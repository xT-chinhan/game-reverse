package com.byazt.al;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 60, 250})
public class k extends fw<com.byazt.cz.x> {
    public final com.byazt.cz.x x;

    public k(List<com.byazt.cz.pr<com.byazt.cz.x>> list) {
        super(list);
        this.x = new com.byazt.cz.x();
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
    @Override // com.byazt.al.pr
    /* JADX INFO: renamed from: hw, reason: merged with bridge method [inline-methods] */
    public com.byazt.cz.x pr(com.byazt.cz.pr<com.byazt.cz.x> prVar, float f) {
        com.byazt.cz.x xVar;
        if (prVar.pr == null || prVar.hw == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.byazt.cz.x xVar2 = prVar.pr;
        com.byazt.cz.x xVar3 = prVar.hw;
        if (this.hn != null && (xVar = (com.byazt.cz.x) this.hn.pr(prVar.uc, prVar.fw.floatValue(), xVar2, xVar3, f, x(), zo())) != null) {
            return xVar;
        }
        this.x.pr(com.byazt.ptr.aj.pr(xVar2.pr(), xVar3.pr(), f), com.byazt.ptr.aj.pr(xVar2.hw(), xVar3.hw(), f));
        return this.x;
    }
}
