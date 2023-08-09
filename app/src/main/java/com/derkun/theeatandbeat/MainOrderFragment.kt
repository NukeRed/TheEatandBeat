package com.derkun.theeatandbeat

import android.animation.LayoutTransition
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar


class MainOrderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)

        val view = inflater.inflate(R.layout.fragment_main_order, container, false)
        val toolbar = view.findViewById<MaterialToolbar>(R.id.collapsing_toolbar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        return view

        val snackGroup =view.findViewById<RadioGroup>(R.id.radio_group_type_snacks)
        val snackType=snackGroup.checkedRadioButtonId
        if (snackType == -1){
            println("Choose snack,please!")
        } else if (snackType == 1){
            val radioColdSnack = view.findViewById<RadioButton>(R.id.cold_snack)
            println("You choose cold snack!Great!")
        } else {
            val radioHotSnack = view.findViewById<RadioButton>(R.id.hot_snack)
            println("You choose hot snack!Great!")
        }

        val hotDrink = view.findViewById<CheckBox>(R.id.hot_drink)
        if (hotDrink.isChecked){
            println("You choose hot drink!")
        }else{
            println("You choose cold drink!")
        }
    }
}