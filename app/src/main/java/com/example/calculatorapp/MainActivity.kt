package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberclick(view: View) {
        if(newop){
            displaytxt.setText("")
        }
        newop=false
        val buselect =view as Button
        var buclick:String = displaytxt.text.toString()

        when(buselect.id){
            bu0.id-> buclick +="0"
            bu1.id-> buclick +="1"
            bu2.id-> buclick +="2"
            bu3.id-> buclick +="3"
            bu4.id-> buclick +="4"
            bu5.id-> buclick +="5"
            bu6.id-> buclick +="6"
            bu7.id-> buclick +="7"
            bu8.id-> buclick +="8"
            bu9.id-> buclick +="9"
            budot.id-> buclick +="."
            buplusminus.id -> {
                // TODO: Prevent more than one minus
                buclick = "-" + buclick

            }

        }
        displaytxt.setText(buclick)
    }
    var op ="*"
    var oldnum= ""
    var newop=true
    fun opselect(view: View) {
        val buselect =view as Button
        when(buselect.id){
            bumul.id-> op="*"
            budiv.id-> op="/"
            busub.id-> op="-"
            buadd.id-> op="+"
        }
        oldnum=displaytxt.text.toString()
        newop=true
    }



    fun equalop(view: View) {
        val newnum=displaytxt.text.toString()
        var finalnum:Double?=null

        when(op) {
            "*" -> finalnum = oldnum.toDouble() * newnum.toDouble()
            "/" -> finalnum = oldnum.toDouble() / newnum.toDouble()
            "+" -> finalnum = oldnum.toDouble() + newnum.toDouble()
            "-" -> finalnum = oldnum.toDouble() - newnum.toDouble()
        }
        displaytxt.setText(finalnum.toString())
        newop=true
    }

    fun percentage(view: View) {
        val percent:Double=displaytxt.text.toString().toDouble()/100
        displaytxt.setText(percent.toString())
        newop=true
    }

    fun allclear(view: View) {
        displaytxt.setText("")
        newop=true

    }



}