package at.mat.game.objects;

import org.newdawn.slick.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class EasyGame extends BasicGame {

        public static final String name = "Vogel";
        public static final int id = 0;
        public static final int width = 640;
        public static final int height = 480;
        private int score;
         private NewVogel bird;
         private Image background;
        private List<Obstacle> obstacles;

        public EasyGame(String title) {
            super(title);
            obstacles = new ArrayList<>();
        }



    public static void main(String[] args) throws SlickException {
        AppGameContainer container = new AppGameContainer(new Game("Vogel"));
        container.setDisplayMode(1024, 768, false);
        //container.setClearEachFrame(false);
        container.setMinimumLogicUpdateInterval(25);
        container.setTargetFrameRate(60);
        container.setShowFPS(true);
        container.start();
    }



    @Override
    public void init(GameContainer container) throws SlickException {
        background = new Image("assets/pics/background.png");
        bird = new NewVogel(100,100, new Image ("assets/pics/meinufo.png"));
        obstacles.add(new Obstacle(800, 300, new Image("assets/pics/obstacle.png")));
        obstacles.add(new Obstacle(1200, 200, new Image("assets/pics/obstacle.png")));


    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        Input input = container.getInput();

        // Fenster mit ESC sclie?en
        if (input.isKeyPressed(Input.KEY_ESCAPE)) {
            container.exit();
        }
        // Bewegung des Vogels aktualisieren
    bird.update(delta);

    // Kollisionserkennung zwischen Vogel und Hindernissen
        for (Obstacle obstacle; obstacles;) {
        if (bird.intersects(obstacle)) {
            // Kollision! Hier kann man Spiellogik für den Fall einer Kollision implementieren
            container.exit(); // Spiel beenden
            score++; // Punktestand erhöhen
        }
        }

        // Hindernisse bewegen
        Iterator<Obstacle> iterator = obstacles.iterator();
        while (iterator.hasNext()) {
            Obstacle obstacle = iterator.next();
            obstacle.update(delta);
            // Entferne Hindernis, wenn es außerhalb des Bildschirms ist
            if (obstacle.getX() + obstacle.getWidth() < 0) {
                iterator.remove();
            }
        }
    }


    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        background.draw();
        bird.draw(g);
        for (Obstacle obstacle : obstacles) {
            obstacle.draw();
        }
    }
}

