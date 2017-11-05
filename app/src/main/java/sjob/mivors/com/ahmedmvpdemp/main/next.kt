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
import android.view.MenuItem
import com.baculsoft.sample.kotlinmvp.views.next.NextPresenter
import com.baculsoft.sample.kotlinmvp.views.next.NextView
import sjob.mivors.com.ahmedmvpdemp.Helper


class next : AppCompatActivity(),NextView {


    lateinit var presenter: NextPresenter
    override fun onAttache() {
        var item:Movie  =  intent.getParcelableExtra(Helper.item)
        var imageTransitionName = intent.getStringExtra(Helper.shareImageView)
        presenter  = NextPresenter(this,item,imageTransitionName)
        presenter.onAttach(this)

    }

    override fun onDetach() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoader() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoader() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setLayoutImageTransitionName(imageTransitionName:String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar_layout.transitionName = imageTransitionName
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        onAttache()
        presenter.BindData();

    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item!!.itemId == android.R.id.home ){
           onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun setLayoutImage(bitmap: Bitmap) {
        toolbar_layout.background = BitmapDrawable(resources, bitmap)
    }
}
