package com.iyxan.newz

import android.app.SearchManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.MutableLiveData
import com.google.android.material.tabs.TabLayoutMediator
import com.iyxan.newz.adapter.SectionPagerAdapter
import com.iyxan.newz.databinding.ActivityMainBinding
import com.iyxan.newz.utils.DelayedDispatcher

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val newsViewModel: NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)

        setSupportActionBar(binding.toolbar)
        setContentView(binding.root)

        setupViewPager()
    }

    private fun setupViewPager() {
        binding.vpNews.adapter = SectionPagerAdapter(this)

        val tablist = arrayOf(
            "Common",
            "About Al Quran",
            "Al Jazeera",
            "Warning for Muslims"
        )

        TabLayoutMediator(binding.tabs, binding.vpNews) { tab, position ->
            tab.text = tablist[position]
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager

        (menu.findItem(R.id.option_search)?.actionView as SearchView).apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))

            setOnQueryTextFocusChangeListener { _, hasFocus ->
                if (hasFocus) {
                    binding.toolbar.setLogo(R.drawable.ic_launcher_foreground)
                } else {
                    binding.toolbar.setLogo(R.drawable.newz_toolbar)
                }
            }

//            val bundleKey = "query"
//            val searchDispatcher = DelayedDispatcher({ bundle ->
//                newsViewModel.performSearch(bundle.getString(bundleKey)!!)
//            }, 1500L, this@MainActivity.lifecycle)
//
//            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//                override fun onQueryTextSubmit(query: String?): Boolean {
//                    searchDispatcher.dispatchNow(Bundle().apply { putString(bundleKey, query) })
//                    return true
//                }
//
//                override fun onQueryTextChange(newText: String?): Boolean {
//                    searchDispatcher.tryDispatch(Bundle().apply { putString(bundleKey, newText) })
//                    return true
//                }
//            })
        }

        return true
    }
}