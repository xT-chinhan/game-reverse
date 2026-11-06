package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.LongSparseArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class d extends ah {
    private com.bytedance.adsdk.lottie.ms.xr.ms<Float, Float> ab;
    private final RectF ch;
    private final Paint hi;
    private final RectF ny;
    private boolean sl;
    private final List<ah> x;

    public d(com.bytedance.adsdk.lottie.x xVar, x xVar2, List<x> list, com.bytedance.adsdk.lottie.c cVar, Context context) {
        int i;
        ah ahVar;
        x.xr xrVarSl;
        int i2;
        super(xVar, xVar2);
        this.x = new ArrayList();
        this.ny = new RectF();
        this.ch = new RectF();
        this.hi = new Paint();
        this.sl = true;
        com.bytedance.adsdk.lottie.model.ms.xr xrVarNw = xVar2.nw();
        if (xrVarNw != null) {
            com.bytedance.adsdk.lottie.ms.xr.ms<Float, Float> msVarMs = xrVarNw.ms();
            this.ab = msVarMs;
            ms(msVarMs);
            this.ab.ms(this);
        } else {
            this.ab = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(cVar.u().size());
        int size = list.size() - 1;
        ah ahVar2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            x xVar3 = list.get(size);
            ah ahVarMs = ah.ms(this, xVar3, xVar, cVar, context);
            if (ahVarMs != null) {
                longSparseArray.put(ahVarMs.d().ka(), ahVarMs);
                if (ahVar2 != null) {
                    ahVar2.ms(ahVarMs);
                    ahVar2 = null;
                } else {
                    this.x.add(0, ahVarMs);
                    if (xVar3 != null && (xrVarSl = xVar3.sl()) != null && ((i2 = AnonymousClass1.f186ms[xrVarSl.ordinal()]) == 1 || i2 == 2)) {
                        ahVar2 = ahVarMs;
                    }
                }
            }
            size--;
        }
        for (i = 0; i < longSparseArray.size(); i++) {
            ah ahVar3 = (ah) longSparseArray.get(longSparseArray.keyAt(i));
            if (ahVar3 != null && (ahVar = (ah) longSparseArray.get(ahVar3.d().zb())) != null) {
                ahVar3.xr(ahVar);
            }
        }
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.lottie.model.layer.d$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        static final /* synthetic */ int[] f186ms;

        static {
            int[] iArr = new int[x.xr.values().length];
            f186ms = iArr;
            try {
                iArr[x.xr.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f186ms[x.xr.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public void xr(boolean z) {
        this.sl = z;
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.ah
    public void ms(boolean z) {
        super.ms(z);
        Iterator<ah> it = this.x.iterator();
        while (it.hasNext()) {
            it.next().ms(z);
        }
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.ah
    public void xr(Canvas canvas, Matrix matrix, int i) {
        super.xr(canvas, matrix, i);
        com.bytedance.adsdk.lottie.ka.ms("CompositionLayer#draw");
        this.ch.set(0.0f, 0.0f, this.ah.x(), this.ah.ny());
        matrix.mapRect(this.ch);
        boolean z = this.xr.ch() && this.x.size() > 1 && i != 255;
        if (z) {
            this.hi.setAlpha(i);
            com.bytedance.adsdk.lottie.ka.ny.ms(canvas, this.ch, this.hi);
        } else {
            canvas.save();
        }
        if (z) {
            i = 255;
        }
        for (int size = this.x.size() - 1; size >= 0; size--) {
            if (((!this.sl && "__container".equals(this.ah.c())) || this.ch.isEmpty()) ? true : canvas.clipRect(this.ch)) {
                this.x.get(size).ms(canvas, matrix, i);
            }
        }
        canvas.restore();
        com.bytedance.adsdk.lottie.ka.xr("CompositionLayer#draw");
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.ah, com.bytedance.adsdk.lottie.ms.ms.ka
    public void ms(RectF rectF, Matrix matrix, boolean z) {
        super.ms(rectF, matrix, z);
        for (int size = this.x.size() - 1; size >= 0; size--) {
            this.ny.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.x.get(size).ms(this.ny, this.f183ms, true);
            rectF.union(this.ny);
        }
    }

    public List<ah> u() {
        return this.x;
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.ah
    public void ms(float f) {
        super.ms(f);
        if (this.ab != null) {
            f = ((this.ab.ab().floatValue() * this.ah.ms().zb()) - this.ah.ms().c()) / (this.xr.op().qv() + 0.01f);
        }
        if (this.ab == null) {
            f -= this.ah.ah();
        }
        if (this.ah.xr() != 0.0f && !"__container".equals(this.ah.c())) {
            f /= this.ah.xr();
        }
        for (int size = this.x.size() - 1; size >= 0; size--) {
            this.x.get(size).ms(f);
        }
    }
}
