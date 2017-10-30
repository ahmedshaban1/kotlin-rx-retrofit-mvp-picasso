package sjob.mivors.com.ahmedmvpdemp.main

import android.view.View
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import sjob.mivors.com.ahmedmvpdemp.base.Presenter
import sjob.mivors.com.ahmedmvpdemp.model.Data
import sjob.mivors.com.ahmedmvpdemp.model.Item
import sjob.mivors.com.ahmedmvpdemp.model.Movie
import sjob.mivors.com.ahmedmvpdemp.network.ApiInterface
import java.util.concurrent.TimeUnit

/**
 * Created by Ahmed shaban on 10/24/2017.
 */
class MainPresenter : Presenter<MainView>{
    private var mView: MainView? = null
    var movices = ArrayList<Movie>()

    override fun onAttach(view: MainView) {
        mView = view
    }

    override fun onDetach() {
        mView = null
    }



    fun loadData() {
        mView?.showLoader()
        val apiService = ApiInterface.create()
        apiService.topMove("96c8db6c81c7dcaaad8d73948946723b").subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result ->
                            movices.addAll(result.results)
                            mView?.bindList(movices)
                            mView?.hideLoader()
                        },
                        { error ->
                            print(error.message)
                            mView?.hideLoader()
                        }
                )
    }

}