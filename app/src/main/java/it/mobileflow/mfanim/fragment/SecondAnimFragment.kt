package it.mobileflow.mfanim.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import it.mobileflow.mfanim.databinding.FragmentSecondAnimBinding

class SecondAnimFragment : Fragment() {
    private lateinit var binding : FragmentSecondAnimBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondAnimBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.androidLogoIv.setOnClickListener {
            binding.androidLogoIv.animate().apply {
                duration = 1000
                rotationXBy(360f)
            }.withEndAction {
                binding.androidLogoIv.animate().apply {
                    duration = 1000
                    rotationYBy(3600f)
                }
            }
        }
    }
}