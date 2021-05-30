package it.mobileflow.mfanim

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import it.mobileflow.mfanim.adapter.SliderAdapter
import it.mobileflow.mfanim.databinding.ActivityMainBinding
import it.mobileflow.mfanim.transformer.SliderTransformer

class MainActivity : AppCompatActivity() {
    companion object {
        private const val SHPREFS = "it.mf.mfanim_rand409371243124_shpref"
        private const val INTROED_KEY = "introed"
        private val INTRO_LAYOUTS = intArrayOf(
                R.layout.intro_first_hello,
                R.layout.intro_second_anim_shown,
                R.layout.intro_third_whoweare)
    }

    private lateinit var binding : ActivityMainBinding
    private var alreadyAddedDots = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(getSharedPreferences(SHPREFS, Context.MODE_PRIVATE)
                .getBoolean(INTROED_KEY, false)) {
            startAnimActivity()
        } else {
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
            init()
        }
    }

    private fun init() {
        makeDots(0)
        supportActionBar?.hide()
        binding.pager.adapter = SliderAdapter(INTRO_LAYOUTS)
        binding.pager.registerOnPageChangeCallback(pageChangeCallback)
        binding.pager.setPageTransformer(SliderTransformer())
        binding.btnNext.setOnClickListener { introCurrent(true) }
        binding.btnPrev.setOnClickListener { introCurrent(false) }
        window.statusBarColor = getColor(R.color.dot_dark_screen1)
    }

    private var pageChangeCallback:
            ViewPager2.OnPageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)

            if(alreadyAddedDots)
                makeDots(position)
            else
                alreadyAddedDots = true

            if (position == INTRO_LAYOUTS.size - 1) {
                binding.btnNext.text = getString(R.string.view_anims)
            } else {
                binding.btnNext.text = getString(R.string.next)
                binding.btnPrev.visibility = if(position == 0) View.INVISIBLE else View.VISIBLE
            }
        }
    }

    private fun introCurrent(goNext: Boolean) {
        val current = binding.pager.currentItem + if (goNext) 1 else -1

        if (current < INTRO_LAYOUTS.size) {
            binding.pager.currentItem = current
        } else {
            startAnimActivity()
            getSharedPreferences(SHPREFS, Context.MODE_PRIVATE).edit().apply {
                putBoolean(INTROED_KEY, true)
                apply()
            }
        }
    }

    private fun makeDots(cur: Int) {
        val dots : Array<TextView?> = arrayOfNulls(INTRO_LAYOUTS.size)

        val colorsActive = resources.getIntArray(R.array.array_dot_active)
        val colorsInactive = resources.getIntArray(R.array.array_dot_inactive)

        binding.layoutDots.removeAllViews()

        for (i in dots.indices) {
            dots[i] = TextView(this)
            dots[i]!!.text = Html.fromHtml("&#8226;", 0)
            dots[i]!!.textSize = 35f
            dots[i]!!.setTextColor(colorsInactive[cur])
            window.statusBarColor = colorsInactive[cur]
            binding.layoutDots.addView(dots[i])
        }

        if (dots.isNotEmpty()) {
            dots[cur]!!.setTextColor(colorsActive[cur])
        }
    }

    private fun startAnimActivity() {
        startActivity(Intent(this,  AnimActivity::class.java))
        finish()
    }
}