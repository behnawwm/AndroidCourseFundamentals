package ir.behnawwm.androidcoursefundamentals

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.behnawwm.androidcoursefundamentals.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPref = getSharedPreferences(Constants.pref_name, Context.MODE_PRIVATE)

        binding.apply {
            btnLogin.setOnClickListener {
                val username = etUsername.text.toString()
                val email = etEmail.text.toString()
                val password = etPassword.text.toString()
                val confirmPassword = etConfirmPassword.text.toString()

                if (username.isNullOrEmpty())
                    etUsername.error = "Username should not be empty"

                if (email.isNullOrEmpty())
                    etEmail.error = "Email should not be empty"

                if (!username.isNullOrEmpty()
                    && !email.isNullOrEmpty()
                    && (password == confirmPassword)
                ) {
                    //save username password
                    sharedPref.edit().apply {
                        putString(Constants.pref_string_user_username, username)
                        putString(Constants.pref_string_user_email, email)
                        putString(Constants.pref_string_user_password, password)
                        apply()
                    }
                    startActivity(Intent(baseContext, LoginActivity::class.java))
                }


            }


        }


    }
}