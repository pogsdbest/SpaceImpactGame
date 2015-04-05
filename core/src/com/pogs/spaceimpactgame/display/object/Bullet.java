package com.pogs.spaceimpactgame.display.object;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Bullet extends Sprite {
	
	public float maxScreenY;
	public boolean readyToDestroy;
	
	public Bullet(String path) {
		super(new Texture(path));
		readyToDestroy = false;
		maxScreenY = Gdx.graphics.getHeight();
		setSize(10, 20);
	}
	
	@Override
	public void draw(Batch batch) {
		
		super.draw(batch);
	}

	public void update(float deltaTime) {
		setY(getY() + 10);
		
		if(getY() > maxScreenY) {
			readyToDestroy = true;
		}
	}
	
	

}
