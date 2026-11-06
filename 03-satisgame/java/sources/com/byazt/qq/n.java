package com.byazt.qq;

import android.net.Uri;
import android.text.TextUtils;
import com.byazt.tk.rv;
import com.byazt.vgx.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DELAY_BUFFERING_UPDATE, 19})
public class n {
    public static void n(final Uri uri, final com.byazt.gcl.s sVar) {
        if (sVar == null || !sVar.n(uri)) {
            return;
        }
        try {
            rv.n().post(new Runnable() { // from class: com.byazt.qq.n.1
                @Override // java.lang.Runnable
                public void run() {
                    sVar.qg(uri);
                }
            });
        } catch (Exception unused) {
        }
    }

    public static void n(final com.byazt.uad.q qVar, final int i, final boolean z) {
        if (qVar == null) {
            return;
        }
        com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.qq.n.2
            @Override // java.lang.Runnable
            public void run() {
                String userAgentString = qVar.getUserAgentString();
                if (TextUtils.isEmpty(userAgentString)) {
                    return;
                }
                StringBuilder sb = new StringBuilder(userAgentString);
                sb.append(" open_news open_news_u_s/").append(i);
                if (z) {
                    sb.append("/").append(w.fs());
                }
                qVar.setUserAgentString(sb.toString());
            }
        });
    }
}
