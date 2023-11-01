package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mails: Array<String> = arrayOf("Edurila.com",
            "Chris Abad",
            "Tuto.com",
            "support",
            "Matt from lonic",
            "Anh.HT204938@")
        val contents: Array<String> = arrayOf("Are you looking to Learn Web Designin....",
            "Let us know your thoughts! No Images...",
            "Photoshop, SEO, Blender, CSS, WordPr...",
            "SAS OVH-http://www.ovh.com 2 rue K...",
            "Announcing the all-new Creator, buil...",
            "Hello The Anh")
        val subjects: Array<String> = arrayOf("\$19 Only (First 10 spots) - Bestselling...",
            "Help make Campaign Monitor b",
            "8h de formation gratuite et les nouvea...",
            "Société Ovh: suivi de vos services - hp...",
            "The New lonic Creator Is Here!",
            "Hello")
        val items = arrayListOf<ItemModel>()
        val random = Random(5)
        repeat(10) {
            val index = (it + 1)%6
            val iconIndex = random.nextInt().toString()
            items.add(ItemModel(
                mails[index],
                resources.getIdentifier("icon$index", "drawable", packageName),
                "5:$index$index AM",
                subjects[index],
                contents[index]
            ))
        }

        this.findViewById<ListView>(R.id.list_view).adapter = ItemAdapter(items)
    }
}