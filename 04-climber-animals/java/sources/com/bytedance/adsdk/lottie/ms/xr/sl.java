package com.bytedance.adsdk.lottie.ms.xr;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class sl extends ab<com.bytedance.adsdk.lottie.c.d> {
    private final com.bytedance.adsdk.lottie.c.d d;

    public sl(List<com.bytedance.adsdk.lottie.c.ms<com.bytedance.adsdk.lottie.c.d>> list) {
        super(list);
        this.d = new com.bytedance.adsdk.lottie.c.d();
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
    @Override // com.bytedance.adsdk.lottie.ms.xr.ms
    /* JADX INFO: renamed from: xr, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.lottie.c.d ms(com.bytedance.adsdk.lottie.c.ms<com.bytedance.adsdk.lottie.c.d> msVar, float f) {
        com.bytedance.adsdk.lottie.c.d dVar;
        if (msVar.f150ms == null || msVar.xr == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.bytedance.adsdk.lottie.c.d dVar2 = msVar.f150ms;
        com.bytedance.adsdk.lottie.c.d dVar3 = msVar.xr;
        if (this.ah != null && (dVar = (com.bytedance.adsdk.lottie.c.d) this.ah.ms(msVar.c, msVar.ab.floatValue(), dVar2, dVar3, f, d(), x())) != null) {
            return dVar;
        }
        this.d.ms(com.bytedance.adsdk.lottie.ka.x.ms(dVar2.ms(), dVar3.ms(), f), com.bytedance.adsdk.lottie.ka.x.ms(dVar2.xr(), dVar3.xr(), f));
        return this.d;
    }
}
