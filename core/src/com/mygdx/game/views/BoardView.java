package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
 import com.mygdx.game.views.*;

public class BoardView extends ScreenAdapter{
	private SpriteBatch batch;
	private WhitePawn white;
	
	@Override
    public void show()
    {
		white=new WhitePawn();
    	batch = new SpriteBatch();
    }
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		white.draw(batch);
		batch.end();
	}

}
