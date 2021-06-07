package cl.maleb.mercadolibre.challenge.ui.detail

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import cl.maleb.mercadolibre.challenge.R
import cl.maleb.mercadolibre.challenge.api.detail.Body
import cl.maleb.mercadolibre.challenge.databinding.ActivityDetailBinding
import cl.maleb.mercadolibre.challenge.shared.attributes.AttributesListAdapter
import cl.maleb.mercadolibre.challenge.shared.image.ImageListAdapter
import cl.maleb.mercadolibre.challenge.util.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private val viewModel: DetailViewModel by viewModels()

    private lateinit var identifier: String
    private lateinit var imageListAdapter: ImageListAdapter
    private lateinit var attributesListAdapter: AttributesListAdapter
    private var binding: ActivityDetailBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setUpView()
        initObservers()
    }

    private fun initObservers() {
        viewModel.detailLiveData.observe(this@DetailActivity, { result ->
            when (result) {
                is Resource.Error -> {
                    showErrorView(result.error)
                }
                is Resource.Loading -> {
                    showLoadingView()
                }
                is Resource.Success -> {
                    showSuccessView(result.data)
                }
            }
        })
    }

    private fun showLoadingView() {
        binding?.progressBar?.visible()
    }

    private fun showErrorView(error: Throwable?) {
        binding?.apply {
            progressBar.gone()
            textViewError.apply {
                visible()
                text = error?.localizedMessage
            }
        }
    }

    private fun showSuccessView(data: Body?) {
        binding?.apply {
            progressBar.gone()
            // set data to controls
            data?.apply {
                imageListAdapter.submitList(pictures)
                attributesListAdapter.submitList(attributes)

                textViewCondition.text =
                    viewModel.getConditionValue(condition.orEmpty())
                textViewTitle.text = title
                textViewPrice.text =
                    getString(R.string.price_formatted, priceFormatted, currency_id)
            }
        }
    }

    private fun setUpView() {
        identifier = intent.getStringExtra(ARG_NAME_IDENTIFIER).toString()
        imageListAdapter = ImageListAdapter()
        attributesListAdapter = AttributesListAdapter()

        supportActionBar?.title = getString(R.string.detail_activity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding?.apply {
            // set adapters
            imageRecyclerView.apply {
                adapter = imageListAdapter
                layoutManager = LinearLayoutManager(
                    this@DetailActivity,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
            }
            attributesRecyclerView.apply {
                adapter = attributesListAdapter
                layoutManager = LinearLayoutManager(this@DetailActivity)
            }
        }

        viewModel.getDetailData(identifier)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}