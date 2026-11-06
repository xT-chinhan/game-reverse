package com.bytedance.sdk.openadsdk.core.component.reward.ah;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.jw.nw;
import com.bytedance.sdk.openadsdk.core.nw.eg;
import com.bytedance.sdk.openadsdk.core.nw.lm;

/* JADX INFO: loaded from: classes2.dex */
public class x extends ms {
    private com.bytedance.sdk.openadsdk.core.widget.c h;
    private String qv;

    public x(Activity activity, lm lmVar) {
        super(activity, lmVar);
        this.h = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.ms, com.bytedance.sdk.openadsdk.core.component.reward.ah.xr
    public xr.ms xr(final ch chVar) {
        final com.bytedance.sdk.openadsdk.core.widget.c cVar = new com.bytedance.sdk.openadsdk.core.widget.c(this.x);
        this.h = cVar;
        ms(cVar, this.d);
        this.h.ms(new com.bytedance.sdk.openadsdk.core.widget.c.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.ah.x.1
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
        return this.qv;
    }

    private void ms(com.bytedance.sdk.openadsdk.core.widget.c cVar, boolean z) {
        if (nw.xr(this.ab)) {
            int iVv = this.ab.vv();
            int iMs = eg.ms(this.ab);
            if (iVv == 0) {
                String str = "试玩时长达标才能领取奖励";
                if (iMs != 1 && !z && !this.ah) {
                    str = "试玩后才能领取奖励";
                }
                this.qv = str;
                cVar.ms(t.ah(this.x, "tt_retain_gift")).ms(ny()).ah("继续试玩").d("坚持退出");
                cVar.ms(com.bytedance.sdk.openadsdk.res.ka.x(this.x));
                return;
            }
            if (iVv != 1) {
                if (iVv != 3) {
                    return;
                }
                this.qv = "确定退出吗?";
                if (this.x != null) {
                    Intent intent = this.x.getIntent();
                    this.qv = String.format("再看%s秒可得奖励", Integer.valueOf(intent != null ? intent.getIntExtra("remainTime", 0) : 0));
                }
                ms(cVar, ny(), "继续观看", "坚持退出");
                cVar.ms(Color.parseColor("#FC1D56"));
                return;
            }
            boolean zAh = com.bytedance.sdk.openadsdk.core.nw.t.ah(this.ab);
            if (iMs != 0 || zAh) {
                this.qv = String.format("再看%s秒可得奖励", Integer.valueOf(this.f2097ms));
            } else {
                this.qv = "未满足奖励要求，需要继续浏览";
            }
            if (zAh) {
                cVar.xr("确定退出吗?");
                ms(cVar, ny(), "继续观看", "坚持退出");
            } else {
                cVar.ms(t.ah(this.x, "tt_reward_coin")).ms(Color.parseColor("#FC1D56")).ms(ny()).ah("继续观看").d("坚持退出");
                cVar.ms(com.bytedance.sdk.openadsdk.res.ka.x(this.x));
            }
        }
    }

    private void ms(com.bytedance.sdk.openadsdk.core.widget.c cVar, String str, String str2, String str3) {
        cVar.ms(t.ah(this.x, "tt_reward_browse_multi_icon")).ms(str).ah(str2).d(str3);
        cVar.ms(com.bytedance.sdk.openadsdk.res.ka.p(this.x));
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
