package com.byazt.vgx;

import android.text.TextUtils;
import com.byazt.gct.pk;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.varbto.utils.api.UtilConst;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_PTS, 19})
public class n {
    public static String n(pk pkVar) {
        if (pkVar == null) {
            return "";
        }
        int iSz = w.sz(pkVar);
        int iOa = w.oa(pkVar);
        if (iSz == 309) {
            return com.byazt.wq.qg.n().qg(pkVar) ? "open_live_saas" : "open_scheme";
        }
        if (iSz == 10) {
            return "open_scheme";
        }
        if (iSz == 16) {
            return "open_miniapp";
        }
        if (iOa == 6) {
            return ((pkVar.k() == null || TextUtils.isEmpty(pkVar.k().qg())) && TextUtils.isEmpty(pkVar.m())) ? "open_scheme" : "download";
        }
        if (pkVar.sz() != null && !TextUtils.isEmpty(pkVar.sz().qg())) {
            return "open_scheme";
        }
        if (TextUtils.isEmpty(pkVar.fs())) {
            return ((pkVar.k() == null || TextUtils.isEmpty(pkVar.k().qg())) && TextUtils.isEmpty(pkVar.m())) ? UtilConst.CRASH_CAT_UNKNOWN : "download";
        }
        return "open_landing_page";
    }
}
