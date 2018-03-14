package gregtech.common.items.armor;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerBasicArmor extends ContainerModularArmor {

	public ContainerBasicArmor(EntityPlayer player, InventoryArmor aInvArmor) {
		super(player, aInvArmor);
	}
	
	public void addSlots(InventoryPlayer aInventoryPlayer) {
		func_75146_a(new Slot(mInvArmor, 0, 118, 6));
		func_75146_a(new Slot(mInvArmor, 1, 136, 6));
		func_75146_a(new Slot(mInvArmor, 2, 154, 6));
		func_75146_a(new Slot(mInvArmor, 3, 118, 24));
		func_75146_a(new Slot(mInvArmor, 4, 136, 24));
		func_75146_a(new Slot(mInvArmor, 5, 154, 24));
		func_75146_a(new Slot(mInvArmor, 6, 118, 42));
		func_75146_a(new Slot(mInvArmor, 7, 136, 42));
		func_75146_a(new Slot(mInvArmor, 8, 154, 42));

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				func_75146_a(new Slot(aInventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (int i = 0; i < 9; i++) {
			ItemStack stackInSlot = aInventoryPlayer.func_70301_a(i);
		    if(isIdenticalItem(mInvArmor.parent,stackInSlot)){
				func_75146_a(new SlotLocked(aInventoryPlayer,i,8+i*18,142));
			}else{
			func_75146_a(new Slot(aInventoryPlayer, i, 8 + i * 18, 142));}
		}
	}

	public int getSlotCount() {
		return 9;
	}

	public int getShiftClickSlotCount() {
		return 9;
	}

}
