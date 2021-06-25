package com.example.remote_control_joystick.view_model

import android.widget.SeekBar
import com.example.remote_control_joystick.model.model
import androidx.lifecycle.ViewModel


class ViewModel: ViewModel() {

    fun VM_connect(ip:String,port:String){
        model.start(ip,port)
    }
    fun VM_disConnect(){
        model.stopThread()
    }
    fun onSeekBarChangeR(seekBar: SeekBar,progress:Int,fromUser:Boolean){
        var variable = (progress.toFloat()/100)
        var command = "set /controls/flight/rudder $variable \r\n"
        model.send(command)

    }
    fun onSeekBarChangeT(seekBar: SeekBar,progress:Int,fromUser:Boolean){
        var variable = (progress.toFloat()/100)
        var command = "set /controls/engines/current-engine/throttle $variable \r\n"
        model.send(command)
    }
    fun VM_changeAileron(aileron : Float){
        var command = "set /controls/flight/aileron $aileron \r\n"
        model.send(command)

    }

    fun VM_changeElevator(elevator : Float){
        var command = "set /controls/flight/elevator $elevator \r\n"
        model.send(command)

    }
}