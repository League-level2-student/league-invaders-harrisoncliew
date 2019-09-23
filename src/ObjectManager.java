import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {

	Random random = new Random();
	RocketShip r;
	ArrayList<Projectile> projectiles = new ArrayList();
	ArrayList<Alien> aliens = new ArrayList();

	public ObjectManager(RocketShip r) {

		this.r = r;
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
		
	}
}
