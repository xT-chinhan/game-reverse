package com.anythink.core.common;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.h.bq;
import com.anythink.core.common.v.af;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class v {
    private static final String b = "v";
    private static volatile v f;
    Context a;
    private final Map<String, Integer> c = new ConcurrentHashMap(8);
    private final Map<String, bq> d = new ConcurrentHashMap(8);
    private final Map<String, Boolean> e = new ConcurrentHashMap(8);

    public static v a(Context context) {
        if (f == null) {
            synchronized (v.class) {
                if (f == null) {
                    f = new v(context);
                }
            }
        }
        return f;
    }

    private v(Context context) {
        this.a = context.getApplicationContext();
    }

    public final void a(String str, String str2, boolean z) {
        bq bqVar;
        if (TextUtils.isEmpty(str) || (bqVar = this.d.get(str)) == null || !TextUtils.equals(str2, bqVar.a())) {
            return;
        }
        bqVar.a(z);
    }

    private boolean c(String str) {
        Boolean boolValueOf = this.e.get(str);
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(af.c(this.a, com.anythink.core.common.d.u.b.l, str));
            if (boolValueOf.booleanValue()) {
                af.b(this.a, com.anythink.core.common.d.u.b.l, str);
            }
            this.e.put(str, Boolean.FALSE);
        }
        new StringBuilder("checkFirstLoadAfterInstall: ").append(str).append(", is first load after install: ").append(boolValueOf);
        return boolValueOf.booleanValue();
    }

    public final void a(String str) {
        Integer num = this.c.get(str);
        if (num == null) {
            this.c.put(str, 1);
        } else {
            num.intValue();
            this.c.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    public final int b(String str) {
        Integer num = this.c.get(str);
        if (num == null) {
            return 1;
        }
        return num.intValue();
    }

    public final bq a(String str, String str2) {
        Boolean boolValueOf = this.e.get(str);
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(af.c(this.a, com.anythink.core.common.d.u.b.l, str));
            if (boolValueOf.booleanValue()) {
                af.b(this.a, com.anythink.core.common.d.u.b.l, str);
            }
            this.e.put(str, Boolean.FALSE);
        }
        new StringBuilder("checkFirstLoadAfterInstall: ").append(str).append(", is first load after install: ").append(boolValueOf);
        boolean zBooleanValue = boolValueOf.booleanValue();
        bq bqVarRemove = this.d.remove(str);
        if (bqVarRemove == null) {
            bqVarRemove = new bq("", zBooleanValue);
        }
        this.d.put(str, new bq(str2, false));
        return bqVarRemove;
    }
}
