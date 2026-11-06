package com.anythink.core.common.v;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.anythink.core.api.AdError;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g {
    private static volatile g d;
    private String g;
    private File i;
    private String l;
    private String m;
    private final String c = getClass().getSimpleName();
    private final String e = k.b("aHR0cHM6Ly9tb3Jlcy5hbnl0aGlua3RlY2guY29tL3RpbmlmeS90YWt1X2FkeF9leHRfcmVzX2pzb24udHh0");
    private final String f = "adx_optional_res.txt";
    private final String h = "anythink_optres/";
    boolean a = false;
    final String b = "adx_optional_res_url";
    private final Object j = new Object();
    private Map<String, String> k = new HashMap();

    public static g a() {
        if (d == null) {
            synchronized (g.class) {
                if (d == null) {
                    d = new g();
                }
            }
        }
        return d;
    }

    public final void a(final Context context) {
        try {
            this.i = new File(com.anythink.core.common.d.t.b().g().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/anythink_optres/");
        } catch (Throwable unused) {
        }
        com.anythink.core.common.v.b.b.a().b(new Runnable() { // from class: com.anythink.core.common.v.g.1
            @Override // java.lang.Runnable
            public final void run() {
                g.this.d(context);
                g gVar = g.this;
                gVar.k = gVar.d("adx_optional_res.txt");
            }
        }, 2);
    }

    public final boolean b(Context context) {
        if (this.a) {
            return false;
        }
        com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(context).b(com.anythink.core.common.d.t.b().p());
        String strZ = (bVarB == null || bVarB.R()) ? "" : bVarB.Z();
        if (TextUtils.isEmpty(strZ)) {
            strZ = this.e;
        }
        if (TextUtils.isEmpty(strZ) || TextUtils.equals(this.m, strZ)) {
            return false;
        }
        String strB = b();
        if (!TextUtils.isEmpty(strB) && TextUtils.equals(strB, strZ)) {
            if (this.k.isEmpty()) {
                this.k = d("adx_optional_res.txt");
            }
            return false;
        }
        this.g = strZ;
        return true;
    }

    public final void c(final Context context) {
        if (b(context)) {
            this.a = true;
            try {
                new com.anythink.core.common.m.h(this.g).a(1, new com.anythink.core.common.m.q() { // from class: com.anythink.core.common.v.g.2
                    @Override // com.anythink.core.common.m.q
                    public final void onLoadStart(int i) {
                    }

                    @Override // com.anythink.core.common.m.q
                    public final void onLoadFinish(int i, Object obj) {
                        String string = obj != null ? obj.toString() : "";
                        String unused = g.this.c;
                        String unused2 = g.this.g;
                        string.length();
                        if (!TextUtils.isEmpty(string)) {
                            g gVar = g.this;
                            gVar.a(context, gVar.g);
                            g gVar2 = g.this;
                            gVar2.k = gVar2.e(string);
                            g.a(g.this, string, "adx_optional_res.txt");
                        }
                        g.this.a = false;
                    }

                    @Override // com.anythink.core.common.m.q
                    public final void onLoadError(int i, String str, AdError adError) {
                        g gVar = g.this;
                        gVar.m = gVar.g;
                        g.this.a = false;
                        com.anythink.core.common.u.e.a(3, g.this.g, adError != null ? adError.printStackTrace() : "");
                    }

                    @Override // com.anythink.core.common.m.q
                    public final void onLoadCanceled(int i) {
                        g.this.a = false;
                    }
                });
            } catch (Throwable unused) {
                this.a = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Map<String, String> d(String str) throws Throwable {
        Map<String, String> mapE;
        synchronized (this.j) {
            String strA = "";
            try {
                File file = new File(this.i, str);
                if (file.exists() && file.canRead()) {
                    strA = w.a(file);
                }
            } catch (Throwable unused) {
            }
            mapE = e(strA);
        }
        return mapE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Map<String, String> e(String str) {
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

    /* JADX INFO: renamed from: com.anythink.core.common.v.g$3, reason: invalid class name */
    final class AnonymousClass3 implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        AnonymousClass3(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (g.this.j) {
                try {
                    if (!g.this.i.exists()) {
                        g.this.i.mkdirs();
                    }
                    File file = new File(g.this.i, this.a);
                    if (file.exists()) {
                        file.delete();
                    }
                    w.a(this.b.getBytes(), file);
                } catch (Throwable unused) {
                }
            }
        }
    }

    private void a(String str, String str2) {
        com.anythink.core.common.v.b.b.a().b(new AnonymousClass3(str2, str), 2);
    }

    public final String a(String str) {
        Map<String, String> map = this.k;
        return (map == null || map.isEmpty()) ? "" : this.k.get(str);
    }

    public final boolean b(String str) {
        Map<String, String> map = this.k;
        if (map != null && !map.isEmpty()) {
            String str2 = this.k.get(str);
            if (!TextUtils.isEmpty(str2) && com.anythink.core.common.res.b.a(com.anythink.core.common.d.t.b().g()).b(new com.anythink.core.common.res.e(3, str2), 0, 0) != null) {
                return true;
            }
        }
        return false;
    }

    public final Bitmap c(String str) {
        Map<String, String> map = this.k;
        if (map == null || map.isEmpty()) {
            return null;
        }
        String str2 = this.k.get(str);
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        return com.anythink.core.common.res.b.a(com.anythink.core.common.d.t.b().g()).b(new com.anythink.core.common.res.e(3, str2), 0, 0);
    }

    private void a(List<String> list, String str) {
        if (list == null) {
            return;
        }
        String strA = a(str);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        list.add(strA);
    }

    public final void a(Set<String> set, String str) {
        String strA = a(str);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        set.add(strA);
    }

    private synchronized String b() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(Context context, String str) {
        this.l = str;
        af.b(context, com.anythink.core.common.d.u.b.a, "adx_optional_res_url", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d(Context context) {
        if (context == null) {
            context = com.anythink.core.common.d.t.b().g();
        }
        this.l = af.c(context, com.anythink.core.common.d.u.b.a, "adx_optional_res_url", "");
    }

    static /* synthetic */ void a(g gVar, String str, String str2) {
        com.anythink.core.common.v.b.b.a().b(gVar.new AnonymousClass3(str2, str), 2);
    }
}
