package com.example.remote_control_joystick.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider



import com.example.remote_control_joystick.R
import com.example.remote_control_joystick.databinding.ActivityMainBinding
import com.example.remote_control_joystick.view_model.ViewModel


class MainActivity : AppCompatActivity() {
    val vm = ViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this)
            .get(ViewModel::class.java)
        DataBindingUtil.setContentView<ActivityMainBinding>(
            this,R.layout.activity_main
        ).apply{
            this.lifecycleOwner = this@MainActivity
            this.viewmodel = viewModel
        }
        val joystick: JoyStick = findViewById(R.id.joyStick)
        joystick.change={aileron:Float,elevator:Float->
            viewModel.VM_changeAileron(aileron)
            viewModel.VM_changeElevator(elevator)
        }
        val connect: Button = findViewById(R.id.connect)
        connect.setOnClickListener { clicked() }
        val disconnect: Button = findViewById(R.id.dis_connect)
        disconnect.setOnClickListener { clickedDIS() }



    }

    private fun clicked() {

        val ip = findViewById<EditText>(R.id.ip).text.toString()
        val port = findViewById<EditText>(R.id.port).text.toString()
        val ok= Patterns.IP_ADDRESS.matcher(ip).matches()
        if(ok) {
            vm.VM_connect(ip, port)
        }

    }

    private fun clickedDIS() {

        vm.VM_disConnect()

    }
}
