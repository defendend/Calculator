package com.defendend.calculator


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class ActivityTwo : AppCompatActivity() {

    private val workPager: ViewPager2 by lazy { findViewById(R.id.pager) }
    private val tabLayout: TabLayout by lazy { findViewById(R.id.tab_layout) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.two_activity)
        workPager.adapter = WorkDetailsAdapter(this)
        workPager.currentItem = TASK_PAGE
        val tabLayoutMediator = TabLayoutMediator(tabLayout, workPager) { tab, position ->
            val title = when (position) {
                TASK_PAGE -> "Число ПИ"
                SECOND_PAGE -> "Число Е"
                else -> ""
            }
            tab.text = title

        }
        tabLayoutMediator.attach()
    }

    companion object {
        private const val TASK_PAGE = 0
        private const val SECOND_PAGE = 1
    }
}