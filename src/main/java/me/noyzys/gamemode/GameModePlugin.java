package me.noyzys.gamemode;

import ch.jalu.injector.Injector;
import ch.jalu.injector.InjectorBuilder;
import org.bukkit.plugin.java.JavaPlugin;
import org.diorite.config.ConfigManager;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: NoyZys, 21:40 26.07.2019
 **/
public final class GameModePlugin extends JavaPlugin {

    private static GameModePlugin instance;
    private final File gamemodeFile = new File(this.getDataFolder(), "messages.yml");
    private GameModeConfiguration gameModeConfiguration;

    @Override
    public void onEnable() {
        instance = this;
        this.initialize();
        this.getLogger().info("Enable.");
    }

    private void initialize(){
        Injector injector = new InjectorBuilder()
                .addDefaultHandlers("me.noyzys.gamemode")
                .create();
        ExecutorService executorService = Executors.newCachedThreadPool();

        //<--- configuration --->
        this.gameModeConfiguration = ConfigManager.createInstance(GameModeConfiguration.class);
        this.gameModeConfiguration.bindFile(this.gamemodeFile);
        this.gameModeConfiguration.load();
        this.gameModeConfiguration.save();
        injector.register(GameModeConfiguration.class, this.gameModeConfiguration);
        injector.register(ExecutorService.class, executorService);

        new GameModeCommand(this);
    }

    @Override
    public void onDisable() {
        this.getLogger().info("Disable.");
    }

    public static GameModePlugin getInstance() {
        return instance;
    }

    public GameModeConfiguration getGameModeConfiguration() {
        return gameModeConfiguration;
    }
}
