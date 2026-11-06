package com.bytedance.sdk.openadsdk.core.component.reward.ah;

import android.app.Activity;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.nw.lm;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends ms {
    private com.bytedance.sdk.openadsdk.core.widget.c h;

    public ah(Activity activity, lm lmVar) {
        super(activity, lmVar);
        this.h = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.ms, com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public xr.ms xr(final ch chVar) {
        xr.ms msVarXr = super.xr(chVar);
        if (msVarXr.ah()) {
            return msVarXr;
        }
        final com.bytedance.sdk.openadsdk.core.widget.c cVar = new com.bytedance.sdk.openadsdk.core.widget.c(this.x);
        this.h = cVar;
        cVar.ms(t.ah(this.x, "tt_retain_gift")).ms(ny()).ah("继续观看").d("坚持退出");
        this.h.ms(com.bytedance.sdk.openadsdk.res.ka.x(this.x));
        this.h.ms(new com.bytedance.sdk.openadsdk.core.widget.c.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.ah.ah.1
            @Override // com.bytedance.sdk.openadsdk.core.widget.c.ms
            public void ms() {
                cVar.dismiss();
                ch chVar2 = chVar;
                if (chVar2 != null) {
                    chVar2.ms();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.c.ms
            public void xr() {
                cVar.dismiss();
                ch chVar2 = chVar;
                if (chVar2 != null) {
                    chVar2.xr();
                }
            }
        });
        this.h.show();
        return new xr.ms(true, 0, "", this.h);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public String ms() {
        if ((this.f2097ms <= 0) || !this.ka) {
            return this.ka ? "忘记点击广告领取奖励啦～" : "再看" + this.f2097ms + "s可领取奖励";
        }
        return "再看" + this.f2097ms + "s，并点击一下广告可领取奖励";
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public boolean xr() {
        com.bytedance.sdk.openadsdk.core.widget.c cVar = this.h;
        return cVar != null && cVar.isShowing();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public void ah() {
        com.bytedance.sdk.openadsdk.core.widget.c cVar = this.h;
        if (cVar != null) {
            cVar.dismiss();
        }
    }
}
