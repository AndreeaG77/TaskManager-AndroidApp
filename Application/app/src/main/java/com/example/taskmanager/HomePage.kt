package com.example.taskmanager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class HomePage: AppCompatActivity() {

    private var startVideo: VideoView? = null
    private var startMediaController: MediaController? = null
    private lateinit var planButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        planButton = findViewById(R.id.planB)

        planButton.setOnClickListener {
            val intent = Intent(this, NavBar::class.java)
            startActivity(intent)
            /*fun onClick(v: View) {
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, "testets")
                intent.type = "text/plain"

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent)
                }
            }*/
        }

        startVideo = findViewById(R.id.startVideo)

        setUpVideoPlayer()
    }

    private fun setUpVideoPlayer() {
        if (startMediaController == null){
            startMediaController = MediaController(this)
            startMediaController!!.setAnchorView(this.startVideo)
        }

        startVideo!!.setMediaController(startMediaController)

        startVideo!!.setVideoURI(
            Uri.parse("android.resource://"
            + packageName + "/" + R.raw.motivationalquote)
        )

        startVideo!!.requestFocus()

        startVideo!!.pause()

        startVideo!!.setOnCompletionListener {
            Toast.makeText(applicationContext, "End of video", Toast.LENGTH_SHORT).show()
        }

        startVideo!!.setOnErrorListener { mp, what, extra ->
            Toast.makeText(applicationContext, "Oops, error!", Toast.LENGTH_SHORT).show()
            false
        }
    }
}