package com.example.taskmanager.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.taskmanager.R

/**
 * A simple [Fragment] subclass.
 * Use the [YesterdayFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class YesterdayFragment : Fragment() {

    private lateinit var buttonShare: Button
    private lateinit var buttonDone: Button
    private lateinit var intent: Intent

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_yesterday, container, false)

        buttonShare = view.findViewById(R.id.share_button)
        buttonDone = view.findViewById(R.id.done)
        var number_stars = buttonDone.text.toString()
        val startIndex = number_stars.indexOf("Done:") + "Done:".length
        val endIndex = number_stars.indexOf("/")
        val numberStars = number_stars.substring(startIndex, endIndex).trim()

        buttonShare.setOnClickListener {
            //fun onClick(v: View) {
            Toast.makeText(requireContext(), "$numberStars stars", Toast.LENGTH_SHORT).show()
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, "$numberStars stars")
            intent.type = "text/plain"

            if(intent.resolveActivity(requireActivity().packageManager) != null){
                startActivity(intent)
            }

           // }
        }

        return view
    }


}