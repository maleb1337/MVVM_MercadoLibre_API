package cl.maleb.mercadolibre.challenge.ui.search

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import cl.maleb.mercadolibre.challenge.R
import cl.maleb.mercadolibre.challenge.api.list.MLResultData
import cl.maleb.mercadolibre.challenge.databinding.FragmentSearchBinding
import cl.maleb.mercadolibre.challenge.shared.result.ResultListAdapter
import cl.maleb.mercadolibre.challenge.ui.detail.DetailActivity
import cl.maleb.mercadolibre.challenge.util.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.fragment_search), ResultListAdapter.OnItemClickListener {

    private val viewModel: SearchViewModel by viewModels()

    private lateinit var searchView: SearchView
    private lateinit var resultAdapter: ResultListAdapter

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpView()
        initObservers()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initObservers() {
        viewModel.resultListLiveData.observe(viewLifecycleOwner, { result ->
            when (result) {
                is Resource.Error -> {
                    showErrorView(result.data, result.error)
                }
                is Resource.Loading -> {
                    showLoadingView()
                }
                is Resource.Success -> {
                    showSuccessView(result.data)
                }
            }

        })

        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.searchEvent.collect { event ->
                when (event) {
                    is SearchEvent.NavigateToDetailScreen -> {
                        activity?.hideSoftKeyboard()
                        searchView.clearFocus()

                        activity?.let {
                            val intent = Intent(activity, DetailActivity::class.java)
                            intent.putExtra(ARG_NAME_IDENTIFIER, event.resultData.id)
                            it.startActivity(intent)
                        }
                    }
                }
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_search_fragment, menu)

        val searchItem = menu.findItem(R.id.action_search)
        searchView = searchItem.actionView as SearchView

        searchView.onQueryTextSubmit { query ->
            // update search query
            if (query.isNotEmpty()) {
                viewModel.getListBySearch(query)
                viewModel.lastSearchQuery = query
            }
        }

    }

    override fun onItemClick(resultData: MLResultData) {
        viewModel.onResultSelected(resultData)
    }

    private fun showLoadingView() {
        binding.apply {
            if (swipeRefreshLayout.isRefreshing) {
                textViewInstructions.gone()
            } else {
                textViewInstructions.gone()
                progressBar.visible()
            }
        }
    }

    private fun showErrorView(data: List<MLResultData>?, error: Throwable?) {
        binding.apply {
            progressBar.gone()
            textViewError.apply {
                isVisible = data.isNullOrEmpty()
                text = error?.localizedMessage
            }
        }
    }

    private fun showSuccessView(data: List<MLResultData>?) {
        binding.apply {
            progressBar.gone()
            requireActivity().hideSoftKeyboard()
            swipeRefreshLayout.isRefreshing = false
            searchView.clearFocus()

            if (data!!.isNotEmpty()) {
                resultAdapter.submitList(data)
            } else {
                textViewInstructions.visible()
                view?.snack(message = getString(R.string.no_results_found)) { }
            }
        }
    }

    private fun setUpView() {
        setHasOptionsMenu(true)
        resultAdapter = ResultListAdapter(this)

        binding.apply {
            recyclerView.apply {
                adapter = resultAdapter
                layoutManager = LinearLayoutManager(context)
            }

            swipeRefreshLayout.setOnRefreshListener {
                viewModel.getListBySearch(viewModel.lastSearchQuery.orEmpty())
            }
        }
    }


}