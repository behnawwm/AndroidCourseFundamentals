package ir.behnawwm.androidcoursefundamentals

data class MainListItem(
    val title: String,
    val price: String,
    val photo: Int,
    val category: Int   // 0-> chair     1-> Desk     2-> misc
)
