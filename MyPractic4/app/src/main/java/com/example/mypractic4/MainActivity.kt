package com.example.mypractic4

import android.content.Intent
import android.os.Bundle
import android.view.View

import androidx.appcompat.app.AppCompatActivity
import com.example.mypractic4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bc: ActivityMainBinding
    private var login: String = "empty"
    private var password: String = "empty"
    private var name_1: String = "empty"
    private var name_2: String = "empty"
    private var name_3: String = "empty"
    private var IDphoto: Int = 0


    override fun onCreate(s: Bundle?) {
        super.onCreate(s)
        bc = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bc.root)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Constance.key_in) {
            val l = data?.getStringExtra(Constance.LOGIN)
            val p = data?.getStringExtra(Constance.PASSWORD)
            if (login == l && password == p) {

                bc.imPhoto.visibility = View.VISIBLE
                bc.imPhoto.setImageResource(IDphoto)
                val textInfo = "$name_2 $name_1 $name_3"
                bc.textIn.text = textInfo
                bc.bUP.visibility = View.GONE
                bc.btIN.text = "Выйти"


            } else {
                bc.imPhoto.visibility = View.VISIBLE
                bc.textIn.text = "Не существует"
                bc.imPhoto.setImageResource(R.drawable.figa)
            }

        } else if (requestCode == Constance.key_up) {

            login = data?.getStringExtra(Constance.LOGIN)!!
            password = data.getStringExtra(Constance.PASSWORD)!!
            name_1 = data.getStringExtra(Constance.NAME)!!
            name_2 = data.getStringExtra(Constance.NAME2)!!
            name_3 = data.getStringExtra(Constance.NAME3)!!
            IDphoto = data.getIntExtra(Constance.AVATAR_ID, 0)
            bc.imPhoto.visibility = View.VISIBLE
            bc.imPhoto.setImageResource(IDphoto)
            val textInfo = "$name_2 $name_1 $name_3"
            bc.textIn.text = textInfo
            bc.bUP.visibility = View.GONE
            bc.btIN.text = "Выйти"
        }
    }


    fun onClickSingIn (view: View) {

        val intent = Intent(this, MainAcivity_2::class.java)
        intent.putExtra(Constance.SING_STATE, Constance.SING_IN_STATE)
        startActivityForResult(intent, Constance.key_in)
    }

    fun onClickSingUp (view: View) {

        val intent = Intent(this, MainAcivity_2::class.java)
        intent.putExtra(Constance.SING_STATE, Constance.SING_UP_STATE)
        startActivityForResult(intent, Constance.key_up)
    }
}

