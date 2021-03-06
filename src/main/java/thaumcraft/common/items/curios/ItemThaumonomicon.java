package thaumcraft.common.items.curios;

import net.minecraft.item.EnumRarity;
import java.util.Iterator;
import java.util.Collection;
import net.minecraft.util.EnumActionResult;
import thaumcraft.Thaumcraft;
import net.minecraft.util.SoundCategory;
import thaumcraft.common.lib.SoundsTC;
import net.minecraft.entity.player.EntityPlayerMP;
import thaumcraft.common.lib.research.ResearchManager;
import thaumcraft.api.capabilities.ThaumcraftCapabilities;
import thaumcraft.common.lib.CommandThaumcraft;
import thaumcraft.api.research.ResearchEntry;
import thaumcraft.api.research.ResearchCategory;
import thaumcraft.api.research.ResearchCategories;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.client.util.ITooltipFlag;
import java.util.List;
import net.minecraft.world.World;
import thaumcraft.common.config.ModConfig;
import net.minecraft.item.Item;
import thaumcraft.common.config.ConfigItems;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.creativetab.CreativeTabs;
import thaumcraft.common.items.ItemTCBase;

public class ItemThaumonomicon extends ItemTCBase
{
    public ItemThaumonomicon() {
        super("thaumonomicon", "normal", "cheat");
        setHasSubtypes(true);
        setMaxStackSize(1);
    }
    
    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (tab == ConfigItems.TABTC || tab == CreativeTabs.SEARCH) {
            items.add(new ItemStack(this, 1, 0));
            if (ModConfig.CONFIG_MISC.allowCheatSheet) {
                items.add(new ItemStack(this, 1, 1));
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        if (stack.getItemDamage() == 1) {
            tooltip.add(TextFormatting.DARK_PURPLE + "Creative only");
        }
    }
    
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        if (!world.isRemote) {
            if (ModConfig.CONFIG_MISC.allowCheatSheet && player.getHeldItem(hand).getItemDamage() == 1) {
                Collection<ResearchCategory> rc = ResearchCategories.researchCategories.values();
                for (ResearchCategory cat : rc) {
                    Collection<ResearchEntry> rl = cat.research.values();
                    for (ResearchEntry ri : rl) {
                        CommandThaumcraft.giveRecursiveResearch(player, ri.getKey());
                    }
                }
            }
            else {
                Collection<ResearchCategory> rc = ResearchCategories.researchCategories.values();
                for (ResearchCategory cat : rc) {
                    Collection<ResearchEntry> rl = cat.research.values();
                    for (ResearchEntry ri : rl) {
                        if (ThaumcraftCapabilities.knowsResearch(player, ri.getKey()) && ri.getSiblings() != null) {
                            for (String sib : ri.getSiblings()) {
                                if (!ThaumcraftCapabilities.knowsResearch(player, sib)) {
                                    ResearchManager.completeResearch(player, sib);
                                }
                            }
                        }
                    }
                }
            }
            ThaumcraftCapabilities.getKnowledge(player).sync((EntityPlayerMP)player);
        }
        else {
            world.playSound(player.posX, player.posY, player.posZ, SoundsTC.page, SoundCategory.PLAYERS, 1.0f, 1.0f, false);
        }
        player.openGui(Thaumcraft.instance, 12, world, 0, 0, 0);
        return (ActionResult<ItemStack>)new ActionResult(EnumActionResult.SUCCESS, player.getHeldItem(hand));
    }
    
    public EnumRarity getRarity(ItemStack itemstack) {
        return (itemstack.getItemDamage() != 1) ? EnumRarity.UNCOMMON : EnumRarity.EPIC;
    }
}
