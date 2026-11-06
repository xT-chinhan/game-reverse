package com.anythink.basead.b.e;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.AdError;
import com.anythink.core.common.d.t;
import com.anythink.core.common.d.u;
import com.anythink.core.common.m.h;
import com.anythink.core.common.m.q;
import com.anythink.core.common.v.af;
import com.anythink.core.common.v.k;
import com.anythink.core.common.v.w;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static final String c = k.b("eyJkc3BfY2xpY2tfbWFjcm9fY29uZmlnIjp7IjQ5Ijp7Im1hcHBpbmdzIjpbeyJtYWNybyI6Il9fUkVfQ19ET1dOX1hfXyIsImFjdGlvbiI6IjMiLCJ2YWx1ZSI6IiRkeCQifSx7Im1hY3JvIjoiX19SRV9DX0RPV05fWV9fIiwiYWN0aW9uIjoiMyIsInZhbHVlIjoiJGR5JCJ9LHsibWFjcm8iOiJfX1JFX0NfVVBfWF9fIiwiYWN0aW9uIjoiMyIsInZhbHVlIjoiJHV4JCJ9LHsibWFjcm8iOiJfX1JFX0NfVVBfWV9fIiwiYWN0aW9uIjoiMyIsInZhbHVlIjoiJHV5JCJ9LHsibWFjcm8iOiJfX01fWF9BQ0NfXyIsImFjdGlvbiI6IjMiLCJ2YWx1ZSI6IiR6bWEkIn0seyJtYWNybyI6Il9fTV9ZX0FDQ19fIiwiYWN0aW9uIjoiMyIsInZhbHVlIjoiJHltYSQifSx7Im1hY3JvIjoiX19NX1pfQUNDX18iLCJhY3Rpb24iOiIzIiwidmFsdWUiOiIkem1hJCJ9XX19fQ==");
    boolean a;
    private final String b;
    private volatile String d;
    private File e;
    private final Object f;
    private final String g;
    private final String h;
    private final String i;
    private Map<String, b> j;

    private static void b() {
    }

    /* synthetic */ a(byte b) {
        this();
    }

    /* JADX INFO: renamed from: com.anythink.basead.b.e.a$a, reason: collision with other inner class name */
    private static class C0013a {
        private static final a a = new a(0);

        private C0013a() {
        }
    }

    private a() {
        this.b = getClass().getSimpleName();
        this.f = new Object();
        this.g = "tracker_mapping";
        this.h = "anythink_tracker_mapping/";
        this.i = "tracker_mapping.txt";
        this.a = false;
        try {
            this.e = new File(t.b().g().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/anythink_tracker_mapping/");
        } catch (Throwable unused) {
        }
        this.j = new HashMap();
        com.anythink.core.common.v.b.b.a().b(new Runnable() { // from class: com.anythink.basead.b.e.a.1
            @Override // java.lang.Runnable
            public final void run() {
                a aVar = a.this;
                aVar.d = aVar.c();
                a aVar2 = a.this;
                aVar2.b(aVar2.d);
            }
        }, 2);
    }

    public static a a() {
        return C0013a.a;
    }

    public final synchronized void a(Context context, final String str) {
        if (this.a) {
            return;
        }
        if (context == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        final Context applicationContext = context.getApplicationContext();
        String strC = af.c(applicationContext, u.b.a, "tracker_mapping", "");
        if (TextUtils.isEmpty(strC) || !TextUtils.equals(strC, str)) {
            this.a = true;
            try {
                new h(str).a(1, new q() { // from class: com.anythink.basead.b.e.a.2
                    @Override // com.anythink.core.common.m.q
                    public final void onLoadStart(int i) {
                    }

                    @Override // com.anythink.core.common.m.q
                    public final void onLoadFinish(int i, Object obj) {
                        String string = obj != null ? obj.toString() : "";
                        if (!TextUtils.isEmpty(string)) {
                            String unused = a.this.b;
                            a.this.d = string;
                            a.b(a.this, string);
                            af.b(applicationContext, u.b.a, "tracker_mapping", str);
                            a aVar = a.this;
                            aVar.b(aVar.d);
                        }
                        a.this.a = false;
                    }

                    @Override // com.anythink.core.common.m.q
                    public final void onLoadError(int i, String str2, AdError adError) {
                        a.this.a = false;
                        String unused = a.this.b;
                    }

                    @Override // com.anythink.core.common.m.q
                    public final void onLoadCanceled(int i) {
                        a.this.a = false;
                    }
                });
            } catch (Throwable unused) {
                this.a = false;
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.b.e.a$3, reason: invalid class name */
    final class AnonymousClass3 implements Runnable {
        final /* synthetic */ String a;

        AnonymousClass3(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (a.this.f) {
                try {
                    if (!a.this.e.exists()) {
                        a.this.e.mkdirs();
                    }
                    File file = new File(a.this.e, "tracker_mapping.txt");
                    if (file.exists()) {
                        file.delete();
                    }
                    w.a(this.a.getBytes(), file);
                } catch (Throwable unused) {
                }
            }
        }
    }

    private void c(String str) {
        com.anythink.core.common.v.b.b.a().b(new AnonymousClass3(str), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c() {
        String strA;
        synchronized (this.f) {
            strA = c;
            try {
                File file = new File(this.e, "tracker_mapping.txt");
                if (file.exists() && file.canRead()) {
                    strA = w.a(file);
                }
            } catch (Throwable unused) {
            }
        }
        return strA;
    }

    public final b a(String str) {
        Map<String, b> map = this.j;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public final void b(String str) {
        JSONArray jSONArrayOptJSONArray;
        try {
            Map<String, b> map = this.j;
            if (map == null) {
                return;
            }
            map.clear();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("dsp_click_macro_config");
            if (jSONObjectOptJSONObject != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(next);
                    if (jSONObjectOptJSONObject2 != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray("mappings")) != null) {
                        b bVar = new b();
                        bVar.a(jSONArrayOptJSONArray);
                        this.j.put(next, bVar);
                    }
                }
            }
            new StringBuilder("fillTrackerMappingJson:").append(jSONObjectOptJSONObject);
        } catch (Throwable unused) {
        }
    }

    static /* synthetic */ void b(a aVar, String str) {
        com.anythink.core.common.v.b.b.a().b(aVar.new AnonymousClass3(str), 2);
    }
}
