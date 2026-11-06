package com.byazt.vt;

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
@com.byazt.vzx.pr(pr = {0, 1, 170, 13})
public class hw implements com.byazt.at.hn, com.byazt.at.pr {
    public final Map<String, C0218hw> pr = new HashMap();

    /* JADX INFO: renamed from: com.byazt.vt.hw$hw, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 170, 497})
    private static class C0218hw {
        public int c;
        public com.byazt.dd.c fw;
        public boolean hn;
        public float hw;
        public float pr;
        public Handler uc;
        public boolean x;

        private C0218hw() {
            this.c = 500;
        }
    }

    @Override // com.byazt.at.hn
    public boolean hw(String str) {
        return "longTap".equals(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.byazt.at.hn
    public boolean pr(String str, String str2, int i, Map<String, Object> map, Map<String, Object> map2, com.byazt.dd.c cVar) {
        Object obj;
        String strPr = com.byazt.at.hw.pr(str, i);
        C0218hw c0218hw = this.pr.get(strPr);
        if (c0218hw == null) {
            c0218hw = new C0218hw();
            c0218hw.uc = pr(c0218hw, str, i);
            this.pr.put(strPr, c0218hw);
        }
        c0218hw.fw = cVar;
        if (map != null && (obj = map.get("duration")) != null) {
            c0218hw.c = com.byazt.aa.hn.pr(String.valueOf(obj), 500);
        }
        MotionEvent motionEventPr = com.byazt.vt.pr.pr(map2);
        if (motionEventPr == null) {
            if (cVar != null) {
                cVar.pr();
            }
            return true;
        }
        switch (motionEventPr.getAction()) {
            case 0:
                c0218hw.x = false;
                c0218hw.hn = false;
                c0218hw.pr = motionEventPr.getRawX();
                c0218hw.hw = motionEventPr.getRawY();
                if (c0218hw.c > 0) {
                    c0218hw.uc.removeMessages(1);
                    c0218hw.uc.sendEmptyMessageDelayed(1, c0218hw.c);
                }
                return true;
            case 1:
            case 3:
                c0218hw.uc.removeMessages(1);
                c0218hw.pr = 0.0f;
                c0218hw.hw = 0.0f;
                c0218hw.hn = false;
                c0218hw.fw = null;
                return true;
            case 2:
                if (Math.abs(motionEventPr.getRawX() - c0218hw.pr) >= 15.0f || Math.abs(motionEventPr.getRawY() - c0218hw.hw) >= 15.0f) {
                    c0218hw.hn = true;
                    c0218hw.uc.removeMessages(1);
                }
                return true;
            default:
                return true;
        }
    }

    private Handler pr(C0218hw c0218hw, String str, int i) {
        return new pr(c0218hw, str, i);
    }

    @com.byazt.vzx.pr(pr = {0, 1, 170, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    private static final class pr extends Handler {
        public final int hn;
        public final String hw;
        public final WeakReference<C0218hw> pr;

        public pr(C0218hw c0218hw, String str, int i) {
            super(Looper.getMainLooper());
            this.pr = new WeakReference<>(c0218hw);
            this.hw = str;
            this.hn = i;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C0218hw c0218hw;
            if (message.what != 1 || (c0218hw = this.pr.get()) == null || c0218hw.hn || c0218hw.x) {
                return;
            }
            c0218hw.x = true;
            if (c0218hw.fw != null) {
                c0218hw.fw.pr();
            }
        }
    }

    @Override // com.byazt.at.pr
    public void pr(String str) {
        String strPr = com.byazt.at.hw.pr(str);
        Iterator<Map.Entry<String, C0218hw>> it = this.pr.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, C0218hw> next = it.next();
            if (next.getKey() != null && next.getKey().startsWith(strPr)) {
                C0218hw value = next.getValue();
                if (value != null && value.uc != null) {
                    value.uc.removeCallbacksAndMessages(null);
                    value.fw = null;
                }
                it.remove();
            }
        }
    }
}
