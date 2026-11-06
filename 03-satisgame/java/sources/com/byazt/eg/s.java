package com.byazt.eg;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.core.view.ViewCompat;
import com.byazt.bd.cy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 959, 8})
public abstract class s implements com.byazt.sp.l, com.byazt.bd.n.InterfaceC0134n {
    public final RectF a;
    public boolean bb;
    public final RectF cd;
    public final Paint cy;
    public boolean fs;
    public s h;
    public final RectF hd;
    public s hu;
    public float j;
    public final Paint k;
    public float l;
    public Paint lh;
    public boolean ln;
    public com.byazt.bd.q m;
    public final Matrix n;
    public final String ou;
    public final RectF py;
    public final cy q;
    public final com.byazt.pp.fs qg;
    public final fs s;
    public List<s> t;
    public final RectF um;
    public final List<com.byazt.bd.n<?, ?>> ur;
    public final Matrix v;
    public BlurMaskFilter w;
    public com.byazt.bd.fs wm;
    public final Handler x = new Handler(Looper.getMainLooper());
    public final Path rv = new Path();
    public final Matrix tj = new Matrix();
    public final Matrix cp = new Matrix();
    public final Paint d = new com.byazt.ft.n(1);
    public final Paint oa = new com.byazt.ft.n(1, PorterDuff.Mode.DST_IN);
    public final Paint sz = new com.byazt.ft.n(1, PorterDuff.Mode.DST_OUT);

    @Override // com.byazt.sp.s
    public void n(List<com.byazt.sp.s> list, List<com.byazt.sp.s> list2) {
    }

    public boolean qg() {
        return this.fs;
    }

    public void s() {
        this.fs = true;
    }

    public void n(Runnable runnable) {
        this.x.post(runnable);
    }

    public static s n(q qVar, fs fsVar, com.byazt.pp.fs fsVar2, com.byazt.pp.w wVar, Context context) {
        switch (AnonymousClass2.n[fsVar.cp().ordinal()]) {
            case 1:
                return new tj(fsVar2, fsVar, qVar, wVar);
            case 2:
                return new q(fsVar2, fsVar, wVar.qg(fsVar.x()), wVar, context);
            case 3:
                return new cp(fsVar2, fsVar);
            case 4:
                if (n(fsVar2, fsVar, "text:")) {
                    return new w(fsVar2, fsVar, context);
                }
                if (n(fsVar2, fsVar, "videoview:")) {
                    com.byazt.pp.rv.n nVarN = n(fsVar2, fsVar);
                    if (nVarN != null) {
                        if (nVarN.n != null && nVarN.n.n > 0.0f) {
                            return new l(fsVar2, fsVar, context, nVarN.n);
                        }
                        if (nVarN.qg) {
                            return new qg(fsVar2, fsVar, context);
                        }
                        return new sz(fsVar2, fsVar, context);
                    }
                    return new sz(fsVar2, fsVar, context);
                }
                if (n(fsVar2, fsVar, "animview:")) {
                    return new n(fsVar2, fsVar, context);
                }
                if (n(fsVar2, fsVar, "view:")) {
                    return new oa(fsVar2, fsVar, context);
                }
                x xVar = new x(fsVar2, fsVar);
                xVar.sz();
                return xVar;
            case 5:
                return new rv(fsVar2, fsVar);
            case 6:
                return new d(fsVar2, fsVar);
            default:
                com.byazt.nu.w.qg("Unknown layer type " + fsVar.cp());
                return null;
        }
    }

    private static com.byazt.pp.rv.n n(com.byazt.pp.fs fsVar, fs fsVar2) {
        com.byazt.pp.rv rvVarW;
        if (fsVar == null || fsVar2 == null || (rvVarW = fsVar.w(fsVar2.x())) == null) {
            return null;
        }
        return rvVarW.tj();
    }

    private static boolean n(com.byazt.pp.fs fsVar, fs fsVar2, String str) {
        com.byazt.pp.rv rvVarW;
        if (fsVar == null || fsVar2 == null || str == null || (rvVarW = fsVar.w(fsVar2.x())) == null) {
            return false;
        }
        return str.equals(rvVarW.sz());
    }

    public s(com.byazt.pp.fs fsVar, fs fsVar2) {
        com.byazt.ft.n nVar = new com.byazt.ft.n(1);
        this.k = nVar;
        this.cy = new com.byazt.ft.n(PorterDuff.Mode.CLEAR);
        this.hd = new RectF();
        this.cd = new RectF();
        this.um = new RectF();
        this.a = new RectF();
        this.py = new RectF();
        this.n = new Matrix();
        this.ur = new ArrayList();
        this.bb = true;
        this.l = 0.0f;
        this.v = new Matrix();
        this.j = 1.0f;
        this.qg = fsVar;
        this.s = fsVar2;
        this.ou = fsVar2.w() + "#draw";
        if (fsVar2.d() == fs.qg.INVERT) {
            nVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            nVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        cy cyVarTj = fsVar2.k().tj();
        this.q = cyVarTj;
        cyVarTj.n((com.byazt.bd.n.InterfaceC0134n) this);
        if (fsVar2.tj() != null && !fsVar2.tj().isEmpty()) {
            com.byazt.bd.fs fsVar3 = new com.byazt.bd.fs(fsVar2.tj());
            this.wm = fsVar3;
            Iterator<com.byazt.bd.n<com.byazt.aw.sz, Path>> it = fsVar3.qg().iterator();
            while (it.hasNext()) {
                it.next().n(this);
            }
            for (com.byazt.bd.n<Integer, Integer> nVar2 : this.wm.s()) {
                n(nVar2);
                nVar2.n(this);
            }
        }
        sz();
    }

    public void n(boolean z) {
        if (z && this.lh == null) {
            this.lh = new com.byazt.ft.n();
        }
        this.ln = z;
    }

    @Override // com.byazt.bd.n.InterfaceC0134n
    public void n() {
        k();
    }

    public fs q() {
        return this.s;
    }

    public void n(s sVar) {
        this.hu = sVar;
    }

    public boolean l() {
        return this.hu != null;
    }

    public void qg(s sVar) {
        this.h = sVar;
    }

    private void sz() {
        if (!this.s.q().isEmpty()) {
            com.byazt.bd.q qVar = new com.byazt.bd.q(this.s.q());
            this.m = qVar;
            qVar.n();
            this.m.n(new com.byazt.bd.n.InterfaceC0134n() { // from class: com.byazt.eg.s.1
                @Override // com.byazt.bd.n.InterfaceC0134n
                public void n() {
                    s sVar = s.this;
                    sVar.qg(sVar.m.rv() == 1.0f);
                }
            });
            qg(this.m.x().floatValue() == 1.0f);
            n(this.m);
            return;
        }
        qg(true);
    }

    private void k() {
        this.qg.invalidateSelf();
    }

    public void n(com.byazt.bd.n<?, ?> nVar) {
        if (nVar == null) {
            return;
        }
        this.ur.add(nVar);
    }

    public Matrix w() {
        return this.v;
    }

    public String x() {
        fs fsVar = this.s;
        if (fsVar != null) {
            return fsVar.x();
        }
        return null;
    }

    @Override // com.byazt.sp.l
    public void n(RectF rectF, Matrix matrix, boolean z) {
        this.hd.set(0.0f, 0.0f, 0.0f, 0.0f);
        hd();
        this.n.set(matrix);
        if (z) {
            List<s> list = this.t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.n.preConcat(this.t.get(size).q.q());
                }
            } else {
                s sVar = this.h;
                if (sVar != null) {
                    this.n.preConcat(sVar.q.q());
                }
            }
        }
        this.n.preConcat(this.q.q());
    }

    @Override // com.byazt.sp.l
    public void n(Canvas canvas, Matrix matrix, int i) {
        Paint paint;
        Integer numX;
        com.byazt.pp.l.n(this.ou);
        if (!this.bb || this.s.ou()) {
            com.byazt.pp.l.qg(this.ou);
            return;
        }
        hd();
        com.byazt.pp.l.n("Layer#parentMatrix");
        this.v.set(matrix);
        this.tj.reset();
        this.tj.set(matrix);
        for (int size = this.t.size() - 1; size >= 0; size--) {
            this.tj.preConcat(this.t.get(size).q.q());
        }
        com.byazt.pp.l.qg("Layer#parentMatrix");
        com.byazt.bd.n<?, Integer> nVarN = this.q.n();
        int iIntValue = (int) ((((i / 255.0f) * ((nVarN == null || (numX = nVarN.x()) == null) ? 100 : numX.intValue())) / 100.0f) * 255.0f);
        if (!l() && !rv()) {
            this.tj.preConcat(this.q.q());
            com.byazt.pp.l.n("Layer#drawLayer");
            qg(canvas, this.tj, iIntValue);
            com.byazt.pp.l.qg("Layer#drawLayer");
            s(com.byazt.pp.l.qg(this.ou));
            return;
        }
        com.byazt.pp.l.n("Layer#computeBounds");
        n(this.hd, this.tj, false);
        qg(this.hd, matrix);
        this.tj.preConcat(this.q.q());
        n(this.hd, this.tj);
        this.cd.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        canvas.getMatrix(this.cp);
        if (!this.cp.isIdentity()) {
            Matrix matrix2 = this.cp;
            matrix2.invert(matrix2);
            this.cp.mapRect(this.cd);
        }
        if (!this.hd.intersect(this.cd)) {
            this.hd.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
        com.byazt.pp.l.qg("Layer#computeBounds");
        if (this.hd.width() >= 1.0f && this.hd.height() >= 1.0f) {
            com.byazt.pp.l.n("Layer#saveLayer");
            this.d.setAlpha(255);
            com.byazt.nu.tj.n(canvas, this.hd, this.d);
            com.byazt.pp.l.qg("Layer#saveLayer");
            n(canvas);
            com.byazt.pp.l.n("Layer#drawLayer");
            qg(canvas, this.tj, iIntValue);
            com.byazt.pp.l.qg("Layer#drawLayer");
            if (rv()) {
                n(canvas, this.tj);
            }
            if (l()) {
                com.byazt.pp.l.n("Layer#drawMatte");
                com.byazt.pp.l.n("Layer#saveLayer");
                com.byazt.nu.tj.n(canvas, this.hd, this.k, 19);
                com.byazt.pp.l.qg("Layer#saveLayer");
                n(canvas);
                this.hu.n(canvas, matrix, iIntValue);
                com.byazt.pp.l.n("Layer#restoreLayer");
                canvas.restore();
                com.byazt.pp.l.qg("Layer#restoreLayer");
                com.byazt.pp.l.qg("Layer#drawMatte");
            }
            com.byazt.pp.l.n("Layer#restoreLayer");
            canvas.restore();
            com.byazt.pp.l.qg("Layer#restoreLayer");
        }
        if (this.ln && (paint = this.lh) != null) {
            paint.setStyle(Paint.Style.STROKE);
            this.lh.setColor(-251901);
            this.lh.setStrokeWidth(4.0f);
            canvas.drawRect(this.hd, this.lh);
            this.lh.setStyle(Paint.Style.FILL);
            this.lh.setColor(1357638635);
            canvas.drawRect(this.hd, this.lh);
        }
        s(com.byazt.pp.l.qg(this.ou));
    }

    private void s(float f) {
        this.qg.t().s().n(this.s.w(), f);
    }

    private void n(Canvas canvas) {
        com.byazt.pp.l.n("Layer#clearLayer");
        canvas.drawRect(this.hd.left - 1.0f, this.hd.top - 1.0f, this.hd.right + 1.0f, this.hd.bottom + 1.0f, this.cy);
        com.byazt.pp.l.qg("Layer#clearLayer");
    }

    private void n(RectF rectF, Matrix matrix) {
        this.um.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (rv()) {
            int size = this.wm.n().size();
            for (int i = 0; i < size; i++) {
                com.byazt.aw.fs fsVar = this.wm.n().get(i);
                Path pathX = this.wm.qg().get(i).x();
                if (pathX != null) {
                    this.rv.set(pathX);
                    this.rv.transform(matrix);
                    int i2 = AnonymousClass2.qg[fsVar.n().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        return;
                    }
                    if ((i2 == 3 || i2 == 4) && fsVar.q()) {
                        return;
                    }
                    this.rv.computeBounds(this.py, false);
                    if (i == 0) {
                        this.um.set(this.py);
                    } else {
                        RectF rectF2 = this.um;
                        rectF2.set(Math.min(rectF2.left, this.py.left), Math.min(this.um.top, this.py.top), Math.max(this.um.right, this.py.right), Math.max(this.um.bottom, this.py.bottom));
                    }
                }
            }
            if (rectF.intersect(this.um)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    /* JADX INFO: renamed from: com.byazt.eg.s$2, reason: invalid class name */
    @com.byazt.cp.n(n = {0, 1, 959, 205})
    static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] n;
        public static final /* synthetic */ int[] qg;

        static {
            int[] iArr = new int[com.byazt.aw.fs.n.values().length];
            qg = iArr;
            try {
                iArr[com.byazt.aw.fs.n.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                qg[com.byazt.aw.fs.n.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                qg[com.byazt.aw.fs.n.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                qg[com.byazt.aw.fs.n.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[fs.n.values().length];
            n = iArr2;
            try {
                iArr2[fs.n.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                n[fs.n.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                n[fs.n.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                n[fs.n.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                n[fs.n.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                n[fs.n.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                n[fs.n.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    private void qg(RectF rectF, Matrix matrix) {
        if (l() && this.s.d() != fs.qg.INVERT) {
            this.a.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.hu.n(this.a, matrix, true);
            if (rectF.intersect(this.a)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public float fs() {
        return this.j;
    }

    public void n(int i) {
        this.j = ((this.q.n() != null ? this.q.n().x().intValue() : 100) / 100.0f) * (i / 255.0f);
    }

    public void qg(Canvas canvas, Matrix matrix, int i) {
        n(i);
    }

    private void n(Canvas canvas, Matrix matrix) {
        com.byazt.pp.l.n("Layer#saveLayer");
        com.byazt.nu.tj.n(canvas, this.hd, this.oa, 19);
        if (Build.VERSION.SDK_INT < 28) {
            n(canvas);
        }
        com.byazt.pp.l.qg("Layer#saveLayer");
        for (int i = 0; i < this.wm.n().size(); i++) {
            com.byazt.aw.fs fsVar = this.wm.n().get(i);
            com.byazt.bd.n<com.byazt.aw.sz, Path> nVar = this.wm.qg().get(i);
            com.byazt.bd.n<Integer, Integer> nVar2 = this.wm.s().get(i);
            int i2 = AnonymousClass2.qg[fsVar.n().ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    if (i == 0) {
                        this.d.setColor(ViewCompat.MEASURED_STATE_MASK);
                        this.d.setAlpha(255);
                        canvas.drawRect(this.hd, this.d);
                    }
                    if (fsVar.q()) {
                        s(canvas, matrix, nVar, nVar2);
                    } else {
                        n(canvas, matrix, nVar);
                    }
                } else if (i2 != 3) {
                    if (i2 == 4) {
                        if (fsVar.q()) {
                            qg(canvas, matrix, nVar, nVar2);
                        } else {
                            n(canvas, matrix, nVar, nVar2);
                        }
                    }
                } else if (fsVar.q()) {
                    l(canvas, matrix, nVar, nVar2);
                } else {
                    q(canvas, matrix, nVar, nVar2);
                }
            } else if (cy()) {
                this.d.setAlpha(255);
                canvas.drawRect(this.hd, this.d);
            }
        }
        com.byazt.pp.l.n("Layer#restoreLayer");
        canvas.restore();
        com.byazt.pp.l.qg("Layer#restoreLayer");
    }

    private boolean cy() {
        if (this.wm.qg().isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.wm.n().size(); i++) {
            if (this.wm.n().get(i).n() != com.byazt.aw.fs.n.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    private void n(Canvas canvas, Matrix matrix, com.byazt.bd.n<com.byazt.aw.sz, Path> nVar, com.byazt.bd.n<Integer, Integer> nVar2) {
        this.rv.set(nVar.x());
        this.rv.transform(matrix);
        this.d.setAlpha((int) (nVar2.x().intValue() * 2.55f));
        canvas.drawPath(this.rv, this.d);
    }

    private void qg(Canvas canvas, Matrix matrix, com.byazt.bd.n<com.byazt.aw.sz, Path> nVar, com.byazt.bd.n<Integer, Integer> nVar2) {
        com.byazt.nu.tj.n(canvas, this.hd, this.d);
        canvas.drawRect(this.hd, this.d);
        this.rv.set(nVar.x());
        this.rv.transform(matrix);
        this.d.setAlpha((int) (nVar2.x().intValue() * 2.55f));
        canvas.drawPath(this.rv, this.sz);
        canvas.restore();
    }

    private void n(Canvas canvas, Matrix matrix, com.byazt.bd.n<com.byazt.aw.sz, Path> nVar) {
        this.rv.set(nVar.x());
        this.rv.transform(matrix);
        canvas.drawPath(this.rv, this.sz);
    }

    private void s(Canvas canvas, Matrix matrix, com.byazt.bd.n<com.byazt.aw.sz, Path> nVar, com.byazt.bd.n<Integer, Integer> nVar2) {
        com.byazt.nu.tj.n(canvas, this.hd, this.sz);
        canvas.drawRect(this.hd, this.d);
        this.sz.setAlpha((int) (nVar2.x().intValue() * 2.55f));
        this.rv.set(nVar.x());
        this.rv.transform(matrix);
        canvas.drawPath(this.rv, this.sz);
        canvas.restore();
    }

    private void q(Canvas canvas, Matrix matrix, com.byazt.bd.n<com.byazt.aw.sz, Path> nVar, com.byazt.bd.n<Integer, Integer> nVar2) {
        com.byazt.nu.tj.n(canvas, this.hd, this.oa);
        this.rv.set(nVar.x());
        this.rv.transform(matrix);
        this.d.setAlpha((int) (nVar2.x().intValue() * 2.55f));
        canvas.drawPath(this.rv, this.d);
        canvas.restore();
    }

    private void l(Canvas canvas, Matrix matrix, com.byazt.bd.n<com.byazt.aw.sz, Path> nVar, com.byazt.bd.n<Integer, Integer> nVar2) {
        com.byazt.nu.tj.n(canvas, this.hd, this.oa);
        canvas.drawRect(this.hd, this.d);
        this.sz.setAlpha((int) (nVar2.x().intValue() * 2.55f));
        this.rv.set(nVar.x());
        this.rv.transform(matrix);
        canvas.drawPath(this.rv, this.sz);
        canvas.restore();
    }

    public boolean rv() {
        com.byazt.bd.fs fsVar = this.wm;
        return (fsVar == null || fsVar.qg().isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(boolean z) {
        if (z != this.bb) {
            this.bb = z;
            k();
        }
    }

    public boolean tj() {
        return this.bb;
    }

    public void n(float f) {
        this.q.n(f);
        if (this.wm != null) {
            for (int i = 0; i < this.wm.qg().size(); i++) {
                this.wm.qg().get(i).n(f);
            }
        }
        com.byazt.bd.q qVar = this.m;
        if (qVar != null) {
            qVar.n(f);
        }
        s sVar = this.hu;
        if (sVar != null) {
            sVar.n(f);
        }
        for (int i2 = 0; i2 < this.ur.size(); i2++) {
            this.ur.get(i2).n(f);
        }
    }

    private void hd() {
        if (this.t != null) {
            return;
        }
        if (this.h == null) {
            this.t = Collections.emptyList();
            return;
        }
        this.t = new ArrayList();
        for (s sVar = this.h; sVar != null; sVar = sVar.h) {
            this.t.add(sVar);
        }
    }

    public String cp() {
        return this.s.w();
    }

    public com.byazt.aw.n d() {
        return this.s.wm();
    }

    public BlurMaskFilter qg(float f) {
        if (this.l == f) {
            return this.w;
        }
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(f / 2.0f, BlurMaskFilter.Blur.NORMAL);
        this.w = blurMaskFilter;
        this.l = f;
        return blurMaskFilter;
    }

    public com.byazt.ur.tj oa() {
        return this.s.m();
    }
}
