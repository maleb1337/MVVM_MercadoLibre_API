package cl.maleb.mercadolibre.challenge.shared

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import cl.maleb.mercadolibre.challenge.api.list.MLResultData
import cl.maleb.mercadolibre.challenge.databinding.ItemResultListBinding

class ResultListAdapter(private val listener: OnItemClickListener) :
    ListAdapter<MLResultData, ResultViewHolder>(ResultItemComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val binding =
            ItemResultListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ResultViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    interface OnItemClickListener {
        fun onItemClick(resultData: MLResultData)
    }


}