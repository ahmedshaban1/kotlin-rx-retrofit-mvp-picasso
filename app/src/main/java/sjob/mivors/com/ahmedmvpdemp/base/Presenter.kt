package sjob.mivors.com.ahmedmvpdemp.base

/**
 * Created by Ahmed shaban on 10/24/2017.
 */
interface  Presenter<in T:View>{
    fun onAttach(view: T)
    fun onDetach()

}