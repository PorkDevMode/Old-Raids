package org.porkplugins.oldRaids;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.raid.RaidFinishEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List; // <-- Add this import

public final class OldRaids extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
    }

    @EventHandler
    public void onRaidFinish(RaidFinishEvent event) {
        int OmenLevel = event.getRaid().getBadOmenLevel();
        List<Player> winners = event.getWinners();

        for (Player p : winners) {
            if (OmenLevel > 0) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.BAD_OMEN, Integer.MAX_VALUE, OmenLevel));
            }
        }
    }
}