package com.bytedance.sdk.openadsdk.core.component.reward.activity;

import android.os.Bundle;
import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.hg.jn;
import com.byazt.joa.pr;
import com.byazt.sd.a;
import com.byazt.vh.hw;
import com.umeng.analytics.pro.an;

/* JADX INFO: loaded from: classes2.dex */
public class TTFullScreenVideoActivity extends TTBaseVideoActivity {
    @Override // com.byazt.cu.TTBaseVideoActivity
    public boolean iu() {
        return false;
    }

    @Override // com.byazt.cu.TTBaseVideoActivity
    public void r() {
        super.r();
        if (jn.yb(this.s) || this.n.nl()) {
            return;
        }
        if (this.ls.y()) {
            this.ww.pr(false, null, null, true, true);
            return;
        }
        int iGz = ((int) this.ls.gz()) / 1000;
        String str = this.qi.uc(jn.x()) + an.aB;
        boolean z = iGz >= this.qi.nw();
        this.ww.pr(false, str, (z || !a.hw().c(String.valueOf(this.ii))) ? null : (this.qi.nw() - iGz) + "s后可跳过", z, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.cu.TTBaseVideoActivity
    public void ve() {
        if (this.hn.getAndSet(true)) {
            return;
        }
        if (this.bm != null && this.bm.hn()) {
            return;
        }
        Bundle bundle = new Bundle();
        if (this.jn.get()) {
            bundle.putBoolean("send_show_event_result", this.jn.get());
        }
        if (this.l.get()) {
            bundle.putBoolean("send_click_event_result", this.l.get());
        }
        pr("onAdClose", bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.cu.TTBaseVideoActivity
    public void hn(boolean z) {
        byte b = -1;
        if (!this.rc) {
            if (z) {
                b = 0;
            }
        } else if (a.hw().to() == 1) {
            b = 2000;
        }
        if (b >= 0 && !this.a.get()) {
            if (b == 0) {
                if (!this.a.getAndSet(true)) {
                    hw.pr().pr(this.s, String.valueOf(this.ii));
                    return;
                }
                return;
            }
            this.hw.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTFullScreenVideoActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!TTFullScreenVideoActivity.this.a.getAndSet(true)) {
                        hw.pr().pr(TTFullScreenVideoActivity.this.s, String.valueOf(TTFullScreenVideoActivity.this.ii));
                    }
                }
            }, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.cu.TTBaseVideoActivity
    public void pr(String str, Bundle bundle) {
        pr.pr(1, this.i, str, bundle);
    }
}
