package com.anythink.core.common;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.h.ac;
import com.anythink.core.common.h.bv;
import com.anythink.core.common.v.af;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class d {
    private static final String a = "d";
    private static volatile d e;
    private Context b;
    private final Map<String, ac> c = new ConcurrentHashMap(8);
    private Map<String, String> d;

    public static d a() {
        if (e == null) {
            synchronized (d.class) {
                if (e == null) {
                    e = new d();
                }
            }
        }
        return e;
    }

    private d() {
    }

    public final void a(String str, ac acVar) {
        new StringBuilder("putBiddingRecorder, placementId: ").append(str).append(", currentBiddingRecorder: ").append(acVar);
        this.c.put(str, acVar);
    }

    public final void a(String str, String str2, String str3) {
        bv bvVarA;
        ac acVar = this.c.get(str);
        if (acVar == null || (bvVarA = acVar.a()) == null || !TextUtils.equals(bvVarA.z(), str3) || !TextUtils.equals(acVar.c(), str2)) {
            return;
        }
        acVar.d();
        b(str);
    }

    public final void b(String str, String str2, String str3) {
        bv bvVarA;
        ac acVar = this.c.get(str);
        if (acVar == null || (bvVarA = acVar.a()) == null || !TextUtils.equals(bvVarA.z(), str3) || !TextUtils.equals(acVar.c(), str2)) {
            return;
        }
        acVar.e();
        b(str);
    }

    public final ac a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ac acVarRemove = this.c.remove(str);
        new StringBuilder("popBiddingRecorder, placementId: ").append(str).append(", lastBiddingRecorder: ").append(acVarRemove);
        if (acVarRemove != null) {
            af.a(this.b, com.anythink.core.common.d.u.b.n, str);
        }
        return acVarRemove;
    }

    public final void a(Context context) {
        ac acVarA;
        this.b = context;
        try {
            Map<String, ?> mapB = af.b(context, com.anythink.core.common.d.u.b.n);
            if (mapB != null) {
                for (Map.Entry<String, ?> entry : mapB.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    if ((value instanceof String) && (acVarA = ac.a((String) value)) != null) {
                        this.c.put(key, acVarA);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void b(String str) {
        try {
            ac acVar = this.c.get(str);
            if (acVar != null) {
                af.b(this.b, com.anythink.core.common.d.u.b.n, str, acVar.i().toString());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final synchronized void a(String str, String str2) {
        if (this.d == null) {
            this.d = new ConcurrentHashMap();
        }
        this.d.put(str, str2);
    }

    public final synchronized String c(String str) {
        Map<String, String> map = this.d;
        if (map == null) {
            return null;
        }
        return map.remove(str);
    }
}
