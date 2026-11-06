package com.byazt.pp;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME, 866})
public class py {
    public final Map<String, String> n;
    public boolean q;
    public final LottieAnimationView qg;
    public final fs s;

    public String n(String str) {
        return str;
    }

    public py() {
        this.n = new HashMap();
        this.q = true;
        this.qg = null;
        this.s = null;
    }

    public py(LottieAnimationView lottieAnimationView) {
        this.n = new HashMap();
        this.q = true;
        this.qg = lottieAnimationView;
        this.s = null;
    }

    public String n(String str, String str2) {
        return n(str2);
    }

    public void qg(String str, String str2) {
        this.n.put(str, str2);
        n();
    }

    public final String s(String str, String str2) {
        if (this.q && this.n.containsKey(str2)) {
            return this.n.get(str2);
        }
        String strN = n(str, str2);
        if (this.q) {
            this.n.put(str2, strN);
        }
        return strN;
    }

    private void n() {
        LottieAnimationView lottieAnimationView = this.qg;
        if (lottieAnimationView != null) {
            lottieAnimationView.invalidate();
        }
        fs fsVar = this.s;
        if (fsVar != null) {
            fsVar.invalidateSelf();
        }
    }
}
