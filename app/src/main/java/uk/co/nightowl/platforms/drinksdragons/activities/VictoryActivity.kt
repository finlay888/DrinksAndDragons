package uk.co.nightowl.platforms.drinksdragons.activities

import android.graphics.Typeface
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.android.synthetic.main.activity_victory.*
import uk.co.nightowl.platforms.drinksdragons.R

class VictoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_victory)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setTypeFace()
        sound()
    }

    private fun setTypeFace(){
        val typeface : Typeface = Typeface.createFromAsset(assets, "attack of the cucumbers.ttf")
        tv_victory_top.typeface = typeface
        tv_victory_bottom.typeface = typeface
    }

    private fun sound(){
        val media : MediaPlayer? = MediaPlayer.create(this, R.raw.victory_trumpet)
        media?.start()
    }
}
