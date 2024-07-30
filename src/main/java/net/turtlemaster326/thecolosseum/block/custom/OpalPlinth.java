package net.turtlemaster326.thecolosseum.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.turtlemaster326.thecolosseum.block.ModBlocks;
import net.turtlemaster326.thecolosseum.item.ModItems;

public class OpalPlinth extends Block {
    public static final BooleanProperty EMPTY = BooleanProperty.create("empty");

    public static final VoxelShape SHAPE = Block.box(0,0,0,16,26,16);

    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
        
    }


    public OpalPlinth(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide) {
            ItemStack $hand = pPlayer.getItemInHand(pHand);




            if(pState.getValue(EMPTY) == true) {
                if(isPlinthBlock($hand)) {
                    pLevel.setBlock(pPos, pState.setValue(EMPTY, false), 3);
                    if (!pPlayer.getAbilities().instabuild) {
                        $hand.shrink(1);

                    }
                    return InteractionResult.SUCCESS;
                }
            }
        }
        return InteractionResult.SUCCESS;
    }







    private static boolean isPlinthBlock(ItemStack pStack) { return pStack.is(ModItems.PURE_OPAL.get()); }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(EMPTY);
        super.createBlockStateDefinition(pBuilder);
    }
}
