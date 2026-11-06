package com.bytedance.adsdk.ugeno.widget.ah;

import android.content.Context;
import com.bytedance.adsdk.ugeno.widget.frame.UGFrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms extends com.bytedance.adsdk.ugeno.xr.ms<UGFrameLayout> {
    public ms(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ms, com.bytedance.adsdk.ugeno.xr.ah
    public void xr() {
        super.xr();
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public void ms(String str, String str2) {
        super.ms(str, str2);
        str.hashCode();
        switch (str) {
            case "onVideoProgress":
            case "onVideoFinish":
            case "onVideoPlay":
            case "onVideoResume":
            case "onVideoPause":
                xr(str, str2);
                break;
        }
    }
}
