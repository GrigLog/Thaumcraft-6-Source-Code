// 
// Decompiled by Procyon v0.6.0
// 

package thaumcraft.common.lib.network.playerdata;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import thaumcraft.common.lib.SoundsTC;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketWarpMessage implements IMessage, IMessageHandler<PacketWarpMessage, IMessage>
{
    protected int data;
    protected byte type;
    
    public PacketWarpMessage() {
        this.data = 0;
        this.type = 0;
    }
    
    public PacketWarpMessage(final EntityPlayer player, final byte type, final int change) {
        this.data = 0;
        this.type = 0;
        this.data = change;
        this.type = type;
    }
    
    public void toBytes(final ByteBuf buffer) {
        buffer.writeInt(this.data);
        buffer.writeByte(this.type);
    }
    
    public void fromBytes(final ByteBuf buffer) {
        this.data = buffer.readInt();
        this.type = buffer.readByte();
    }
    
    @SideOnly(Side.CLIENT)
    public IMessage onMessage(final PacketWarpMessage message, final MessageContext ctx) {
        if (message.data != 0) {
            Minecraft.getMinecraft().addScheduledTask(new Runnable() {
                @Override
                public void run() {
                    PacketWarpMessage.this.processMessage(message);
                }
            });
        }
        return null;
    }
    
    @SideOnly(Side.CLIENT)
    void processMessage(final PacketWarpMessage message) {
        if (message.type == 0 && message.data > 0) {
            String text = I18n.translateToLocal("tc.addwarp");
            if (message.data < 0) {
                text = I18n.translateToLocal("tc.removewarp");
            }
            else {
                Minecraft.getMinecraft().player.playSound(SoundsTC.whispers, 0.5f, 1.0f);
            }
        }
        else if (message.type == 1) {
            String text = I18n.translateToLocal("tc.addwarpsticky");
            if (message.data < 0) {
                text = I18n.translateToLocal("tc.removewarpsticky");
            }
            else {
                Minecraft.getMinecraft().player.playSound(SoundsTC.whispers, 0.5f, 1.0f);
            }
            Minecraft.getMinecraft().player.sendStatusMessage(new TextComponentString(text), true);
        }
        else if (message.data > 0) {
            String text = I18n.translateToLocal("tc.addwarptemp");
            if (message.data < 0) {
                text = I18n.translateToLocal("tc.removewarptemp");
            }
            Minecraft.getMinecraft().player.sendStatusMessage(new TextComponentString(text), true);
        }
    }
}