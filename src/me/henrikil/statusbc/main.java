package me.henrikil.statusbc;
import java.net.InetAddress;

import org.bukkit.event.Listener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
public class main extends JavaPlugin implements Listener{
public void onEnable() {
getLogger().info(ChatColor.AQUA + "NameNotify enabled. by henrikil:)");
Bukkit.broadcastMessage(ChatColor.GOLD + "[StatusBC] " + ChatColor.AQUA + "This server is running StatusBC by henrikil!");
Bukkit.getServer().getPluginManager().registerEvents(this, this);


Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){
    public void run(){
    	InetAddress adr = InetAddress.getByName("status.mojang.com/check?service=sessionserver.mojang.com");
    	if(adr.isReachable(timeout)){
    		Bukkit.broadcastMessage(ChatColor.RED + "[Warning]");
    	} else {
    		Bukkit.broadcastMessage(ChatColor.RED + "[Warning]" + ChatColor.GOLD + "The session servers are offline! if you leave you might not be able to join again!");
    	}
    }}, 50, 50);
}
}