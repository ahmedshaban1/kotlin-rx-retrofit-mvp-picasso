package sjob.mivors.com.ahmedmvpdemp.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.transition.Visibility
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import sjob.mivors.com.ahmedmvpdemp.R
import sjob.mivors.com.ahmedmvpdemp.adapters.MyAdapter
import sjob.mivors.com.ahmedmvpdemp.model.Item
import sjob.mivors.com.ahmedmvpdemp.model.Movie

class MainActivity : AppCompatActivity(),MainView {
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
        adapter = MyAdapter(movices)
        list_recyclerView.adapter = adapter
    }


}
