# Remote Control JoyStick - Android App

This is an app which connects to the external software named FlightGear simulator.
The app controls the flight of an airplane from the simulator.

*Collaborators*:

The program was developed by two computer science students at Bar Ilan University, Israel - Liad Malihi and Yeheli Frangi.

*General Description*:

The program connects to the [flight simulator](https://www.flightgear.org/) as a client, and control the airplane values and flies the plane according to values,
such as: Throttle, Elevator, Aileron and Rudder
The program connects to the simulator with ip and port.

*Code Degins*:

The Remote Control JoyStick programmed with the MVVM design using data binding of the Kotlin language, and xml.
You can see the division between the view ,the viewModel and the model of the whole program.

*Features*:
* Slider-Throttle:
You can use the slider to control the flight throttle.

* Slider-Rudder:
You can use the slider to control the flight rudder.

* Joy Stick:
You can control the joy stick movment of the plane dring the flight and control the Aileron and Elevator values according to the joyStick.

*Structure project*:

In the main window you can see the View,ViewModel and Model files of the app when you get into - app/src/main/java/com/example/remot_control_joystoick.

In the main window you can see the main xaml of the app when you get into - app/src/main/res/layout.

Also you can see the UML of the hole project.


*How to run the app?*:
* Download the FlightGear app from [here](https://www.flightgear.org/) and open the app.
* In the settings of the app, add those line to the command line:

--telnet=socket,in,10,127.0.0.1,6400,tcp

* Download [this project](https://github.com/liadmalihi/Remote_Control_Joystick) using git clone.
* Make sure you have the Android Studio in your computer.
* start the simulator
* Run the program and follow the instructions to type your PC's IP address and 6400 as a port number.
* Enjoy the flight!

Documentation:
![Image of UML](https://github.com/liadmalihi/Remote_Control_Joystick/blob/master/UML.jpg)
You can see in the UML the MVVM architecture.
You can see the Data Binding and the Property Changed connection in the UML.
[Demo of the app running and explanation about the structure of the project](https://www.youtube.com/watch?v=ZHujSPWrEzo)
Enjoy!
