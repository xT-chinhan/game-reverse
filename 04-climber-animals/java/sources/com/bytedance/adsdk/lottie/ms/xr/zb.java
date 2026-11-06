package com.bytedance.adsdk.lottie.ms.xr;

import android.graphics.Path;
import com.bytedance.adsdk.lottie.ms.ms.y;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class zb extends ms<com.bytedance.adsdk.lottie.model.xr.u, Path> {
    private List<y> c;
    private final com.bytedance.adsdk.lottie.model.xr.u d;
    private final Path ka;

    public zb(List<com.bytedance.adsdk.lottie.c.ms<com.bytedance.adsdk.lottie.model.xr.u>> list) {
        super(list);
        this.d = new com.bytedance.adsdk.lottie.model.xr.u();
        this.ka = new Path();
    }

    @Override // com.bytedance.adsdk.lottie.ms.xr.ms
    /* JADX INFO: renamed from: xr, reason: merged with bridge method [inline-methods] */
    public Path ms(com.bytedance.adsdk.lottie.c.ms<com.bytedance.adsdk.lottie.model.xr.u> msVar, float f) {
        this.d.ms(msVar.f150ms, msVar.xr, f);
        com.bytedance.adsdk.lottie.model.xr.u uVarMs = this.d;
        List<y> list = this.c;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                uVarMs = this.c.get(size).ms(uVarMs);
            }
        }
        com.bytedance.adsdk.lottie.ka.x.ms(uVarMs, this.ka);
        return this.ka;
    }

    public void ms(List<y> list) {
        this.c = list;
    }
}
