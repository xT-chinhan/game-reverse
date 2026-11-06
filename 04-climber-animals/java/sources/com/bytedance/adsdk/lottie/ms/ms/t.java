package com.bytedance.adsdk.lottie.ms.ms;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;

/* JADX INFO: loaded from: classes2.dex */
public class t extends ms {
    private final com.bytedance.adsdk.lottie.ms.xr.ms<Integer, Integer> ab;
    private final boolean c;
    private final com.bytedance.adsdk.lottie.model.layer.ah d;
    private final String ka;
    private com.bytedance.adsdk.lottie.ms.xr.ms<ColorFilter, ColorFilter> x;

    public t(com.bytedance.adsdk.lottie.x xVar, com.bytedance.adsdk.lottie.model.layer.ah ahVar, com.bytedance.adsdk.lottie.model.xr.qv qvVar) {
        super(xVar, ahVar, qvVar.ab().ms(), qvVar.x().ms(), qvVar.ny(), qvVar.ah(), qvVar.d(), qvVar.ka(), qvVar.c());
        this.d = ahVar;
        this.ka = qvVar.ms();
        this.c = qvVar.ch();
        com.bytedance.adsdk.lottie.ms.xr.ms<Integer, Integer> msVarMs = qvVar.xr().ms();
        this.ab = msVarMs;
        msVarMs.ms(this);
        ahVar.ms(msVarMs);
    }

    @Override // com.bytedance.adsdk.lottie.ms.ms.ms, com.bytedance.adsdk.lottie.ms.ms.ka
    public void ms(Canvas canvas, Matrix matrix, int i) {
        if (this.c) {
            return;
        }
        this.xr.setColor(((com.bytedance.adsdk.lottie.ms.xr.xr) this.ab).ny());
        if (this.x != null) {
            this.xr.setColorFilter(this.x.ab());
        }
        super.ms(canvas, matrix, i);
    }
}
