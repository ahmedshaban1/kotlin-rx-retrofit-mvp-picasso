package sjob.mivors.com.ahmedmvpdemp.callbacks

import android.widget.ImageView
import sjob.mivors.com.ahmedmvpdemp.model.Movie

/**
 * Created by Ahmed shaban on 11/1/2017.
 */
interface MovieItemClickListener {
    fun onItemClick(pos: Int, item: Movie, shareImageView: ImageView)
}