package com.mygdx.menu;

<<<<<<< HEAD
import com.badlogic.gdx.Gdx; 
=======
import com.badlogic.gdx.Gdx;
>>>>>>> ab6b0c7eb88d41f93830e2dd7f67c1baee5ad296
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class BoardSettingsScreen implements Screen {
	private MainClass main;
	private Stage stage = new Stage(new ScreenViewport());
	private SpriteBatch batch = new SpriteBatch();
	private LoadingScreen sound;
	private LoadingScreen texture;
	private LoadingScreen skin;
	private LoadingScreen image;
	private LoadingScreen music;
	private LoadingScreen checkbox;
	
<<<<<<< HEAD
	private static Texture bg = new Texture(Gdx.files.internal("assets/tag.jpg"));
=======
	private static Texture bg = new Texture(Gdx.files.internal("tag.jpg"));
>>>>>>> ab6b0c7eb88d41f93830e2dd7f67c1baee5ad296
	
	private boolean muted = false;
	
	public BoardSettingsScreen(MainClass parent) {
		main = parent;
		Gdx.input.setInputProcessor(stage);
		sound = new LoadingScreen(parent);
		texture = new LoadingScreen(parent);
		skin = new LoadingScreen(parent); 
		image = new LoadingScreen(parent);
		music = new LoadingScreen(parent);
		checkbox = new LoadingScreen(parent);
	}
	@Override
	public void show() {
		Table leftTable = new Table().align(Align.left);
		Table rightTable = new Table().align(Align.center);
		leftTable.setFillParent(true);
		rightTable.setFillParent(true);
		
		Image soundImage = new Image(image.getImage());
		soundImage.setX(5);
		soundImage.setY(435);
		
		final Label mainLabel = new Label("Pieces On Board", skin.getSkin());
		
		final Label pawnLabel = new Label("Pawn:", skin.getSkin());
		final Label queenLabel = new Label("Queen:", skin.getSkin());
		final Label knightLabel = new Label("Knight:", skin.getSkin());
		final Label bishopLabel = new Label("Bishop:", skin.getSkin());
		final Label rookLabel = new Label("Rook:", skin.getSkin());
		
		final CheckBox pawnBox = new CheckBox("Untick to remove", checkbox.getCheckBoxSkin());
		final CheckBox queenBox = new CheckBox("Untick to remove", checkbox.getCheckBoxSkin());
		final CheckBox knightBox = new CheckBox("Untick to remove", checkbox.getCheckBoxSkin());
		final CheckBox bishopBox = new CheckBox("Untick to remove", checkbox.getCheckBoxSkin());
		final CheckBox rookBox = new CheckBox("Untick to remove", checkbox.getCheckBoxSkin());
		
		TextButton backButton = new TextButton("Back", skin.getSkin(), "default");
		
		pawnBox.setChecked(true);
		queenBox.setChecked(true);
		knightBox.setChecked(true);
		bishopBox.setChecked(true);
		rookBox.setChecked(true);
		
		mainLabel.setPosition(135, 410);
		backButton.setPosition(95, 20);
		
<<<<<<< HEAD
=======
		//pawnBox.isChecked()
	
>>>>>>> ab6b0c7eb88d41f93830e2dd7f67c1baee5ad296
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
		backButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
<<<<<<< HEAD
				main.setScreen(new PlayerScreen(main));
=======
				main.setScreen(new PlayerScreen(main,pawnBox.isChecked(),queenBox.isChecked(),knightBox.isChecked(),rookBox.isChecked(),bishopBox.isChecked()));
>>>>>>> ab6b0c7eb88d41f93830e2dd7f67c1baee5ad296
				sound.getSound().play(0.75f);
			}
		});
		leftTable.add(pawnLabel).pad(15).padLeft(100);
		leftTable.row();
		leftTable.add(queenLabel).pad(15).padLeft(100);
		leftTable.row();
		leftTable.add(knightLabel).pad(15).padLeft(100);
		leftTable.row();
		leftTable.add(bishopLabel).pad(15).padLeft(100);
		leftTable.row();
		leftTable.add(rookLabel).pad(15).padLeft(100).padBottom(30);
		
		rightTable.add(pawnBox).pad(23).padTop(35).padLeft(175);
		rightTable.row();
		rightTable.add(queenBox).pad(23).padLeft(175);
		rightTable.row();
		rightTable.add(knightBox).pad(23).padLeft(175);
		rightTable.row();
		rightTable.add(bishopBox).pad(23).padLeft(175);
		rightTable.row();
		rightTable.add(rookBox).pad(23).padLeft(175).padBottom(50);
		stage.addActor(mainLabel);
		stage.addActor(leftTable);	
		stage.addActor(rightTable);
		stage.addActor(soundImage);
		stage.addActor(backButton);
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(255/255f, 255/255f, 255/255f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 30 / 30f));
		stage.draw();
		batch.begin();
		batch.draw(texture.getTexture(), 0, 0);
		batch.draw(bg, 70, 95);
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

<<<<<<< HEAD
}
=======
}
>>>>>>> ab6b0c7eb88d41f93830e2dd7f67c1baee5ad296
