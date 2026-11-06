package com.bytedance.adsdk.lottie.ms.xr;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class d extends ab<Float> {
    public d(List<com.bytedance.adsdk.lottie.c.ms<Float>> list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.adsdk.lottie.ms.xr.ms
    /* JADX INFO: renamed from: xr, reason: merged with bridge method [inline-methods] */
    public Float ms(com.bytedance.adsdk.lottie.c.ms<Float> msVar, float f) {
        return Float.valueOf(ah(msVar, f));
    }

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
    float ah(com.bytedance.adsdk.lottie.c.ms<Float> msVar, float f) {
        Float f2;
        if (msVar.f150ms == null || msVar.xr == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        if (this.ah != null && (f2 = (Float) this.ah.ms(msVar.c, msVar.ab.floatValue(), msVar.f150ms, msVar.xr, f, d(), x())) != null) {
            return f2.floatValue();
        }
        return com.bytedance.adsdk.lottie.ka.x.ms(msVar.c(), msVar.ab(), f);
    }

    public float ny() {
        return ah(ah(), ka());
    }
}
