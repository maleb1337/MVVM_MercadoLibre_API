package cl.maleb.mercadolibre.challenge.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import cl.maleb.mercadolibre.challenge.R
import cl.maleb.mercadolibre.challenge.databinding.FragmentSearchBinding
import cl.maleb.mercadolibre.challenge.shared.ResultListAdapter
import cl.maleb.mercadolibre.challenge.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.fragment_search) {

    private val viewModel: SearchViewModel by viewModels()

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
        val resultAdapter = ResultListAdapter()

        binding.apply {
            recyclerView.apply {
                adapter = resultAdapter
                layoutManager = LinearLayoutManager(context)
            }

            viewModel.results.observe(viewLifecycleOwner, { result ->
                resultAdapter.submitList(result.data)

                textViewError.isVisible = result is Resource.Error && result.data.isNullOrEmpty()
                textViewError.text = result.error?.localizedMessage
                textViewNoResults.isVisible = result.data.isNullOrEmpty()

                val isNotEmpty = result.data!!.isNotEmpty()
                textViewInstructions.isVisible = !isNotEmpty


            })
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}