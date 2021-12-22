package ir.behnawwm.androidcoursefundamentals.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.behnawwm.androidcoursefundamentals.R
import ir.behnawwm.androidcoursefundamentals.data.Product
import ir.behnawwm.androidcoursefundamentals.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val product = intent.extras?.getParcelable<Product>("product")!!

        binding.apply {
            tvTitle.text = product.title
            tvPrice.text = product.price
            tvDesc.text = product.category.toString()
            ivPhoto.background = resources.getDrawable(product.photo, baseContext.theme)
        }
    }
}