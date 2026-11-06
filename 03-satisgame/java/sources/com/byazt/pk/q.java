package com.byazt.pk;

import android.view.MotionEvent;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 36, 5})
public class q implements com.byazt.sx.n, com.byazt.sx.s {
    public final Map<String, n> n = new HashMap();

    @com.byazt.cp.n(n = {0, 1, 36, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME})
    private static class n {
        public float n;
        public boolean q;
        public float qg;
        public boolean s;

        private n() {
        }
    }

    @Override // com.byazt.sx.s
    public boolean qg(String str) {
        return "tap".equals(str);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0095  */
    /* JADX WARN: Code duplicated, block: B:29:0x0099  */
    /* JADX WARN: Code duplicated, block: B:31:0x00a0  */
    @Override // com.byazt.sx.s
    public boolean n(String str, String str2, int i, Map<String, Object> map, Map<String, Object> map2, com.byazt.xz.l lVar) {
        float rawX;
        new StringBuilder("handle: scenario=").append(str).append(" ").append(str2).append(" ").append(i).append(" ").append(map).append(" ").append(map2);
        MotionEvent motionEventN = com.byazt.pk.n.n(map2);
        if (motionEventN == null) {
            return false;
        }
        String strN = com.byazt.sx.qg.n(str, i);
        n nVar = this.n.get(strN);
        if (nVar == null) {
            nVar = new n();
            this.n.put(strN, nVar);
        }
        int action = motionEventN.getAction();
        if (action == 0) {
            nVar.q = false;
            nVar.n = motionEventN.getRawX();
            nVar.qg = motionEventN.getRawY();
        } else if (action == 1) {
            if (nVar.s) {
                nVar.s = false;
                nVar.n = 0.0f;
                nVar.qg = 0.0f;
                return false;
            }
            rawX = motionEventN.getRawX();
            float rawY = motionEventN.getRawY();
            if (Math.abs(rawX - nVar.n) < 15.0f || Math.abs(rawY - nVar.qg) >= 15.0f) {
                nVar.s = false;
                return false;
            }
            if (!nVar.q) {
                nVar.q = true;
                nVar.n = 0.0f;
                nVar.qg = 0.0f;
                if (lVar != null) {
                    lVar.n();
                }
                return true;
            }
        } else if (action == 2) {
            float rawX2 = motionEventN.getRawX();
            float rawY2 = motionEventN.getRawY();
            if (Math.abs(rawX2 - nVar.n) >= 15.0f || Math.abs(rawY2 - nVar.qg) >= 15.0f) {
                nVar.s = true;
            }
        } else if (action == 3) {
            nVar.s = false;
            float rawX3 = motionEventN.getRawX();
            if (motionEventN.getRawY() != 0.0f || rawX3 != 0.0f) {
                if (nVar.s) {
                    nVar.s = false;
                    nVar.n = 0.0f;
                    nVar.qg = 0.0f;
                    return false;
                }
                rawX = motionEventN.getRawX();
                float rawY3 = motionEventN.getRawY();
                if (Math.abs(rawX - nVar.n) < 15.0f) {
                }
                nVar.s = false;
                return false;
            }
        }
        return true;
    }

    @Override // com.byazt.sx.n
    public void n(String str, int i) {
        this.n.remove(com.byazt.sx.qg.n(str, i));
    }

    @Override // com.byazt.sx.n
    public void n(String str) {
        String strN = com.byazt.sx.qg.n(str);
        Iterator<Map.Entry<String, n>> it = this.n.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, n> next = it.next();
            if (next.getKey() != null && next.getKey().startsWith(strN)) {
                it.remove();
            }
        }
    }
}
