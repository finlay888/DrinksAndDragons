package uk.co.nightowl.platforms.drinksdragons.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_how_to_play.*
import uk.co.nightowl.platforms.drinksdragons.R
import uk.co.nightowl.platforms.drinksdragons.adapters.TutorialViewPagerAdapter
import uk.co.nightowl.platforms.drinksdragons.fragments.TutorialFour
import uk.co.nightowl.platforms.drinksdragons.fragments.TutorialOne
import uk.co.nightowl.platforms.drinksdragons.fragments.TutorialThree
import uk.co.nightowl.platforms.drinksdragons.fragments.TutorialTwo

class HowToPlayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_how_to_play)

        val fragments : ArrayList<Fragment> = ArrayList()
        fragments.add(TutorialOne())
        fragments.add(TutorialTwo())
        fragments.add(TutorialThree())
        fragments.add(TutorialFour())

        val adapter = TutorialViewPagerAdapter(supportFragmentManager, fragments)
        vp_tutorial.adapter = adapter
    }
}