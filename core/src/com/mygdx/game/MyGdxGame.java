package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.mygdx.game.views.*;

public class MyGdxGame extends Game {
	@Override
	public void create () {
		setScreen(new BoardView());
	}


}


