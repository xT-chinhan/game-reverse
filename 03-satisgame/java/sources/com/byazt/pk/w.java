package com.byazt.pk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 36, 13})
public class w implements com.byazt.sx.n, com.byazt.sx.s {
    public final Map<String, n> n = new HashMap();

    @com.byazt.cp.n(n = {0, 1, 36, 108})
    private static class n {
        public int n;
        public Handler qg;

        private n() {
            this.n = 500;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 36, MediaPlayer.MEDIA_PLAYER_OPTION_OPT_SUB_FIRST_LOAD_TIME})
    private static class s {
        public final com.byazt.xz.l n;
        public final int q;
        public final String qg;
        public final int s;

        public s(com.byazt.xz.l lVar, String str, int i, int i2) {
            this.n = lVar;
            this.qg = str;
            this.s = i;
            this.q = i2;
        }
    }

    @Override // com.byazt.sx.s
    public boolean qg(String str) {
        return "touchStart".equals(str);
    }

    @Override // com.byazt.sx.s
    public boolean n(String str, String str2, int i, Map<String, Object> map, Map<String, Object> map2, com.byazt.xz.l lVar) {
        String strN = com.byazt.sx.qg.n(str, i);
        n nVar = this.n.get(strN);
        if (nVar == null) {
            nVar = new n();
            nVar.qg = n();
            this.n.put(strN, nVar);
        }
        if (map != null) {
            Object obj = map.get("delay");
            if (obj == null) {
                nVar.n = 500;
            } else {
                nVar.n = com.byazt.hb.s.n(String.valueOf(obj), 500);
            }
        }
        MotionEvent motionEventN = com.byazt.pk.n.n(map2);
        if (motionEventN == null) {
            return false;
        }
        int action = motionEventN.getAction();
        if (action == 0) {
            nVar.qg.removeMessages(1101);
            nVar.qg.sendMessageDelayed(nVar.qg.obtainMessage(1101, new s(lVar, str, i, nVar.n)), nVar.n);
        } else if (action == 1 || action == 3) {
            nVar.qg.removeMessages(1101);
        }
        return false;
    }

    private static Handler n() {
        return new qg();
    }

    @com.byazt.cp.n(n = {0, 1, 36, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUX_NONBLOCK_READ})
    private static final class qg extends Handler {
        public qg() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1101 && (message.obj instanceof s)) {
                s sVar = (s) message.obj;
                if (sVar.n != null) {
                    sVar.n.n();
                }
                removeMessages(1101);
            }
        }
    }

    @Override // com.byazt.sx.n
    public void n(String str, int i) {
        n nVarRemove = this.n.remove(com.byazt.sx.qg.n(str, i));
        if (nVarRemove == null || nVarRemove.qg == null) {
            return;
        }
        nVarRemove.qg.removeCallbacksAndMessages(null);
    }

    @Override // com.byazt.sx.n
    public void n(String str) {
        String strN = com.byazt.sx.qg.n(str);
        Iterator<Map.Entry<String, n>> it = this.n.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, n> next = it.next();
            if (next.getKey() != null && next.getKey().startsWith(strN)) {
                n value = next.getValue();
                if (value != null && value.qg != null) {
                    value.qg.removeCallbacksAndMessages(null);
                }
                it.remove();
            }
        }
    }
}
