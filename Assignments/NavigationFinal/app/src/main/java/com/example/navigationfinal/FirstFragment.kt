package com.example.navigationfinal

import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.navigationfinal.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button1.setOnClickListener {
            val img = (R.drawable.android_image_1)
            val action: FirstFragmentDirections.MainToSecond =
                FirstFragmentDirections.mainToSecond("",0)

            action.message = "Image One"
            action.image = img
            Navigation.findNavController(it).navigate(action)
        }

        binding.button2.setOnClickListener {
            val img = (R.drawable.android_image_2)
            val action: FirstFragmentDirections.MainToSecond =
                FirstFragmentDirections.mainToSecond("", 0)

            action.message = "Image Two"
            action.image = img

            Navigation.findNavController(it).navigate(action)
        }

        binding.button3.setOnClickListener {
            val img = (R.drawable.android_image_3)
            val action: FirstFragmentDirections.MainToSecond =
                FirstFragmentDirections.mainToSecond("", 0)

            action.message = "Image Three"
            action.image = img
            Navigation.findNavController(it).navigate(action)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        //return inflater.inflate(R.layout.fragment_first, container, false)
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
