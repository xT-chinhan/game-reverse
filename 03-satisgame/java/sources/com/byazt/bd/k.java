package com.byazt.bd;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 893, 210})
public class k extends x<com.byazt.ld.qg> {
    public k(List<com.byazt.yt.n<com.byazt.ld.qg>> list) {
        super(list);
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
    @Override // com.byazt.bd.n
    /* JADX INFO: renamed from: qg, reason: merged with bridge method [inline-methods] */
    public com.byazt.ld.qg n(com.byazt.yt.n<com.byazt.ld.qg> nVar, float f) {
        if (this.s != null) {
            return (com.byazt.ld.qg) this.s.n(nVar.w, nVar.x == null ? Float.MAX_VALUE : nVar.x.floatValue(), nVar.n, nVar.qg == null ? nVar.n : nVar.qg, f, l(), fs());
        }
        if (f != 1.0f || nVar.qg == null) {
            return nVar.n;
        }
        return nVar.qg;
    }
}
