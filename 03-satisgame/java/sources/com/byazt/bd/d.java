package com.byazt.bd;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 893, 113})
public class d extends x<com.byazt.yt.q> {
    public final com.byazt.yt.q q;

    public d(List<com.byazt.yt.n<com.byazt.yt.q>> list) {
        super(list);
        this.q = new com.byazt.yt.q();
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
    public com.byazt.yt.q n(com.byazt.yt.n<com.byazt.yt.q> nVar, float f) {
        com.byazt.yt.q qVar;
        if (nVar.n == null || nVar.qg == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.byazt.yt.q qVar2 = nVar.n;
        com.byazt.yt.q qVar3 = nVar.qg;
        if (this.s != null && (qVar = (com.byazt.yt.q) this.s.n(nVar.w, nVar.x.floatValue(), qVar2, qVar3, f, q(), fs())) != null) {
            return qVar;
        }
        this.q.n(com.byazt.nu.rv.n(qVar2.n(), qVar3.n(), f), com.byazt.nu.rv.n(qVar2.qg(), qVar3.qg(), f));
        return this.q;
    }
}
