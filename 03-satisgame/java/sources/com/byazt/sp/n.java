package com.byazt.sp;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1179, 19})
public abstract class n implements cp, l, com.byazt.bd.n.InterfaceC0134n {
    public final com.byazt.bd.n<?, Float> cp;
    public com.byazt.bd.n<Float, Float> cy;
    public final com.byazt.bd.n<?, Integer> d;
    public final com.byazt.pp.fs fs;
    public com.byazt.bd.s hd;
    public com.byazt.bd.n<ColorFilter, ColorFilter> k;
    public final com.byazt.eg.s n;
    public final List<com.byazt.bd.n<?, Float>> oa;
    public final Paint qg;
    public float s;
    public final com.byazt.bd.n<?, Float> sz;
    public final float[] tj;
    public final PathMeasure q = new PathMeasure();
    public final Path l = new Path();
    public final Path w = new Path();
    public final RectF x = new RectF();
    public final List<C0335n> rv = new ArrayList();

    public n(com.byazt.pp.fs fsVar, com.byazt.eg.s sVar, Paint.Cap cap, Paint.Join join, float f, com.byazt.ccr.q qVar, com.byazt.ccr.qg qgVar, List<com.byazt.ccr.qg> list, com.byazt.ccr.qg qgVar2) {
        com.byazt.ft.n nVar = new com.byazt.ft.n(1);
        this.qg = nVar;
        this.s = 0.0f;
        this.fs = fsVar;
        this.n = sVar;
        nVar.setStyle(Paint.Style.STROKE);
        nVar.setStrokeCap(cap);
        nVar.setStrokeJoin(join);
        nVar.setStrokeMiter(f);
        this.d = qVar.n();
        this.cp = qgVar.n();
        if (qgVar2 == null) {
            this.sz = null;
        } else {
            this.sz = qgVar2.n();
        }
        this.oa = new ArrayList(list.size());
        this.tj = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.oa.add(list.get(i).n());
        }
        sVar.n(this.d);
        sVar.n(this.cp);
        for (int i2 = 0; i2 < this.oa.size(); i2++) {
            sVar.n(this.oa.get(i2));
        }
        com.byazt.bd.n<?, Float> nVar2 = this.sz;
        if (nVar2 != null) {
            sVar.n(nVar2);
        }
        this.d.n(this);
        this.cp.n(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.oa.get(i3).n(this);
        }
        com.byazt.bd.n<?, Float> nVar3 = this.sz;
        if (nVar3 != null) {
            nVar3.n(this);
        }
        if (sVar.d() != null) {
            com.byazt.bd.n<Float, Float> nVarN = sVar.d().n().n();
            this.cy = nVarN;
            nVarN.n(this);
            sVar.n(this.cy);
        }
        if (sVar.oa() != null) {
            this.hd = new com.byazt.bd.s(this, sVar, sVar.oa());
        }
    }

    @Override // com.byazt.bd.n.InterfaceC0134n
    public void n() {
        this.fs.invalidateSelf();
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0055  */
    /* JADX WARN: Code duplicated, block: B:23:0x0059 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x005b  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069 A[SYNTHETIC] */
    @Override // com.byazt.sp.s
    public void n(List<s> list, List<s> list2) {
        py pyVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            s sVar = list.get(size);
            if (sVar instanceof py) {
                py pyVar2 = (py) sVar;
                if (pyVar2.getType() == com.byazt.aw.um.n.INDIVIDUALLY) {
                    pyVar = pyVar2;
                }
            }
        }
        if (pyVar != null) {
            pyVar.n(this);
        }
        C0335n c0335n = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            s sVar2 = list2.get(size2);
            if (sVar2 instanceof py) {
                py pyVar3 = (py) sVar2;
                if (pyVar3.getType() == com.byazt.aw.um.n.INDIVIDUALLY) {
                    if (c0335n != null) {
                        this.rv.add(c0335n);
                    }
                    c0335n = new C0335n(pyVar3);
                    pyVar3.n(this);
                } else if (!(sVar2 instanceof oa)) {
                    if (c0335n == null) {
                        c0335n = new C0335n(pyVar);
                    }
                    c0335n.n.add((oa) sVar2);
                }
            } else if (!(sVar2 instanceof oa)) {
                if (c0335n == null) {
                    c0335n = new C0335n(pyVar);
                }
                c0335n.n.add((oa) sVar2);
            }
        }
        if (c0335n != null) {
            this.rv.add(c0335n);
        }
    }

    public void n(Canvas canvas, Matrix matrix, int i) {
        com.byazt.pp.l.n("StrokeContent#draw");
        if (com.byazt.nu.tj.qg(matrix)) {
            com.byazt.pp.l.qg("StrokeContent#draw");
            return;
        }
        this.qg.setAlpha(com.byazt.nu.rv.n((int) ((((i / 255.0f) * ((com.byazt.bd.w) this.d).rv()) / 100.0f) * 255.0f), 0, 255));
        this.qg.setStrokeWidth(((com.byazt.bd.q) this.cp).rv() * com.byazt.nu.tj.n(matrix));
        if (this.qg.getStrokeWidth() <= 0.0f) {
            com.byazt.pp.l.qg("StrokeContent#draw");
            return;
        }
        n(matrix);
        com.byazt.bd.n<ColorFilter, ColorFilter> nVar = this.k;
        if (nVar != null) {
            this.qg.setColorFilter(nVar.x());
        }
        com.byazt.bd.n<Float, Float> nVar2 = this.cy;
        if (nVar2 != null) {
            float fFloatValue = nVar2.x().floatValue();
            if (fFloatValue == 0.0f) {
                this.qg.setMaskFilter(null);
            } else if (fFloatValue != this.s) {
                this.qg.setMaskFilter(this.n.qg(fFloatValue));
            }
            this.s = fFloatValue;
        }
        com.byazt.bd.s sVar = this.hd;
        if (sVar != null) {
            sVar.n(this.qg);
        }
        for (int i2 = 0; i2 < this.rv.size(); i2++) {
            C0335n c0335n = this.rv.get(i2);
            if (c0335n.qg != null) {
                n(canvas, c0335n, matrix);
            } else {
                com.byazt.pp.l.n("StrokeContent#buildPath");
                this.l.reset();
                for (int size = c0335n.n.size() - 1; size >= 0; size--) {
                    this.l.addPath(((oa) c0335n.n.get(size)).q(), matrix);
                }
                com.byazt.pp.l.qg("StrokeContent#buildPath");
                com.byazt.pp.l.n("StrokeContent#drawPath");
                canvas.drawPath(this.l, this.qg);
                com.byazt.pp.l.qg("StrokeContent#drawPath");
            }
        }
        com.byazt.pp.l.qg("StrokeContent#draw");
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0110  */
    private void n(Canvas canvas, C0335n c0335n, Matrix matrix) {
        float f;
        float f2;
        float fMin;
        com.byazt.pp.l.n("StrokeContent#applyTrimPath");
        if (c0335n.qg == null) {
            com.byazt.pp.l.qg("StrokeContent#applyTrimPath");
            return;
        }
        this.l.reset();
        for (int size = c0335n.n.size() - 1; size >= 0; size--) {
            this.l.addPath(((oa) c0335n.n.get(size)).q(), matrix);
        }
        float fFloatValue = c0335n.qg.qg().x().floatValue() / 100.0f;
        float fFloatValue2 = c0335n.qg.s().x().floatValue() / 100.0f;
        float fFloatValue3 = c0335n.qg.q().x().floatValue() / 360.0f;
        if (fFloatValue < 0.01f && fFloatValue2 > 0.99f) {
            canvas.drawPath(this.l, this.qg);
            com.byazt.pp.l.qg("StrokeContent#applyTrimPath");
            return;
        }
        this.q.setPath(this.l, false);
        float length = this.q.getLength();
        while (this.q.nextContour()) {
            length += this.q.getLength();
        }
        float f3 = fFloatValue3 * length;
        float f4 = (fFloatValue * length) + f3;
        float fMin2 = Math.min((fFloatValue2 * length) + f3, (f4 + length) - 1.0f);
        float f5 = 0.0f;
        for (int size2 = c0335n.n.size() - 1; size2 >= 0; size2--) {
            this.w.set(((oa) c0335n.n.get(size2)).q());
            this.w.transform(matrix);
            this.q.setPath(this.w, false);
            float length2 = this.q.getLength();
            if (fMin2 > length) {
                float f6 = fMin2 - length;
                if (f6 >= f5 + length2 || f5 >= f6) {
                    f = f5 + length2;
                    if (f < f4 && f5 <= fMin2) {
                        if (f > fMin2 || f4 >= f5) {
                            f2 = f4 < f5 ? 0.0f : (f4 - f5) / length2;
                            fMin = fMin2 > f ? 1.0f : (fMin2 - f5) / length2;
                        } else {
                            canvas.drawPath(this.w, this.qg);
                        }
                    }
                } else {
                    f2 = f4 > length ? (f4 - length) / length2 : 0.0f;
                    fMin = Math.min(f6 / length2, 1.0f);
                }
                com.byazt.nu.tj.n(this.w, f2, fMin, 0.0f);
                canvas.drawPath(this.w, this.qg);
            } else {
                f = f5 + length2;
                if (f < f4) {
                }
            }
            f5 += length2;
        }
        com.byazt.pp.l.qg("StrokeContent#applyTrimPath");
    }

    @Override // com.byazt.sp.l
    public void n(RectF rectF, Matrix matrix, boolean z) {
        com.byazt.pp.l.n("StrokeContent#getBounds");
        this.l.reset();
        for (int i = 0; i < this.rv.size(); i++) {
            C0335n c0335n = this.rv.get(i);
            for (int i2 = 0; i2 < c0335n.n.size(); i2++) {
                this.l.addPath(((oa) c0335n.n.get(i2)).q(), matrix);
            }
        }
        this.l.computeBounds(this.x, false);
        float fRv = ((com.byazt.bd.q) this.cp).rv();
        RectF rectF2 = this.x;
        float f = fRv / 2.0f;
        rectF2.set(rectF2.left - f, this.x.top - f, this.x.right + f, this.x.bottom + f);
        rectF.set(this.x);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.byazt.pp.l.qg("StrokeContent#getBounds");
    }

    private void n(Matrix matrix) {
        com.byazt.pp.l.n("StrokeContent#applyDashPattern");
        if (this.oa.isEmpty()) {
            com.byazt.pp.l.qg("StrokeContent#applyDashPattern");
            return;
        }
        float fN = com.byazt.nu.tj.n(matrix);
        for (int i = 0; i < this.oa.size(); i++) {
            this.tj[i] = this.oa.get(i).x().floatValue();
            if (i % 2 == 0) {
                float[] fArr = this.tj;
                if (fArr[i] < 1.0f) {
                    fArr[i] = 1.0f;
                }
            } else {
                float[] fArr2 = this.tj;
                if (fArr2[i] < 0.1f) {
                    fArr2[i] = 0.1f;
                }
            }
            float[] fArr3 = this.tj;
            fArr3[i] = fArr3[i] * fN;
        }
        com.byazt.bd.n<?, Float> nVar = this.sz;
        this.qg.setPathEffect(new DashPathEffect(this.tj, nVar == null ? 0.0f : fN * nVar.x().floatValue()));
        com.byazt.pp.l.qg("StrokeContent#applyDashPattern");
    }

    /* JADX INFO: renamed from: com.byazt.sp.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 1179, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    private static final class C0335n {
        public final List<oa> n;
        public final py qg;

        private C0335n(py pyVar) {
            this.n = new ArrayList();
            this.qg = pyVar;
        }
    }
}
