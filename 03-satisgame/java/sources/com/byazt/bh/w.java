package com.byazt.bh;

import android.content.ContentValues;
import android.text.TextUtils;
import com.anythink.core.d.b.e;
import com.anythink.core.e.i;
import com.byazt.gct.fs;
import com.byazt.qit.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 125, 13})
public class w {
    public static final w n = new w();
    public static volatile n q;
    public static final n qg;
    public static volatile long s;
    public final Map<String, qg> l = new ConcurrentHashMap();

    interface n {
        void n(long j);

        void n(ContentValues contentValues);
    }

    static {
        n nVar = new n() { // from class: com.byazt.bh.w.1
            @Override // com.byazt.bh.w.n
            public void n(ContentValues contentValues) {
                l.n(contentValues);
            }

            @Override // com.byazt.bh.w.n
            public void n(long j) {
                l.n(j);
            }
        };
        qg = nVar;
        s = -1L;
        q = nVar;
    }

    public static w n() {
        return n;
    }

    public boolean n(int i) {
        fs.s sVarN = fs.n(i);
        if (sVarN == null || sVarN.hd() == null) {
            return false;
        }
        return sVarN.hd().n(i);
    }

    public void n(String str, int i, String str2, long j) {
        qg qgVarPutIfAbsent;
        if (!n(i) || TextUtils.isEmpty(str)) {
            return;
        }
        qg qgVar = this.l.get(str);
        if (qgVar == null && (qgVarPutIfAbsent = this.l.putIfAbsent(str, (qgVar = new qg()))) != null) {
            qgVar = qgVarPutIfAbsent;
        }
        synchronized (qgVar) {
            if (j <= 0) {
                j = System.currentTimeMillis();
                qgVar.n = j;
                qgVar.qg = i;
                qgVar.s = str2;
                qgVar.q = 0L;
                qgVar.l = 0L;
                qgVar.w = 0L;
                qgVar.x = false;
                qgVar.fs = false;
                qgVar.rv = 0L;
                qgVar.tj = 0L;
                qgVar.cp = 0L;
                qgVar.d = 0L;
                qgVar.oa = 0L;
            } else {
                qgVar.n = j;
                qgVar.qg = i;
                qgVar.s = str2;
                qgVar.q = 0L;
                qgVar.l = 0L;
                qgVar.w = 0L;
                qgVar.x = false;
                qgVar.fs = false;
                qgVar.rv = 0L;
                qgVar.tj = 0L;
                qgVar.cp = 0L;
                qgVar.d = 0L;
                qgVar.oa = 0L;
            }
            throw th;
        }
    }

    public void n(String str, long j, long j2) {
        qg qgVar;
        if (TextUtils.isEmpty(str) || (qgVar = this.l.get(str)) == null) {
            return;
        }
        synchronized (qgVar) {
            if (qgVar.d <= 0 && j > 0) {
                qgVar.d = j;
            }
            if (qgVar.oa <= 0 && j2 > 0) {
                qgVar.oa = j2;
            }
        }
    }

    public void n(String str, long j) {
        qg qgVar;
        if (TextUtils.isEmpty(str) || (qgVar = this.l.get(str)) == null) {
            return;
        }
        if (j <= 0) {
            j = System.currentTimeMillis();
        }
        synchronized (qgVar) {
            if (qgVar.n <= 0) {
                return;
            }
            if (qgVar.rv <= 0) {
                qgVar.rv = Math.max(0L, j - qgVar.n);
            }
        }
    }

    public void qg(String str, long j) {
        qg qgVar;
        if (TextUtils.isEmpty(str) || (qgVar = this.l.get(str)) == null) {
            return;
        }
        if (j <= 0) {
            j = System.currentTimeMillis();
        }
        synchronized (qgVar) {
            if (qgVar.cp <= 0) {
                qgVar.cp = j;
            }
        }
    }

    public void s(String str, long j) {
        qg qgVar;
        if (TextUtils.isEmpty(str) || (qgVar = this.l.get(str)) == null) {
            return;
        }
        if (j <= 0) {
            j = System.currentTimeMillis();
        }
        synchronized (qgVar) {
            if (qgVar.n <= 0) {
                qgVar.n = j;
            }
            if (qgVar.q <= 0) {
                qgVar.q = Math.max(0L, j - qgVar.n);
            }
            if (qgVar.tj <= 0 && qgVar.cp > 0) {
                qgVar.tj = Math.max(0L, j - qgVar.cp);
            }
            qgVar.fs = true;
        }
    }

    public void q(final String str, final long j) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.ag.qg.n(new x("tmax_record_on_cached") { // from class: com.byazt.bh.w.2
            @Override // java.lang.Runnable
            public void run() {
                qg qgVar = (qg) w.this.l.get(str);
                if (qgVar == null) {
                    return;
                }
                long jCurrentTimeMillis = j;
                if (jCurrentTimeMillis <= 0) {
                    jCurrentTimeMillis = System.currentTimeMillis();
                }
                synchronized (qgVar) {
                    if (qgVar.n <= 0) {
                        return;
                    }
                    if (qgVar.l <= 0) {
                        qgVar.l = Math.max(0L, jCurrentTimeMillis - qgVar.n);
                    }
                }
            }
        });
    }

    public void l(String str, long j) {
        qg qgVar;
        if (TextUtils.isEmpty(str) || (qgVar = this.l.get(str)) == null) {
            return;
        }
        if (j <= 0) {
            j = System.currentTimeMillis();
        }
        synchronized (qgVar) {
            if (qgVar.x) {
                return;
            }
            qgVar.x = true;
            if (qgVar.n <= 0) {
                qgVar.n = j;
            }
            qgVar.w = Math.max(0L, j - qgVar.n);
        }
    }

    public void w(String str, long j) {
        qg qgVar;
        if (TextUtils.isEmpty(str) || (qgVar = this.l.get(str)) == null) {
            return;
        }
        if (j <= 0) {
            j = System.currentTimeMillis();
        }
        synchronized (qgVar) {
            if (qgVar.fs) {
                if (qgVar.n <= 0) {
                    qgVar.n = j;
                }
                ContentValues contentValuesN = n(str, qgVar, j);
                this.l.remove(str);
                n(contentValuesN);
            }
        }
    }

    private ContentValues n(String str, qg qgVar, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("load_id", str);
        contentValues.put("ad_slot_type", Integer.valueOf(qgVar.qg));
        contentValues.put("ad_slot_id", qgVar.s);
        contentValues.put("loaded_duration", Long.valueOf(qgVar.q));
        contentValues.put("cached_duration", Long.valueOf(qgVar.l));
        contentValues.put("shown_duration", Long.valueOf(qgVar.w));
        contentValues.put("is_shown", Integer.valueOf(qgVar.x ? 1 : 0));
        contentValues.put(e.a.i, Long.valueOf(j));
        contentValues.put("pre_time", Long.valueOf(qgVar.rv + Math.max(0L, qgVar.d)));
        contentValues.put("after_time", Long.valueOf(qgVar.tj + Math.max(0L, qgVar.oa)));
        return contentValues;
    }

    private void n(ContentValues contentValues) {
        q.n(contentValues);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - s > 86400000) {
            s = jCurrentTimeMillis;
            final long j = jCurrentTimeMillis - i.f;
            if (j > 0) {
                com.byazt.ag.qg.n(new x("tmax_record_cleanup") { // from class: com.byazt.bh.w.3
                    @Override // java.lang.Runnable
                    public void run() {
                        w.q.n(j);
                    }
                });
            }
        }
    }

    @com.byazt.cp.n(n = {0, 1, 125, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUX_NONBLOCK_READ})
    private static class qg {
        public long cp;
        public long d;
        public boolean fs;
        public long l;
        public long n;
        public long oa;
        public long q;
        public int qg;
        public long rv;
        public String s;
        public long tj;
        public long w;
        public boolean x;

        private qg() {
        }
    }
}
