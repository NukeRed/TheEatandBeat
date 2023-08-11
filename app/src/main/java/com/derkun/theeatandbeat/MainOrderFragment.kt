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
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.chip.Chip
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar


class MainOrderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)

        val view = inflater.inflate(R.layout.fragment_main_order, container, false)
        val toolbar = view.findViewById<MaterialToolbar>(R.id.toolbar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        return view

        val snackGroup = view.findViewById<RadioGroup>(R.id.radio_group_type_snacks)
        val snackType = snackGroup.checkedRadioButtonId
        if (snackType == -1) {
            println("Choose snack,please!")
        } else if (snackType == 1) {
            val radioColdSnack = view.findViewById<RadioButton>(R.id.cold_snack)
            val radioColdSnackText = "You choose cold snack!Great!"
            Toast.makeText(activity, radioColdSnackText, Toast.LENGTH_LONG).show()
        } else {
            val radioHotSnack = view.findViewById<RadioButton>(R.id.hot_snack)
            val radioColdSnackText = "You choose cold snack!Great!"
            Toast.makeText(activity, radioColdSnackText, Toast.LENGTH_LONG).show()
        }

        val hotDrink = view.findViewById<CheckBox>(R.id.hot_drink)
        if (hotDrink.isChecked) {
            println("You choose hot drink!")
        } else {
            println("You choose cold drink!")
        }

        val fab = view.findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val radio_group_type_snacks = view.findViewById<RadioGroup>(R.id.radio_group_type_snacks)
            val foodType = radio_group_type_snacks.checkedRadioButtonId
            if (foodType ==-1) {
                val noSelectedSnack = "Cold snack selected!"
                Toast.makeText(activity, noSelectedSnack, Toast.LENGTH_LONG).show()
            } else {
                var text = (when (foodType) {
                    R.id.hot_snack -> "Hot Snack"
                    else -> "Cold Snack"
                })
                val colddrink = view.findViewById<Chip>(R.id.cold_drink)
                text += if (colddrink.isChecked) ", cold drink" else ""
                val hotdrink = view.findViewById<Chip>(R.id.hot_drink)
                text += if (hotDrink.isChecked) ", hot drink" else ""
                Snackbar.make(fab, text, Snackbar.LENGTH_LONG).show()
            }
        }
        return view
    }
}