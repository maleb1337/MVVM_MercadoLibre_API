package cl.maleb.mercadolibre.challenge.ui.detail

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import cl.maleb.mercadolibre.challenge.R
import cl.maleb.mercadolibre.challenge.databinding.ActivityDetailBinding
import cl.maleb.mercadolibre.challenge.shared.image.ImageListAdapter
import cl.maleb.mercadolibre.challenge.util.ARG_NAME_IDENTIFIER
import cl.maleb.mercadolibre.challenge.util.Resource
import cl.maleb.mercadolibre.challenge.util.gone
import cl.maleb.mercadolibre.challenge.util.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private val viewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val identifier: String = intent.getStringExtra(ARG_NAME_IDENTIFIER).toString()
        val imageListAdapter = ImageListAdapter()

        viewModel.getDetailData(identifier)

        binding.apply {
            viewModel.detailLiveData.observe(this@DetailActivity, { result ->
                when (result) {
                    is Resource.Error -> {
                        progressBar.gone()
                        textViewError.apply {
                            visible()
                            text = result.error?.localizedMessage
                        }
                    }
                    is Resource.Loading -> {
                        progressBar.visible()
                    }
                    is Resource.Success -> {
                        progressBar.gone()
                        // set adapter
                        imageRecyclerView.apply {
                            adapter = imageListAdapter
                            layoutManager = LinearLayoutManager(
                                this@DetailActivity,
                                LinearLayoutManager.HORIZONTAL,
                                false
                            )
                        }
                        // set data to controls
                        result.data?.apply {
                            imageListAdapter.submitList(pictures)

                            textViewCondition.text =
                                viewModel.getConditionValue(condition.orEmpty())
                            textViewTitle.text = title
                            textViewPrice.text = getString(R.string.price_formatted, priceFormatted)
                        }


                    }
                }
            })
        }

    }

}