package net.roburo.stardewmod.item.custom;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class SteelHoeItem extends HoeItem {

    public SteelHoeItem() {
        super(Tiers.IRON, new Item.Properties().durability(150));
    }


    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Player player = pContext.getPlayer();
        BlockPos blockpos = pContext.getClickedPos();
        BlockState toolModifiedState = level.getBlockState(blockpos).getToolModifiedState(pContext, net.minecraftforge.common.ToolActions.HOE_TILL, false);
        Pair<Predicate<UseOnContext>, Consumer<UseOnContext>> pair = toolModifiedState == null ? null : Pair.of(ctx -> true, changeIntoState(toolModifiedState));

        BlockPos center = pContext.getClickedPos();
        ItemStack stack = pContext.getItemInHand();

        if (pair == null) {
            return InteractionResult.PASS;
        } else {
            boolean isSneaking = player != null && player.isShiftKeyDown();

            boolean tilledAtLeastOne = false;
            Predicate<UseOnContext> predicate = pair.getFirst();
            Consumer<UseOnContext> consumer = pair.getSecond();

            assert player != null;
            Direction direction = player.getDirection();

            if (!isSneaking) {
                for (int i = 0; i < 5; i++) {
                    BlockPos pos = center.relative(direction, i);

                    UseOnContext localContext = new UseOnContext(player, pContext.getHand(),
                            new BlockHitResult(pos.getCenter(), Direction.UP, pos, false));

                    if (predicate.test(localContext)) {
                        if (!level.isClientSide) {
                            consumer.accept(localContext);
                        }
                        level.playSound(player, pos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                        tilledAtLeastOne = true;
                    }
                }
            } else {
                BlockPos pos = center.relative(direction, 0);
                UseOnContext localContext = new UseOnContext(player, pContext.getHand(),
                        new BlockHitResult(pos.getCenter(), Direction.UP, pos, false));
                if (predicate.test(localContext)) {
                    if (!level.isClientSide) {
                        consumer.accept(localContext);
                    }
                    level.playSound(player, pos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                    tilledAtLeastOne = true;
                }
            }

            return tilledAtLeastOne ? InteractionResult.sidedSuccess(level.isClientSide) : InteractionResult.PASS;
        }
    }
}
