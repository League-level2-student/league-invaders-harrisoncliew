import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	
	int score = 0;

	Random random = new Random();
	RocketShip r;
	ArrayList<Projectile> projectiles = new ArrayList();
	ArrayList<Alien> aliens = new ArrayList();

	public ObjectManager(RocketShip r) {

		this.r = r;
	}
	
	 int getScore() {
		return score;
	}

	void addProjectile(Projectile p) {
		projectiles.add(p);
	}

	void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
	}

	void update() {
		for (int i = 0; i < aliens.size(); i++) {
			Alien temp = aliens.get(i);
			temp.update();
			if (temp.y > LeagueInvaders.HEIGHT) {
				temp.isActive = false;
			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			Projectile temp = projectiles.get(i);
			temp.update();
			if (temp.y > LeagueInvaders.HEIGHT) {
				temp.isActive = false;
			}
		}
		checkCollision();
		purgeObjects();
	}

	void draw(Graphics g) {
		r.draw(g);
		for (int i = 0; i < aliens.size(); i++) {
			Alien temp = aliens.get(i);
			temp.draw(g);

		}
		for (int i = 0; i < projectiles.size(); i++) {
			Projectile temp = projectiles.get(i);
			temp.draw(g);

		}
	}
	void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++) {
			Alien temp = aliens.get(i);
			if(temp.isActive==false) {
				aliens.remove(i);
			}

		}
		for (int i = 0; i < projectiles.size(); i++) {
			Projectile temp = projectiles.get(i);
			if(temp.isActive==false) {
				projectiles.remove(i);
			}

		}
	}
	void checkCollision() {
		for (int i = 0; i < aliens.size(); i++) {
			if(r.collisionBox.intersects(aliens.get(i).collisionBox)) {
				aliens.get(i).isActive = false;
				r.isActive = false;
			}
		for(int j = 0; j < projectiles.size(); j++) {
			if(aliens.get(i).collisionBox.intersects(projectiles.get(j).collisionBox)) {
				aliens.get(i).isActive = false;
				projectiles.get(j).isActive = false;
				score++;
			}
			
			
		}
	}
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
		
	}
}
