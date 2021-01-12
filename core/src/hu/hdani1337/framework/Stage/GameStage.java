package hu.hdani1337.framework.Stage;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.PrettyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.SimplePrettyStage;
import hu.hdani1337.framework.Hud.TextBox;

public class GameStage extends SimplePrettyStage {
    public static AssetList assetList = new AssetList();
    static {
        assetList.collectAssetDescriptor(TextBox.class,assetList);
    }

    public static boolean isAct;
    public static boolean isGameOver;
    public static long score;

    public GameStage(MyGame game) {
        super(game);
    }

    @Override
    public void assignment() {
        isAct = true;
        isGameOver = false;
        score = 0;
    }

    @Override
    public void setSizes() {

    }

    @Override
    public void setPositions() {

    }

    @Override
    public void addListeners() {

    }

    @Override
    public void setZIndexes() {

    }

    @Override
    public void addActors() {

    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(isAct){
            //A JÁTÉKMENET KÓDJA ITT FUT

        }
    }
}
