package mod.rummikub.effect;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.server.world.ServerWorld;

public class SkaffaEffect extends StatusEffect {
    public SkaffaEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        entity.addStatusEffect(new net.minecraft.entity.effect.StatusEffectInstance(
                StatusEffects.HUNGER, 40, amplifier * 2 + 10, false, false, false));
        entity.addStatusEffect(new net.minecraft.entity.effect.StatusEffectInstance(
                StatusEffects.NAUSEA, 100, amplifier, false, false, false));
        return super.applyUpdateEffect(world, entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
