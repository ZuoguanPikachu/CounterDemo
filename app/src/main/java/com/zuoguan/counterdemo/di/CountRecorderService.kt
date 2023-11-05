package com.zuoguan.counterdemo.di

class CountRecorderService {
    private var count = 0;
    init {
        println("new service")
    }
    fun addCount(){
        count += 1
        println(count)
    }

    fun getCount(): Int {
        return count
    }
}