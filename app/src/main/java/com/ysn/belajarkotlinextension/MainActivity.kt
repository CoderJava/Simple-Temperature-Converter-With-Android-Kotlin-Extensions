package com.ysn.belajarkotlinextension

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var TAG: String = "MainActivityTAG"
    private var arrayUnitTemperature: Array<String>? = null
    private var temperature: String = "0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponent()
    }


    private fun initComponent() {
        // do something
        arrayUnitTemperature = arrayOf("C", "F", "K", "R", "Re")
        val arrayAdapterUnitTemperature = ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, arrayUnitTemperature)
        app_compat_spinner_unit_temperature_from_activity_main.adapter = arrayAdapterUnitTemperature
        app_compat_spinner_unit_temperature_to_activity_main.adapter = arrayAdapterUnitTemperature
        app_compat_spinner_unit_temperature_to_activity_main.setSelection(1)
        text_view_unit_temperature_to_activity_main.text = "Fahrenheit"

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
        text_view_value_temperature_to_activity_main.text = "0"
    }

    private fun backspaceTemperatureValueFrom() {
        if (temperature != "0") {
            temperature = temperature.substring(0, temperature.length - 1)
        }
        temperature = if (temperature.isEmpty() || temperature == "-") "0" else temperature
        text_view_value_temperature_from_activity_main.text = temperature
        if (temperature == "0" || temperature == "0.0") {
            text_view_value_temperature_to_activity_main.text = "0"
        }
    }

    private fun updateTemperatureValueFrom(strValue: String) {
        if (strValue == "0") {
            temperature = if (temperature == "0") "0" else temperature.plus(strValue)
        } else if (strValue == ".") {
            temperature = if (!temperature.contains(".")) temperature.plus(strValue) else temperature
        } else {
            temperature = if (temperature == "0") strValue else temperature.plus(strValue)
        }
        Log.d(TAG, "temperature: $temperature")
        text_view_value_temperature_from_activity_main.text = temperature
        if (temperature != "0" && temperature != "0.0") {
            calculateTemperatureConversion()
        } else {
            text_view_value_temperature_to_activity_main.text = "0"
        }
    }

    private fun calculateTemperatureConversion() {
        val unitTemperatureFrom = app_compat_spinner_unit_temperature_from_activity_main.selectedItem.toString()
        val unitTemperatureTo = app_compat_spinner_unit_temperature_to_activity_main.selectedItem.toString()
        Log.d(TAG, "unitTemperatureTo: $unitTemperatureTo")
        val temperatureFrom = temperature.toDouble()
        var temperatureTo: Double = 0.0
        Log.d(TAG, "temperatureFrom: $temperatureFrom && temperatureTo: $temperatureTo")

        if (unitTemperatureFrom == "C") {
            when (unitTemperatureTo) {
                "F" -> {
                    // C x 1,8 + 32
                    temperatureTo = temperatureFrom.times(1.8).plus(32)
                    Log.d(TAG, "temperatureTo new: $temperatureTo")
                }
                "K" -> {
                    // C + 273,15
                    temperatureTo = temperatureFrom.plus(273.15)
                }
                "R" -> {
                    // 1,8 x (C + 496,67)
                    temperatureTo = (temperatureFrom.plus(496.67)).times(1.8)
                }
                "Re" -> {
                    // C x 0,8
                    temperatureTo = temperatureFrom.times(0.8)
                }
                else -> {
                    // nothing to do in here
                }
            }
        } else if (unitTemperatureFrom == "F") {
            when (unitTemperatureTo) {
                "C" -> {
                    // (F - 32) / 1,8
                    temperatureTo = (temperatureFrom.minus(32)).div(1.8)
                }
                "K" -> {
                    // (F + 459,67) / 1,8
                    temperatureTo = (temperatureFrom.plus(459.67)).div(1.8)
                }
                "R" -> {
                    // F + 459,67
                    temperatureTo = temperatureFrom.plus(459.67)
                }
                "Re" -> {
                    // (F - 32) / 2,25
                    temperatureTo = (temperatureFrom.minus(32)).div(2.25)
                }
                else -> {
                    // nothing to do in here
                }
            }
        } else if (unitTemperatureFrom == "K") {
            when (unitTemperatureTo) {
                "C" -> {
                    // K - 273,15
                    temperatureTo = temperatureFrom.minus(273.15)
                }
                "F" -> {
                    // K x 1,8 - 459,67
                    temperatureTo = temperatureFrom.times(1.8).minus(459.67)
                }
                "R" -> {
                    // K x 1,8
                    temperatureTo = temperatureFrom.times(1.8)
                }
                "Re" -> {
                    // (K - 273,15) x 0,8
                    temperatureTo = (temperatureFrom.minus(273.15)).div(0.8)
                }
                else -> {
                    // nothing to do in here
                }
            }
        } else if (unitTemperatureFrom == "R") {
            when (unitTemperatureTo) {
                "C" -> {
                    // R / 1,8 + 273,15
                    temperatureTo = temperatureFrom.div(1.8).plus(273.15)
                }
                "F" -> {
                    // R - 459,67
                    temperatureTo = temperatureFrom.minus(459.67)
                }
                "K" -> {
                    // R / 1,8
                    temperatureTo = temperatureFrom.div(1.8)
                }
                "Re" -> {
                    // (R / 1,8 + 273,15) x 0,8
                    temperatureTo = temperatureFrom.div(1.8).plus(273.15).times(0.8)
                }
                else -> {
                    // nothing to do in here
                }
            }
        } else if (unitTemperatureFrom == "Re") {
            when (unitTemperatureTo) {
                "C" -> {
                    // Re / 0,8
                    temperatureTo = temperatureFrom.div(0.8)
                }
                "F" -> {
                    // Re x 2,25 + 32
                    temperatureTo = temperatureFrom.times(2.25).plus(32)
                }
                "K" -> {
                    // Re / 0,8 + 273,15
                    temperatureTo = temperatureFrom.div(0.8).plus(273.15)
                }
                "R" -> {
                    // Re x 2,25 + 491,67
                    temperatureTo = temperatureFrom.times(2.25).plus(491.67)
                }
                else -> {
                    // nothing to do in here
                }
            }
        }
        text_view_value_temperature_to_activity_main.text = temperatureTo.toString()
    }
}
