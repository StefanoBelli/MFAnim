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
        binding.fadeIn.setOnClickListener {
            binding.textView.visibility = View.VISIBLE
            val animation = AnimationUtils.loadAnimation(context , R.anim.fade_in)
            binding.textView.startAnimation(animation)
        }
        binding.fadeOut.setOnClickListener {
            binding.textView.visibility = View.VISIBLE
            val animation = AnimationUtils.loadAnimation(context , R.anim.fade_out)
            binding.textView.startAnimation(animation)
        }
        binding.zoomIn.setOnClickListener {
            binding.textView.visibility = View.VISIBLE
            val animation = AnimationUtils.loadAnimation(context , R.anim.zoom_in)
            binding.textView.startAnimation(animation)
        }
        binding.zoomOut.setOnClickListener {
            binding.textView.visibility = View.VISIBLE
            val animation = AnimationUtils.loadAnimation(context , R.anim.zoom_out)
            binding.textView.startAnimation(animation)
        }
        binding.slideDown.setOnClickListener {
            binding.textView.visibility = View.VISIBLE
            val animation = AnimationUtils.loadAnimation(context , R.anim.slide_down)
            binding.textView.startAnimation(animation)
        }
        binding.slideUp.setOnClickListener {
            binding.textView.visibility = View.VISIBLE
            val animation = AnimationUtils.loadAnimation(context , R.anim.slide_up)
            binding.textView.startAnimation(animation)
        }
        binding.bounce.setOnClickListener {
            binding.textView.visibility = View.VISIBLE
            val animation = AnimationUtils.loadAnimation(context , R.anim.bounce)
            binding.textView.startAnimation(animation)
        }
        binding.rotate.setOnClickListener {
            binding.textView.visibility = View.VISIBLE
            val animation = AnimationUtils.loadAnimation(context , R.anim.rotate)
            binding.textView.startAnimation(animation)
        }
    }

}