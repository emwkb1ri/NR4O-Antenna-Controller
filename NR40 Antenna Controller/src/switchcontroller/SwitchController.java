package switchcontroller;

// Java version of Radio_Ant_Tracker.py
// Reads each of my radios COM ports every .5 secs
// Calculates operating frequency from TX frequency
// Selects ant number based on band lookup table
// Assembles an XML packet in the N1MM+ OTRSP format
// Sends the XML packet via UDP to a LOCALHOST and a remote HOST IP socket port.
// Sends UDP packet every 10 seconds or when an antenna change is detected.
// Monitors keyboard input for 'p' pause, 'r' run, 'q' quit

import java.util.*;

import switchcontroller.DisplayFrame;

import java.io.*;
import java.net.*;

public class SwitchController {

	// Instantiate the application window
    public static DisplayFrame frame = new DisplayFrame();
    
	public static void main(String[] args)
	{

		// create a window with text field

		System.out.println("Running....\n");
		
	}
}