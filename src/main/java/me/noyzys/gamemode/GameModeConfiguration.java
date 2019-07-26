package me.noyzys.gamemode;

import org.diorite.config.Config;
import org.diorite.config.annotations.CustomKey;

/**
 * @author: NoyZys, 22:11 26.07.2019
 **/
public interface GameModeConfiguration extends Config {

    @CustomKey("command_only_player")
    default String getCommandOnlyPlayer(){
        return "Command only Player.";
    }

    @CustomKey("command_usage")
    default String getCommandUsage(){
        return "Poprawne uzycie, to: /gamemode <nick>, <0|1|2|3>.";
    }

    @CustomKey("gamemode_not_found")
    default String getGameModeNotFound(){
        return "Blad: nie rozpoznano tryb gamemode.";
    }

    @CustomKey("gamemode_success_player")
    default String getGameModeSuccessPlayer(){
        return "Pomyslnie zminiles tryb gry na: {GAMEMODE}";
    }

    @CustomKey("player_not_found")
    default String getPlayerNotFound(){
        return "Podany gracz jest offline.";
    }

    @CustomKey("gamemode_change_message_player")
    default String getGameModeChangeMessagePlayer(){
        return "Zmieniles tryb gry graczowi: {PLAYER} na: {GAMEMODE}.";
    }

    @CustomKey("gamemode_change_message_sender")
    default String getGameModeChangeMessageSender(){
        return "Twoj tryb gry zostal zmieniony na: {GAMEMODE} przez administratora: {PLAYER}.";
    }

    @CustomKey("no_permissions")
        default String getNoPermisions(){
        return "Nie posiadasz uprawnien (plugin.gamemode.other).";
    }

    @CustomKey("permissions_gamemode")
    default String getPermisionsGameMode(){
        return "plugin.gamemode";
    }
}
