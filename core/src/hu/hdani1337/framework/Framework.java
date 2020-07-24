package hu.hdani1337.framework;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.hdani1337.framework.Screen.IntroScreen;
import hu.hdani1337.framework.Screen.MenuScreen;
import hu.hdani1337.framework.Stage.LoadingStage;

public class Framework extends MyGame {
	public Framework(){

	}

	public Framework(boolean debug){
		super(debug);
	}

	@Override
	public void create() {
		super.create();
		setLoadingStage(null);
		setScreen(new MenuScreen(this));
	}
}
