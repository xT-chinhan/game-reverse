package com.byazt.wt;

import android.net.Uri;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 213})
public class cz {
    public static void pr(final Uri uri, final com.byazt.sd.nl nlVar) {
        if (nlVar != null && nlVar.pr(uri)) {
            try {
                com.byazt.ca.aj.pr().post(new Runnable() { // from class: com.byazt.wt.cz.1
                    @Override // java.lang.Runnable
                    public void run() {
                        nlVar.hw(uri);
                    }
                });
            } catch (Exception e) {
            }
        }
    }

    public static void pr(final com.byazt.son.x xVar, final int i, final boolean z) {
        if (xVar == null) {
            return;
        }
        com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.wt.cz.2
            @Override // java.lang.Runnable
            public void run() {
                String userAgentString = xVar.getUserAgentString();
                if (TextUtils.isEmpty(userAgentString)) {
                    return;
                }
                StringBuilder sb = new StringBuilder(userAgentString);
                sb.append(" open_news open_news_u_s/").append(i);
                if (z) {
                    sb.append("/").append(ls.zo());
                }
                xVar.setUserAgentString(sb.toString());
            }
        });
    }
}
