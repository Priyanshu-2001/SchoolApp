package com.geek.schoolapp

import android.app.ActionBar
import android.content.Context
import android.view.LayoutInflater
import android.view.WindowManager
import android.view.WindowManager.LayoutParams.FLAG_DIM_BEHIND
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.geek.schoolapp.databinding.ViewDialogBinding

class ClassDialog : AppCompatActivity(){
     fun showCustomDialog(context: Context) {
        val dialogBinding: ViewDialogBinding? =
            DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.view_dialog,
                null,
                false
            )
        val customDialog = AlertDialog.Builder(context, 0).create()
        customDialog.apply {
            setView(dialogBinding?.root)
            setCancelable(true)
        }.show()

        dialogBinding?.btnOk?.setOnClickListener {
            customDialog.dismiss()
        }
    }
}