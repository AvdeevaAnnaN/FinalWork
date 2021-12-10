package com.avd.example.finalwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val LAST_SELECTED_ITEM = "item"

private val GALLERY_FRAGMENT = GalleryFragment().javaClass.name
private val FLOWERS_FRAGMENT = FavoritePicturesFragment().javaClass.name

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener { item ->
            var fragment: Fragment? = null
            when (item.itemId) {
                R.id.gallery_of_flowers -> {
                    fragment = if (savedInstanceState != null) supportFragmentManager.getFragment(
                        savedInstanceState,
                        GALLERY_FRAGMENT
                    ) else GalleryFragment()
                }
                R.id.favorite_list -> {
                    fragment = if (savedInstanceState != null) supportFragmentManager.getFragment(
                        savedInstanceState,
                        FLOWERS_FRAGMENT
                    ) else FavoritePicturesFragment()
                }
            }
            replaceFragment(fragment!!)
            true

        }
        bottomNavigationView.selectedItemId =
            savedInstanceState?.getInt(LAST_SELECTED_ITEM) ?: R.id.gallery_of_flowers


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_SELECTED_ITEM, bottomNavigationView.selectedItemId)

        val currentFragment = supportFragmentManager.fragments.last()
        supportFragmentManager.putFragment(
            outState,
            currentFragment.javaClass.name,
            currentFragment
        )
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(fragment.tag)
            .commit()
    }
}