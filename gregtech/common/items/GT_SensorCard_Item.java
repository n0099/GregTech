package gregtech.common.items;

import gregtech.api.items.GT_Generic_Item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.UUID;

public class GT_SensorCard_Item extends GT_Generic_Item {
        //implements IRemoteSensor, IPanelDataSource {
    private static final UUID CARD_TYPE = new UUID(0L, 41L);

    public GT_SensorCard_Item(String aUnlocalized, String aEnglish) {
        super(aUnlocalized, aEnglish, "Insert into Display Panel");
        func_77625_d(1);
    }

    public void addAdditionalToolTips(List aList, ItemStack aStack, EntityPlayer aPlayer) {
        super.addAdditionalToolTips(aList, aStack, aPlayer);
        if (aStack != null) {
            NBTTagCompound tNBT = aStack.func_77978_p();
            if (tNBT == null) {
                aList.add("Missing Coodinates!");
            } else {
                aList.add("Device at:");
                aList.add(String.format("x: %d, y: %d, z: %d",
                        tNBT.func_74762_e("x"),
                        tNBT.func_74762_e("y"),
                        tNBT.func_74762_e("z")));
            }
        }
    }

    /*@Override
    public CardState update(TileEntity aPanel, ICardWrapper aCard, int aMaxRange) {
        return update(aPanel.getWorldObj(), aCard, aMaxRange);
    }

    @Override
    public CardState update(World world, ICardWrapper aCard, int aMaxRange) {
        ChunkCoordinates target = aCard.getTarget();

        TileEntity tTileEntity = world.getTileEntity(target.posX, target.posY, target.posZ);
        if (((tTileEntity instanceof IGregTechDeviceInformation)) && (((IGregTechDeviceInformation) tTileEntity).isGivingInformation())) {
            String[] tInfoData = ((IGregTechDeviceInformation) tTileEntity).getInfoData();
            for (int i = 0; i < tInfoData.length; i++) {
                aCard.setString("mString" + i, tInfoData[i]);
            }
            return CardState.OK;
        }
        return CardState.NO_TARGET;
    }

    public List<PanelString> getStringData(int aSettings, ICardWrapper aCard, boolean aLabels) {
        List<PanelString> rList = new LinkedList();
        for (int i = 0; i < 8; i++) {
            if ((aSettings & 1 << i) != 0) {
                PanelString line = new PanelString();
                line.textLeft = GT_LanguageManager.getTranslation(aCard.getString("mString" + i), "\\\\");
                rList.add(line);
            }
        }
        return rList;
    }

    public List<PanelSetting> getSettingsList() {
        List<PanelSetting> rList = new ArrayList(30);
        for (int i = 0; i < 8; i++) {
            rList.add(new PanelSetting(String.valueOf((i + 1)), 1 << i, getCardType()));
        }
        return rList;
    }

    public UUID getCardType() {
        return CARD_TYPE;
    }*/

    @SideOnly(Side.CLIENT)
    public void func_150895_a(Item var1, CreativeTabs aTab, List aList) {}

}