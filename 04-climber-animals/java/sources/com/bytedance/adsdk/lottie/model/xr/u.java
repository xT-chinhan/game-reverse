package com.bytedance.adsdk.lottie.model.xr;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class u {
    private boolean ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final List<com.bytedance.adsdk.lottie.model.ms> f233ms;
    private PointF xr;

    public u(PointF pointF, boolean z, List<com.bytedance.adsdk.lottie.model.ms> list) {
        this.xr = pointF;
        this.ah = z;
        this.f233ms = new ArrayList(list);
    }

    public u() {
        this.f233ms = new ArrayList();
    }

    public void ms(float f, float f2) {
        if (this.xr == null) {
            this.xr = new PointF();
        }
        this.xr.set(f, f2);
    }

    public PointF ms() {
        return this.xr;
    }

    public void ms(boolean z) {
        this.ah = z;
    }

    public boolean xr() {
        return this.ah;
    }

    public List<com.bytedance.adsdk.lottie.model.ms> ah() {
        return this.f233ms;
    }

    public void ms(u uVar, u uVar2, float f) {
        if (this.xr == null) {
            this.xr = new PointF();
        }
        this.ah = uVar.xr() || uVar2.xr();
        if (uVar.ah().size() != uVar2.ah().size()) {
            com.bytedance.adsdk.lottie.ka.ka.xr("Curves must have the same number of control points. Shape 1: " + uVar.ah().size() + "\tShape 2: " + uVar2.ah().size());
        }
        int iMin = Math.min(uVar.ah().size(), uVar2.ah().size());
        if (this.f233ms.size() < iMin) {
            for (int size = this.f233ms.size(); size < iMin; size++) {
                this.f233ms.add(new com.bytedance.adsdk.lottie.model.ms());
            }
        } else if (this.f233ms.size() > iMin) {
            for (int size2 = this.f233ms.size() - 1; size2 >= iMin; size2--) {
                List<com.bytedance.adsdk.lottie.model.ms> list = this.f233ms;
                list.remove(list.size() - 1);
            }
        }
        PointF pointFMs = uVar.ms();
        PointF pointFMs2 = uVar2.ms();
        ms(com.bytedance.adsdk.lottie.ka.x.ms(pointFMs.x, pointFMs2.x, f), com.bytedance.adsdk.lottie.ka.x.ms(pointFMs.y, pointFMs2.y, f));
        for (int size3 = this.f233ms.size() - 1; size3 >= 0; size3--) {
            com.bytedance.adsdk.lottie.model.ms msVar = uVar.ah().get(size3);
            com.bytedance.adsdk.lottie.model.ms msVar2 = uVar2.ah().get(size3);
            PointF pointFMs3 = msVar.ms();
            PointF pointFXr = msVar.xr();
            PointF pointFAh = msVar.ah();
            PointF pointFMs4 = msVar2.ms();
            PointF pointFXr2 = msVar2.xr();
            PointF pointFAh2 = msVar2.ah();
            this.f233ms.get(size3).ms(com.bytedance.adsdk.lottie.ka.x.ms(pointFMs3.x, pointFMs4.x, f), com.bytedance.adsdk.lottie.ka.x.ms(pointFMs3.y, pointFMs4.y, f));
            this.f233ms.get(size3).xr(com.bytedance.adsdk.lottie.ka.x.ms(pointFXr.x, pointFXr2.x, f), com.bytedance.adsdk.lottie.ka.x.ms(pointFXr.y, pointFXr2.y, f));
            this.f233ms.get(size3).ah(com.bytedance.adsdk.lottie.ka.x.ms(pointFAh.x, pointFAh2.x, f), com.bytedance.adsdk.lottie.ka.x.ms(pointFAh.y, pointFAh2.y, f));
        }
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.f233ms.size() + "closed=" + this.ah + AbstractJsonLexerKt.END_OBJ;
    }
}
