// 
// Decompiled by Procyon v0.6.0
// 

package thaumcraft.common.blocks.world.plants;

import net.minecraft.block.BlockPlanks;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.item.Item;
import thaumcraft.api.items.ItemsTC;
import thaumcraft.common.world.aura.AuraHandler;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.util.NonNullList;
import net.minecraft.creativetab.CreativeTabs;
import thaumcraft.api.blocks.BlocksTC;
import net.minecraft.block.material.MapColor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import thaumcraft.common.config.ConfigItems;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockLeaves;

public class BlockLeavesTC extends BlockLeaves
{
    public BlockLeavesTC(final String name) {
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty)BlockLeavesTC.CHECK_DECAY, (Comparable)true).withProperty((IProperty)BlockLeavesTC.DECAYABLE, (Comparable)true));
        this.setCreativeTab(ConfigItems.TABTC);
        this.setUnlocalizedName(name);
        this.setRegistryName("thaumcraft", name);
    }
    
    public int getFlammability(final IBlockAccess world, final BlockPos pos, final EnumFacing face) {
        return 60;
    }
    
    public int getFireSpreadSpeed(final IBlockAccess world, final BlockPos pos, final EnumFacing face) {
        return 30;
    }
    
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return Blocks.LEAVES.getBlockLayer();
    }
    
    public boolean isOpaqueCube(final IBlockState state) {
        return Blocks.LEAVES.isOpaqueCube(state);
    }
    
    public void onBlockPlacedBy(final World worldIn, final BlockPos pos, final IBlockState state, final EntityLivingBase placer, final ItemStack stack) {
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
        if (placer != null && placer instanceof EntityPlayer) {
            worldIn.setBlockState(pos, state.withProperty((IProperty)BlockLeavesTC.DECAYABLE, (Comparable)false));
        }
    }
    
    public boolean shouldSideBeRendered(final IBlockState blockState, final IBlockAccess blockAccess, final BlockPos pos, final EnumFacing side) {
        this.setGraphicsLevel(!this.isOpaqueCube(blockState));
        return super.shouldSideBeRendered(blockState, blockAccess, pos, side);
    }
    
    public MapColor getMapColor(final IBlockState state, final IBlockAccess worldIn, final BlockPos pos) {
        return (state.getBlock() == BlocksTC.leafSilverwood) ? MapColor.LIGHT_BLUE : super.getMapColor(state, worldIn, pos);
    }
    
    public int damageDropped(final IBlockState state) {
        return 0;
    }
    
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(final CreativeTabs tab, final NonNullList<ItemStack> list) {
        list.add(new ItemStack(this));
    }
    
    protected ItemStack getSilkTouchDrop(final IBlockState state) {
        return new ItemStack(this);
    }
    
    public void updateTick(final World worldIn, final BlockPos pos, final IBlockState state, final Random rand) {
        if (!worldIn.isRemote && state.getBlock() == BlocksTC.leafSilverwood && (boolean)state.getValue((IProperty)BlockLeavesTC.DECAYABLE) && AuraHandler.getVis(worldIn, pos) < AuraHandler.getAuraBase(worldIn, pos)) {
            AuraHandler.addVis(worldIn, pos, 0.01f);
        }
        super.updateTick(worldIn, pos, state, rand);
    }
    
    public IBlockState getStateFromMeta(final int meta) {
        return this.getDefaultState().withProperty((IProperty)BlockLeavesTC.DECAYABLE, (Comparable)((meta & 0x4) == 0x0)).withProperty((IProperty)BlockLeavesTC.CHECK_DECAY, (Comparable)((meta & 0x8) > 0));
    }
    
    public int getMetaFromState(final IBlockState state) {
        int i = 0;
        if (!(boolean)state.getValue(BlockLeavesTC.DECAYABLE)) {
            i |= 0x4;
        }
        if (state.getValue(BlockLeavesTC.CHECK_DECAY)) {
            i |= 0x8;
        }
        return i;
    }
    
    protected int getSaplingDropChance(final IBlockState state) {
        return 75;
    }
    
    protected void dropApple(final World worldIn, final BlockPos pos, final IBlockState state, final int chance) {
        if (state.getBlock() == BlocksTC.leafSilverwood && worldIn.rand.nextInt((int)(chance * 0.75)) == 0) {
            spawnAsEntity(worldIn, pos, new ItemStack(ItemsTC.nuggets, 1, 5));
        }
    }
    
    public Item getItemDropped(final IBlockState state, final Random rand, final int fortune) {
        return (state.getBlock() == BlocksTC.leafSilverwood) ? Item.getItemFromBlock(BlocksTC.saplingSilverwood) : Item.getItemFromBlock(BlocksTC.saplingGreatwood);
    }
    
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {BlockLeavesTC.CHECK_DECAY, BlockLeavesTC.DECAYABLE});
    }
    
    public List<ItemStack> onSheared(final ItemStack item, final IBlockAccess world, final BlockPos pos, final int fortune) {
        final IBlockState state = world.getBlockState(pos);
        return new ArrayList<ItemStack>(Arrays.asList(new ItemStack(this)));
    }
    
    public BlockPlanks.EnumType getWoodType(final int meta) {
        return null;
    }
}