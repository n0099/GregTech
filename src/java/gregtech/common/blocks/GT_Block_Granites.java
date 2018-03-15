package gregtech.common.blocks;

import com.google.common.collect.ImmutableList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_LanguageManager;
import gregtech.api.util.GT_OreDictUnificator;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GT_Block_Granites extends GT_Block_Stones_Abstract {

    public GT_Block_Granites() {
        super(GT_Item_Granites.class, "gt.blockgranites");
        func_149752_b(60.0F);
        GT_LanguageManager.addStringLocalization(func_149739_a() + ".0.name", "Black Granite");
        GT_LanguageManager.addStringLocalization(func_149739_a() + ".1.name", "Black Granite Cobblestone");
        GT_LanguageManager.addStringLocalization(func_149739_a() + ".2.name", "Mossy Black Granite Cobblestone");
        GT_LanguageManager.addStringLocalization(func_149739_a() + ".3.name", "Black Granite Bricks");
        GT_LanguageManager.addStringLocalization(func_149739_a() + ".4.name", "Cracked Black Granite Bricks");
        GT_LanguageManager.addStringLocalization(func_149739_a() + ".5.name", "Mossy Black Granite Bricks");
        GT_LanguageManager.addStringLocalization(func_149739_a() + ".6.name", "Chiseled Black Granite");
        GT_LanguageManager.addStringLocalization(func_149739_a() + ".7.name", "Smooth Black Granite");
        GT_LanguageManager.addStringLocalization(func_149739_a() + ".8.name", "Red Granite");
        GT_LanguageManager.addStringLocalization(func_149739_a() + ".9.name", "Red Granite Cobblestone");
        GT_LanguageManager.addStringLocalization(func_149739_a() + ".10.name", "Mossy Red Granite Cobblestone");
        GT_LanguageManager.addStringLocalization(func_149739_a() + ".11.name", "Red Granite Bricks");
        GT_LanguageManager.addStringLocalization(func_149739_a() + ".12.name", "Cracked Red Granite Bricks");
        GT_LanguageManager.addStringLocalization(func_149739_a() + ".13.name", "Mossy Red Granite Bricks");
        GT_LanguageManager.addStringLocalization(func_149739_a() + ".14.name", "Chiseled Red Granite");
        GT_LanguageManager.addStringLocalization(func_149739_a() + ".15.name", "Smooth Red Granite");
        GT_OreDictUnificator.registerOre(OrePrefixes.stone, Materials.GraniteBlack, new ItemStack(this, 1, 0));
        GT_OreDictUnificator.registerOre(OrePrefixes.stone, Materials.GraniteBlack, new ItemStack(this, 1, 1));
        GT_OreDictUnificator.registerOre(OrePrefixes.stone, Materials.GraniteBlack, new ItemStack(this, 1, 2));
        GT_OreDictUnificator.registerOre(OrePrefixes.stone, Materials.GraniteBlack, new ItemStack(this, 1, 3));
        GT_OreDictUnificator.registerOre(OrePrefixes.stone, Materials.GraniteBlack, new ItemStack(this, 1, 4));
        GT_OreDictUnificator.registerOre(OrePrefixes.stone, Materials.GraniteBlack, new ItemStack(this, 1, 5));
        GT_OreDictUnificator.registerOre(OrePrefixes.stone, Materials.GraniteBlack, new ItemStack(this, 1, 6));
        GT_OreDictUnificator.registerOre(OrePrefixes.stone, Materials.GraniteBlack, new ItemStack(this, 1, 7));
        GT_OreDictUnificator.registerOre(OrePrefixes.stone, Materials.GraniteRed, new ItemStack(this, 1, 8));
        GT_OreDictUnificator.registerOre(OrePrefixes.stone, Materials.GraniteRed, new ItemStack(this, 1, 9));
        GT_OreDictUnificator.registerOre(OrePrefixes.stone, Materials.GraniteRed, new ItemStack(this, 1, 10));
        GT_OreDictUnificator.registerOre(OrePrefixes.stone, Materials.GraniteRed, new ItemStack(this, 1, 11));
        GT_OreDictUnificator.registerOre(OrePrefixes.stone, Materials.GraniteRed, new ItemStack(this, 1, 12));
        GT_OreDictUnificator.registerOre(OrePrefixes.stone, Materials.GraniteRed, new ItemStack(this, 1, 13));
        GT_OreDictUnificator.registerOre(OrePrefixes.stone, Materials.GraniteRed, new ItemStack(this, 1, 14));
        GT_OreDictUnificator.registerOre(OrePrefixes.stone, Materials.GraniteRed, new ItemStack(this, 1, 15));
    }

    @Override
    public int getHarvestLevel(IBlockState blockState) {
        return 3;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getIcon(EnumFacing aSide, int aMeta) {
        if ((aMeta >= 0) && (aMeta < 16)) {
            return gregtech.api.enums.Textures.BlockIcons.GRANITES[aMeta].getIcon();
        }
        return gregtech.api.enums.Textures.BlockIcons.GRANITES[0].getIcon();
    }

    @Override
    public boolean canEntityDestroy(IBlockState state, IBlockAccess world, BlockPos pos, Entity entity) {
        return !(entity instanceof EntityWither);
    }

}