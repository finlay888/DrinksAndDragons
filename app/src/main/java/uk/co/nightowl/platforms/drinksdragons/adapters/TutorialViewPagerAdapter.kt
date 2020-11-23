package uk.co.nightowl.platforms.drinksdragons.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import uk.co.nightowl.platforms.drinksdragons.activities.HowToPlayActivity

class TutorialViewPagerAdapter (manager: FragmentManager,
                                private val list: ArrayList<Fragment>,
                                private val context: Context): FragmentStatePagerAdapter(manager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Fragment {
        return list[position]
    }

}