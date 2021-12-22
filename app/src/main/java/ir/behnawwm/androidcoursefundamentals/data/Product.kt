package ir.behnawwm.androidcoursefundamentals.data

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Product(
    val title: String,
    val price: String,
    val photo: Int,
    val category: Int   // 0-> chair     1-> Desk     -1 -> misc
) : Parcelable {

}