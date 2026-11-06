package com.bytedance.adsdk.lottie.ms.ms;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes2.dex */
public class ao implements ch, hi, ka, zb, com.bytedance.adsdk.lottie.ms.xr.ms.InterfaceC0189ms {
    private final com.bytedance.adsdk.lottie.ms.xr.ms<Float, Float> ab;
    private final com.bytedance.adsdk.lottie.x ah;
    private final boolean c;
    private d ch;
    private final com.bytedance.adsdk.lottie.model.layer.ah d;
    private final String ka;
    private final com.bytedance.adsdk.lottie.ms.xr.ao ny;
    private final com.bytedance.adsdk.lottie.ms.xr.ms<Float, Float> x;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Matrix f244ms = new Matrix();
    private final Path xr = new Path();

    public ao(com.bytedance.adsdk.lottie.x xVar, com.bytedance.adsdk.lottie.model.layer.ah ahVar, com.bytedance.adsdk.lottie.model.xr.sl slVar) {
        this.ah = xVar;
        this.d = ahVar;
        this.ka = slVar.ms();
        this.c = slVar.ka();
        com.bytedance.adsdk.lottie.ms.xr.ms<Float, Float> msVarMs = slVar.xr().ms();
        this.ab = msVarMs;
        ahVar.ms(msVarMs);
        msVarMs.ms(this);
        com.bytedance.adsdk.lottie.ms.xr.ms<Float, Float> msVarMs2 = slVar.ah().ms();
        this.x = msVarMs2;
        ahVar.ms(msVarMs2);
        msVarMs2.ms(this);
        com.bytedance.adsdk.lottie.ms.xr.ao aoVarCh = slVar.d().ch();
        this.ny = aoVarCh;
        aoVarCh.ms(ahVar);
        aoVarCh.ms(this);
    }

    @Override // com.bytedance.adsdk.lottie.ms.ms.ch
    public void ms(ListIterator<ah> listIterator) {
        if (this.ch != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.ch = new d(this.ah, this.d, "Repeater", this.c, arrayList, null);
    }

    @Override // com.bytedance.adsdk.lottie.ms.ms.ah
    public void ms(List<ah> list, List<ah> list2) {
        this.ch.ms(list, list2);
    }

    @Override // com.bytedance.adsdk.lottie.ms.ms.zb
    public Path d() {
        Path pathD = this.ch.d();
        this.xr.reset();
        float fFloatValue = this.ab.ab().floatValue();
        float fFloatValue2 = this.x.ab().floatValue();
        for (int i = ((int) fFloatValue) - 1; i >= 0; i--) {
            this.f244ms.set(this.ny.xr(i + fFloatValue2));
            this.xr.addPath(pathD, this.f244ms);
        }
        return this.xr;
    }

    @Override // com.bytedance.adsdk.lottie.ms.ms.ka
    public void ms(Canvas canvas, Matrix matrix, int i) {
        float fFloatValue = this.ab.ab().floatValue();
        float fFloatValue2 = this.x.ab().floatValue();
        float fFloatValue3 = this.ny.xr().ab().floatValue() / 100.0f;
        float fFloatValue4 = this.ny.ah().ab().floatValue() / 100.0f;
        for (int i2 = ((int) fFloatValue) - 1; i2 >= 0; i2--) {
            this.f244ms.set(matrix);
            float f = i2;
            this.f244ms.preConcat(this.ny.xr(f + fFloatValue2));
            this.ch.ms(canvas, this.f244ms, (int) (i * com.bytedance.adsdk.lottie.ka.x.ms(fFloatValue3, fFloatValue4, f / fFloatValue)));
        }
    }

    @Override // com.bytedance.adsdk.lottie.ms.ms.ka
    public void ms(RectF rectF, Matrix matrix, boolean z) {
        this.ch.ms(rectF, matrix, z);
    }

    @Override // com.bytedance.adsdk.lottie.ms.xr.ms.InterfaceC0189ms
    public void ms() {
        this.ah.invalidateSelf();
    }
}
