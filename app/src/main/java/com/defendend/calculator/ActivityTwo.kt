package com.defendend.calculator


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class ActivityTwo : AppCompatActivity() {

    private val viewPager: ViewPager2 by lazy { findViewById(R.id.pager) }
    private val tabLayout: TabLayout by lazy { findViewById(R.id.tab_layout) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.two_activity)
        viewPager.adapter = FragmentAdapter(this)
        viewPager.currentItem = PI_PAGE
        val tabLayoutMediator = TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            val title = when (position) {
                PI_PAGE -> getString(R.string.pi)
                E_PAGE -> getString(R.string.e)
                else -> ""
            }
            tab.text = title

        }
        tabLayoutMediator.attach()
    }

    companion object {
        private const val PI_PAGE = 0
        private const val E_PAGE = 1
    }
}