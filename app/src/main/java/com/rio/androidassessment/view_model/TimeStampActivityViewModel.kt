package com.rio.androidassessment.view_model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rio.androidassessment.model.Repository
import java.text.SimpleDateFormat
import java.util.*

class TimeStampActivityViewModel:ViewModel() {
    var repository = Repository()
    var timeFormated = MutableLiveData<String>()
    var timePast = MutableLiveData<String>()

    var topHour = MutableLiveData<String>()
    var topMinute = MutableLiveData<String>()
    var topSecond = MutableLiveData<String>()
    var topMeridian = MutableLiveData<String>()

    var bottomHour = MutableLiveData<String>()
    var bottomMinute = MutableLiveData<String>()
    var bottomSeconds = MutableLiveData<String>()
    var bottomYear = MutableLiveData<String>()
    var bottomMonth = MutableLiveData<String>()
    var bottomdate = MutableLiveData<String>()

    fun triggerTimeStampFinder():Boolean{
        if(topHour.value?.isEmpty() == true || topMinute.value?.isEmpty() == true
            || topSecond.value?.isEmpty() == true ||
            !(topMeridian.value?.toString()?.uppercase() == "AM" || topMeridian.value?.toString()?.uppercase() == "PM")
            || topHour.value.toString().toInt() >12 || topMinute.value.toString().toInt() >59 || topSecond.value.toString().toInt() > 59  ){
            return false
        }
        timeFormated.value = repository.getTimeFormted(
            topHour.value.toString().toInt(),
            topMinute.value.toString().toInt(),
            topSecond.value.toString().toInt(),
            "Meridian",
            topMeridian.value.toString().uppercase()
        )
        return true
    }

    fun triggerTimePastFinder():Boolean{
        if(bottomYear.value?.isEmpty() == true || bottomMonth.value?.isEmpty() == true
            || bottomdate.value?.isEmpty() == true || bottomHour.value?.isEmpty() == true
            || bottomMinute.value?.isEmpty() == true || bottomSeconds.value?.isEmpty() == true
            || bottomYear.value.toString().toInt() > 2022 || bottomMonth.value.toString().toInt() >12
            || bottomdate.value.toString().toInt() >31 || bottomHour.value.toString().toInt() >23
            || bottomMinute.value.toString().toInt() >59 || bottomSeconds.value.toString().toInt() >12 ){
            return false
        }
        val myDate = "${bottomYear.value.toString()}/${bottomMonth.value.toString()}/${bottomdate.value.toString()} " +
                "${bottomHour.value.toString()}:${bottomMinute.value.toString()}:${bottomSeconds.value.toString()}"
        val sdf = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
        val date: Date = sdf.parse(myDate)
        val millis: Long = date.time

        timePast.value = repository.getTimePast(
            currentTimeInMilliSeconds = System.currentTimeMillis(),
            givenTimeInMilliSeconds = millis
        )
        return true
    }
}