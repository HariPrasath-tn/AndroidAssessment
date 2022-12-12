package com.rio.androidassessment.view

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.rio.androidassessment.R
import com.rio.androidassessment.databinding.ActivityTimeStampBinding
import com.rio.androidassessment.view_model.TimeStampActivityViewModel
import java.util.*

class TimeStampActivity : AppCompatActivity(), OnClickListener {
    private lateinit var viewModel:TimeStampActivityViewModel
    private lateinit var binding:ActivityTimeStampBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_time_stamp)
        viewModel = ViewModelProvider(this)[TimeStampActivityViewModel::class.java]
        binding.topButton.setOnClickListener(this)
        binding.bottomButton.setOnClickListener(this)
        binding.data = viewModel
        binding.lifecycleOwner = this
    }

    override fun onClick(v: View?) {
        binding.apply {
            when(v){
                topButton ->{
                    if(!viewModel.triggerTimeStampFinder()){
                        Toast.makeText(this@TimeStampActivity, "Enter all Data correctly to find the Time Format", Toast.LENGTH_SHORT).show()
                    }
                }

                bottomButton->{
                    if(!viewModel.triggerTimePastFinder()){
                        Toast.makeText(this@TimeStampActivity, "Enter all Data correctly to find the time Past", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}