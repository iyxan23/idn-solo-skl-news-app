package com.iyxan.newz.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.iyxan.newz.ui.AboutAlQuranFragment
import com.iyxan.newz.ui.AlJazeeraFragment
import com.iyxan.newz.ui.CommonFragment
import com.iyxan.newz.ui.WarningFragment

class SectionPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount() = 4

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> CommonFragment()
            1 -> AboutAlQuranFragment()
            2 -> AlJazeeraFragment()
            3 -> WarningFragment()

            else -> CommonFragment()
        }
    }
}