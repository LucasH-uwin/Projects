package assignment;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class Assignment extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField answer;
	public static JTextPane display;
	private int setter= 0;
	private int ogSetter= 0;
	private Player[] players;
	private int playerCount;
	private int userAnswer;
	private Double userdivAnswer;
	private int gameAnswer;
	private int questionType;
	private long time = 0;
	private static Assignment frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame = new Assignment();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Assignment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 380);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(77, 73, 72));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		answer = new JTextField();
		answer.setBackground(new Color(128, 128, 128));
		answer.setVisible(false);
		answer.setEnabled(false);
		answer.setBounds(199, 214, 96, 19);
		contentPane.add(answer);
		answer.setColumns(10);
		
		display = new JTextPane();
		display.setBackground(new Color(128, 128, 128));
		display.setText("Select Mode to Start");
		display.setFocusable(false);
		StyledDocument doc = display.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        try {
            doc.setParagraphAttributes(0, doc.getLength(), center, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
		display.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(display);
		scrollPane.setBounds(75, 28, 346, 100);
        contentPane.add(scrollPane);
        
        
		JButton singlePlayer = new JButton("Single Player");
		singlePlayer.setBackground(new Color(128, 128, 128));
		singlePlayer.setBounds(75, 148, 120, 20);
		contentPane.add(singlePlayer);
		
		JButton multiplayer = new JButton("Multiplayer");
		multiplayer.setBackground(new Color(128, 128, 128));
		multiplayer.setBounds(301, 148, 120, 20);
		contentPane.add(multiplayer);
		
		JButton sinTime = new JButton("Time Trial");
		sinTime.setToolTipText("Get as many questions right as possible in 15 seconds");
		sinTime.setEnabled(false);
		sinTime.setBackground(Color.GRAY);
		sinTime.setBounds(75, 148, 120, 20);
		sinTime.setEnabled(false);
		sinTime.setVisible(false);
		contentPane.add(sinTime);
		
		JButton sinWish = new JButton("Make a Wish");
		sinWish.setToolTipText("Choose how many questions you want to answer");
		sinWish.setBackground(Color.GRAY);
		sinWish.setBounds(301, 148, 120, 20);
		sinWish.setEnabled(false);
		sinWish.setVisible(false);
		contentPane.add(sinWish);
		
		JButton sinChance = new JButton("Take Chances");
		sinChance.setToolTipText("You have 3 lives, Answer as many questions as possible");
		sinChance.setEnabled(false);
		sinChance.setBackground(Color.GRAY);
		sinChance.setBounds(75, 200, 120, 20);
		sinChance.setEnabled(false);
		sinChance.setVisible(false);
		contentPane.add(sinChance);
		
		JButton sinOne = new JButton("No Mistakes");
		sinOne.setToolTipText("You have 1 life, Answer as many questions as possible");
		sinOne.setBackground(Color.GRAY);
		sinOne.setBounds(301, 200, 120, 20);
		sinOne.setEnabled(false);
		sinOne.setVisible(false);
		contentPane.add(sinOne);
		
		JButton multTime = new JButton("Time Trial");
		multTime.setToolTipText("Choose how long you want to play for (in seconds)");
		multTime.setBackground(Color.GRAY);
		multTime.setBounds(75, 148, 120, 20);
		multTime.setEnabled(false);
		multTime.setVisible(false);
		contentPane.add(multTime);
		
		JButton multWish = new JButton("Make a Wish");
		multWish.setToolTipText("Choose how long you want to play for (in seconds)");
		multWish.setBackground(Color.GRAY);
		multWish.setBounds(301, 148, 120, 20);
		multWish.setEnabled(false);
		multWish.setVisible(false);
		contentPane.add(multWish);
		
		JButton multChance = new JButton("Take Chances");
		multChance.setToolTipText("You have 3 lives, Answer as many questions as possible");
		multChance.setBackground(Color.GRAY);
		multChance.setBounds(75, 200, 120, 20);
		multChance.setEnabled(false);
		multChance.setVisible(false);
		contentPane.add(multChance);
		
		
		JButton multOne = new JButton("No Mistakes");
		multOne.setToolTipText("You have 1 life, Answer as many questions as possible");
		multOne.setBackground(Color.GRAY);
		multOne.setBounds(301, 200, 120, 20);
		multOne.setEnabled(false);
		multOne.setVisible(false);
		contentPane.add(multOne);
		
		JButton nameSubmit = new JButton("Submit");
		nameSubmit.setBounds(199, 275, 96, 20);
		nameSubmit.setBackground(Color.GRAY);
		nameSubmit.setEnabled(false);
		nameSubmit.setVisible(false);
		contentPane.add(nameSubmit);
		
		JButton playerSubmit = new JButton("Submit");
		playerSubmit.setBounds(199, 275, 96, 20);
		playerSubmit.setBackground(Color.GRAY);
		playerSubmit.setEnabled(false);
		playerSubmit.setVisible(false);
		contentPane.add(playerSubmit);
		
		JButton sinAnswerSubmit = new JButton("Submit");
		sinAnswerSubmit.setBounds(199, 275, 96, 20);
		sinAnswerSubmit.setBackground(Color.GRAY);
		sinAnswerSubmit.setEnabled(false);
		sinAnswerSubmit.setVisible(false);
		contentPane.add(sinAnswerSubmit);
		
		JButton sinWishSubmit = new JButton("Submit");
		sinWishSubmit.setBounds(199, 275, 96, 20);
		sinWishSubmit.setBackground(Color.GRAY);
		sinWishSubmit.setEnabled(false);
		sinWishSubmit.setVisible(false);
		contentPane.add(sinWishSubmit);
		
		JButton sinTimeSubmit = new JButton("Submit");
		sinTimeSubmit.setBounds(199, 275, 96, 20);
		sinTimeSubmit.setBackground(Color.GRAY);
		sinTimeSubmit.setEnabled(false);
		sinTimeSubmit.setVisible(false);
		contentPane.add(sinTimeSubmit);
		
		JButton multTimeSubmit = new JButton("Submit");
		multTimeSubmit.setBounds(199, 275, 96, 20);
		multTimeSubmit.setBackground(Color.GRAY);
		multTimeSubmit.setEnabled(false);
		multTimeSubmit.setVisible(false);
		contentPane.add(multTimeSubmit);
		
		JButton multWishSubmit = new JButton("Submit");
		multWishSubmit.setBounds(199, 275, 96, 20);
		multWishSubmit.setBackground(Color.GRAY);
		multWishSubmit.setEnabled(false);
		multWishSubmit.setVisible(false);
		contentPane.add(multWishSubmit);
		
		JButton multAnswerSubmit = new JButton("Submit");
		multAnswerSubmit.setBounds(199, 275, 96, 20);
		multAnswerSubmit.setBackground(Color.GRAY);
		multAnswerSubmit.setEnabled(false);
		multAnswerSubmit.setVisible(false);
		contentPane.add(multAnswerSubmit);
		
		
		JButton Continue = new JButton("Continue");
		Continue.setBackground(Color.GRAY);
		Continue.setBounds(199, 275, 96, 20);
		Continue.setEnabled(false);
		Continue.setVisible(false);
		contentPane.add(Continue);
		
		JButton quitGame = new JButton("Quit");
		quitGame.setBackground(Color.GRAY);
		quitGame.setBounds(301, 148, 120, 20);
		quitGame.setEnabled(false);
		quitGame.setVisible(false);
		contentPane.add(quitGame);
		
		JButton newGame = new JButton("Play Again");
		newGame.setBackground(Color.GRAY);
		newGame.setBounds(75, 148, 120, 20);
		newGame.setEnabled(false);
		newGame.setVisible(false);
		contentPane.add(newGame);
		
		singlePlayer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				multiplayer.setVisible(false);
				singlePlayer.setVisible(false);
				multiplayer.setEnabled(false);
				singlePlayer.setEnabled(false);
				sinWish.setEnabled(true);
				sinWish.setVisible(true);
				sinTime.setEnabled(true);
				sinTime.setVisible(true);
				sinOne.setEnabled(true);
				sinOne.setVisible(true);
				sinChance.setEnabled(true);
				sinChance.setVisible(true);
				display.setText("Choose a Game Mode\n Hint: Hover over the button to see what the modes do");
				players = new Player[1];
				players[0] = new Player();
				playerCount=1;
				
			}
		});
		
		sinWish.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sinChance.setEnabled(false);
				sinChance.setVisible(false);
				sinTime.setEnabled(false);
				sinTime.setVisible(false);
				sinWish.setEnabled(false);
				sinWish.setVisible(false);
				sinOne.setEnabled(false);
				sinOne.setVisible(false);
				answer.setVisible(true);
				answer.setEnabled(true);
				sinWishSubmit.setEnabled(true);
				sinWishSubmit.setVisible(true);
				display.setText("How many questions would you like?");
				
			}
		});
		
		sinWishSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					answer.setBackground(new Color(128, 128, 128));
					setter = Integer.parseInt(answer.getText());
					answer.setText("");
					sinWishSubmit.setVisible(false);
					sinWishSubmit.setEnabled(false);
					time = -1;
					sinAnswerSubmit.setVisible(true);
					sinAnswerSubmit.setEnabled(true);
					answer.requestFocusInWindow();
					questionType = (int)(Math.random() * 4);
					gameAnswer = Game.getQuestion(players , 0, questionType );
				} catch (NumberFormatException q) {
					answer.setBackground(Color.RED);
					answer.setText("");
					answer.requestFocusInWindow();
				}
				
			}
		});
		
		sinTime.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sinChance.setEnabled(false);
				sinChance.setVisible(false);
				sinTime.setEnabled(false);
				sinTime.setVisible(false);
				sinWish.setEnabled(false);
				sinWish.setVisible(false);
				sinOne.setEnabled(false);
				sinOne.setVisible(false);
				answer.setVisible(true);
				answer.setEnabled(true);
				sinTimeSubmit.setEnabled(true);
				sinTimeSubmit.setVisible(true);
				display.setText("How much time would you like?");
				
			}
		});
		
		sinTimeSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					answer.setBackground(new Color(128, 128, 128));
					setter = Integer.parseInt(answer.getText());
					answer.setText("");
					sinTimeSubmit.setVisible(false);
					sinTimeSubmit.setEnabled(false);
					sinAnswerSubmit.setVisible(true);
					sinAnswerSubmit.setEnabled(true);
					answer.requestFocusInWindow();
					time = System.currentTimeMillis();
					questionType = (int)(Math.random() * 4);
					gameAnswer = Game.getQuestion(players , 0, questionType);
				} catch (NumberFormatException q) {
					answer.setBackground(Color.RED);
					answer.setText("");
					answer.requestFocusInWindow();
				}
			}
		});
		
		sinChance.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sinChance.setEnabled(false);
				sinChance.setVisible(false);
				sinTime.setEnabled(false);
				sinTime.setVisible(false);
				sinWish.setEnabled(false);
				sinWish.setVisible(false);
				sinOne.setEnabled(false);
				sinOne.setVisible(false);
				setter = 3;
				sinAnswerSubmit.setVisible(true);
				sinAnswerSubmit.setEnabled(true);
				answer.setVisible(true);
				answer.setEnabled(true);
				answer.requestFocusInWindow();
				questionType = (int)(Math.random() * 4);
				gameAnswer = Game.getQuestion(players , 0, questionType );
				
			}
		});
		
		sinOne.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sinChance.setEnabled(false);
				sinChance.setVisible(false);
				sinTime.setEnabled(false);
				sinTime.setVisible(false);
				sinWish.setEnabled(false);
				sinWish.setVisible(false);
				sinOne.setEnabled(false);
				sinOne.setVisible(false);
				setter = 1;
				sinAnswerSubmit.setVisible(true);
				sinAnswerSubmit.setEnabled(true);
				answer.setVisible(true);
				answer.setEnabled(true);
				answer.requestFocusInWindow();
				questionType = (int)(Math.random() * 4);
				gameAnswer = Game.getQuestion(players , 0, questionType );
			}
		});
		
		sinAnswerSubmit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					answer.setBackground(new Color(128, 128, 128));
					if(questionType != 1) {
						userAnswer = Integer.parseInt(answer.getText());
						players[0].summary+= userAnswer + " " + (userAnswer==gameAnswer)+"\n";
						gameAnswer*=100;
					}
					else {
						userdivAnswer = Double.parseDouble(answer.getText());
						players[0].summary+= userdivAnswer + " " + (userdivAnswer==(((double)gameAnswer)/100))+"\n";
					}
					if(time == -1) {
					setter--;
					}
					else if((double)userAnswer!=(((double)gameAnswer)/100)&&time == 0) {
						setter--;
					}
					if((double)userAnswer==(((double)gameAnswer)/100)){
						players[0].score++;
					}
					answer.setText("");
					answer.requestFocusInWindow();
					long time2  = System.currentTimeMillis();
					if(((time2/1000) - (time/1000) > setter) && (time !=0 && time != -1)){
						display.setText("SUMMARY\n" + players[0].summary);
						quitGame.setVisible(true);
						quitGame.setEnabled(true);
						newGame.setVisible(true);
						newGame.setEnabled(true);
						sinAnswerSubmit.setVisible(false);
						sinAnswerSubmit.setEnabled(false);
						answer.setVisible(false);
						answer.setEnabled(false);
					}
					else if(setter == 0) {
						display.setText("SUMMARY\n" + players[0].summary + "score : "+ players[0].score);
						quitGame.setVisible(true);
						quitGame.setEnabled(true);
						newGame.setVisible(true);
						newGame.setEnabled(true);
						sinAnswerSubmit.setVisible(false);
						sinAnswerSubmit.setEnabled(false);
						answer.setVisible(false);
						answer.setEnabled(false);
					}
					else {
						questionType = (int)(Math.random() * 4);
						gameAnswer = Game.getQuestion(players , 0, questionType);
					}
				} catch (NumberFormatException q) {
					answer.setBackground(Color.RED);
					answer.setText("");
					answer.requestFocusInWindow();
				}
			}
		});
		
		
		//Multiplayer Mode handling
		multiplayer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				multiplayer.setVisible(false);
				singlePlayer.setVisible(false);
				multiplayer.setEnabled(false);
				singlePlayer.setEnabled(false);
				answer.setVisible(true);
				answer.setEnabled(true);
				playerSubmit.setVisible(true);
				playerSubmit.setEnabled(true);
				display.setText("How Many Players");
				answer.requestFocusInWindow();
				
				
			}
			
		});
		
		playerSubmit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
					try {
						answer.setBackground(new Color(128, 128, 128));
						playerCount = Integer.parseInt(answer.getText());
						players = new Player[playerCount];
						answer.setText("");
						playerSubmit.setVisible(false);
						playerSubmit.setEnabled(false);
						nameSubmit.setVisible(true);
						nameSubmit.setEnabled(true);
						display.setText("Name of Player " + (setter+1));
						answer.requestFocusInWindow();
					} catch (NumberFormatException q) {
						answer.setBackground(Color.RED);
						answer.setText("");
						answer.requestFocusInWindow();
					}
			}
		});
		
		nameSubmit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				players[setter] = new Player();
				players[setter].name = answer.getText();
				setter++;
				if(setter==playerCount) {
					nameSubmit.setVisible(false);
					nameSubmit.setEnabled(false);
					answer.setText("");
					answer.setVisible(false);
					answer.setEnabled(false);
					display.setText("Choose a Game Mode\n Hint: Hover over the button to see what the modes do");
					multTime.setVisible(true);
					multTime.setEnabled(true);
					multChance.setVisible(true);
					multChance.setEnabled(true);
					multOne.setVisible(true);
					multOne.setEnabled(true);
					multWish.setVisible(true);
					multWish.setEnabled(true);
					setter = 0;
				}
				else {
					display.setText("Name of Player " + (setter+1));
					answer.setText("");
					answer.requestFocusInWindow();
				}
			}
		});
		
		multChance.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				multTime.setVisible(false);
				multTime.setEnabled(false);
				multChance.setVisible(false);
				multChance.setEnabled(false);
				multWish.setEnabled(false);
				multWish.setVisible(false);
				multOne.setEnabled(false);
				multOne.setVisible(false);
				setter = 3;
				ogSetter = 3;
				playerCount = 0;
				Continue.setEnabled(true);
				Continue.setVisible(true);
				display.setText(players[playerCount].name +"'s turn");
			}
		});
		
		multTime.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				multTime.setVisible(false);
				multTime.setEnabled(false);
				multChance.setVisible(false);
				multChance.setEnabled(false);
				multWish.setEnabled(false);
				multWish.setVisible(false);
				multOne.setEnabled(false);
				multOne.setVisible(false);
				multTimeSubmit.setEnabled(true);
				multTimeSubmit.setVisible(true);
				answer.setVisible(true);
				answer.setEnabled(true);
				display.setText("How much time would you like?");
			}
		});
		
		multTimeSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					answer.setBackground(new Color(128, 128, 128));
					setter = Integer.parseInt(answer.getText());
					answer.setText("");
					multTimeSubmit.setVisible(false);
					multTimeSubmit.setEnabled(false);
					answer.setVisible(false);
					answer.setEnabled(false);
					time = System.currentTimeMillis();
					playerCount=0;
					Continue.setVisible(true);
					Continue.setEnabled(true);
					display.setText(players[playerCount].name +"'s turn");
				} catch (NumberFormatException q) {
					answer.setBackground(Color.RED);
					answer.setText("");
					answer.requestFocusInWindow();
				}
			}
		});
		
		multOne.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				multChance.setEnabled(false);
				multChance.setVisible(false);
				multTime.setEnabled(false);
				multTime.setVisible(false);
				multWish.setEnabled(false);
				multWish.setVisible(false);
				multOne.setEnabled(false);
				multOne.setVisible(false);
				setter = 1;
				ogSetter = 1;
				playerCount=0;
				Continue.setVisible(true);
				Continue.setEnabled(true);
				display.setText(players[playerCount].name +"'s turn");			
				}
		});

		multWish.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				multChance.setEnabled(false);
				multChance.setVisible(false);
				multTime.setEnabled(false);
				multTime.setVisible(false);
				multWish.setEnabled(false);
				multWish.setVisible(false);
				multOne.setEnabled(false);
				multOne.setVisible(false);
				answer.setVisible(true);
				answer.setEnabled(true);
				multWishSubmit.setEnabled(true);
				multWishSubmit.setVisible(true);
				display.setText("How many questions would you like?");
				
			}
		});
		
		multWishSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					answer.setBackground(new Color(128, 128, 128));
					ogSetter = Integer.parseInt(answer.getText());
					setter = ogSetter;
					answer.setText("");
					multWishSubmit.setVisible(false);
					multWishSubmit.setEnabled(false);
					answer.setVisible(false);
					answer.setEnabled(false);
					time = -1;
					playerCount = 0;
					Continue.setVisible(true);
					Continue.setEnabled(true);
					display.setText(players[playerCount].name +"'s turn");	
				} catch (NumberFormatException q) {
					answer.setBackground(Color.RED);
					answer.setText("");
					answer.requestFocusInWindow();
				}
				
			}
		});
		
		multAnswerSubmit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					answer.setBackground(new Color(128, 128, 128));
					if(questionType != 1) {
						userAnswer = Integer.parseInt(answer.getText());
						players[playerCount].summary+= userAnswer + " " + (userAnswer==gameAnswer)+"\n";
						gameAnswer*=100;
					}
					else {
						userdivAnswer = Double.parseDouble(answer.getText());
						players[playerCount].summary+= userdivAnswer + " " + (userdivAnswer==(((double)gameAnswer)/100))+"\n";
					}
					if((double)userAnswer!=(((double)gameAnswer)/100)&&time == 0) {
						setter--;
					}
					else if(time == -1) {
						setter--;
					}
					answer.setText("");
					answer.requestFocusInWindow();
					if((double)userAnswer==(((double)gameAnswer)/100)) {
						players[playerCount].score++;
					}
					long time2  = System.currentTimeMillis();
					if(((time2/1000) - (time/1000) > setter) && (time !=0 && time != -1)){
						playerCount++;
						if(playerCount == players.length) {
							String finalSummary = "";
							for(int j = 0; j <playerCount; j++ ){
								finalSummary += "SUMMARY " + players[j].name + "\n" + players[j].summary + "\n";
							}
							for(int i = 0; i<playerCount; i++) {
					        	for(int j = 0; j<playerCount; j++) {
					        		if(players[i].score > players[j].score) {
					        			Player Temp = players[i];
					        			players[i] = players[j];
					        			players[j] =  Temp;
					        		}
					        	}
					        }
							finalSummary += "\nLeaderboard\n";
							for(int j = 0; j <playerCount; j++ ){
								finalSummary += players[j].name + ": " + players[j].score + "\n";
							}
							display.setText(finalSummary);
							quitGame.setVisible(true);
							quitGame.setEnabled(true);
							newGame.setVisible(true);
							newGame.setEnabled(true);
							multAnswerSubmit.setVisible(false);
							multAnswerSubmit.setEnabled(false);
							answer.setVisible(false);
							answer.setEnabled(false);
							
						}
						else {
							display.setText(players[playerCount].name +"'s turn");
							multAnswerSubmit.setVisible(false);
							multAnswerSubmit.setEnabled(false);
							answer.setVisible(false);
							answer.setEnabled(false);
							Continue.setEnabled(true);
							Continue.setVisible(true);
						}
					}
					else if(setter == 0) {
						playerCount++;
						if(playerCount == players.length) {
							String finalSummary = "";
							for(int j = 0; j <playerCount; j++ ){
								finalSummary += "SUMMARY " + players[j].name + "\n" + players[j].summary + "\n";
							}
							for(int i = 0; i<playerCount; i++) {
					        	for(int j = 0; j<playerCount; j++) {
					        		if(players[i].score > players[j].score) {
					        			Player Temp = players[i];
					        			players[i] = players[j];
					        			players[j] =  Temp;
					        		}
					        	}
					        }
							finalSummary += "\nLeaderboard\n";
							for(int j = 0; j <playerCount; j++ ){
								finalSummary += players[j].name + ": " + players[j].score + "\n";
							}
							display.setText(finalSummary);
							quitGame.setVisible(true);
							quitGame.setEnabled(true);
							newGame.setVisible(true);
							newGame.setEnabled(true);
							multAnswerSubmit.setVisible(false);
							multAnswerSubmit.setEnabled(false);
							answer.setVisible(false);
							answer.setEnabled(false);
						}
						else {
							display.setText(players[playerCount].name +"'s turn");
							setter = ogSetter;
							multAnswerSubmit.setVisible(false);
							multAnswerSubmit.setEnabled(false);
							answer.setVisible(false);
							answer.setEnabled(false);
							Continue.setEnabled(true);
							Continue.setVisible(true);
						}
					}
					else {
						questionType = (int)(Math.random() * 4);
						gameAnswer = Game.getQuestion(players , playerCount, questionType);
					}
				} catch (NumberFormatException q) {
					answer.setBackground(Color.RED);
					answer.setText("");
					answer.requestFocusInWindow();
				}
			}
		});
		
		//pause between players
		Continue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				multAnswerSubmit.setEnabled(true);
				multAnswerSubmit.setVisible(true);
				answer.setVisible(true);
				answer.setEnabled(true);
				Continue.setVisible(false);
				Continue.setEnabled(false);
				answer.requestFocusInWindow();
				if(time == 0|| time == -1) {
					questionType = (int)(Math.random() * 4);
					gameAnswer = Game.getQuestion(players , playerCount, questionType);
				}
				else {
					time = System.currentTimeMillis();
					questionType = (int)(Math.random() * 4);
					gameAnswer = Game.getQuestion(players , playerCount, questionType);
				}
			}
		});

		newGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				multiplayer.setVisible(true);
				singlePlayer.setVisible(true);
				multiplayer.setEnabled(true);
				singlePlayer.setEnabled(true);
				display.setText("Select Mode to Start");
				quitGame.setVisible(false);
				quitGame.setEnabled(false);
				newGame.setVisible(false);
				newGame.setEnabled(false);
				setter= 0;
				time = 0;
				ogSetter=0;
			}
		});
		
		quitGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
	}
}
;