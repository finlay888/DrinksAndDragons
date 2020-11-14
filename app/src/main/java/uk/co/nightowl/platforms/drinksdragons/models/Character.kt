package uk.co.nightowl.platforms.drinksdragons.models

import android.os.Parcel
import android.os.Parcelable

data class Character(
    val name: String = "John Snow",
    var level: Int = 1,
    var bFight: Int = 30,
    var bCharm: Int = 30,
    var bRun: Int = 30,
    var head: Treasure? = null,
    var chest: Treasure? = null,
    var legs: Treasure? = null,
    var feet: Treasure? = null,
    var weapon: Treasure? = null,
    var trinket: Treasure? = null,
    var inventory: ArrayList<Treasure> = ArrayList()
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readParcelable(Treasure::class.java.classLoader),
        parcel.readParcelable(Treasure::class.java.classLoader),
        parcel.readParcelable(Treasure::class.java.classLoader),
        parcel.readParcelable(Treasure::class.java.classLoader),
        parcel.readParcelable(Treasure::class.java.classLoader),
        parcel.readParcelable(Treasure::class.java.classLoader),
        parcel.createTypedArrayList(Treasure.CREATOR)!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(level)
        parcel.writeInt(bFight)
        parcel.writeInt(bCharm)
        parcel.writeInt(bRun)
        parcel.writeParcelable(head, flags)
        parcel.writeParcelable(chest, flags)
        parcel.writeParcelable(legs, flags)
        parcel.writeParcelable(feet, flags)
        parcel.writeParcelable(weapon, flags)
        parcel.writeParcelable(trinket, flags)
        parcel.writeTypedList(inventory)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Character> {
        override fun createFromParcel(parcel: Parcel): Character {
            return Character(parcel)
        }

        override fun newArray(size: Int): Array<Character?> {
            return arrayOfNulls(size)
        }
    }
}
