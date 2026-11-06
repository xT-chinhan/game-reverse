package com.bytedance.sdk.openadsdk.core.component.reward.activity;

import android.os.Bundle;
import com.anythink.core.common.s;
import com.byazt.df.TTBaseVideoActivity;
import com.byazt.gct.cx;
import com.byazt.nf.rv;
import com.byazt.pj.qg;

/* JADX INFO: loaded from: classes2.dex */
public class TTFullScreenVideoActivity extends TTBaseVideoActivity {
    @Override // com.byazt.df.TTBaseVideoActivity
    public boolean t() {
        return false;
    }

    @Override // com.byazt.df.TTBaseVideoActivity
    public void sh() {
        super.sh();
        if (cx.hd(this.ae) || this.an.ln()) {
            return;
        }
        if (this.fi.lh()) {
            this.j.n(false, null, null, true, true);
            return;
        }
        int iBb = ((int) this.fi.bb()) / 1000;
        String str = this.dg.w(cx.q()) + s.a;
        boolean z = iBb >= this.dg.dh();
        this.j.n(false, str, (z || !rv.qg().l(String.valueOf(this.wo))) ? null : (this.dg.dh() - iBb) + "s后可跳过", z, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.df.TTBaseVideoActivity
    public void ur() {
        if (this.s.getAndSet(true)) {
            return;
        }
        if (this.pe == null || !this.pe.s()) {
            Bundle bundle = new Bundle();
            if (this.e.get()) {
                bundle.putBoolean("send_show_event_result", this.e.get());
            }
            if (this.yw.get()) {
                bundle.putBoolean("send_click_event_result", this.yw.get());
            }
            n("onAdClose", bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.df.TTBaseVideoActivity
    public void s(boolean z) {
        byte b = -1;
        if (this.hu) {
            if (rv.qg().ts() == 1) {
                b = 2000;
            }
        } else if (z) {
            b = 0;
        }
        if (b < 0 || this.a.get()) {
            return;
        }
        if (b == 0) {
            if (this.a.getAndSet(true)) {
                return;
            }
            qg.n().n(this.ae, String.valueOf(this.wo));
            return;
        }
        this.qg.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTFullScreenVideoActivity.1
            @Override // java.lang.Runnable
            public void run() {
                if (TTFullScreenVideoActivity.this.a.getAndSet(true)) {
                    return;
                }
                qg.n().n(TTFullScreenVideoActivity.this.ae, String.valueOf(TTFullScreenVideoActivity.this.wo));
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.byazt.df.TTBaseVideoActivity
    public void n(String str, Bundle bundle) {
        com.byazt.rv.qg.n(1, this.sh, str, bundle);
    }
}
