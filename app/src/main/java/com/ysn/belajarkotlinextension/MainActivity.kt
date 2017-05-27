package com.ysn.belajarkotlinextension

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var temperature: String = "0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponent()
    }

    private fun initComponent() {
        // do something
        val arrayUnitTemperature = arrayOf("C", "F", "K", "R", "Re")
        val arrayAdapterUnitTemperature = ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, arrayUnitTemperature)
        app_compat_spinner_unit_temperature_from_activity_main.adapter = arrayAdapterUnitTemperature
        app_compat_spinner_unit_temperature_to_activity_main.adapter = arrayAdapterUnitTemperature
        app_compat_spinner_unit_temperature_to_activity_main.setSelection(1)
        text_view_unit_temperature_to_activity_main.text="Fahrenheit"

        button_keypad_0_activity_main.setOnClickListener(this)
        button_keypad_1_activity_main.setOnClickListener(this)
        button_keypad_2_activity_main.setOnClickListener(this)
        button_keypad_3_activity_main.setOnClickListener(this)
        button_keypad_4_activity_main.setOnClickListener(this)
        button_keypad_5_activity_main.setOnClickListener(this)
        button_keypad_6_activity_main.setOnClickListener(this)
        button_keypad_7_activity_main.setOnClickListener(this)
        button_keypad_8_activity_main.setOnClickListener(this)
        button_keypad_9_activity_main.setOnClickListener(this)
        button_keypad_backspace_activity_main.setOnClickListener(this)
        button_keypad_ac_activity_main.setOnClickListener(this)
        button_keypad_dot_activity_main.setOnClickListener(this)
        button_keypad_plus_minus_activity_main.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.button_keypad_0_activity_main -> {
                // do something
                updateTemperatureValueFrom("0")
            }
            R.id.button_keypad_1_activity_main -> {
                // do something
                updateTemperatureValueFrom("1")
            }
            R.id.button_keypad_2_activity_main -> {
                // do something
                updateTemperatureValueFrom("2")
            }
            R.id.button_keypad_3_activity_main -> {
                // do something
                updateTemperatureValueFrom("3")
            }
            R.id.button_keypad_4_activity_main -> {
                // do something
                updateTemperatureValueFrom("4")
            }
            R.id.button_keypad_5_activity_main -> {
                // do something
                updateTemperatureValueFrom("5")
            }
            R.id.button_keypad_6_activity_main -> {
                // do something
                updateTemperatureValueFrom("6")
            }
            R.id.button_keypad_7_activity_main -> {
                // do something
                updateTemperatureValueFrom("7")
            }
            R.id.button_keypad_8_activity_main -> {
                // do something
                updateTemperatureValueFrom("8")
            }
            R.id.button_keypad_9_activity_main -> {
                // do something
                updateTemperatureValueFrom("9")
            }
            R.id.button_keypad_backspace_activity_main -> {
                // do something
                backspaceTemperatureValueFrom()
            }
            R.id.button_keypad_ac_activity_main -> {
                // do something
                clearTemperatureValueFrom()
            }
            R.id.button_keypad_dot_activity_main -> {
                // do something
                updateTemperatureValueFrom(".")
            }
            R.id.button_keypad_plus_minus_activity_main -> {
                // do something
                changePlusMinusValueFrom()
            }
            else -> {
                // nothing to do in here
            }
        }
    }

    private fun changePlusMinusValueFrom() {
        // do something
        if (temperature.startsWith("-")) {
            temperature = temperature.replace("-", "")
        } else {
            temperature = "-$temperature"
        }
        temperature = if (temperature == "-0") "0" else temperature
        text_view_value_temperature_from_activity_main.text = temperature
    }

    private fun clearTemperatureValueFrom() {
        temperature = "0"
        text_view_value_temperature_from_activity_main.text = temperature
    }

    private fun backspaceTemperatureValueFrom() {
        if (temperature != "0") {
            temperature = temperature.substring(0, temperature.length-1)
        }
        temperature = if (temperature.isEmpty() || temperature == "-") "0" else temperature
        text_view_value_temperature_from_activity_main.text = temperature
    }

    private fun updateTemperatureValueFrom(strValue: String) {
        if (strValue == "0") {
            temperature = if (temperature == "0") "0" else temperature.plus(strValue)
        } else if (strValue == ".") {
            temperature = if (!temperature.contains(".")) temperature.plus(strValue) else temperature
        } else {
            temperature = if (temperature == "0") strValue else temperature.plus(strValue)
        }
        text_view_value_temperature_from_activity_main.text = temperature
    }
}
