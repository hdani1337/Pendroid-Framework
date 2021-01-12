package hu.csanyzeg.master.MyBaseClasses.Scene2D;

import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;

/**
 * @author hdani1337
 * @date 2020.10.14.
 *
 * Ez az absztrakt osztály tulajdonképpen csak a StageInterfacet implementálja,
 * de itt van egy alap konstruktorunk, szóval nem kell minden stagenél egyesével végighívogatni az összes voidot
 * **/
public abstract class SimplePrettyStage extends SimpleWorldStage implements IPrettyStage {

    public SimplePrettyStage(Viewport viewport, MyGame game) {
        super(viewport, game);
        beforeInit();
        assignment();
        setSizes();
        setPositions();
        addListeners();
        setZIndexes();
        addActors();
        afterInit();
    }

    public SimplePrettyStage(MyGame game) {
        super(new ResponseViewport(9), game);
        beforeInit();
        assignment();
        setSizes();
        setPositions();
        addListeners();
        setZIndexes();
        addActors();
        afterInit();
    }

    /**
     * Az értékek beállítása előtt végrehajtandó utasítások
     * Pl. debuggoláshoz, vagy írhatsz egy programot ide ami minden sikeres lefutásnál lefőz egy kávét
     * **/
    public void beforeInit(){
    }

    /**
     * Az értékek beállítása után végrehajtandó utasítások
     * Pl. itt is főzhetsz le kávét
     * **/
    public void afterInit(){
    }
}
