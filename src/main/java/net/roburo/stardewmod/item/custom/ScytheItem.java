package net.roburo.stardewmod.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import static net.minecraft.world.item.Tiers.DIAMOND;
import static net.minecraft.world.item.Tiers.STONE;

public class ScytheItem extends Item {
    Tier tier;
    public ScytheItem(Properties pProperties, Tier tier) {
        super(pProperties);
        this.tier = tier;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, @NotNull Player player, @NotNull InteractionHand hand) {
        if (!world.isClientSide) {
            BlockPos center = player.blockPosition(); // Center position (player's block location)

            int radius = (tier == DIAMOND) ? 5 : 3;
            if(tier == STONE) {
                radius = 2;
            }
            int y = player.blockPosition().getY(); // Fixed height: player’s feet

            for (int dx = -radius; dx <= radius; dx++) {
                for (int dz = -radius; dz <= radius; dz++) {
                    BlockPos pos = new BlockPos(center.getX() + dx, y, center.getZ() + dz);
                    BlockState state = world.getBlockState(pos);
                    Block block = state.getBlock();

                    if (block == Blocks.SHORT_GRASS || block == Blocks.TALL_GRASS) {
                        world.destroyBlock(pos, true);
                    }
                }
            }
        }
        return InteractionResultHolder.sidedSuccess(player.getItemInHand(hand), world.isClientSide());
    }
}
