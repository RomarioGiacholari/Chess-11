package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BoardView extends ScreenAdapter{
	private SpriteBatch batch;
	private Texture logo;
	
	@Override
    public void show()
    {
    	batch = new SpriteBatch();
    	logo = new Texture(Gdx.files.internal("badlogic.jpg"));
    }
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(255,255,255,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		batch.draw(logo,50,50,100,100);
		batch.draw(logo, 0,0,100,100);
		batch.end();
	}

}
