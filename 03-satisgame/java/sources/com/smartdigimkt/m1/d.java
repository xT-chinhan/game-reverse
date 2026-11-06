package com.smartdigimkt.m1;

import android.text.TextUtils;
import com.smartdigimkt.i3.o;
import com.smartdigimkt.r4.e;
import com.smartdigimkt.r4.q;
import com.smartdigimkt.z.d0;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static volatile d j;
    public String c;
    public File d;
    public String h;
    public String i;
    public final String a = com.anythink.core.e.d.a;
    public final String b = e.a("aHR0cHM6Ly9tb3Jlcy5hbnl0aGlua3RlY2guY29tL3RpbmlmeS90YWt1X2FkeF9leHRfcmVzX2pzb24udHh0");
    public boolean e = false;
    public final Object f = new Object();
    public Map g = new HashMap();

    public static d a() {
        if (j == null) {
            synchronized (d.class) {
                if (j == null) {
                    j = new d();
                }
            }
        }
        return j;
    }

    public final boolean b() {
        String str;
        if (this.e) {
            return false;
        }
        String str2 = "";
        com.smartdigimkt.p4.a aVarA = com.smartdigimkt.o4.e.c().a();
        if (aVarA != null && !aVarA.g) {
            str2 = aVarA.P;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = this.b;
        }
        if (TextUtils.isEmpty(str2) || TextUtils.equals(this.i, str2)) {
            return false;
        }
        synchronized (this) {
            str = this.h;
        }
        if (TextUtils.isEmpty(str) || !TextUtils.equals(str, str2)) {
            this.c = str2;
            return true;
        }
        if (this.g.isEmpty()) {
            this.g = c();
        }
        return false;
    }

    public final synchronized HashMap c() {
        synchronized (this.f) {
            if (this.d == null) {
                return new HashMap();
            }
            String strC = "";
            try {
                File file = new File(this.d, "adx_optional_res.txt");
                if (file.exists() && file.canRead()) {
                    strC = q.c(file);
                }
            } catch (Throwable unused) {
            }
            return a(strC);
        }
    }

    public final synchronized HashMap a(String str) {
        HashMap map = new HashMap();
        if (TextUtils.isEmpty(str)) {
            return map;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.optString(next));
            }
        } catch (Throwable unused) {
        }
        return map;
    }

    public final boolean c(String str) {
        Map map = this.g;
        if (map == null || map.isEmpty()) {
            return false;
        }
        String str2 = (String) this.g.get(str);
        return (TextUtils.isEmpty(str2) || d0.a().b(new o(3, str2), 0, 0) == null) ? false : true;
    }

    public final void a(HashSet hashSet, String str) {
        String strB = b(str);
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        hashSet.add(strB);
    }

    public final String b(String str) {
        Map map = this.g;
        return (map == null || map.isEmpty()) ? "" : (String) this.g.get(str);
    }
}
