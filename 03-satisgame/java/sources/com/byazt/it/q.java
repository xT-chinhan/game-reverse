package com.byazt.it;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.byazt.vy.hd;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 879, 5})
public class q {
    public static Context n;
    public static volatile n qg;
    public static volatile n s;

    public static void n(Context context) {
        n = context;
    }

    public static void n(long j) {
        n nVar = new n("sdk_init", j, 0L, 0, 0, null, null);
        qg = nVar;
        nVar.n();
    }

    public static void n(long j, int i, int i2, JSONObject jSONObject, Map<String, Object> map) {
        n nVar = new n("sdk_init_end", -1L, j, i, i2, jSONObject, map);
        s = nVar;
        nVar.n();
    }

    public static boolean n() {
        return !TextUtils.isEmpty(hd.n());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String l() {
        return hd.n();
    }

    @com.byazt.cp.n(n = {0, 1, 879, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME})
    private static class n {
        public final long fs;
        public final int l;
        public final Handler n;
        public final long q;
        public volatile boolean qg = false;
        public int rv = 0;
        public final String s;
        public Map<String, Object> tj;
        public final int w;
        public final JSONObject x;

        public static /* synthetic */ int qg(n nVar) {
            int i = nVar.rv;
            nVar.rv = i + 1;
            return i;
        }

        public n(String str, long j, long j2, int i, int i2, JSONObject jSONObject, Map<String, Object> map) {
            this.fs = j == -1 ? System.currentTimeMillis() : j;
            this.s = str;
            this.q = j2;
            this.l = i;
            this.w = i2;
            this.x = jSONObject;
            this.tj = map;
            this.n = new Handler(Looper.getMainLooper());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n() {
            this.n.postDelayed(new Runnable() { // from class: com.byazt.it.q.n.1
                @Override // java.lang.Runnable
                public void run() {
                    n.qg(n.this);
                    if (n.this.rv >= 5 || q.n()) {
                        n.this.n(1);
                    } else {
                        com.byazt.rb.qg.n("TMe", "--==-- 重试一次 eventType:" + n.this.s + ", 重试次数：" + n.this.rv);
                        n.this.n();
                    }
                }
            }, 500L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:25:0x008f  */
        public synchronized void n(int i) {
            byte b;
            this.n.removeCallbacksAndMessages(null);
            if (this.qg) {
                return;
            }
            this.qg = true;
            if (i == 1) {
                com.byazt.rb.qg.n("TMe", "--==-- 最终上报：eventType:" + this.s + ", 重试次数：" + this.rv + ", did: " + q.l());
            } else if (i == 2) {
                com.byazt.rb.qg.n("TMe", "--==-- 最终上报：eventType:" + this.s + ", 从applog回调中上报, did: " + q.l());
            }
            String str = this.s;
            int iHashCode = str.hashCode();
            if (iHashCode != -834688111) {
                if (iHashCode == 270071285 && str.equals("sdk_init")) {
                    b = 0;
                } else {
                    b = -1;
                }
            } else if (str.equals("sdk_init_end")) {
                b = 1;
            } else {
                b = -1;
            }
            if (b == 0) {
                q.qg(this.fs);
            } else {
                if (b == 1) {
                    q.n(this.q, this.l, this.w, this.fs, this.x, this.tj);
                }
            }
        }
    }

    public static void qg() {
        new com.byazt.gv.qg(1).n(new Runnable() { // from class: com.byazt.it.q.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.gp.s.s();
            }
        });
    }

    public static void s() {
        new com.byazt.gv.qg(2).n(new Runnable() { // from class: com.byazt.it.q.2
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.gp.s.n();
            }
        });
    }

    public static void qg(long j) {
        com.byazt.gp.s.n(j);
    }

    public static void n(long j, int i, int i2, long j2, JSONObject jSONObject, Map<String, Object> map) {
        com.byazt.gp.s.n(j, i, i2, j2, jSONObject, map);
    }

    public static void n(final boolean z) {
        new com.byazt.gv.qg(16).n(new Runnable() { // from class: com.byazt.it.q.3
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.gp.s.n(z);
            }
        });
    }

    public static void n(final int i, final int i2, final long j, final boolean z, final boolean z2, final JSONObject jSONObject, final long j2, final JSONObject jSONObject2) {
        new com.byazt.gv.qg(32).n(new Runnable() { // from class: com.byazt.it.q.4
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.gp.s.n(i, i2, j, z, z2, jSONObject, j2, jSONObject2);
            }
        });
    }
}
