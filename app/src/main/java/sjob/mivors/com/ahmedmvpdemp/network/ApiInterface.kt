package sjob.mivors.com.ahmedmvpdemp.network

import android.database.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import sjob.mivors.com.ahmedmvpdemp.model.MovieResponse
import java.util.*


/**
 * Created by Ahmed shaban on 10/29/2017.
 */
interface ApiInterface{
    @GET("top_rated")
    fun topMove(@Query("api_key") artist: String): io.reactivex.Observable<MovieResponse>

    companion  object Factory {

        fun create(): ApiInterface {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("http://api.themoviedb.org/3/movie/")
                    .build()

            return retrofit.create<ApiInterface>(ApiInterface::class.java!!)
        }
    }

}