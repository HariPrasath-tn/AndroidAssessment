package com.rio.androidassessment.model

class TimePastFinder {
    fun findTimePast(currentTimeInMilliSeconds:Long, givenTimeInMilliSeconds:Long):String{
        var temp = (currentTimeInMilliSeconds-givenTimeInMilliSeconds)/1000
        if(temp/((365*24*3600)) > 0) {
            return "${temp/((365*24*3600))}years ago"
        }
        var days = temp/(24*3600)

        var months = (days/30)
        if(months > 0) {
            return "$months months ago"
        }

        var weeks = days/7
        if(weeks > 0){
            return "$weeks weeks ago"
        }
        if(days > 0) {
            return "$days days ago"
        }

        var hours = temp/3600
        if(hours > 0) {
            return "$hours hours ago"
        }

        var minutes = temp/60

        if(minutes > 0) {
            return "$minutes minutes ago"
        }

        var seconds = temp
        return "$seconds seconds ago"
    }
}