package cofh.thermal.core.client.gui;

import cofh.core.client.gui.element.ElementXpStorage;
import cofh.core.client.gui.element.panel.PanelConfiguration;
import cofh.core.inventory.container.ContainerCoFH;
import cofh.thermal.core.tileentity.ReconfigurableTile4Way;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;

import static cofh.core.util.GuiHelper.*;

public class MachineScreenReconfigurable<T extends ContainerCoFH> extends ThermalScreenBase<T> {

    protected ReconfigurableTile4Way tile;

    public MachineScreenReconfigurable(T container, PlayerInventory inv, ReconfigurableTile4Way tile, ITextComponent titleIn) {

        super(container, inv, tile, titleIn);
        this.tile = tile;
    }

    @Override
    public void init() {

        super.init();

        addPanel(new PanelConfiguration(this, tile, tile, () -> tile.getFacing())
                .addConditionals(ThermalGuiHelper.createDefaultMachineConfigs(this, name, tile)));

        if (tile.getEnergyStorage() != null && tile.getEnergyStorage().getMaxEnergyStored() > 0) {
            addPanel(ThermalGuiHelper.createDefaultEnergyUserPanel(this, tile));
            addElement(setClearable(createDefaultEnergyStorage(this, 8, 8, tile.getEnergyStorage()), tile, 0));
        }
        if (tile.getXpStorage() != null) {
            addElement(setClaimable((ElementXpStorage) createDefaultXpStorage(this, 152, 65, tile.getXpStorage()).setVisible(() -> tile.getXpStorage().getMaxXpStored() > 0), tile));
        }
    }

}
