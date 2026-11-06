package com.anythink.core.common.m.b;

import com.taptap.sdk.kit.internal.http.TapHttp;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public final class ad {
    final v a;
    final String b;
    final u c;
    final ae d;
    final Map<Class<?>, Object> e;
    private volatile d f;

    ad(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c.a();
        this.d = aVar.d;
        this.e = com.anythink.core.common.m.b.a.c.a(aVar.e);
    }

    public final v a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final u c() {
        return this.c;
    }

    public final String a(String str) {
        return this.c.a(str);
    }

    public final List<String> b(String str) {
        return this.c.b(str);
    }

    public final ae d() {
        return this.d;
    }

    private Object h() {
        return Object.class.cast(this.e.get(Object.class));
    }

    private <T> T a(Class<? extends T> cls) {
        return cls.cast(this.e.get(cls));
    }

    public final a e() {
        return new a(this);
    }

    public final d f() {
        d dVar = this.f;
        if (dVar != null) {
            return dVar;
        }
        d dVarA = d.a(this.c);
        this.f = dVarA;
        return dVarA;
    }

    public final boolean g() {
        return this.a.c();
    }

    public final String toString() {
        return "Request{method=" + this.b + ", url=" + this.a + ", tags=" + this.e + AbstractJsonLexerKt.END_OBJ;
    }

    public static class a {
        v a;
        String b;
        u.a c;
        ae d;
        Map<Class<?>, Object> e;

        public a() {
            this.e = Collections.emptyMap();
            this.b = TapHttp.METHOD_GET;
            this.c = new u.a();
        }

        a(ad adVar) {
            Map<Class<?>, Object> linkedHashMap;
            this.e = Collections.emptyMap();
            this.a = adVar.a;
            this.b = adVar.b;
            this.d = adVar.d;
            if (adVar.e.isEmpty()) {
                linkedHashMap = Collections.emptyMap();
            } else {
                linkedHashMap = new LinkedHashMap<>(adVar.e);
            }
            this.e = linkedHashMap;
            this.c = adVar.c.b();
        }

        public final a a(v vVar) {
            if (vVar == null) {
                throw new NullPointerException("url == null");
            }
            this.a = vVar;
            return this;
        }

        public final a a(String str) {
            if (str == null) {
                throw new NullPointerException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = "https:" + str.substring(4);
            }
            return a(v.e(str));
        }

        private a a(URL url) {
            if (url == null) {
                throw new NullPointerException("url == null");
            }
            return a(v.e(url.toString()));
        }

        public final a a(String str, String str2) {
            this.c.d(str, str2);
            return this;
        }

        public final a b(String str, String str2) {
            this.c.a(str, str2);
            return this;
        }

        public final a b(String str) {
            this.c.b(str);
            return this;
        }

        public final a a(u uVar) {
            this.c = uVar.b();
            return this;
        }

        private a a(d dVar) {
            String string = dVar.toString();
            return string.isEmpty() ? b("Cache-Control") : a("Cache-Control", string);
        }

        public final a a() {
            return a(TapHttp.METHOD_GET, (ae) null);
        }

        private a c() {
            return a("HEAD", (ae) null);
        }

        private a a(ae aeVar) {
            return a(TapHttp.METHOD_POST, aeVar);
        }

        private a b(ae aeVar) {
            return a("DELETE", aeVar);
        }

        private a d() {
            return a("DELETE", com.anythink.core.common.m.b.a.c.e);
        }

        private a c(ae aeVar) {
            return a("PUT", aeVar);
        }

        private a d(ae aeVar) {
            return a("PATCH", aeVar);
        }

        public final a a(String str, ae aeVar) {
            if (str == null) {
                throw new NullPointerException("method == null");
            }
            if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            }
            if (aeVar != null && !com.anythink.core.common.m.b.a.c.f.c(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            }
            if (aeVar == null && com.anythink.core.common.m.b.a.c.f.b(str)) {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            }
            this.b = str;
            this.d = aeVar;
            return this;
        }

        private a a(Object obj) {
            if (obj == null) {
                this.e.remove(Object.class);
            } else {
                if (this.e.isEmpty()) {
                    this.e = new LinkedHashMap();
                }
                this.e.put(Object.class, Object.class.cast(obj));
            }
            return this;
        }

        private <T> a a(Class<? super T> cls, T t) {
            if (t == null) {
                this.e.remove(cls);
            } else {
                if (this.e.isEmpty()) {
                    this.e = new LinkedHashMap();
                }
                this.e.put(cls, cls.cast(t));
            }
            return this;
        }

        public final ad b() {
            if (this.a == null) {
                throw new IllegalStateException("url == null");
            }
            return new ad(this);
        }
    }
}
