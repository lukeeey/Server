package org.cloudburstmc.server.blockentity.impl;

import com.nukkitx.math.vector.Vector3i;
import org.cloudburstmc.server.block.BlockIds;
import org.cloudburstmc.server.block.BlockState;
import org.cloudburstmc.server.block.BlockTraits;
import org.cloudburstmc.server.blockentity.BlastFurnace;
import org.cloudburstmc.server.blockentity.BlockEntityType;
import org.cloudburstmc.server.inventory.InventoryType;
import org.cloudburstmc.server.level.chunk.Chunk;
import org.cloudburstmc.server.utils.Identifier;

public class BlastFurnaceBlockEntity extends FurnaceBlockEntity implements BlastFurnace {

    public BlastFurnaceBlockEntity(BlockEntityType<?> type, Chunk chunk, Vector3i position) {
        super(type, chunk, position, InventoryType.BLAST_FURNACE);
    }

    @Override
    public boolean isValid() {
        Identifier id = getBlockState().getType();
        return id == BlockIds.BLAST_FURNACE || id == BlockIds.LIT_BLAST_FURNACE;
    }

    @Override
    public float getBurnRate() {
        return 2.0f;
    }

    @Override
    protected void extinguishFurnace() {
        this.getLevel().setBlock(this.getPosition(), BlockState.get(BlockIds.BLAST_FURNACE).copyTrait(BlockTraits.FACING_DIRECTION, getBlockState()), true);
    }

    @Override
    protected void lightFurnace() {
        this.getLevel().setBlock(this.getPosition(), BlockState.get(BlockIds.LIT_BLAST_FURNACE).copyTrait(BlockTraits.FACING_DIRECTION, getBlockState()), true);
    }
}
