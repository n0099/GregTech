package gregtech.api.util;

import gregtech.api.damagesources.GT_DamageSources;
import gregtech.api.interfaces.IFoodStat;
import gregtech.api.items.GT_MetaBase_Item;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.SoundCategory;

public class GT_FoodStat implements IFoodStat {
    private final int mFoodLevel;
    private final int[] mPotionEffects;
    private final float mSaturation;
    private final EnumAction mAction;
    private final ItemStack mEmptyContainer;
    private final boolean mAlwaysEdible, mInvisibleParticles, mIsRotten;
    private boolean mExplosive = false, mMilk = false;

    /**
     * @param aFoodLevel          Amount of Food in Half Bacon [0 - 20]
     * @param aSaturation         Amount of Saturation [0.0F - 1.0F]
     * @param aAction             The Action to be used. If this is null, it uses the Eating Action
     * @param aEmptyContainer     An empty Container (Optional)
     * @param aAlwaysEdible       If this Item is always edible, like Golden Apples or Potions
     * @param aInvisibleParticles If the Particles of the Potion Effects are invisible
     * @param aPotionEffects      An Array of Potion Effects with %4==0 Elements as follows
     *                            ID of a Potion Effect. 0 for none
     *                            Duration of the Potion in Ticks
     *                            Level of the Effect. [0, 1, 2] are for [I, II, III]
     *                            The likelihood that this Potion Effect takes place upon being eaten [1 - 100]
     */
    public GT_FoodStat(int aFoodLevel, float aSaturation, EnumAction aAction, ItemStack aEmptyContainer, boolean aAlwaysEdible, boolean aInvisibleParticles, boolean aIsRotten, int... aPotionEffects) {
        mFoodLevel = aFoodLevel;
        mSaturation = aSaturation;
        mAction = aAction == null ? EnumAction.EAT : aAction;
        mPotionEffects = aPotionEffects;
        mEmptyContainer = GT_Utility.copy(aEmptyContainer);
        mInvisibleParticles = aInvisibleParticles;
        mAlwaysEdible = aAlwaysEdible;
        mIsRotten = aIsRotten;
    }

    public GT_FoodStat setExplosive() {
        mExplosive = true;
        return this;
    }

    public GT_FoodStat setMilk() {
        mMilk = true;
        return this;
    }

    @Override
    public int getFoodLevel(GT_MetaBase_Item aItem, ItemStack aStack, EntityPlayer aPlayer) {
        return mFoodLevel;
    }

    @Override
    public float getSaturation(GT_MetaBase_Item aItem, ItemStack aStack, EntityPlayer aPlayer) {
        return mSaturation;
    }

    @Override
    public void onEaten(GT_MetaBase_Item aItem, ItemStack aStack, EntityPlayer aPlayer) {
        aStack.field_77994_a--;
        ItemStack tStack = GT_OreDictUnificator.get(GT_Utility.copy(mEmptyContainer));
        if (tStack != null && !aPlayer.field_71071_by.func_70441_a(tStack))
            aPlayer.func_71019_a(tStack, true);
        aPlayer.field_70170_p.func_184133_a(aPlayer, aPlayer.func_180425_c(), SoundEvents.field_187739_dZ, SoundCategory.VOICE, 0.5F, aPlayer.field_70170_p.field_73012_v.nextFloat() * 0.1F + 0.9F);
        if (!aPlayer.field_70170_p.field_72995_K) {
            if (mMilk) {
                aPlayer.curePotionEffects(new ItemStack(Items.field_151117_aB, 1, 0));
            }
            for (int i = 3; i < mPotionEffects.length; i += 4) {
                if (aPlayer.field_70170_p.field_73012_v.nextInt(100) < mPotionEffects[i]) {
                    aPlayer.func_70690_d(new PotionEffect(Potion.func_188412_a(mPotionEffects[i - 3]), mPotionEffects[i - 2], mPotionEffects[i - 1], false, mInvisibleParticles));
                }
            }
            if (mExplosive) {
                aPlayer.field_70170_p.func_72885_a(aPlayer, aPlayer.field_70165_t, aPlayer.field_70163_u, aPlayer.field_70161_v, 4, true, true);
                aPlayer.func_70097_a(GT_DamageSources.getExplodingDamage(), Float.MAX_VALUE);
            }
        }
    }

    @Override
    public EnumAction getFoodAction(GT_MetaBase_Item aItem, ItemStack aStack) {
        return mAction;
    }

    @Override
    public boolean alwaysEdible(GT_MetaBase_Item aItem, ItemStack aStack, EntityPlayer aPlayer) {
        return mAlwaysEdible;
    }

    @Override
    public boolean isRotten(GT_MetaBase_Item aItem, ItemStack aStack, EntityPlayer aPlayer) {
        return mIsRotten;
    }
}