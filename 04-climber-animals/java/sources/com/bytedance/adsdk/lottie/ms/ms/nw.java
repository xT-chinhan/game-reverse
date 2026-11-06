package com.bytedance.adsdk.lottie.ms.ms;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class nw implements ah, com.bytedance.adsdk.lottie.ms.xr.ms.InterfaceC0189ms {
    private final com.bytedance.adsdk.lottie.ms.xr.ms<?, Float> ab;
    private final List<com.bytedance.adsdk.lottie.ms.xr.ms.InterfaceC0189ms> ah = new ArrayList();
    private final com.bytedance.adsdk.lottie.ms.xr.ms<?, Float> c;
    private final com.bytedance.adsdk.lottie.model.xr.y.ms d;
    private final com.bytedance.adsdk.lottie.ms.xr.ms<?, Float> ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final String f250ms;
    private final boolean xr;

    @Override // com.bytedance.adsdk.lottie.ms.ms.ah
    public void ms(List<ah> list, List<ah> list2) {
    }

    public nw(com.bytedance.adsdk.lottie.model.layer.ah ahVar, com.bytedance.adsdk.lottie.model.xr.y yVar) {
        this.f250ms = yVar.ms();
        this.xr = yVar.ka();
        this.d = yVar.getType();
        com.bytedance.adsdk.lottie.ms.xr.ms<Float, Float> msVarMs = yVar.ah().ms();
        this.ka = msVarMs;
        com.bytedance.adsdk.lottie.ms.xr.ms<Float, Float> msVarMs2 = yVar.xr().ms();
        this.c = msVarMs2;
        com.bytedance.adsdk.lottie.ms.xr.ms<Float, Float> msVarMs3 = yVar.d().ms();
        this.ab = msVarMs3;
        ahVar.ms(msVarMs);
        ahVar.ms(msVarMs2);
        ahVar.ms(msVarMs3);
        msVarMs.ms(this);
        msVarMs2.ms(this);
        msVarMs3.ms(this);
    }

    @Override // com.bytedance.adsdk.lottie.ms.xr.ms.InterfaceC0189ms
    public void ms() {
        for (int i = 0; i < this.ah.size(); i++) {
            this.ah.get(i).ms();
        }
    }

    void ms(com.bytedance.adsdk.lottie.ms.xr.ms.InterfaceC0189ms interfaceC0189ms) {
        this.ah.add(interfaceC0189ms);
    }

    com.bytedance.adsdk.lottie.model.xr.y.ms getType() {
        return this.d;
    }

    public com.bytedance.adsdk.lottie.ms.xr.ms<?, Float> xr() {
        return this.ka;
    }

    public com.bytedance.adsdk.lottie.ms.xr.ms<?, Float> ah() {
        return this.c;
    }

    public com.bytedance.adsdk.lottie.ms.xr.ms<?, Float> d() {
        return this.ab;
    }

    public boolean ka() {
        return this.xr;
    }
}
