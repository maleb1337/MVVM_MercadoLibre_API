package cl.maleb.mercadolibre.challenge.shared

import androidx.recyclerview.widget.DiffUtil
import cl.maleb.mercadolibre.challenge.api.list.MLResultData

class ResultItemComparator : DiffUtil.ItemCallback<MLResultData>() {
    override fun areItemsTheSame(oldItem: MLResultData, newItem: MLResultData) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: MLResultData, newItem: MLResultData) =
        oldItem == newItem
}