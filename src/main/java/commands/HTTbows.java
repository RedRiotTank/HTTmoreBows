package commands;


import httbows.httbows.HTTBows;
import httbows.httbows.ItemManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class HTTbows implements CommandExecutor {


    private final HTTBows plugin;

    public HTTbows(HTTBows plugin){
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;

        if(args.length == 0){
            p.sendMessage("Comando incorrecto");
        } else if(args.length == 1){

            if(args[0].equalsIgnoreCase("explosibeBow")){
                if(sender instanceof Player){
                    Player player = (Player) sender;


                    ItemStack item = ItemManager.returnExplosiveBow();
                    player.getInventory().addItem(item);

                }
            }

            if(args[0].equalsIgnoreCase("thunderbow")){
                if(sender instanceof Player){
                    Player player = (Player) sender;


                    ItemStack item = ItemManager.returnThunderBow();
                    player.getInventory().addItem(item);

                }
            }

            if(args[0].equalsIgnoreCase("shadowbow")){

                if(sender instanceof Player){
                    Player player = (Player) sender;

                    ItemStack item = ItemManager.returnShadowBow();
                    player.getInventory().addItem(item);

                }

            }

            if(args[0].equalsIgnoreCase("levitationbow")){

                if(sender instanceof Player){
                    Player player = (Player) sender;

                    ItemStack item = ItemManager.returnLevitationBow();
                    player.getInventory().addItem(item);

                }

            }

            if(args[0].equalsIgnoreCase("firebow")){
                if(sender instanceof Player){
                    Player player = (Player) sender;


                    ItemStack item = ItemManager.returnFireBow();
                    player.getInventory().addItem(item);

                }
            }
        }





        return false;
    }
}