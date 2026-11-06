package com.byazt.al;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 60, 109})
public class w extends fw<PointF> {
    public final PointF x;

    public w(List<com.byazt.cz.pr<PointF>> list) {
        super(list);
        this.x = new PointF();
    }

    @Override // com.byazt.al.pr
    /* JADX INFO: renamed from: hw, reason: merged with bridge method [inline-methods] */
    public PointF pr(com.byazt.cz.pr<PointF> prVar, float f) {
        return pr(prVar, f, f, f);
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
    public PointF pr(com.byazt.cz.pr<PointF> prVar, float f, float f2, float f3) {
        PointF pointF;
        if (prVar.pr == null || prVar.hw == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF2 = prVar.pr;
        PointF pointF3 = prVar.hw;
        if (this.hn != null && (pointF = (PointF) this.hn.pr(prVar.uc, prVar.fw.floatValue(), pointF2, pointF3, f, x(), zo())) != null) {
            return pointF;
        }
        this.x.set(pointF2.x + (f2 * (pointF3.x - pointF2.x)), pointF2.y + (f3 * (pointF3.y - pointF2.y)));
        return this.x;
    }
}
