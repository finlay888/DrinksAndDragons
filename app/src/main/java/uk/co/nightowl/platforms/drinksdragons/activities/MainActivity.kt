package uk.co.nightowl.platforms.drinksdragons.activities

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.app.Activity
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import uk.co.nightowl.platforms.drinksdragons.R
import uk.co.nightowl.platforms.drinksdragons.adapters.AcquiredAdapter
import uk.co.nightowl.platforms.drinksdragons.objects.Treasure.setTreasure
import uk.co.nightowl.platforms.drinksdragons.models.*
import uk.co.nightowl.platforms.drinksdragons.objects.Constants
import uk.co.nightowl.platforms.drinksdragons.objects.Events

class MainActivity : AppCompatActivity() {

    private lateinit var frontAnim : AnimatorSet
    private lateinit var backAnim : AnimatorSet
    private lateinit var fadeIn : Animation
    private lateinit var fadeOut : Animation
    private var isFront = true
    private var firstPress = true

    private var mEvents : ArrayList<Event> = Events.setEvents()
    private lateinit var mCharacter: Character
    private var currentEvent : Event? = null
    private lateinit var mTreasure : ArrayList<Treasure>
    private var inventory = ArrayList<Treasure>()
    private var mFight = 0
    private var mCharm = 0
    private var mRun = 0
    private var playerList : ArrayList<Character> = ArrayList()
    private var playerTurn = 0
    private var eventBtn = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        playerList = intent.getParcelableArrayListExtra<Character>(Constants.PLAYERS) as ArrayList<Character>
        mCharacter = playerList[0]
        tv_player_name.text = playerList[0].name
        Log.i("scoop1", playerList[0].name)
        setUi()
        mTreasure = setTreasure()
        calculateStats()
        val scale = applicationContext.resources.displayMetrics.density
        cl_card_front.cameraDistance = 8000 * scale
        cl_card_back.cameraDistance = 8000 * scale

        frontAnim = AnimatorInflater.loadAnimator(applicationContext,
            R.animator.front_animator
        ) as AnimatorSet
        backAnim = AnimatorInflater.loadAnimator(applicationContext,
            R.animator.back_animator
        ) as AnimatorSet
        val ttb = AnimationUtils.loadAnimation(this, R.anim.ttb)
        val btt = AnimationUtils.loadAnimation(this, R.anim.btt)
        fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out)
        val btnAnim = AnimationUtils.loadAnimation(this, R.anim.btn_bounce)

        btn_event.setOnClickListener {
            Log.i("scoop1", playerList[0].name)
            if (eventBtn){
                eventBtn = false
                Handler().postDelayed({
                    btn_event.text = getString(R.string.end_turn)
                }, 750)
                calculateStats()
                cardSound()
                if (firstPress){
                    firstPress = false
                }else{
                    if(mEvents.size == 0){
                        mEvents = Events.setEvents()
                    }
                    setUi()
                }
                when {
                    currentEvent!!.badStuff != null -> {
                        fl_event_card.startAnimation(ttb)
                        ll_decision_btns.startAnimation(btt)
                        ll_main_btns.visibility = View.GONE
                        ll_success_chance.visibility = View.VISIBLE
                        Handler().postDelayed({
                            fl_event_card.visibility = View.VISIBLE
                            ll_decision_btns.visibility = View.VISIBLE
                        }, 500)
                    }
                    currentEvent!!.special != null -> {
                        fl_event_card.startAnimation(ttb)
                        ll_special_btns.startAnimation(btt)
                        ll_main_btns.visibility = View.GONE
                        ll_success_chance.visibility = View.GONE
                        Handler().postDelayed({
                            fl_event_card.visibility = View.VISIBLE
                            ll_special_btns.visibility = View.VISIBLE
                        }, 500)
                    }
                    currentEvent!!.curse != null -> {
                        fl_event_card.startAnimation(ttb)
                        btn_continue.startAnimation(btt)
                        ll_main_btns.visibility = View.GONE
                        ll_success_chance.visibility = View.GONE
                        Handler().postDelayed({
                            fl_event_card.visibility = View.VISIBLE
                            btn_continue.visibility = View.VISIBLE
                        }, 500)
                    }
                }
            }else{
                eventBtn = true
                playerList[playerTurn] = mCharacter
                nextTurn()
                btn_event.text = getString(R.string.draw_event_card)
                statusImageSetter(mCharacter.level)
            }
        }

        /*fl_event_card.setOnClickListener {
            if (currentEvent!!.badStuff != null){
                isFront = if(isFront){
                    frontAnim.setTarget(cl_card_front)
                    backAnim.setTarget(cl_card_back)
                    frontAnim.start()
                    backAnim.start()
                    false
                }else{
                    frontAnim.setTarget(cl_card_back)
                    backAnim.setTarget(cl_card_front)
                    frontAnim.start()
                    backAnim.start()
                    true
                }
            }
        }*/

        btn_inventory.setOnClickListener {
            val intent = Intent(this, InventoryActivity::class.java)
            intent.putExtra(Constants.CHARACTER, mCharacter)
            startActivityForResult(intent, Constants.INVENTORY_REQUEST_CODE)
        }

        //special buttons
        btn_special_1.setOnClickListener {
            specialResult(currentEvent!!.special!!.outcome1)
            btn_special_1.startAnimation(btnAnim)
            fl_event_card.startAnimation(fadeOut)
            ll_special_btns.startAnimation(fadeOut)
            Handler().postDelayed({
                fl_event_card.visibility = View.INVISIBLE
                ll_special_btns.visibility = View.INVISIBLE
            }, 740)
            Handler().postDelayed({
                ll_main_btns.visibility = View.VISIBLE
                ll_main_btns.startAnimation(ttb)
            }, 750)
        }

        btn_special_2.setOnClickListener {
            specialResult(currentEvent!!.special!!.outcome2)
            btn_special_2.startAnimation(btnAnim)
            fl_event_card.startAnimation(fadeOut)
            ll_special_btns.startAnimation(fadeOut)
            Handler().postDelayed({
                fl_event_card.visibility = View.INVISIBLE
                ll_special_btns.visibility = View.INVISIBLE
            }, 740)
            Handler().postDelayed({
                ll_main_btns.visibility = View.VISIBLE
                ll_main_btns.startAnimation(ttb)
            }, 750)
        }

        //choice buttons
        btn_fight.setOnClickListener {
            val result = successCalculator(mCharacter.bFight + mFight, currentEvent?.fDifficulty!!)
            result("f", result)
            btn_fight.startAnimation(btnAnim)
            fl_event_card.startAnimation(fadeOut)
            ll_decision_btns.startAnimation(fadeOut)
            Handler().postDelayed({
                fl_event_card.visibility = View.INVISIBLE
                ll_decision_btns.visibility = View.INVISIBLE
            }, 730)
            Handler().postDelayed({
                cl_outcome.startAnimation(ttb)
                cardSound()
                btn_continue.startAnimation(btt)
                btn_continue.visibility = View.VISIBLE
                cl_outcome.visibility = View.VISIBLE
            },500)
        }
        btn_charm.setOnClickListener {
            btn_charm.startAnimation(btnAnim)
            val result = successCalculator(mCharacter.bCharm + mCharm, currentEvent?.cDifficulty!!)
            result("c", result)
            fl_event_card.startAnimation(fadeOut)
            ll_decision_btns.startAnimation(fadeOut)
            Handler().postDelayed({
                fl_event_card.visibility = View.INVISIBLE
                ll_decision_btns.visibility = View.INVISIBLE
            }, 730)
            Handler().postDelayed({
                cl_outcome.startAnimation(ttb)
                cardSound()
                cl_outcome.visibility = View.VISIBLE
                btn_continue.startAnimation(btt)
                btn_continue.visibility = View.VISIBLE
            },500)
        }
        btn_run.setOnClickListener {
            btn_run.startAnimation(btnAnim)
            val result = successCalculator(mCharacter.bRun, currentEvent?.rDifficulty!!)
            result("r", result)
            fl_event_card.startAnimation(fadeOut)
            ll_decision_btns.startAnimation(fadeOut)
            Handler().postDelayed({
                fl_event_card.visibility = View.INVISIBLE
                ll_decision_btns.visibility = View.INVISIBLE
            }, 730)
            Handler().postDelayed({
                cl_outcome.startAnimation(ttb)
                cardSound()
                cl_outcome.visibility = View.VISIBLE
                btn_continue.startAnimation(btt)
                btn_continue.visibility = View.VISIBLE
            },500)
        }
        btn_continue.setOnClickListener {
            if(mCharacter.level >= 10){
                val intent = Intent(this, VictoryActivity::class.java)
                Handler().postDelayed({
                    startActivity(intent)
                    finish()
                }, 1000)
            }
                btn_continue.startAnimation(fadeOut)
            if (!isFront){
                isFront = true
                frontAnim.setTarget(cl_card_back)
                backAnim.setTarget(cl_card_front)
                frontAnim.start()
                backAnim.start()
            }
            Log.i("continue", playerList[0].name)
            if (currentEvent!!.curse != null){
                curseResult()
                fl_event_card.startAnimation(fadeOut)
                Handler().postDelayed({
                    fl_event_card.visibility = View.INVISIBLE
                }, 730)
            }
            if (cl_outcome.visibility == View.VISIBLE){
                cl_outcome.startAnimation(fadeOut)
            }else if (fl_event_card.visibility == View.VISIBLE){
                fl_event_card.startAnimation(fadeOut)
            }
            Handler().postDelayed({
                cl_outcome.visibility = View.INVISIBLE
                ll_main_btns.visibility = View.VISIBLE
                btn_continue.visibility = View.INVISIBLE
                ll_main_btns.startAnimation(ttb)
            }, 730)
        }
    }

    private fun nextTurn(){
        if (playerTurn >= 0){
            mCharacter = playerList[playerTurn]
        }
        if (playerTurn == playerList.size - 1){
            playerTurn = 0
            Log.i("woof", playerTurn.toString())
        }else{
            playerTurn += 1
        }
        mCharacter = playerList[playerTurn]
        Log.i("scoop", playerTurn.toString())
        Log.i("scoops", playerList.size.toString())
        Log.i("next turn", playerList[0].name)
        inventory = mCharacter.inventory
        tv_player_name.text = mCharacter.name
        tv_level_number.text = mCharacter.level.toString()
        setUpRecyclerView(ArrayList())
    }

    private fun setUi(){
        val rn = generateNumber(mEvents.size) - 1
        val model = mEvents[rn]
        currentEvent = model
        tv_event_name.text = model.name
        tv_event_description.text = model.description
        iv_event_image.setImageResource(model.image)
        tv_treasure_number.text = model.treasure.toString()
        ll_treasure_number.visibility = View.VISIBLE
        if(model.badStuff != null){
            tv_bad_stuff_description.text = model.bsDescription
            tv_bad_stuff_stats.text = model.badStuff.forfeit
        }else if (model.special != null){
            btn_special_1.text = model.special.choice1
            btn_special_2.text = model.special.choice2
            ll_treasure_number.visibility = View.INVISIBLE
        }else if (model.curse != null){
            ll_treasure_number.visibility = View.INVISIBLE
        }
        mEvents.removeAt(rn)
        tv_level_number.text = mCharacter.level.toString()
        statusImageSetter(mCharacter.level)
        successChance()
    }

    private fun statusImageSetter(level : Int){
        when(level){
            1 -> iv_status_event.setImageResource(R.drawable.s_pleb)
            2 -> iv_status_event.setImageResource(R.drawable.s_peasant)
            3 -> iv_status_event.setImageResource(R.drawable.s_traveller)
            4 -> iv_status_event.setImageResource(R.drawable.s_knight)
            5 -> iv_status_event.setImageResource(R.drawable.s_hero)
        }
    }

    private fun generateNumber(range : Int) : Int {
        return (1..range).random()
    }

    private fun successCalculator (stat : Int, difficulty : Int) : Boolean {
        val result = generateNumber(difficulty)
        Log.i("stat", result.toString())
        Log.i("static", difficulty.toString())
        return stat >= result
    }

    private fun successChance(){
        var fight = (((mCharacter.bFight + mFight).toDouble()/(currentEvent?.fDifficulty!!).toDouble())*100).toInt()
        if (fight > 100){
            fight = 100
        }
        var charm = (((mCharacter.bCharm + mCharm).toDouble()/(currentEvent?.cDifficulty!!).toDouble())*100).toInt()
        if (charm > 100){
            charm = 100
        }
        var run = (((mCharacter.bRun + mRun).toDouble()/(currentEvent?.rDifficulty!!).toDouble())*100).toInt()
        if (run > 100){
            run = 100
        }
        tv_fight_chance.text = "Fight "+fight.toString() + "%"
        tv_charm_chance.text = "Charm "+charm.toString()+ "%"
        tv_run_chance.text = "Run "+run.toString()+ "%"
    }

    private fun cardSound(){
        val media : MediaPlayer? = MediaPlayer.create(this, R.raw.card_sound)
        media?.start()
    }

    private fun specialResult (outcome : Outcome){
        mCharacter.level += outcome.level
        if(mCharacter.level >= 10){
            val intent = Intent(this, VictoryActivity::class.java)
            startActivity(intent)
            finish()
        }
        if (outcome.special != null){
            mCharacter.inventory.add(outcome.special)
        }
        when(outcome.statType){
            "f" -> mCharacter.bFight += outcome.statEffect
            "c" -> mCharacter.bCharm += outcome.statEffect
            "r" -> mCharacter.bRun += outcome.statEffect
        }
        tv_level_number.text = mCharacter.level.toString()
    }

    private fun curseResult(){
        val model = currentEvent!!.curse
        mCharacter.level += model!!.level
        if (model.treasureAffect.isNotEmpty()){
            removeTreasure(model.treasureAffect)
        }
    }

    private fun result (type : String, result: Boolean){
        if (result){
            when(type){
                "f" -> {
                    tv_outcome_description.text = currentEvent!!.fight
                    levelAdd()
                    tv_level_number.text = mCharacter.level.toString()
                    acquireTreasure()
                    if(generateNumber(2) == 1){
                        iv_outcome_image.setImageResource(R.drawable.victory_one)
                    }else{
                        iv_outcome_image.setImageResource(R.drawable.victory_two)
                    }
                }
                "c" -> {
                    tv_outcome_description.text = currentEvent!!.charm
                    levelAdd()
                    acquireTreasure()
                    tv_level_number.text = mCharacter.level.toString()
                    iv_outcome_image.setImageResource(R.drawable.charmed)
                }
                "r" -> {
                    tv_outcome_description.text = getString(R.string.runaway_success)
                    tv_outcome_forfeit.visibility = View.VISIBLE
                    tv_outcome_forfeit.text = getString(R.string.run_forfeit)
                    iv_outcome_image.setImageResource(R.drawable.runaway)
                }
            }
            tv_outcome_title.text = getString(R.string.success)
        }else{
            tv_outcome_forfeit.visibility = View.VISIBLE
            tv_outcome_description.text = currentEvent!!.bsDescription
            tv_outcome_forfeit.text = currentEvent!!.badStuff?.forfeit
            tv_outcome_title.text = getString(R.string.failure)
            val levelAffect = currentEvent!!.badStuff?.level
            mCharacter.level += levelAffect!!
            when(generateNumber(3)){
                1 -> iv_outcome_image.setImageResource(R.drawable.death_one)
                2 -> iv_outcome_image.setImageResource(R.drawable.death_two)
                3 -> iv_outcome_image.setImageResource(R.drawable.death_three)
            }
        }
        levelCheck()
    }

    private fun levelCheck(){
        if (mCharacter.level < 1){
            mCharacter.level = 1
        }else if(mCharacter.level >= 6){
            val intent = Intent(this, VictoryActivity::class.java)
            startActivity(intent)
            finish()
        }
        tv_level_number.text = mCharacter.level.toString()
        statusImageSetter(mCharacter.level)
    }

    private fun removeTreasure(type : String){
        when(type){
            "h" -> {
                inventory.remove(mCharacter.head)
                mCharacter.head = null
            }
            "c" -> {
                inventory.remove(mCharacter.chest)
                mCharacter.chest = null
            }
            "l" -> {
                inventory.remove(mCharacter.legs)
                mCharacter.legs = null
            }
            "f" -> {
                inventory.remove(mCharacter.feet)
                mCharacter.feet = null
            }
            "w" -> {
                inventory.remove(mCharacter.weapon)
                mCharacter.weapon = null
            }
            "t" -> {
                inventory.remove(mCharacter.trinket)
                mCharacter.trinket = null
            }
        }
    }

    private fun acquireTreasure(){
        val acquired = ArrayList<Treasure>()
        tv_outcome_forfeit.visibility = View.GONE
        val treasureNum = currentEvent!!.treasure
        if (mTreasure.size <= 3){
            mTreasure = setTreasure()
        }
        for (i in 0 until treasureNum){
            val rn = generateNumber(mTreasure.size) - 1
            inventory.add(mTreasure[rn])
            mCharacter.inventory = inventory
            acquired.add(mTreasure[rn])
            mTreasure.removeAt(rn)
        }
        setUpRecyclerView(acquired)
    }

    private fun levelAdd(){
        mCharacter.level += 1
        tv_level_number.text = mCharacter.level.toString()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == Constants.INVENTORY_REQUEST_CODE){
            mCharacter = data?.getParcelableExtra(Constants.CHARACTER)!!
            playerList[playerTurn] = mCharacter
            Log.i("onActivityResult", playerList[0].name)
        }
    }

    private fun calculateStats(){
        var charm = 0
        var fight = 0
        var run = 0
        if (mCharacter.head != null){
            charm += mCharacter.head!!.charm
            fight += mCharacter.head!!.fight
            run += mCharacter.head!!.run
        }
        if (mCharacter.chest != null){
            charm += mCharacter.chest!!.charm
            fight += mCharacter.chest!!.fight
            run += mCharacter.chest!!.run
        }
        if (mCharacter.legs != null){
            charm += mCharacter.legs!!.charm
            fight += mCharacter.legs!!.fight
            run += mCharacter.legs!!.run
        }
        if (mCharacter.feet != null){
            charm += mCharacter.feet!!.charm
            fight += mCharacter.feet!!.fight
            run += mCharacter.feet!!.run
        }
        if (mCharacter.weapon != null){
            charm += mCharacter.weapon!!.charm
            fight += mCharacter.weapon!!.fight
            run += mCharacter.weapon!!.run
        }
        if (mCharacter.trinket != null){
            charm += mCharacter.trinket!!.charm
            fight += mCharacter.trinket!!.fight
            run += mCharacter.trinket!!.run
        }
        mFight = fight
        mCharm = charm
        mRun = run
    }

    private fun setUpRecyclerView(list : ArrayList<Treasure>){
        rv_treasure_acquired.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rv_treasure_acquired.setHasFixedSize(false)

        val adapter = AcquiredAdapter(this, list)
        rv_treasure_acquired.adapter = adapter
    }
}
