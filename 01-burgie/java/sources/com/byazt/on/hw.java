package com.byazt.on;

import android.app.Activity;
import android.view.View;
import com.byazt.hg.of;
import com.byazt.wt.er;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_EANABLE_DROPPING_DTS_ROLLBACK, 13})
public class hw {
    public boolean pr;
    public boolean x;
    public long hw = 0;
    public long hn = 0;

    public hw(String str) {
        this.x = "rewarded_video".equalsIgnoreCase(str) || "fullscreen_interstitial_ad".equalsIgnoreCase(str);
    }

    public void pr(final Activity activity, of ofVar) {
        if (activity == null || ofVar == null || !ofVar.e()) {
            return;
        }
        er.hn(activity);
        try {
            final View decorView = activity.getWindow().getDecorView();
            decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.byazt.on.hw.1
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    if (i == 0) {
                        hw.this.pr();
                        try {
                            if (activity.isFinishing()) {
                                return;
                            }
                            decorView.postDelayed(new Runnable() { // from class: com.byazt.on.hw.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    er.hn(activity);
                                }
                            }, 5000L);
                        } catch (Throwable th) {
                        }
                    }
                }
            });
        } catch (Throwable th) {
        }
    }

    public void pr(int i) {
        boolean z = i == 4;
        this.pr = z;
        if (z) {
            this.hw = System.currentTimeMillis();
        }
    }

    public boolean hw(Activity activity, of ofVar) {
        if (activity == null || ofVar == null) {
            return false;
        }
        boolean z = this.pr;
        this.pr = false;
        if (!ofVar.e() || !z) {
            return false;
        }
        if (pr.pr(activity) || hw()) {
            return true;
        }
        try {
            if (this.x) {
                if (pr.pr()) {
                    return false;
                }
                return pr(activity);
            }
            return pr(activity);
        } catch (Throwable th) {
            return false;
        }
    }

    public void pr() {
        this.hn = System.currentTimeMillis();
    }

    private boolean pr(Activity activity) {
        return (activity.getWindow().getDecorView().getSystemUiVisibility() & 2) == 2;
    }

    private boolean hw() {
        long j = this.hw;
        long jAbs = j > 0 ? Math.abs(j - this.hn) : -1L;
        if (jAbs >= 0 && jAbs < 300) {
            return true;
        }
        return false;
    }
}
