package com.example.computec.eltadreb.utils

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.View
import alif.hamza.moquette.R

object ActivityUtils {

    fun addFragmentToActivity(fragmentManager: FragmentManager,
                              fragment: Fragment, isSaved: Boolean = false) {
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        if (isSaved) transaction.addToBackStack(null)
        transaction.commit()
    }

    fun addFragmentToActivity(fragmentManager: android.app.FragmentManager?
                              , fragment: android.app.Fragment, isSaved: Boolean = false
                              , view: View? = null, transactionName: String? = null) {
        val transaction = fragmentManager?.beginTransaction()
        transaction?.replace(R.id.container, fragment)
//        view?.let {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                transaction?.addSharedElement(view, transactionName!!)
//            }
//        }
        if (isSaved) transaction?.addToBackStack(null)
        transaction?.commit()
    }
}