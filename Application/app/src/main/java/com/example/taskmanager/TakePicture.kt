package com.example.taskmanager

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import android.Manifest


class TakePicture: AppCompatActivity() {

    private lateinit var imageP: ImageView
    private lateinit var buttonP: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_take_picture)

        imageP = findViewById(R.id.imageP)
        buttonP = findViewById(R.id.buttonP)

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
        != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 100)
        }

        buttonP.setOnClickListener(View.OnClickListener {
            fun onClick(v: View){
                var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(intent,100)
            }
        })
    }

    protected override fun onActivityResult(requestCode: Int, resultCode: Int, @Nullable data: Intent?){
        super.onActivityResult(requestCode, resultCode,data)
        if(requestCode==100){
            val bitmap = data?.extras?.get("data") as Bitmap
            imageP.setImageBitmap(bitmap)
        }
    }

}