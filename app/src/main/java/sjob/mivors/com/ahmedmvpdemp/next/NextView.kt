package com.baculsoft.sample.kotlinmvp.views.next

import android.graphics.Bitmap
import sjob.mivors.com.ahmedmvpdemp.base.View


interface NextView : View {

     fun setLayoutImageTransitionName(name:String)
     fun setLayoutImage(bitmap: Bitmap)

}