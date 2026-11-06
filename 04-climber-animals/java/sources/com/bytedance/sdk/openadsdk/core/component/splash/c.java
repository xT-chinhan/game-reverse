package com.bytedance.sdk.openadsdk.core.component.splash;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.u;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import com.bytedance.sdk.openadsdk.core.nw.tz;
import com.bytedance.sdk.openadsdk.core.re;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static void ms(long j, boolean z, boolean z2, lm lmVar, long j2, String str) {
        String str2;
        long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
        if (z) {
            str2 = z2 ? "load_video_success" : "load_video_error";
        } else {
            str2 = z2 ? "download_video_image_success" : "download_video_image_fail";
        }
        String str3 = str2;
        if (z) {
            Map<String, Object> mapMs = f.ms(z2, lmVar, jElapsedRealtime, j2, str);
            mapMs.put("splash_show_type", 1);
            com.bytedance.sdk.openadsdk.core.zb.ah.ka(lmVar, "splash_ad", str3, mapMs);
        } else {
            Map<String, Object> mapXr = f.xr(z2, lmVar, jElapsedRealtime, j2, str);
            mapXr.put("splash_show_type", 2);
            com.bytedance.sdk.openadsdk.core.zb.ah.d(lmVar, "splash_ad", str3, mapXr);
        }
    }

    public static void ms(com.bytedance.sdk.openadsdk.core.nw.ms msVar) {
        com.bykv.vk.openvk.component.video.api.ah.d dVarMs;
        if (xr(msVar)) {
            lm lmVar = msVar.xr().get(0);
            int iNy = f.ny(lmVar);
            com.bykv.vk.openvk.component.video.api.ah.ah ahVarU = qr.u(lmVar);
            if (ahVarU != null) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                String strSl = ahVarU.sl();
                if (TextUtils.isEmpty(strSl)) {
                    ms(jElapsedRealtime, true, false, lmVar, -1L, "preLoadVideo videoUrl is null");
                    return;
                }
                if (TextUtils.isEmpty(ahVarU.ub())) {
                    com.bytedance.sdk.component.utils.ka.xr(strSl);
                }
                if (lmVar.gx()) {
                    dVarMs = qr.ms(2, lmVar);
                } else {
                    dVarMs = qr.ms(3, lmVar);
                }
                dVarMs.ms("material_meta", lmVar);
                if (!re.xr().x(String.valueOf(iNy)) || u.d(re.getContext())) {
                    ahVarU.ka(0);
                    com.bykv.vk.openvk.component.video.ms.ms.ms();
                    com.bytedance.sdk.openadsdk.core.video.d.xr.ms(dVarMs, new com.bykv.vk.openvk.component.video.api.ka.xr() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.c.1
                        @Override // com.bykv.vk.openvk.component.video.api.ka.ms.InterfaceC0178ms
                        public void ms(com.bykv.vk.openvk.component.video.api.ah.d dVar, int i) {
                        }

                        @Override // com.bykv.vk.openvk.component.video.api.ka.ms.InterfaceC0178ms
                        public void ms(com.bykv.vk.openvk.component.video.api.ah.d dVar, int i, String str) {
                        }
                    });
                }
            }
        }
    }

    public static boolean xr(com.bytedance.sdk.openadsdk.core.nw.ms msVar) {
        return (msVar == null || msVar.xr() == null || msVar.xr().isEmpty() || msVar.xr().get(0) == null) ? false : true;
    }

    public static int ms(tz tzVar) {
        if (tzVar == null) {
            return 0;
        }
        int iAh = ah(tzVar.xr());
        return iAh <= 0 ? ms(tzVar.ms()) : iAh;
    }

    public static int ms(lm lmVar) {
        if (lmVar != null) {
            return f.ny(lmVar);
        }
        return 0;
    }

    public static int ah(com.bytedance.sdk.openadsdk.core.nw.ms msVar) {
        if (msVar != null) {
            return msVar.ms();
        }
        return 0;
    }

    public static boolean xr(lm lmVar) {
        if (lmVar == null || lmVar.vl() == 1 || qr.u(lmVar) == null || TextUtils.isEmpty(qr.ms(lmVar))) {
            return true;
        }
        lmVar.ny(true);
        return false;
    }
}
