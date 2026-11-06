package com.byazt.bb;

import com.byazt.sx.s;
import com.byazt.xz.l;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FRAME_DROPPING_DTS_MAX_DIFF, 19})
public class n implements com.byazt.sx.n, s {
    public final Map<String, Boolean> n = new ConcurrentHashMap();

    @Override // com.byazt.sx.s
    public boolean qg(String str) {
        return "videoProgress".equals(str);
    }

    @Override // com.byazt.sx.s
    public boolean n(String str, String str2, int i, Map<String, Object> map, Map<String, Object> map2, l lVar) {
        String strN = com.byazt.sx.qg.n(str, i);
        Boolean bool = this.n.get(strN);
        if (bool != null && bool.booleanValue()) {
            return false;
        }
        this.n.put(strN, Boolean.TRUE);
        if (lVar == null) {
            return true;
        }
        lVar.n();
        return true;
    }

    @Override // com.byazt.sx.n
    public void n(String str, int i) {
        this.n.remove(com.byazt.sx.qg.n(str, i));
    }

    @Override // com.byazt.sx.n
    public void n(String str) {
        String strN = com.byazt.sx.qg.n(str);
        Iterator<Map.Entry<String, Boolean>> it = this.n.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Boolean> next = it.next();
            if (next.getKey() != null && next.getKey().startsWith(strN)) {
                it.remove();
            }
        }
    }
}
