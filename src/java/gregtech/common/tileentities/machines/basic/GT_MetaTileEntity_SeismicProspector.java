package gregtech.common.tileentities.machines.basic;

import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.Textures;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_BasicMachine;
import gregtech.api.objects.GT_RenderedTexture;
import gregtech.api.objects.ItemData;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import gregtech.api.util.GT_ModHandler;
import ic2.core.ref.BlockName;
import ic2.core.ref.ItemName;
import ic2.core.ref.TeBlock;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fluids.FluidStack;

import java.util.ArrayList;
import java.util.List;

public class GT_MetaTileEntity_SeismicProspector extends GT_MetaTileEntity_BasicMachine {

    boolean ready = false;

    public GT_MetaTileEntity_SeismicProspector(int aID, String aName, String aNameRegional, int aTier) {
        super(aID, aName, aNameRegional, aTier, 1, "Place, activate with explosives(8 Dynamite, 1 Glyceryl, 4 TNT or 2 ITNT), use Data Stick", 1, 1, "Default.png", "", new ITexture[]{new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_SIDE_ROCK_BREAKER_ACTIVE), new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_SIDE_ROCK_BREAKER), new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_TOP_ROCK_BREAKER_ACTIVE), new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_TOP_ROCK_BREAKER), new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_FRONT_ROCK_BREAKER_ACTIVE), new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_FRONT_ROCK_BREAKER), new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_BOTTOM_ROCK_BREAKER_ACTIVE), new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_BOTTOM_ROCK_BREAKER)});
    }

    public GT_MetaTileEntity_SeismicProspector(String aName, int aTier, String aDescription, ITexture[][][] aTextures, String aGUIName, String aNEIName) {
        super(aName, aTier, 1, aDescription, aTextures, 1, 1, aGUIName, aNEIName);
    }

    public MetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new GT_MetaTileEntity_SeismicProspector(this.mName, this.mTier, this.mDescription, this.mTextures, this.mGUIName, this.mNEIName);
    }

    @Override
    public boolean onRightclick(IGregTechTileEntity aBaseMetaTileEntity, EntityPlayer aPlayer, EnumHand hand) {
        if (aBaseMetaTileEntity.isServerSide()) {
            ItemStack aStack = aPlayer.func_184586_b(hand);
            if (!ready && (aStack != null) && (
            		(aStack.func_77973_b() == Item.func_150898_a(Blocks.field_150335_W) && aStack.field_77994_a > 3 ) || 
            		(aStack.func_77973_b() == GT_ModHandler.getIC2Item(BlockName.te, TeBlock.itnt, 1).func_77973_b() && aStack.field_77994_a > 1 ) ||
            		(aStack.func_77973_b() == GT_ModHandler.getIC2Item(ItemName.dynamite, 1).func_77973_b() && aStack.field_77994_a > 7 ) ||
            		(GT_OreDictUnificator.getItemData(aStack).mMaterial.mMaterial == Materials.Glyceryl  && aStack.field_77994_a > 0 )
            		) ) {
                if ((!aPlayer.field_71075_bZ.field_75098_d) && (aStack.field_77994_a != 111)) {
                	if(aStack.func_77973_b() == Item.func_150898_a(Blocks.field_150335_W)){
                    aStack.field_77994_a -= 4;
                	}else if(aStack.func_77973_b() == GT_ModHandler.getIC2Item(BlockName.te, TeBlock.itnt, 1).func_77973_b()){
                    aStack.field_77994_a -= 2;
                    }else if(aStack.func_77973_b() == GT_ModHandler.getIC2Item(ItemName.dynamite, 1).func_77973_b()){
                    aStack.field_77994_a -= 8;
                    }else{
                    aStack.field_77994_a -= 1;
                    }
                }
                this.ready = true;
                this.mMaxProgresstime = 200;
            } else if (ready && mMaxProgresstime == 0 && aStack != null && aStack.field_77994_a == 1 && aStack.func_77973_b() == ItemList.Tool_DataStick.getItem()) {
                this.ready = false;
                GT_Utility.ItemNBT.setBookTitle(aPlayer.func_184586_b(hand), "Raw Prospection Data");
                List<String> tStringList = new ArrayList<String>();
                for (int i = this.getBaseMetaTileEntity().getYCoord(); i > 0; i--) {
                    for (int f = -2; f < 3; f++) {
                        for (int g = -2; g < 3; g++) {
                            BlockPos blockPos = aBaseMetaTileEntity.getWorldPos().func_177982_a(f, -i, g);
                            IBlockState blockState = aBaseMetaTileEntity.getWorldObj().func_180495_p(blockPos);
                            Block tBlock = blockState.func_177230_c();
                            /*if ((tBlock instanceof GT_Block_Ores_Abstract)) {
                                TileEntity tTileEntity = getBaseMetaTileEntity().getWorldObj().getTileEntity(aBaseMetaTileEntity.getWorldPos().add(f, -i, g));
                                if ((tTileEntity instanceof GT_TileEntity_Ores)) {
                                	if(((GT_TileEntity_Ores) tTileEntity).mMetaData < 16000){
                                    Materials tMaterial = GregTech_API.sGeneratedMaterials[(((GT_TileEntity_Ores) tTileEntity).mMetaData % 1000)];
                                    if ((tMaterial != null) && (tMaterial != Materials._NULL)) {
                                        if (!tStringList.contains(tMaterial.mDefaultLocalName)) {
                                            tStringList.add(tMaterial.mDefaultLocalName);
                                        }
                                    }
                                  }
                                }
                            } else*/ {
                                int tMetaID = blockState.func_177230_c().func_176201_c(blockState);
                                ItemData tAssotiation = GT_OreDictUnificator.getAssociation(new ItemStack(tBlock, 1, tMetaID));
                                if ((tAssotiation != null) && (tAssotiation.mPrefix.toString().startsWith("ore"))) {
                                    if (!tStringList.contains(tAssotiation.mMaterial.mMaterial.mDefaultLocalName)) {
                                        tStringList.add(tAssotiation.mMaterial.mMaterial.mDefaultLocalName);
                                    }
                                }
                            }
                        }
                    }
                }
                if(tStringList.size()<1){tStringList.add("No Ores found.");}
                FluidStack tFluid = GT_Utility.getUndergroundOil(getBaseMetaTileEntity().getWorldObj(), getBaseMetaTileEntity().getXCoord(), getBaseMetaTileEntity().getZCoord());
                String[] tStringArray = new String[tStringList.size()];
                {
                    for (int i = 0; i < tStringArray.length; i++) {
                        tStringArray[i] = tStringList.get(i);
                    }
                }
                GT_Utility.ItemNBT.setProspectionData(aPlayer.func_184586_b(hand), this.getBaseMetaTileEntity().getXCoord(), this.getBaseMetaTileEntity().getYCoord(), this.getBaseMetaTileEntity().getZCoord(), this.getBaseMetaTileEntity().getWorldObj().field_73011_w.getDimension(), tFluid, tStringArray);
            }
        }

        return true;
    }

}