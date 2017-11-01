package sjob.mivors.com.ahmedmvpdemp.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.widget.LinearLayoutManager
import android.transition.Visibility
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.recyclerview_item_row.*
import sjob.mivors.com.ahmedmvpdemp.Extensions.toast
import sjob.mivors.com.ahmedmvpdemp.R
import sjob.mivors.com.ahmedmvpdemp.adapters.MyAdapter
import sjob.mivors.com.ahmedmvpdemp.callbacks.MovieItemClickListener
import sjob.mivors.com.ahmedmvpdemp.model.Item
import sjob.mivors.com.ahmedmvpdemp.model.Movie
import android.support.v4.view.ViewCompat



class MainActivity : AppCompatActivity(),MainView,MovieItemClickListener {




    override fun showLoader() {
        loader.visibility = View.VISIBLE
    }

    override fun hideLoader() {
        loader.visibility = View.GONE
    }


    lateinit var presenter: MainPresenter
    lateinit var adapter:MyAdapter
    lateinit var layoutManager:LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter  = MainPresenter()
        onAttache()
    }



    override fun onAttache() {
        presenter.onAttach(this)
        layoutManager  = LinearLayoutManager(this)
        list_recyclerView.layoutManager = layoutManager
        presenter.loadData()



    }

    override fun onDetach() {
    }



    override fun bindList(movices: ArrayList<Movie>) {
        adapter = MyAdapter(movices,this)
        list_recyclerView.adapter = adapter
    }


    override fun onItemClick(pos: Int, item: Movie, shareImageView: ImageView) {

        val intent = Intent(this, next::class.java)
        var bundle:Bundle = Bundle()
        bundle.putParcelable("item",item)
        bundle.putString("shareImageView", ViewCompat.getTransitionName(shareImageView))
        intent.putExtras(bundle)
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this,
                shareImageView,
                ViewCompat.getTransitionName(shareImageView))

        startActivity(intent, options.toBundle())
    }


}
