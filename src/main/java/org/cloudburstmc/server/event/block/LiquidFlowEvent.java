package org.cloudburstmc.server.event.block;

import org.cloudburstmc.server.block.Block;
import org.cloudburstmc.server.block.BlockState;
import org.cloudburstmc.server.event.Cancellable;

public class LiquidFlowEvent extends BlockEvent implements Cancellable {

    private final BlockState to;
    private final Block source;
    private final int newFlowDecay;

    public LiquidFlowEvent(BlockState to, Block source, int newFlowDecay) {
        super(source);
        this.to = to;
        this.source = source;
        this.newFlowDecay = newFlowDecay;
    }

    public int getNewFlowDecay() {
        return this.newFlowDecay;
    }

    public Block getSource() {
        return this.source;
    }

    public BlockState getTo() {
        return this.to;
    }
}
