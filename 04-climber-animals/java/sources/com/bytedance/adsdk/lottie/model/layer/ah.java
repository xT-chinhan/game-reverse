package com.bytedance.adsdk.lottie.model.layer;

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
import com.bytedance.adsdk.lottie.ms.xr.ao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ah implements com.bytedance.adsdk.lottie.ms.ms.ka, com.bytedance.adsdk.lottie.ms.xr.ms.InterfaceC0189ms {
    final x ah;
    private final Paint ao;
    private final String b;
    BlurMaskFilter c;
    private boolean cv;
    final ao d;
    private boolean g;
    private final RectF h;
    private com.bytedance.adsdk.lottie.ms.xr.d i;
    float ka;
    private final List<com.bytedance.adsdk.lottie.ms.xr.ms<?, ?>> le;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    final Matrix f183ms;
    private final RectF nw;
    private Paint of;
    private List<ah> op;
    private final Matrix p;
    private float pc;
    private final RectF qv;
    private com.bytedance.adsdk.lottie.ms.xr.x re;
    private final RectF t;
    private final Paint ub;
    private ah w;
    private boolean x;
    final com.bytedance.adsdk.lottie.x xr;
    private final RectF y;
    private ah yu;
    private final Handler ab = new Handler(Looper.getMainLooper());
    private final Path ny = new Path();
    private final Matrix ch = new Matrix();
    private final Matrix hi = new Matrix();
    private final Paint sl = new com.bytedance.adsdk.lottie.ms.ms(1);
    private final Paint zb = new com.bytedance.adsdk.lottie.ms.ms(1, PorterDuff.Mode.DST_IN);
    private final Paint u = new com.bytedance.adsdk.lottie.ms.ms(1, PorterDuff.Mode.DST_OUT);

    @Override // com.bytedance.adsdk.lottie.ms.ms.ah
    public void ms(List<com.bytedance.adsdk.lottie.ms.ms.ah> list, List<com.bytedance.adsdk.lottie.ms.ms.ah> list2) {
    }

    public boolean xr() {
        return this.x;
    }

    public void ah() {
        this.x = true;
    }

    public void ms(Runnable runnable) {
        this.ab.post(runnable);
    }

    static ah ms(d dVar, x xVar, com.bytedance.adsdk.lottie.x xVar2, com.bytedance.adsdk.lottie.c cVar, Context context) {
        switch (AnonymousClass2.f185ms[xVar.hi().ordinal()]) {
            case 1:
                return new ch(xVar2, xVar, dVar, cVar);
            case 2:
                return new d(xVar2, xVar, cVar.xr(xVar.ab()), cVar, context);
            case 3:
                return new hi(xVar2, xVar);
            case 4:
                if (ms(xVar2, xVar, "text:")) {
                    return new c(xVar2, xVar, context);
                }
                if (ms(xVar2, xVar, "videoview:")) {
                    com.bytedance.adsdk.lottie.ny.ms msVarMs = ms(xVar2, xVar);
                    if (msVarMs != null) {
                        if (msVarMs.f266ms != null && msVarMs.f266ms.f267ms > 0.0f) {
                            return new ka(xVar2, xVar, context, msVarMs.f266ms);
                        }
                        if (msVarMs.xr) {
                            return new xr(xVar2, xVar, context);
                        }
                        return new u(xVar2, xVar, context);
                    }
                    return new u(xVar2, xVar, context);
                }
                if (ms(xVar2, xVar, "animview:")) {
                    return new ms(xVar2, xVar, context);
                }
                if (ms(xVar2, xVar, "view:")) {
                    return new zb(xVar2, xVar, context);
                }
                return new ab(xVar2, xVar);
            case 5:
                return new ny(xVar2, xVar);
            case 6:
                return new sl(xVar2, xVar);
            default:
                com.bytedance.adsdk.lottie.ka.ka.xr("Unknown layer type " + xVar.hi());
                return null;
        }
    }

    private static com.bytedance.adsdk.lottie.ny.ms ms(com.bytedance.adsdk.lottie.x xVar, x xVar2) {
        com.bytedance.adsdk.lottie.ny nyVarC;
        if (xVar == null || xVar2 == null || (nyVarC = xVar.c(xVar2.ab())) == null) {
            return null;
        }
        return nyVarC.ch();
    }

    private static boolean ms(com.bytedance.adsdk.lottie.x xVar, x xVar2, String str) {
        com.bytedance.adsdk.lottie.ny nyVarC;
        if (xVar == null || xVar2 == null || str == null || (nyVarC = xVar.c(xVar2.ab())) == null) {
            return false;
        }
        return str.equals(nyVarC.zb());
    }

    ah(com.bytedance.adsdk.lottie.x xVar, x xVar2) {
        com.bytedance.adsdk.lottie.ms.ms msVar = new com.bytedance.adsdk.lottie.ms.ms(1);
        this.ub = msVar;
        this.ao = new com.bytedance.adsdk.lottie.ms.ms(PorterDuff.Mode.CLEAR);
        this.h = new RectF();
        this.qv = new RectF();
        this.y = new RectF();
        this.t = new RectF();
        this.nw = new RectF();
        this.f183ms = new Matrix();
        this.le = new ArrayList();
        this.cv = true;
        this.ka = 0.0f;
        this.p = new Matrix();
        this.pc = 1.0f;
        this.xr = xVar;
        this.ah = xVar2;
        this.b = xVar2.c() + "#draw";
        if (xVar2.sl() == x.xr.INVERT) {
            msVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            msVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        ao aoVarCh = xVar2.ub().ch();
        this.d = aoVarCh;
        aoVarCh.ms((com.bytedance.adsdk.lottie.ms.xr.ms.InterfaceC0189ms) this);
        if (xVar2.ch() != null && !xVar2.ch().isEmpty()) {
            com.bytedance.adsdk.lottie.ms.xr.x xVar3 = new com.bytedance.adsdk.lottie.ms.xr.x(xVar2.ch());
            this.re = xVar3;
            Iterator<com.bytedance.adsdk.lottie.ms.xr.ms<com.bytedance.adsdk.lottie.model.xr.u, Path>> it = xVar3.xr().iterator();
            while (it.hasNext()) {
                it.next().ms(this);
            }
            for (com.bytedance.adsdk.lottie.ms.xr.ms<Integer, Integer> msVar2 : this.re.ah()) {
                ms(msVar2);
                msVar2.ms(this);
            }
        }
        u();
    }

    void ms(boolean z) {
        if (z && this.of == null) {
            this.of = new com.bytedance.adsdk.lottie.ms.ms();
        }
        this.g = z;
    }

    @Override // com.bytedance.adsdk.lottie.ms.xr.ms.InterfaceC0189ms
    public void ms() {
        ub();
    }

    x d() {
        return this.ah;
    }

    void ms(ah ahVar) {
        this.w = ahVar;
    }

    boolean ka() {
        return this.w != null;
    }

    void xr(ah ahVar) {
        this.yu = ahVar;
    }

    private void u() {
        if (!this.ah.d().isEmpty()) {
            com.bytedance.adsdk.lottie.ms.xr.d dVar = new com.bytedance.adsdk.lottie.ms.xr.d(this.ah.d());
            this.i = dVar;
            dVar.ms();
            this.i.ms(new com.bytedance.adsdk.lottie.ms.xr.ms.InterfaceC0189ms() { // from class: com.bytedance.adsdk.lottie.model.layer.ah.1
                @Override // com.bytedance.adsdk.lottie.ms.xr.ms.InterfaceC0189ms
                public void ms() {
                    ah ahVar = ah.this;
                    ahVar.xr(ahVar.i.ny() == 1.0f);
                }
            });
            xr(this.i.ab().floatValue() == 1.0f);
            ms(this.i);
            return;
        }
        xr(true);
    }

    private void ub() {
        this.xr.invalidateSelf();
    }

    public void ms(com.bytedance.adsdk.lottie.ms.xr.ms<?, ?> msVar) {
        if (msVar == null) {
            return;
        }
        this.le.add(msVar);
    }

    public Matrix c() {
        return this.p;
    }

    public String ab() {
        x xVar = this.ah;
        if (xVar != null) {
            return xVar.ab();
        }
        return null;
    }

    @Override // com.bytedance.adsdk.lottie.ms.ms.ka
    public void ms(RectF rectF, Matrix matrix, boolean z) {
        this.h.set(0.0f, 0.0f, 0.0f, 0.0f);
        h();
        this.f183ms.set(matrix);
        if (z) {
            List<ah> list = this.op;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f183ms.preConcat(this.op.get(size).d.d());
                }
            } else {
                ah ahVar = this.yu;
                if (ahVar != null) {
                    this.f183ms.preConcat(ahVar.d.d());
                }
            }
        }
        this.f183ms.preConcat(this.d.d());
    }

    @Override // com.bytedance.adsdk.lottie.ms.ms.ka
    public void ms(Canvas canvas, Matrix matrix, int i) {
        Paint paint;
        Integer numAb;
        com.bytedance.adsdk.lottie.ka.ms(this.b);
        if (!this.cv || this.ah.b()) {
            com.bytedance.adsdk.lottie.ka.xr(this.b);
            return;
        }
        h();
        com.bytedance.adsdk.lottie.ka.ms("Layer#parentMatrix");
        this.p.set(matrix);
        this.ch.reset();
        this.ch.set(matrix);
        for (int size = this.op.size() - 1; size >= 0; size--) {
            this.ch.preConcat(this.op.get(size).d.d());
        }
        com.bytedance.adsdk.lottie.ka.xr("Layer#parentMatrix");
        com.bytedance.adsdk.lottie.ms.xr.ms<?, Integer> msVarMs = this.d.ms();
        int iIntValue = (int) ((((i / 255.0f) * ((msVarMs == null || (numAb = msVarMs.ab()) == null) ? 100 : numAb.intValue())) / 100.0f) * 255.0f);
        if (!ka() && !ny()) {
            this.ch.preConcat(this.d.d());
            com.bytedance.adsdk.lottie.ka.ms("Layer#drawLayer");
            xr(canvas, this.ch, iIntValue);
            com.bytedance.adsdk.lottie.ka.xr("Layer#drawLayer");
            ah(com.bytedance.adsdk.lottie.ka.xr(this.b));
            return;
        }
        com.bytedance.adsdk.lottie.ka.ms("Layer#computeBounds");
        ms(this.h, this.ch, false);
        xr(this.h, matrix);
        this.ch.preConcat(this.d.d());
        ms(this.h, this.ch);
        this.qv.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        canvas.getMatrix(this.hi);
        if (!this.hi.isIdentity()) {
            Matrix matrix2 = this.hi;
            matrix2.invert(matrix2);
            this.hi.mapRect(this.qv);
        }
        if (!this.h.intersect(this.qv)) {
            this.h.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
        com.bytedance.adsdk.lottie.ka.xr("Layer#computeBounds");
        if (this.h.width() >= 1.0f && this.h.height() >= 1.0f) {
            com.bytedance.adsdk.lottie.ka.ms("Layer#saveLayer");
            this.sl.setAlpha(255);
            com.bytedance.adsdk.lottie.ka.ny.ms(canvas, this.h, this.sl);
            com.bytedance.adsdk.lottie.ka.xr("Layer#saveLayer");
            ms(canvas);
            com.bytedance.adsdk.lottie.ka.ms("Layer#drawLayer");
            xr(canvas, this.ch, iIntValue);
            com.bytedance.adsdk.lottie.ka.xr("Layer#drawLayer");
            if (ny()) {
                ms(canvas, this.ch);
            }
            if (ka()) {
                com.bytedance.adsdk.lottie.ka.ms("Layer#drawMatte");
                com.bytedance.adsdk.lottie.ka.ms("Layer#saveLayer");
                com.bytedance.adsdk.lottie.ka.ny.ms(canvas, this.h, this.ub, 19);
                com.bytedance.adsdk.lottie.ka.xr("Layer#saveLayer");
                ms(canvas);
                this.w.ms(canvas, matrix, iIntValue);
                com.bytedance.adsdk.lottie.ka.ms("Layer#restoreLayer");
                canvas.restore();
                com.bytedance.adsdk.lottie.ka.xr("Layer#restoreLayer");
                com.bytedance.adsdk.lottie.ka.xr("Layer#drawMatte");
            }
            com.bytedance.adsdk.lottie.ka.ms("Layer#restoreLayer");
            canvas.restore();
            com.bytedance.adsdk.lottie.ka.xr("Layer#restoreLayer");
        }
        if (this.g && (paint = this.of) != null) {
            paint.setStyle(Paint.Style.STROKE);
            this.of.setColor(-251901);
            this.of.setStrokeWidth(4.0f);
            canvas.drawRect(this.h, this.of);
            this.of.setStyle(Paint.Style.FILL);
            this.of.setColor(1357638635);
            canvas.drawRect(this.h, this.of);
        }
        ah(com.bytedance.adsdk.lottie.ka.xr(this.b));
    }

    private void ah(float f) {
        this.xr.op().ah().ms(this.ah.c(), f);
    }

    private void ms(Canvas canvas) {
        com.bytedance.adsdk.lottie.ka.ms("Layer#clearLayer");
        canvas.drawRect(this.h.left - 1.0f, this.h.top - 1.0f, this.h.right + 1.0f, this.h.bottom + 1.0f, this.ao);
        com.bytedance.adsdk.lottie.ka.xr("Layer#clearLayer");
    }

    private void ms(RectF rectF, Matrix matrix) {
        this.y.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (ny()) {
            int size = this.re.ms().size();
            for (int i = 0; i < size; i++) {
                com.bytedance.adsdk.lottie.model.xr.x xVar = this.re.ms().get(i);
                Path pathAb = this.re.xr().get(i).ab();
                if (pathAb != null) {
                    this.ny.set(pathAb);
                    this.ny.transform(matrix);
                    int i2 = AnonymousClass2.xr[xVar.ms().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        return;
                    }
                    if ((i2 == 3 || i2 == 4) && xVar.d()) {
                        return;
                    }
                    this.ny.computeBounds(this.nw, false);
                    if (i == 0) {
                        this.y.set(this.nw);
                    } else {
                        RectF rectF2 = this.y;
                        rectF2.set(Math.min(rectF2.left, this.nw.left), Math.min(this.y.top, this.nw.top), Math.max(this.y.right, this.nw.right), Math.max(this.y.bottom, this.nw.bottom));
                    }
                }
            }
            if (rectF.intersect(this.y)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.lottie.model.layer.ah$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        static final /* synthetic */ int[] f185ms;
        static final /* synthetic */ int[] xr;

        static {
            int[] iArr = new int[com.bytedance.adsdk.lottie.model.xr.x.ms.values().length];
            xr = iArr;
            try {
                iArr[com.bytedance.adsdk.lottie.model.xr.x.ms.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                xr[com.bytedance.adsdk.lottie.model.xr.x.ms.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                xr[com.bytedance.adsdk.lottie.model.xr.x.ms.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                xr[com.bytedance.adsdk.lottie.model.xr.x.ms.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[x.ms.values().length];
            f185ms = iArr2;
            try {
                iArr2[x.ms.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f185ms[x.ms.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f185ms[x.ms.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f185ms[x.ms.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f185ms[x.ms.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f185ms[x.ms.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f185ms[x.ms.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    private void xr(RectF rectF, Matrix matrix) {
        if (ka() && this.ah.sl() != x.xr.INVERT) {
            this.t.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.w.ms(this.t, matrix, true);
            if (rectF.intersect(this.t)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public float x() {
        return this.pc;
    }

    protected void ms(int i) {
        this.pc = ((this.d.ms() != null ? this.d.ms().ab().intValue() : 100) / 100.0f) * (i / 255.0f);
    }

    public void xr(Canvas canvas, Matrix matrix, int i) {
        ms(i);
    }

    private void ms(Canvas canvas, Matrix matrix) {
        com.bytedance.adsdk.lottie.ka.ms("Layer#saveLayer");
        com.bytedance.adsdk.lottie.ka.ny.ms(canvas, this.h, this.zb, 19);
        if (Build.VERSION.SDK_INT < 28) {
            ms(canvas);
        }
        com.bytedance.adsdk.lottie.ka.xr("Layer#saveLayer");
        for (int i = 0; i < this.re.ms().size(); i++) {
            com.bytedance.adsdk.lottie.model.xr.x xVar = this.re.ms().get(i);
            com.bytedance.adsdk.lottie.ms.xr.ms<com.bytedance.adsdk.lottie.model.xr.u, Path> msVar = this.re.xr().get(i);
            com.bytedance.adsdk.lottie.ms.xr.ms<Integer, Integer> msVar2 = this.re.ah().get(i);
            int i2 = AnonymousClass2.xr[xVar.ms().ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    if (i == 0) {
                        this.sl.setColor(ViewCompat.MEASURED_STATE_MASK);
                        this.sl.setAlpha(255);
                        canvas.drawRect(this.h, this.sl);
                    }
                    if (xVar.d()) {
                        ah(canvas, matrix, msVar, msVar2);
                    } else {
                        ms(canvas, matrix, msVar);
                    }
                } else if (i2 != 3) {
                    if (i2 == 4) {
                        if (xVar.d()) {
                            xr(canvas, matrix, msVar, msVar2);
                        } else {
                            ms(canvas, matrix, msVar, msVar2);
                        }
                    }
                } else if (xVar.d()) {
                    ka(canvas, matrix, msVar, msVar2);
                } else {
                    d(canvas, matrix, msVar, msVar2);
                }
            } else if (ao()) {
                this.sl.setAlpha(255);
                canvas.drawRect(this.h, this.sl);
            }
        }
        com.bytedance.adsdk.lottie.ka.ms("Layer#restoreLayer");
        canvas.restore();
        com.bytedance.adsdk.lottie.ka.xr("Layer#restoreLayer");
    }

    private boolean ao() {
        if (this.re.xr().isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.re.ms().size(); i++) {
            if (this.re.ms().get(i).ms() != com.bytedance.adsdk.lottie.model.xr.x.ms.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    private void ms(Canvas canvas, Matrix matrix, com.bytedance.adsdk.lottie.ms.xr.ms<com.bytedance.adsdk.lottie.model.xr.u, Path> msVar, com.bytedance.adsdk.lottie.ms.xr.ms<Integer, Integer> msVar2) {
        this.ny.set(msVar.ab());
        this.ny.transform(matrix);
        this.sl.setAlpha((int) (msVar2.ab().intValue() * 2.55f));
        canvas.drawPath(this.ny, this.sl);
    }

    private void xr(Canvas canvas, Matrix matrix, com.bytedance.adsdk.lottie.ms.xr.ms<com.bytedance.adsdk.lottie.model.xr.u, Path> msVar, com.bytedance.adsdk.lottie.ms.xr.ms<Integer, Integer> msVar2) {
        com.bytedance.adsdk.lottie.ka.ny.ms(canvas, this.h, this.sl);
        canvas.drawRect(this.h, this.sl);
        this.ny.set(msVar.ab());
        this.ny.transform(matrix);
        this.sl.setAlpha((int) (msVar2.ab().intValue() * 2.55f));
        canvas.drawPath(this.ny, this.u);
        canvas.restore();
    }

    private void ms(Canvas canvas, Matrix matrix, com.bytedance.adsdk.lottie.ms.xr.ms<com.bytedance.adsdk.lottie.model.xr.u, Path> msVar) {
        this.ny.set(msVar.ab());
        this.ny.transform(matrix);
        canvas.drawPath(this.ny, this.u);
    }

    private void ah(Canvas canvas, Matrix matrix, com.bytedance.adsdk.lottie.ms.xr.ms<com.bytedance.adsdk.lottie.model.xr.u, Path> msVar, com.bytedance.adsdk.lottie.ms.xr.ms<Integer, Integer> msVar2) {
        com.bytedance.adsdk.lottie.ka.ny.ms(canvas, this.h, this.u);
        canvas.drawRect(this.h, this.sl);
        this.u.setAlpha((int) (msVar2.ab().intValue() * 2.55f));
        this.ny.set(msVar.ab());
        this.ny.transform(matrix);
        canvas.drawPath(this.ny, this.u);
        canvas.restore();
    }

    private void d(Canvas canvas, Matrix matrix, com.bytedance.adsdk.lottie.ms.xr.ms<com.bytedance.adsdk.lottie.model.xr.u, Path> msVar, com.bytedance.adsdk.lottie.ms.xr.ms<Integer, Integer> msVar2) {
        com.bytedance.adsdk.lottie.ka.ny.ms(canvas, this.h, this.zb);
        this.ny.set(msVar.ab());
        this.ny.transform(matrix);
        this.sl.setAlpha((int) (msVar2.ab().intValue() * 2.55f));
        canvas.drawPath(this.ny, this.sl);
        canvas.restore();
    }

    private void ka(Canvas canvas, Matrix matrix, com.bytedance.adsdk.lottie.ms.xr.ms<com.bytedance.adsdk.lottie.model.xr.u, Path> msVar, com.bytedance.adsdk.lottie.ms.xr.ms<Integer, Integer> msVar2) {
        com.bytedance.adsdk.lottie.ka.ny.ms(canvas, this.h, this.zb);
        canvas.drawRect(this.h, this.sl);
        this.u.setAlpha((int) (msVar2.ab().intValue() * 2.55f));
        this.ny.set(msVar.ab());
        this.ny.transform(matrix);
        canvas.drawPath(this.ny, this.u);
        canvas.restore();
    }

    boolean ny() {
        com.bytedance.adsdk.lottie.ms.xr.x xVar = this.re;
        return (xVar == null || xVar.xr().isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(boolean z) {
        if (z != this.cv) {
            this.cv = z;
            ub();
        }
    }

    public boolean ch() {
        return this.cv;
    }

    void ms(float f) {
        this.d.ms(f);
        if (this.re != null) {
            for (int i = 0; i < this.re.xr().size(); i++) {
                this.re.xr().get(i).ms(f);
            }
        }
        com.bytedance.adsdk.lottie.ms.xr.d dVar = this.i;
        if (dVar != null) {
            dVar.ms(f);
        }
        ah ahVar = this.w;
        if (ahVar != null) {
            ahVar.ms(f);
        }
        for (int i2 = 0; i2 < this.le.size(); i2++) {
            this.le.get(i2).ms(f);
        }
    }

    private void h() {
        if (this.op != null) {
            return;
        }
        if (this.yu == null) {
            this.op = Collections.emptyList();
            return;
        }
        this.op = new ArrayList();
        for (ah ahVar = this.yu; ahVar != null; ahVar = ahVar.yu) {
            this.op.add(ahVar);
        }
    }

    public String hi() {
        return this.ah.c();
    }

    public com.bytedance.adsdk.lottie.model.xr.ms sl() {
        return this.ah.re();
    }

    public BlurMaskFilter xr(float f) {
        if (this.ka == f) {
            return this.c;
        }
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(f / 2.0f, BlurMaskFilter.Blur.NORMAL);
        this.c = blurMaskFilter;
        this.ka = f;
        return blurMaskFilter;
    }

    public com.bytedance.adsdk.lottie.d.ch zb() {
        return this.ah.i();
    }
}
