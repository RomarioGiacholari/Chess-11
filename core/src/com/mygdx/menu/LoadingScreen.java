package com.mygdx.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class LoadingScreen implements Screen {
	private MainClass main;
	private static Music music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
	private static Sound sound = Gdx.audio.newSound(Gdx.files.internal("clickSound.mp3"));
	private static Texture texture = new Texture(Gdx.files.internal("BackgroundImage.jpg"));
	private static Skin skin = new Skin(Gdx.files.internal("craftacular-ui.json"));
	private static boolean backgroundMusicPlaying;
	
	public LoadingScreen(MainClass parent) {
		main = parent;
		playFX();
	}
	
	public Skin getSkin() {
		return skin;
	}
	
	public Texture getTexture() {
		return texture;
	}
	
	public Music getMusic() {
		return music;
	}
	
	public Sound getSound() {
		return sound;
	}
	
	public static void playFX() {
		if(backgroundMusicPlaying != true) {
			music.play();
			music.setVolume(1.0f);
			music.setLooping(true);
			backgroundMusicPlaying = true;
		}
	}
	public static void muteFX() {
		if(backgroundMusicPlaying == true) {
			music.stop();
			backgroundMusicPlaying = false;
		}
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
	}

	@Override
	public void render(float delta) {
		main.changeScreen(MainClass.MENU);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
