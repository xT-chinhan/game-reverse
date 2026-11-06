package com.bytedance.sdk.openadsdk.core.ugeno.component.ms;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends com.bytedance.adsdk.ugeno.widget.xr.ms {
    public ms(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.widget.xr.ms
    public String x(String str) {
        str.hashCode();
        switch (str) {
            case "unmuted":
                return "tt_ugen_unmuted";
            case "back":
                return "tt_ugen_back";
            case "logo":
                return "tt_ugen_logo";
            case "close":
                return "tt_ugen_close";
            case "muted":
                return "tt_ugen_muted";
            default:
                return "";
        }
    }
}
