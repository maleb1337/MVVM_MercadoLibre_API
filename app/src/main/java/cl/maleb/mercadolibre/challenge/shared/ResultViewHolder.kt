package cl.maleb.mercadolibre.challenge.shared

import androidx.recyclerview.widget.RecyclerView
import cl.maleb.mercadolibre.challenge.api.list.MLResultData
import cl.maleb.mercadolibre.challenge.databinding.ItemResultListBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority

class ResultViewHolder(
    private val binding: ItemResultListBinding,
    private val listener: ResultListAdapter.OnItemClickListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(result: MLResultData) {
        binding.apply {
            Glide.with(itemView)
                .load(result.thumbnail)
                .priority(Priority.HIGH)
                .into(imageView)

            textViewTitle.text = result.title ?: ""

            root.setOnClickListener {
                listener.onItemClick(result)
            }
        }
    }
}