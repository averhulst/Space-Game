package game;

import game.entity.BackGround;
import game.entity.Entity;
import game.entity.enemy.EnemyFactory;
import game.entity.enemy.EnemyFighter;
import game.entity.projectile.Projectile;
import game.entity.unit.Player;
import game.entity.unit.Unit;
import org.newdawn.slick.*;
import java.util.ArrayList;
import java.util.List;

public class Game extends BasicGame {
    public static final int WINDOW_HEIGHT = 1200;
    public static final int WINDOW_WIDTH = 800;
    private Entity backGround;
    private Player player;
    private List<Unit> enemies =  new ArrayList<Unit>();
    private List<Projectile> projectiles = new ArrayList<Projectile>();

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
        enemies.add(EnemyFactory.buildEnemy("fighter", new Vector(50,50)));
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException{
        List<Entity> projectilesToRemove = new ArrayList<>();
        backGround.update();

        for(Projectile p : projectiles){
            if(isOnScreen(p)){
                p.update();

                for(Unit e : enemies){
                    if(p.collidesWith(e)){
                        e.applyDamage(p.getDamage());
                    }
                }

            }else{
                projectilesToRemove.add(p);
            }
        }

        for(Entity p : projectilesToRemove){
            projectiles.remove(p);
        }

        for(Entity e : enemies){
            e.update();
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

        for(Entity e : enemies){
            e.render();
        }

    }

    private boolean isOnScreen(Entity e){
        return
                e.getYPosition() > 0 && e.getYPosition() < Game.WINDOW_HEIGHT
                &&
                e.getXPosition() > 0 && e.getXPosition() < Game.WINDOW_WIDTH;
    }
}
