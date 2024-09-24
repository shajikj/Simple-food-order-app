package com.shaji.finfood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SignupActivity : AppCompatActivity() {
    private lateinit var nameField: EditText
    private lateinit var emailField: EditText
    private lateinit var passwordField: EditText
    private lateinit var confirmPasswordField: EditText
    private lateinit var signupButton: Button
    private lateinit var loginLink: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        nameField = findViewById(R.id.name)
        emailField = findViewById(R.id.email)
        passwordField = findViewById(R.id.password)
        confirmPasswordField = findViewById(R.id.confirm_password)
        signupButton = findViewById(R.id.signup_button)
signupButton.setOnClickListener(object : View.OnClickListener {
    override fun onClick(view: View?) {
        val intent = Intent(this@SignupActivity, OrderActivity::class.java)
        /* intent.putExtra("Username", "John Doe")*/

        startActivity(intent)
    }

})

    }
}