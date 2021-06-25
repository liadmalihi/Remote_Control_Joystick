package com.example.remote_control_joystick.model

import java.io.PrintWriter
import java.net.Socket
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingDeque

object model {
    var fg:Socket? = null
    var out:PrintWriter?=null
    private var connect = false
    private var tasks : BlockingQueue<Runnable> = LinkedBlockingDeque()
    fun start(ip:String?,port:String){
        Thread(Runnable {
            this.fg = Socket(ip, port.toInt());
            this.out = PrintWriter(fg!!.getOutputStream(), true)
            connect = true
            while(connect){
                try{
                    tasks.take().run()
                }
                catch (error:InterruptedException){
                }
            }
        }).start()
    }

    fun stopThread(){
        fg?.close()
        out?.close()
        connect=false
    }
    fun send(command:String){
        if(connect) {
            tasks.put(Runnable {
                out?.write(command)
                out?.flush()
            })
        }
    }
}


