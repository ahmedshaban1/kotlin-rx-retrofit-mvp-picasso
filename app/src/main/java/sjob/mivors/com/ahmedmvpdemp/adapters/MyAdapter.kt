package sjob.mivors.com.ahmedmvpdemp.adapters

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recyclerview_item_row.view.*
import sjob.mivors.com.ahmedmvpdemp.Extensions.inflate
import sjob.mivors.com.ahmedmvpdemp.R
import sjob.mivors.com.ahmedmvpdemp.main.next
import sjob.mivors.com.ahmedmvpdemp.model.Movie
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.app.AppCompatActivity
import sjob.mivors.com.ahmedmvpdemp.callbacks.MovieItemClickListener
import sjob.mivors.com.ahmedmvpdemp.main.MainActivity
import android.R.attr.name
import android.support.v4.view.ViewCompat
import sjob.mivors.com.ahmedmvpdemp.Helper


/**
 * Created by Ahmed shaban on 10/25/2017.
 */
class MyAdapter(private val items:ArrayList<Movie>, private val itemClick: MovieItemClickListener) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.bindItem(items[position])

        ViewCompat.setTransitionName(holder.itemView.imageView, items[position].title)
        holder.itemView.setOnClickListener { itemClick.onItemClick(holder.adapterPosition,  items[position], holder.itemView.imageView) }
    }

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val inflatedView = parent!!.inflate(R.layout.recyclerview_item_row, false)
        return ViewHolder(inflatedView)
    }


    class ViewHolder(v:View):RecyclerView.ViewHolder(v)  {
        private var view:View = v


        fun bindItem(item: Movie) {
            Picasso.with(view.context).load(Helper.image_url+item.poster_path).into(view.imageView)
            view.title.text = item.title
            view.textView3.text = item.overview
        }

    }

}

