import javax.swing.*;
public class LeagueInvaders {
public static void main(String[] args) {
	LeagueInvaders league = new LeagueInvaders();
		league.setup();
		
}
JFrame frame;
GamePanel panel;
public static final int WIDTH = 500;
public static final int HEIGHT = 800;
public LeagueInvaders(){
	frame = new JFrame();
	panel = new GamePanel();
}
void setup() {
	frame.add(panel);
	frame.setVisible(true);
	frame.setSize(WIDTH, HEIGHT);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

}
