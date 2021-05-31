package it.mobileflow.mfanim

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import it.mobileflow.mfanim.adapter.FragmentAdapter
import it.mobileflow.mfanim.databinding.ActivityAnimBinding


class AnimActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAnimBinding
    private lateinit var titles : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimBinding.inflate(layoutInflater)
        setContentView(binding.root)
        titles = arrayOf(
                getString(R.string.first_anim_name),
                getString(R.string.second_anim_name),
                getString(R.string.third_anim_name),
                getString(R.string.fourth_anim_name)
        )
        init()
    }

    private fun init() {
        val colorDrawable = ColorDrawable(getColor(R.color.primary))
        supportActionBar!!.setBackgroundDrawable(colorDrawable)
        window.statusBarColor = getColor(R.color.primary_variant)
        binding.pager.adapter = FragmentAdapter(this)
        TabLayoutMediator(binding.layoutTabs, binding.pager)
            { tab: TabLayout.Tab, position: Int
                -> tab.text = titles[position] }.attach()
    }
}