package com.zuoguan.counterdemo.route

sealed class Route(val route: String) {
    object Start : Route("start")
    object Main : Route("main")
}