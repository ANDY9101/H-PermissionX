package com.permission.zhr
import androidx.fragment.app.FragmentActivity

object PermissionX {
    const val TAG = "InvisibleFragment"

    fun request(activity: FragmentActivity, vararg permission: String, callback: PermissionCallback){
        val fragmentManager = activity.supportFragmentManager
        val existedFragment = fragmentManager.findFragmentByTag(TAG)
        val fragment = if(existedFragment != null){
            existedFragment as InvisibleFragment
        }else{
            val invisibleFragment = InvisibleFragment()
            fragmentManager.beginTransaction().add(invisibleFragment, TAG).commitNow()
            invisibleFragment
        }
        fragment.requestNow(callback, *permission)
    }
}