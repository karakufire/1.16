package cofh.thermal.core.util.control;

import cofh.core.network.packet.server.SideConfigPacket;
import cofh.core.util.Utils;
import cofh.core.util.control.IReconfigurableTile;
import cofh.core.util.control.ReconfigControlModule;
import net.minecraft.util.Direction;

import java.util.function.BooleanSupplier;

import static cofh.core.util.control.IReconfigurable.SideConfig.*;

public class CellReconfigControlModule extends ReconfigControlModule {

    public CellReconfigControlModule(IReconfigurableTile tile) {

        super(tile);
    }

    public CellReconfigControlModule(IReconfigurableTile tile, BooleanSupplier enabled) {

        super(tile, enabled);
    }

    @Override
    public void disable() {

        this.sides = new SideConfig[]{SIDE_NONE, SIDE_NONE, SIDE_NONE, SIDE_NONE, SIDE_NONE, SIDE_NONE};
        tile.onControlUpdate();
    }

    @Override
    public SideConfig getSideConfig(int side) {

        if (side > 5) {
            return SIDE_NONE;
        }
        return sides[side];
    }

    // region IReconfigurable
    @Override
    public SideConfig getSideConfig(Direction side) {

        if (side == null || !isReconfigurable()) {
            return SIDE_NONE;
        }
        return sides[side.ordinal()];
    }

    @Override
    public boolean prevSideConfig(Direction side) {

        if (!isReconfigurable() || side == null) {
            return false;
        }
        int ord = side.ordinal();
        sides[ord] = sides[ord].prev();
        if (sides[ord] == SIDE_ACCESSIBLE || sides[ord] == SIDE_BOTH) {
            sides[ord] = SIDE_OUTPUT;
        }
        if (Utils.isClientWorld(tile.world())) {
            SideConfigPacket.sendToServer(tile);
        } else {
            tile.onControlUpdate();
        }
        return true;
    }

    @Override
    public boolean nextSideConfig(Direction side) {

        if (!isReconfigurable() || side == null) {
            return false;
        }
        int ord = side.ordinal();
        sides[ord] = sides[ord].next();
        if (sides[ord] == SIDE_ACCESSIBLE || sides[ord] == SIDE_BOTH) {
            sides[ord] = SIDE_NONE;
        }
        if (Utils.isClientWorld(tile.world())) {
            SideConfigPacket.sendToServer(tile);
        } else {
            tile.onControlUpdate();
        }
        return true;
    }

    @Override
    public boolean setSideConfig(Direction side, SideConfig config) {

        if (!isReconfigurable() || side == null || config == null) {
            return false;
        }
        sides[side.ordinal()] = config;
        if (Utils.isClientWorld(tile.world())) {
            SideConfigPacket.sendToServer(tile);
        } else {
            tile.onControlUpdate();
        }
        return true;
    }
    // endregion
}
