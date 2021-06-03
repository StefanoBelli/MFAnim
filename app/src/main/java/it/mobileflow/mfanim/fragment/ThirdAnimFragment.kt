package it.mobileflow.mfanim.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import it.mobileflow.mfanim.R
import it.mobileflow.mfanim.databinding.FragmentThirdAnimBinding

class ThirdAnimFragment : Fragment() {
    private lateinit var binding : FragmentThirdAnimBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = FragmentThirdAnimBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listener = CommonOnClickListener()

        binding.fadeInBtn.setOnClickListener(listener)
        binding.fadeOutBtn.setOnClickListener(listener)
        binding.zoomInBtn.setOnClickListener(listener)
        binding.zoomOutBtn.setOnClickListener(listener)
        binding.bounceBtn.setOnClickListener(listener)
        binding.rotateBtn.setOnClickListener(listener)
        binding.slideUpBtn.setOnClickListener(listener)
        binding.slideDownBtn.setOnClickListener(listener)
    }

    inner class CommonOnClickListener : View.OnClickListener {
        private val anim = mapOf(
                binding.fadeInBtn to R.anim.fade_in, binding.fadeOutBtn to R.anim.fade_out,
                binding.zoomInBtn to R.anim.zoom_in, binding.zoomOutBtn to R.anim.zoom_out,
                binding.slideDownBtn to R.anim.slide_down, binding.slideUpBtn to R.anim.slide_up,
                binding.rotateBtn to R.anim.rotate, binding.bounceBtn to R.anim.bounce)

        override fun onClick(v: View?) {
            val animation = anim[v]?.let { AnimationUtils.loadAnimation(context , it) }
            binding.animViewPosResanimTv.visibility = View.VISIBLE
            binding.animViewPosResanimTv.startAnimation(animation)
        }
    }
}