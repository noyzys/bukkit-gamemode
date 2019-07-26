package me.noyzys.gamemode;

import static me.noyzys.gamemode.GameModePlugin.getInstance;
/**
 * @author: NoyZys, 22:11 26.07.2019
 **/
public enum GameModeType {

    COMMAND_ONLY_PLAYER(getInstance().getGameModeConfiguration().getCommandOnlyPlayer()),
    COMMAND_USAGE(getInstance().getGameModeConfiguration().getCommandUsage()),
    GAMEMODE_NOT_FOUND(getInstance().getGameModeConfiguration().getGameModeNotFound()),
    GAMEMODE_SUCCESS_PLAYER(getInstance().getGameModeConfiguration().getGameModeSuccessPlayer()),
    PLAYER_NOT_FOUND(getInstance().getGameModeConfiguration().getPlayerNotFound()),
    MESSAGE_CHANGE_GAMEMODE_PLAYER(getInstance().getGameModeConfiguration().getGameModeChangeMessagePlayer()),
    MESSAGE_CHANGE_GAMEMODE_SENDER(getInstance().getGameModeConfiguration().getGameModeChangeMessageSender()),
    NO_PERMISSIONS(getInstance().getGameModeConfiguration().getNoPermisions()),
    PERMISIONS_GAMEMODE(getInstance().getGameModeConfiguration().getPermisionsGameMode());

    private final String message;

    GameModeType(String message) {
        this.message = message;
    }
}
