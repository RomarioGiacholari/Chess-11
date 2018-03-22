package com.mygdx.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class GameSettings implements Screen {
	private MainClass main;
	private Stage stage = new Stage(new ScreenViewport());
	private SpriteBatch batch = new SpriteBatch();
	private LoadingScreen sound;
	private LoadingScreen texture;
	private LoadingScreen skin;
	private LoadingScreen image;
	private LoadingScreen music;
	private boolean blackOrWhite = true;
	private boolean timeBool = true;
	private boolean anoBool = true;
	private boolean muted = false;
	
	public GameSettings(MainClass parent) {
		main = parent;
		Gdx.input.setInputProcessor(stage); 
		sound = new LoadingScreen(parent);
		texture = new LoadingScreen(parent);
		skin = new LoadingScreen(parent);
		image = new LoadingScreen(parent);
		music = new LoadingScreen(parent);
	}
	@Override
	public void show() {
		Table table = new Table();
		table.setFillParent(true);
		
		final Label labelPlayerColor = new Label("Player Color : White", getSkin());
		final TextButton startGameButton = new TextButton("Start Game!", getSkin(), "default");
		final TextButton backGameButton = new TextButton("Back", getSkin(), "default");
		final Slider playerSlider = new Slider(0, 1, 1, false, getSkin());
		
		Image soundImage = new Image(image.getImage());
		soundImage.setX(5);
		soundImage.setY(435);
		
		soundImage.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if(music.getMusic().getVolume() == 1.0f && muted == false) {
					music.getMusic().setVolume(0.0f);
					sound.getSound().play(0.75f);
					muted = true;
				} else {
					music.getMusic().setVolume(1.0f);
					sound.getSound().play(0.75f);
					muted = false;
				}
			}
		});
		playerSlider.addListener(new ChangeListener() {
			@Override
			public void changed (ChangeEvent event, Actor actor) { {
				if(playerSlider.isDragging()) {
					getSound().play(0.75f);
					if(blackOrWhite == false) {
						labelPlayerColor.setText("Player Color : White");
						blackOrWhite = true;
					} else {
						labelPlayerColor.setText("Player Color : Black");
						blackOrWhite = false;
					}
				}
			}
			}
		});
		startGameButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				getSound().play(0.75f);
			}
		});
		backGameButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				getSound().play(0.75f);
				main.setScreen(new PlayerScreen(main));
			}
		});
		
		table.add(labelPlayerColor).pad(10);
		table.row();
		table.add(playerSlider).pad(10);
		table.row();
		table.add(startGameButton).pad(10);
		table.row();
		table.add(backGameButton).pad(10);
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
		batch.dispose();
		texture.dispose();
		sound.dispose();
		image.dispose();
		music.dispose();
	}

}
