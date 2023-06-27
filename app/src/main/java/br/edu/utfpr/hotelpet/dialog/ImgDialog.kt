package br.edu.utfpr.hotelpet.dialog

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import br.edu.utfpr.hotelpet.databinding.ActivityImgDialogBinding
import br.edu.utfpr.hotelpet.extentions.loadImag

class ImgDialog (private val context: Context){
    fun showDialog(whenImageloaded: (imagem : String) -> Unit){
        val bind = ActivityImgDialogBinding.inflate(LayoutInflater.from(context))
        bind.formImgButton.setOnClickListener {
            val url = bind.formImgUri.text.toString()
            bind.formImgImage.loadImag(url)
        }
        AlertDialog.Builder(context)
            .setView(bind.root)
            .setPositiveButton("Ok"){_,_->
            val url = bind.formImgUri.text.toString()
            whenImageloaded(url)
        }
        .setNegativeButton("Cancelar"){_,_->}
        .show()
    }
}