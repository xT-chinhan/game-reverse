package com.byazt.r;

import com.byazt.ta.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 889, 19})
public class n {
    public int n;
    public final Map<String, s> qg;
    public final Map<String, q> s;

    public void n(String str, s sVar) {
        synchronized (this.qg) {
            this.qg.put(str, sVar);
        }
    }

    public void n(int i) {
        this.n = i;
    }

    public s n(String str, List<com.byazt.wm.s> list) {
        s sVarRemove;
        synchronized (this.qg) {
            sVarRemove = this.qg.remove(str);
        }
        if (sVarRemove == null) {
            return null;
        }
        if (w.n(sVarRemove.fs(), list)) {
            try {
                sVarRemove.q();
            } catch (InterruptedException unused) {
            }
            if (sVarRemove.w() && sVarRemove.l()) {
                return sVarRemove;
            }
        }
        try {
            sVarRemove.s();
            return null;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public boolean n(String str) {
        s sVar = this.qg.get(str);
        if (sVar != null) {
            if (sVar.x()) {
                return true;
            }
            if (sVar.w() && sVar.l()) {
                return true;
            }
        }
        return false;
    }

    public q qg(String str, List<com.byazt.wm.s> list) {
        q qVarRemove;
        synchronized (this.s) {
            qVarRemove = this.s.remove(str);
        }
        if (qVarRemove == null) {
            return null;
        }
        if (w.n(qVarRemove.w(), list)) {
            try {
                qVarRemove.l();
            } catch (InterruptedException unused) {
            }
            if (qVarRemove.fs() && qVarRemove.x()) {
                return qVarRemove;
            }
        }
        try {
            qVarRemove.q();
            return null;
        } catch (Throwable unused2) {
            return null;
        }
    }

    /* JADX INFO: renamed from: com.byazt.r.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 889, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    private static final class C0318n {
        public static final n n = new n();
    }

    public static n n() {
        return C0318n.n;
    }

    private n() {
        this.qg = new HashMap();
        this.s = new LinkedHashMap(3);
        this.n = 3;
    }
}
