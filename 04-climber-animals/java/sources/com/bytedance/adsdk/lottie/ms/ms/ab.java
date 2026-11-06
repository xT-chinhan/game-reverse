package com.bytedance.adsdk.lottie.ms.ms;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ab implements hi, ka, com.bytedance.adsdk.lottie.ms.xr.ms.InterfaceC0189ms {
    private final List<zb> ab;
    private final Paint ah;
    private final boolean c;
    private com.bytedance.adsdk.lottie.ms.xr.ms<ColorFilter, ColorFilter> ch;
    private final com.bytedance.adsdk.lottie.model.layer.ah d;
    private final com.bytedance.adsdk.lottie.x hi;
    private final String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    float f243ms;
    private final com.bytedance.adsdk.lottie.ms.xr.ms<Integer, Integer> ny;
    private com.bytedance.adsdk.lottie.ms.xr.ms<Float, Float> sl;
    private final com.bytedance.adsdk.lottie.ms.xr.ms<Integer, Integer> x;
    private final Path xr;
    private com.bytedance.adsdk.lottie.ms.xr.ah zb;

    public ab(com.bytedance.adsdk.lottie.x xVar, com.bytedance.adsdk.lottie.model.layer.ah ahVar, com.bytedance.adsdk.lottie.model.xr.ub ubVar) {
        Path path = new Path();
        this.xr = path;
        this.ah = new com.bytedance.adsdk.lottie.ms.ms(1);
        this.ab = new ArrayList();
        this.d = ahVar;
        this.ka = ubVar.ms();
        this.c = ubVar.ka();
        this.hi = xVar;
        if (ahVar.sl() != null) {
            com.bytedance.adsdk.lottie.ms.xr.ms<Float, Float> msVarMs = ahVar.sl().ms().ms();
            this.sl = msVarMs;
            msVarMs.ms(this);
            ahVar.ms(this.sl);
        }
        if (ahVar.zb() != null) {
            this.zb = new com.bytedance.adsdk.lottie.ms.xr.ah(this, ahVar, ahVar.zb());
        }
        if (ubVar.xr() == null || ubVar.ah() == null) {
            this.x = null;
            this.ny = null;
            return;
        }
        path.setFillType(ubVar.d());
        com.bytedance.adsdk.lottie.ms.xr.ms<Integer, Integer> msVarMs2 = ubVar.xr().ms();
        this.x = msVarMs2;
        msVarMs2.ms(this);
        ahVar.ms(msVarMs2);
        com.bytedance.adsdk.lottie.ms.xr.ms<Integer, Integer> msVarMs3 = ubVar.ah().ms();
        this.ny = msVarMs3;
        msVarMs3.ms(this);
        ahVar.ms(msVarMs3);
    }

    @Override // com.bytedance.adsdk.lottie.ms.xr.ms.InterfaceC0189ms
    public void ms() {
        this.hi.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.lottie.ms.ms.ah
    public void ms(List<ah> list, List<ah> list2) {
        for (int i = 0; i < list2.size(); i++) {
            ah ahVar = list2.get(i);
            if (ahVar instanceof zb) {
                this.ab.add((zb) ahVar);
            }
        }
    }

    @Override // com.bytedance.adsdk.lottie.ms.ms.ka
    public void ms(Canvas canvas, Matrix matrix, int i) {
        if (this.c) {
            return;
        }
        com.bytedance.adsdk.lottie.ka.ms("FillContent#draw");
        this.ah.setColor((com.bytedance.adsdk.lottie.ka.x.ms((int) ((((i / 255.0f) * this.ny.ab().intValue()) / 100.0f) * 255.0f), 0, 255) << 24) | (((com.bytedance.adsdk.lottie.ms.xr.xr) this.x).ny() & ViewCompat.MEASURED_SIZE_MASK));
        com.bytedance.adsdk.lottie.ms.xr.ms<ColorFilter, ColorFilter> msVar = this.ch;
        if (msVar != null) {
            this.ah.setColorFilter(msVar.ab());
        }
        com.bytedance.adsdk.lottie.ms.xr.ms<Float, Float> msVar2 = this.sl;
        if (msVar2 != null) {
            float fFloatValue = msVar2.ab().floatValue();
            if (fFloatValue == 0.0f) {
                this.ah.setMaskFilter(null);
            } else if (fFloatValue != this.f243ms) {
                this.ah.setMaskFilter(this.d.xr(fFloatValue));
            }
            this.f243ms = fFloatValue;
        }
        com.bytedance.adsdk.lottie.ms.xr.ah ahVar = this.zb;
        if (ahVar != null) {
            ahVar.ms(this.ah);
        }
        this.xr.reset();
        for (int i2 = 0; i2 < this.ab.size(); i2++) {
            this.xr.addPath(this.ab.get(i2).d(), matrix);
        }
        canvas.drawPath(this.xr, this.ah);
        com.bytedance.adsdk.lottie.ka.xr("FillContent#draw");
    }

    @Override // com.bytedance.adsdk.lottie.ms.ms.ka
    public void ms(RectF rectF, Matrix matrix, boolean z) {
        this.xr.reset();
        for (int i = 0; i < this.ab.size(); i++) {
            this.xr.addPath(this.ab.get(i).d(), matrix);
        }
        this.xr.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }
}
