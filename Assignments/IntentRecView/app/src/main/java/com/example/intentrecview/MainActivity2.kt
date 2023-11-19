package com.example.intentrecview

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.intentrecview.databinding.ActivityMain2Binding
import com.example.intentrecview.databinding.ActivityMainBinding


class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras ?: return
        val title = extras.getString("titleString")
        val detail = extras.getString(("detailString"))
        val image = extras.getInt("imageID")

        binding.textView.text = title
        binding.textView2.text = detail
        binding.imageView.setImageDrawable(getDrawable(image))
    }
}