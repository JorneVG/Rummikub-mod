package mod.rummikub.item.custom;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.consume.UseAction;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class JonkoItem extends Item {
    public static final int MAX_USE_TIME = 1200;
    private static final int DURABILITY_LOSS_RATE = 5; // Duurzaamheid verlies per tick

    public JonkoItem(Settings settings) {
        super(settings.maxDamage(100)); // Stel de initiële duurzaamheid in op 100
    }

    public int getMaxUseTime(ItemStack stack) {
        return MAX_USE_TIME;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.EAT; // Gebruik de eetactie voor de animatie
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        user.playSound(SoundEvents.BLOCK_CAMPFIRE_CRACKLE, 3.0F, 1.0F);
        user.incrementStat(Stats.USED.getOrCreateStat(this));
        user.setCurrentHand(hand); // Zorg ervoor dat de speler de hand instelt
        return ActionResult.CONSUME; // Geef een succesvolle actie terug
    }

    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        if (!world.isClient) return;

        // Spawn smoke every 5 ticks instead of every tick
        if (remainingUseTicks % 5 == 0) {
            spawnSmoke((ClientWorld) world, user);
        }
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        return stack;
    }

    @Environment(EnvType.CLIENT)
    private void spawnSmoke(ClientWorld world, LivingEntity user) {
        Vec3d pos = user.getPos().add(0, user.getHeight() * 0.9, 0);
        for (int i = 0; i < 2; i++) { // Spawn 2 particles instead of 3
            // Random offsets for spreading the smoke
            double offsetX = (Math.random() - 0.5) * 1; // Verspreiding in de x-richting
            double offsetZ = (Math.random() - 0.5) * 1; // Verspreiding in de z-richting
            world.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, pos.x + offsetX, pos.y, pos.z + offsetZ, 0, 0.05, 0); // Snellere beweging
        }
    }
}