package it.mobileflow.mfanim.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import it.mobileflow.mfanim.databinding.FragmentFirstAnimBinding

class FirstAnimFragment : Fragment() {
    private lateinit var binding : FragmentFirstAnimBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstAnimBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}