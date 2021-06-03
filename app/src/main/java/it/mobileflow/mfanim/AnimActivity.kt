package it.mobileflow.mfanim

import android.content.DialogInterface
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.format.DateFormat
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import it.mobileflow.mfanim.adapter.FragmentAdapter
import it.mobileflow.mfanim.databinding.ActivityAnimBinding
import it.mobileflow.mfanim.transformer.PopPageTransformer
import java.text.SimpleDateFormat
import java.util.*

class AnimActivity : AppCompatActivity() {
    companion object {
        private const val DATE_FORMAT = "EEE, d MMM yyyy HH:mm:ss Z"
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

        val dateFormat = SimpleDateFormat(DATE_FORMAT, Locale.getDefault(Locale.Category.FORMAT))
        val buildDateTimeFormatBasedOnUserLocale =
            dateFormat.format(Date(BuildConfig.BUILD_TIMESTAMP))

        infoMsg = "${getString(R.string.basic_info)}\n\n" +
                " * ${getString(R.string.project_src_link)}: ${getString(R.string.project_url)}\n" +
                " * ${getString(R.string.build_compiled)}: ${buildDateTimeFormatBasedOnUserLocale}\n" +
                " * ${getString(R.string.build_type)}: ${BuildConfig.BUILD_TYPE}"

        initUi()
    }

    private fun initUi() {
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
                    .setIcon(R.drawable.ic_baseline_info_24)
                    .setCancelable(false)
                    .setMessage(infoMsg)
                    .setPositiveButton(R.string.ok) { actualDialog: DialogInterface, _: Int ->
                        actualDialog.cancel()
                    }
                    .show() //Dialog
                    .getButton(DialogInterface.BUTTON_POSITIVE)
                    .setTextColor(getColor(R.color.primary))
            }
        }

        return super.onOptionsItemSelected(item)
    }
}