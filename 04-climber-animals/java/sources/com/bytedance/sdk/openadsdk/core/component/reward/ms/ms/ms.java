package com.bytedance.sdk.openadsdk.core.component.reward.ms.ms;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.ny.xr.d;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import com.bytedance.sdk.openadsdk.core.re.ka;
import com.bytedance.sdk.openadsdk.op.ny;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final Map<lm, Long> f2225ms = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.component.reward.ms.ms.ms$ms, reason: collision with other inner class name */
    public interface InterfaceC0275ms<T> {
        void ms(boolean z, T t);
    }

    public static void ms(final boolean z, final lm lmVar, final InterfaceC0275ms<Object> interfaceC0275ms) {
        if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(lmVar)) {
            return;
        }
        f2225ms.put(lmVar, Long.valueOf(SystemClock.elapsedRealtime()));
        if (!TextUtils.isEmpty(qr.ms(lmVar))) {
            if (interfaceC0275ms != null) {
                interfaceC0275ms.ms(false, null);
            }
            xr(z, false, lmVar, -1L, " meta == null or meta.getVideo() == null ");
        } else {
            String strMs = qr.ms(lmVar);
            File fileMs = ms(qr.ab(lmVar), lmVar.pd());
            com.bytedance.sdk.component.ny.xr.xr xrVarD = ka.ms().xr().d();
            xrVarD.ms(strMs);
            xrVarD.ms(fileMs.getParent(), fileMs.getName());
            xrVarD.ms(new com.bytedance.sdk.component.ny.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.ms.ms.ms.1
                @Override // com.bytedance.sdk.component.ny.ms.ms
                public void ms(d dVar, com.bytedance.sdk.component.ny.xr xrVar) {
                    if (xrVar.x() && xrVar.ab() != null && xrVar.ab().exists()) {
                        InterfaceC0275ms interfaceC0275ms2 = interfaceC0275ms;
                        if (interfaceC0275ms2 != null) {
                            interfaceC0275ms2.ms(true, null);
                        }
                        sl.ms("MetaResourceCacheManager", "onResponse: RewardFullVideo preload success ");
                        ms.xr(z, true, lmVar, xrVar.ms(), xrVar.xr());
                        return;
                    }
                    InterfaceC0275ms interfaceC0275ms3 = interfaceC0275ms;
                    if (interfaceC0275ms3 != null) {
                        interfaceC0275ms3.ms(false, null);
                    }
                    sl.ms("MetaResourceCacheManager", "onResponse: RewardFullVideo preload fail ");
                    ms.xr(z, false, lmVar, xrVar.ms(), xrVar.xr());
                }

                @Override // com.bytedance.sdk.component.ny.ms.ms
                public void ms(d dVar, IOException iOException) {
                    InterfaceC0275ms interfaceC0275ms2 = interfaceC0275ms;
                    if (interfaceC0275ms2 != null) {
                        interfaceC0275ms2.ms(false, null);
                    }
                    sl.ms("MetaResourceCacheManager", "onFailure: RewardFullVideo preload fail ");
                    ms.xr(z, false, lmVar, -2L, iOException.getMessage());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xr(boolean z, boolean z2, lm lmVar, long j, String str) {
        Long lRemove = f2225ms.remove(lmVar);
        long jElapsedRealtime = lRemove == null ? 0L : SystemClock.elapsedRealtime() - lRemove.longValue();
        String str2 = z2 ? "load_video_success" : "load_video_error";
        if (z2 || str == null) {
            str = null;
        }
        com.bytedance.sdk.openadsdk.core.zb.ah.ka(lmVar, z ? "rewarded_video" : "fullscreen_interstitial_ad", str2, f.ms(z2, lmVar, jElapsedRealtime, j, str));
    }

    private static File ms(String str, int i) {
        return new File(ny.ms(i).ms(), str);
    }
}
