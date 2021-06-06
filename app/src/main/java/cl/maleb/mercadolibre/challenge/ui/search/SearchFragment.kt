package cl.maleb.mercadolibre.challenge.ui.search

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
import cl.maleb.mercadolibre.challenge.shared.ResultListAdapter
import cl.maleb.mercadolibre.challenge.util.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.fragment_search), ResultListAdapter.OnItemClickListener {

    private val viewModel: SearchViewModel by viewModels()

    private lateinit var searchView: SearchView

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
        setHasOptionsMenu(true)

        val resultAdapter = ResultListAdapter(this)

        binding.apply {
            recyclerView.apply {
                adapter = resultAdapter
                layoutManager = LinearLayoutManager(context)
            }

            viewModel.results.observe(viewLifecycleOwner, { result ->
                when (result) {
                    is Resource.Error -> {
                        textViewError.visible()
                        textViewError.isVisible = result.data.isNullOrEmpty()
                        textViewError.text = result.error?.localizedMessage
                    }
                    is Resource.Loading -> {
                    }
                    is Resource.Success -> {
                        requireActivity().hideSoftKeyboard()
                        if (result.data!!.isNotEmpty()) {
                            resultAdapter.submitList(result.data)
                            textViewInstructions.gone()
                        } else {
                            view.snack(message = getString(R.string.no_results_found)) { }
                        }
                    }
                }

            })

            viewLifecycleOwner.lifecycleScope.launchWhenCreated {
                viewModel.searchEvent.collect { event ->
                    when (event) {
                        is SearchEvent.NavigateToDetailScreen -> {
//                            var transaction = parentFragmentManager.beginTransaction()
//                            transaction = transaction.attach()
                        }
                    }
                }
            }

        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_search_fragment, menu)

        val searchItem = menu.findItem(R.id.action_search)
        searchView = searchItem.actionView as SearchView

        // Just to restore searchView when phone is rotated
        val pendingQuery = viewModel.searchQuery.value
        if (pendingQuery != null && pendingQuery.isNotEmpty()) {
            searchItem.expandActionView()
            searchView.setQuery(pendingQuery, false)
        }

        searchView.onQueryTextSubmit {
            // update search query
            viewModel.searchQuery.value = it
        }

    }

    override fun onItemClick(resultData: MLResultData) {
        viewModel.onResultSelected(resultData)
    }
}