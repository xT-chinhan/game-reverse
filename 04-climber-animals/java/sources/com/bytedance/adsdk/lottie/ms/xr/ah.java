package com.bytedance.adsdk.lottie.ms.xr;

import android.graphics.Color;
import android.graphics.Paint;

/* JADX INFO: loaded from: classes2.dex */
public class ah implements ms.InterfaceC0189ms {
    private boolean ab = true;
    private final ms<Float, Float> ah;
    private final ms<Float, Float> c;
    private final ms<Float, Float> d;
    private final ms<Float, Float> ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final ms.InterfaceC0189ms f259ms;
    private final ms<Integer, Integer> xr;

    public ah(ms.InterfaceC0189ms interfaceC0189ms, com.bytedance.adsdk.lottie.model.layer.ah ahVar, com.bytedance.adsdk.lottie.d.ch chVar) {
        this.f259ms = interfaceC0189ms;
        ms<Integer, Integer> msVarMs = chVar.ms().ms();
        this.xr = msVarMs;
        msVarMs.ms(this);
        ahVar.ms(msVarMs);
        ms<Float, Float> msVarMs2 = chVar.xr().ms();
        this.ah = msVarMs2;
        msVarMs2.ms(this);
        ahVar.ms(msVarMs2);
        ms<Float, Float> msVarMs3 = chVar.ah().ms();
        this.d = msVarMs3;
        msVarMs3.ms(this);
        ahVar.ms(msVarMs3);
        ms<Float, Float> msVarMs4 = chVar.d().ms();
        this.ka = msVarMs4;
        msVarMs4.ms(this);
        ahVar.ms(msVarMs4);
        ms<Float, Float> msVarMs5 = chVar.ka().ms();
        this.c = msVarMs5;
        msVarMs5.ms(this);
        ahVar.ms(msVarMs5);
    }

    @Override // com.bytedance.adsdk.lottie.ms.xr.ms.InterfaceC0189ms
    public void ms() {
        this.ab = true;
        this.f259ms.ms();
    }

    public void ms(Paint paint) {
        if (this.ab) {
            this.ab = false;
            double dFloatValue = ((double) this.d.ab().floatValue()) * 0.017453292519943295d;
            float fFloatValue = this.ka.ab().floatValue();
            float fSin = ((float) Math.sin(dFloatValue)) * fFloatValue;
            float fCos = ((float) Math.cos(dFloatValue + 3.141592653589793d)) * fFloatValue;
            int iIntValue = this.xr.ab().intValue();
            paint.setShadowLayer(this.c.ab().floatValue(), fSin, fCos, Color.argb(Math.round(this.ah.ab().floatValue()), Color.red(iIntValue), Color.green(iIntValue), Color.blue(iIntValue)));
        }
    }
}
