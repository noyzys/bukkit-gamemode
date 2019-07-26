package me.noyzys.gamemode;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author: NoyZys, 21:50 26.07.2019
 **/
public class GameModeCommand implements CommandExecutor {

    private final GameModePlugin plugin;

    public GameModeCommand(GameModePlugin plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("gamemode").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)) {
            MessageHelper.sendMessage(sender, this.plugin.getGameModeConfiguration().getCommandOnlyPlayer());
            return true;
        }
        final Player player = (Player) sender;
        final GameMode gameMode = GameModeParser.parseGameMode(args[0]);

        if (args.length == 1) return MessageHelper.sendMessage(player, this.plugin.getGameModeConfiguration().getCommandUsage());
        if (gameMode == null) return MessageHelper.sendMessage(player, this.plugin.getGameModeConfiguration().getGameModeNotFound());

        if (player.hasPermission("plugin.gamemode." + gameMode.toString().toLowerCase())) {
            player.setGameMode(gameMode);
            return MessageHelper.sendMessage(player, this.plugin.getGameModeConfiguration().getGameModeSuccessPlayer().replace("{GAMEMODE}", gameMode.toString().toLowerCase() + "."));
        }

        if (sender.hasPermission("plugin.gamemode.other")) if (Bukkit.getPlayer(args[1]) == null)
            return MessageHelper.sendMessage(sender, this.plugin.getGameModeConfiguration().getPlayerNotFound());

        final Player target = Bukkit.getPlayer(args[1]);

        if (gameMode == null) return MessageHelper.sendMessage(player, this.plugin.getGameModeConfiguration().getGameModeNotFound());

        if (target.hasPermission("plugin.gamemode." + gameMode.toString().toLowerCase() + ".other")) target.setGameMode(gameMode);

        MessageHelper.sendMessage(player, this.plugin.getGameModeConfiguration().getGameModeChangeMessagePlayer().replace("{PLAYER}",  target.getName().replace("{GAMEMODE}", gameMode.toString().toLowerCase())));
        MessageHelper.sendMessage(player, this.plugin.getGameModeConfiguration().getGameModeChangeMessageSender().replace("{GAMEMODE}", gameMode.toString().toLowerCase().replace("{PLAYER}", player.getName())));

        MessageHelper.sendMessage(player, this.plugin.getGameModeConfiguration().getNoPermisions());
        return true;
    }
}

