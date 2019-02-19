package switchcontroller;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

import java.awt.event.*;

// Extends JFrame so it can create frames

public class DisplayFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static JTextArea textArea1;
	
	JButton button0;
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	JButton button6;
	JButton button7;
	JButton button8;
	
	int button0Clicked;
	int button1Clicked;
	int button2Clicked;
	int button3Clicked;
	int button4Clicked;
	int button5Clicked;
	int button6Clicked;
	int button7Clicked;
	int button8Clicked;
	
	static boolean runFlag = true;
	static boolean swapflag = false;
		
	public DisplayFrame(){
		
		// Define the size of the frame
		this.setSize(650, 200);
		
		// Toolkit is the super class for the Abstract Window Toolkit
		// It allows us to ask questions of the OS
				
		Toolkit tk = Toolkit.getDefaultToolkit();
				
		// A Dimension can hold the width and height of a component
		// getScreenSize returns the size of the screen
				
		Dimension dim = tk.getScreenSize();
				
		// dim.width returns the width of the screen
		// this.getWidth returns the width of the frame you are making

		// set the window position to top right of screen
		int xPos = (dim.width) - (this.getWidth());
		// int yPos = (dim.height / 2) - (this.getHeight() / 2);
		int yPos = 10;
				 
		// You could also define the x, y position of the frame
				 
		this.setLocation(xPos, yPos);
		
		// Define how the frame exits (Click the Close Button)
		// Without this Java will eventually close the app
				
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		// Define the title for the frame
				
		this.setTitle("Remote Ant-Switch Controller");
				
		// The JPanel contains all of the components for your frame
				
		JPanel thePanel = new JPanel();
		
		// How to add a text area ----------------------
		/* Text area not needed at this time
		 * 
		textArea1 = new JTextArea(20, 30);
				
		// Set the default text for the text area
				
		// textArea1.setText("Program output goes here - eventually\n");
				
		// If text doesn't fit on a line, jump to the next
		
		textArea1.setLineWrap(true);
		
		// Makes sure that words stay intact if a line wrap occurs
				
		textArea1.setWrapStyleWord(true);
				
		// Adds scroll bars to the text area ----------
				
		JScrollPane scrollbar1 = new JScrollPane(textArea1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				
		// Other options: VERTICAL_SCROLLBAR_ALWAYS, VERTICAL_SCROLLBAR_NEVER, VERTICAL_SCROLLBAR_AS_NEEDED
				
		thePanel.add(scrollbar1);
		*/
		
		// Create an instance of ListenForEvents to handle events
		
		ListenForButton lForButton = new ListenForButton();
		
		// Create a button with "Radio 1" on it
		
		button0 = new JButton("Radio 1");
		
		// Tell Java that you want to be alerted when an event
		// occurs on the button
		
		button0.addActionListener(lForButton);
		
		thePanel.add(button0);
		
		// Create a button with "1" on it
		
		button1 = new JButton("- 1 -");
		
		// Tell Java that you want to be alerted when an event
		// occurs on the button
		
		button1.addActionListener(lForButton);
		
		thePanel.add(button1);
		
		// Create a button with "- 2 -" on it
		
		button2 = new JButton("- 2 -");
		
		// Tell Java that you want to be alerted when an event
		// occurs on the button
		
		button2.addActionListener(lForButton);
		
		thePanel.add(button2);
		
		// Create a button with "- 3 -" on it
		
		button3 = new JButton("- 3 -");
		
		// Tell Java that you want to be alerted when an event
		// occurs on the button
		
		button3.addActionListener(lForButton);
		
		thePanel.add(button3);
		
		// Create a button with "- 3 -" on it
		
		button4 = new JButton("- 4 -");
		
		// Tell Java that you want to be alerted when an event
		// occurs on the button
		
		button4.addActionListener(lForButton);
		
		thePanel.add(button4);
		
		// Create a button with "- 5 -" on it
		
		button5 = new JButton("- 5 -");
		
		// Tell Java that you want to be alerted when an event
		// occurs on the button
		
		button5.addActionListener(lForButton);
		
		thePanel.add(button5);
		
		// Create a button with "- 6 -" on it
		
		button6 = new JButton("- 6 -");
		
		// Tell Java that you want to be alerted when an event
		// occurs on the button
		
		button6.addActionListener(lForButton);
		
		thePanel.add(button6);
		
		// Create a button with "- 7 -" on it
		
		button7 = new JButton("- 7 -");
		
		// Tell Java that you want to be alerted when an event
		// occurs on the button
		
		button7.addActionListener(lForButton);
		
		thePanel.add(button7);
		
		// Create a button with "- 8 -" on it
		
		button8 = new JButton("- 8 -");
		
		// Tell Java that you want to be alerted when an event
		// occurs on the button
		
		button8.addActionListener(lForButton);
		
		thePanel.add(button8);
		
		// Render the panel in the Frame now that all the components are defined
		
		this.add(thePanel);
	
		// Setup other listeners
		
		ListenForWindow lForWindow = new ListenForWindow();
		
		this.addWindowListener(lForWindow);
		
		this.setVisible(true);
		
		// Track the mouse if it is inside of the panel
		
		ListenForMouse lForMouse = new ListenForMouse();
		
		thePanel.addMouseListener(lForMouse);
		
	}
	
	/* this not needed right now....
	public static void appendtext(String text) {
		// method to add text to 'textArea1'
		textArea1.append(text);
		textArea1.setCaretPosition(textArea1.getDocument().getLength());
	}
	*/
	
	// Implements ActionListener so it can react to events on components
	
	private class ListenForButton implements ActionListener{
	
	// This method is called when an event occurs
	
		public void actionPerformed(ActionEvent e){
			
			// Check if the source of the event was the button
			
			String state;
			
			if(e.getSource() == button0){
				// button 1 pressed
				
				button0Clicked++;
				state = button0.getText();
				
				if (state.equals("Radio 1")) {			

					
					// Change the button text to "++GND++"
					
					button0.setText("++GND++");
					
					// e.getSource().toString() returns information on the button
					// and the event that occurred
				}
				else {
					
					// Change button text back to original
					
					button0.setText("Radio 1");
				}
			}
			
			if(e.getSource() == button1){
				// button 1 pressed
				
				button1Clicked++;
				state = button1.getText();
				
				if (state.equals("- 1 -")) {			

					
					// Change the button text to "On"
					
					button1.setText("++1++");
					
					// e.getSource().toString() returns information on the button
					// and the event that occurred
				}
				else {
					
					// Change button text back to original
					
					button1.setText("- 1 -");
				}
			}
			else if (e.getSource() == button2) {
				// button 2 pressed
				
				button2Clicked++;
				state = button2.getText();
				
				if (state.equals("- 2 -")) {			

					
					// Change the button text to "On"
					
					button2.setText("++2++");
					
					// e.getSource().toString() returns information on the button
					// and the event that occurred
				}
				else {
					
					// Change button text back to original
					
					button2.setText("- 2 -");
				}	
			}
			else if (e.getSource() == button3) {
				// button 3 pressed
				
				button3Clicked++;
				state = button3.getText();
				
				if (state.equals("- 3 -")) {			

					
					// Change the button text to "On"
					
					button3.setText("++3++");
					
					// e.getSource().toString() returns information on the button
					// and the event that occurred
				}
				else {
					
					// Change button text back to original
					
					button3.setText("- 3 -");
				}	
			}
			else if (e.getSource() == button4) {
				// button 4 pressed
				
				button4Clicked++;
				state = button4.getText();
				
				if (state.equals("- 4 -")) {			

					
					// Change the button text to "On"
					
					button4.setText("++4++");
					
					// e.getSource().toString() returns information on the button
					// and the event that occurred
				}
				else {
					
					// Change button text back to original
					
					button4.setText("- 4 -");
				}	
			}
			else if (e.getSource() == button5) {
				// button 5 pressed
				
				button5Clicked++;
				state = button5.getText();
				
				if (state.equals("- 5 -")) {			

					
					// Change the button text to "On"
					
					button5.setText("++5++");
					
					// e.getSource().toString() returns information on the button
					// and the event that occurred
				}
				else {
					
					// Change button text back to original
					
					button5.setText("- 5 -");
				}	
			}
			else if (e.getSource() == button6) {
				// button 6 pressed
				
				button6Clicked++;
				state = button6.getText();
				
				if (state.equals("- 6 -")) {			

					
					// Change the button text to "On"
					
					button6.setText("++6++");
					
					// e.getSource().toString() returns information on the button
					// and the event that occurred
				}
				else {
					
					// Change button text back to original
					
					button6.setText("- 6 -");
				}	
			}
			else if (e.getSource() == button7) {
				// button 7 pressed
				
				button7Clicked++;
				state = button7.getText();
				
				if (state.equals("- 7 -")) {			

					
					// Change the button text to "On"
					
					button7.setText("++7++");
					
					// e.getSource().toString() returns information on the button
					// and the event that occurred
				}
				else {
					
					// Change button text back to original
					
					button7.setText("- 7 -");
				}	
			}
			else if (e.getSource() == button8) {
				// button 8 pressed
				
				button8Clicked++;
				state = button8.getText();
				
				if (state.equals("- 8 -")) {			

					
					// Change the button text to "On"
					
					button8.setText("++8++");
					
					// e.getSource().toString() returns information on the button
					// and the event that occurred
				}
				else {
					
					// Change button text back to original
					
					button8.setText("- 8 -");
				}	
			}
		}
	}
	
	
	public static void clearswapflag() {
		swapflag = false;
	}

	
	// By using KeyListener you can track keys on the keyboard
	
	private class ListenForKeys implements KeyListener{
		
		// Handle the key typed event from the text field.
	    public void keyTyped(KeyEvent e) {
	    	// textArea1.append("Key Hit: " + e.getKeyChar() + "\n"); 
	    }

	    // Handle the key-pressed event from the text field.
	    public void keyPressed(KeyEvent e) {
	        
	    }

	    // Handle the key-released event from the text field.
	    public void keyReleased(KeyEvent e) {
	        
	    }
		
	}
	
	private class ListenForMouse implements MouseListener{

		// Called when a mouse button is clicked
		
		public void mouseClicked(MouseEvent e) {
			
			// show data when mouse is clicked
			System.out.println("Mouse Panel Pos: " + e.getX() + " " + e.getY());
			System.out.println("Mouse Screen Pos: " + e.getXOnScreen() + " " + e.getYOnScreen()); 
			System.out.println("Mouse Button: " + e.getButton()); 
			System.out.println("Mouse Clicks: " + e.getClickCount());
			
		}

		// Called when the mouse enters the component assigned
		// the MouseListener
		
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
			System.out.println("Mouse Entered Window");
			
		}

		// Called when the mouse leaves the component assigned
		// the MouseListener
		
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("Mouse Exited Window");
		}

		// Mouse button pressed
		
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("Mouse Button Pressed");
		}

		// Mouse button released
		
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("Mouse Button Released");
		}
		
	}
	
	private class ListenForWindow implements WindowListener{

		// Called when window is the active window
		
		public void windowActivated(WindowEvent e) {
			System.out.println("Window Activated");
			
		}

		// Called when window is closed using dispose
		// this.dispose(); can be used to close a window
		
		public void windowClosed(WindowEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("Window Closed");
		}

		// Called when the window is closed from the menu
		
		public void windowClosing(WindowEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("Window Closing");
		}

		// Called when a window is no longer the active window
		
		public void windowDeactivated(WindowEvent e) {
			System.out.println("Window de-Activated\n");
			
		}

		// Called when the window goes from minimized to a normal state
		
		public void windowDeiconified(WindowEvent arg0) {
			System.out.println("Window in Normal State");
			
		}

		// Called when the window goes from normal to a minimized state
		
		public void windowIconified(WindowEvent arg0) {
			System.out.println("Window Minimized");
			
		}

		// Called when the window is first created
		
		public void windowOpened(WindowEvent arg0) {
			System.out.println("Window Created");
			
		}	
	}
}
