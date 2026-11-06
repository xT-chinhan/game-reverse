package com.byazt.bd;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 893, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj extends x<PointF> {
    public final float[] l;
    public final PointF q;
    public final PathMeasure w;
    public rv x;

    public tj(List<? extends com.byazt.yt.n<PointF>> list) {
        super(list);
        this.q = new PointF();
        this.l = new float[2];
        this.w = new PathMeasure();
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
    @Override // com.byazt.bd.n
    /* JADX INFO: renamed from: qg, reason: merged with bridge method [inline-methods] */
    public PointF n(com.byazt.yt.n<PointF> nVar, float f) {
        PointF pointF;
        rv rvVar = (rv) nVar;
        Path pathQg = rvVar.qg();
        if (pathQg == null) {
            return nVar.n;
        }
        if (this.s != null && (pointF = (PointF) this.s.n(rvVar.w, rvVar.x.floatValue(), rvVar.n, rvVar.qg, q(), f, fs())) != null) {
            return pointF;
        }
        if (this.x != rvVar) {
            this.w.setPath(pathQg, false);
            this.x = rvVar;
        }
        PathMeasure pathMeasure = this.w;
        pathMeasure.getPosTan(f * pathMeasure.getLength(), this.l, null);
        PointF pointF2 = this.q;
        float[] fArr = this.l;
        pointF2.set(fArr[0], fArr[1]);
        return this.q;
    }
}
