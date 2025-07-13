package com.example.chatapplication

import android.content.IntentSender

class Message {
    var message : String?=null
    var senderId: String?=null
    var timestamp: Long? = null
    constructor(){}

    constructor(message: String?, senderId: String?){
        this.message=message
        this.senderId=senderId
    }

}