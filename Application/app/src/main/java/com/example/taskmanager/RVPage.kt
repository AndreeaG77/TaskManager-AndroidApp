package com.example.taskmanager

import android.app.Activity
import android.content.ClipData.Item
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskmanager.fragments.TodayFragment

class RVPage : AppCompatActivity() {

    private var titleList = mutableListOf<String>()
    //private var descList = mutableListOf<String>()
    private var imagesList = mutableListOf<Int>()
    private lateinit var rv_recyclerView1 : androidx.recyclerview.widget.RecyclerView

    val tl = mutableListOf("Work", "Chores", "Workout", "Study", "Relax Time", "Hobby")
    val il = mutableListOf(R.drawable.baseline_work_history_24,R.drawable.baseline_house_24, R.drawable.baseline_directions_bike_24, R.drawable.baseline_school_24, R.drawable.baseline_free_breakfast_24, R.drawable.baseline_auto_awesome_24)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rv_page)

        postToList()

        rv_recyclerView1 = findViewById(R.id.rv_recyclerView)
        rv_recyclerView1.layoutManager = LinearLayoutManager(this)

        rv_recyclerView1.adapter = RecyclerAdapter(titleList,imagesList)
        //rv_recyclerView1.adapter = adapter
    }
    private fun addToList(title: String, image: Int){
        titleList.add(title)
        //descList.add(description)
        imagesList.add(image)
    }

    private fun postToList() {
        for (i in 0..5){
            var title = tl[i]
            var vectorDrawable = il[i]
            addToList("$title", vectorDrawable)
        }
    }

}
