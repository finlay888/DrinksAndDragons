package uk.co.nightowl.platforms.drinksdragons.activities

import android.app.Activity
import android.app.DownloadManager
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_inventory.*
import uk.co.nightowl.platforms.drinksdragons.R
import uk.co.nightowl.platforms.drinksdragons.adapters.EquipmentAdapter
import uk.co.nightowl.platforms.drinksdragons.models.Character
import uk.co.nightowl.platforms.drinksdragons.models.Treasure
import uk.co.nightowl.platforms.drinksdragons.objects.Constants
import java.io.File

class InventoryActivity : AppCompatActivity() {

    private var inventory = ArrayList<Treasure>()
    private val head = ArrayList<Treasure>()
    private val chest = ArrayList<Treasure>()
    private val legs = ArrayList<Treasure>()
    private val feet = ArrayList<Treasure>()
    private val weapon = ArrayList<Treasure>()
    private val trinket = ArrayList<Treasure>()

    private var eHead : Treasure? = null
    private var eChest : Treasure? = null
    private var eLegs : Treasure? = null
    private var eFeet : Treasure? = null
    private var eWeapon : Treasure? = null
    private var eTrinket : Treasure? = null
    private lateinit var character : Character

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inventory)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        character = intent.getParcelableExtra<Character>(Constants.CHARACTER)!!
        inventory = character.inventory

        loadGear()

        setUpRecyclerView(inventory)
        separateEquipment(inventory)

        iv_helmet.setOnClickListener {
            setUpRecyclerView(head)
            changeGear()
        }
        iv_chest.setOnClickListener {
            setUpRecyclerView(chest)
            changeGear()
        }
        iv_legs.setOnClickListener {
            setUpRecyclerView(legs)
            changeGear()
        }
        iv_feet.setOnClickListener {
            setUpRecyclerView(feet)
            changeGear()
        }
        iv_weapon.setOnClickListener {
            setUpRecyclerView(weapon)
            changeGear()
        }
        iv_trinket.setOnClickListener {
            setUpRecyclerView(trinket)
            changeGear()
        }

        addStats()
    }

    private fun setUpRecyclerView(treasure: ArrayList<Treasure>){
        val linearLayoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, true)
        linearLayoutManager.stackFromEnd = true
        rv_treasure_list.layoutManager = linearLayoutManager
        rv_treasure_list.setHasFixedSize(false)

        val adapter = EquipmentAdapter(this, treasure)
        rv_treasure_list.adapter = adapter

        adapter.setOnClickListener(object : EquipmentAdapter.OnClickListener {
            override fun onClick(position: Int, model: Treasure) {
                when (model.type) {
                    "h" -> {
                        iv_helmet.setImageResource(model.image)
                        eHead = model
                        character.head = model
                        addStats()
                        changeGear()
                        equipSound()
                    }
                    "c" -> {
                        iv_chest.setImageResource(model.image)
                        eChest = model
                        character.chest = model
                        addStats()
                        changeGear()
                        equipSound()
                    }
                    "l" -> {
                        iv_legs.setImageResource(model.image)
                        eLegs = model
                        character.legs = model
                        addStats()
                        changeGear()
                        equipSound()
                    }
                    "f" -> {
                        iv_feet.setImageResource(model.image)
                        eFeet = model
                        character.feet = model
                        addStats()
                        changeGear()
                        equipSound()
                    }
                    "w" -> {
                        iv_weapon.setImageResource(model.image)
                        eWeapon = model
                        character.weapon = model
                        addStats()
                        changeGear()
                        equipWeaponSound()
                    }
                    "t" -> {
                        iv_trinket.setImageResource(model.image)
                        eTrinket = model
                        character.trinket = model
                        addStats()
                        changeGear()
                        equipSound()
                    }
                }

            }
        })
    }

    private fun addStats(){
        var charm = 0
        var fight = 0
        var run = 0

        if (eHead != null){
            charm += eHead!!.charm
            fight += eHead!!.fight
            run += eHead!!.run
        }
        if (eChest != null){
            charm += eChest!!.charm
            fight += eChest!!.fight
            run += eChest!!.run
        }
        if (eLegs != null){
            charm += eLegs!!.charm
            fight += eLegs!!.fight
            run += eLegs!!.run
        }
        if (eFeet != null){
            charm += eFeet!!.charm
            fight += eFeet!!.fight
            run += eFeet!!.run
        }
        if (eWeapon != null){
            charm += eWeapon!!.charm
            fight += eWeapon!!.fight
            run += eWeapon!!.run
        }
        if (eTrinket != null){
            charm += eTrinket!!.charm
            fight += eTrinket!!.fight
            run += eTrinket!!.run
        }
        fight += character.bFight
        charm += character.bCharm
        run += character.bRun
        tv_charm_stat.text = charm.toString()
        tv_fight_stat.text = fight.toString()
    }

    private fun separateEquipment(list: ArrayList<Treasure>){
        for (i in list){
            when(i.type){
                "h" -> head.add(i)
                "c" -> chest.add(i)
                "l" -> legs.add(i)
                "f" -> feet.add(i)
                "w" -> weapon.add(i)
                "t" -> trinket.add(i)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        changeGear()
    }

    private fun loadGear(){
        if (character.head != null){
            iv_helmet.setImageResource(character.head!!.image)
            eHead = character.head
        }
        if (character.chest != null){
            iv_chest.setImageResource(character.chest!!.image)
            eChest = character.chest
        }
        if (character.legs != null){
            iv_legs.setImageResource(character.legs!!.image)
            eLegs = character.legs
        }
        if (character.feet != null){
            iv_feet.setImageResource(character.feet!!.image)
            eFeet = character.feet
        }
        if (character.weapon != null){
            iv_weapon.setImageResource(character.weapon!!.image)
            eWeapon = character.weapon
        }
        if (character.trinket != null){
            iv_trinket.setImageResource(character.trinket!!.image)
            eTrinket = character.trinket
        }
        addStats()
    }

    private fun changeGear(){
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(Constants.CHARACTER, character)
        setResult(Activity.RESULT_OK, intent)
    }

    private fun equipSound(){
        val media : MediaPlayer? = MediaPlayer.create(this, R.raw.item_equip)
        media?.start()
    }

    private fun equipWeaponSound(){
        val media : MediaPlayer? = MediaPlayer.create(this, R.raw.weapon_equip)
        media?.start()
    }
}
