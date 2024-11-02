package uz.jasurbek.viewpagertablayout.utils

import uz.jasurbek.viewpagertablayout.R
import uz.jasurbek.viewpagertablayout.models.User

object MyData {
    val list = ArrayList<User>()

    fun addUsers(){
        list.add(User("Boburjon", R.drawable.img))
        list.add(User("Behruzbek", R.drawable.img_1))
        list.add(User("Farruxbek", R.drawable.img_2))
        list.add(User("Jasurbek", R.drawable.img_3))
    }
}