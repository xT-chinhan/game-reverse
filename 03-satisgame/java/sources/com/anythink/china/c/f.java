package com.anythink.china.c;

import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.api.AdError;
import com.anythink.core.common.d.s;
import com.anythink.core.common.d.t;
import com.anythink.core.common.u.ad;
import java.io.File;
import java.util.Iterator;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f {
    public static long a = 1800000;
    private static volatile f b = null;
    private static long c = 1800000;
    private Long d = 0L;
    private boolean e = false;

    public static f a() {
        if (b == null) {
            synchronized (f.class) {
                if (b == null) {
                    b = new f();
                }
            }
        }
        return b;
    }

    private f() {
    }

    public final void b() {
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(s.b().g()).b(s.b().p());
            if (bVarB != null) {
                long jA = bVarB.a();
                c = jA;
                if (jA > 0) {
                    b(jA);
                    com.anythink.core.common.t.f.a("1", "0", "", "", "", String.valueOf(c), jElapsedRealtime);
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
                com.anythink.core.common.t.f.a("1", "1", "", "", "", String.valueOf(c), jElapsedRealtime);
            } else {
                com.anythink.core.common.t.f.a("1", "2", "", "", "", String.valueOf(j), jElapsedRealtime);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void b(long j) {
        try {
            if (this.d.longValue() == 0) {
                this.d = Long.valueOf(ad.b(s.b().g(), t.b.a, t.a.H, 0L));
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
            if (g.a().b().isEmpty()) {
                return;
            }
            final long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (this.e) {
                return;
            }
            this.e = true;
            new b(s.b().g(), s.b().p(), s.b().q(), null).a(0, new com.anythink.core.common.l.s() { // from class: com.anythink.china.c.f.1
                @Override // com.anythink.core.common.l.s
                public final void onLoadStart(int i) {
                    f.this.e = true;
                }

                @Override // com.anythink.core.common.l.s
                public final void onLoadFinish(int i, Object obj) {
                    JSONObject jSONObjectOptJSONObject;
                    JSONObject jSONObjectOptJSONObject2;
                    try {
                        f.this.e = false;
                        f.this.d = Long.valueOf(System.currentTimeMillis());
                        ad.a(s.b().g(), t.b.a, t.a.H, System.currentTimeMillis());
                        com.anythink.core.common.t.f.a("1", "", "", "1", "", String.valueOf(f.c), jElapsedRealtime);
                        if (obj == null || (jSONObjectOptJSONObject = ((JSONObject) obj).optJSONObject("items")) == null) {
                            return;
                        }
                        Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            if (!TextUtils.isEmpty(next) && (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(next)) != null) {
                                f.a(next, jSONObjectOptJSONObject2);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }

                @Override // com.anythink.core.common.l.s
                public final void onLoadError(int i, String str, AdError adError) {
                    f.this.e = false;
                    if (adError != null) {
                        str = adError.getFullErrorInfo();
                    }
                    com.anythink.core.common.t.f.a("1", "", "", "2", str, String.valueOf(f.c), jElapsedRealtime);
                }

                @Override // com.anythink.core.common.l.s
                public final void onLoadCanceled(int i) {
                    f.this.e = false;
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, JSONObject jSONObject) {
        File fileA;
        try {
            a aVarA = a.a(str, jSONObject);
            if (aVarA == null || (fileA = com.anythink.china.c.a.a(s.b().g(), String.valueOf(aVarA.f()))) == null || new File(fileA.getAbsolutePath(), aVarA.b() + ".jar").exists()) {
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
                e eVar = new e(aVarA.c(), file, aVarA);
                eVar.a(new AnonymousClass2(jElapsedRealtime));
                eVar.d();
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
            e.printStackTrace();
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
            e eVar = new e(aVar.c(), file, aVar);
            eVar.a(new AnonymousClass2(jElapsedRealtime));
            eVar.d();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: com.anythink.china.c.f$2, reason: invalid class name */
    final class AnonymousClass2 implements e.a {
        final /* synthetic */ long a;

        AnonymousClass2(long j) {
            this.a = j;
        }

        @Override // com.anythink.china.c.e.a
        public final void a(File file, a aVar) {
            if (file == null || aVar == null) {
                return;
            }
            if (file.exists() && aVar.e() == file.length() && aVar.d().equals(com.anythink.china.c.a.a(file.getAbsolutePath()))) {
                file.renameTo(new File(file.getAbsolutePath().replace(".tmp", ".jar")));
            }
            com.anythink.core.common.t.f.a("2", "", aVar.a(), "1", "", String.valueOf(f.c), this.a);
        }

        @Override // com.anythink.china.c.e.a
        public final void a(File file, a aVar, String str) {
            if (file == null || aVar == null) {
                return;
            }
            if (file.exists()) {
                file.delete();
            }
            com.anythink.core.common.t.f.a("2", "", aVar.a(), "2", str, String.valueOf(f.c), this.a);
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
            ad.a(s.b().g(), t.b.a, t.a.G + aVar.f, aVar.g);
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
                this.d = jSONObject.optLong("update_ts");
                this.e = jSONObject.optLong("file_size", 0L);
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
