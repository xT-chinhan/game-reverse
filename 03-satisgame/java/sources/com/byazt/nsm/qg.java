package com.byazt.nsm;

import android.app.Activity;
import android.view.View;
import com.byazt.gct.pk;
import com.byazt.okk.s;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 723, 26})
public class qg {
    public boolean n;
    public boolean q;
    public long qg = 0;
    public long s = 0;

    public qg(String str) {
        this.q = "rewarded_video".equalsIgnoreCase(str) || "fullscreen_interstitial_ad".equalsIgnoreCase(str);
    }

    public void n(final Activity activity, pk pkVar) {
        if (activity == null || pkVar == null || !pkVar.f()) {
            return;
        }
        s.s(activity);
        try {
            final View decorView = activity.getWindow().getDecorView();
            decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.byazt.nsm.qg.1
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    if (i == 0) {
                        qg.this.n();
                        try {
                            if (activity.isFinishing()) {
                                return;
                            }
                            decorView.postDelayed(new Runnable() { // from class: com.byazt.nsm.qg.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    s.s(activity);
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

    public void n(int i) {
        boolean z = i == 4;
        this.n = z;
        if (z) {
            this.qg = System.currentTimeMillis();
        }
    }

    public boolean qg(Activity activity, pk pkVar) {
        boolean zN = false;
        if (activity != null && pkVar != null) {
            boolean z = this.n;
            this.n = false;
            if (!pkVar.f() || !z) {
                return false;
            }
            if (n.n(activity) || qg()) {
                return true;
            }
            try {
                if (!this.q || !n.n()) {
                    zN = n(activity);
                }
            } catch (Throwable unused) {
            }
        }
        return zN;
    }

    public void n() {
        this.s = System.currentTimeMillis();
    }

    private boolean n(Activity activity) {
        return (activity.getWindow().getDecorView().getSystemUiVisibility() & 2) == 2;
    }

    private boolean qg() {
        long j = this.qg;
        long jAbs = j > 0 ? Math.abs(j - this.s) : -1L;
        return jAbs >= 0 && jAbs < 300;
    }
}
