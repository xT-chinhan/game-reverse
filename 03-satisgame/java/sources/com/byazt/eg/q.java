package com.byazt.eg;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.LongSparseArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 959, 5})
public class q extends s {
    public final Paint cp;
    public boolean d;
    public final List<s> fs;
    public final RectF rv;
    public final RectF tj;
    public com.byazt.bd.n<Float, Float> x;

    public q(com.byazt.pp.fs fsVar, fs fsVar2, List<fs> list, com.byazt.pp.w wVar, Context context) {
        int i;
        s sVar;
        fs.qg qgVarD;
        int i2;
        super(fsVar, fsVar2);
        this.fs = new ArrayList();
        this.rv = new RectF();
        this.tj = new RectF();
        this.cp = new Paint();
        this.d = true;
        com.byazt.ccr.qg qgVarPy = fsVar2.py();
        if (qgVarPy != null) {
            com.byazt.bd.n<Float, Float> nVarN = qgVarPy.n();
            this.x = nVarN;
            n(nVarN);
            this.x.n(this);
        } else {
            this.x = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(wVar.sz().size());
        int size = list.size() - 1;
        s sVar2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            fs fsVar3 = list.get(size);
            s sVarN = s.n(this, fsVar3, fsVar, wVar, context);
            if (sVarN != null) {
                longSparseArray.put(sVarN.q().l(), sVarN);
                if (sVar2 != null) {
                    sVar2.n(sVarN);
                    sVar2 = null;
                } else {
                    this.fs.add(0, sVarN);
                    if (fsVar3 != null && (qgVarD = fsVar3.d()) != null && ((i2 = AnonymousClass1.n[qgVarD.ordinal()]) == 1 || i2 == 2)) {
                        sVar2 = sVarN;
                    }
                }
            }
            size--;
        }
        for (i = 0; i < longSparseArray.size(); i++) {
            s sVar3 = (s) longSparseArray.get(longSparseArray.keyAt(i));
            if (sVar3 != null && (sVar = (s) longSparseArray.get(sVar3.q().oa())) != null) {
                sVar3.qg(sVar);
            }
        }
    }

    /* JADX INFO: renamed from: com.byazt.eg.q$1, reason: invalid class name */
    @com.byazt.cp.n(n = {0, 1, 959, 37})
    static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] n;

        static {
            int[] iArr = new int[fs.qg.values().length];
            n = iArr;
            try {
                iArr[fs.qg.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                n[fs.qg.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public void qg(boolean z) {
        this.d = z;
    }

    @Override // com.byazt.eg.s
    public void n(boolean z) {
        super.n(z);
        Iterator<s> it = this.fs.iterator();
        while (it.hasNext()) {
            it.next().n(z);
        }
    }

    @Override // com.byazt.eg.s
    public void qg(Canvas canvas, Matrix matrix, int i) {
        super.qg(canvas, matrix, i);
        com.byazt.pp.l.n("CompositionLayer#draw");
        this.tj.set(0.0f, 0.0f, this.s.fs(), this.s.rv());
        matrix.mapRect(this.tj);
        boolean z = this.qg.tj() && this.fs.size() > 1 && i != 255;
        if (z) {
            this.cp.setAlpha(i);
            com.byazt.nu.tj.n(canvas, this.tj, this.cp);
        } else {
            canvas.save();
        }
        if (z) {
            i = 255;
        }
        for (int size = this.fs.size() - 1; size >= 0; size--) {
            if (((!this.d && "__container".equals(this.s.w())) || this.tj.isEmpty()) ? true : canvas.clipRect(this.tj)) {
                this.fs.get(size).n(canvas, matrix, i);
            }
        }
        canvas.restore();
        com.byazt.pp.l.qg("CompositionLayer#draw");
    }

    @Override // com.byazt.eg.s, com.byazt.sp.l
    public void n(RectF rectF, Matrix matrix, boolean z) {
        super.n(rectF, matrix, z);
        for (int size = this.fs.size() - 1; size >= 0; size--) {
            this.rv.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.fs.get(size).n(this.rv, this.n, true);
            rectF.union(this.rv);
        }
    }

    public List<s> sz() {
        return this.fs;
    }

    @Override // com.byazt.eg.s
    public void n(float f) {
        super.n(f);
        if (this.x != null) {
            f = ((this.x.x().floatValue() * this.s.n().oa()) - this.s.n().w()) / (this.qg.t().cd() + 0.01f);
        }
        if (this.x == null) {
            f -= this.s.s();
        }
        if (this.s.qg() != 0.0f && !"__container".equals(this.s.w())) {
            f /= this.s.qg();
        }
        for (int size = this.fs.size() - 1; size >= 0; size--) {
            this.fs.get(size).n(f);
        }
    }
}
