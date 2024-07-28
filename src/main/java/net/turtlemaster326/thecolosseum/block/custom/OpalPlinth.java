package net.turtlemaster326.thecolosseum.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.turtlemaster326.thecolosseum.block.ModBlocks;
import net.turtlemaster326.thecolosseum.item.ModItems;

public class OpalPlinth extends Block {
    public static final BooleanProperty FILLED = BooleanProperty.create("filled");



    public OpalPlinth(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if(!pLevel.isClientSide) {
            pLevel.setBlock(pPos, pState.cycle(FILLED), 3);

        }



        return InteractionResult.SUCCESS;

    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FILLED);
        super.createBlockStateDefinition(pBuilder);
    }
}
