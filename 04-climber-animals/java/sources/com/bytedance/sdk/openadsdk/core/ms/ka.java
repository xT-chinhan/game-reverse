package com.bytedance.sdk.openadsdk.core.ms;

import android.os.Looper;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.ao.xr.xr.ch;
import com.bytedance.sdk.openadsdk.core.nw;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ka extends com.bytedance.sdk.openadsdk.t.ms.xr.ms.ah implements xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private long f2869ms;

    public ka(Bridge bridge) {
        super(bridge);
        this.f2869ms = System.currentTimeMillis();
    }

    @Override // com.bytedance.sdk.openadsdk.t.ms.xr.ms.ah
    public void ms(final int i, final String str) {
        if (str == null) {
            str = "未知异常";
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.ms(i, str);
        } else {
            nw.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ms.ka.1
                @Override // java.lang.Runnable
                public void run() {
                    ka.super.ms(i, str);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.t.ms.xr.ms.ah
    public void ms(final List<ch> list) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.ms(list);
        } else {
            nw.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ms.ka.2
                @Override // java.lang.Runnable
                public void run() {
                    ka.super.ms(list);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ms.xr
    public long ms() {
        return this.f2869ms;
    }
}
