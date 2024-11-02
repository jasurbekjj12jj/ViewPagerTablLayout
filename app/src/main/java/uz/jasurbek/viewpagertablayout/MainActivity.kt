package uz.jasurbek.viewpagertablayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.tabs.TabLayout
import uz.jasurbek.viewpagertablayout.adapters.MyUserAdapter
import uz.jasurbek.viewpagertablayout.databinding.ActivityMainBinding
import uz.jasurbek.viewpagertablayout.utils.MyData

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var myUserAdapter: MyUserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MyData.addUsers()

        myUserAdapter = MyUserAdapter(MyData.list)

        binding.viewPager.adapter = myUserAdapter
        binding.myTab.setupWithViewPager(binding.viewPager)

        loadTabLayout()
    }

    private fun loadTabLayout() {
        val tabCount = binding.myTab.tabCount

        for (i in 0 until tabCount){
            val tabView = LayoutInflater.from(this).inflate(R.layout.item_tab_layout, null, false)
            val tab = binding.myTab.getTabAt(i)
            tab?.customView = tabView

            tabView.findViewById<TextView>(R.id.tv_tab_title).text = MyData.list[i].name

            val imageView = tabView.findViewById<ImageView>(R.id.image_indicator)

            if (i == 0){
                imageView.visibility = View.VISIBLE
            }else{
                imageView.visibility = View.GONE
            }
        }

        binding.myTab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val customView = tab?.customView
                val image = customView?.findViewById<ImageView>(R.id.image_indicator)
                image?.visibility = View.VISIBLE
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val customView = tab?.customView
                val image = customView?.findViewById<ImageView>(R.id.image_indicator)
                image?.visibility = View.GONE
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

    }
}