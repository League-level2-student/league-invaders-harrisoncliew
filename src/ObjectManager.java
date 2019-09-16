import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {

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
		for(int i=0; i<aliens.size(); i++) {
			Alien temp = aliens.get(i);
			temp.update();
			if(temp.y>LeagueInvaders.HEIGHT) {
				temp.isActive = false;
			}
		}
	}
}
