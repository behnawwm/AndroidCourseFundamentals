package ir.behnawwm.androidcoursefundamentals.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.forEach
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.chip.Chip
import ir.behnawwm.androidcoursefundamentals.data.Product
import ir.behnawwm.androidcoursefundamentals.data.ProductRepository
import ir.behnawwm.androidcoursefundamentals.databinding.ActivityMainBinding
import ir.behnawwm.androidcoursefundamentals.ui.DetailsActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var rvAdapter: MainListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Creating recyclerview
        binding.recyclerview.layoutManager = GridLayoutManager(baseContext, 2)
        val rvItems = ProductRepository.provideProducts().toMutableList()


        rvAdapter = MainListAdapter(rvItems) {
            val intent = Intent(baseContext, DetailsActivity::class.java)
            intent.putExtra("product",it)
            startActivity(intent)
        }
        binding.recyclerview.adapter = rvAdapter

        //setting up chipGroup
        val checkedCategoryIds = mutableSetOf<Int>()

        binding.chipChair.setOnCheckedChangeListener { compoundButton, isActive ->
            if (isActive)
                checkedCategoryIds.add(0)
            else
                checkedCategoryIds.remove(0)

            filterListByCategory(checkedCategoryIds, rvItems)
        }
        binding.chipDesk.setOnCheckedChangeListener { compoundButton, isActive ->
            if (isActive)
                checkedCategoryIds.add(1)
            else
                checkedCategoryIds.remove(1)

            filterListByCategory(checkedCategoryIds, rvItems)
        }
        binding.chipLamp.setOnCheckedChangeListener { compoundButton, isActive ->
            if (isActive)
                checkedCategoryIds.add(2)
            else
                checkedCategoryIds.remove(2)

            filterListByCategory(checkedCategoryIds, rvItems)
        }
        binding.chipMisc.setOnCheckedChangeListener { compoundButton, isActive ->
            if (isActive)
                checkedCategoryIds.add(-1)
            else
                checkedCategoryIds.remove(-1)

            filterListByCategory(checkedCategoryIds, rvItems)
        }

    }

    private fun filterListByCategory(
        checkedCategoryIds: MutableSet<Int>,
        rvItems: MutableList<Product>
    ) {
        rvItems.clear()
        if (checkedCategoryIds.size != 0) {
            checkedCategoryIds.forEach { id ->
                val newItems = ProductRepository.provideProducts().filter {
                    it.category == id
                }
                rvItems.addAll(newItems)
            }
        } else
            rvItems.addAll(ProductRepository.provideProducts())

        rvAdapter.notifyDataSetChanged()

    }
}