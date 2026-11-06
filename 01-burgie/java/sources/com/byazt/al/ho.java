package com.byazt.al;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 60, 19})
public class ho extends fw<com.byazt.uxi.hw> {
    public ho(List<com.byazt.cz.pr<com.byazt.uxi.hw>> list) {
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
    @Override // com.byazt.al.pr
    /* JADX INFO: renamed from: hw, reason: merged with bridge method [inline-methods] */
    public com.byazt.uxi.hw pr(com.byazt.cz.pr<com.byazt.uxi.hw> prVar, float f) {
        if (this.hn != null) {
            return (com.byazt.uxi.hw) this.hn.pr(prVar.uc, prVar.fw == null ? Float.MAX_VALUE : prVar.fw.floatValue(), prVar.pr, prVar.hw == null ? prVar.pr : prVar.hw, f, c(), zo());
        }
        if (f != 1.0f || prVar.hw == null) {
            return prVar.pr;
        }
        return prVar.hw;
    }
}
