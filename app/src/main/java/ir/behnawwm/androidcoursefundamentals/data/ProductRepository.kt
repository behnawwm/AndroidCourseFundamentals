package ir.behnawwm.androidcoursefundamentals.data

import ir.behnawwm.androidcoursefundamentals.R

object ProductRepository {

    fun provideProducts(): List<Product> {
        return listOf(
            Product("Chair 1", "30$", R.drawable.chair1, 0),
            Product("Chair 2", "40$", R.drawable.chair3, 0),
            Product("Desk 1", "100$", R.drawable.desk2, 1),
            Product("Desk 2", "120$", R.drawable.desk3, 1),
            Product("Desk 3", "130$", R.drawable.desk4, 1),
            Product("Gaming Pc", "1000$", R.drawable.gamingpc, -1),
            Product("Gaming Pc", "1000$", R.drawable.gamingpc, -1),
            Product("Gaming Pc", "1000$", R.drawable.gamingpc, -1),
            Product("Gaming Pc", "1000$", R.drawable.gamingpc, -1),
            Product("Gaming Pc", "1000$", R.drawable.gamingpc, -1),
        )
    }
}