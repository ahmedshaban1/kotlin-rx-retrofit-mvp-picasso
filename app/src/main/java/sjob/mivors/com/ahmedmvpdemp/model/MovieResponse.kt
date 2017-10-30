package sjob.mivors.com.ahmedmvpdemp.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Ahmed shaban on 10/29/2017.
 */
data class MovieResponse (var page:Int,
                          var total_results:Int,
                          var total_pages:Int,
                          var results:List<Movie>)