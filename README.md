# Remote_Control_JoyStick - Android App

This is an app which connects to the external software named FlightGear simulator.
The app controls the flight of an airplane from the simulator.

*Collaborators*:

The program was developed by four computer science students at Bar Ilan University, Israel - Liad Malihi and Yeheli Frangi.

*General Description*:

The program connects to the [flight simulator](https://www.flightgear.org/) as a client, and control the airplane values and כlies the plane according to values,
such as: Throttle, Elevator, Aileron and Rudder
The program connects to the simulator with ip and port.

*Code Degins*:

The FlightInseptionApp programmed with the MVVM design using data binding of the Kotlin language, and xml.
You can see the division between the view ,the viewModel and the model of the whole program.

*Features*:
* Slider-Throttle:
You can use the slider to control the flight throttle.

* Slider-Rudder:
You can use the slider to control the flight rudder.

* Joy Stick:
You can control the joy stick movment of the plane dring the flight and control the Aileron and Elevator values according to the joyStick.

???????????????????????????????*Structure project*:

In the main window you can see all the code's files for the app.

Also you can see the UML of the hole project.

In the Images folder you have all the feature to run the app.

In the dll folder you have the algorithms for the dll.

In the files folder you have the xml and csv files to upload in the app.

In the packages folder there is the Oxplot libary - download it to your project.

*How to run the app?*:
* Download the FlightGear app from [here](https://www.flightgear.org/) and open the app.
* In the settings of the app, add those line to the command line:

--telnet=socket,in,10,127.0.0.1,6400,tcp

???????????* Download [this project](https://github.com/ashira-major/FlightDetection) using git clone.
* Make sure you have the Android Studio in your computer.
* start the simulator
* Run the program and follow the instructions to type your PC's IP address and 6400 as a port number.
* Enjoy the flight!

Documentation:
?????????![Image of UML](https://github.com/ashira-major/FlightDetection/blob/master/UML.jpg)
You can see in the UML the MVVM architecture.
You can see the Data Binding and the Property Changed connection in the UML.
?????[Demo of the app running and explanation about the structure of the project](https://youtu.be/AGYCmEJU_LM)
Enjoy!
