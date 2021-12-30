package ir.behnawwm.androidcoursefundamentals.data

import ir.behnawwm.androidcoursefundamentals.R

object ProductRepository {

    fun provideProducts(): List<Product> {
        return listOf(
            Product(0,"Chair 1", "30$", R.drawable.chair1, 0),
            Product(1,"Chair 2", "40$", R.drawable.chair3, 0),
            Product(2,"Desk 1", "100$", R.drawable.desk2, 1),
            Product(3,"Desk 2", "120$", R.drawable.desk3, 1),
            Product(4,"Desk 3", "130$", R.drawable.desk4, 1),
            Product(5,"Gaming Pc", "1000$", R.drawable.gamingpc, -1),
            Product(6,"Gaming Pc", "1000$", R.drawable.gamingpc, -1),
        )
    }
}