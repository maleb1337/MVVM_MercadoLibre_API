package cl.maleb.mercadolibre.challenge.ui.detail

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import cl.maleb.mercadolibre.challenge.databinding.ActivityDetailBinding
import cl.maleb.mercadolibre.challenge.util.ARG_NAME_IDENTIFIER
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private val viewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val identifier: String = intent.getStringExtra(ARG_NAME_IDENTIFIER).toString()

        viewModel.getDetailData(identifier)

        binding.apply {
            viewModel.detailLiveData.observe(this@DetailActivity, { result ->
                textViewError.text = result.data?.title
//                progressBar.isVisible = result is Resource.Loading && result.data.isNullOrEmpty()
//                textViewError.isVisible = result is Resource.Error && result.data.isNullOrEmpty()
//                textViewError.text = result.error?.localizedMessage
            })
        }

    }

}