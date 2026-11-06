package com.anythink.china.b;

import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.api.AdError;
import com.anythink.core.common.d.t;
import com.anythink.core.common.d.u;
import com.anythink.core.common.e.g;
import com.anythink.core.common.m.q;
import com.anythink.core.common.v.af;
import com.anythink.pd.ExHandler;
import java.io.File;
import java.util.Iterator;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static long a = 1800000;
    private static volatile e b = null;
    private static long c = 1800000;
    private Long d = 0L;
    private boolean e = false;

    public static e a() {
        if (b == null) {
            synchronized (e.class) {
                if (b == null) {
                    b = new e();
                }
            }
        }
        return b;
    }

    private e() {
    }

    public final void b() {
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(t.b().g()).b(t.b().p());
            if (bVarB != null) {
                long jA = bVarB.a();
                c = jA;
                if (jA > 0) {
                    b(jA);
                    com.anythink.core.common.u.e.a("1", "0", "", "", "", String.valueOf(c), jElapsedRealtime);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void a(long j) {
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            c = j;
            if (j > 0) {
                b(j);
                com.anythink.core.common.u.e.a("1", "1", "", "", "", String.valueOf(c), jElapsedRealtime);
            } else {
                com.anythink.core.common.u.e.a("1", "2", "", "", "", String.valueOf(j), jElapsedRealtime);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void b(long j) {
        try {
            if (this.d.longValue() == 0) {
                this.d = Long.valueOf(af.b(t.b().g(), u.b.a, u.a.E, 0L));
            }
            if (System.currentTimeMillis() - this.d.longValue() > j) {
                d();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private synchronized void d() {
        try {
            if (f.a().b().isEmpty()) {
                return;
            }
            final long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (this.e) {
                return;
            }
            this.e = true;
            new b(t.b().g(), t.b().p(), t.b().q(), null).a(0, new q() { // from class: com.anythink.china.b.e.1
                @Override // com.anythink.core.common.m.q
                public final void onLoadStart(int i) {
                    e.this.e = true;
                }

                @Override // com.anythink.core.common.m.q
                public final void onLoadFinish(int i, Object obj) {
                    JSONObject jSONObjectOptJSONObject;
                    JSONObject jSONObjectOptJSONObject2;
                    new StringBuilder("onLoadFinish:").append(i).append(":").append(obj);
                    try {
                        e.this.e = false;
                        e.this.d = Long.valueOf(System.currentTimeMillis());
                        af.a(t.b().g(), u.b.a, u.a.E, System.currentTimeMillis());
                        com.anythink.core.common.u.e.a("1", "", "", "1", "", String.valueOf(e.c), jElapsedRealtime);
                        if (obj == null || (jSONObjectOptJSONObject = ((JSONObject) obj).optJSONObject("items")) == null) {
                            return;
                        }
                        Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            if (!TextUtils.isEmpty(next) && (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(next)) != null) {
                                e.a(next, jSONObjectOptJSONObject2);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }

                @Override // com.anythink.core.common.m.q
                public final void onLoadError(int i, String str, AdError adError) {
                    e.this.e = false;
                    if (adError != null) {
                        str = adError.getFullErrorInfo();
                    }
                    com.anythink.core.common.u.e.a("1", "", "", "2", str, String.valueOf(e.c), jElapsedRealtime);
                }

                @Override // com.anythink.core.common.m.q
                public final void onLoadCanceled(int i) {
                    e.this.e = false;
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, JSONObject jSONObject) {
        try {
            a aVarA = a.a(str, jSONObject);
            if (aVarA != null) {
                new StringBuilder("handlePluginsResponse:").append(aVarA);
                File fileA = com.anythink.china.b.a.a(t.b().g(), String.valueOf(aVarA.f()));
                if (fileA != null) {
                    if (new File(fileA.getAbsolutePath(), aVarA.b() + ".jar").exists()) {
                        new StringBuilder("handlePlugins has download:").append(aVarA);
                        return;
                    }
                    File file = new File(fileA.getAbsolutePath(), aVarA.b() + ".tmp");
                    if (file.exists()) {
                        file.delete();
                    }
                    try {
                        if (TextUtils.isEmpty(aVarA.c())) {
                            return;
                        }
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        d dVar = new d(aVarA.c(), file, aVarA);
                        dVar.a(new AnonymousClass2(jElapsedRealtime));
                        dVar.d();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void a(a aVar, File file) {
        try {
            if (TextUtils.isEmpty(aVar.c())) {
                return;
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            d dVar = new d(aVar.c(), file, aVar);
            dVar.a(new AnonymousClass2(jElapsedRealtime));
            dVar.d();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: com.anythink.china.b.e$2, reason: invalid class name */
    final class AnonymousClass2 implements d.a {
        final /* synthetic */ long a;

        AnonymousClass2(long j) {
            this.a = j;
        }

        @Override // com.anythink.china.b.d.a
        public final void a(File file, a aVar) {
            new StringBuilder("onLoadSuccess:").append(file);
            if (file == null || aVar == null) {
                return;
            }
            if (file.exists() && aVar.e() == file.length() && aVar.d().equals(com.anythink.china.b.a.a(file.getAbsolutePath()))) {
                file.renameTo(new File(file.getAbsolutePath().replace(".tmp", ".jar")));
            }
            com.anythink.core.common.u.e.a("2", "", aVar.a(), "1", "", String.valueOf(e.c), this.a);
        }

        @Override // com.anythink.china.b.d.a
        public final void a(File file, a aVar, String str, String str2) {
            new StringBuilder("onLoadFail:").append(str).append(":").append(str2).append(":").append(file);
            if (file == null || aVar == null) {
                return;
            }
            if (file.exists()) {
                file.delete();
            }
            com.anythink.core.common.u.e.a("2", "", aVar.a(), "2", str2, String.valueOf(e.c), this.a);
        }
    }

    public static class a {
        private String a;
        private String b;
        private String c;
        private long d;
        private long e;
        private int f;
        private int g;
        private JSONObject h;

        public final String a() {
            JSONObject jSONObject = this.h;
            return jSONObject != null ? jSONObject.toString() : "";
        }

        static a a(String str, JSONObject jSONObject) {
            Integer numValueOf;
            try {
                numValueOf = Integer.valueOf(Integer.parseInt(str));
            } catch (Exception e) {
                e.printStackTrace();
                numValueOf = null;
            }
            if (numValueOf == null) {
                return null;
            }
            a aVar = new a(numValueOf, jSONObject);
            af.a(t.b().g(), u.b.a, u.a.D + aVar.f, aVar.g);
            if (TextUtils.isEmpty(aVar.b) || TextUtils.isEmpty(aVar.a) || TextUtils.isEmpty(aVar.c)) {
                return null;
            }
            return aVar;
        }

        private a(Integer num, JSONObject jSONObject) {
            if (jSONObject != null) {
                this.h = jSONObject;
                this.f = num.intValue();
                this.g = jSONObject.optInt("forbid", 2);
                this.a = jSONObject.optString("update_ver");
                this.b = jSONObject.optString("dl_url");
                this.c = jSONObject.optString("md5");
                this.d = jSONObject.optLong(ExHandler.JSON_REQUEST_UPDATE_TS);
                this.e = jSONObject.optLong(g.a.D, 0L);
            }
        }

        public final String b() {
            return this.a;
        }

        public final String c() {
            return this.b;
        }

        public final String d() {
            return this.c;
        }

        private long g() {
            return this.d;
        }

        public final long e() {
            return this.e;
        }

        public final int f() {
            return this.f;
        }

        private int h() {
            return this.g;
        }

        public final String toString() {
            return "{pl_update_ver='" + this.a + "', pl_url='" + this.b + "', pl_md5='" + this.c + "', pl_update_time=" + this.d + ", pl_file_size=" + this.e + ", pl_id=" + this.f + ", pl_forbid=" + this.g + AbstractJsonLexerKt.END_OBJ;
        }
    }
}
