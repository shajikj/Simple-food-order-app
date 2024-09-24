package com.shaji.finfood

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var emailField: EditText
    private lateinit var passwordField: EditText
    private lateinit var loginButton: Button
    private lateinit var signupLink: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        emailField = findViewById(R.id.email)
        passwordField = findViewById(R.id.password)
        loginButton = findViewById(R.id.login_button)
        signupLink = findViewById(R.id.signup_link)

       /* loginButton.setOnClickListener {
            // Handle login logic here
            startActivity(Intent(this, OrderActivity::class.java))
        }*/
        loginButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                val intent = Intent(this@LoginActivity, OrderActivity::class.java)
               /* intent.putExtra("Username", "John Doe")*/

                startActivity(intent)
            }

        })

        signupLink.setOnClickListener {
            // Navigate to signup screen
            startActivity(Intent(this, SignupActivity::class.java))
        }

    }
}