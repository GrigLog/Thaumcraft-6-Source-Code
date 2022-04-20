// 
// Decompiled by Procyon v0.6.0
// 

package thaumcraft.common.blocks.world.plants;

import net.minecraft.block.Block;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.util.EnumParticleTypes;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.init.Blocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.SoundType;
import thaumcraft.common.config.ConfigItems;
import net.minecraft.block.material.Material;
import net.minecraft.block.BlockBush;

public class BlockPlantCinderpearl extends BlockBush
{
    public BlockPlantCinderpearl() {
        super(Material.PLANTS);
        this.setUnlocalizedName("cinderpearl");
        this.setRegistryName("thaumcraft", "cinderpearl");
        this.setCreativeTab(ConfigItems.TABTC);
        this.setSoundType(SoundType.PLANT);
        this.setLightLevel(0.5f);
    }
    
    protected boolean canSustainBush(final IBlockState state) {
        return state.getBlock() == Blocks.SAND || state.getBlock() == Blocks.DIRT || state.getBlock() == Blocks.STAINED_HARDENED_CLAY || state.getBlock() == Blocks.HARDENED_CLAY;
    }
    
    public EnumPlantType getPlantType(final IBlockAccess world, final BlockPos pos) {
        return EnumPlantType.Desert;
    }
    
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(final IBlockState state, final World world, final BlockPos pos, final Random rand) {
        if (rand.nextBoolean()) {
            final float xr = pos.getX() + 0.5f + (rand.nextFloat() - rand.nextFloat()) * 0.1f;
            final float yr = pos.getY() + 0.6f + (rand.nextFloat() - rand.nextFloat()) * 0.1f;
            final float zr = pos.getZ() + 0.5f + (rand.nextFloat() - rand.nextFloat()) * 0.1f;
            world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, xr, yr, zr, 0.0, 0.0, 0.0, new int[0]);
            world.spawnParticle(EnumParticleTypes.FLAME, xr, yr, zr, 0.0, 0.0, 0.0, new int[0]);
        }
    }
    
    public Block.EnumOffsetType getOffsetType() {
        return Block.EnumOffsetType.XZ;
    }
}