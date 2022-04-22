// 
// Decompiled by Procyon v0.6.0
// 

package thaumcraft.common.blocks.devices;

import thaumcraft.Thaumcraft;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.SoundType;
import thaumcraft.common.tiles.devices.TilePotionSprayer;
import net.minecraft.block.material.Material;
import thaumcraft.common.blocks.IBlockEnabled;
import thaumcraft.common.blocks.IBlockFacing;
import thaumcraft.common.blocks.BlockTCDevice;

public class BlockPotionSprayer extends BlockTCDevice implements IBlockFacing, IBlockEnabled
{
    public BlockPotionSprayer() {
        super(Material.IRON, TilePotionSprayer.class, "potion_sprayer");
        setSoundType(SoundType.METAL);
    }
    
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (world.isRemote) {
            return true;
        }
        player.openGui(Thaumcraft.instance, 21, world, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }
    
    @Override
    public int damageDropped(IBlockState state) {
        return 0;
    }
}
