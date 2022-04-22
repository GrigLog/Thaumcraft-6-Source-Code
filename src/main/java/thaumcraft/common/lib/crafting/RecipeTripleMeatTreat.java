// 
// Decompiled by Procyon v0.6.0
// 

package thaumcraft.common.lib.crafting;

import net.minecraft.item.ItemStack;
import thaumcraft.api.items.ItemsTC;
import net.minecraft.init.Items;
import java.util.ArrayList;
import net.minecraft.world.World;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class RecipeTripleMeatTreat extends IForgeRegistryEntry.Impl<IRecipe> implements IRecipe
{
    public boolean matches(InventoryCrafting inv, World worldIn) {
        boolean sugar = false;
        ArrayList<Integer> meats = new ArrayList<Integer>();
        for (int a = 0; a < 3; ++a) {
            for (int b = 0; b < 3; ++b) {
                if (inv.getStackInRowAndColumn(a, b) != null) {
                    if (!inv.getStackInRowAndColumn(a, b).isEmpty()) {
                        ItemStack stack = inv.getStackInRowAndColumn(a, b).copy();
                        if (stack.getItem() == Items.SUGAR && sugar) {
                            return false;
                        }
                        if (stack.getItem() == Items.SUGAR && !sugar) {
                            sugar = true;
                        }
                        else {
                            if (stack.getItem() != ItemsTC.chunks) {
                                return false;
                            }
                            if (meats.contains(stack.getItemDamage()) || meats.size() >= 3) {
                                return false;
                            }
                            meats.add(stack.getItemDamage());
                        }
                    }
                }
            }
        }
        return sugar && meats.size() == 3;
    }
    
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        return new ItemStack(ItemsTC.tripleMeatTreat);
    }
    
    public ItemStack getRecipeOutput() {
        return new ItemStack(ItemsTC.tripleMeatTreat);
    }
    
    public boolean canFit(int width, int height) {
        return width * height >= 4;
    }
}
