package com.example.simple_soul.ebook.view.activity

import android.app.ActivityOptions
import android.content.Intent
import android.support.v4.app.ActivityCompat
import android.view.View
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.example.simple_soul.ebook.R
import com.example.simple_soul.ebook.utils.loadTransition
import com.example.simple_soul.ebook.utils.setStatusBarColor
import com.example.simple_soul.ebook.view.fragment.BookshelfFragment
import com.example.simple_soul.ebook.view.fragment.MineFragment
import com.special.ResideMenu.ResideMenu
import com.special.ResideMenu.ResideMenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.title_bar.*


class MainActivity : BaseActivity(), View.OnClickListener, BottomNavigationBar.OnTabSelectedListener
{

    private lateinit var resideMenu: ResideMenu

    private val manager = fragmentManager

    override fun getLayout(): Int
    {
        return R.layout.activity_main
    }

    override fun beforeSetContentView()
    {
        setStatusBarColor(this, R.color.colorPrimary)
        loadTransition(window, this)
    }

    override fun init()
    {
//        // attach to current activity;
//        resideMenu = ResideMenu(this)
//        resideMenu.setBackground(R.drawable.menu_background)
//        resideMenu.attachToActivity(this)
//        resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_RIGHT)
//        resideMenu.setScaleValue(0.7f)
//
//        // create menu items;
//        val titles = arrayOf("Home", "Profile", "Calendar", "Settings")
//        val icon = intArrayOf(R.drawable.icon_home, R.drawable.icon_profile, R.drawable.icon_calendar, R.drawable.icon_settings)
//
//        for (i in titles.indices)
//        {
//            val item = ResideMenuItem(this, icon[i], titles[i])
//            item.tag = i
//            item.setOnClickListener(this)
//            resideMenu.addMenuItem(item, ResideMenu.DIRECTION_LEFT) // or  ResideMenu.DIRECTION_RIGHT
//        }

        //要先设计模式后再添加图标！
        //设置按钮模式  MODE_FIXED表示固定   MODE_SHIFTING表示转移
        main_bnv.setMode(BottomNavigationBar.MODE_FIXED)
        //设置背景风格
        // BACKGROUND_STYLE_STATIC表示静态的
        //BACKGROUND_STYLE_RIPPLE表示涟漪的，也就是可以变化的 ，跟随setActiveColor里面的颜色变化
        main_bnv.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
        main_bnv.activeColor = R.color.colorPrimary

        main_bnv.addItem(BottomNavigationItem(R.drawable.icon_book, "书架"))
                .addItem(BottomNavigationItem(R.drawable.icon_profile, "我的"))
                .initialise()
        main_bnv.setTabSelectedListener(this)

        manager.beginTransaction().add(R.id.main_ll, BookshelfFragment()).commit()

        title_ll_search.setOnClickListener(this)
    }

//    override fun dispatchTouchEvent(ev: MotionEvent): Boolean
//    {
//        return resideMenu.dispatchTouchEvent(ev)
//    }

    override fun onTabReselected(position: Int) {}

    override fun onTabUnselected(position: Int) {}

    override fun onTabSelected(position: Int)
    {
        val tran = manager.beginTransaction()
        when(position)
        {
            0 -> tran.add(R.id.main_ll, BookshelfFragment()).commit()
            1 -> tran.add(R.id.main_ll, MineFragment()).commit()
        }
    }

    override fun onClick(v: View?)
    {
        when(v?.id)
        {
            R.id.title_ll_search->
            {
                val intent = Intent(this, SearchActivity::class.java)
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
            }
            R.id.title_image_more->
            {
                showToast("more")
            }
            else -> {
                val item = v as ResideMenuItem
                when(item.tag)
                {
//                    0->
//                    1->
//                    2->
//                    3->
                }
            }
        }
    }

    override fun onBackPressed()
    {
        super.onBackPressed()
        ActivityCompat.finishAfterTransition(this)
    }
}
