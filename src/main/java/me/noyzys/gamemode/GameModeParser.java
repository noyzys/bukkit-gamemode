package me.noyzys.gamemode;

import org.apache.commons.lang.StringUtils;
import org.bukkit.GameMode;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * @author: NoyZys, 21:43 26.07.2019
 **/
public final class GameModeParser {

    @Contract(pure = true)
    private GameModeParser() {
    }

    private static GameMode getGameMode(@NotNull String content){
        return Arrays.stream(GameMode.values())
                .filter(mode -> mode.name().toLowerCase().contains(content.toLowerCase()))
                .findAny()
                .orElse(null);
    }

    public static GameMode parseGameMode(@NotNull String content){
        if (StringUtils.isNumeric(content)) return GameMode.getByValue(Integer.valueOf(content));
        else return getGameMode(content);
    }
}
