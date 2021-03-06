package cl.maleb.mercadolibre.challenge

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import cl.maleb.mercadolibre.challenge.databinding.ActivityMainBinding
import cl.maleb.mercadolibre.challenge.ui.search.SearchFragment
import cl.maleb.mercadolibre.challenge.util.KEY_SELECTED_INDEX
import cl.maleb.mercadolibre.challenge.util.TAG_SEARCH_FRAGMENT
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var searchFragment: SearchFragment

    private val fragments: Array<Fragment>
        get() = arrayOf(searchFragment)

    private var selectedIndex = 0

    private val selectedFragment get() = fragments[selectedIndex]

    private fun selectFragment(selectedFragment: Fragment) {
        var transaction = supportFragmentManager.beginTransaction()
        fragments.forEachIndexed { index, fragment ->
            if (selectedFragment == fragment) {
                transaction = transaction.attach(fragment)
                selectedIndex = index
            } else {
                transaction = transaction.detach(fragment)
            }
        }
        transaction.commit()

        title = when (selectedFragment) {
            is SearchFragment -> getString(R.string.title_search_fragment)
            else -> ""
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if (savedInstanceState == null) {
            searchFragment = SearchFragment()

            supportFragmentManager.beginTransaction()
                .add(binding.fragmentContainer.id, searchFragment, TAG_SEARCH_FRAGMENT)
                .commit()
        } else {
            searchFragment =
                supportFragmentManager.findFragmentByTag(TAG_SEARCH_FRAGMENT) as SearchFragment

            selectedIndex = savedInstanceState.getInt(KEY_SELECTED_INDEX, 0)
        }

        selectFragment(selectedFragment)

        binding.bottomNavBar.setOnNavigationItemSelectedListener { item ->
            val fragment = when (item.itemId) {
                R.id.nav_search -> searchFragment
                else -> throw IllegalArgumentException("Unexpected itemId")
            }

            selectFragment(fragment)

            true
        }

    }

    override fun onBackPressed() {
        if (selectedIndex != 0) {
            binding.bottomNavBar.selectedItemId = R.id.nav_search
        } else {
            super.onBackPressed()
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putInt(KEY_SELECTED_INDEX, selectedIndex)
    }
}