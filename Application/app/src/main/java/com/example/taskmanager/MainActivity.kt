package com.example.taskmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

/* import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import android.view.View
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.facebook.CallbackManager
import com.facebook.login.LoginResult
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import com.example.androidapp.databinding.ActivityMainBinding
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.GraphRequest
import org.json.JSONObject*/

class MainActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usernameEditText = findViewById(R.id.username)
        passwordEditText = findViewById(R.id.password)
        loginButton = findViewById(R.id.loginB)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (username == "admin" && password == "admin") {
                val intent = Intent(this, HomePage::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        }
    }
    /* var TAG = "andreeag"
    lateinit var mainBinding: ActivityMainBinding
    lateinit var callbackManager: CallbackManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main) as ActivityMainBinding
        callbackManager = CallbackManager.Factory.create()
        mainBinding.loginB.setReadPermissions(listOf("email", "user_name"))
        mainBinding.loginB.registerCallback(callbackManager,object:
            FacebookCallback<LoginResult> {
            override fun onCancel() {
                TODO("Not yet implemented")
            }

            override fun onError(error: FacebookException) {
                TODO("Not yet implemented")
            }

            override fun onSuccess(result: LoginResult) {
                val graphRequest = GraphRequest.newMeRequest(result?.accessToken){`object`, response->
                    getFacebookData(`object`)
                }
                val parameters = Bundle()
                parameters.putString("fields", "id, user_name, email")
                graphRequest.parameters = parameters
                graphRequest.executeAsync()
            }
        })

       printHashKey()
       val username: TextView = findViewById(R.id.username)
       val password: TextView = findViewById(R.id.password)
       val loginB: MaterialButton = findViewById(R.id.loginB)

        loginB.setOnClickListener{
           fun onClick(view: View){
              if(username.text.toString().equals("admin") && password.text.toString().equals("admin")){
                  Toast.makeText(this, "LOGIN SUCCESFUL", Toast.LENGTH_SHORT).show()
              } else{
                 Toast.makeText(this, "LOGIN FAILED", Toast.LENGTH_SHORT).show()
             }
          }
        }
    }

    private fun getFacebookData(obj: JSONObject?) {
        val profilePic = "https://graph.facebook.com/${obj?.getString("id")}/picture?width=200&height=200"

        Glide.with(this)
            .load(profilePic)
            .into(mainBinding.imgAvatar)
        val name = obj?.getString("user_name")
        val email = obj?.getString("email")
        mainBinding.tvName.text = "USER_NAME: ${name}"
        mainBinding.tvEmail.text = "EMAIL: ${email}"
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager.onActivityResult(requestCode,resultCode,data)
    }

    fun printHashKey() {
        try {
            val info: PackageInfo = this.packageManager.getPackageInfo(this.packageName, PackageManager.GET_SIGNATURES)
            for (signature in info.signatures) {
                val md: MessageDigest = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                val hashKey = String(Base64.encode(md.digest(),0))
                Log.d(TAG, "printHashKey() Hash Key: $hashKey")
            }
        } catch (e: NoSuchAlgorithmException) {
            Log.d(TAG, "printHashKey()", e)
        } catch (e: Exception) {
            Log.d(TAG, "printHashKey()", e)
        }
    } */
}