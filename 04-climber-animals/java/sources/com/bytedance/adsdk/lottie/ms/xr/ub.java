package com.bytedance.adsdk.lottie.ms.xr;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ub extends ab<com.bytedance.adsdk.lottie.model.xr> {
    public ub(List<com.bytedance.adsdk.lottie.c.ms<com.bytedance.adsdk.lottie.model.xr>> list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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
    public com.bytedance.adsdk.lottie.model.xr ms(com.bytedance.adsdk.lottie.c.ms<com.bytedance.adsdk.lottie.model.xr> msVar, float f) {
        if (this.ah != null) {
            return (com.bytedance.adsdk.lottie.model.xr) this.ah.ms(msVar.c, msVar.ab == null ? Float.MAX_VALUE : msVar.ab.floatValue(), msVar.f150ms, msVar.xr == null ? msVar.f150ms : msVar.xr, f, ka(), x());
        }
        if (f != 1.0f || msVar.xr == null) {
            return msVar.f150ms;
        }
        return msVar.xr;
    }
}
