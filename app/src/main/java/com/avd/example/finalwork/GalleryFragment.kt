package com.avd.example.finalwork

import android.graphics.Picture
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

private const val LAST_IMAGE = "Image"

class GalleryFragment : Fragment() {

    lateinit var imageFlower: ImageView
    lateinit var imageButton: Button

    private val flowerList: List<Int> = listOf(
        R.drawable.picture_1,
        R.drawable.picture_2,
        R.drawable.picture_3,
        R.drawable.picture_4,
        R.drawable.picture_5
    )
    var lastImageRes = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_gallery, container, false)

        imageFlower = view.findViewById(R.id.picture_1)
        imageButton = view.findViewById(R.id.choose_picture_1)

        if (savedInstanceState != null)

            imageFlower.setImageResource(savedInstanceState.getInt(LAST_IMAGE))
        imageButton.setOnClickListener {
            lastImageRes = flowerList.random()
            imageFlower.setImageResource(lastImageRes)
        }

        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_IMAGE, lastImageRes)
    }


}