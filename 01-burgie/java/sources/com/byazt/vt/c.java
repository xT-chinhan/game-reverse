package com.byazt.vt;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.group.constants.Constants;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 170, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c implements com.byazt.at.hn, com.byazt.at.pr {
    public final Map<String, pr> pr = new HashMap();

    @com.byazt.vzx.pr(pr = {0, 1, 170, 169})
    private static class pr {
        public Handler hn;
        public boolean hw;
        public int pr;

        private pr() {
            this.pr = 500;
        }
    }

    @Override // com.byazt.at.hn
    public boolean hw(String str) {
        return "touchEnd".equals(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.byazt.at.hn
    public boolean pr(String str, String str2, int i, Map<String, Object> map, Map<String, Object> map2, com.byazt.dd.c cVar) {
        String strPr = com.byazt.at.hw.pr(str, i);
        pr prVar = this.pr.get(strPr);
        if (prVar == null) {
            prVar = new pr();
            prVar.hn = pr(prVar);
            this.pr.put(strPr, prVar);
        }
        if (map != null) {
            Object obj = map.get(Constants.DELAY_FIELD);
            if (obj != null) {
                prVar.pr = com.byazt.aa.hn.pr(String.valueOf(obj), 500);
            } else {
                prVar.pr = 500;
            }
        }
        MotionEvent motionEventPr = com.byazt.vt.pr.pr(map2);
        if (motionEventPr == null) {
            return false;
        }
        switch (motionEventPr.getAction()) {
            case 0:
                prVar.hn.removeMessages(1102);
                prVar.hn.sendEmptyMessageDelayed(1102, prVar.pr);
                return true;
            case 1:
                if (prVar.hw) {
                    prVar.hw = false;
                    prVar.hn.removeMessages(1102);
                    if (cVar != null) {
                        cVar.pr();
                    }
                    return true;
                }
                prVar.hn.removeMessages(1102);
                prVar.hw = false;
                return false;
            case 2:
            default:
                return true;
            case 3:
                prVar.hn.removeMessages(1102);
                prVar.hw = false;
                return true;
        }
    }

    private static Handler pr(pr prVar) {
        return new hw(prVar);
    }

    @com.byazt.vzx.pr(pr = {0, 1, 170, 401})
    private static final class hw extends Handler {
        public final WeakReference<pr> pr;

        public hw(pr prVar) {
            super(Looper.getMainLooper());
            this.pr = new WeakReference<>(prVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            pr prVar;
            if (message.what != 1102 || (prVar = this.pr.get()) == null) {
                return;
            }
            prVar.hw = true;
            removeMessages(1102);
        }
    }

    @Override // com.byazt.at.pr
    public void pr(String str) {
        String strPr = com.byazt.at.hw.pr(str);
        Iterator<Map.Entry<String, pr>> it = this.pr.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, pr> next = it.next();
            if (next.getKey() != null && next.getKey().startsWith(strPr)) {
                pr value = next.getValue();
                if (value != null && value.hn != null) {
                    value.hn.removeCallbacksAndMessages(null);
                }
                it.remove();
            }
        }
    }
}
