package org.wadael.kotlinintents

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_qrreader.setOnClickListener(
            object : View.OnClickListener {
                override fun onClick(v: View?) {
                    val goQr = Intent(v?.getContext(), QRCodeActivity::class.java)
                    startActivity(goQr)
                }
            }
        )

        button2.setOnClickListener(
            object : View.OnClickListener {
                override fun onClick(v: View?) {
                    onClickAllerEcran2(v)
                }
            }
        )
    }


    fun onClickAllerEcran2(view: View?) {
        val intent = Intent(this, Ecran2Activity::class.java)  //   /!\
        val radioSelection = etatdame.getCheckedRadioButtonId()

        Log.d("GoScreen2", "radio id= $radioSelection")

        when (radioSelection) {
            rb_c.id -> intent.putExtra(Ecran2Activity.ETAT_D_AME, Ecran2Activity.ETAT_D_AME_CONTENT)
            rb_pc.id -> intent.putExtra(Ecran2Activity.ETAT_D_AME, Ecran2Activity.ETAT_D_AME_PAS_CONTENT)
        }

        if (radioSelection == -1) {
            Toast.makeText(this, "Il faut choisir", Toast.LENGTH_SHORT).show()
        } else
            startActivity(intent)
    }

    fun onClickCallMeMaybe(view: View) {
        val number = Uri.parse("tel:0628080000")
        val callIntent = Intent(Intent.ACTION_DIAL, number)
        startActivity(callIntent)
    }
}
