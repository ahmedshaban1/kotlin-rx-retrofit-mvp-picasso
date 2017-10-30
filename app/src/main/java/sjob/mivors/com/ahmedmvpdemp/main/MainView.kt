package sjob.mivors.com.ahmedmvpdemp.main

import sjob.mivors.com.ahmedmvpdemp.base.View
import sjob.mivors.com.ahmedmvpdemp.model.Data
import sjob.mivors.com.ahmedmvpdemp.model.Item
import sjob.mivors.com.ahmedmvpdemp.model.Movie

/**
 * Created by Ahmed shaban on 10/24/2017.
 */
interface MainView : View {

    fun  bindList(movices: ArrayList<Movie>)
}