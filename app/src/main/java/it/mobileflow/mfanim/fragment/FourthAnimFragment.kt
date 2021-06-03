package it.mobileflow.mfanim.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import it.mobileflow.mfanim.R
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
        binding.toggleVisibilityBtn.setOnClickListener {
            if (binding.loremIpsumTv.visibility == View.VISIBLE){
                binding.loadingSpinnerPb.visibility = View.VISIBLE
                binding.loremIpsumTv.visibility = View.INVISIBLE
                binding.loremIpsumTv.animate()
                    .alpha(0f)
                    .duration = 100
                Toast
                    .makeText(context, R.string.click_again_tosee_effect, Toast.LENGTH_SHORT)
                    .show()
            } else{
                binding.loadingSpinnerPb.visibility = View.INVISIBLE
                binding.loremIpsumTv.visibility = View.VISIBLE
                binding.loremIpsumTv.animate()
                    .alpha(1.0f)
                    .duration = 3000
            }
        }
    }
}
