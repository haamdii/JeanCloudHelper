package com.example.dhiyabh.jean_cloudhelper

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_compte_acitvity.*

class CompteAcitvity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compte_acitvity)
        auth = FirebaseAuth.getInstance()


        b.setOnClickListener{
            signUpUser()
        }
    }
    private fun signUpUser() {


        if ((Patterns.EMAIL_ADDRESS.matcher(et1.text.toString()).matches())&&(!e2.text.toString().isEmpty())) {


            auth.createUserWithEmailAndPassword(et1.text.toString(), e2.text.toString())
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            startActivity(Intent(this, ConnexionActicity::class.java))
                            finish()
                        } else {
                            Toast.makeText(baseContext, "Connexion échoué. vérifier votre données.",
                                    Toast.LENGTH_SHORT).show()
                        }

                    }
        } else {

            Toast.makeText(baseContext, "vérifier votre données.",
                    Toast.LENGTH_SHORT).show()

        }
    }}

