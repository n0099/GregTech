package gregtech.api.gui;

import net.minecraft.inventory.IContainerListener;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_BasicTank;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;

import java.util.Iterator;

/**
 * NEVER INCLUDE THIS FILE IN YOUR MOD!!!
 * <p/>
 * The Container I use for all my Basic Tanks
 */
public class GT_Container_BasicTank extends GT_ContainerMetaTile_Machine {

    public int mContent = 0;

    public GT_Container_BasicTank(InventoryPlayer aInventoryPlayer, IGregTechTileEntity aTileEntity) {
        super(aInventoryPlayer, aTileEntity);
    }

    @Override
    public void addSlots(InventoryPlayer aInventoryPlayer) {
        func_75146_a(new Slot(mTileEntity, 0, 80, 17));
        func_75146_a(new GT_Slot_Output(mTileEntity, 1, 80, 53));
        func_75146_a(new GT_Slot_Render(mTileEntity, 2, 59, 42));
    }

    @Override
    public void func_75142_b() {
        super.func_75142_b();
        if (mTileEntity.isClientSide() || mTileEntity.getMetaTileEntity() == null) return;
        if (((GT_MetaTileEntity_BasicTank) mTileEntity.getMetaTileEntity()).mFluid != null)
            mContent = ((GT_MetaTileEntity_BasicTank) mTileEntity.getMetaTileEntity()).mFluid.amount;
        else
            mContent = 0;
        Iterator<IContainerListener> var2 = this.field_75149_d.iterator();
        while (var2.hasNext()) {
            IContainerListener var1 = var2.next();
            var1.func_71112_a(this, 100, mContent & 65535);
            var1.func_71112_a(this, 101, mContent >>> 16);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void func_75137_b(int par1, int par2) {
        super.func_75137_b(par1, par2);
        switch (par1) {
            case 100:
                mContent = mContent & -65536 | par2;
                break;
            case 101:
                mContent = mContent & 65535 | par2 << 16;
                break;
        }
    }

    @Override
    public int getSlotCount() {
        return 2;
    }

    @Override
    public int getShiftClickSlotCount() {
        return 1;
    }
}