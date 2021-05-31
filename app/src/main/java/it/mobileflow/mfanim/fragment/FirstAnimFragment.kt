package it.mobileflow.mfanim.fragment

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.graphics.Path
import android.graphics.RectF
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import it.mobileflow.mfanim.R
import it.mobileflow.mfanim.databinding.FragmentFirstAnimBinding

class FirstAnimFragment : Fragment() {
    companion object {
        private const val TRSL_X = "translationX"
        private const val TRSL_Y = "translationY"
    }

    private lateinit var binding : FragmentFirstAnimBinding
    private var animDuration : Long = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstAnimBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.durationSkb.setOnSeekBarChangeListener(SeekBarChangeListener())
        binding.durationSkb.min = 100
        binding.durationSkb.max = 5000
        binding.durationSkb.progress = 2500
        binding.clickMeBtn.setOnClickListener(ButtonClickListener())
    }

    inner class SeekBarChangeListener : SeekBar.OnSeekBarChangeListener {
        @SuppressLint("SetTextI18n")
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            binding.durationTv.text = getString(R.string.duration) + ": " + progress + "ms"
            animDuration = progress.toLong()
        }

        override fun onStartTrackingTouch(seekBar: SeekBar?) {
        }

        override fun onStopTrackingTouch(seekBar: SeekBar?) {
        }
    }

    inner class ButtonClickListener : View.OnClickListener {
        private var currentStep = 0
        private var origX : Float = 0f
        private var origY : Float = 0f

        override fun onClick(v: View?) {
            when(currentStep) {
                0 -> {
                    origX = v!!.x
                    origY = v.y
                    ObjectAnimator.ofFloat(v, TRSL_X, 300f).apply {
                        duration = animDuration
                        start()
                    }
                    currentStep = 1
                }
                1 -> {
                    ObjectAnimator.ofFloat(v, TRSL_Y, 300f).apply {
                        duration = animDuration
                        start()
                    }
                    currentStep = 2
                }
                2 -> {
                    val linedPath = Path().apply {
                        moveTo(v!!.x, v.y)
                        lineTo(origX, origY)
                    }
                    ObjectAnimator.ofFloat(v, View.X, View.Y, linedPath).apply {
                        duration = animDuration
                        start()
                    }
                    currentStep = 0
                }
            }
        }
    }
}
