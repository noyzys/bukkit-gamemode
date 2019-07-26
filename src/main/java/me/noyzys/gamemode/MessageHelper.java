package me.noyzys.gamemode;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * @author: NoyZys, 21:48 26.07.2019
 **/
public final class MessageHelper {

    @Contract(pure = true)
    private MessageHelper() {
    }

    @NotNull
    public static String colored(@NotNull String content){
        return ChatColor
                .translateAlternateColorCodes('&', content);
    }

    public static boolean sendMessage(@NotNull CommandSender sender, String message){
        sender.sendMessage(colored(message));
        return true;
    }
}
