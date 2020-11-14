package uk.co.nightowl.platforms.drinksdragons.models

import android.os.Parcel
import android.os.Parcelable

data class Treasure (
    val name : String,
    val description : String,
    val type : String,
    val rating : Int,
    val fight : Int = 0,
    val charm : Int = 0,
    val run : Int = 0,
    val image : Int
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeString(type)
        parcel.writeInt(rating)
        parcel.writeInt(fight)
        parcel.writeInt(charm)
        parcel.writeInt(run)
        parcel.writeInt(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Treasure> {
        override fun createFromParcel(parcel: Parcel): Treasure {
            return Treasure(parcel)
        }

        override fun newArray(size: Int): Array<Treasure?> {
            return arrayOfNulls(size)
        }
    }
}