package sjob.mivors.com.ahmedmvpdemp.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_next.*
import kotlinx.android.synthetic.main.recyclerview_item_row.*
import kotlinx.android.synthetic.main.recyclerview_item_row.view.*
import sjob.mivors.com.ahmedmvpdemp.Extensions.toast
import sjob.mivors.com.ahmedmvpdemp.R
import sjob.mivors.com.ahmedmvpdemp.model.Movie
import android.graphics.drawable.Drawable
import android.graphics.drawable.BitmapDrawable
import android.graphics.Bitmap
import android.widget.TextView
import sjob.mivors.com.ahmedmvpdemp.R.id.imageView
import android.support.v4.view.ViewCompat.setTransitionName
import android.os.Build







class next : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)
        setSupportActionBar(toolbar)

        var item:Movie =  intent.getParcelableExtra("item")
        var imageTransitionName = intent.getStringExtra("shareImageView")
       // Picasso.with(this).load().into(imageView1)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar_layout.transitionName = imageTransitionName
        }


        Picasso.with(this).load("http://image.tmdb.org/t/p/w185//"+item.poster_path).into(object : com.squareup.picasso.Target {

            override fun onBitmapLoaded(bitmap: Bitmap, from: Picasso.LoadedFrom) {
                toolbar_layout.background = BitmapDrawable(resources, bitmap)
            }

            override fun onBitmapFailed(errorDrawable: Drawable) {
                //Log.d("TAG", "FAILED");
            }

            override fun onPrepareLoad(placeHolderDrawable: Drawable) {
                //Log.d("TAG", "Prepare Load");
            }
        })
    }
}
