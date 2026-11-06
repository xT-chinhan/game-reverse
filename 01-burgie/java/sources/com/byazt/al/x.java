package com.byazt.al;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 60, 121})
public class x extends fw<Float> {
    public x(List<com.byazt.cz.pr<Float>> list) {
        super(list);
    }

    @Override // com.byazt.al.pr
    /* JADX INFO: renamed from: hw, reason: merged with bridge method [inline-methods] */
    public Float pr(com.byazt.cz.pr<Float> prVar, float f) {
        return Float.valueOf(hn(prVar, f));
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
    public float hn(com.byazt.cz.pr<Float> prVar, float f) {
        Float f2;
        if (prVar.pr == null || prVar.hw == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        if (this.hn != null && (f2 = (Float) this.hn.pr(prVar.uc, prVar.fw.floatValue(), prVar.pr, prVar.hw, f, x(), zo())) != null) {
            return f2.floatValue();
        }
        return com.byazt.ptr.aj.pr(prVar.uc(), prVar.fw(), f);
    }

    public float aj() {
        return hn(hn(), c());
    }
}
