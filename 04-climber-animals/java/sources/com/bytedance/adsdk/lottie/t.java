package com.bytedance.adsdk.lottie;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class t {
    private final x ah;
    private boolean d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Map<String, String> f272ms;
    private final LottieAnimationView xr;

    public String ms(String str) {
        return str;
    }

    t() {
        this.f272ms = new HashMap();
        this.d = true;
        this.xr = null;
        this.ah = null;
    }

    public t(LottieAnimationView lottieAnimationView) {
        this.f272ms = new HashMap();
        this.d = true;
        this.xr = lottieAnimationView;
        this.ah = null;
    }

    public String ms(String str, String str2) {
        return ms(str2);
    }

    public void xr(String str, String str2) {
        this.f272ms.put(str, str2);
        ms();
    }

    public final String ah(String str, String str2) {
        if (this.d && this.f272ms.containsKey(str2)) {
            return this.f272ms.get(str2);
        }
        String strMs = ms(str, str2);
        if (this.d) {
            this.f272ms.put(str2, strMs);
        }
        return strMs;
    }

    private void ms() {
        LottieAnimationView lottieAnimationView = this.xr;
        if (lottieAnimationView != null) {
            lottieAnimationView.invalidate();
        }
        x xVar = this.ah;
        if (xVar != null) {
            xVar.invalidateSelf();
        }
    }
}
