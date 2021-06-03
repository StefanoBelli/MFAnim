package it.mobileflow.mfanim

import android.content.DialogInterface
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import it.mobileflow.mfanim.adapter.FragmentAdapter
import it.mobileflow.mfanim.databinding.ActivityAnimBinding
import it.mobileflow.mfanim.transformer.PopPageTransformer
import java.util.Date

class AnimActivity : AppCompatActivity() {
    companion object {
        private const val PROJECT_SRC_LINK = "https://github.com/StefanoBelli/MFAnim"
    }

    private lateinit var binding : ActivityAnimBinding
    private lateinit var titles : Array<String>
    private lateinit var infoMsg : String

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

        infoMsg = "${getString(R.string.basic_info)}\n\n" +
                " * ${getString(R.string.project_src_link)}: ${PROJECT_SRC_LINK}\n" +
                " * ${getString(R.string.build_compiled)}: ${Date(BuildConfig.BUILD_TIMESTAMP)}\n" +
                " * ${getString(R.string.build_type)}: ${BuildConfig.BUILD_TYPE}"

        init()
    }

    private fun init() {
        val colorDrawable = ColorDrawable(getColor(R.color.primary))
        supportActionBar!!.setBackgroundDrawable(colorDrawable)
        window.statusBarColor = getColor(R.color.primary_variant)
        binding.pager.adapter = FragmentAdapter(this)
        binding.pager.setPageTransformer(PopPageTransformer())
        TabLayoutMediator(binding.layoutTabs, binding.pager)
            { tab: TabLayout.Tab, position: Int
                -> tab.text = titles[position] }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_anim, menu)
        return super.onCreateOptionsMenu(menu)
    }
    
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.app_info_btn -> {
                AlertDialog.Builder(this)
                        .setTitle(getString(R.string.appinfo))
                        .setIcon(R.drawable.ic_baseline_info_24,)
                        .setCancelable(false)
                        .setMessage(infoMsg)
                        .setPositiveButton(R.string.ok) { actualDialog: DialogInterface, _: Int ->
                            actualDialog.cancel()
                        }
                        .show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}