package com.example.remote_control_joystick.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

import kotlin.math.min
import kotlin.math.sqrt



class JoyStick @JvmOverloads constructor(
    context : Context, attrs: AttributeSet?=null, defStyleAttr: Int=0) : View(context,attrs,defStyleAttr) {
    private var radius:Float = 0f
    private var center: PointF = PointF()
    private var iniCenter:PointF= PointF()
    private var initRadius:Float = 0f
    private var aileron: Float = 0f
    private var elevator: Float = 0f
    lateinit var change: (Float, Float) -> Unit
    private var paintInner= Paint().apply{
        style = Paint.Style.FILL_AND_STROKE
        color = Color.argb(180,200,100,150)
        isAntiAlias = true
    }
    private var paintOut = Paint().apply{
        style = Paint.Style.FILL_AND_STROKE
        color = Color.argb(170,150,110,250)
        isAntiAlias = true
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawCircle(iniCenter.x,iniCenter.y,(initRadius.toFloat()),paintOut)
        canvas.drawCircle(center.x,center.y,radius,paintInner)
    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        radius = 0.15f* min(w,h).toFloat()
        initRadius = 0.3f* min(w,h).toFloat()
        center = PointF(w/2.0f,h/2f)
        iniCenter =PointF(w/2.0f,h/2f)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if(event == null){
            return true
        }
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> touchMove(event.x, event.y)
            MotionEvent.ACTION_MOVE -> touchMove(event.x, event.y)
            MotionEvent.ACTION_UP -> touchUp(iniCenter.x, iniCenter.y)
        }
        //}
        return true
    }

    private fun touchUp(x: Float, y: Float) {
        this.center.x = x
        this.center.y = y
        invalidate()
    }


    private fun touchMove(x: Float, y: Float) {
        var dis=sqrt(((x-iniCenter.x)*(x-iniCenter.x))+((y-iniCenter.y)*(y-iniCenter.y)))
        if(dis<=initRadius){
            this.center.x = x
            this.center.y = y
            this.elevator=(y-iniCenter.y)/initRadius
            this.aileron=(x-iniCenter.x)/initRadius
            change(aileron,elevator)
        }
        else{
            var ratio=initRadius/dis
            this.center.x=iniCenter.x+(x-iniCenter.x)*ratio
            this.center.y=iniCenter.y+(y-iniCenter.y)*ratio
            this.elevator=(center.y-iniCenter.y)/initRadius
            this.aileron=(center.x-iniCenter.x)/initRadius
            change(aileron,elevator)
        }
        invalidate()
    }
}