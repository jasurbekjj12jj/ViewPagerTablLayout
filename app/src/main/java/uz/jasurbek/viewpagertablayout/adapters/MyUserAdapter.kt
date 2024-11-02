package uz.jasurbek.viewpagertablayout.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import uz.jasurbek.viewpagertablayout.databinding.ItemPageBinding
import uz.jasurbek.viewpagertablayout.models.User

class MyUserAdapter(var list: ArrayList<User>) : PagerAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemPagerBinding = ItemPageBinding.inflate(LayoutInflater.from(container.context), container, false)
        itemPagerBinding.imgPage.setImageResource(list[position].image)
        itemPagerBinding.tvPage.text = (list[position].name)

        container.addView(itemPagerBinding.root)

        return itemPagerBinding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view = `object` as View
        container.removeView(view)
    }
}