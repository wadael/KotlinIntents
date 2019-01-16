package org.wadael.kotlinintents


import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_ecran2.*


class Ecran2Activity : Activity() {
    companion object {
        const val ETAT_D_AME = "etadame"
        const val ETAT_D_AME_CONTENT = "youpi"
        const val ETAT_D_AME_PAS_CONTENT = "pakontan"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ecran2)

        var tonEtatDAme = intent.getStringExtra(ETAT_D_AME)
        var rotate = AnimationUtils.loadAnimation(this, R.anim.rotate_pic)
        imageView.startAnimation(rotate)

        when (tonEtatDAme) {
            ETAT_D_AME_CONTENT -> {
                imageView.setImageResource(R.drawable.happy)
                Log.d(ETAT_D_AME, "happy")
            }
            ETAT_D_AME_PAS_CONTENT -> {
                imageView.setImageResource(R.drawable.nothappy)
                Log.d(ETAT_D_AME, "not happy")
            }
        }
        Log.d(ETAT_D_AME, "Valeur: $tonEtatDAme")
        Log.d(ETAT_D_AME, "Fin")
    }


}