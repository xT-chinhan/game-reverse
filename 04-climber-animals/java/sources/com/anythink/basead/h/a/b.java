package com.anythink.basead.h.a;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.basead.d.c;
import com.anythink.core.common.h.ay;
import com.anythink.core.d.l;
import com.anythink.core.d.n;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    private static b a;
    private Context b;
    private ConcurrentHashMap<String, c> d = new ConcurrentHashMap<>();
    private SimpleDateFormat c = new SimpleDateFormat("yyyyMMdd");

    private b(Context context) {
        this.b = context.getApplicationContext();
    }

    public static b a(Context context) {
        if (a == null) {
            a = new b(context);
        }
        return a;
    }

    public final void a(ay ayVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str = this.c.format(new Date(jCurrentTimeMillis));
        final c cVarD = d(ayVar);
        if (cVarD.f.equals(str)) {
            cVarD.d++;
        } else {
            cVarD.d = 1;
            cVarD.f = str;
        }
        cVarD.e = jCurrentTimeMillis;
        com.anythink.core.common.v.b.b.a().b(new Runnable() { // from class: com.anythink.basead.h.a.b.1
            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.basead.c.a.a(b.this.b).c(cVarD.f);
                com.anythink.basead.c.a.a(b.this.b).a(cVarD);
            }
        }, 2);
    }

    public final boolean b(ay ayVar) {
        return ayVar.c != -1 && d(ayVar).d >= ayVar.c;
    }

    public final boolean c(ay ayVar) {
        return System.currentTimeMillis() - d(ayVar).e <= ayVar.d;
    }

    public final String a() {
        List<c> listB = com.anythink.basead.c.a.a(this.b).b(this.c.format(new Date(System.currentTimeMillis())));
        JSONArray jSONArray = new JSONArray();
        if (listB != null) {
            Iterator<c> it = listB.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().a);
            }
        }
        return jSONArray.toString();
    }

    public final boolean a(String str) {
        List<ay> listAa;
        l lVarA = n.a(this.b).a(str);
        if (lVarA == null || (listAa = lVarA.aa()) == null || listAa.size() <= 0) {
            return false;
        }
        Iterator<ay> it = listAa.iterator();
        while (it.hasNext()) {
            if (!b(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final c d(ay ayVar) {
        String str = this.c.format(new Date(System.currentTimeMillis()));
        c cVarA = this.d.get(ayVar.v());
        if (cVarA == null) {
            cVarA = com.anythink.basead.c.a.a(this.b).a(ayVar.v());
            if (cVarA == null) {
                cVarA = new c();
                cVarA.a = ayVar.v();
                cVarA.b = ayVar.c;
                cVarA.c = ayVar.d;
                cVarA.e = 0L;
                cVarA.d = 0;
                cVarA.f = str;
            }
            this.d.put(ayVar.v(), cVarA);
        }
        if (!TextUtils.equals(str, cVarA.f)) {
            cVarA.f = str;
            cVarA.d = 0;
        }
        return cVarA;
    }
}
