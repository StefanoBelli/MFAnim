package it.mobileflow.mfanim.fragment

import android.animation.Animator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.*
import android.view.ViewGroup
import android.view.animation.*
import androidx.fragment.app.Fragment

import it.mobileflow.mfanim.databinding.FragmentFourthAnimBinding

class FourthAnimFragment : Fragment() {
    private lateinit var binding: FragmentFourthAnimBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFourthAnimBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.erase.setOnClickListener {
            if (binding.eraseText.visibility == VISIBLE){
                binding.loadingSpinner.visibility = VISIBLE
                binding.eraseText.visibility = INVISIBLE
                binding.eraseText.animate()
                    .alpha(0.0f)
                    .setDuration(1000)
            }
           else{
                binding.loadingSpinner.visibility = INVISIBLE
                binding.eraseText.visibility = VISIBLE
                binding.eraseText.animate()
                    .alpha(1.0f)
                    .setDuration(1000)
            }
        }
    }
}
