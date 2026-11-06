package com.bytedance.adsdk.lottie.ms.xr;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends ab<Integer> {
    public xr(List<com.bytedance.adsdk.lottie.c.ms<Integer>> list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.adsdk.lottie.ms.xr.ms
    /* JADX INFO: renamed from: xr, reason: merged with bridge method [inline-methods] */
    public Integer ms(com.bytedance.adsdk.lottie.c.ms<Integer> msVar, float f) {
        return Integer.valueOf(ah(msVar, f));
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
    public int ah(com.bytedance.adsdk.lottie.c.ms<Integer> msVar, float f) {
        Integer num;
        if (msVar.f150ms == null || msVar.xr == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        if (this.ah != null && (num = (Integer) this.ah.ms(msVar.c, msVar.ab.floatValue(), msVar.f150ms, msVar.xr, f, d(), x())) != null) {
            return num.intValue();
        }
        return com.bytedance.adsdk.lottie.ka.ah.ms(com.bytedance.adsdk.lottie.ka.x.xr(f, 0.0f, 1.0f), msVar.f150ms.intValue(), msVar.xr.intValue());
    }

    public int ny() {
        return ah(ah(), ka());
    }
}
