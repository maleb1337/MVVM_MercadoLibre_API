package cl.maleb.mercadolibre.challenge.shared.image

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import cl.maleb.mercadolibre.challenge.api.detail.Picture
import cl.maleb.mercadolibre.challenge.databinding.ItemImageDetailBinding
import com.bumptech.glide.Glide

class ImageListAdapter : ListAdapter<Picture, ImageListAdapter.ImageViewHolder>(ImageComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding =
            ItemImageDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    class ImageViewHolder(private val binding: ItemImageDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(picture: Picture) {
            binding.apply {
                Glide.with(imageView)
                    .load(picture.secure_url)
                    .into(imageView)
            }
        }
    }

    class ImageComparator : DiffUtil.ItemCallback<Picture>() {
        override fun areItemsTheSame(oldItem: Picture, newItem: Picture) =
            oldItem.secure_url == newItem.secure_url

        override fun areContentsTheSame(oldItem: Picture, newItem: Picture) =
            oldItem == newItem


    }

}

