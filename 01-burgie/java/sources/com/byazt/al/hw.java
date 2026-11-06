package com.byazt.al;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 60, 13})
public class hw extends fw<Integer> {
    public hw(List<com.byazt.cz.pr<Integer>> list) {
        super(list);
    }

    @Override // com.byazt.al.pr
    /* JADX INFO: renamed from: hw, reason: merged with bridge method [inline-methods] */
    public Integer pr(com.byazt.cz.pr<Integer> prVar, float f) {
        return Integer.valueOf(hn(prVar, f));
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
    public int hn(com.byazt.cz.pr<Integer> prVar, float f) {
        Integer num;
        if (prVar.pr == null || prVar.hw == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        if (this.hn != null && (num = (Integer) this.hn.pr(prVar.uc, prVar.fw.floatValue(), prVar.pr, prVar.hw, f, x(), zo())) != null) {
            return num.intValue();
        }
        return com.byazt.ptr.x.pr(com.byazt.ptr.aj.hw(f, 0.0f, 1.0f), prVar.pr.intValue(), prVar.hw.intValue());
    }

    public int aj() {
        return hn(hn(), c());
    }
}
