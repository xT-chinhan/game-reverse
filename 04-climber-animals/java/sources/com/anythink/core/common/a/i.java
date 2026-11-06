package com.anythink.core.common.a;

import android.content.Context;
import com.anythink.core.common.d.u;
import com.anythink.core.common.h.bv;
import com.anythink.core.common.v.af;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class i {
    private static String a = "i";
    private static i b;
    private Context c;
    private final String f = "rpr_";
    private final String g = "bid_";
    private final Map<String, a> d = new ConcurrentHashMap();
    private final Map<String, Long> e = new ConcurrentHashMap(5);

    public static class a {
        public long a;
        public int b;
        public long c;
    }

    private i(Context context) {
        this.c = context.getApplicationContext();
    }

    public static i a(Context context) {
        if (b == null) {
            synchronized (i.class) {
                if (b == null) {
                    b = new i(context);
                }
            }
        }
        return b;
    }

    public final void a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            String.format("handleAdxCtrl, no adx ctrl, remove setting, adSourceId=%s", str);
            this.d.remove(str);
            af.a(this.c, u.b.o, c(str));
            af.a(this.c, u.b.o, d(str));
            return;
        }
        this.d.put(str, a(jSONObject));
        String string = jSONObject.toString();
        String.format("handleAdxCtrl, save setting, adSourceId=%s, setting=%s", str, string);
        af.b(this.c, u.b.o, c(str), string);
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
        aVar.b = jSONObject.optInt(com.anythink.core.common.k.aa, 2);
        aVar.c = jSONObject.optLong(com.anythink.core.common.k.V, 0L);
        return aVar;
    }

    public final void a() {
        try {
            Map<String, ?> mapB = af.b(this.c, u.b.o);
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
        String.format("recordAdxStartBidTime, adSourceId=%s", str);
        this.e.put(str, Long.valueOf(j));
        af.a(this.c, u.b.o, d(str), j);
    }

    public final boolean a(String str) {
        a aVar = this.d.get(str);
        if (aVar == null) {
            String.format("isInBidInterval, no adx ctrl, return. adSourceId=%s", str);
            return false;
        }
        long j = aVar.a;
        if (j <= 0) {
            String.format("isInBidInterval, adxBidInterval <= 0, return. adSourceId=%s", str);
            return false;
        }
        Long l = this.e.get(str);
        if (l == null) {
            String.format("isInBidInterval, adx has not initiated a bid yet, return. adSourceId=%s", str);
            return false;
        }
        if (System.currentTimeMillis() - l.longValue() > j) {
            return false;
        }
        String.format("isInBidInterval, during the bid interval, no bid can be initiated. adSourceId=%s", str);
        return true;
    }

    public final Boolean b(String str) {
        a aVar = this.d.get(str);
        if (aVar == null) {
            String.format("isInBidFailInterval, no adx ctrl, return. adSourceId=%s", str);
            return null;
        }
        long j = aVar.c;
        if (j <= 0) {
            String.format("isInBidFailInterval, adxBidFailInterval <= 0, return. adSourceId=%s", str);
            return Boolean.FALSE;
        }
        long jA = com.anythink.core.common.c.a().a(str);
        if (jA <= 0) {
            String.format("isInBidFailInterval, adx has not bid failed yet <= 0, return. adSourceId=%s", str);
            return Boolean.FALSE;
        }
        if (System.currentTimeMillis() - jA > j) {
            return Boolean.FALSE;
        }
        String.format("isInBidFailInterval, during the bid fail interval, no bid can be initiated. adSourceId=%s", str);
        return Boolean.TRUE;
    }

    public final Boolean a(bv bvVar) {
        String strZ = bvVar.z();
        a aVar = this.d.get(strZ);
        if (aVar == null) {
            String.format("isBidRealtimeSwitchOn, no adx ctrl, return. adSourceId=%s", strZ);
            return null;
        }
        if (aVar.b == 2) {
            String.format("isBidRealtimeSwitchOn, need real time bid. adSourceId=%s", strZ);
            return Boolean.TRUE;
        }
        String.format("isBidRealtimeSwitchOn, switch is off. adSourceId=%s", strZ);
        return Boolean.FALSE;
    }
}
