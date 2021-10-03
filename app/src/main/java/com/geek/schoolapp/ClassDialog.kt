package com.geek.schoolapp

import android.app.ActionBar
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.WindowManager
import android.view.WindowManager.LayoutParams.FLAG_DIM_BEHIND
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
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
            val classList = context.resources.getStringArray(R.array.Class)
            if(dialogBinding.classSpinner.selectedItemPosition!=0){
                val selectedClass = classList[dialogBinding.classSpinner.selectedItemPosition]
                val i = Intent(context,studentList::class.java)
                i.putExtra("class", selectedClass)
                it.context.startActivity(i)
                customDialog.dismiss()
            }else{
                Toast.makeText(context, "HEY Select One of the class !!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}