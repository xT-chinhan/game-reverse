package com.bytedance.sdk.openadsdk.core.ms;

import android.os.Looper;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.ao.xr.xr.zb;
import com.bytedance.sdk.openadsdk.core.nw;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ab extends com.bytedance.sdk.openadsdk.t.ms.xr.ms.ka implements xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private long f2853ms;

    public ab(Bridge bridge) {
        super(bridge);
        this.f2853ms = System.currentTimeMillis();
    }

    @Override // com.bytedance.sdk.openadsdk.t.ms.xr.ms.ka
    public void ms(final int i, final String str) {
        if (str == null) {
            str = "未知异常";
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.ms(i, str);
        } else {
            nw.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ms.ab.1
                @Override // java.lang.Runnable
                public void run() {
                    ab.super.ms(i, str);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.t.ms.xr.ms.ka
    public void ms(final List<zb> list) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.ms(list);
        } else {
            nw.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ms.ab.2
                @Override // java.lang.Runnable
                public void run() {
                    ab.super.ms(list);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ms.xr
    public long ms() {
        return this.f2853ms;
    }
}
