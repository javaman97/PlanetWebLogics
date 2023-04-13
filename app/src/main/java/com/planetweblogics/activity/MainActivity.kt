package com.planetweblogics.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.planetweblogics.*
import com.planetweblogics.databinding.ActivityMainBinding
import com.planetweblogics.fragment.ContactFragment
import com.planetweblogics.fragment.HomeFragment
import com.planetweblogics.fragment.PortfolioFragment
import com.planetweblogics.fragment.PricingFragment
import com.planetweblogics.internet.NoInternet
import com.planetweblogics.internet.NoInternetFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding:ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        val networkConnection= NoInternet(applicationContext)
        networkConnection.observe(this) {
            if(it){
                replaceFragment(HomeFragment())
                binding.bottomNavigation.visibility= View.VISIBLE
            } else{
                replaceFragment(NoInternetFragment())
                binding.bottomNavigation.visibility= View.INVISIBLE
                Toast.makeText(this," No Connection",Toast.LENGTH_LONG).show()
            }
        }
        binding.bottomNavigation.setOnItemSelectedListener{
            when(it.itemId){
                R.id.home -> replaceFragment(HomeFragment())
                R.id.pricing -> replaceFragment(PricingFragment())
                R.id.portfolio -> replaceFragment(PortfolioFragment())
                R.id.contact -> replaceFragment(ContactFragment())
             else -> {

             }
            }
            true
        }
    }
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager=supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}