package com.byazt.ukb;

import com.byazt.ep.cp;
import com.byazt.gct.cd;
import com.byazt.gct.pk;
import com.byazt.vgx.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTSevenScreenWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL, 19})
public class n {
    public static Class<?> n(boolean z, pk pkVar, boolean z2, Map<String, Object> map) {
        if (cd.l(pkVar)) {
            return TTSevenScreenWebPageActivity.class;
        }
        if (cd.w(pkVar) && !pkVar.an()) {
            return TTVideoWebPageActivity.class;
        }
        if (pk.s(pkVar) && !z && w.fs(pkVar)) {
            if (cp.w(pkVar)) {
                return TTNativePageActivity.class;
            }
            if (pkVar.an()) {
                return TTWebPageActivity.class;
            }
            return n(TTVideoWebPageActivity.class, z2, pkVar, map);
        }
        if (cp.w(pkVar)) {
            return TTNativePageActivity.class;
        }
        return TTWebPageActivity.class;
    }

    private static Class n(Class cls, boolean z, pk pkVar, Map<String, Object> map) {
        if (!TTVideoWebPageActivity.class.equals(cls) || !z) {
            return cls;
        }
        if (map != null) {
            try {
                com.byazt.cs.n nVar = new com.byazt.cs.n();
                nVar.x = 100L;
                nVar.n = true;
                nVar.q = w.ur(pkVar);
                map.put("multi_process_data", nVar.n().toString());
            } catch (Throwable unused) {
                return cls;
            }
        }
        if (pkVar.cf() == 0) {
            return TTVideoScrollWebPageActivity.class;
        }
        return (pkVar.cf() <= 0 || 100 <= pkVar.cf() || !w.ur(pkVar)) ? cls : TTVideoScrollWebPageActivity.class;
    }
}
