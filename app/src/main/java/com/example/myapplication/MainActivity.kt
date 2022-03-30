package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.calc)
        val height: EditText = findViewById(R.id.num1)
        val weight: EditText = findViewById(R.id.num2)
        val result: TextView = findViewById(R.id.result)
        var flag : String = "male"
        val spinnerVal : Spinner = findViewById(R.id.spinner)
        var options = arrayOf("female","male")
        spinnerVal.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options )
        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
               flag=options.get(p2);
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
            button.setOnClickListener { view ->
                var x: Int = height.text.toString().toInt();
                var y: Int = weight.text.toString().toInt()
                if(flag=="male")
                {
                    result.text = male(x, y).toString();
                }
                else {
                    result.text = female(x, y).toString()
                }

            }
        }
}
    public fun male(a: Int, b: Int): Double {
        return ((a*a)/b).toDouble();
    }
    public fun female(a: Int, b: Int): Double {
    return ((a*a)/b)*0.25;
    }


