package hu.hdani1337.framework.Stage;

import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class LoadingStage extends hu.csanyzeg.master.MyBaseClasses.Assets.LoadingStage {

    public AssetList assetList = new AssetList();
    static {
        //add assets here
    }

    public LoadingStage(MyGame game) {
        super(new ResponseViewport(900), game);
    }

    @Override
    public AssetList getAssetList() {
        return assetList;
    }
}
