// 
// Decompiled by Procyon v0.6.0
// 

package thaumcraft.common.blocks.basic;

import net.minecraft.util.IStringSerializable;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.SoundType;
import thaumcraft.common.config.ConfigItems;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.BlockSlab;

public class BlockSlabTC extends BlockSlab
{
    public static final PropertyEnum<Variant> VARIANT;
    boolean wood;
    Block drop;
    
    protected BlockSlabTC(final String name, final Block b, final boolean wood) {
        super(wood ? Material.WOOD : Material.ROCK);
        this.wood = false;
        this.drop = null;
        this.drop = b;
        this.wood = wood;
        this.setUnlocalizedName(name);
        this.setRegistryName("thaumcraft", name);
        IBlockState iblockstate = this.blockState.getBaseState();
        if (!this.isDouble()) {
            iblockstate = iblockstate.withProperty((IProperty)BlockSlabTC.HALF, (Comparable)BlockSlab.EnumBlockHalf.BOTTOM);
            this.setCreativeTab(ConfigItems.TABTC);
        }
        this.setSoundType(wood ? SoundType.WOOD : SoundType.STONE);
        this.setDefaultState(iblockstate.withProperty((IProperty)BlockSlabTC.VARIANT, (Comparable)Variant.DEFAULT));
        this.useNeighborBrightness = !this.isDouble();
    }
    
    public Item getItemDropped(final IBlockState state, final Random rand, final int fortune) {
        return (this.drop == null) ? Item.getItemFromBlock(state.getBlock()) : Item.getItemFromBlock(this.drop);
    }
    
    @SideOnly(Side.CLIENT)
    public ItemStack getItem(final World worldIn, final BlockPos pos, final IBlockState state) {
        return new ItemStack(state.getBlock());
    }
    
    public IBlockState getStateFromMeta(final int meta) {
        IBlockState iblockstate = this.getDefaultState().withProperty((IProperty)BlockSlabTC.VARIANT, (Comparable)Variant.DEFAULT);
        if (!this.isDouble()) {
            iblockstate = iblockstate.withProperty((IProperty)BlockSlabTC.HALF, (Comparable)(((meta & 0x8) == 0x0) ? BlockSlab.EnumBlockHalf.BOTTOM : BlockSlab.EnumBlockHalf.TOP));
        }
        return iblockstate;
    }
    
    public int getMetaFromState(final IBlockState state) {
        int i = 0;
        if (!this.isDouble() && state.getValue((IProperty)BlockSlabTC.HALF) == BlockSlab.EnumBlockHalf.TOP) {
            i |= 0x8;
        }
        return i;
    }
    
    protected BlockStateContainer createBlockState() {
        return this.isDouble() ? new BlockStateContainer(this, new IProperty[] {BlockSlabTC.VARIANT}) : new BlockStateContainer(this, new IProperty[] {BlockSlabTC.HALF, BlockSlabTC.VARIANT});
    }
    
    public int damageDropped(final IBlockState state) {
        return 0;
    }
    
    public boolean isDouble() {
        return false;
    }
    
    public String getUnlocalizedName(final int meta) {
        return this.getUnlocalizedName();
    }
    
    public IProperty<?> getVariantProperty() {
        return BlockSlabTC.VARIANT;
    }
    
    public Comparable<?> getTypeForItem(final ItemStack stack) {
        return Variant.DEFAULT;
    }
    
    public int getFlammability(final IBlockAccess world, final BlockPos pos, final EnumFacing face) {
        return this.wood ? 20 : super.getFlammability(world, pos, face);
    }
    
    public int getFireSpreadSpeed(final IBlockAccess world, final BlockPos pos, final EnumFacing face) {
        return this.wood ? 5 : super.getFireSpreadSpeed(world, pos, face);
    }
    
    static {
        VARIANT = PropertyEnum.create("variant", (Class)Variant.class);
    }
    
    public static class Double extends BlockSlabTC
    {
        public Double(final String name, final Block b, final boolean wood) {
            super(name, b, wood);
        }
        
        @Override
        public boolean isDouble() {
            return true;
        }
    }
    
    public static class Half extends BlockSlabTC
    {
        public Half(final String name, final Block b, final boolean wood) {
            super(name, b, wood);
        }
        
        @Override
        public boolean isDouble() {
            return false;
        }
    }
    
    public enum Variant implements IStringSerializable
    {
        DEFAULT;
        
        public String getName() {
            return "default";
        }
    }
}