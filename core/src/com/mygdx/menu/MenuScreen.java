package com.mygdx.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MenuScreen implements Screen {
	private MainClass main;
	private Stage stage = new Stage(new ScreenViewport());
	private SpriteBatch batch = new SpriteBatch();
	private LoadingScreen sound;
	private LoadingScreen texture;
	private LoadingScreen skin;
	
	private Texture soundButton = new Texture(Gdx.files.internal("soundButton.png"));
	private Texture titleImage = new Texture(Gdx.files.internal("title.png"));
	
	private boolean muted = true;
	
	public MenuScreen(MainClass parent) {
		main = parent;
		Gdx.input.setInputProcessor(stage); 
		sound = new LoadingScreen(parent);
		texture = new LoadingScreen(parent);
		skin = new LoadingScreen(parent);
	}
	@Override
	public void show() {
		Table table = new Table();
		table.setFillParent(true);
		
		final TextButton startGameButton = new TextButton("Start", getSkin(), "default"); 
		final TextButton optionsGameButton = new TextButton("Options", getSkin(), "default"); 
		final TextButton quitGameButton = new TextButton("Quit", getSkin(), "default");
		
		Image soundImage = new Image(soundButton);
		soundImage.setX(5);
		soundImage.setY(535);
		
		Image title = new Image(titleImage);
		
		soundImage.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if(muted == true) {
					LoadingScreen.muteFX();
					muted = false;
				} else {
					LoadingScreen.playFX();
					muted = true;
				}
					
			}
		});
		
		startGameButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				getSound().play(0.75f);
				main.setScreen(new GameScreen(main));
			}
		});
		optionsGameButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				getSound().play(0.75f);
				main.setScreen(new OptionScreen(main));
			}
		});
		quitGameButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				getSound().play(0.75f);
				Gdx.app.exit();
			}
		});
		table.add(title).pad(15);
		table.row();
		table.add(startGameButton).pad(10);
		table.row();
		table.add(optionsGameButton).pad(10);
		table.row();
		table.add(quitGameButton).pad(10);
		table.row();
		stage.addActor(table);
		stage.addActor(soundImage);
	}
	
	public Sound getSound() {
		return sound.getSound();
	}
	
	public Texture getTexture() {
		return texture.getTexture();
	}
	
	public Skin getSkin() {
		return skin.getSkin();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 30 / 30f));
		batch.begin();
		batch.draw(getTexture(), 0, 0);
		batch.end();
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
	}

	@Override
	public void pause() {}

	@Override
	public void resume() {}

	@Override
	public void hide() {}

	@Override
	public void dispose() {
		stage.dispose();
		skin.dispose();
		texture.dispose();
		batch.dispose();
		sound.dispose();
	}
}