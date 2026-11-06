package com.bytedance.sdk.openadsdk.core.component.reward.swiper;

import com.bykv.vk.openvk.component.video.api.ah.d;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.draw.xr;
import com.bytedance.sdk.openadsdk.core.jw.pc;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.yu;
import com.bytedance.sdk.openadsdk.core.nw.le;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import com.bytedance.sdk.openadsdk.core.zb.ah;
import com.bytedance.sdk.openadsdk.op.ch;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends xr {
    private boolean ka;

    public ms(TTBaseVideoActivity tTBaseVideoActivity, lm lmVar, String str, boolean z, boolean z2) {
        super(tTBaseVideoActivity, lmVar, str, z, z2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.xr
    public void ms(NativeExpressView nativeExpressView) {
        Map<String, Object> mapEg = this.f2159ms.eg();
        if (nativeExpressView.getDynamicShowType() == 0) {
            yu.ms(mapEg, this.xr, nativeExpressView);
        } else {
            mapEg.put("dynamic_show_type", Integer.valueOf(nativeExpressView.getDynamicShowType()));
        }
        le leVarFi = this.xr.fi();
        Double dFm = null;
        if (leVarFi != null) {
            mapEg.put("refresh_num", Integer.valueOf(leVarFi.ah()));
            if (this.ka) {
                dFm = this.f2159ms.fm();
            }
        }
        ah.ms(this.xr, this.ah, mapEg, dFm);
        com.bytedance.sdk.openadsdk.core.op.ms.ms().d();
        pc.ms(this.xr.ka());
    }

    public void ah(boolean z) {
        this.ka = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.xr
    public d hi() {
        d dVarMs = qr.ms(1, this.xr);
        dVarMs.xr(this.xr.df());
        dVarMs.xr(100);
        dVarMs.ah(100);
        dVarMs.ah(this.xr.lx());
        dVarMs.xr(this.d);
        if (ch.ms(this.xr)) {
            dVarMs.ms(true);
        }
        return dVarMs;
    }
}
