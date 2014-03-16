package com.me.gameZombies;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;


public class GameZombiesRender implements Disposable {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private GameZombiesController gC;
	
	//Objetos gráficos
	//private Sprite sprite;

	public GameZombiesRender(GameZombiesController gC) {
		init();
		this.gC=gC;
	}
	public void init(){
		//Visión de la cámara
		camera = new OrthographicCamera(480,320);
		camera.position.set(0, 0, 0);
		camera.update();
		
		//Escenario
		batch = new SpriteBatch();
		
		
	}
	public void render(){
		batch.setProjectionMatrix(camera.combined);
		
		batch.begin();
		//Le decimos que pinte nuestro sprite batch(el cubo)
		gC.cubo.draw(batch);
		batch.end();
	}
	public void resize(int width, int height) {}
	@Override
	public void dispose() {}

}
