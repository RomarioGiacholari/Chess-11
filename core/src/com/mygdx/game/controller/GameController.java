package com.mygdx.game.controller;

import com.mygdx.game.models.*;
import com.mygdx.game.rules.ClickListener;

public class GameController{

    public GameController(chessGame game){

         game = new chessGame();
         ClickListener clickListener = new ClickListener();
    }

}