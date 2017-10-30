package com.baculsoft.sample.kotlinmvp.views.next

import sjob.mivors.com.ahmedmvpdemp.base.Presenter

class NextPresenter : Presenter<NextView> {
    private var mView: NextView? = null

    override fun onAttach(view: NextView) {
        mView = view
    }

    override fun onDetach() {
        mView = null
    }

    fun showText(text: String) {
        mView?.onShowResult(text)
    }
}