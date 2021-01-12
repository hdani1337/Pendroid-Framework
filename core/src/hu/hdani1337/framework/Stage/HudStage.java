package hu.hdani1337.framework.Stage;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.PrettyStage;
import hu.hdani1337.framework.Hud.Pause;
import hu.hdani1337.framework.Hud.TextBox;
import hu.hdani1337.framework.Screen.GameScreen;

public class HudStage extends PrettyStage {
    public static AssetList assetList = new AssetList();
    static {
        //add assets here
    }

    public static GameStage stage;//Hátha kell a GameStageből valami
    private Pause pause;
    private TextBox scoreBoard;

    public HudStage(MyGame game) {
        super(game);
    }

    @Override
    public void assignment() {
        pause = new Pause(game);
        scoreBoard = new TextBox(game,"0",2.5f);
    }

    @Override
    public void setSizes() {
        pause.setSize(180,180);
    }

    @Override
    public void setPositions() {
        pause.setPosition(15,getViewport().getWorldHeight()-pause.getHeight()-15);
        scoreBoard.setPosition(getViewport().getWorldWidth()-scoreBoard.getWidth()-15,getViewport().getWorldHeight()-scoreBoard.getHeight()-15);
    }

    @Override
    public void addListeners() {

    }

    @Override
    public void setZIndexes() {

    }

    @Override
    public void addActors() {
        addActor(scoreBoard);
        addActor(pause);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(scoreBoard.text != GameStage.score+"") {
            scoreBoard.setText(GameStage.score + "");
            setPositions();
        }
    }
}
