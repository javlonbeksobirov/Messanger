package com.b12game.messanger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.b12game.messanger.adapter.ChatAdapter
import com.b12game.messanger.model.Chat
import com.b12game.messanger.model.Message
import com.b12game.messanger.model.Room

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setLayoutManager(GridLayoutManager(this,1))

        refreshAdapter(getAllChats())
    }

    fun refreshAdapter(chats: ArrayList<Chat>) {
        val adapter = ChatAdapter(this,chats)
        recyclerView!!.adapter = adapter
    }

    fun getAllChats():ArrayList<Chat>{
        var stories: ArrayList<Room> = ArrayList<Room>()
           stories.add(Room(R.drawable.im_profile,"Sobirov Javlonbek"))


        val chats : ArrayList<Chat> = ArrayList<Chat>()
        chats.add(Chat(stories))
        chats.add(Chat(Message(R.drawable.im_profile,"Sobirov Javlonbek",false)))
        chats.add(Chat(Message(R.drawable.im_profile,"Sobirov Javlonbek",true)))

        return chats

    }
}