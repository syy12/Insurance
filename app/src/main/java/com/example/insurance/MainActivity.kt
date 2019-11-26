package com.example.insurance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Toast.makeText(this,"Position =" + position, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinnerAge.onItemSelectedListener = this

        buttonCalculate.setOnClickListener {
            calculatePremium()
        }

        buttonReset.setOnClickListener {
            textViewInsurancePremium.text = null
            spinnerAge.setSelection(0)
            radioGroupGender.clearCheck()
            checkBoxSmoker.isChecked = false
        }
    }

    private fun calculatePremium() {
        val position = spinnerAge.selectedItemPosition
        val gender = radioGroupGender.checkedRadioButtonId
        var premium = 0.0

        premium = when(position){
            0 -> 60.0
            1 -> 70.0
            2 -> 90.0
            3 -> 120.0
            4 -> 150.0
            else -> 150.0
        }

        if(gender == R.id.radioButtonMale){
            premium += when(position){
                0 -> 0.0
                1 -> 50.0
                2 -> 100.0
                3 -> 150.0
                4 -> 200.0
                else -> 200.0
            }
        }

        if(checkBoxSmoker.isChecked){
            premium += when(position){
                0 -> 0.0
                1 -> 100.0
                2 -> 150.0
                3 -> 200.0
                4 -> 250.0
                else -> 300.0
            }
        }



        textViewInsurancePremium.setText(getString(R.string.insurance_premium) + ": RM ${premium}")

    }
}
