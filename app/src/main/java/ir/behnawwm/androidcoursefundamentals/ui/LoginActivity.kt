package ir.behnawwm.androidcoursefundamentals.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.behnawwm.androidcoursefundamentals.common.Constants
import ir.behnawwm.androidcoursefundamentals.databinding.ActivityLoginBinding
import ir.behnawwm.androidcoursefundamentals.ui.main.MainActivity


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnLogin = binding.btnLogin
        val etEmail = binding.etEmail
        val etPassword = binding.etPassword

        val sharedPref = getSharedPreferences(Constants.pref_name, Context.MODE_PRIVATE)
        if (sharedPref.getBoolean(Constants.pref_is_user_logged_in, false)) {
            //yani user ghablan login shode!
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.tvCreateAccount.setOnClickListener {
            //intent to register activity
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {
            //karamoono anjam midim vaghti button click shod
            val emailText = etEmail.text.toString()
            val passwordText = etPassword.text.toString()

            val emailFromPref = sharedPref.getString(Constants.pref_string_user_email, "")
            val passwordFromPref = sharedPref.getString(Constants.pref_string_user_password, "")

            if (emailText == emailFromPref
                && passwordText == passwordFromPref
            ) {
                sharedPref.edit().apply {
                    putBoolean(Constants.pref_is_user_logged_in, true)
                    apply()
                }
                startActivity(Intent(this, MainActivity::class.java))
            }
        }


    }
}