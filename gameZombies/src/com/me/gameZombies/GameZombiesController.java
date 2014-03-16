package com.me.gameZombies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class GameZombiesController extends InputAdapter {
	private Pixmap plataforma;
	public Texture textura;
	//incorpora movimiento
	public Sprite cubo;
	
	public GameZombiesController() {
		Init();
	}
	
	public void Init(){
		this.initPlataformas();
		Gdx.input.setInputProcessor(this);
		
	}
	
	public void update(float deltaTime){
		//movimiento
		hdlKeys(deltaTime);
	}
	
	public void initPlataformas(){
		plataforma = new Pixmap (32, 32, Format.RGBA8888);
		plataforma.setColor(1,0,0,0.5f);
		plataforma.fill();
		plataforma.setColor(1,1,0,1);
		plataforma.drawLine(0,0,32,32);
		plataforma.drawLine(32,0,0,32);
		plataforma.setColor(0,1,1,1);
		plataforma.drawRectangle(0,0,32,32);
		
		//Cargas texturas
		textura = new Texture(plataforma);
		cubo = new Sprite(textura);
		//Posicionamos el cubo en...
		cubo.setPosition(0, 0);
		plataforma.dispose();
		//sprite = new Sprite (textura);
	}
	
	private void hdlKeys(float deltaTime){
		
		float moveSpeed=200*deltaTime;
		//capturar apretar teclas
		if(Gdx.input.isKeyPressed(Keys.A)){
			this.moveCube(-moveSpeed, 0);	
		}
		if(Gdx.input.isKeyPressed(Keys.W)){
			this.moveCube(0, moveSpeed);
		}
		if(Gdx.input.isKeyPressed(Keys.S)){
			this.moveCube(0, -moveSpeed);
		}
		if(Gdx.input.isKeyPressed(Keys.D)){
			this.moveCube(moveSpeed, 0);
		}
	}
	
	//Implementamos método para mover el cubo
	private void moveCube(float xAmount, float yAmount){
		cubo.translate(xAmount, yAmount);
	}
	
	@Override
	public boolean keyUp (int Keycode){
		//Reiniciamos el juego
		if(Keycode==Keys.ESCAPE){
			this.Init();
		}
		return true;
	}
}
