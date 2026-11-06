package com.bytedance.adsdk.lottie.ms.xr;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ch extends ab<PointF> {
    private ny ab;
    private final PathMeasure c;
    private final PointF d;
    private final float[] ka;

    public ch(List<? extends com.bytedance.adsdk.lottie.c.ms<PointF>> list) {
        super(list);
        this.d = new PointF();
        this.ka = new float[2];
        this.c = new PathMeasure();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.adsdk.lottie.ms.xr.ms
    /* JADX INFO: renamed from: xr, reason: merged with bridge method [inline-methods] */
    public PointF ms(com.bytedance.adsdk.lottie.c.ms<PointF> msVar, float f) {
        PointF pointF;
        ny nyVar = (ny) msVar;
        Path pathXr = nyVar.xr();
        if (pathXr == null) {
            return msVar.f150ms;
        }
        if (this.ah != null && (pointF = (PointF) this.ah.ms(nyVar.c, nyVar.ab.floatValue(), nyVar.f150ms, nyVar.xr, d(), f, x())) != null) {
            return pointF;
        }
        if (this.ab != nyVar) {
            this.c.setPath(pathXr, false);
            this.ab = nyVar;
        }
        PathMeasure pathMeasure = this.c;
        pathMeasure.getPosTan(f * pathMeasure.getLength(), this.ka, null);
        PointF pointF2 = this.d;
        float[] fArr = this.ka;
        pointF2.set(fArr[0], fArr[1]);
        return this.d;
    }
}
