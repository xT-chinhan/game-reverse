package com.byazt.pk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 36, 18})
public class l implements com.byazt.sx.n, com.byazt.sx.s {
    public final Map<String, n> n = new HashMap();

    @com.byazt.cp.n(n = {0, 1, 36, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    private static class n {
        public int n;
        public boolean qg;
        public Handler s;

        private n() {
            this.n = 500;
        }
    }

    @Override // com.byazt.sx.s
    public boolean qg(String str) {
        return "touchEnd".equals(str);
    }

    @Override // com.byazt.sx.s
    public boolean n(String str, String str2, int i, Map<String, Object> map, Map<String, Object> map2, com.byazt.xz.l lVar) {
        String strN = com.byazt.sx.qg.n(str, i);
        n nVar = this.n.get(strN);
        if (nVar == null) {
            nVar = new n();
            nVar.s = n(nVar);
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
            nVar.s.removeMessages(1102);
            nVar.s.sendEmptyMessageDelayed(1102, nVar.n);
        } else {
            if (action == 1) {
                if (nVar.qg) {
                    nVar.qg = false;
                    nVar.s.removeMessages(1102);
                    if (lVar != null) {
                        lVar.n();
                    }
                    return true;
                }
                nVar.s.removeMessages(1102);
                nVar.qg = false;
                return false;
            }
            if (action == 3) {
                nVar.s.removeMessages(1102);
                nVar.qg = false;
            }
        }
        return true;
    }

    private static Handler n(n nVar) {
        return new qg(nVar);
    }

    @com.byazt.cp.n(n = {0, 1, 36, 120})
    private static final class qg extends Handler {
        public final WeakReference<n> n;

        public qg(n nVar) {
            super(Looper.getMainLooper());
            this.n = new WeakReference<>(nVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            n nVar;
            if (message.what == 1102 && (nVar = this.n.get()) != null) {
                nVar.qg = true;
                removeMessages(1102);
            }
        }
    }

    @Override // com.byazt.sx.n
    public void n(String str, int i) {
        n nVarRemove = this.n.remove(com.byazt.sx.qg.n(str, i));
        if (nVarRemove == null || nVarRemove.s == null) {
            return;
        }
        nVarRemove.s.removeCallbacksAndMessages(null);
    }

    @Override // com.byazt.sx.n
    public void n(String str) {
        String strN = com.byazt.sx.qg.n(str);
        Iterator<Map.Entry<String, n>> it = this.n.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, n> next = it.next();
            if (next.getKey() != null && next.getKey().startsWith(strN)) {
                n value = next.getValue();
                if (value != null && value.s != null) {
                    value.s.removeCallbacksAndMessages(null);
                }
                it.remove();
            }
        }
    }
}
