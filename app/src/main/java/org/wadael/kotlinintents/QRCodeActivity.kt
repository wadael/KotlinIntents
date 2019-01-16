package org.wadael.kotlinintents

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class QRCodeActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qrcode)

        try {
            val intent = Intent("com.google.zxing.client.android.SCAN")
            intent.putExtra("SCAN_MODE", "QR_CODE_MODE") // "PRODUCT_MODE for bar codes
            startActivityForResult(intent, 0)
        } catch (e: Exception) {
            val marketUri = Uri.parse("market://details?id=com.google.zxing.client.android")
            val marketIntent = Intent(Intent.ACTION_VIEW, marketUri)
            startActivity(marketIntent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 0) {
            if (resultCode == Activity.RESULT_OK) {
                val contents = data.getStringExtra("SCAN_RESULT")
                val tvqr = findViewById<TextView>(R.id.tv_qr)
                tvqr.text = contents
            }

            if (resultCode == Activity.RESULT_CANCELED) {
                //handle cancel
                val layout_qr = findViewById<LinearLayout>(R.id.layout_qr)
                val iv_qr = ImageView(this)
                iv_qr.setImageDrawable(getDrawable(R.drawable.qrcode))
                iv_qr.minimumHeight = 100
                iv_qr.minimumWidth = 100
                iv_qr.visibility = View.VISIBLE
                layout_qr.addView(iv_qr)
            }
        }
    }
}