package com.huanghai.empty.widget

import android.annotation.TargetApi
import android.app.Activity
import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView

import com.huanghai.empty.App
import com.huanghai.empty.R
import kotlinx.android.synthetic.main.my_titlebar.view.*


/**
 * Created by huanghai on 2016/5/26.
 */
class MyTitleBar : FrameLayout {



    val textVisibility: Boolean
        get() = if (View.VISIBLE == tv_menu.visibility) {
            true
        } else false

    val iconVisibility: Boolean
        get() = if (View.VISIBLE == iv_menuicon.visibility) {
            true
        } else false

    private var onBackClickListener: OnBackClickListener? = null

    constructor(context: Context) : super(context) {}

    @JvmOverloads constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int = 0) : super(context, attrs, defStyleAttr) {
        //JLog.i("huanghai","三个参数的");
        val view = View.inflate(context, R.layout.my_titlebar, null)
        val params = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (App.SCREEN_HEIGHT * 0.08).toInt())
        view.layoutParams = params
        val ta = context.obtainStyledAttributes(attrs, R.styleable.TitleBarAttrs)
        val title = ta.getString(R.styleable.TitleBarAttrs_cjyytitle)
        val menuText = ta.getString(R.styleable.TitleBarAttrs_menuText)
        val isBackShow = ta.getBoolean(R.styleable.TitleBarAttrs_showBack, true)
        val isMenuShow = ta.getBoolean(R.styleable.TitleBarAttrs_showMenu, false)
        val menudrawable = ta.getDrawable(R.styleable.TitleBarAttrs_menuDrawable)

        val back = view.findViewById(R.id.back) as ImageView
        val iv_menuicon = view.findViewById(R.id.iv_menuicon) as ImageView
        val tv_title = view.findViewById(R.id.tv_title) as TextView
        val tv_menu = view.findViewById(R.id.tv_menu) as TextView

        val ll_menu = view.findViewById(R.id.ll_menu) as LinearLayout

        if (title != null) {
            tv_title.text = title
        }
        if (isBackShow) {
            back.visibility = View.VISIBLE
            back.setOnClickListener {
                if (onBackClickListener == null) {
                    (context as Activity).finish()
                } else {
                    onBackClickListener!!.onClick()
                }
            }
        } else {
            back.visibility = View.GONE
        }
        if (isMenuShow) {
            ll_menu.visibility = View.VISIBLE
            if (menudrawable != null) {
                iv_menuicon.setImageDrawable(menudrawable)

            }
            if (menuText != null) {
                tv_menu.text = menuText
            }


        } else {
            ll_menu.visibility = View.GONE
        }
        ta.recycle()
        this.addView(view)
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
    }

    fun setMenuText(text: String) {
        tv_menu.text = text
    }

    fun setMenuOnClickListener(listener: View.OnClickListener) {
        ll_menu.setOnClickListener(listener)
    }

    fun setBackOnClickListener(listener: View.OnClickListener) {
        back.setOnClickListener(listener)
    }

    fun setBackVisibility(visibility: Boolean?) {
        if (visibility!!) {
            back.visibility = View.VISIBLE
        } else {
            back.visibility = View.GONE
        }
    }

    fun setMenuVisibilityGone(gone: Boolean?) {
        if (gone!!) {
            ll_menu.visibility = View.GONE
        } else {
            ll_menu.visibility = View.VISIBLE
        }
    }

    fun setTitle(title: String) {
        tv_title.text = title
    }

    fun setMenuIcon(icon: Int) {
        iv_menuicon.setBackgroundResource(icon)
    }

    fun setIconVisibility(gone: Boolean?) {
        if (gone!!) {
            iv_menuicon.visibility = View.VISIBLE
        } else {
            iv_menuicon.visibility = View.GONE
        }
    }

    fun setTextVisibility(gone: Boolean?) {
        if (gone!!) {
            tv_menu.visibility = View.VISIBLE
        } else {
            tv_menu.visibility = View.GONE
        }
    }

    fun setBackVisibility(isShow: Boolean) {
        if (isShow) {
            back.visibility = View.VISIBLE
        } else {
            back.visibility = View.INVISIBLE
        }
    }

    interface OnBackClickListener {
        fun onClick()
    }

    fun setOnBackClickListener(onBackClickListener: OnBackClickListener) {
        this.onBackClickListener = onBackClickListener
    }
}
