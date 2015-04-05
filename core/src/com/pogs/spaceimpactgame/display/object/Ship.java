package com.pogs.spaceimpactgame.display.object;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Ship extends Sprite implements InputProcessor{
	
	public int targetX;
	public int targetY;
	private float time;
	
	private ArrayList<Bullet> bullets;
	
	public Ship(String path) {
		super(new Texture(path));
		//setTexture(new Texture(path));
		setSize(40, 50);
	}
	
	@Override
	public void draw(Batch batch) {
		super.draw(batch);
	}

	public void update(float delta) {
		if(getX() < targetX) {
			setX(getX() + 2);
			if(getX() >= targetX ) setX(targetX);
		}
		if(getX() > targetX) {
			setX(getX() - 2);
			if(getX() <= targetX ) setX(targetX);
		}
	
		if(getY() < targetY){
			setY(getY() + 2);
			if(getY() >= targetY ) setY(targetY);
		}
		
		if(getY() > targetY) {
			setY(getY() - 2);
			if(getY() <= targetY ) setY(targetY);
		}
		
		time += delta;
		if(time > 1) {
			shootBullet();
			time = 0;
		}
	}

	private void shootBullet() {
		Bullet b = new Bullet("bullet.png");
		b.setPosition(getX() + (getWidth()/2) - (b.getWidth()/2), getY()+(getHeight()));
		bullets.add(b);
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		targetX = screenX - (int)(getWidth()/2);
		targetY = Gdx.app.getGraphics().getHeight() - screenY - (int)( getHeight()/2);
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

	public ArrayList<Bullet> getBullets() {
		return bullets;
	}

	public void setBullets(ArrayList<Bullet> bullets) {
		this.bullets = bullets;
	}
	
	
	
}
