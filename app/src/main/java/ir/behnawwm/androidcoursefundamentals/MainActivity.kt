package ir.behnawwm.androidcoursefundamentals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import ir.behnawwm.androidcoursefundamentals.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Creating recyclerview
        val dataList = listOf(
            MainListItem("Chair 1", "30$", R.drawable.chair1, 0),
            MainListItem("Chair 2", "40$", R.drawable.chair3, 0),
            MainListItem("Desk 1", "100$", R.drawable.desk2, 1),
            MainListItem("Desk 2", "120$", R.drawable.desk3, 1),
            MainListItem("Desk 3", "130$", R.drawable.desk4, 1),
            MainListItem("Gaming Pc", "1000$", R.drawable.gamingpc, 2),
            MainListItem("Gaming Pc", "1000$", R.drawable.gamingpc, 2),
            MainListItem("Gaming Pc", "1000$", R.drawable.gamingpc, 2),
            MainListItem("Gaming Pc", "1000$", R.drawable.gamingpc, 2),
            MainListItem("Gaming Pc", "1000$", R.drawable.gamingpc, 2),
        )
        binding.recyclerview.layoutManager = GridLayoutManager(baseContext, 2)
        binding.recyclerview.adapter = MainListAdapter(dataList)


        //Creating Spinner
        val spinnerData = listOf(
            "Desks",
            "Chairs",
            "Misc"
        )
        val spinnerAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerData)
        binding.spinner.adapter = spinnerAdapter

        //todo
//        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onNothingSelected(p0: AdapterView<*>?) {
//                TODO("Not yet implemented")
//            }
//
//        }

    }
}