package com.byazt.bf;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, 101})
public class fs {
    public static final String n = "TTMediationSDK_fs";
    public Map<String, x> qg;
    public com.byazt.zg.n<x> s;

    private fs() {
        this.s = new com.byazt.zg.qg(com.byazt.qt.qg.getContext());
        this.qg = new ConcurrentHashMap();
    }

    public static fs n() {
        return n.n;
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO})
    private static class n {
        public static fs n = new fs();
    }

    public void n(String str) {
        if (this.s != null) {
            Map<String, x> map = this.qg;
            if (map != null) {
                map.remove(str);
            }
            this.s.delete(str);
        }
    }

    public void n(String str, String str2) {
        if (this.s != null) {
            Map<String, x> map = this.qg;
            if (map != null) {
                map.remove(str + "_" + str2);
            }
            this.s.delete(str, str2);
        }
    }

    public void n(x xVar) {
        x xVarQg;
        l lVar;
        if (xVar.n()) {
            xVarQg = qg(xVar.qg(), xVar.s());
        } else {
            xVarQg = qg(xVar.qg());
        }
        if (xVarQg == null) {
            if (this.s != null) {
                Map<String, x> map = this.qg;
                if (map != null) {
                    map.put(xVar.q(), xVar);
                }
                this.s.qg(xVar);
                return;
            }
            return;
        }
        HashMap map2 = new HashMap();
        for (l lVar2 : xVarQg.cp()) {
            map2.put(lVar2.s(), lVar2);
        }
        for (l lVar3 : xVar.cp()) {
            if (map2.containsKey(lVar3.s()) && (lVar = (l) map2.get(lVar3.s())) != null) {
                lVar3.n(lVar);
            }
        }
        Map<String, x> map3 = this.qg;
        if (map3 != null) {
            map3.put(xVar.q(), xVar);
        }
        qg(xVar);
    }

    public x qg(String str) {
        if (this.s != null) {
            Map<String, x> map = this.qg;
            x xVar = map != null ? map.get(str) : null;
            if (xVar != null) {
                return xVar;
            }
            x xVarQuery = this.s.query(str);
            if (xVarQuery != null) {
                Map<String, x> map2 = this.qg;
                if (map2 != null) {
                    map2.put(xVarQuery.q(), xVarQuery);
                }
                return xVarQuery;
            }
        }
        return null;
    }

    public x qg(String str, String str2) {
        if (this.s != null) {
            Map<String, x> map = this.qg;
            x xVar = map != null ? map.get(str + "_" + str2) : null;
            if (xVar != null) {
                return xVar;
            }
            x xVarQuery = this.s.query(str, str2);
            if (xVarQuery != null) {
                Map<String, x> map2 = this.qg;
                if (map2 != null) {
                    map2.put(xVarQuery.q(), xVarQuery);
                }
                return xVarQuery;
            }
        }
        return null;
    }

    public void qg(x xVar) {
        if (this.s != null) {
            Map<String, x> map = this.qg;
            if (map != null) {
                map.put(xVar.q(), xVar);
            }
            this.s.n(xVar);
        }
    }

    public void n(x xVar, String str, int i) {
        if (this.s != null) {
            xVar.n(str, i);
            Map<String, x> map = this.qg;
            if (map != null) {
                map.put(xVar.q(), xVar);
            }
            this.s.n(xVar);
        }
    }

    public void n(x xVar, String str, long j) {
        if (this.s != null) {
            xVar.n(str, j);
            Map<String, x> map = this.qg;
            if (map != null) {
                map.put(xVar.q(), xVar);
            }
            this.s.n(xVar);
        }
    }
}
