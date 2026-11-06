package com.byazt.al;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 60, 50})
public class vk extends fw<PointF> {
    public final float[] c;
    public aj fw;
    public final PathMeasure uc;
    public final PointF x;

    public vk(List<? extends com.byazt.cz.pr<PointF>> list) {
        super(list);
        this.x = new PointF();
        this.c = new float[2];
        this.uc = new PathMeasure();
    }

    /* JADX WARN: Multi-variable type inference failed */
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
    public PointF pr(com.byazt.cz.pr<PointF> prVar, float f) {
        PointF pointF;
        aj ajVar = (aj) prVar;
        Path pathHw = ajVar.hw();
        if (pathHw == null) {
            return prVar.pr;
        }
        if (this.hn != null && (pointF = (PointF) this.hn.pr(ajVar.uc, ajVar.fw.floatValue(), ajVar.pr, ajVar.hw, x(), f, zo())) != null) {
            return pointF;
        }
        if (this.fw != ajVar) {
            this.uc.setPath(pathHw, false);
            this.fw = ajVar;
        }
        PathMeasure pathMeasure = this.uc;
        pathMeasure.getPosTan(f * pathMeasure.getLength(), this.c, null);
        PointF pointF2 = this.x;
        float[] fArr = this.c;
        pointF2.set(fArr[0], fArr[1]);
        return this.x;
    }
}
