package com.mygdx.menu;
import com.badlogic.gdx.Game;

public class MainClass extends Game {

<<<<<<< HEAD
  private LoadingScreen loadingScreen;
  
  @Override
  public void create() {
    loadingScreen = new LoadingScreen(this);
    setScreen(loadingScreen);
  }
  
  public void render() {
    super.render();
  }

  public void dispose() {
    super.dispose();
  }  
=======
	private LoadingScreen loadingScreen;
	
	@Override
	public void create() {
		loadingScreen = new LoadingScreen(this);
		setScreen(loadingScreen);
	}
	
	public void render() {
		super.render();
	}

	public void dispose() {
		super.dispose();
	}	
>>>>>>> ab6b0c7eb88d41f93830e2dd7f67c1baee5ad296

}