package com.mygdx.menu;
import com.badlogic.gdx.Game;

public class MainClass extends Game {

	public static final int MENU = 0;
	
	private LoadingScreen loadingScreen;
	private MenuScreen menuScreen;
	
	@Override
	public void create() {
		loadingScreen = new LoadingScreen(this);
		setScreen(loadingScreen);
	}
	
	public void changeScreen(int screen) {
		switch(screen){
		case MENU:
			if(menuScreen == null) menuScreen = new MenuScreen(this);
			this.setScreen(menuScreen);
			break;
		}
	}

	public void render() {
		super.render();
	}

	public void dispose() {
		super.dispose();
	}	

}
