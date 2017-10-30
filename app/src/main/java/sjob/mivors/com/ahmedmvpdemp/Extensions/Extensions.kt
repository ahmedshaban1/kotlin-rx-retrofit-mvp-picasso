package sjob.mivors.com.ahmedmvpdemp.Extensions

/**
 * Created by Ahmed shaban on 10/25/2017.
 */
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Ahmed shaban on 10/25/2017.
 */
fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}