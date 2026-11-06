package com.byazt.vt;

import android.view.MotionEvent;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 170, 121})
public class x implements com.byazt.at.hn, com.byazt.at.pr {
    public final Map<String, pr> pr = new HashMap();

    @com.byazt.vzx.pr(pr = {0, 1, 170, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
    private static class pr {
        public boolean hn;
        public float hw;
        public float pr;
        public boolean x;

        private pr() {
        }
    }

    @Override // com.byazt.at.hn
    public boolean hw(String str) {
        return "tap".equals(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:21:0x008e  */
    /* JADX WARN: Code duplicated, block: B:23:0x0092  */
    /* JADX WARN: Code duplicated, block: B:25:0x0099  */
    @Override // com.byazt.at.hn
    public boolean pr(String str, String str2, int i, Map<String, Object> map, Map<String, Object> map2, com.byazt.dd.c cVar) {
        float rawX;
        new StringBuilder("handle: scenario=").append(str).append(" ").append(str2).append(" ").append(i).append(" ").append(map).append(" ").append(map2);
        MotionEvent motionEventPr = com.byazt.vt.pr.pr(map2);
        if (motionEventPr == null) {
            return false;
        }
        String strPr = com.byazt.at.hw.pr(str, i);
        pr prVar = this.pr.get(strPr);
        if (prVar == null) {
            prVar = new pr();
            this.pr.put(strPr, prVar);
        }
        switch (motionEventPr.getAction()) {
            case 0:
                prVar.x = false;
                prVar.pr = motionEventPr.getRawX();
                prVar.hw = motionEventPr.getRawY();
                return true;
            case 1:
                if (prVar.hn) {
                    prVar.hn = false;
                    prVar.pr = 0.0f;
                    prVar.hw = 0.0f;
                    return false;
                }
                rawX = motionEventPr.getRawX();
                float rawY = motionEventPr.getRawY();
                if (Math.abs(rawX - prVar.pr) < 15.0f || Math.abs(rawY - prVar.hw) >= 15.0f) {
                    prVar.hn = false;
                    return false;
                }
                if (!prVar.x) {
                    prVar.x = true;
                    prVar.pr = 0.0f;
                    prVar.hw = 0.0f;
                    if (cVar != null) {
                        cVar.pr();
                    }
                    return true;
                }
                return true;
            case 2:
                float rawX2 = motionEventPr.getRawX();
                float rawY2 = motionEventPr.getRawY();
                if (Math.abs(rawX2 - prVar.pr) >= 15.0f || Math.abs(rawY2 - prVar.hw) >= 15.0f) {
                    prVar.hn = true;
                }
                return true;
            case 3:
                prVar.hn = false;
                float rawX3 = motionEventPr.getRawX();
                if (motionEventPr.getRawY() != 0.0f || rawX3 != 0.0f) {
                    if (prVar.hn) {
                        prVar.hn = false;
                        prVar.pr = 0.0f;
                        prVar.hw = 0.0f;
                        return false;
                    }
                    rawX = motionEventPr.getRawX();
                    float rawY3 = motionEventPr.getRawY();
                    if (Math.abs(rawX - prVar.pr) < 15.0f) {
                        break;
                    }
                    prVar.hn = false;
                    return false;
                }
                return true;
            default:
                return true;
        }
    }

    @Override // com.byazt.at.pr
    public void pr(String str) {
        String strPr = com.byazt.at.hw.pr(str);
        Iterator<Map.Entry<String, pr>> it = this.pr.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, pr> next = it.next();
            if (next.getKey() != null && next.getKey().startsWith(strPr)) {
                it.remove();
            }
        }
    }
}
