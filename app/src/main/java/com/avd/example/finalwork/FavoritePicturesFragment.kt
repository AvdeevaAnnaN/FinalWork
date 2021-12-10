package com.avd.example.finalwork

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FavoritePicturesFragment : Fragment() {

    lateinit var favoriteFlowersList: RecyclerView
    lateinit var sendButton: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_favorite_pictures, container, false)

        val flowersNames: List<String> =
            listOf("Vanda", "Falenopsis", "Miltonia", "Dendrobium", "Kattlea")

        sendButton = view.findViewById(R.id.send_my_list_pictures)

        favoriteFlowersList = view.findViewById(R.id.list_favorite_pictures)
        favoriteFlowersList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        favoriteFlowersList.adapter = FlowersListAdapter(flowersNames)



        sendButton.setOnClickListener {
            val link = Uri.parse("https://google.com")
            val intent = Intent(Intent.ACTION_VIEW, link)
            context?.startActivity(intent)

        }




        return view
    }


}