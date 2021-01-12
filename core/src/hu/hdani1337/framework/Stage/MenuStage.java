package hu.hdani1337.framework.Stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.util.ArrayList;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.PrettyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.SimplePrettyStage;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.PositionRule;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.ShapeType;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleBodyType;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldHelper;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.Timers.Timer;
import hu.hdani1337.framework.Hud.Logo;
import hu.hdani1337.framework.Hud.TextBox;
import hu.hdani1337.framework.Screen.GameScreen;
import hu.hdani1337.framework.Screen.InfoScreen;
import hu.hdani1337.framework.Screen.MenuScreen;
import hu.hdani1337.framework.Screen.OptionsScreen;
import hu.hdani1337.framework.Screen.ShopScreen;

import static hu.hdani1337.framework.Framework.muted;
import static hu.hdani1337.framework.GlobalAssets.MENU_BG_TEXTURE;
import static hu.hdani1337.framework.SoundManager.kezdesHang;
import static hu.hdani1337.framework.SoundManager.kilepesHang;

public class MenuStage extends SimplePrettyStage {
    public static final String STARTBUTTON_TEXTURE = "pic/gombok/jatek.png";
    public static final String OPTIONSBUTTON_TEXTURE = "pic/gombok/opciok.png";
    public static final String INFOBUTTON_TEXTURE = "pic/gombok/info.png";
    public static final String EXITBUTTON_TEXTURE = "pic/gombok/x.png";

    public static AssetList assetList = new AssetList();
    static {
        assetList.collectAssetDescriptor(Logo.class, assetList);
        assetList.collectAssetDescriptor(TextBox.class, assetList);
    }

    public MenuStage(MyGame game) {
        super(game);
    }

    private Logo logo;
    private OneSpriteStaticActor start;
    private OneSpriteStaticActor info;
    private OneSpriteStaticActor options;
    private OneSpriteStaticActor exit;

    private ArrayList<OneSpriteStaticActor> menuElements;

    @Override
    public void assignment() {
        menuElements = new ArrayList<>();
        logo = new Logo(game, Logo.LogoType.MENU);
        start = new OneSpriteStaticActor(game, STARTBUTTON_TEXTURE);
        info = new OneSpriteStaticActor(game, INFOBUTTON_TEXTURE);
        options = new OneSpriteStaticActor(game, OPTIONSBUTTON_TEXTURE);
        exit = new OneSpriteStaticActor(game, EXITBUTTON_TEXTURE);

        menuElements.add(start);
        menuElements.add(options);
        menuElements.add(logo);
        menuElements.add(exit);
        menuElements.add(info);

        for (OneSpriteStaticActor a : menuElements) {
            a.setActorWorldHelper(new SimpleWorldHelper(world,a, ShapeType.Rectangle, SimpleBodyType.Sensor));
            a.setColor(0, 0, 0, 0);
            ((SimpleWorldHelper) a.getActorWorldHelper()).getBody().colorToFixTime(1, 1, 1, 1, 1);
        }
    }

    @Override
    public void setSizes() {
        for (OneSpriteStaticActor a : menuElements)
            if(a != logo)
                a.setSize(a.getWidth()*0.002f,a.getHeight()*0.002f);

        logo.setSize(logo.getWidth()*0.003f,logo.getHeight()*0.003f);
        logo.setOrigintoCenter();
    }

    @Override
    public void setPositions() {
        logo.setPosition(getViewport().getWorldWidth()/2-logo.getWidth()/2,getViewport().getWorldHeight()-logo.getHeight()*1.2f);

        start.setX(getViewport().getWorldWidth()/2 - start.getWidth()/2);
        start.setY(getViewport().getWorldHeight()*0.575f - start.getHeight()/2);

        info.setY(start.getY() - info.getHeight()*1.4f);
        info.setX((getViewport().getWorldWidth()/2 - info.getWidth()/2));

        options.setY(info.getY() - options.getHeight()*1.4f);
        options.setX((getViewport().getWorldWidth()/2 - options.getWidth()/2));

        exit.setY(exit.getHeight()*0.05f);
        exit.setX(getViewport().getWorldWidth() - exit.getWidth()*1.05f);
    }

    @Override
    public void addListeners() {
        start.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                animation(start);
                if(!muted && kezdesHang != null) kezdesHang.play(1);
                addTimer(new TickTimer(0.5f, false, new TickTimerListener(){
                    @Override
                    public void onTick(Timer sender, float correction) {
                        super.onTick(sender, correction);
                        game.setScreenWithPreloadAssets(GameScreen.class, new LoadingStage(game));
                    }
                }));
            }
        });

        info.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                animation(info);
                addTimer(new TickTimer(0.5f, false, new TickTimerListener(){
                    @Override
                    public void onTick(Timer sender, float correction) {
                        super.onTick(sender, correction);
                        game.setScreenWithPreloadAssets(InfoScreen.class, new LoadingStage(game));
                    }
                }));
            }
        });

        options.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                animation(options);
                addTimer(new TickTimer(0.7f, false, new TickTimerListener(){
                    @Override
                    public void onTick(Timer sender, float correction) {
                        super.onTick(sender, correction);
                        game.setScreenWithPreloadAssets(OptionsScreen.class, new LoadingStage(game));
                    }
                }));
            }
        });

        exit.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                for (OneSpriteStaticActor a : menuElements) {
                    ((SimpleWorldHelper) a.getActorWorldHelper()).getBody().sizeToFixTime(0, 0, 0.5f, PositionRule.Center);
                    ((SimpleWorldHelper) a.getActorWorldHelper()).getBody().colorToFixTime(0.5f, 1, 1, 1, 0);
                }

                if(!muted && kilepesHang != null){
                    kilepesHang.play(1);
                }
                addTimer(new TickTimer(0.5f,false,new TickTimerListener(){
                    @Override
                    public void onStop(Timer sender) {
                        super.onStop(sender);
                        Gdx.app.exit();
                    }
                }));
            }
        });
    }

    private void animation(OneSpriteStaticActor sender){
        sender.setOrigintoCenter();
        ((SimpleWorldHelper)sender.getActorWorldHelper()).getBody().sizeToFixTime(sender.getWidth()*1.5f,sender.getHeight()*1.5f,0.5f, PositionRule.Center);
        ((SimpleWorldHelper)sender.getActorWorldHelper()).getBody().colorToFixTime(0.6f,1,1,1,0);
        for (OneSpriteStaticActor a : menuElements)
            if(a != sender) {
                ((SimpleWorldHelper) a.getActorWorldHelper()).getBody().colorToFixTime(0.5f,1,1,1,0);
            }
    }

    @Override
    public void setZIndexes() {

    }

    @Override
    public void addActors() {
        addActor(logo);
        addActor(start);
        addActor(info);
        addActor(options);
        addActor(exit);
    }
}
