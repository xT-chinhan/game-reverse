package com.byazt.fa;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT, 19})
public abstract class n {
    public abstract boolean n(com.byazt.vr.n nVar);

    public abstract boolean n(String str);

    public abstract List<com.byazt.vr.n> qg(int i, com.byazt.vr.n nVar, boolean z, List<String> list, String str);

    public abstract boolean qg(int i, String str, com.byazt.vr.n nVar);

    public List<com.byazt.vr.n> n(int i, com.byazt.vr.n nVar, boolean z, List<String> list, String str) {
        if (com.byazt.hls.q.n(i)) {
            return qg(i, nVar, z, list, str);
        }
        if (n(nVar)) {
            return qg(i, nVar, z, list, str);
        }
        return null;
    }

    public boolean n(int i, String str, com.byazt.vr.n nVar) {
        if (com.byazt.hls.q.n(i)) {
            return n(str);
        }
        if (n(nVar)) {
            return qg(i, str, nVar);
        }
        return false;
    }
}
