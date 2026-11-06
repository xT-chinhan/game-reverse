package com.byazt.tiu;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_VIDEO_FIRSTSEG_CONNECT_TIME, 121})
public class x {

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_VIDEO_FIRSTSEG_CONNECT_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
    static class pr extends IOException {
        public pr() {
            super("APNG Format error");
        }
    }

    public static List<c> pr(com.byazt.fe.pr prVar) throws IOException {
        if (!prVar.pr("\u0089PNG") || !prVar.pr("\r\n\u001a\n")) {
            throw new pr();
        }
        ArrayList arrayList = new ArrayList();
        while (prVar.x() > 0) {
            arrayList.add(hw(prVar));
        }
        return arrayList;
    }

    private static c hw(com.byazt.fe.pr prVar) throws IOException {
        c cVar;
        int iHn = prVar.hn();
        int iHw = prVar.hw();
        int iB_ = prVar.b_();
        if (iB_ == com.byazt.tiu.pr.pr) {
            cVar = new com.byazt.tiu.pr();
        } else if (iB_ == uc.pr) {
            cVar = new uc();
        } else if (iB_ == fw.pr) {
            cVar = new fw();
        } else if (iB_ == vk.pr) {
            cVar = new vk();
        } else if (iB_ == w.pr) {
            cVar = new w();
        } else if (iB_ == k.pr) {
            cVar = new k();
        } else {
            cVar = new c();
        }
        cVar.fw = iHn;
        cVar.c = iB_;
        cVar.x = iHw;
        cVar.hw(prVar);
        cVar.uc = prVar.hw();
        return cVar;
    }
}
