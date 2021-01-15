package cl.serlitoral.desafiokotlinapi2.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.serlitoral.desafiokotlinapi2.data.Photo
import cl.serlitoral.desafiokotlinapi2.databinding.PhotoItemBinding
import coil.load

class PhotoAdapter: RecyclerView.Adapter<PhotoVH>() {

    private var items = listOf<Photo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoVH {
        val binding = PhotoItemBinding.inflate(LayoutInflater.from(parent.context))
        return  PhotoVH(binding)
    }

    override fun onBindViewHolder(holder: PhotoVH, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun update(list: List<Photo>) {
        items = list
        notifyDataSetChanged()
    }
}

class PhotoVH(val binding: PhotoItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Photo) {
        binding.imgPhoto.load(item.url)
        binding.tvTitle.text = item.title
    }
}