package com.example.taskmanager

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


//import com.example.taskmanager.databinding.ActivityAnimationPageBinding

class AnimationPage : AppCompatActivity() {

    //private lateinit var binding: ActivityAnimationPageBinding
    private lateinit var toDoList: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_page)
       // binding = ActivityAnimationPageBinding.inflate(layoutInflater)

        toDoList = findViewById(R.id.toDoList)
        var AnimatetoDoList = ObjectAnimator.ofFloat(toDoList, "translationY", 800f)
        AnimatetoDoList.duration = 3000
        AnimatetoDoList.start()
        toDoList.alpha = 0f
        toDoList.animate().setDuration(2600).alpha(1f).withEndAction{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }
    }
}