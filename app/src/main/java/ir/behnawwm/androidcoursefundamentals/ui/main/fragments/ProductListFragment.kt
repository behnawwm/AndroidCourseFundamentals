package ir.behnawwm.androidcoursefundamentals.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import ir.behnawwm.androidcoursefundamentals.R
import ir.behnawwm.androidcoursefundamentals.data.Product
import ir.behnawwm.androidcoursefundamentals.data.ProductRepository
import ir.behnawwm.androidcoursefundamentals.databinding.FragmentProductListBinding

class ProductListFragment : Fragment() {

    private lateinit var binding: FragmentProductListBinding
    private lateinit var rvAdapter: MainListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      //Creating recyclerview
        binding.recyclerview.layoutManager = GridLayoutManager(requireContext(), 2)
        val rvItems = ProductRepository.provideProducts().toMutableList()


        rvAdapter = MainListAdapter(rvItems) {
            val action = ProductListFragmentDirections.actionProductListFragmentToProductDetailsFragment(it.id)
            findNavController().navigate(action)

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