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
         private Arrow arrow;
        private List<Obstacle> obstacles;
        private List<Arrow> arrows;
        private Music music;



        public EasyGame(String title) {
            super(title);
            obstacles = new ArrayList<>();
        }



    public static void main(String[] args) throws SlickException {
        AppGameContainer container = new AppGameContainer(new EasyGame("Vogel"));
        container.setDisplayMode(728, 728, false);
        //container.setClearEachFrame(false);
        container.setMinimumLogicUpdateInterval(25);
        container.setTargetFrameRate(60);
        container.setShowFPS(true);
        container.start();
    }



    @Override
    public void init(GameContainer container) throws SlickException {
        background = new Image("assets/pics/Hintergrund.png");
        bird = new NewVogel(100,100, new Image ("assets/pics/meinufo.png"),"assets/animation/texture.def","1Vogel");
        obstacles.add(new Obstacle(800, 300, new Image("assets/pics/obstacle.png"),"Stein1"));
        obstacles.add(new Obstacle(1200, 200, new Image("assets/pics/obstacle.png"),"Stein2"));
        arrow = new Arrow(320, 600, new Image("assets/pics/arrow.png"));
        music = new Music("assets/sound/music_game.ogg");
        music.play();

    }

    @Override

    public void update(GameContainer container, int delta) throws SlickException {
        Input input = container.getInput();

        // Fenster mit ESC sclie?en
        if (input.isKeyPressed(Input.KEY_ESCAPE)) {
            container.exit();
        }

        // mit space starte pfeil
        if (input.isKeyPressed(Input.KEY_SPACE)) {
            arrow.setShooting(true);
        }
        if (input.isKeyPressed(Input.KEY_D)) {
            arrow.rotate(0);
        }
        if (input.isKeyPressed(Input.KEY_S)) {
            arrow.rotate(1);
        }


        // Bewegung des Vogels aktualisieren
        bird.update(delta);

        // arrow update
        arrow.update(delta);

    // Kollisionserkennung zwischen Vogel und Hindernissen
        for (Arrow arrow1;) {
            if (bird.intersects(arrow.getBounds())) {
                //
                //container.exit(); // Spiel beenden
                if (arrow.getBounds() == "") System.out.println("Volltreffer!");
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
        arrow.draw(g);
        for (Obstacle obstacle : obstacles) {
            obstacle.draw();
        }
    }
}

