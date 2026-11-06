package com.byazt.bf;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj {
    public static final String n = "TTMediationSDK_tj";
    public Map<String, rv> qg;
    public com.byazt.zg.s<rv> s;

    private tj() {
        this.s = new com.byazt.zg.q(com.byazt.qt.qg.getContext());
        this.qg = new ConcurrentHashMap();
    }

    public static tj n() {
        return n.n;
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, 855})
    private static class n {
        public static tj n = new tj();
    }

    public void n(String str, long j) {
        if (this.s != null) {
            Map<String, rv> map = this.qg;
            rv rvVar = map != null ? map.get(str) : null;
            if (rvVar != null) {
                rvVar.n(j);
            }
            this.s.n(str, j);
        }
    }

    public void n(String str, String str2, long j) {
        if (this.s != null) {
            Map<String, rv> map = this.qg;
            rv rvVar = map != null ? map.get(str + "_" + str2) : null;
            if (rvVar != null) {
                rvVar.n(j);
            }
            this.s.n(str, str2, j);
        }
    }

    public void n(String str) {
        if (this.s != null) {
            Map<String, rv> map = this.qg;
            if (map != null) {
                map.remove(str);
            }
            this.s.delete(str);
        }
    }

    public void n(String str, String str2) {
        if (this.s != null) {
            Map<String, rv> map = this.qg;
            if (map != null) {
                map.remove(str + "_" + str2);
            }
            this.s.delete(str, str2);
        }
    }

    public void n(rv rvVar) {
        if (this.s == null || TextUtils.isEmpty(rvVar.tj())) {
            return;
        }
        Map<String, rv> map = this.qg;
        if (map != null) {
            map.put(rvVar.q(), rvVar);
        }
        this.s.qg(rvVar);
    }

    public rv qg(String str) {
        if (this.s == null) {
            return null;
        }
        Map<String, rv> map = this.qg;
        rv rvVar = map != null ? map.get(str) : null;
        if (rvVar != null) {
            return rvVar;
        }
        rv rvVarQuery = this.s.query(str);
        if (rvVarQuery != null) {
            this.qg.put(rvVarQuery.qg(), rvVarQuery);
        }
        return rvVarQuery;
    }

    public rv qg(String str, String str2) {
        if (this.s == null) {
            return null;
        }
        Map<String, rv> map = this.qg;
        rv rvVar = map != null ? map.get(str + "_" + str2) : null;
        if (rvVar != null) {
            return rvVar;
        }
        rv rvVarQuery = this.s.query(str, str2);
        if (rvVarQuery != null) {
            this.qg.put(rvVarQuery.q(), rvVarQuery);
        }
        return rvVarQuery;
    }
}
