package mod.rummikub.block.custom;

import mod.rummikub.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;

public class CannabisBushBlock extends SweetBerryBushBlock {
    public CannabisBushBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state, boolean includeData) {
        return new ItemStack(ModItems.CANNABIS_SEEDS); // Drops seeds when broken
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        int age = state.get(AGE);
        boolean fullyGrown = age == 3;

        // Require shears to harvest
        if (fullyGrown && itemStack.isOf(Items.SHEARS)) {
            if (!world.isClient) {
                Random random = world.getRandom();

                // Drop the main crop
                int cropAmount = 1 + random.nextInt(2); // 1-2 crops
                dropStack(world, pos, new ItemStack(ModItems.CANNABIS, cropAmount));

                // 5% chance to drop seeds
                if (random.nextFloat() < 0.05) {
                    dropStack(world, pos, new ItemStack(ModItems.CANNABIS_SEEDS, 1));
                }

                // Play harvesting sound
                world.playSound(null, pos, SoundEvents.ENTITY_SHEEP_SHEAR, SoundCategory.BLOCKS, 1.0F, 1.0F);

                // Reset plant to earlier growth stage
                world.setBlockState(pos, state.with(AGE, 1), Block.NOTIFY_LISTENERS);
                world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(player, state));

            }
            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }


    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, net.minecraft.entity.Entity entity) {
        // Do nothing (removes damage behavior from sweet berry bush)
    }
}