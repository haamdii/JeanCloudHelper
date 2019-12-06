package com.example.dhiyabh.jean_cloudhelper

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*

class ConnexionActicity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_login)
            auth = FirebaseAuth.getInstance()


            b2.setOnClickListener {
                startActivity(Intent(this,CompteAcitvity::class.java))

            }
            b1.setOnClickListener {
                doLogin()
            }


        }
        private fun doLogin() {
            if ((Patterns.EMAIL_ADDRESS.matcher(e1.text.toString()).matches())&&(!e2.text.toString().isEmpty())) {
                auth.signInWithEmailAndPassword(e1.text.toString(), e2.text.toString())
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                val user = auth.currentUser
                                updateUI(user)
                            } else {

                                updateUI(null)
                            }

                        }
            } else {
                Toast.makeText(baseContext, "vérifier votre compte",
                        Toast.LENGTH_SHORT).show()
            }
        }

        public override fun onStart() {
            super.onStart()
            val currentUser = auth.currentUser
            updateUI(currentUser)
        }

        private fun updateUI(currentUser: FirebaseUser?){
            if(currentUser!=null){
                startActivity(Intent(this,Espace::class.java))
                finish()
            }else{
                Toast.makeText(baseContext, "Connexion echoué.",
                        Toast.LENGTH_SHORT).show()}
        }
    }