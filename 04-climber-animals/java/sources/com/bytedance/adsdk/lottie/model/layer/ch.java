package com.bytedance.adsdk.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.bytedance.adsdk.lottie.model.xr.ao;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public class ch extends ah {
    private final com.bytedance.adsdk.lottie.ms.ms.d ab;
    private final d x;

    ch(com.bytedance.adsdk.lottie.x xVar, x xVar2, d dVar, com.bytedance.adsdk.lottie.c cVar) {
        super(xVar, xVar2);
        this.x = dVar;
        com.bytedance.adsdk.lottie.ms.ms.d dVar2 = new com.bytedance.adsdk.lottie.ms.ms.d(xVar, this, new ao("__container", xVar2.u(), false), cVar);
        this.ab = dVar2;
        dVar2.ms(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.ah
    public void xr(Canvas canvas, Matrix matrix, int i) {
        super.xr(canvas, matrix, i);
        this.ab.ms(canvas, matrix, i);
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.ah, com.bytedance.adsdk.lottie.ms.ms.ka
    public void ms(RectF rectF, Matrix matrix, boolean z) {
        super.ms(rectF, matrix, z);
        this.ab.ms(rectF, this.f183ms, z);
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.ah
    public com.bytedance.adsdk.lottie.model.xr.ms sl() {
        com.bytedance.adsdk.lottie.model.xr.ms msVarSl = super.sl();
        return msVarSl != null ? msVarSl : this.x.sl();
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.ah
    public com.bytedance.adsdk.lottie.d.ch zb() {
        com.bytedance.adsdk.lottie.d.ch chVarZb = super.zb();
        return chVarZb != null ? chVarZb : this.x.zb();
    }
}
