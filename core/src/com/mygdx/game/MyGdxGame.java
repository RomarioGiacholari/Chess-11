package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter; 
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.views.*;

import com.mygdx.game.controller.*;
public class MyGdxGame extends ApplicationAdapter {
	

	private static final int GRID_CELL = 32;
	 private ShapeRenderer shapeRenderer;
	 
	 public void show(){
		 
		 shapeRenderer = new ShapeRenderer();
	 }

	 private void drawGrid() {
		 shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
		 for (int x = 0; x < Gdx.graphics.getWidth(); x += GRID_CELL) {
			 for (int y = 0; y < Gdx.graphics.getHeight(); y += GRID_CELL) {
				 shapeRenderer.rect(x,y, GRID_CELL, GRID_CELL);
			 }
		 }
		 shapeRenderer.end();
	}
	 
	 public void render(float delta) {
		// Other code omitted for now
		drawGrid();
		draw();
		}

	 shapeRenderer.rect(100,100, GRID_CELL, GRID_CELL);

}


