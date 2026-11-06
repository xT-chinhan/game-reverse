package com.byazt.xev;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
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
@com.byazt.vzx.pr(pr = {0, 1, 75, 74})
public final class nt {
    public static final String hw;
    public static boolean k;
    public static final String pr;
    public static String vk;
    public static long w;
    public static final List<com.byazt.lq.hn> x;
    public final yb c;
    public final a fw;
    public Long g;
    public Map<String, String> m;
    public final boolean uc;
    public final Context zo;
    public final ReentrantLock hn = new ReentrantLock();
    public final AtomicBoolean aj = new AtomicBoolean(false);

    static {
        String str = nt.class.getSimpleName() + "#";
        hw = str;
        pr = str;
        x = new ArrayList();
    }

    public nt(Context context) {
        this.zo = context.getApplicationContext();
        yb ybVarPr = lb.pr(context);
        this.c = ybVarPr;
        if (ybVarPr != null) {
            this.uc = ybVarPr.hw(context);
        } else {
            this.uc = false;
        }
        this.fw = new a(context);
    }

    public Map<String, String> pr(long j) {
        if (!this.uc) {
            return null;
        }
        if (!com.byazt.zrg.pr.hw) {
            qa qaVarPr = this.fw.pr();
            if (qaVarPr != null) {
                return qaVarPr.pr();
            }
            return null;
        }
        hw();
        if (this.m == null) {
            SystemClock.elapsedRealtime();
            try {
                if (this.hn.tryLock(j, TimeUnit.MILLISECONDS)) {
                    this.hn.unlock();
                }
            } catch (InterruptedException e) {
                com.byazt.ec.w.pr(e);
                return this.m;
            }
        }
        return this.m;
    }

    public static void pr(com.byazt.lq.hn hnVar) {
        List<com.byazt.lq.hn> list = x;
        synchronized (list) {
            list.add(hnVar);
        }
        if (vk != null) {
            pr(new com.byazt.lq.hw() { // from class: com.byazt.xev.nt.1
                @Override // com.byazt.lq.hw
                public String pr() {
                    return nt.vk;
                }

                @Override // com.byazt.lq.hw
                public boolean hw() {
                    return nt.k;
                }

                @Override // com.byazt.lq.hw
                public long hn() {
                    return nt.w;
                }
            }, new Object[]{hnVar});
        }
    }

    public yb pr() {
        return this.c;
    }

    public static void hw(com.byazt.lq.hn hnVar) {
        List<com.byazt.lq.hn> list = x;
        synchronized (list) {
            list.remove(hnVar);
        }
    }

    private static Object[] uc() {
        Object[] array;
        List<com.byazt.lq.hn> list = x;
        synchronized (list) {
            if (list.size() <= 0) {
                array = null;
            } else {
                array = list.toArray();
            }
        }
        return array;
    }

    private static void pr(com.byazt.lq.hw hwVar, Object[] objArr) {
        if (hwVar != null && objArr != null) {
            for (Object obj : objArr) {
                ((com.byazt.lq.hn) obj).pr(hwVar);
            }
        }
    }

    public static void pr(JSONObject jSONObject, String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            try {
                jSONObject.put(str, obj);
            } catch (JSONException e) {
                com.byazt.ec.w.pr(e);
            }
        }
    }

    public static <K, V> void pr(Map<K, V> map, K k2, V v) {
        if (k2 != null && v != null) {
            map.put(k2, v);
        }
    }

    public void hw() {
        if (this.aj.compareAndSet(false, true)) {
            pr(new Runnable() { // from class: com.byazt.xev.nt.2
                @Override // java.lang.Runnable
                public void run() {
                    nt.this.fw();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fw() {
        String string;
        try {
            this.hn.lock();
            qa qaVarPr = this.fw.pr();
            boolean z = false;
            if (qaVarPr != null) {
                vk = qaVarPr.pr;
                k = qaVarPr.hn != null && qaVarPr.hn.booleanValue();
                w = qaVarPr.fw == null ? -1L : qaVarPr.fw.longValue();
                this.m = qaVarPr.pr();
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            Pair<String, Boolean> pairPr = pr(this.zo);
            long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
            qa qaVar = null;
            String str = null;
            if (pairPr.first != null) {
                int iIntValue = -1;
                if (qaVarPr != null) {
                    str = qaVarPr.hw;
                    iIntValue = qaVarPr.uc.intValue() + 1;
                }
                if (!TextUtils.isEmpty(str)) {
                    string = str;
                } else {
                    string = UUID.randomUUID().toString();
                }
                if (iIntValue <= 0) {
                    iIntValue = 1;
                }
                qa qaVar2 = new qa((String) pairPr.first, string, (Boolean) pairPr.second, Long.valueOf(jElapsedRealtime2), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(iIntValue), this.g);
                this.fw.pr(qaVar2);
                qaVar = qaVar2;
            }
            if (qaVar != null) {
                vk = qaVar.pr;
                if (qaVar.hn != null && qaVar.hn.booleanValue()) {
                    z = true;
                }
                k = z;
                w = qaVar.fw != null ? qaVar.fw.longValue() : -1L;
                this.m = qaVar.pr();
            }
        } finally {
            this.hn.unlock();
            pr(new com.byazt.lq.hw() { // from class: com.byazt.xev.nt.3
                @Override // com.byazt.lq.hw
                public String pr() {
                    return nt.vk;
                }

                @Override // com.byazt.lq.hw
                public boolean hw() {
                    return nt.k;
                }

                @Override // com.byazt.lq.hw
                public long hn() {
                    return nt.w;
                }
            }, uc());
        }
    }

    private Pair<String, Boolean> pr(Context context) {
        Boolean boolValueOf;
        yb.pr prVarHn;
        yb ybVar = this.c;
        String str = null;
        if (ybVar != null && (prVarHn = ybVar.hn(context)) != null) {
            str = prVarHn.hw;
            boolValueOf = Boolean.valueOf(prVarHn.hn);
            if (prVarHn instanceof aj.pr) {
                this.g = Long.valueOf(((aj.pr) prVarHn).pr);
            }
        } else {
            boolValueOf = null;
        }
        return new Pair<>(str, boolValueOf);
    }

    private static void pr(Runnable runnable) {
        zo.pr(pr + "-query", runnable);
    }
}
