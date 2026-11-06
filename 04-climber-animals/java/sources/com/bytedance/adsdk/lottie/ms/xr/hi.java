package com.bytedance.adsdk.lottie.ms.xr;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class hi extends ab<PointF> {
    private final PointF d;

    public hi(List<com.bytedance.adsdk.lottie.c.ms<PointF>> list) {
        super(list);
        this.d = new PointF();
    }

    @Override // com.bytedance.adsdk.lottie.ms.xr.ms
    /* JADX INFO: renamed from: xr, reason: merged with bridge method [inline-methods] */
    public PointF ms(com.bytedance.adsdk.lottie.c.ms<PointF> msVar, float f) {
        return ms(msVar, f, f, f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
    public PointF ms(com.bytedance.adsdk.lottie.c.ms<PointF> msVar, float f, float f2, float f3) {
        PointF pointF;
        if (msVar.f150ms == null || msVar.xr == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF2 = msVar.f150ms;
        PointF pointF3 = msVar.xr;
        if (this.ah != null && (pointF = (PointF) this.ah.ms(msVar.c, msVar.ab.floatValue(), pointF2, pointF3, f, d(), x())) != null) {
            return pointF;
        }
        this.d.set(pointF2.x + (f2 * (pointF3.x - pointF2.x)), pointF2.y + (f3 * (pointF3.y - pointF2.y)));
        return this.d;
    }
}
