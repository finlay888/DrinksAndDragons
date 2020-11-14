package uk.co.nightowl.platforms.drinksdragons.activities

import android.animation.AnimatorSet
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.view.animation.*
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_splash.*
import org.angmarch.views.NiceSpinner
import uk.co.nightowl.platforms.drinksdragons.R
import uk.co.nightowl.platforms.drinksdragons.dialogs.PlayerDialog
import uk.co.nightowl.platforms.drinksdragons.objects.Constants
import java.util.*

class SplashActivity : AppCompatActivity(), AdapterView.OnItemClickListener {

    private var playerNum = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        setUpSpinner()
        setTypeFace()
        loadingAnimations()
        sound()

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        val btnAnim = AnimationUtils.loadAnimation(
            this,
            R.anim.btn_bounce
        )

        btn_new_game.setOnClickListener {
            btn_new_game.startAnimation(btnAnim)
            playerNum = spinner_players.selectedItem.toString().first().toInt() - 48
            nameDialog()
        }

        btn_tutorial.setOnClickListener {
            btn_tutorial.startAnimation(btnAnim)
        }

    }

    private fun nameDialog(){
        val nameDialog = object : PlayerDialog(this, playerNum){
        }
        nameDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        nameDialog.show()
    }

    private fun setUpSpinner(){
        val spinner : NiceSpinner = findViewById(R.id.spinner_players)
        val dataset: List<String> = LinkedList(listOf("1 Player", "2 Adventurers", "3 Archaeologists",
            "4 Legends", "5 Heroes", "6 Paladins"))
        spinner.attachDataSource(dataset)
    }

    private fun setTypeFace(){
        val typeface : Typeface = Typeface.createFromAsset(assets, "attack of the cucumbers.ttf")
        tv_splash_title_drinks.typeface = typeface
        tv_splash_title_and.typeface = typeface
        tv_splash_title_dragons.typeface = typeface
    }

    private fun sound(){
        val media : MediaPlayer? = MediaPlayer.create(this, R.raw.splash)
        media?.start()
    }

    private fun loadingAnimations(){
        val title1 = findViewById<TextView>(R.id.tv_splash_title_drinks)
        val title2 = findViewById<TextView>(R.id.tv_splash_title_and)
        val title3 = findViewById<TextView>(R.id.tv_splash_title_dragons)
        val splashIconOne = findViewById<ImageView>(R.id.iv_splash_icon)
        val splashIconTwo = findViewById<ImageView>(R.id.iv_swords_icon)
        val menuBtns = findViewById<LinearLayout>(R.id.ll_splash_menu_btns)

        val basicFadeIn = AnimationUtils.loadAnimation(
            this,
            R.anim.fade_in
        )

        val fadeIn = AlphaAnimation(0f, 1f)
        fadeIn.interpolator = AccelerateInterpolator() //add this
        fadeIn.duration = 2000

        val fadeOut = AlphaAnimation(1f, 0f)
        fadeOut.interpolator = DecelerateInterpolator() //and this
        fadeOut.startOffset = 2000
        fadeOut.duration = 1000

        val animation = AnimationSet(false) //change to false
        animation.addAnimation(fadeIn)
        animation.addAnimation(fadeOut)

        title1.startAnimation(animation)
        title2.startAnimation(animation)
        title3.startAnimation(animation)
        splashIconOne.startAnimation(animation)

        Handler().postDelayed({
            title1.visibility = View.GONE
            title2.visibility = View.GONE
            title3.visibility = View.GONE
            splashIconOne.visibility = View.GONE
        }, 3000)

        Handler().postDelayed({
            splashIconTwo.startAnimation(basicFadeIn)
            menuBtns.startAnimation(basicFadeIn)
            splashIconTwo.visibility = View.VISIBLE
            menuBtns.startAnimation(basicFadeIn)
            menuBtns.visibility = View.VISIBLE
        }, 3500)
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

    }
}
