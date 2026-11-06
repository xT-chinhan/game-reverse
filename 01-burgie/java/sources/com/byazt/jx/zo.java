package com.byazt.jx;

import android.content.Context;
import com.byazt.hg.of;
import com.byazt.sd.cz;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_NO_AV_SYNC, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo {
    public static com.byazt.ri.pr pr(Context context, of ofVar, String str) {
        com.byazt.ri.x xVar = new com.byazt.ri.x(context, ofVar, str, "");
        if (ofVar != null) {
            com.byazt.qd.pr.pr(ofVar, String.valueOf(ls.m(ofVar)), ls.k(ofVar), 1, ofVar.z());
            cz.hw(ofVar.le(), xVar, com.byazt.nv.hn.class);
            ofVar.le();
        }
        return xVar;
    }

    public static com.byazt.nv.hn hw(Context context, of ofVar, String str) {
        if (ofVar != null) {
            com.byazt.qd.pr.pr(ofVar, String.valueOf(ls.m(ofVar)), ls.k(ofVar), 2, ofVar.z());
        }
        return new com.byazt.ri.x(context, ofVar, str, "");
    }

    public static com.byazt.nv.hn pr(Context context, String str, of ofVar, String str2) {
        if (ofVar != null) {
            com.byazt.qd.pr.pr(ofVar, String.valueOf(ls.m(ofVar)), ls.k(ofVar), 3, ofVar.z());
        }
        com.byazt.ri.x xVar = new com.byazt.ri.x(context, ofVar, str2, str);
        xVar.uc(true);
        return xVar;
    }
}
