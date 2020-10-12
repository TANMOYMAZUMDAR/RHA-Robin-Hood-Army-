package com.example.rha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TableLayout
import androidx.viewpager.widget.ViewPager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout


lateinit var tablayout:TableLayout
lateinit var viewpager:ViewPager
lateinit var floatingActionButtongoogle: FloatingActionButton
lateinit var floatingActionButtonfab: FloatingActionButton
class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val spinner:Spinner?=findViewById(R.id.Roles)
        val madapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,resources.getStringArray(R.array.roles))
        madapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        if (spinner != null) {
            spinner.adapter=madapter
        }

        val tablayout=findViewById<TabLayout>(R.id.tabLayout)
        val viewPager=findViewById<ViewPager>(R.id.viewPager)
        val facebook=findViewById<FloatingActionButton>(R.id.fab_facebook)
        val google=findViewById<FloatingActionButton>(R.id.fab_google)

        tablayout.addTab(tablayout.newTab().setText("Login"))
        tablayout.addTab(tablayout.newTab().setText("Register"))
        tablayout.tabGravity=(TabLayout.GRAVITY_FILL)

        val loginAdapter:LoginAdapter= LoginAdapter(supportFragmentManager,this,tablayout.tabCount)
        viewPager.adapter=loginAdapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tablayout))

        facebook.translationY=300f
        google.translationY=300f
        tablayout.translationY=300f

        facebook.alpha=0f
        google.alpha=0f
        tablayout.alpha=0f

        facebook.animate().translationY(0f).alpha(1f).setDuration(1000).setStartDelay(400).start()
        google.animate().translationY(0f).alpha(1f).setDuration(1000).setStartDelay(600).start()
        tablayout.animate().translationY(0f).alpha(1f).setDuration(1000).setStartDelay(800).start()

    }
}