package com.byazt.yb;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE})
public final class cy {
    public static long cp = 0;
    public static boolean d = false;
    public static final String n = "cy#";
    public static final List<com.byazt.zve.s> q = new ArrayList();
    public static final String qg = "cy#";
    public static String tj;
    public final Context fs;
    public final hd l;
    public Map<String, String> oa;
    public Long sz;
    public final boolean w;
    public final a x;
    public final ReentrantLock s = new ReentrantLock();
    public final AtomicBoolean rv = new AtomicBoolean(false);

    public cy(Context context) {
        this.fs = context.getApplicationContext();
        hd hdVarN = cd.n(context);
        this.l = hdVarN;
        if (hdVarN != null) {
            this.w = hdVarN.qg(context);
        } else {
            this.w = false;
        }
        this.x = new a(context);
    }

    public Map<String, String> n(long j) {
        if (!this.w) {
            return null;
        }
        if (!com.byazt.wv.n.qg) {
            um umVarN = this.x.n();
            if (umVarN != null) {
                return umVarN.n();
            }
            return null;
        }
        qg();
        if (this.oa == null) {
            SystemClock.elapsedRealtime();
            try {
                if (this.s.tryLock(j, TimeUnit.MILLISECONDS)) {
                    this.s.unlock();
                }
            } catch (InterruptedException e) {
                com.byazt.km.cp.n(e);
                return this.oa;
            }
        }
        return this.oa;
    }

    public static void n(com.byazt.zve.s sVar) {
        List<com.byazt.zve.s> list = q;
        synchronized (list) {
            list.add(sVar);
        }
        if (tj != null) {
            n(new com.byazt.zve.qg() { // from class: com.byazt.yb.cy.1
                @Override // com.byazt.zve.qg
                public String n() {
                    return cy.tj;
                }

                @Override // com.byazt.zve.qg
                public boolean qg() {
                    return cy.d;
                }

                @Override // com.byazt.zve.qg
                public long s() {
                    return cy.cp;
                }
            }, new Object[]{sVar});
        }
    }

    public hd n() {
        return this.l;
    }

    public static void qg(com.byazt.zve.s sVar) {
        List<com.byazt.zve.s> list = q;
        synchronized (list) {
            list.remove(sVar);
        }
    }

    private static Object[] w() {
        Object[] array;
        List<com.byazt.zve.s> list = q;
        synchronized (list) {
            array = list.size() > 0 ? list.toArray() : null;
        }
        return array;
    }

    private static void n(com.byazt.zve.qg qgVar, Object[] objArr) {
        if (qgVar == null || objArr == null) {
            return;
        }
        for (Object obj : objArr) {
            ((com.byazt.zve.s) obj).n(qgVar);
        }
    }

    public static void n(JSONObject jSONObject, String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e) {
            com.byazt.km.cp.n(e);
        }
    }

    public static <K, V> void n(Map<K, V> map, K k, V v) {
        if (k == null || v == null) {
            return;
        }
        map.put(k, v);
    }

    public void qg() {
        if (this.rv.compareAndSet(false, true)) {
            n(new Runnable() { // from class: com.byazt.yb.cy.2
                @Override // java.lang.Runnable
                public void run() {
                    cy.this.x();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        int iIntValue;
        try {
            this.s.lock();
            um umVarN = this.x.n();
            long jLongValue = -1;
            boolean z = false;
            if (umVarN != null) {
                tj = umVarN.n;
                d = umVarN.s != null && umVarN.s.booleanValue();
                cp = umVarN.x == null ? -1L : umVarN.x.longValue();
                this.oa = umVarN.n();
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            Pair<String, Boolean> pairN = n(this.fs);
            long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
            um umVar = null;
            String string = null;
            if (pairN.first != null) {
                if (umVarN != null) {
                    string = umVarN.qg;
                    iIntValue = umVarN.w.intValue() + 1;
                } else {
                    iIntValue = -1;
                }
                if (TextUtils.isEmpty(string)) {
                    string = UUID.randomUUID().toString();
                }
                String str = string;
                if (iIntValue <= 0) {
                    iIntValue = 1;
                }
                um umVar2 = new um((String) pairN.first, str, (Boolean) pairN.second, Long.valueOf(jElapsedRealtime2), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(iIntValue), this.sz);
                this.x.n(umVar2);
                umVar = umVar2;
            }
            if (umVar != null) {
                tj = umVar.n;
                if (umVar.s != null && umVar.s.booleanValue()) {
                    z = true;
                }
                d = z;
                if (umVar.x != null) {
                    jLongValue = umVar.x.longValue();
                }
                cp = jLongValue;
                this.oa = umVar.n();
            }
        } finally {
            this.s.unlock();
            n(new com.byazt.zve.qg() { // from class: com.byazt.yb.cy.3
                @Override // com.byazt.zve.qg
                public String n() {
                    return cy.tj;
                }

                @Override // com.byazt.zve.qg
                public boolean qg() {
                    return cy.d;
                }

                @Override // com.byazt.zve.qg
                public long s() {
                    return cy.cp;
                }
            }, w());
        }
    }

    private Pair<String, Boolean> n(Context context) {
        String str;
        Boolean boolValueOf;
        hd.n nVarS;
        hd hdVar = this.l;
        if (hdVar == null || (nVarS = hdVar.s(context)) == null) {
            str = null;
            boolValueOf = null;
        } else {
            str = nVarS.qg;
            boolValueOf = Boolean.valueOf(nVarS.s);
            if (nVarS instanceof rv.n) {
                this.sz = Long.valueOf(((rv.n) nVarS).n);
            }
        }
        return new Pair<>(str, boolValueOf);
    }

    private static void n(Runnable runnable) {
        fs.n(n + "-query", runnable);
    }
}
