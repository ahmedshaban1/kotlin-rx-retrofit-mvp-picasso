package com.baculsoft.sample.kotlinmvp.views.next

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.text.method.MovementMethod
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_next.*
import sjob.mivors.com.ahmedmvpdemp.Helper
import sjob.mivors.com.ahmedmvpdemp.base.Presenter
import sjob.mivors.com.ahmedmvpdemp.model.Movie

class NextPresenter(context: Context,item:Movie,transitionName:String) : Presenter<NextView> {


    private var mView: NextView? = null
    var context: Context = context
    var item:Movie = item
    var transitionName:String = transitionName
    override fun onAttach(view: NextView) {
        mView = view
    }

    override fun onDetach() {
        mView = null
    }

    fun BindData(){
        mView?.setLayoutImageTransitionName(transitionName)
        Picasso.with(context).load(Helper.image_url+item.poster_path).into(object : com.squareup.picasso.Target {

            override fun onBitmapLoaded(bitmap: Bitmap, from: Picasso.LoadedFrom) {
                mView?.setLayoutImage(bitmap)
            }

            override fun onBitmapFailed(errorDrawable: Drawable) {
            }
            override fun onPrepareLoad(placeHolderDrawable: Drawable) {
            }
        })

    }


}