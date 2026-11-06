package com.byazt.iy;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1124, 5})
public class q {

    @com.byazt.cp.n(n = {0, 1, 1124, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME})
    static class n extends IOException {
        public n() {
            super("APNG Format error");
        }
    }

    public static List<l> n(com.byazt.gq.n nVar) throws IOException {
        if (!nVar.n("\u0089PNG") || !nVar.n("\r\n\u001a\n")) {
            throw new n();
        }
        ArrayList arrayList = new ArrayList();
        while (nVar.q() > 0) {
            arrayList.add(qg(nVar));
        }
        return arrayList;
    }

    private static l qg(com.byazt.gq.n nVar) throws IOException {
        l lVar;
        int iS = nVar.s();
        int iQg = nVar.qg();
        int iB_ = nVar.b_();
        if (iB_ == com.byazt.iy.n.n) {
            lVar = new com.byazt.iy.n();
        } else if (iB_ == w.n) {
            lVar = new w();
        } else if (iB_ == x.n) {
            lVar = new x();
        } else if (iB_ == tj.n) {
            lVar = new tj();
        } else if (iB_ == cp.n) {
            lVar = new cp();
        } else if (iB_ == d.n) {
            lVar = new d();
        } else {
            lVar = new l();
        }
        lVar.x = iS;
        lVar.l = iB_;
        lVar.q = iQg;
        lVar.qg(nVar);
        lVar.w = nVar.qg();
        return lVar;
    }
}
