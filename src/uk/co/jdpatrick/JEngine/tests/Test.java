package uk.co.jdpatrick.JEngine.tests;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import uk.co.jdpatrick.JEngine.Level.TiledLevel;
import uk.co.jdpatrick.JEngine.Particle.BloodParticle;
import uk.co.jdpatrick.JEngine.Particle.ParticleSystem;

/**
 * @author Jack Patrick
 */
public class Test extends BasicGame {

    TiledLevel level;

    public Test(String title) {
        super(title);
    }

    ParticleSystem p = new ParticleSystem();

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        level = new TiledLevel("/res/level.png");
    }

    int pX = 0;
    int pY = 0;

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
        if (Mouse.isButtonDown(0)) {
            p.addParticle(new BloodParticle(pX, pY));
        }
        p.update();

        if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
            pY--;
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
            pX--;
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
            pY++;
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
            pX++;
        }

        System.out.println(pX + ":" + pY);


        level.c.center(pX, pY, level.getWidth(), level.getHeight());
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        level.render(graphics);
        p.render(graphics, level.c.getX(), level.c.getY());

    }
}
