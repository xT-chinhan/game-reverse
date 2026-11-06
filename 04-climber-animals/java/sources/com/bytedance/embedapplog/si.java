package com.bytedance.embedapplog;

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
final class si {
    private static String ch = null;
    private static final List<ka> d = new ArrayList();
    private static long hi = 0;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    static final String f521ms = "si#";
    private static boolean sl = false;
    private static final String xr = "si#";
    private final mh ab;
    private final boolean c;
    private final pl ka;
    private Long u;
    private final Context x;
    private Map<String, String> zb;
    private final ReentrantLock ah = new ReentrantLock();
    private final AtomicBoolean ny = new AtomicBoolean(false);

    si(Context context) {
        this.x = context.getApplicationContext();
        pl plVarMs = di.ms(context);
        this.ka = plVarMs;
        if (plVarMs != null) {
            this.c = plVarMs.ms(context);
        } else {
            this.c = false;
        }
        this.ab = new mh(context);
    }

    public Map<String, String> ms(long j) {
        if (!this.c) {
            return null;
        }
        if (!ms.xr) {
            a aVarMs = this.ab.ms();
            if (aVarMs != null) {
                return aVarMs.ms();
            }
            return null;
        }
        xr();
        if (this.zb == null) {
            SystemClock.elapsedRealtime();
            try {
                if (this.ah.tryLock(j, TimeUnit.MILLISECONDS)) {
                    this.ah.unlock();
                }
            } catch (InterruptedException e) {
                oh.ms(e);
                return this.zb;
            }
        }
        return this.zb;
    }

    static void ms(ka kaVar) {
        List<ka> list = d;
        synchronized (list) {
            list.add(kaVar);
        }
        if (ch != null) {
            ms(new ka.ms(ch, sl, hi), new Object[]{kaVar});
        }
    }

    public pl ms() {
        return this.ka;
    }

    private static Object[] ah() {
        Object[] array;
        List<ka> list = d;
        synchronized (list) {
            array = list.size() > 0 ? list.toArray() : null;
        }
        return array;
    }

    private static void ms(ka.ms msVar, Object[] objArr) {
        if (msVar == null || objArr == null) {
            return;
        }
        for (Object obj : objArr) {
            ((ka) obj).ms(msVar);
        }
    }

    static void ms(JSONObject jSONObject, String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e) {
            oh.ms(e);
        }
    }

    static <K, V> void ms(Map<K, V> map, K k, V v) {
        if (k == null || v == null) {
            return;
        }
        map.put(k, v);
    }

    public void xr() {
        if (this.ny.compareAndSet(false, true)) {
            ms(new Runnable() { // from class: com.bytedance.embedapplog.si.1
                @Override // java.lang.Runnable
                public void run() {
                    si.this.d();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        int iIntValue;
        try {
            this.ah.lock();
            a aVarMs = this.ab.ms();
            long jLongValue = -1;
            boolean z = false;
            if (aVarMs != null) {
                ch = aVarMs.f475ms;
                sl = aVarMs.ah != null && aVarMs.ah.booleanValue();
                hi = aVarMs.ab == null ? -1L : aVarMs.ab.longValue();
                this.zb = aVarMs.ms();
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            Pair<String, Boolean> pairMs = ms(this.x);
            long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
            a aVar = null;
            String string = null;
            if (pairMs.first != null) {
                if (aVarMs != null) {
                    string = aVarMs.xr;
                    iIntValue = aVarMs.c.intValue() + 1;
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
                a aVar2 = new a((String) pairMs.first, str, (Boolean) pairMs.second, Long.valueOf(jElapsedRealtime2), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(iIntValue), this.u);
                this.ab.ms(aVar2);
                aVar = aVar2;
            }
            if (aVar != null) {
                ch = aVar.f475ms;
                if (aVar.ah != null && aVar.ah.booleanValue()) {
                    z = true;
                }
                sl = z;
                if (aVar.ab != null) {
                    jLongValue = aVar.ab.longValue();
                }
                hi = jLongValue;
                this.zb = aVar.ms();
            }
        } finally {
            this.ah.unlock();
            ms(new ka.ms(ch, sl, hi), ah());
        }
    }

    private Pair<String, Boolean> ms(Context context) {
        String str;
        Boolean boolValueOf;
        pl.ms msVarXr;
        pl plVar = this.ka;
        if (plVar == null || (msVarXr = plVar.xr(context)) == null) {
            str = null;
            boolValueOf = null;
        } else {
            str = msVarXr.xr;
            boolValueOf = Boolean.valueOf(msVarXr.ah);
            if (msVarXr instanceof gs.ms) {
                this.u = Long.valueOf(((gs.ms) msVarXr).f489ms);
            }
        }
        return new Pair<>(str, boolValueOf);
    }

    private static void ms(Runnable runnable) {
        kl.ms(f521ms + "-query", runnable);
    }
}
