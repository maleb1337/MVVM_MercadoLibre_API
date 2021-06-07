package cl.maleb.mercadolibre.challenge.shared.attributes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import cl.maleb.mercadolibre.challenge.api.detail.AttributeDetail
import cl.maleb.mercadolibre.challenge.databinding.ItemAttributeDetailBinding

class AttributesListAdapter :
    ListAdapter<AttributeDetail, AttributesListAdapter.AttributesViewHolder>(AttributesComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttributesViewHolder {
        val binding =
            ItemAttributeDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AttributesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AttributesViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    class AttributesViewHolder(private val binding: ItemAttributeDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(attributeDetail: AttributeDetail) {
            binding.apply {
                textViewTitle.text = attributeDetail.name
                textViewDescription.text = attributeDetail.value_name
            }
        }
    }

    class AttributesComparator : DiffUtil.ItemCallback<AttributeDetail>() {
        override fun areItemsTheSame(oldItem: AttributeDetail, newItem: AttributeDetail) =
            oldItem.name == newItem.name

        override fun areContentsTheSame(
            oldItem: AttributeDetail,
            newItem: AttributeDetail
        ) = oldItem == newItem

    }

}