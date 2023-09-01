import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FlappyFish extends JFrame {
	ImageIcon tube = new ImageIcon("img/tube.gif");
	ImageIcon fish0 = new ImageIcon("img/fish0.gif");
	ImageIcon fish1 = new ImageIcon("img/fish1.gif");
	ImageIcon fish2 = new ImageIcon("img/fish2.gif");
	ImageIcon fish3 = new ImageIcon("img/fish3.gif");
	ImageIcon fish4 = new ImageIcon("img/fish4.gif");
	ImageIcon sea = new ImageIcon("img/sea0.jpg");
	ImageIcon floor = new ImageIcon("img/floor.jpg");
	ImageIcon white = new ImageIcon("img/white.jpg");
	ImageIcon Dragon = new ImageIcon("img/Dragon.gif");
	ImageIcon Dragon2 = new ImageIcon("img/Dragon2.gif");
	ImageIcon Dragon3 = new ImageIcon("img/Dragon3.gif");
	ImageIcon red_Dragon = new ImageIcon("img/red_Dragon.gif");
	ImageIcon light1 = new ImageIcon("img/light1.png");
	ImageIcon light2 = new ImageIcon("img/light2.png");
	ImageIcon light3 = new ImageIcon("img/light3.png");
	ImageIcon light4 = new ImageIcon("img/light4.png");
	ImageIcon light5 = new ImageIcon("img/light5.png");
	ImageIcon light9 = new ImageIcon("img/9.png");
	ImageIcon message1 = new ImageIcon("img/message1.gif");
	ImageIcon message2 = new ImageIcon("img/message2.gif");
	ImageIcon message3 = new ImageIcon("img/message3.gif");
	ImageIcon message4 = new ImageIcon("img/message4.gif");
	ImageIcon fish_light = new ImageIcon("img/f0.gif");
	ImageIcon red_light = new ImageIcon("img/red_light.png");
	ImageIcon logo = new ImageIcon("img/logo.png");
	ImageIcon GG = new ImageIcon("img/GG.png");
	ImageIcon start = new ImageIcon("img/start.png");
	ImageIcon success = new ImageIcon("img/success.png");
	ImageIcon stop = new ImageIcon("img/stop.png");
	
	ImageIcon[] blood = new ImageIcon[100];
	ImageIcon[] light = new ImageIcon[50];
	ImageIcon[] message = new ImageIcon[100];
	ImageIcon[] evolution = new ImageIcon[100];
	ImageIcon[] missing = new ImageIcon[100];

	int fishx;
	int fishy;
	int dragonx;
	int dragony;
	int up_t;
	int down_t;
	int died_t;
	int next_light_t;
	int light_t;
	int evolution_t;
	int missing_t;
	int tube1_id;
	int tube2_id;
	int tube3_id;
	int Score;
	int dragon_t;
	int hit_dragon_t;
	int blood_t;
	int light_id;
	int message_id;
	int fish_light_id;
	int blood_id;
	int evolution_id;
	int missing_id;
	int dragon_action;
	int red_Dragonx;
	int red_Dragony;

	int[] tube1x = new int[1000];
	int[] tube1y = new int[1000];
	int[] tube2x = new int[1000];
	int[] tube2y = new int[1000];
	int[] tube3x = new int[1000];
	int[] tube3y = new int[1000];
	int[] fish_lightx = new int[1000];
	int[] fish_lighty = new int[1000];

	boolean isStart = false;
	boolean isDied = false;
	boolean isSuccess =false;
	boolean UP = false;
	boolean open_up_t = false;
	boolean open_down_t = false;
	boolean open_died_t = false;
	boolean open_Dragon = false;
	boolean open_red_Dragon = false;
	boolean open_message = false;
	boolean open_evolution = false;
	boolean open_fish_light = false;
	boolean open_next_light = false;
	boolean hit_Dragon = false;
	boolean open_blood = false;
	boolean open_red_light = false;

	Random random = new Random();
	Timer timer = new Timer();

	public static void main(String[] args) {
		FlappyFish flappyFish = new FlappyFish();

		// flappyFish.setVisible(true);
	}

	public FlappyFish() {
		Frame();
		initFlappyFish();

		Panel panel = new Panel();
		this.add(panel);

		Action action = new Action();
		this.addKeyListener(action);

		timer.schedule(new timertask(), 0, 10);

	}

	void Frame() {
		this.setTitle("Flappy Fish Game");
		int w = 900;
		int h = 720;
		this.setSize(w, h);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setResizable(true);

		int sw = Toolkit.getDefaultToolkit().getScreenSize().width;
		int sh = Toolkit.getDefaultToolkit().getScreenSize().height;

		this.setLocation((sw - w) / 2, (sh - h) / 2);

		this.setVisible(true);
	}

	void initFlappyFish() {
		fishx = 50;
		fishy = 250;
		dragonx = 1000;
		dragony = 100;
		tube1_id = 0;
		tube2_id = 0;
		tube3_id = 0;
		light_id = -1;
		blood_t=0;
		message_id = 0;
		fish_light_id = -1;
		blood_id = 0;
		evolution_id = 0;
		missing_id = 0;
		dragon_action = 0;
		Score = 0;
		red_Dragonx = -200;
		red_Dragony = -150;

		tube1x = new int[1000];
		tube1y = new int[1000];
		tube2x = new int[1000];
		tube2y = new int[1000];
		tube3x = new int[1000];
		tube3y = new int[1000];
		fish_lightx = new int[1000];
		fish_lighty = new int[1000];

		tube1x[0] = 1000;
		tube1y[0] = random.nextInt(300) - 375;

		tube2x[0] = 1500;
		tube2y[0] = random.nextInt(300) - 375;

		tube3x[0] = 2000;
		tube3y[0] = random.nextInt(300) - 375;

		isStart = false;
		isDied = false;
		isSuccess = false;
		UP = false;
		open_up_t = false;
		open_down_t = false;
		open_died_t = false;
		open_Dragon = false;
		open_message = false;
		open_fish_light = false;
		open_next_light = true;
		open_evolution = false;
		open_red_Dragon = false;
		open_blood= false;
		hit_Dragon = false;
		open_red_light = false;

		up_t = 0;
		down_t = 0;
		died_t = 0;
		dragon_t = 0;
		hit_dragon_t = 0;
		next_light_t = 0;
		light_t = 0;
		evolution_t = 0;
		missing_t = 0;
	}

	void put_tube() {
		if (tube1x[tube1_id] == -50 && Score <= 27) {
			tube1_id++;
			tube1x[tube1_id] = 1500;
			tube1y[tube1_id] = random.nextInt(300) - 375;
			;
		}

		if (tube2x[tube2_id] == -50 && Score <= 27) {
			tube2_id++;
			tube2x[tube2_id] = 1500;
			tube2y[tube2_id] = random.nextInt(300) - 375;
			;
		}

		if (tube3x[tube3_id] == -50 && Score <= 27) {
			tube3_id++;
			tube3x[tube3_id] = 1500;
			tube3y[tube3_id] = random.nextInt(300) - 375;
			;
		}

		if (Score >= 30) {
			open_Dragon = true;
		}

		if (dragonx == 500 && message_id < 4) {
			open_message = true;
		}

		if (dragonx == 500) {
			open_blood = true;
		}
		
		if (blood_id == 14 && message_id == 4) {
			open_message = true;
		}
		
		if (dragonx == 560 && dragony == 300 && !open_red_light) {
			open_message = true;
		}
		
		if (blood_id == 21) {
			open_message = true;
		}

	}

	void run_tube() {
		tube1x[tube1_id] -= 5;

		tube2x[tube2_id] -= 5;

		tube3x[tube3_id] -= 5;
	}

	void Die_Check() {
		if (fishx - 65 < tube1x[tube1_id] && fishx + 60 > tube1x[tube1_id]) {
			if (!(fishy - 430 > tube1y[tube1_id] && fishy - 565 < tube1y[tube1_id])) {
				isDied = true;
			}
		}

		if (fishx - 65 < tube2x[tube2_id] && fishx + 60 > tube2x[tube2_id]) {
			if (!(fishy - 430 > tube2y[tube2_id] && fishy - 565 < tube2y[tube2_id])) {
				isDied = true;
			}
		}

		if (fishx - 65 < tube3x[tube3_id] && fishx + 60 > tube3x[tube3_id]) {
			if (!(fishy - 430 > tube3y[tube3_id] && fishy - 565 < tube3y[tube3_id])) {
				isDied = true;
			}
		}

		if (fishy > 565) {
			isDied = true;
		}

		if (fishy < -15) {
			isDied = true;
		}

		if (isDied) {
			open_died_t = true;
		}
	}

	class Panel extends JPanel {
		public Panel() {

		}

		@Override
		public void paint(Graphics g) {
			loadimg();
			super.paint(g);
			sea.paintIcon(this, g, 0, 0);
			
			if (missing_id == 7) {
				isSuccess = true;
			}

			tube.paintIcon(this, g, tube1x[tube1_id], tube1y[tube1_id]);

			tube.paintIcon(this, g, tube2x[tube2_id], tube2y[tube2_id]);

			tube.paintIcon(this, g, tube3x[tube3_id], tube3y[tube3_id]);

			floor.paintIcon(this, g, 0, 620);
			
			if (blood_id <= 21 && open_blood && missing_id!=7) {
				blood[blood_id].paintIcon(this, g, 15, 15);
			}else if (!open_blood && isStart) {
				g.setColor(Color.white);
				g.setFont(new Font("�L�n������", Font.BOLD, 50));
				g.drawString(Score + "", 400, 75);
			}

			if (evolution_id >= 10) {
				open_red_Dragon = true;
				dragon_action = 11;
			}
			

			if (open_red_Dragon) {
				red_Dragon.paintIcon(this, g, red_Dragonx,red_Dragony);
			} else if (isDied) {
				fish4.paintIcon(this, g, fishx, fishy);
			} else if (open_down_t) {
				fish3.paintIcon(this, g, fishx, fishy);
			} else {
				fish1.paintIcon(this, g, fishx, fishy);
			}
			
			if (isSuccess) {
				if ( red_Dragonx< -75) {
					red_Dragonx+=5;
				}
				
				if (red_Dragony < 0) {
					red_Dragony+=5;
				}
			}

			
			if (open_died_t) {
				white.paintIcon(this, g, 0, 0);
			}
			
			if (dragon_action == 11) {
				if (dragony > 300) {
					dragony -= 2;
				}
				
				if (dragonx < 560) {
					dragonx+=5;
				}

				if (dragony < 300) {
					dragony += 4;
				}
			}
			
			
		
			if (message_id == 8) {
				missing[missing_id].paintIcon(this, g, dragonx, dragony);
				
				missing_t++;
				
				if (missing_t == 7 && missing_id < 7) {
					missing_t = 0;
					missing_id++;
				}
			}else if (dragon_action == 11 && dragony > 100) {
				Dragon3.paintIcon(this, g, dragonx,dragony);	
			}else {
				Dragon.paintIcon(this, g, dragonx,dragony );
			}
			
			

			if (dragon_action == 2 && light_id < 50) {
				g.drawImage(light[light_id].getImage(), 465, 360, null);
			} else if (dragon_action == 3 && light_id < 50) {
				g.drawImage(light[light_id].getImage(), 465, 360, null);
			} else if (dragon_action == 5 && light_id < 50) {
				g.drawImage(light[light_id].getImage(), 465, 110, null);
			} else if (dragon_action == 6 && light_id < 50) {
				g.drawImage(light[light_id].getImage(), 465, 110, null);
			} else if (dragon_action == 8 && light_id < 50) {
				g.drawImage(light[light_id].getImage(), 465, 235, null);
			} else if (dragon_action == 9 && light_id < 50) {
				g.drawImage(light[light_id].getImage(), 465, 235, null);
			} else if (dragon_action == 10 && light_id < 50) {
				g.drawImage(light[light_id].getImage(), 465, 235, null);
			} 
			
			
			if (dragon_action == 2 && light_id == 49) {
				light1.paintIcon(this, g, -30, 355);
				g.drawImage(light[light_id].getImage(), 465, 360, null);

				light_t++;
				if (fishy > 320 && fishy < 460) {
					isDied = true;
				}
				
				if (light_t == 50) {
					dragon_action++;
					light_t = 0;
					light_id = 0;
				}

			} else if (dragon_action == 3 && light_id == 49) {
				light2.paintIcon(this, g, -40, -5);
				g.drawImage(light[light_id].getImage(), 465, 360, null);

				light_t++;
				
				if (fishy > 10 && fishy < 180 && !open_red_Dragon && !open_evolution) {
					isDied = true;
				}
				

				if (light_t == 50) {
					dragon_action++;
					light_t = 0;
					light_id = 0;
				}
			} else if (dragon_action == 5 && light_id == 49) {
				light1.paintIcon(this, g, -30, 105);
				g.drawImage(light[light_id].getImage(), 465, 110, null);

				light_t++;
				if (fishy > 70 && fishy < 210 && !open_red_Dragon && !open_evolution) {
					isDied = true;
				}

				if (light_t == 50) {
					dragon_action++;
					light_t = 0;
					light_id = 0;
				}
			} else if (dragon_action == 6 && light_id == 49) {
				light3.paintIcon(this, g, -25, 85);
				g.drawImage(light[light_id].getImage(), 465, 110, null);

				light_t++;
				if (fishy > 400 && fishy < 560 && !open_red_Dragon && !open_evolution) {
					isDied = true;
				}

				if (light_t == 50) {
					dragon_action++;
					light_t = 0;
					light_id = 0;
				}
			} else if (dragon_action == 8 && light_id == 49) {
				light1.paintIcon(this, g, -30, 230);
				g.drawImage(light[light_id].getImage(), 465, 235, null);

				light_t++;
				if (fishy > 190 && fishy < 330 && !open_red_Dragon && !open_evolution) {
					isDied = true;
				}

				if (light_t == 50) {
					dragon_action++;
					light_t = 0;
					light_id = 0;
				}
			} else if (dragon_action == 9 && light_id == 49) {
				light5.paintIcon(this, g, -20, 240);
				g.drawImage(light[light_id].getImage(), 465, 235, null);

				light_t++;
				if (fishy > 445 && fishy < 595 && !open_red_Dragon && !open_evolution) {
					isDied = true;
				}

				if (light_t == 50) {
					dragon_action++;
					light_t = 0;
					light_id = 0;
				}
			} else if (dragon_action == 10 && light_id == 49) {
				light4.paintIcon(this, g, -25, -10);
				g.drawImage(light[light_id].getImage(), 465, 235, null);

				light_t++;
				if (fishy > -15 && fishy < 135 && !open_red_Dragon && !open_evolution) {
					isDied = true;
				}

				if (light_t == 50) {
					dragon_action = 1;
					light_t = 0;
					light_id = 0;
				}
			}

			if (open_fish_light) {
				fish_light.paintIcon(this, g, fish_lightx[fish_light_id], fish_lighty[fish_light_id]);

				if (fish_light_id >= 1) {
					fish_light.paintIcon(this, g, fish_lightx[fish_light_id - 1], fish_lighty[fish_light_id - 1]);
				}

				if (fish_light_id >= 2) {
					fish_light.paintIcon(this, g, fish_lightx[fish_light_id - 2], fish_lighty[fish_light_id - 2]);
				}
			}
			
			if (open_red_light && light_id>=0) {
				if (light_id <=48) {
					light[light_id].paintIcon(this, g, 175, 125);
				}else if (blood_id <21){
					red_light.paintIcon(this, g, 60, -85);
					light[45].paintIcon(this, g, 175, 125);
					
					blood_t++;
					
					if (blood_t == 7 && blood_id < 21) {
						blood_t = 0;
						blood_id++;
					}
				}
			}

			if (hit_Dragon) {
				Dragon2.paintIcon(this, g, dragonx, dragony);

				hit_dragon_t++;

				if (hit_dragon_t == 3) {
					hit_Dragon = false;
					hit_dragon_t = 0;
				}
			}

			if (open_message) {
				if (message_id <= 2) {
					message[message_id].paintIcon(this, g, 15, 480);
				} else if (message_id <= 4) {
					message[message_id].paintIcon(this, g, 15, 525);
				} else if (message_id <= 7) {
					message[message_id].paintIcon(this, g, 15, 480);
				}else {
					
				}

			}
			
			
			if (message_id == 5 && evolution_id < 13) { 
				open_evolution = true;
			}
			
			
			if (open_evolution) {
				evolution[evolution_id].paintIcon(this, g, fishx - evolution_id * 14, fishy - evolution_id * 30);
			}

			if (evolution_id < 13 && open_evolution) {
				evolution_t++;

				if (evolution_t == 5) {
					evolution_id++;
					evolution_t = 0;
				}
			} else if (evolution_id == 13) {
				evolution_t++;

				if (evolution_t == 5) {
					open_evolution = false;
					evolution_t = 0;
				}
			}
			
			if (!isStart) {
				logo.paintIcon(this, g, 275, 25);
				start.paintIcon(this, g, 125, 300);
			}

			if (isDied) {
				GG.paintIcon(this, g, 135, 150);
			}
			
			
			if (isSuccess && red_Dragonx==-75 && red_Dragony == 0) {
				//success.paintIcon(this, g, 450, 300);
				success.paintIcon(this, g, 460, 325);	
				logo.paintIcon(this, g, 470, 200);
			}
			
			
		}

		void loadimg() {
			light[0] = new ImageIcon("img/0.png");
			light[1] = new ImageIcon("img/0.png");
			light[2] = new ImageIcon("img/0.png");
			light[3] = new ImageIcon("img/0.png");
			light[4] = new ImageIcon("img/0.png");
			light[5] = new ImageIcon("img/1.png");
			light[6] = new ImageIcon("img/1.png");
			light[7] = new ImageIcon("img/1.png");
			light[8] = new ImageIcon("img/1.png");
			light[9] = new ImageIcon("img/1.png");
			light[10] = new ImageIcon("img/2.png");
			light[11] = new ImageIcon("img/2.png");
			light[12] = new ImageIcon("img/2.png");
			light[13] = new ImageIcon("img/2.png");
			light[14] = new ImageIcon("img/2.png");
			light[15] = new ImageIcon("img/3.png");
			light[16] = new ImageIcon("img/3.png");
			light[17] = new ImageIcon("img/3.png");
			light[18] = new ImageIcon("img/3.png");
			light[19] = new ImageIcon("img/3.png");
			light[20] = new ImageIcon("img/4.png");
			light[21] = new ImageIcon("img/4.png");
			light[22] = new ImageIcon("img/4.png");
			light[23] = new ImageIcon("img/4.png");
			light[24] = new ImageIcon("img/4.png");
			light[25] = new ImageIcon("img/5.png");
			light[26] = new ImageIcon("img/5.png");
			light[27] = new ImageIcon("img/5.png");
			light[28] = new ImageIcon("img/5.png");
			light[29] = new ImageIcon("img/5.png");
			light[30] = new ImageIcon("img/6.png");
			light[31] = new ImageIcon("img/6.png");
			light[32] = new ImageIcon("img/6.png");
			light[33] = new ImageIcon("img/6.png");
			light[34] = new ImageIcon("img/6.png");
			light[35] = new ImageIcon("img/7.png");
			light[36] = new ImageIcon("img/7.png");
			light[37] = new ImageIcon("img/7.png");
			light[38] = new ImageIcon("img/7.png");
			light[39] = new ImageIcon("img/7.png");
			light[40] = new ImageIcon("img/8.png");
			light[41] = new ImageIcon("img/8.png");
			light[42] = new ImageIcon("img/8.png");
			light[43] = new ImageIcon("img/8.png");
			light[44] = new ImageIcon("img/8.png");
			light[45] = new ImageIcon("img/9.png");
			light[46] = new ImageIcon("img/9.png");
			light[47] = new ImageIcon("img/9.png");
			light[48] = new ImageIcon("img/9.png");
			light[49] = new ImageIcon("img/9.png");

			message[0] = new ImageIcon("img/message1.gif");
			message[1] = new ImageIcon("img/message2.gif");
			message[2] = new ImageIcon("img/message3.gif");
			message[3] = new ImageIcon("img/message4.gif");
			message[4] = new ImageIcon("img/message5.gif");
			message[5] = new ImageIcon("img/message6.gif");
			message[6] = new ImageIcon("img/message7.gif");
			message[7] = new ImageIcon("img/message8.gif");

			blood[0] = new ImageIcon("img/b0.gif");
			blood[1] = new ImageIcon("img/b1.gif");
			blood[2] = new ImageIcon("img/b2.gif");
			blood[3] = new ImageIcon("img/b3.gif");
			blood[4] = new ImageIcon("img/b4.gif");
			blood[5] = new ImageIcon("img/b5.gif");
			blood[6] = new ImageIcon("img/b6.gif");
			blood[7] = new ImageIcon("img/b7.gif");
			blood[8] = new ImageIcon("img/b8.gif");
			blood[9] = new ImageIcon("img/b9.gif");
			blood[10] = new ImageIcon("img/b10.gif");
			blood[11] = new ImageIcon("img/b11.gif");
			blood[12] = new ImageIcon("img/b12.gif");
			blood[13] = new ImageIcon("img/b13.gif");
			blood[14] = new ImageIcon("img/b14.gif");
			blood[15] = new ImageIcon("img/b15.gif");
			blood[16] = new ImageIcon("img/b16.gif");
			blood[17] = new ImageIcon("img/b17.gif");
			blood[18] = new ImageIcon("img/b18.gif");
			blood[19] = new ImageIcon("img/b19.gif");
			blood[20] = new ImageIcon("img/b20.gif");
			blood[21] = new ImageIcon("img/b21.gif");

			evolution[0] = new ImageIcon("img/e0.gif");
			evolution[1] = new ImageIcon("img/e1.gif");
			evolution[2] = new ImageIcon("img/e2.gif");
			evolution[3] = new ImageIcon("img/e3.gif");
			evolution[4] = new ImageIcon("img/e4.gif");
			evolution[5] = new ImageIcon("img/e5.gif");
			evolution[6] = new ImageIcon("img/e6.gif");
			evolution[7] = new ImageIcon("img/e7.gif");
			evolution[8] = new ImageIcon("img/e8.gif");
			evolution[9] = new ImageIcon("img/e9.gif");
			evolution[10] = new ImageIcon("img/e10.gif");
			evolution[11] = new ImageIcon("img/e11.gif");
			evolution[12] = new ImageIcon("img/e12.gif");
			evolution[13] = new ImageIcon("img/e13.gif");
			
			missing[0] = new ImageIcon("img/m0.gif");
			missing[1] = new ImageIcon("img/m1.gif");
			missing[2] = new ImageIcon("img/m2.gif");
			missing[3] = new ImageIcon("img/m3.gif");
			missing[4] = new ImageIcon("img/m4.gif");
			missing[5] = new ImageIcon("img/m5.gif");
			missing[6] = new ImageIcon("img/m6.gif");
			missing[7] = new ImageIcon("img/m7.gif");
		}
	}

	class timertask extends TimerTask {

		@Override
		public void run() {

			

			if (isStart && !isDied && !open_message) {

	

				if (open_evolution) {
					if (fishy > 100) {
						fishy -= 3;
					}

					if (fishy < 100) {
						fishy += 3;
					}

				} else if (open_up_t) {
					up_t++;
					fishy -= 15;

				} else if (open_down_t) {
					fishy += 6;

				} else {
					fishy += 1;
					down_t++;

				}

				if (up_t == 5) {
					open_up_t = false;
					up_t = 0;
				}

				if (down_t == 60) {
					open_down_t = true;
					down_t = 0;
				}

				put_tube();
				run_tube();
				if (!open_red_Dragon) {
					Die_Check();
				}

				if (tube1x[tube1_id] == 110) {
					Score++;
				}
				if (tube2x[tube2_id] == 110) {
					Score++;
				}
				if (tube3x[tube3_id] == 110) {
					Score++;
				}

				if (open_Dragon && !open_red_Dragon) {
					if (dragonx != 500) {
						dragonx -= 5;
					}
				}

				if (dragon_action == 1 && dragony < 226) {
					dragony += 2;

					if (dragony == 226) {
						dragon_action++;
					}
				} else if (dragon_action == 4 && dragony > -26) {
					dragony -= 2;

					if (dragony == -26) {
						dragon_action++;
					}
				} else if (dragon_action == 7 && dragony < 100) {
					dragony += 2;

					if (dragony == 100) {
						dragon_action++;
					}
				}

				if (dragon_action == 2 && light_id < 49) {
					light_id++;
				} else if (dragon_action == 3 && light_id < 49) {
					light_id++;
				} else if (dragon_action == 5 && light_id < 49) {
					light_id++;
				} else if (dragon_action == 6 && light_id < 49) {
					light_id++;
				} else if (dragon_action == 8 && light_id < 49) {
					light_id++;
				} else if (dragon_action == 9 && light_id < 49) {
					light_id++;
				} else if (dragon_action == 10 && light_id < 49) {
					light_id++;
				}

				if (open_fish_light) {
					fish_lightx[fish_light_id] += 5;

					if (fish_light_id >= 1) {
						fish_lightx[fish_light_id - 1] += 5;
					}

					if (fish_light_id >= 2) {
						fish_lightx[fish_light_id - 2] += 5;
					}
				}
				// -----------------------------------------

				if (!open_next_light) {
					next_light_t++;
				}

				if (next_light_t == 20) {
					next_light_t = 0;
					open_next_light = true;
				}
				// -----------------------------------------------

				if (open_fish_light) {
					if (fish_lightx[fish_light_id] == 550) {
						if (fish_lighty[fish_light_id] >= dragony + 80 && fish_lighty[fish_light_id] <= dragony + 230) {
							hit_Dragon = true;
							blood_id++;
						}
					}

					if (fish_light_id >= 1) {
						if (fish_lightx[fish_light_id - 1] == 550) {
							if (fish_lighty[fish_light_id - 1] >= dragony + 80
									&& fish_lighty[fish_light_id - 1] <= dragony + 230) {
								hit_Dragon = true;
								blood_id++;
							}
						}
					}

					if (fish_light_id >= 2) {
						if (fish_lightx[fish_light_id - 2] == 550) {
							if (fish_lighty[fish_light_id - 2] >= dragony + 80
									&& fish_lighty[fish_light_id - 2] <= dragony + 230) {
								hit_Dragon = true;
								blood_id++;
							}
						}
					}
				}
			}

			if (isDied) {
				fishy += 8;
			}

			if (open_died_t) {
				died_t++;
			}

			if (died_t == 4) {
				open_died_t = false;
				died_t = 0;
			}

			// ----------------------------

			repaint();

		}

	}

	class Action implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub

			int KeyCode = e.getKeyCode();

			if (!isStart && KeyCode == KeyEvent.VK_ENTER) {
				isStart = true;
			}

			if (isStart && KeyCode == KeyEvent.VK_SPACE) {
				isStart = false;
			}

			boolean UP_Key = KeyCode == KeyEvent.VK_UP || KeyCode == KeyEvent.VK_W;

			if (isStart && UP_Key) {
				// fishy -= 75;

				open_up_t = true;
				open_down_t = false;
			}

			if ((isDied || isSuccess) && KeyCode == KeyEvent.VK_ENTER) {
				initFlappyFish();
			}

			if (open_message) {
				if (KeyCode == KeyEvent.VK_RIGHT) {
					message_id++;
				}

				if (blood_id == 0 && message_id == 4) {
					open_message = false;
					dragon_action++;
				}

				if (message_id == 5) {
					open_message = false;
				}
				
				if (message_id == 7) {
					open_message = false;
					open_red_light = true;
					light_id = -3;
					open_message = false;
				}

			}

			if (open_Dragon && !open_message && !open_red_light) {
				if (KeyCode == KeyEvent.VK_ENTER && open_next_light) {

					fish_light_id++;
					fish_lightx[fish_light_id] = fishx + 70;
					fish_lighty[fish_light_id] = fishy + 25;

					open_fish_light = true;
					open_next_light = false;
				}
			}
			
			if (open_red_light) {
				if (KeyCode == KeyEvent.VK_ENTER) {
					light_id+=3;
				}
			}
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

	}

}
