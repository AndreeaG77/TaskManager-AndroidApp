package com.example.taskmanager

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ShareFunction : AppCompatActivity() {

    private lateinit var buttonShare: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_function)

        buttonShare = findViewById(R.id.buttonShare)
        buttonShare.setOnClickListener {
            fun onClick(v: View) {
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, "testets")
                intent.type = "text/plain"

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent)
                }
            }
        }
    }
}