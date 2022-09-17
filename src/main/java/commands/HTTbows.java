package commands;
import httbows.httbows.HTTBows;
import httbows.httbows.ItemManager;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class HTTbows implements CommandExecutor {
    private final HTTBows plugin;

    public HTTbows(HTTBows plugin){ this.plugin = plugin; }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;

        if(args.length == 0){
            p.sendMessage("Incorrect Command");
        } else if(args.length == 1){
            Player player = (Player) sender;

            if(sender instanceof Player){

                ItemManager itemmanag = new ItemManager(this.plugin);

                ItemStack item = new ItemStack(Material.BOW, 1);

                if(args[0].equalsIgnoreCase("explosivebow"))
                    item = itemmanag.returnExplosiveBow();

                if(args[0].equalsIgnoreCase("thunderbow"))
                    item = itemmanag.returnThunderBow();

                if(args[0].equalsIgnoreCase("shadowbow"))
                    item = itemmanag.returnShadowBow();

                if(args[0].equalsIgnoreCase("levitationbow"))
                    item = itemmanag.returnLevitationBow();

                if(args[0].equalsIgnoreCase("firebow"))
                    item = itemmanag.returnFireBow();

                if(args[0].equalsIgnoreCase("allbows")){
                    item = itemmanag.returnFireBow();
                }

                player.getInventory().addItem(item);

            }
        }

        return false;
    }
}