package com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ms;

import android.app.Activity;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.component.reward.ah.ch;
import com.bytedance.sdk.openadsdk.core.nw.k;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.widget.c;
import com.bytedance.sdk.openadsdk.res.ka;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends ms {
    private c xr;

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public String ms() {
        return "恭喜您已经获得奖励，是否要继续观看视频，再得超值奖励";
    }

    public xr(Activity activity, lm lmVar) {
        super(activity, lmVar);
        this.xr = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ms.ms, com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public com.bytedance.sdk.openadsdk.core.component.reward.ah.xr.ms ms(final ch chVar) {
        com.bytedance.sdk.openadsdk.core.component.reward.ah.xr.ms msVarMs = super.ms(chVar);
        if (msVarMs.ah()) {
            return msVarMs;
        }
        final c cVar = new c(this.x);
        this.xr = cVar;
        cVar.ms(t.ah(this.x, "tt_retain_gift")).ms(ms()).ah(k.ms(this.ab, this.hi, this.sl)).d("坚持退出");
        cVar.ms(ka.x(this.x));
        this.xr.ms(new c.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.business.xr.ms.xr.1
            @Override // com.bytedance.sdk.openadsdk.core.widget.c.ms
            public void ms() {
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
        this.xr.show();
        return new com.bytedance.sdk.openadsdk.core.component.reward.ah.xr.ms(true, 0, "", this.xr);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public boolean xr() {
        c cVar = this.xr;
        return cVar != null && cVar.isShowing();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public void ah() {
        c cVar = this.xr;
        if (cVar != null) {
            cVar.dismiss();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public void d() {
        c cVar = this.xr;
        if (cVar != null) {
            cVar.ms();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public void ka() {
        c cVar = this.xr;
        if (cVar != null) {
            cVar.xr();
        }
    }
}
