package com.byazt.bd;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 893, 29})
public class cp extends x<PointF> {
    public final PointF q;

    public cp(List<com.byazt.yt.n<PointF>> list) {
        super(list);
        this.q = new PointF();
    }

    @Override // com.byazt.bd.n
    /* JADX INFO: renamed from: qg, reason: merged with bridge method [inline-methods] */
    public PointF n(com.byazt.yt.n<PointF> nVar, float f) {
        return n(nVar, f, f, f);
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
    public PointF n(com.byazt.yt.n<PointF> nVar, float f, float f2, float f3) {
        PointF pointF;
        if (nVar.n == null || nVar.qg == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF2 = nVar.n;
        PointF pointF3 = nVar.qg;
        if (this.s != null && (pointF = (PointF) this.s.n(nVar.w, nVar.x.floatValue(), pointF2, pointF3, f, q(), fs())) != null) {
            return pointF;
        }
        this.q.set(pointF2.x + (f2 * (pointF3.x - pointF2.x)), pointF2.y + (f3 * (pointF3.y - pointF2.y)));
        return this.q;
    }
}
