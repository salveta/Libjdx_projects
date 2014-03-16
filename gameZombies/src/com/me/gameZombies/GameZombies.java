package com.me.gameZombies;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class GameZombies implements ApplicationListener {
	//Creamos objeto
	private GameZombiesController gameController; 
	private GameZombiesRender gameRenderer;
	
	
	@Override
	public void create() {		
		//Inicializamos objeto
		gameController = new GameZombiesController();
		gameRenderer = new GameZombiesRender(gameController);
	}

	@Override
	public void dispose() {

	}

	@Override
	public void render() {		
		gameController.update(Gdx.graphics.getDeltaTime());
		Gdx.gl.glClearColor(0.64f, 0.95f, 0.95f, 1f);
		//Clear the screen
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		//Render game world to screen
		gameRenderer.render();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
