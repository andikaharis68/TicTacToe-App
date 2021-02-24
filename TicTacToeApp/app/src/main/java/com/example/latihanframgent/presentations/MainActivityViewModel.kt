package com.example.latihanframgent.presentations

import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    var player1:String? = null
    var player2:String? = null

    fun setPlayer(p1: String, p2: String){
        player1 = p1
        player2 = p2
    }
}