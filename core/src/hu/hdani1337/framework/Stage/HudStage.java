package hu.hdani1337.framework.Stage;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.PrettyStage;

public class HudStage extends PrettyStage {
    public static AssetList assetList = new AssetList();
    static {
        //add assets here
    }

    public static GameStage stage;//Hátha kell a GameStageből valami

    public HudStage(MyGame game) {
        super(game);
    }

    @Override
    public void assignment() {

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
}
