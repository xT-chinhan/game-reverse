package com.anythink.core.common.a;

import android.content.Context;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.by;
import com.anythink.core.common.k;
import com.anythink.core.common.u.ad;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d {
    private static String a = "d";
    private static d b;
    private final Context c;
    private final String f = "rpr_";
    private final String g = "bid_";
    private final Map<String, a> d = new ConcurrentHashMap();
    private final Map<String, Long> e = new ConcurrentHashMap(5);

    public static class a {
        public long a;
        public int b;
        public long c;
    }

    private d(Context context) {
        this.c = context.getApplicationContext();
    }

    public static d a(Context context) {
        if (b == null) {
            synchronized (d.class) {
                if (b == null) {
                    b = new d(context);
                }
            }
        }
        return b;
    }

    public final void a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            this.d.remove(str);
            ad.a(this.c, t.b.k, c(str));
            ad.a(this.c, t.b.k, d(str));
        } else {
            this.d.put(str, a(jSONObject));
            ad.b(this.c, t.b.k, c(str), jSONObject.toString());
        }
    }

    private static String c(String str) {
        return "rpr_".concat(String.valueOf(str));
    }

    private static String d(String str) {
        return "bid_".concat(String.valueOf(str));
    }

    private static a a(JSONObject jSONObject) {
        a aVar = new a();
        aVar.a = jSONObject.optLong("bid_inr", 0L);
        aVar.b = jSONObject.optInt(k.ab, 2);
        aVar.c = jSONObject.optLong(k.W, 0L);
        return aVar;
    }

    public final void a() {
        try {
            Map<String, ?> mapB = ad.b(this.c, t.b.k);
            if (mapB == null || mapB.size() <= 0) {
                return;
            }
            for (Map.Entry<String, ?> entry : mapB.entrySet()) {
                String key = entry.getKey();
                if (key != null) {
                    if (key.startsWith("rpr_")) {
                        Object value = entry.getValue();
                        if (value instanceof String) {
                            try {
                                a aVarA = a(new JSONObject((String) value));
                                this.d.put(key.replace("rpr_", ""), aVarA);
                            } catch (Throwable unused) {
                            }
                        }
                    } else if (key.startsWith("bid_")) {
                        Object value2 = entry.getValue();
                        if (value2 instanceof Long) {
                            this.e.put(key.replace("bid_", ""), (Long) value2);
                        }
                    }
                }
            }
        } catch (Throwable unused2) {
        }
    }

    public final void a(String str, long j) {
        this.e.put(str, Long.valueOf(j));
        ad.a(this.c, t.b.k, d(str), j);
    }

    public final boolean a(String str) {
        Long l;
        a aVar = this.d.get(str);
        if (aVar == null) {
            return false;
        }
        long j = aVar.a;
        return j > 0 && (l = this.e.get(str)) != null && System.currentTimeMillis() - l.longValue() <= j;
    }

    public final Boolean b(String str) {
        a aVar = this.d.get(str);
        if (aVar == null) {
            return null;
        }
        long j = aVar.c;
        if (j <= 0) {
            return Boolean.FALSE;
        }
        long jA = com.anythink.core.common.c.a().a(str);
        if (jA <= 0) {
            return Boolean.FALSE;
        }
        if (System.currentTimeMillis() - jA > j) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public final Boolean a(by byVar) {
        a aVar = this.d.get(byVar.G());
        if (aVar == null) {
            return null;
        }
        if (aVar.b == 2) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
