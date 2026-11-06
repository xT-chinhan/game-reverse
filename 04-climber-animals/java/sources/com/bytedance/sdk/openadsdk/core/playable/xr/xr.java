package com.bytedance.sdk.openadsdk.core.playable.xr;

import android.app.Activity;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.lm;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    private boolean d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private boolean f3290ms;
    private long xr = 0;
    private long ah = 0;

    public xr(String str) {
        this.d = "rewarded_video".equalsIgnoreCase(str) || "fullscreen_interstitial_ad".equalsIgnoreCase(str);
    }

    public void ms(final Activity activity, lm lmVar) {
        if (activity == null || lmVar == null || !lmVar.ny()) {
            return;
        }
        ul.ah(activity);
        try {
            final View decorView = activity.getWindow().getDecorView();
            decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.playable.xr.xr.1
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    if (i == 0) {
                        xr.this.ms();
                        try {
                            if (activity.isFinishing()) {
                                return;
                            }
                            decorView.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.playable.xr.xr.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ul.ah(activity);
                                }
                            }, 5000L);
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public void ms(int i) {
        boolean z = i == 4;
        this.f3290ms = z;
        if (z) {
            this.xr = System.currentTimeMillis();
        }
    }

    public boolean xr(Activity activity, lm lmVar) {
        boolean zMs = false;
        if (activity != null && lmVar != null) {
            boolean z = this.f3290ms;
            this.f3290ms = false;
            if (!lmVar.ny() || !z) {
                return false;
            }
            if (ms.ms(activity) || xr()) {
                return true;
            }
            try {
                if (!this.d || !ms.ms()) {
                    zMs = ms(activity);
                }
            } catch (Throwable unused) {
            }
        }
        return zMs;
    }

    public void ms() {
        this.ah = System.currentTimeMillis();
    }

    private boolean ms(Activity activity) {
        return (activity.getWindow().getDecorView().getSystemUiVisibility() & 2) == 2;
    }

    private boolean xr() {
        long j = this.xr;
        long jAbs = j > 0 ? Math.abs(j - this.ah) : -1L;
        return jAbs >= 0 && jAbs < 300;
    }
}
