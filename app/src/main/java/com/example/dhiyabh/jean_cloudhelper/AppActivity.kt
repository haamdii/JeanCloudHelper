package com.example.dhiyabh.jean_cloudhelper

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_app.*

class AppActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)
        b.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this, ConnexionActicity::class.java))
            finish()
        }
    }
}
