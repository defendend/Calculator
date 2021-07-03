package com.defendend.calculator

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity){

    private val piFragment = PiFragment()
    private val eFragment = EFragment()

    override fun getItemCount(): Int = PAGE_COUNT

    override fun createFragment(position: Int): Fragment {
        return if(position == 0) {
            piFragment
        } else {
            eFragment
        }
    }

    companion object {
        private const val PAGE_COUNT = 2
    }
}