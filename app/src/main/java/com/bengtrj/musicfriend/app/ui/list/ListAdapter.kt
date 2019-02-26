package com.bengtrj.musicfriend.app.ui.list

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bengtrj.musicfriend.app.R
import com.bengtrj.musicfriend.app.models.Album
import com.bengtrj.musicfriend.app.models.AlbumsQueryResult
import com.squareup.picasso.Picasso

class ListAdapter(private val context: Context, private val list: MutableList<Album>,
                  fragment: androidx.fragment.app.Fragment) : androidx.recyclerview.widget.RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    private val listener: ListAdapter.OnItemClickListener

    init {
        this.listener = fragment as ListAdapter.OnItemClickListener
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView = LayoutInflater.from(context)
                .inflate(R.layout.album_item_layout, parent, false)

        return ListAdapter.ListViewHolder(itemView, listener)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    class ListViewHolder(itemView: View, private val listener: ListAdapter.OnItemClickListener)
        : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        private val layout = itemView.findViewById(R.id.album_item_layout) as View
        private val title = itemView.findViewById(R.id.album_artist_name) as TextView
        private val body = itemView.findViewById(R.id.album_name) as TextView
        private val album = itemView.findViewById(R.id.album_image) as ImageView

        fun onBind(album: Album) {
            title.text = album.artistName
            body.text = album.name
            Picasso.with(itemView.context)
                    .load(album.artworkUrl)
                    .resizeDimen(R.dimen.list_image_size, R.dimen.list_image_size)
                    .centerCrop()
                    .into(this.album)
            layout.setOnClickListener {
                listener.itemDetail(album.id.toString())
            }
        }
    }

    interface OnItemClickListener {
        fun itemRemoveClick(post: AlbumsQueryResult)
        fun itemDetail(postId: String)
    }
}