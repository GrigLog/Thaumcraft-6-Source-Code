// 
// Decompiled by Procyon v0.6.0
// 

package thaumcraft.common.lib.research.theorycraft;

import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import thaumcraft.api.items.ItemsTC;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentTranslation;
import thaumcraft.common.lib.crafting.ThaumcraftCraftingManager;
import java.util.Random;
import thaumcraft.api.research.theorycraft.ResearchTableData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.item.ItemStack;
import thaumcraft.api.research.theorycraft.TheorycraftCard;

public class CardTinker extends TheorycraftCard
{
    ItemStack stack;
    static ItemStack[] options;
    
    public CardTinker() {
        stack = ItemStack.EMPTY;
    }
    
    @Override
    public NBTTagCompound serialize() {
        NBTTagCompound nbt = super.serialize();
        nbt.setTag("stack", stack.serializeNBT());
        return nbt;
    }
    
    @Override
    public void deserialize(NBTTagCompound nbt) {
        super.deserialize(nbt);
        stack = new ItemStack(nbt.getCompoundTag("stack"));
    }
    
    @Override
    public boolean initialize(EntityPlayer player, ResearchTableData data) {
        Random r = new Random(getSeed());
        stack = CardTinker.options[r.nextInt(CardTinker.options.length)].copy();
        return stack != null;
    }
    
    @Override
    public int getInspirationCost() {
        return 1;
    }
    
    @Override
    public String getResearchCategory() {
        return "ARTIFICE";
    }
    
    private int getVal() {
        int q = 0;
        try {
            q += (int)Math.sqrt(ThaumcraftCraftingManager.getObjectTags(stack).visSize());
        }
        catch (Exception ex) {}
        return q;
    }
    
    @Override
    public String getLocalizedName() {
        return new TextComponentTranslation("card.tinker.name").getFormattedText();
    }
    
    @Override
    public String getLocalizedText() {
        int a = getVal() * 2;
        int b = a + 10;
        return new TextComponentTranslation("card.tinker.text", a, b).getFormattedText();
    }
    
    @Override
    public ItemStack[] getRequiredItems() {
        return new ItemStack[] { stack };
    }
    
    @Override
    public boolean activate(EntityPlayer player, ResearchTableData data) {
        int q = getVal() * 2;
        data.addTotal(getResearchCategory(), MathHelper.getInt(player.getRNG(), q, q + 10));
        return true;
    }
    
    static {
        CardTinker.options = new ItemStack[] { new ItemStack(ItemsTC.visResonator), new ItemStack(ItemsTC.thaumometer), new ItemStack(Blocks.ANVIL), new ItemStack(Blocks.ACTIVATOR_RAIL), new ItemStack(Blocks.DISPENSER), new ItemStack(Blocks.DROPPER), new ItemStack(Blocks.ENCHANTING_TABLE), new ItemStack(Blocks.ENDER_CHEST), new ItemStack(Blocks.JUKEBOX), new ItemStack(Blocks.DAYLIGHT_DETECTOR), new ItemStack(Blocks.PISTON), new ItemStack(Blocks.HOPPER), new ItemStack(Blocks.STICKY_PISTON), new ItemStack(Items.MAP), new ItemStack(Items.COMPASS), new ItemStack(Items.TNT_MINECART), new ItemStack(Items.COMPARATOR), new ItemStack(Items.CLOCK) };
    }
}
