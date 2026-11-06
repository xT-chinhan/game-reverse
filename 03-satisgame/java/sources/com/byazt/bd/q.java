package com.byazt.bd;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 893, 5})
public class q extends x<Float> {
    public q(List<com.byazt.yt.n<Float>> list) {
        super(list);
    }

    @Override // com.byazt.bd.n
    /* JADX INFO: renamed from: qg, reason: merged with bridge method [inline-methods] */
    public Float n(com.byazt.yt.n<Float> nVar, float f) {
        return Float.valueOf(s(nVar, f));
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
    public float s(com.byazt.yt.n<Float> nVar, float f) {
        Float f2;
        if (nVar.n == null || nVar.qg == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        if (this.s != null && (f2 = (Float) this.s.n(nVar.w, nVar.x.floatValue(), nVar.n, nVar.qg, f, q(), fs())) != null) {
            return f2.floatValue();
        }
        return com.byazt.nu.rv.n(nVar.w(), nVar.x(), f);
    }

    public float rv() {
        return s(s(), l());
    }
}
