package com.byazt.cg;

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
import android.support.v4.view.ViewCompat;
import com.byazt.al.nt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPENED_TIME, 20})
public abstract class hn implements com.byazt.al.pr.InterfaceC0016pr, com.byazt.ova.c {
    public final RectF a;
    public hn b;
    public float c;
    public final RectF cz;
    public com.byazt.al.zo fo;
    public boolean gz;
    public final zo hn;
    public final Paint ho;
    public final com.byazt.dx.zo hw;
    public List<hn> iu;
    public final RectF lb;
    public float n;
    public boolean nl;
    public final Paint nt;
    public final String ny;
    public final Matrix pr;
    public final RectF qa;
    public com.byazt.al.x rc;
    public BlurMaskFilter uc;
    public final List<com.byazt.al.pr<?, ?>> ve;
    public final Matrix ww;
    public final nt x;
    public Paint y;
    public final RectF yb;
    public hn z;
    public boolean zo;
    public final Handler fw = new Handler(Looper.getMainLooper());
    public final Path aj = new Path();
    public final Matrix vk = new Matrix();
    public final Matrix w = new Matrix();
    public final Paint k = new com.byazt.qpa.pr(1);
    public final Paint m = new com.byazt.qpa.pr(1, PorterDuff.Mode.DST_IN);
    public final Paint g = new com.byazt.qpa.pr(1, PorterDuff.Mode.DST_OUT);

    public boolean hw() {
        return this.zo;
    }

    public void hn() {
        this.zo = true;
    }

    public void pr(Runnable runnable) {
        this.fw.post(runnable);
    }

    public static hn pr(x xVar, zo zoVar, com.byazt.dx.zo zoVar2, com.byazt.dx.uc ucVar, Context context) {
        switch (AnonymousClass2.pr[zoVar.w().ordinal()]) {
            case 1:
                return new vk(zoVar2, zoVar, xVar, ucVar);
            case 2:
                return new x(zoVar2, zoVar, ucVar.hw(zoVar.fw()), ucVar, context);
            case 3:
                return new w(zoVar2, zoVar);
            case 4:
                if (pr(zoVar2, zoVar, "text:")) {
                    return new uc(zoVar2, zoVar, context);
                }
                if (pr(zoVar2, zoVar, "videoview:")) {
                    com.byazt.dx.aj.pr prVarPr = pr(zoVar2, zoVar);
                    if (prVarPr != null) {
                        if (prVarPr.pr != null && prVarPr.pr.pr > 0.0f) {
                            return new c(zoVar2, zoVar, context, prVarPr.pr);
                        }
                        if (prVarPr.hw) {
                            return new hw(zoVar2, zoVar, context);
                        }
                        return new g(zoVar2, zoVar, context);
                    }
                    return new g(zoVar2, zoVar, context);
                }
                if (pr(zoVar2, zoVar, "animview:")) {
                    return new pr(zoVar2, zoVar, context);
                }
                if (pr(zoVar2, zoVar, "view:")) {
                    return new m(zoVar2, zoVar, context);
                }
                fw fwVar = new fw(zoVar2, zoVar);
                fwVar.g();
                return fwVar;
            case 5:
                return new aj(zoVar2, zoVar);
            case 6:
                return new k(zoVar2, zoVar);
            default:
                com.byazt.ptr.uc.hw("Unknown layer type " + zoVar.w());
                return null;
        }
    }

    private static com.byazt.dx.aj.pr pr(com.byazt.dx.zo zoVar, zo zoVar2) {
        com.byazt.dx.aj ajVarUc;
        if (zoVar == null || zoVar2 == null || (ajVarUc = zoVar.uc(zoVar2.fw())) == null) {
            return null;
        }
        return ajVarUc.vk();
    }

    private static boolean pr(com.byazt.dx.zo zoVar, zo zoVar2, String str) {
        com.byazt.dx.aj ajVarUc;
        if (zoVar == null || zoVar2 == null || str == null || (ajVarUc = zoVar.uc(zoVar2.fw())) == null) {
            return false;
        }
        return str.equals(ajVarUc.g());
    }

    public hn(com.byazt.dx.zo zoVar, zo zoVar2) {
        com.byazt.qpa.pr prVar = new com.byazt.qpa.pr(1);
        this.ho = prVar;
        this.nt = new com.byazt.qpa.pr(PorterDuff.Mode.CLEAR);
        this.yb = new RectF();
        this.lb = new RectF();
        this.qa = new RectF();
        this.a = new RectF();
        this.cz = new RectF();
        this.pr = new Matrix();
        this.ve = new ArrayList();
        this.gz = true;
        this.c = 0.0f;
        this.ww = new Matrix();
        this.n = 1.0f;
        this.hw = zoVar;
        this.hn = zoVar2;
        this.ny = zoVar2.uc() + "#draw";
        if (zoVar2.k() == zo.hw.INVERT) {
            prVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            prVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        nt ntVarVk = zoVar2.ho().vk();
        this.x = ntVarVk;
        ntVarVk.pr((com.byazt.al.pr.InterfaceC0016pr) this);
        if (zoVar2.vk() != null && !zoVar2.vk().isEmpty()) {
            com.byazt.al.zo zoVar3 = new com.byazt.al.zo(zoVar2.vk());
            this.fo = zoVar3;
            Iterator<com.byazt.al.pr<com.byazt.ynb.g, Path>> it = zoVar3.hw().iterator();
            while (it.hasNext()) {
                it.next().pr(this);
            }
            for (com.byazt.al.pr<Integer, Integer> prVar2 : this.fo.hn()) {
                pr(prVar2);
                prVar2.pr(this);
            }
        }
        g();
    }

    public void pr(boolean z) {
        if (z && this.y == null) {
            this.y = new com.byazt.qpa.pr();
        }
        this.nl = z;
    }

    @Override // com.byazt.al.pr.InterfaceC0016pr
    public void pr() {
        ho();
    }

    public zo x() {
        return this.hn;
    }

    public void pr(hn hnVar) {
        this.z = hnVar;
    }

    public boolean c() {
        return this.z != null;
    }

    public void hw(hn hnVar) {
        this.b = hnVar;
    }

    private void g() {
        if (!this.hn.x().isEmpty()) {
            com.byazt.al.x xVar = new com.byazt.al.x(this.hn.x());
            this.rc = xVar;
            xVar.pr();
            this.rc.pr(new com.byazt.al.pr.InterfaceC0016pr() { // from class: com.byazt.cg.hn.1
                @Override // com.byazt.al.pr.InterfaceC0016pr
                public void pr() {
                    hn hnVar = hn.this;
                    hnVar.hw(hnVar.rc.aj() == 1.0f);
                }
            });
            hw(this.rc.fw().floatValue() == 1.0f);
            pr(this.rc);
            return;
        }
        hw(true);
    }

    private void ho() {
        this.hw.invalidateSelf();
    }

    public void pr(com.byazt.al.pr<?, ?> prVar) {
        if (prVar == null) {
            return;
        }
        this.ve.add(prVar);
    }

    public Matrix uc() {
        return this.ww;
    }

    public String fw() {
        zo zoVar = this.hn;
        if (zoVar != null) {
            return zoVar.fw();
        }
        return null;
    }

    public void pr(RectF rectF, Matrix matrix, boolean z) {
        this.yb.set(0.0f, 0.0f, 0.0f, 0.0f);
        yb();
        this.pr.set(matrix);
        if (z) {
            List<hn> list = this.iu;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.pr.preConcat(this.iu.get(size).x.x());
                }
            } else {
                hn hnVar = this.b;
                if (hnVar != null) {
                    this.pr.preConcat(hnVar.x.x());
                }
            }
        }
        this.pr.preConcat(this.x.x());
    }

    @Override // com.byazt.ova.c
    public void pr(Canvas canvas, Matrix matrix, int i) {
        Paint paint;
        Integer numFw;
        com.byazt.dx.c.pr(this.ny);
        if (!this.gz || this.hn.ny()) {
            com.byazt.dx.c.hw(this.ny);
            return;
        }
        yb();
        com.byazt.dx.c.pr("Layer#parentMatrix");
        this.ww.set(matrix);
        this.vk.reset();
        this.vk.set(matrix);
        for (int size = this.iu.size() - 1; size >= 0; size--) {
            this.vk.preConcat(this.iu.get(size).x.x());
        }
        com.byazt.dx.c.hw("Layer#parentMatrix");
        int iIntValue = 100;
        com.byazt.al.pr<?, Integer> prVarPr = this.x.pr();
        if (prVarPr != null && (numFw = prVarPr.fw()) != null) {
            iIntValue = numFw.intValue();
        }
        int i2 = (int) ((((i / 255.0f) * iIntValue) / 100.0f) * 255.0f);
        if (!c() && !aj()) {
            this.vk.preConcat(this.x.x());
            com.byazt.dx.c.pr("Layer#drawLayer");
            hw(canvas, this.vk, i2);
            com.byazt.dx.c.hw("Layer#drawLayer");
            hn(com.byazt.dx.c.hw(this.ny));
            return;
        }
        com.byazt.dx.c.pr("Layer#computeBounds");
        pr(this.yb, this.vk, false);
        hw(this.yb, matrix);
        this.vk.preConcat(this.x.x());
        pr(this.yb, this.vk);
        this.lb.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        canvas.getMatrix(this.w);
        if (!this.w.isIdentity()) {
            Matrix matrix2 = this.w;
            matrix2.invert(matrix2);
            this.w.mapRect(this.lb);
        }
        if (!this.yb.intersect(this.lb)) {
            this.yb.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
        com.byazt.dx.c.hw("Layer#computeBounds");
        if (this.yb.width() >= 1.0f && this.yb.height() >= 1.0f) {
            com.byazt.dx.c.pr("Layer#saveLayer");
            this.k.setAlpha(255);
            com.byazt.ptr.vk.pr(canvas, this.yb, this.k);
            com.byazt.dx.c.hw("Layer#saveLayer");
            pr(canvas);
            com.byazt.dx.c.pr("Layer#drawLayer");
            hw(canvas, this.vk, i2);
            com.byazt.dx.c.hw("Layer#drawLayer");
            if (aj()) {
                pr(canvas, this.vk);
            }
            if (c()) {
                com.byazt.dx.c.pr("Layer#drawMatte");
                com.byazt.dx.c.pr("Layer#saveLayer");
                com.byazt.ptr.vk.pr(canvas, this.yb, this.ho, 19);
                com.byazt.dx.c.hw("Layer#saveLayer");
                pr(canvas);
                this.z.pr(canvas, matrix, i2);
                com.byazt.dx.c.pr("Layer#restoreLayer");
                canvas.restore();
                com.byazt.dx.c.hw("Layer#restoreLayer");
                com.byazt.dx.c.hw("Layer#drawMatte");
            }
            com.byazt.dx.c.pr("Layer#restoreLayer");
            canvas.restore();
            com.byazt.dx.c.hw("Layer#restoreLayer");
        }
        if (this.nl && (paint = this.y) != null) {
            paint.setStyle(Paint.Style.STROKE);
            this.y.setColor(-251901);
            this.y.setStrokeWidth(4.0f);
            canvas.drawRect(this.yb, this.y);
            this.y.setStyle(Paint.Style.FILL);
            this.y.setColor(1357638635);
            canvas.drawRect(this.yb, this.y);
        }
        hn(com.byazt.dx.c.hw(this.ny));
    }

    private void hn(float f) {
        this.hw.iu().hn().pr(this.hn.uc(), f);
    }

    private void pr(Canvas canvas) {
        com.byazt.dx.c.pr("Layer#clearLayer");
        canvas.drawRect(this.yb.left - 1.0f, this.yb.top - 1.0f, this.yb.right + 1.0f, this.yb.bottom + 1.0f, this.nt);
        com.byazt.dx.c.hw("Layer#clearLayer");
    }

    private void pr(RectF rectF, Matrix matrix) {
        this.qa.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (!aj()) {
            return;
        }
        int size = this.fo.pr().size();
        for (int i = 0; i < size; i++) {
            com.byazt.ynb.zo zoVar = this.fo.pr().get(i);
            Path pathFw = this.fo.hw().get(i).fw();
            if (pathFw != null) {
                this.aj.set(pathFw);
                this.aj.transform(matrix);
                switch (AnonymousClass2.hw[zoVar.pr().ordinal()]) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                    case 4:
                        if (zoVar.x()) {
                            break;
                        }
                    default:
                        this.aj.computeBounds(this.cz, false);
                        if (i == 0) {
                            this.qa.set(this.cz);
                        } else {
                            RectF rectF2 = this.qa;
                            rectF2.set(Math.min(rectF2.left, this.cz.left), Math.min(this.qa.top, this.cz.top), Math.max(this.qa.right, this.cz.right), Math.max(this.qa.bottom, this.cz.bottom));
                        }
                        break;
                }
                return;
            }
        }
        if (!rectF.intersect(this.qa)) {
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    /* JADX INFO: renamed from: com.byazt.cg.hn$2, reason: invalid class name */
    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPENED_TIME, 58})
    static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] hw;
        public static final /* synthetic */ int[] pr;

        static {
            int[] iArr = new int[com.byazt.ynb.zo.pr.values().length];
            hw = iArr;
            try {
                iArr[com.byazt.ynb.zo.pr.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                hw[com.byazt.ynb.zo.pr.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                hw[com.byazt.ynb.zo.pr.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                hw[com.byazt.ynb.zo.pr.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            int[] iArr2 = new int[zo.pr.values().length];
            pr = iArr2;
            try {
                iArr2[zo.pr.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                pr[zo.pr.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                pr[zo.pr.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                pr[zo.pr.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
            try {
                pr[zo.pr.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError e9) {
            }
            try {
                pr[zo.pr.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError e10) {
            }
            try {
                pr[zo.pr.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError e11) {
            }
        }
    }

    private void hw(RectF rectF, Matrix matrix) {
        if (!c() || this.hn.k() == zo.hw.INVERT) {
            return;
        }
        this.a.set(0.0f, 0.0f, 0.0f, 0.0f);
        this.z.pr(this.a, matrix, true);
        if (!rectF.intersect(this.a)) {
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public float zo() {
        return this.n;
    }

    public void pr(int i) {
        this.n = ((this.x.pr() != null ? this.x.pr().fw().intValue() : 100) / 100.0f) * (i / 255.0f);
    }

    public void hw(Canvas canvas, Matrix matrix, int i) {
        pr(i);
    }

    private void pr(Canvas canvas, Matrix matrix) {
        com.byazt.dx.c.pr("Layer#saveLayer");
        com.byazt.ptr.vk.pr(canvas, this.yb, this.m, 19);
        if (Build.VERSION.SDK_INT < 28) {
            pr(canvas);
        }
        com.byazt.dx.c.hw("Layer#saveLayer");
        for (int i = 0; i < this.fo.pr().size(); i++) {
            com.byazt.ynb.zo zoVar = this.fo.pr().get(i);
            com.byazt.al.pr<com.byazt.ynb.g, Path> prVar = this.fo.hw().get(i);
            com.byazt.al.pr<Integer, Integer> prVar2 = this.fo.hn().get(i);
            switch (AnonymousClass2.hw[zoVar.pr().ordinal()]) {
                case 1:
                    if (nt()) {
                        this.k.setAlpha(255);
                        canvas.drawRect(this.yb, this.k);
                    }
                    break;
                case 2:
                    if (i == 0) {
                        this.k.setColor(ViewCompat.MEASURED_STATE_MASK);
                        this.k.setAlpha(255);
                        canvas.drawRect(this.yb, this.k);
                    }
                    if (zoVar.x()) {
                        hn(canvas, matrix, prVar, prVar2);
                    } else {
                        pr(canvas, matrix, prVar);
                    }
                    break;
                case 3:
                    if (zoVar.x()) {
                        c(canvas, matrix, prVar, prVar2);
                    } else {
                        x(canvas, matrix, prVar, prVar2);
                    }
                    break;
                case 4:
                    if (zoVar.x()) {
                        hw(canvas, matrix, prVar, prVar2);
                    } else {
                        pr(canvas, matrix, prVar, prVar2);
                    }
                    break;
            }
        }
        com.byazt.dx.c.pr("Layer#restoreLayer");
        canvas.restore();
        com.byazt.dx.c.hw("Layer#restoreLayer");
    }

    private boolean nt() {
        if (this.fo.hw().isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.fo.pr().size(); i++) {
            if (this.fo.pr().get(i).pr() != com.byazt.ynb.zo.pr.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    private void pr(Canvas canvas, Matrix matrix, com.byazt.al.pr<com.byazt.ynb.g, Path> prVar, com.byazt.al.pr<Integer, Integer> prVar2) {
        this.aj.set(prVar.fw());
        this.aj.transform(matrix);
        this.k.setAlpha((int) (prVar2.fw().intValue() * 2.55f));
        canvas.drawPath(this.aj, this.k);
    }

    private void hw(Canvas canvas, Matrix matrix, com.byazt.al.pr<com.byazt.ynb.g, Path> prVar, com.byazt.al.pr<Integer, Integer> prVar2) {
        com.byazt.ptr.vk.pr(canvas, this.yb, this.k);
        canvas.drawRect(this.yb, this.k);
        this.aj.set(prVar.fw());
        this.aj.transform(matrix);
        this.k.setAlpha((int) (prVar2.fw().intValue() * 2.55f));
        canvas.drawPath(this.aj, this.g);
        canvas.restore();
    }

    private void pr(Canvas canvas, Matrix matrix, com.byazt.al.pr<com.byazt.ynb.g, Path> prVar) {
        this.aj.set(prVar.fw());
        this.aj.transform(matrix);
        canvas.drawPath(this.aj, this.g);
    }

    private void hn(Canvas canvas, Matrix matrix, com.byazt.al.pr<com.byazt.ynb.g, Path> prVar, com.byazt.al.pr<Integer, Integer> prVar2) {
        com.byazt.ptr.vk.pr(canvas, this.yb, this.g);
        canvas.drawRect(this.yb, this.k);
        this.g.setAlpha((int) (prVar2.fw().intValue() * 2.55f));
        this.aj.set(prVar.fw());
        this.aj.transform(matrix);
        canvas.drawPath(this.aj, this.g);
        canvas.restore();
    }

    private void x(Canvas canvas, Matrix matrix, com.byazt.al.pr<com.byazt.ynb.g, Path> prVar, com.byazt.al.pr<Integer, Integer> prVar2) {
        com.byazt.ptr.vk.pr(canvas, this.yb, this.m);
        this.aj.set(prVar.fw());
        this.aj.transform(matrix);
        this.k.setAlpha((int) (prVar2.fw().intValue() * 2.55f));
        canvas.drawPath(this.aj, this.k);
        canvas.restore();
    }

    private void c(Canvas canvas, Matrix matrix, com.byazt.al.pr<com.byazt.ynb.g, Path> prVar, com.byazt.al.pr<Integer, Integer> prVar2) {
        com.byazt.ptr.vk.pr(canvas, this.yb, this.m);
        canvas.drawRect(this.yb, this.k);
        this.g.setAlpha((int) (prVar2.fw().intValue() * 2.55f));
        this.aj.set(prVar.fw());
        this.aj.transform(matrix);
        canvas.drawPath(this.aj, this.g);
        canvas.restore();
    }

    public boolean aj() {
        com.byazt.al.zo zoVar = this.fo;
        return (zoVar == null || zoVar.hw().isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(boolean z) {
        if (z != this.gz) {
            this.gz = z;
            ho();
        }
    }

    public boolean vk() {
        return this.gz;
    }

    public void pr(float f) {
        this.x.pr(f);
        if (this.fo != null) {
            for (int i = 0; i < this.fo.hw().size(); i++) {
                this.fo.hw().get(i).pr(f);
            }
        }
        com.byazt.al.x xVar = this.rc;
        if (xVar != null) {
            xVar.pr(f);
        }
        hn hnVar = this.z;
        if (hnVar != null) {
            hnVar.pr(f);
        }
        for (int i2 = 0; i2 < this.ve.size(); i2++) {
            this.ve.get(i2).pr(f);
        }
    }

    private void yb() {
        if (this.iu != null) {
            return;
        }
        if (this.b == null) {
            this.iu = Collections.emptyList();
            return;
        }
        this.iu = new ArrayList();
        for (hn hnVar = this.b; hnVar != null; hnVar = hnVar.b) {
            this.iu.add(hnVar);
        }
    }

    public String w() {
        return this.hn.uc();
    }

    public com.byazt.ynb.pr k() {
        return this.hn.fo();
    }

    public BlurMaskFilter hw(float f) {
        if (this.c == f) {
            return this.uc;
        }
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(f / 2.0f, BlurMaskFilter.Blur.NORMAL);
        this.uc = blurMaskFilter;
        this.c = f;
        return blurMaskFilter;
    }

    public com.byazt.tx.vk m() {
        return this.hn.rc();
    }

    @Override // com.byazt.ova.hn
    public void pr(List<com.byazt.ova.hn> list, List<com.byazt.ova.hn> list2) {
    }
}
