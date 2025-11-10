package com.example.a2566_login

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    private val fragments = listOf(BeritaFragment(), PengumumanFragment())

    override fun getItemCount() = fragments.size
    override fun createFragment(position: Int) = fragments[position]
}
