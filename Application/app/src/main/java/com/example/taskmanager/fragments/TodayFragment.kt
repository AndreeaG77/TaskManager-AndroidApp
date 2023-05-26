package com.example.taskmanager.fragments

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.taskmanager.HomePage
import com.example.taskmanager.R
import com.example.taskmanager.RVPage
import com.example.taskmanager.RecyclerAdapter
import android.graphics.Bitmap
import android.provider.MediaStore
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity

/**
 * A simple [Fragment] subclass.
 * Use the [TodayFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TodayFragment : Fragment() {

    private lateinit var button: Button
    private lateinit var imageP: ImageView
    private lateinit var buttonP: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_today, container, false)

        button = view.findViewById(R.id.add_button)
        buttonP = view.findViewById(R.id.buttonP)
        imageP = view.findViewById(R.id.imageP)

        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(requireActivity(), arrayOf(Manifest.permission.CAMERA), 100)
        }

        button.setOnClickListener {
            val intent = Intent(requireContext(), RVPage::class.java)
            startActivity(intent)
        }

        buttonP.setOnClickListener{
                var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(intent,100)
        }

        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, @Nullable data: Intent?){
        super.onActivityResult(requestCode, resultCode,data)
        if(requestCode==100){
            val bitmap = data?.extras?.get("data") as Bitmap
            imageP.setImageBitmap(bitmap)
        }
    }
}