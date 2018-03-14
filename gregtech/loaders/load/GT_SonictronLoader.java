package gregtech.loaders.load;

import gregtech.GT_Mod;
import gregtech.api.util.GT_Log;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class GT_SonictronLoader
        implements Runnable {
    public void run() {
        GT_Log.out.println("GT_Mod: Loading Sonictron Sounds");
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Blocks.field_150339_S, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("note.harp");
        GT_Mod.gregtechproxy.mSoundCounts.add(25);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Blocks.field_150340_R, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("note.pling");
        GT_Mod.gregtechproxy.mSoundCounts.add(25);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Blocks.field_150348_b, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("note.bd");
        GT_Mod.gregtechproxy.mSoundCounts.add(25);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Blocks.field_150364_r, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("note.bassattack");
        GT_Mod.gregtechproxy.mSoundCounts.add(25);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Blocks.field_150344_f, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("note.bass");
        GT_Mod.gregtechproxy.mSoundCounts.add(25);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Blocks.field_150359_w, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("note.hat");
        GT_Mod.gregtechproxy.mSoundCounts.add(25);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Blocks.field_150354_m, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("note.snare");
        GT_Mod.gregtechproxy.mSoundCounts.add(25);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Items.field_151093_ce, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("streaming.");
        GT_Mod.gregtechproxy.mSoundCounts.add(12);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Blocks.field_150335_W, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("random.explode");
        GT_Mod.gregtechproxy.mSoundCounts.add(3);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Blocks.field_150480_ab, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("fire.fire");
        GT_Mod.gregtechproxy.mSoundCounts.add(1);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Items.field_151033_d, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("fire.ignite");
        GT_Mod.gregtechproxy.mSoundCounts.add(1);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Blocks.field_150353_l, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("liquid.lavapop");
        GT_Mod.gregtechproxy.mSoundCounts.add(1);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Blocks.field_150355_j, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("liquid.water");
        GT_Mod.gregtechproxy.mSoundCounts.add(1);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Items.field_151131_as, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("liquid.splash");
        GT_Mod.gregtechproxy.mSoundCounts.add(1);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Items.field_151129_at, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("random.fizz");
        GT_Mod.gregtechproxy.mSoundCounts.add(1);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Blocks.field_150427_aO, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("portal.portal");
        GT_Mod.gregtechproxy.mSoundCounts.add(1);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Blocks.field_150384_bq, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("portal.travel");
        GT_Mod.gregtechproxy.mSoundCounts.add(1);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Blocks.field_150378_br, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("portal.trigger");
        GT_Mod.gregtechproxy.mSoundCounts.add(1);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Blocks.field_150410_aZ, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("random.glass");
        GT_Mod.gregtechproxy.mSoundCounts.add(1);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Items.field_151079_bi, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("random.orb");
        GT_Mod.gregtechproxy.mSoundCounts.add(1);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Items.field_151061_bv, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("random.levelup");
        GT_Mod.gregtechproxy.mSoundCounts.add(1);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Blocks.field_150430_aB, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("random.click");
        GT_Mod.gregtechproxy.mSoundCounts.add(1);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Blocks.field_150347_e, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("damage.fallbig");
        GT_Mod.gregtechproxy.mSoundCounts.add(1);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Blocks.field_150346_d, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("damage.fallsmall");
        GT_Mod.gregtechproxy.mSoundCounts.add(1);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Items.field_151040_l, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("damage.hurtflesh");
        GT_Mod.gregtechproxy.mSoundCounts.add(1);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Items.field_151048_u, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("random.hurt");
        GT_Mod.gregtechproxy.mSoundCounts.add(1);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Items.field_151031_f, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("random.bow");
        GT_Mod.gregtechproxy.mSoundCounts.add(1);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Items.field_151032_g, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("random.drr");
        GT_Mod.gregtechproxy.mSoundCounts.add(1);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Items.field_151112_aM, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("random.bowhit");
        GT_Mod.gregtechproxy.mSoundCounts.add(1);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Items.field_151037_a, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("random.break");
        GT_Mod.gregtechproxy.mSoundCounts.add(1);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Items.field_151133_ar, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("random.breath");
        GT_Mod.gregtechproxy.mSoundCounts.add(1);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Items.field_151068_bn, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("random.drink");
        GT_Mod.gregtechproxy.mSoundCounts.add(1);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Items.field_151069_bo, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("random.burp");
        GT_Mod.gregtechproxy.mSoundCounts.add(1);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Blocks.field_150477_bB == null ? Blocks.field_150343_Z : Blocks.field_150477_bB, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("random.chestopen");
        GT_Mod.gregtechproxy.mSoundCounts.add(1);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Blocks.field_150486_ae, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("random.chestclosed");
        GT_Mod.gregtechproxy.mSoundCounts.add(1);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Items.field_151139_aw, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("random.door_open");
        GT_Mod.gregtechproxy.mSoundCounts.add(1);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Items.field_179570_aq, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("random.door_close");
        GT_Mod.gregtechproxy.mSoundCounts.add(1);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Items.field_151147_al, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("random.eat");
        GT_Mod.gregtechproxy.mSoundCounts.add(1);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Blocks.field_150325_L, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("step.cloth");
        GT_Mod.gregtechproxy.mSoundCounts.add(1);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Blocks.field_150349_c, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("step.grass");
        GT_Mod.gregtechproxy.mSoundCounts.add(1);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Blocks.field_150351_n, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("step.gravel");
        GT_Mod.gregtechproxy.mSoundCounts.add(1);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Blocks.field_150433_aE, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("step.snow");
        GT_Mod.gregtechproxy.mSoundCounts.add(1);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Blocks.field_150331_J, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("tile.piston.out");
        GT_Mod.gregtechproxy.mSoundCounts.add(1);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Blocks.field_150320_F, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("tile.piston.in");
        GT_Mod.gregtechproxy.mSoundCounts.add(1);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Blocks.field_150341_Y, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("ambient.cave.cave");
        GT_Mod.gregtechproxy.mSoundCounts.add(1);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Blocks.field_150368_y, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("ambient.weather.rain");
        GT_Mod.gregtechproxy.mSoundCounts.add(1);
        GT_Mod.gregtechproxy.mSoundItems.add(new ItemStack(Blocks.field_150484_ah, 1));
        GT_Mod.gregtechproxy.mSoundNames.add("ambient.weather.thunder");
        GT_Mod.gregtechproxy.mSoundCounts.add(1);
    }
}
