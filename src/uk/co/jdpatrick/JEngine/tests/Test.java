package uk.co.jdpatrick.JEngine.tests;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import uk.co.jdpatrick.JEngine.Particle.BloodParticle;
import uk.co.jdpatrick.JEngine.Particle.ParticleSystem;

/**
 * @author Jack Patrick
 *
 */
public class Test extends BasicGame{

    public Test(String title) {
        super(title);
    }

    ParticleSystem p = new ParticleSystem();

    @Override
    public void init(GameContainer gameContainer) throws SlickException {

    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
    if(Mouse.isButtonDown(0)){
        p.addParticle(new BloodParticle(50,50));
    }
        p.update();
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        p.render(graphics,0,0);
    }
}
