package sjob.mivors.com.ahmedmvpdemp.adapters

import android.content.Intent
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recyclerview_item_row.view.*
import sjob.mivors.com.ahmedmvpdemp.Extensions.inflate
import sjob.mivors.com.ahmedmvpdemp.R
import sjob.mivors.com.ahmedmvpdemp.model.Item
import sjob.mivors.com.ahmedmvpdemp.model.Movie

/**
 * Created by Ahmed shaban on 10/25/2017.
 */
class MyAdapter(private val items:ArrayList<Movie>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.bindPhoto(items[position])
    }

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val inflatedView = parent!!.inflate(R.layout.recyclerview_item_row, false)
        return ViewHolder(inflatedView)
    }


    class ViewHolder(v:View):RecyclerView.ViewHolder(v) {
        private var view:View = v
        private var item: Movie? =null

        fun bindPhoto(item: Movie) {
            this.item = item
            Picasso.with(view.context).load("http://image.tmdb.org/t/p/w185//"+item.poster_path).into(view.imageView)
            view.title.text = item?.title
            view.textView3.text = item?.overview


        }
    }

}

