package it.mobileflow.mfanim.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import it.mobileflow.mfanim.fragment.FirstAnimFragment
import it.mobileflow.mfanim.fragment.FourthAnimFragment
import it.mobileflow.mfanim.fragment.SecondAnimFragment
import it.mobileflow.mfanim.fragment.ThirdAnimFragment

class FragmentAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    companion object {
        private val frags = arrayListOf(
            FirstAnimFragment::class.java,
            SecondAnimFragment::class.java,
            ThirdAnimFragment::class.java,
            FourthAnimFragment::class.java
        )
    }

    override fun createFragment(position: Int): Fragment {
        return frags[position].newInstance()
    }

    override fun getItemCount(): Int {
        return frags.size
    }
}