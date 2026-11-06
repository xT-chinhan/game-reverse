package com.byazt.vt;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.group.constants.Constants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 170, 5})
public class uc implements com.byazt.at.hn, com.byazt.at.pr {
    public final Map<String, pr> pr = new HashMap();

    @com.byazt.vzx.pr(pr = {0, 1, 170, 129})
    private static class pr {
        public Handler hw;
        public int pr;

        private pr() {
            this.pr = 500;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 170, MediaPlayer.MEDIA_PLAYER_OPTION_SIDX_VIDEO_WINDOW_SIZE})
    private static class hn {
        public final int hn;
        public final String hw;
        public final com.byazt.dd.c pr;
        public final int x;

        public hn(com.byazt.dd.c cVar, String str, int i, int i2) {
            this.pr = cVar;
            this.hw = str;
            this.hn = i;
            this.x = i2;
        }
    }

    @Override // com.byazt.at.hn
    public boolean hw(String str) {
        return "touchStart".equals(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.byazt.at.hn
    public boolean pr(String str, String str2, int i, Map<String, Object> map, Map<String, Object> map2, com.byazt.dd.c cVar) {
        String strPr = com.byazt.at.hw.pr(str, i);
        pr prVar = this.pr.get(strPr);
        if (prVar == null) {
            prVar = new pr();
            prVar.hw = pr();
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
                prVar.hw.removeMessages(1101);
                prVar.hw.sendMessageDelayed(prVar.hw.obtainMessage(1101, new hn(cVar, str, i, prVar.pr)), prVar.pr);
                return false;
            case 1:
            case 3:
                prVar.hw.removeMessages(1101);
                return false;
            case 2:
            default:
                return false;
        }
    }

    private static Handler pr() {
        return new hw();
    }

    @com.byazt.vzx.pr(pr = {0, 1, 170, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED})
    private static final class hw extends Handler {
        public hw() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1101 || !(message.obj instanceof hn)) {
                return;
            }
            hn hnVar = (hn) message.obj;
            if (hnVar.pr != null) {
                hnVar.pr.pr();
            }
            removeMessages(1101);
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
                if (value != null && value.hw != null) {
                    value.hw.removeCallbacksAndMessages(null);
                }
                it.remove();
            }
        }
    }
}
