package ir.behnawwm.androidcoursefundamentals.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import ir.behnawwm.androidcoursefundamentals.data.Product
import ir.behnawwm.androidcoursefundamentals.data.ProductRepository
import ir.behnawwm.androidcoursefundamentals.databinding.FragmentProductDetailsBinding

class ProductDetailsFragment : Fragment() {

    private lateinit var binding:FragmentProductDetailsBinding
    val args: ProductDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val product =ProductRepository.provideProducts()[args.selectedProductId]

        binding.apply {
            tvTitle.text = product.title
            tvPrice.text = product.price
            tvDesc.text = product.category.toString()
            ivPhoto.background = resources.getDrawable(product.photo, requireContext().theme)
        }

    }

}