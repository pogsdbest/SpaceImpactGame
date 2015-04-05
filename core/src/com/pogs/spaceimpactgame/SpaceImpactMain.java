package com.pogs.spaceimpactgame;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pogs.spaceimpactgame.display.object.Bullet;
import com.pogs.spaceimpactgame.display.object.Ship;

public class SpaceImpactMain extends ApplicationAdapter {
	
	
	private SpriteBatch batch;
	private Texture bg;
	private Ship ship;
	
	private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	
	
	private boolean moving = false;

	@Override
	public void create () {
		batch = new SpriteBatch();
		bg = new Texture("bg.png");
		
		ship = new Ship("ship.png");
		ship.setBullets(bullets);
		
		Gdx.input.setInputProcessor(ship);
		
		
	}

	@Override
	public void render () {
		batch.begin();
		batch.draw(bg,0,0);
		ship.draw(batch);
		ship.update(Gdx.graphics.getDeltaTime());
		
		for(int i=0;i<bullets.size();i++) {
			
			bullets.get(i).draw(batch);
			bullets.get(i).update(Gdx.graphics.getDeltaTime());
			
		}
		
		for(int i=0;i<bullets.size();i++) {
			
			if(bullets.get(i).readyToDestroy) {
				bullets.remove(i);
			}
		}
		
		
		
		batch.end();
		
		
	}
	
	
	
	@Override
	public void dispose() {
		
		super.dispose();
	}
}
