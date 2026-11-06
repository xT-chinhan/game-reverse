package com.byazt.sbt;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_START_INDEX, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
public class oa {
    public static final d n = new qg(null);
    public final Map<String, d> qg = new HashMap();

    public oa() {
        n(new s());
        n(new fs());
        n(new tj());
        n(new cp());
        n(new rv());
        n(new k());
        n(new sz());
        n(new n());
        n(new q());
        n(new l());
        n(new cy());
        n(new x());
        n(new w());
    }

    public synchronized void n(d dVar) {
        if (dVar != null) {
            if (dVar.n() != null) {
                this.qg.put(dVar.n(), dVar);
            }
        }
    }

    public synchronized d n(String str) {
        d dVar = this.qg.get(str);
        if (dVar != null) {
            return dVar;
        }
        return n;
    }
}
