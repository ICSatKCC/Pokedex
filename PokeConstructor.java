import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * PokeConstructor for the game Pokedex.java
 * @author Ujjwal Gautam, Kelly Hwang
 * @since 12/06/2020
 */
	
	
	@SuppressWarnings("serial")
	public class PokeConstructor extends JPanel implements ActionListener{
		/**
		 * Instance variable poke for storing Pokemon object
		 */
		private Pokemon poke;
		/** rangen for storing random number */
		Random rangen = new Random();
		/** PokeTree for printing list of Pokemon*/
	   private PokeTree<Pokemon> pokeTree = new PokeTree<Pokemon>();
	   /** ArrayDeque for printing most recent Pokemon*/
		private Deque<Pokemon> aDequeBackpack = new ArrayDeque<Pokemon>();
		/** PriorityQueue for printing Pokemon in numerical order*/
		private PriorityQueue<Pokemon> pQueue = new PriorityQueue<Pokemon>();
		
		
		/**topPanel container in the frame*/
		private JPanel topPanel = new JPanel();
		/**middlePanel container in the frame*/
		private JPanel midPanel = new JPanel();
		/**bottomPanel container in the frame*/
		private JPanel bottomPanel = new JPanel();
		/**topSubPanel container inside topPanel*/
		private JPanel topSubPanel = new JPanel();
		/**label inside the topSubPanel*/
		private JLabel topLabel = new JLabel("GAME OF POKEMON!!");
		/**Generates the type of pokemon species hunted*/
		private JLabel huntLabel = new JLabel();
		/** button that hunts Pokemon */
		private JButton bHunt = new JButton("Hunt");
		/** button that catches Pokemon */
		private JButton bCatch = new JButton("Catch");
		/** button that prints Pokedex from stored pokemon */
		private JButton bPokedex = new JButton("Pokedex");
		/** button that displays lists of pokemon according to the choice */
		private JButton bBackpack = new JButton("Backpack");
		/** textArea field for displaying output of BackPack */
		private JTextArea textArea = new JTextArea(7, 45);
		/** textArea field for displaying output of caught Pokemon */
		private JTextArea catchTextArea = new JTextArea(9, 30);
		/** adds a scrollPane in the catchTextArea */
		private JScrollPane scrollTop = new JScrollPane(catchTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); 
		/** adds a scrollPane in the textArea */
		private JScrollPane scrollPokedex = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
	/**
	 * PokeConstructor for displaying frames and panels
	 */
	
		public PokeConstructor() {
			
			/**Initialization of the frame */
			JFrame jFrame = new JFrame("Pokemon GUI");
			//sets dimension of the frame
			jFrame.setPreferredSize(new Dimension(1400, 900));
			//closes the operation upon closing the window
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//size of topPanel
			topPanel.setPreferredSize(new Dimension(800, 450));
			//using FlowLayout as a layout manager
			jFrame.setLayout(new FlowLayout());
			//setting background color as gray
			topPanel.setBackground(Color.gray);
			topSubPanel.setPreferredSize(new Dimension(800, 400));
			//creating a customized background color
			topSubPanel.setBackground(new Color(170, 172, 171));
			//customized font
			topLabel.setFont(new Font("MV Boli", Font.PLAIN, 40));
			huntLabel.setFont(new Font("MV Boli", Font.PLAIN, 60));
			//adds label to the panel
			topSubPanel.add(topLabel);
			//embedding subPanel inside panel
			topPanel.add(topSubPanel, BorderLayout.CENTER);
			bCatch.setPreferredSize(new Dimension(100, 30));
			bHunt.setPreferredSize(new Dimension(100, 30));
			bCatch.setBackground(Color.DARK_GRAY);
			bHunt.setBackground(Color.DARK_GRAY);
			bCatch.setForeground(Color.RED);
			bHunt.setForeground(Color.RED);
			//removes the dotted rectangle inside the button
			bHunt.setFocusable(false);
			bCatch.setFocusable(false);
			
			//listens to events in the buttons
			bHunt.addActionListener(this);
			bCatch.addActionListener(this);
			//toppanels and subpanels components
			topSubPanel.add(huntLabel);
			//topSubPanel.add(catchTextArea);
			//topPanel.add(topSubPanel);
			topPanel.add(bHunt);
			topPanel.add(bCatch);
			topSubPanel.add(scrollTop);
			scrollTop.setBorder(null);
			scrollTop.getVerticalScrollBar().setPreferredSize(new Dimension(20,0));
			
			//listens to events in the buttons
			//catchTextArea.add(scrollTop);
			bHunt.addActionListener(this);
			bCatch.addActionListener(this);
			catchTextArea.setFont(new Font("SansSerif", Font.ITALIC, 20));
			catchTextArea.setBackground(new Color(171, 123, 147));
			//Disable any edits in the textarea
			catchTextArea.setEditable(false);
			//does not work
			//catchTextArea.add(new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
			
			
				
			//midpanel for cosmetic purpose
			midPanel.setPreferredSize(new Dimension(800, 100));
		
		
			//bottomPanel components
			bottomPanel.setPreferredSize(new Dimension(800, 250));
			bottomPanel.setBackground(new Color(141, 130, 135));
			bPokedex.setPreferredSize(new Dimension(100,30));
			bBackpack.setPreferredSize(new Dimension(100,30));
			bPokedex.setFocusable(false);
			bBackpack.setFocusable(false);
			scrollPokedex.setBorder(null);
			//adding Pokedex, Backpack buttons and scrollPokedex/textArea in the bottom panel
			bottomPanel.add(bPokedex);
			bottomPanel.add(bBackpack);
			bottomPanel.add(scrollPokedex);
			//scrollPokedex.setBorder(null);
			scrollPokedex.getVerticalScrollBar().setPreferredSize(new Dimension(20,0));

				//listening to events in buttons Pokedex and Backpack
			bPokedex.addActionListener(this);
			bBackpack.addActionListener(this);
			//textArea.setPreferredSize(new Dimension(700, 200));
			textArea.setBackground(new Color(192, 192, 192));
			textArea.setFont(new Font("Serif", Font.BOLD, 20));
			textArea.setEditable(false);
		

			//bottomPanel.add(scrollPokedex);
			//adding textArea to bottom panel.
			//bottomPanel.add(textArea); ///////
			
			
		//bottomPanel.add(scroll);
			
		//Embedding all the containers and components into the jFrame	
		jFrame.add(topPanel);
		jFrame.add(midPanel);
		jFrame.add(bottomPanel);
		
		//packs everything together
		jFrame.pack();
		//Visible on the screen
		jFrame.setVisible(true);
		}
		
		/**
		 * A method that listens to events in buttons.
		 * @param event is where it's listening to
		 */
		@Override
		public void actionPerformed(ActionEvent event) {			
			//if the event source is bHunt		
			try {
				if (event.getSource() == bHunt) {
				int num = rangen.nextInt(10 - 1 + 1) + 1;
				switch(num) {
					case 1:
		               poke = new Bulbasaur();
		               break;
		               
		            case 2:
		               poke = new Ivysaur();
		               break;
		               
		            case 3:
		               poke = new Venusaur();
		               break;
		               
		            case 4:
		               poke = new Charmander();
		               break;
		               
		            case 5:
		               poke = new Charmeleon();
		               break;
		               
		            case 6:
		               poke = new Charizard();
		               break;
		               
		            case 7:
		               poke = new Squirtle();
		               break;
		               
		            case 8:
		               poke = new Wartortle();
		               break;
		               
		            case 9:
		               poke = new Blastoise();
		               break;        
		               
		               
		            default: //not a valid menu entry                  
		               break;            
				
				}
				
			String result = poke.getSpecies();
			huntLabel.setText("You created " + result + "!!");
			//Do not show catchTextArea while hunting for Pokemon
			//catchTextArea.setVisible(false);
			catchTextArea.setText(".................");
			
			}	
			//if the event source is bCatch
			else if (event.getSource() == bCatch) {
				//when user taps the bCatch button show the caught Pokemon
				catchTextArea.setVisible(true);
				//generates random number that determines if the Pokemon is caught
				int number = rangen.nextInt(1 - 0 + 1) + 0;			
			String result = poke.getSpecies();
			if (number == 0) {
				catchTextArea.setText("You caught a " + result + "\n" + poke.toString());
				//adding Pokemon in pokeTree, aDeque, and priority queue
				pokeTree.add(poke, poke.getNumber());
				aDequeBackpack.offer(poke);
				pQueue.add(poke);
			
			} else 
			{
				catchTextArea.setText( result + " escaped!!");
			
			}
			
				
			}	
			
				//if the event source is bPokedex
				//print list of pokemon using PokeTree 
			else if (event.getSource() == bPokedex) {
				String pokeString = pokeTree.toString();
			         textArea.setText(pokeString + "\n\n");
			         
				
			
				
			}	
				
			//if the event source is backpack	
			else if (event.getSource() == bBackpack) {
				Pokemon poke3;
				Pokemon poke4;
				String pokeStringBackpack = "";
				String pokeStringPQueue = "";
				String[] response = {"Number", "Recent"};
				//asks for users' sorting choice. Sort by number or recent.
			int run = JOptionPane.showOptionDialog(null, "Select a sorting type", "Sorting Choices", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, response, 0);
			//set textArea to null before printing users' selected method
			//for cosmetic purpose
			textArea.setText(null);
				switch(run) {
				//if the optionDialog output is 1 then print most recent list of pokemon
				case 0:
					do {
					poke3 = aDequeBackpack.pop();
					 pokeStringBackpack = pokeStringBackpack + poke3.toString() + "\n\n";
//					textArea.setText(pokeStringBackpack);
					}
					while (aDequeBackpack.size() > 0);
					textArea.setText(pokeStringBackpack);
					break;
				//Prints pokemon by their number	
				case 1:
					do {
					poke4 = pQueue.poll();
				    pokeStringPQueue = pokeStringPQueue + poke4.toString() + "\n\n";
//					textArea.setText(pokeStringPQueue);
					}
					while (pQueue.size() > 0);
					textArea.setText(pokeStringPQueue);
					break;
					
				default:
				System.out.print("Not a valid entry");
			
				}
				
			}
			} //catches any possible errors
			catch (NoSuchElementException nse) {
				System.out.println("No elements");
			}
			
			catch (NullPointerException npe) {
				
				System.out.println("No elements");
			}
			
				
	
		}  //closes action listener



		} //closes class




