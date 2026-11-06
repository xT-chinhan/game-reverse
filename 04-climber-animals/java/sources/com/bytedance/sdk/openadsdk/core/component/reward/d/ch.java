package com.bytedance.sdk.openadsdk.core.component.reward.d;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.anythink.basead.exoplayer.i.a;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qf;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import com.bytedance.sdk.openadsdk.core.nw.ul;
import com.bytedance.sdk.openadsdk.core.nw.xn;
import com.bytedance.sdk.openadsdk.core.re;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class ch extends ms {
    private boolean jw;
    boolean pc;

    public static int ms(lm lmVar) {
        return 9;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    public boolean am() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public boolean c() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    public boolean l() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    public void qk() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    public boolean sa() {
        return false;
    }

    public ch(TTBaseVideoActivity tTBaseVideoActivity, lm lmVar) {
        super(tTBaseVideoActivity, lmVar);
        this.pc = false;
        this.jw = false;
        this.jw = com.bytedance.sdk.openadsdk.core.live.ah.xr.ms(lmVar) == 1;
    }

    public static boolean ms(Context context, lm lmVar) {
        long jC;
        if (!xn.d(lmVar)) {
            return false;
        }
        if (ul.ms(lmVar)) {
            jC = ((long) ul.xr(lmVar)) * 1000;
        } else {
            jC = qr.u(lmVar) != null ? (long) (qr.c(lmVar) * 1000.0d) : 0L;
        }
        long jMin = Math.min(qf.ms(), (long) (jC * (lmVar.cb() / 100.0f)));
        HashMap map = new HashMap(3);
        map.put("reward_countdown", Long.valueOf(jMin));
        map.put("event_tag", "rewarded_video");
        map.put("reward_live_scene", Integer.valueOf(com.bytedance.sdk.openadsdk.core.live.ah.xr.ms(lmVar)));
        return com.bytedance.sdk.openadsdk.core.live.xr.ms().xr(context, lmVar, map) == 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.xr ms(boolean z) {
        this.ny = new com.bytedance.sdk.openadsdk.core.component.reward.layout.ny(this.f2142ms, this.xr, z);
        return this.ny;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms, com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    protected void ah() {
        this.f2142ms.xr(true, true);
        this.ny.ah(true);
        this.ch.ah(false);
        this.y.ms(false);
        int iX = com.bytedance.sdk.openadsdk.core.jw.ul.x(re.getContext());
        com.bytedance.sdk.openadsdk.core.zb.ah.ms("click", this.xr, new com.bytedance.sdk.openadsdk.core.nw.ch.ms().c(-1.0f).ka(-1.0f).d(-1.0f).ah(-1.0f).xr(-1L).ms(-1L).ah(-1).d(-1).ka(-1024).xr(com.bytedance.sdk.openadsdk.core.ch.ub().ah() ? 1 : 2).ms(iX).ms(com.bytedance.sdk.openadsdk.core.jw.ul.c(re.getContext())).xr(com.bytedance.sdk.openadsdk.core.jw.ul.ab(re.getContext())).ms(), this.sl, true, this.f2142ms.eg(), -1, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void ms(int i, int i2, Intent intent) {
        super.ms(i, i2, intent);
        if (i != 1) {
            this.f2142ms.finish();
            return;
        }
        if (intent == null || intent.getExtras() == null) {
            this.f2142ms.finish();
            return;
        }
        if (intent.getExtras().getLong("csj.reward_countdown_duration_ms") <= 0) {
            int i3 = intent.getExtras().getInt("csj.reward_auth_status", 0);
            if (this.jw && i3 == 1) {
                this.f2142ms.finish();
                return;
            }
            com.bytedance.sdk.component.utils.sl.d("rewardAuthFlag", "verify rew....");
            this.f2142ms.d(0);
            x(true);
            this.f2142ms.az().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.d.ch.1
                @Override // java.lang.Runnable
                public void run() {
                    ch.this.zf();
                }
            }, a.f);
            return;
        }
        this.f2142ms.finish();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void ms(int i) {
        super.ms(i);
        if (i == 0) {
            zf();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public View ny() {
        FrameLayout frameLayout = new FrameLayout(this.f2142ms);
        frameLayout.setId(2114387959);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zf() {
        if (this.pc) {
            return;
        }
        this.pc = true;
        x(false);
        this.f2142ms.finish();
    }

    private void x(final boolean z) {
        if (this.ny instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.ny) {
            com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.d.ch.2
                @Override // java.lang.Runnable
                public void run() {
                    if (ch.this.ny == null) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.component.reward.layout.ny nyVar = (com.bytedance.sdk.openadsdk.core.component.reward.layout.ny) ch.this.ny;
                    if (z) {
                        nyVar.xr();
                    } else {
                        nyVar.ah();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public int cv() {
        return ms(this.xr);
    }
}
