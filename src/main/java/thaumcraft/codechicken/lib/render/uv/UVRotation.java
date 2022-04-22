// 
// Decompiled by Procyon v0.6.0
// 

package thaumcraft.codechicken.lib.render.uv;

import thaumcraft.codechicken.lib.vec.ITransformation;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import thaumcraft.codechicken.lib.math.MathHelper;

public class UVRotation extends UVTransformation
{
    public double angle;
    
    public UVRotation(double angle) {
        this.angle = angle;
    }
    
    @Override
    public void apply(UV uv) {
        double c = MathHelper.cos(angle);
        double s = MathHelper.sin(angle);
        double u2 = c * uv.u + s * uv.v;
        uv.v = -s * uv.u + c * uv.v;
        uv.u = u2;
    }
    
    @Override
    public UVTransformation inverse() {
        return new UVRotation(-angle);
    }
    
    @Override
    public UVTransformation merge(UVTransformation next) {
        if (next instanceof UVRotation) {
            return new UVRotation(angle + ((UVRotation)next).angle);
        }
        return null;
    }
    
    @Override
    public boolean isRedundant() {
        return MathHelper.between(-1.0E-5, angle, 1.0E-5);
    }
    
    @Override
    public String toString() {
        MathContext cont = new MathContext(4, RoundingMode.HALF_UP);
        return "UVRotation(" + new BigDecimal(angle, cont) + ")";
    }
}
