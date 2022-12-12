package com.rio.androidassessment.model

import android.util.Log

class TimeFormater {
    private fun timeFromRailwayToMeridian(hour:Int, minute:Int, seconds:Int):String{
        return "${hour%12}:$minute:$seconds ${if(hour/12 == 1){ "PM" }else{ "AM" }}"
    }


    private fun timeFromMeridianToRailway(hour:Int, minute:Int, seconds:Int, meridian: String):String{
        var resultant = ""
        var hour = if(meridian == "AM"){
            "${hour%12}"
        }else{
            "${(12+(hour%12))}"
        }
        if(hour.length == 1){
            hour = "0$hour"
        }
        resultant += "$hour:$minute:$seconds"
        return resultant
    }

    fun formatTimeAndReturn(hour:Int, minute:Int, seconds:Int, timeType:String, meridian:String=""):String{
        if (timeType == "Meridian"){
            return timeFromMeridianToRailway(hour, minute, seconds, meridian)
        }
        return timeFromRailwayToMeridian(hour, minute, seconds)
    }
}

private fun timeFromRailwayToMeridian(hour:Int, minute:Int, seconds:Int):String{
    return "${hour%12}:$minute:$seconds ${if(hour/12 == 1){ "PM" }else{ "AM" }}"
}


private fun timeFromMeridianToRailway(hour:Int, minute:Int, seconds:Int, meridian: String):String{
    var resultant = ""
    resultant += if(meridian == "AM"){
        "${hour%12}"
    }else{
        "${12+hour}"
    }
    resultant += ":$minute:$seconds"
    return resultant
}

fun formatTimeAndReturn(hour:Int, minute:Int, seconds:Int, timeType:String, meridian:String=""):String{
    if (timeType == "Meridian"){
        return timeFromMeridianToRailway(hour, minute, seconds, meridian)
    }
    return timeFromRailwayToMeridian(hour, minute, seconds)
}
fun main(){
    println(formatTimeAndReturn(12, 50, 33, "Meridian", "AM"))
    println(formatTimeAndReturn(12, 22, 33, "Meridian", "PM"))
    println(formatTimeAndReturn(19, 22, 33, "Railway"))
}