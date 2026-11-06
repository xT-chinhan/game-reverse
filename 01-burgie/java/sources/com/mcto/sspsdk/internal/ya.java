package com.mcto.sspsdk.internal;

import com.mcto.sspsdk.QyCustomMade;
import com.mcto.sspsdk.QyLocation;
import com.mcto.sspsdk.QySdk;
import com.umeng.analytics.pro.an;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONStringer;

/* JADX INFO: loaded from: classes2.dex */
public final class ya {
    public static final HashSet F = new HashSet(Arrays.asList(an.av, "n", "m", "w", "ltt", "lgt", "oaid"));
    public static HashMap G;
    public String A;
    public final String B;
    public final String C;
    public final String D;
    public final String E;
    public String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public String j;
    public final HashMap k;
    public HashMap l;
    public HashMap m;
    public int n;
    public int o;
    public long p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public String y;
    public String z;

    public ya(mh mhVar) {
        y4 y4Var = y4.r;
        this.b = y4Var.i();
        this.c = y4Var.e();
        this.B = gj.d(y4Var.g());
        this.C = y4Var.b();
        this.D = y4Var.h();
        QyCustomMade qyCustomMade = rd.d;
        this.E = qyCustomMade != null ? qyCustomMade.getOaid() : null;
        this.f = rd.f;
        this.d = QySdk.SDK_VERSION;
        this.e = y4Var.c();
        this.h = ha.a();
        if (mhVar != null) {
            this.i = mhVar.g;
            this.j = mhVar.f;
            this.k = mhVar.o;
            this.g = "" + mhVar.e;
        }
        HashMap map = this.k;
        if (map == null || map.isEmpty()) {
            this.k = G;
        } else {
            G = this.k;
        }
    }

    public final void a(JSONStringer jSONStringer) {
        QyLocation qyLocation;
        QyLocation qyLocation2;
        try {
            HashMap map = new HashMap(32);
            HashMap map2 = this.k;
            if (map2 != null) {
                map.putAll(map2);
            }
            map.put(an.aH, this.b);
            map.put(an.av, this.c);
            map.put("nw", this.g);
            map.put("e", this.i);
            map.put("n", this.B);
            map.put("w", this.C);
            map.put("m", this.D);
            map.put("oaid", this.E);
            map.put(an.aB, Long.valueOf(System.currentTimeMillis()));
            map.put("av", this.d);
            map.put("vv", this.e);
            map.put("rnw", this.h);
            map.put("skt", "1");
            QyCustomMade qyCustomMade = rd.d;
            String str = "";
            map.put("ltt", (qyCustomMade == null || (qyLocation2 = qyCustomMade.getQyLocation()) == null) ? "" : "" + qyLocation2.mLatitude);
            QyCustomMade qyCustomMade2 = rd.d;
            if (qyCustomMade2 != null && (qyLocation = qyCustomMade2.getQyLocation()) != null) {
                str = "" + qyLocation.mLongitude;
            }
            map.put("lgt", str);
            map.put("pn", jd.a.getPackageName());
            a(map, F);
            map.put("encv", "1");
            if (rd.a()) {
                map.put("y", this.f);
                QyCustomMade qyCustomMade3 = rd.d;
                map.put("mk", qyCustomMade3 != null ? qyCustomMade3.getChannelId() : null);
            } else {
                map.put("sspd", this.f);
                map.put("sspt", "1");
            }
            for (Map.Entry entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    jSONStringer.key((String) entry.getKey()).value(entry.getValue());
                }
            }
        } catch (JSONException e) {
            r9.a("ssp_sdk", "toJsonObject(): ", e);
        }
    }

    public static void a(HashMap map, HashSet hashSet) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            stringBuffer.append(str).append(":").append(gj.f(map.containsKey(str) ? String.valueOf(map.get(str)) : "")).append(";");
            map.remove(str);
        }
        map.put("encp", gj.b(32, stringBuffer.deleteCharAt(stringBuffer.length() - 1).toString(), "e84584df1113ff82bccbdfef9b69c2f3"));
    }
}
