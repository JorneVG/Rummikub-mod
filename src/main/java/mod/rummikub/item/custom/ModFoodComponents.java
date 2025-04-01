package mod.rummikub.item.custom;

import mod.rummikub.effect.ModEffects;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

public class ModFoodComponents {
    public static final FoodComponent CANNABIS_COOKIE = new FoodComponent.Builder().nutrition(4)
            .saturationModifier(0.6F).alwaysEdible().build();
    public static final FoodComponent KEBAB = new FoodComponent.Builder().nutrition(8)
            .saturationModifier(1.2F).alwaysEdible().build();
    public static final ConsumableComponent CANNABIS_COOKIE_EFFECT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(ModEffects.SKAFFA, 1000), 1f)).build();
}
