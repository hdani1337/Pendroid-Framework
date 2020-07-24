package hu.hdani1337.framework.Screen;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;
import hu.hdani1337.framework.Stage.GameOverStage;
import hu.hdani1337.framework.Stage.GameStage;
import hu.hdani1337.framework.Stage.HudStage;
import hu.hdani1337.framework.Stage.PauseStage;

public class GameScreen extends MyScreen {
    public static AssetList assetList = new AssetList();
    static {
        assetList.collectAssetDescriptor(GameStage.class, assetList);
        assetList.collectAssetDescriptor(HudStage.class, assetList);
        assetList.collectAssetDescriptor(GameOverStage.class, assetList);
        assetList.collectAssetDescriptor(PauseStage.class, assetList);
    }

    public GameScreen(MyGame game) {
        super(game);
    }

    public GameStage gameStage;

    @Override
    protected void afterAssetsLoaded() {
        gameStage = new GameStage(game);
        HudStage.stage = gameStage;
        addStage(gameStage,1,false);
        addStage(new HudStage(game),2, true);
        addStage(new PauseStage(game),3, true);
        addStage(new GameOverStage(game),4, true);
    }

    @Override
    public AssetList getAssetList() {
        return assetList;
    }

    @Override
    public void init() {

    }
}
