package game;

import game.entity.BackGround;
import game.entity.Entity;
import game.entity.unit.Player;
import org.newdawn.slick.*;
import java.util.ArrayList;
import java.util.List;

public class Game extends BasicGame {
    public static final int WINDOW_HEIGHT = 1200;
    public static final int WINDOW_WIDTH = 800;
    private Entity backGround;
    private Player player;
    private List<Entity> enemies =  new ArrayList<Entity>();
    private List<Entity> projectiles = new ArrayList<Entity>();

    public Game(){
        super("Space Game");
    }

    public static void run(){
        try{
            AppGameContainer app = new AppGameContainer(new Game());
            app.setDisplayMode(WINDOW_WIDTH, WINDOW_HEIGHT, false);
            app.setTargetFrameRate(60);
            app.start();
        }
        catch (SlickException e){
            e.printStackTrace();
        }
    }

    @Override
    public void init(GameContainer container) throws SlickException{
        backGround = new BackGround();
        player = new Player();
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException{
        backGround.update();

        for(Entity p : projectiles){
            p.update();
        }
        player.update();

        projectiles.addAll(player.getFiredProjectiles());

    }

    public void render(GameContainer container, Graphics g) throws SlickException{
        backGround.render();
        player.render();
        for(Entity p : projectiles){
            p.render();
        }
    }
}
