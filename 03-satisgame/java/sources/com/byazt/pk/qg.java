package com.byazt.pk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 36, 26})
public class qg implements com.byazt.sx.n, com.byazt.sx.s {
    public final Map<String, C0297qg> n = new HashMap();

    /* JADX INFO: renamed from: com.byazt.pk.qg$qg, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 36, 201})
    private static class C0297qg {
        public int l;
        public float n;
        public boolean q;
        public float qg;
        public boolean s;
        public Handler w;
        public com.byazt.xz.l x;

        private C0297qg() {
            this.l = 500;
        }
    }

    @Override // com.byazt.sx.s
    public boolean qg(String str) {
        return "longTap".equals(str);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x007c  */
    @Override // com.byazt.sx.s
    public boolean n(String str, String str2, int i, Map<String, Object> map, Map<String, Object> map2, com.byazt.xz.l lVar) {
        Object obj;
        String strN = com.byazt.sx.qg.n(str, i);
        C0297qg c0297qg = this.n.get(strN);
        if (c0297qg == null) {
            c0297qg = new C0297qg();
            c0297qg.w = n(c0297qg, str, i);
            this.n.put(strN, c0297qg);
        }
        c0297qg.x = lVar;
        if (map != null && (obj = map.get(MediationConstant.EXTRA_DURATION)) != null) {
            c0297qg.l = com.byazt.hb.s.n(String.valueOf(obj), 500);
        }
        MotionEvent motionEventN = com.byazt.pk.n.n(map2);
        if (motionEventN == null) {
            if (lVar != null) {
                lVar.n();
            }
            return true;
        }
        int action = motionEventN.getAction();
        if (action == 0) {
            c0297qg.q = false;
            c0297qg.s = false;
            c0297qg.n = motionEventN.getRawX();
            c0297qg.qg = motionEventN.getRawY();
            if (c0297qg.l > 0) {
                c0297qg.w.removeMessages(1);
                c0297qg.w.sendEmptyMessageDelayed(1, c0297qg.l);
            }
        } else if (action == 1) {
            c0297qg.w.removeMessages(1);
            c0297qg.n = 0.0f;
            c0297qg.qg = 0.0f;
            c0297qg.s = false;
            c0297qg.x = null;
        } else if (action != 2) {
            if (action == 3) {
                c0297qg.w.removeMessages(1);
                c0297qg.n = 0.0f;
                c0297qg.qg = 0.0f;
                c0297qg.s = false;
                c0297qg.x = null;
            }
        } else if (Math.abs(motionEventN.getRawX() - c0297qg.n) >= 15.0f || Math.abs(motionEventN.getRawY() - c0297qg.qg) >= 15.0f) {
            c0297qg.s = true;
            c0297qg.w.removeMessages(1);
        }
        return true;
    }

    private Handler n(C0297qg c0297qg, String str, int i) {
        return new n(c0297qg, str, i);
    }

    @com.byazt.cp.n(n = {0, 1, 36, 48})
    private static final class n extends Handler {
        public final WeakReference<C0297qg> n;
        public final String qg;
        public final int s;

        public n(C0297qg c0297qg, String str, int i) {
            super(Looper.getMainLooper());
            this.n = new WeakReference<>(c0297qg);
            this.qg = str;
            this.s = i;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C0297qg c0297qg;
            if (message.what != 1 || (c0297qg = this.n.get()) == null || c0297qg.s || c0297qg.q) {
                return;
            }
            c0297qg.q = true;
            if (c0297qg.x != null) {
                c0297qg.x.n();
            }
        }
    }

    @Override // com.byazt.sx.n
    public void n(String str, int i) {
        C0297qg c0297qgRemove = this.n.remove(com.byazt.sx.qg.n(str, i));
        if (c0297qgRemove == null || c0297qgRemove.w == null) {
            return;
        }
        c0297qgRemove.w.removeCallbacksAndMessages(null);
        c0297qgRemove.x = null;
    }

    @Override // com.byazt.sx.n
    public void n(String str) {
        String strN = com.byazt.sx.qg.n(str);
        Iterator<Map.Entry<String, C0297qg>> it = this.n.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, C0297qg> next = it.next();
            if (next.getKey() != null && next.getKey().startsWith(strN)) {
                C0297qg value = next.getValue();
                if (value != null && value.w != null) {
                    value.w.removeCallbacksAndMessages(null);
                    value.x = null;
                }
                it.remove();
            }
        }
    }
}
