package com.example.myapplication

data class ItemModel(val name: String, val imageThumb: Int, val time: String, val subject: String, val content: String, val imageLarge: Int = 0) {
    var selected: Boolean = false
}