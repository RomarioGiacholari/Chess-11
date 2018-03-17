package com.mygdx.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldFilter;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class OptionScreen implements Screen{
	private MainClass main;
	private Stage stage = new Stage(new ScreenViewport());
	private SpriteBatch batch = new SpriteBatch();
	private LoadingScreen music;
	private LoadingScreen sound;
	private LoadingScreen texture;
	private LoadingScreen skin;
	private Boolean musicOnOff = true;
	
	public OptionScreen(MainClass parent) {
		main = parent;
		Gdx.input.setInputProcessor(stage); 
		music = new LoadingScreen(parent);
		sound = new LoadingScreen(parent);
		texture = new LoadingScreen(parent);
		skin = new LoadingScreen(parent);
	}
	
	@Override
	public void show() {
		Table table = new Table();
		table.setFillParent(true);
		
		final Label labelMusic = new Label("Music", getSkin());
		final Label labelVolume = new Label("Volume : 100%", getSkin());
		final Label deltaTime = new Label("Delta Time", getSkin());
		final Slider volumeSlider = new Slider(0, 4, 1, false, getSkin());
		final TextButton musicButton = new TextButton("Music : On", getSkin(), "default");
		final TextButton backGameButton = new TextButton("Back", getSkin(), "default");
		final TextField deltaField = new TextField("0 to 1", getSkin());
		
		volumeSlider.setAnimateDuration(0.05f);
		volumeSlider.setValue(6);
		deltaField.setTextFieldFilter(new TextFieldFilter.DigitsOnlyFilter());
		deltaField.setMaxLength(3);
		
		musicButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				getSound().play(0.75f);
				if(musicOnOff == true) {
					musicButton.setText("Music : Off");
					LoadingScreen.muteFX();
					musicOnOff = false;
				} else {
					musicButton.setText("Music : On");
					LoadingScreen.playFX();
					musicOnOff = true;
				}
			}
		});
		volumeSlider.addListener(new ChangeListener() {
			public void changed (ChangeEvent event, Actor actor) {
				getMusic().setVolume(volumeSlider.getValue());
				float sliderValue = getVolumeValue();
				if(sliderValue == 0) {
					getMusic().setVolume(0.0f);
					labelVolume.setText("Volume: 0%");
				} else if (sliderValue == 4) {
					getMusic().setVolume(1.0f);
					labelVolume.setText("Volume: 100%");
				} else if (sliderValue == 3) {
					getMusic().setVolume(0.75f);
					labelVolume.setText("Volume: 75%");
				} else if (sliderValue == 1) {
					getMusic().setVolume(0.25f);
					labelVolume.setText("Volume: 25%");
				} else {
					getMusic().setVolume(0.50f);
					labelVolume.setText("Volume: 50%");
				}
			}
		});
		backGameButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				main.setScreen(new MenuScreen(main));
				getSound().play(0.75f);
			}
		});
		table.add(labelMusic).pad(5);
		table.row();
		table.add(musicButton).pad(5);
		table.row();
		table.add(labelVolume).pad(5);
		table.row();
		table.add(volumeSlider).pad(5);
		table.row();
		table.add(deltaTime).pad(5);
		table.row();
		table.add(deltaField).pad(5);
		table.row();
		table.add(backGameButton).pad(5);
		stage.addActor(table);
	}
	
	public Music getMusic() {
		return music.getMusic();
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
	
	public float getVolumeValue() {
		float value = getMusic().getVolume();
		return value;
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
		music.dispose();
		sound.dispose();
	}

}
