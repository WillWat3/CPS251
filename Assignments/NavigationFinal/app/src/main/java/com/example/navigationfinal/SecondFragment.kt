package com.example.navigationfinal

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.net.Uri
import com.example.navigationfinal.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    override fun onStart() {
        super.onStart()
        arguments?.let {
            val args = SecondFragmentArgs.fromBundle(it)
            val drawable = resources.getDrawable(args.image)
            binding.finalText.text = args.message
            binding.finalView.setImageDrawable(drawable)
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
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}