package com.rio.androidassessment.model

class Repository {

    fun getTimeFormted(hour:Int, minute:Int, seconds:Int, timeType:String, meridian:String):String{
        return TimeFormater().formatTimeAndReturn(hour, minute, seconds, timeType, meridian)
    }

    fun getTimePast(currentTimeInMilliSeconds:Long, givenTimeInMilliSeconds:Long):String{
        return TimePastFinder().findTimePast(currentTimeInMilliSeconds, givenTimeInMilliSeconds)
    }
}