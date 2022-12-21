package com.example.mypractic4

import android.content.Intent
import android.os.Bundle
import android.view.View

import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.mypractic4.databinding.ActivityMain2Binding


class MainAcivity_2 : AppCompatActivity() {
    lateinit var bc: ActivityMain2Binding
    private var sing_state = "empty"

    override fun onCreate(s: Bundle?) {
        super.onCreate(s)
        bc = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(bc.root)
        sing_state = intent.getStringExtra(Constance.SING_STATE)!!
        if (sing_state == Constance.SING_IN_STATE) {
            bc.edName1.visibility = View.GONE
            bc.edName2.visibility = View.GONE
            bc.edName3.visibility = View.GONE
            bc.bAvatar.visibility = View.INVISIBLE

        }


    }

    fun onClickExit(view: View) {
        if (sing_state == Constance.SING_UP_STATE) {
            val intent = Intent()
            intent.putExtra(Constance.LOGIN, bc.edLogin.text.toString())
            intent.putExtra(Constance.PASSWORD, bc.edPassword.text.toString())
            intent.putExtra(Constance.NAME, bc.edName1.text.toString())
            intent.putExtra(Constance.NAME2, bc.edName2.text.toString())
            intent.putExtra(Constance.NAME3, bc.edName3.text.toString())
            if(bc.imAvatar.isVisible)intent.putExtra(Constance.AVATAR_ID, R.drawable.pirog_2)
            setResult(RESULT_OK, intent)
            finish()

        } else if (sing_state == Constance.SING_IN_STATE) {
            val intent = Intent()
            intent.putExtra(Constance.LOGIN, bc.edLogin.text.toString())
            intent.putExtra(Constance.PASSWORD, bc.edPassword.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }

    }

    fun onClickAvatar(view: View) {

        bc.imAvatar.visibility = View.VISIBLE
    }
}