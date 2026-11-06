package com.bytedance.adsdk.lottie.ms.ms;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class qv implements zb, com.bytedance.adsdk.lottie.ms.xr.ms.InterfaceC0189ms {
    private final boolean ah;
    private boolean c;
    private final com.bytedance.adsdk.lottie.x d;
    private final com.bytedance.adsdk.lottie.ms.xr.zb ka;
    private final String xr;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Path f251ms = new Path();
    private final xr ab = new xr();

    public qv(com.bytedance.adsdk.lottie.x xVar, com.bytedance.adsdk.lottie.model.layer.ah ahVar, com.bytedance.adsdk.lottie.model.xr.h hVar) {
        this.xr = hVar.ms();
        this.ah = hVar.ah();
        this.d = xVar;
        com.bytedance.adsdk.lottie.ms.xr.zb zbVarMs = hVar.xr().ms();
        this.ka = zbVarMs;
        ahVar.ms(zbVarMs);
        zbVarMs.ms(this);
    }

    @Override // com.bytedance.adsdk.lottie.ms.xr.ms.InterfaceC0189ms
    public void ms() {
        xr();
    }

    private void xr() {
        this.c = false;
        this.d.invalidateSelf();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0026  */
    /* JADX WARN: Code duplicated, block: B:12:0x002a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:13:0x002c  */
    /* JADX WARN: Code duplicated, block: B:21:0x0036 A[SYNTHETIC] */
    @Override // com.bytedance.adsdk.lottie.ms.ms.ah
    public void ms(List<ah> list, List<ah> list2) {
        ArrayList arrayList = null;
        for (int i = 0; i < list.size(); i++) {
            ah ahVar = list.get(i);
            if (ahVar instanceof nw) {
                nw nwVar = (nw) ahVar;
                if (nwVar.getType() == com.bytedance.adsdk.lottie.model.xr.y.ms.SIMULTANEOUSLY) {
                    this.ab.ms(nwVar);
                    nwVar.ms(this);
                } else if (!(ahVar instanceof y)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((y) ahVar);
                }
            } else if (!(ahVar instanceof y)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add((y) ahVar);
            }
        }
        this.ka.ms((List<y>) arrayList);
    }

    @Override // com.bytedance.adsdk.lottie.ms.ms.zb
    public Path d() {
        if (this.c) {
            return this.f251ms;
        }
        this.f251ms.reset();
        if (this.ah) {
            this.c = true;
            return this.f251ms;
        }
        Path pathAb = this.ka.ab();
        if (pathAb == null) {
            return this.f251ms;
        }
        this.f251ms.set(pathAb);
        this.f251ms.setFillType(Path.FillType.EVEN_ODD);
        this.ab.ms(this.f251ms);
        this.c = true;
        return this.f251ms;
    }
}
