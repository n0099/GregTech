package gregtech.api.gui;

import net.minecraft.inventory.IContainerListener;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;

/**
 * NEVER INCLUDE THIS FILE IN YOUR MOD!!!
 * <p/>
 * The Container I use for all my MetaTileEntities
 */
public class GT_ContainerMetaTile_Machine extends GT_Container {

    public int mActive = 0, mMaxProgressTime = 0, mProgressTime = 0, mEnergy = 0, mSteam = 0, mSteamStorage = 0, mStorage = 0, mOutput = 0, mInput = 0, mID = 0, mDisplayErrorCode = 0;
    private int oActive = 0, oMaxProgressTime = 0, oProgressTime = 0, oEnergy = 0, oSteam = 0, oSteamStorage = 0, oStorage = 0, oOutput = 0, oInput = 0, oID = 0, oDisplayErrorCode = 0, mTimer = 0;


    public GT_ContainerMetaTile_Machine(InventoryPlayer aInventoryPlayer, IGregTechTileEntity aTileEntity) {
        super(aInventoryPlayer, aTileEntity);

        mTileEntity = aTileEntity;

        if (mTileEntity != null && mTileEntity.getMetaTileEntity() != null) {
            addSlots(aInventoryPlayer);
            if (doesBindPlayerInventory()) bindPlayerInventory(aInventoryPlayer);
            func_75142_b();
        } else {
            aInventoryPlayer.field_70458_d.field_71070_bA = aInventoryPlayer.field_70458_d.field_71069_bz;
        }
    }
    public GT_ContainerMetaTile_Machine(InventoryPlayer aInventoryPlayer, IGregTechTileEntity aTileEntity, boolean doesBindInventory) {
        super(aInventoryPlayer, aTileEntity);
        mTileEntity = aTileEntity;

        if (mTileEntity != null && mTileEntity.getMetaTileEntity() != null) {
            addSlots(aInventoryPlayer);
            if (doesBindPlayerInventory() && doesBindInventory) bindPlayerInventory(aInventoryPlayer);
            func_75142_b();
        } else {
            aInventoryPlayer.field_70458_d.field_71070_bA = aInventoryPlayer.field_70458_d.field_71069_bz;
        }
    }

    @Override
    public void func_75142_b() {
        super.func_75142_b();
        if (mTileEntity.isClientSide() || mTileEntity.getMetaTileEntity() == null) return;
        mStorage = (int) Math.min(Integer.MAX_VALUE, mTileEntity.getEUCapacity());
        mEnergy = (int) Math.min(Integer.MAX_VALUE, mTileEntity.getStoredEU());
        mSteamStorage = (int) Math.min(Integer.MAX_VALUE, mTileEntity.getSteamCapacity());
        mSteam = (int) Math.min(Integer.MAX_VALUE, mTileEntity.getStoredSteam());
        mOutput = (int) Math.min(Integer.MAX_VALUE, mTileEntity.getOutputVoltage());
        mInput = (int) Math.min(Integer.MAX_VALUE, mTileEntity.getInputVoltage());
        mDisplayErrorCode = mTileEntity.getErrorDisplayID();
        mProgressTime = mTileEntity.getProgress();
        mMaxProgressTime = mTileEntity.getMaxProgress();
        mActive = mTileEntity.isActive() ? 1 : 0;
        mTimer++;

        for(IContainerListener var1 : field_75149_d) {
            if (mTimer % 500 == 10 || oEnergy != mEnergy) {
                var1.func_71112_a(this, 0, mEnergy & 65535);
                var1.func_71112_a(this, 1, mEnergy >>> 16);
            }
            if (mTimer % 500 == 10 || oStorage != mStorage) {
                var1.func_71112_a(this, 2, mStorage & 65535);
                var1.func_71112_a(this, 3, mStorage >>> 16);
            }
            if (mTimer % 500 == 10 || oOutput != mOutput) {
                var1.func_71112_a(this, 4, mOutput);
            }
            if (mTimer % 500 == 10 || oInput != mInput) {
                var1.func_71112_a(this, 5, mInput);
            }
            if (mTimer % 500 == 10 || oDisplayErrorCode != mDisplayErrorCode) {
                var1.func_71112_a(this, 6, mDisplayErrorCode);
            }
            if (mTimer % 500 == 10 || oProgressTime != mProgressTime) {
                var1.func_71112_a(this, 11, mProgressTime & 65535);
                var1.func_71112_a(this, 12, mProgressTime >>> 16);
            }
            if (mTimer % 500 == 10 || oMaxProgressTime != mMaxProgressTime) {
                var1.func_71112_a(this, 13, mMaxProgressTime & 65535);
                var1.func_71112_a(this, 14, mMaxProgressTime >>> 16);
            }
            if (mTimer % 500 == 10 || oID != mID) {
                var1.func_71112_a(this, 15, mID);
            }
            if (mTimer % 500 == 10 || oActive != mActive) {
                var1.func_71112_a(this, 16, mActive);
            }
            if (mTimer % 500 == 10 || oSteam != mSteam) {
                var1.func_71112_a(this, 17, mSteam & 65535);
                var1.func_71112_a(this, 18, mSteam >>> 16);
            }
            if (mTimer % 500 == 10 || oSteamStorage != mSteamStorage) {
                var1.func_71112_a(this, 19, mSteamStorage & 65535);
                var1.func_71112_a(this, 20, mSteamStorage >>> 16);
            }
        }

        oID = mID;
        oSteam = mSteam;
        oInput = mInput;
        oActive = mActive;
        oOutput = mOutput;
        oEnergy = mEnergy;
        oStorage = mStorage;
        oSteamStorage = mSteamStorage;
        oProgressTime = mProgressTime;
        oMaxProgressTime = mMaxProgressTime;
        oDisplayErrorCode = mDisplayErrorCode;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void func_75137_b(int par1, int par2) {
        super.func_75137_b(par1, par2);
        switch (par1) {
            case 0:
                mEnergy = mEnergy & -65536 | par2;
                break;
            case 1:
                mEnergy = mEnergy & 65535 | par2 << 16;
                break;
            case 2:
                mStorage = mStorage & -65536 | par2;
                break;
            case 3:
                mStorage = mStorage & 65535 | par2 << 16;
                break;
            case 4:
                mOutput = par2;
                break;
            case 5:
                mInput = par2;
                break;
            case 6:
                mDisplayErrorCode = par2;
                break;
            case 11:
                mProgressTime = mProgressTime & -65536 | par2;
                break;
            case 12:
                mProgressTime = mProgressTime & 65535 | par2 << 16;
                break;
            case 13:
                mMaxProgressTime = mMaxProgressTime & -65536 | par2;
                break;
            case 14:
                mMaxProgressTime = mMaxProgressTime & 65535 | par2 << 16;
                break;
            case 15:
                mID = par2;
                break;
            case 16:
                mActive = par2;
                break;
            case 17:
                mSteam = mSteam & -65536 | par2;
                break;
            case 18:
                mSteam = mSteam & 65535 | par2 << 16;
                break;
            case 19:
                mSteamStorage = mSteamStorage & -65536 | par2;
                break;
            case 20:
                mSteamStorage = mSteamStorage & 65535 | par2 << 16;
                break;
        }
    }

    @Override
    public boolean func_75145_c(EntityPlayer player) {
        return mTileEntity.func_70300_a(player);
    }
}
