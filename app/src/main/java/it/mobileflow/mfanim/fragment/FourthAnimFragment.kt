package it.mobileflow.mfanim.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import it.mobileflow.mfanim.databinding.FragmentFourthAnimBinding

class FourthAnimFragment : Fragment() {
    private lateinit var binding : FragmentFourthAnimBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFourthAnimBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}