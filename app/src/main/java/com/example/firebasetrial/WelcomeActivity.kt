package com.example.firebasetrial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.os.postDelayed
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class WelcomeActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        auth = Firebase.auth
        val user = auth.currentUser


        Handler(Looper.getMainLooper()).postDelayed({
            if(user == null){
                val signInActivityIntent = Intent(this@WelcomeActivity , SignInActivity::class.java)
                startActivity(signInActivityIntent)
                finish()
            }
            else{
                val mainActivityIntent = Intent(this , MainActivity::class.java)
                startActivity(mainActivityIntent)
                finish()
            }
        } , 3000)


    }
}