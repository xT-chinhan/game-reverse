package com.anythink.core.common;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.h.bs;
import com.anythink.core.common.u.ad;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class u {
    private static final String b = "u";
    private static volatile u f;
    Context a;
    private final Map<String, Integer> c = new ConcurrentHashMap(8);
    private final Map<String, bs> d = new ConcurrentHashMap(8);
    private final Map<String, Boolean> e = new ConcurrentHashMap(8);

    public static u a(Context context) {
        if (f == null) {
            synchronized (u.class) {
                if (f == null) {
                    f = new u(context);
                }
            }
        }
        return f;
    }

    private u(Context context) {
        this.a = context.getApplicationContext();
    }

    public final void a(String str, String str2, boolean z) {
        bs bsVar;
        if (TextUtils.isEmpty(str) || (bsVar = this.d.get(str)) == null || !TextUtils.equals(str2, bsVar.a())) {
            return;
        }
        bsVar.a(z);
    }

    private boolean b(String str) {
        Boolean boolValueOf = this.e.get(str);
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ad.c(this.a, com.anythink.core.common.d.t.b.i, str));
            if (boolValueOf.booleanValue()) {
                ad.b(this.a, com.anythink.core.common.d.t.b.i, str);
            }
            this.e.put(str, Boolean.FALSE);
        }
        return boolValueOf.booleanValue();
    }

    public final void a(String str) {
        Integer num = this.c.get(str);
        if (num == null) {
            this.c.put(str, 1);
        } else {
            this.c.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    private int c(String str) {
        Integer num = this.c.get(str);
        if (num == null) {
            return 1;
        }
        return num.intValue();
    }

    public final bs a(String str, String str2) {
        Boolean boolValueOf = this.e.get(str);
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ad.c(this.a, com.anythink.core.common.d.t.b.i, str));
            if (boolValueOf.booleanValue()) {
                ad.b(this.a, com.anythink.core.common.d.t.b.i, str);
            }
            this.e.put(str, Boolean.FALSE);
        }
        boolean zBooleanValue = boolValueOf.booleanValue();
        bs bsVarRemove = this.d.remove(str);
        if (bsVarRemove == null) {
            bsVarRemove = new bs("", zBooleanValue);
        }
        this.d.put(str, new bs(str2, false));
        return bsVarRemove;
    }
}
