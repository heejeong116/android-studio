package com.example.review3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.example.review3.databinding.ActivityTabPagerBinding
import com.google.android.material.tabs.TabLayout

class TabPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityTabPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("1")) //탭 새롭게 생성하기
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("2"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("3"))

        val adapter = ThreePageAdapter(LayoutInflater.from(this@TabPagerActivity))
        binding.viewPager.adapter=adapter
        binding.viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout))
        binding.tabLayout.addOnTabSelectedListener(object:TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.viewPager.currentItem=tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })


    }
}

class ThreePageAdapter(val layoutInflater: LayoutInflater):PagerAdapter(){
    override fun getCount(): Int {
        return 3
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view=== `object` as View
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        when (position){
            0->{
                val view= layoutInflater.inflate(R.layout.fragment1,container,false)
                container.addView(view)
                return view
            }
            1->{
                val view= layoutInflater.inflate(R.layout.fragment2,container,false)
                container.addView(view)
                return view
            }
            2->{
                val view= layoutInflater.inflate(R.layout.fragment3,container,false)
                container.addView(view)
                return view
            }
            else->{
                val view= layoutInflater.inflate(R.layout.fragment1,container,false)
                container.addView(view)
                return view
            }
        }
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}