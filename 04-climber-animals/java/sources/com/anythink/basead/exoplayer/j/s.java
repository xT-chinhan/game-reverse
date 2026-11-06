package com.anythink.basead.exoplayer.j;

import android.text.TextUtils;
import com.anythink.basead.exoplayer.k.af;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface s extends h {
    public static final com.anythink.basead.exoplayer.k.u<String> c = new com.anythink.basead.exoplayer.k.u<String>() { // from class: com.anythink.basead.exoplayer.j.s.1
        @Override // com.anythink.basead.exoplayer.k.u
        public final /* synthetic */ boolean a(String str) {
            String strD = af.d(str);
            if (TextUtils.isEmpty(strD)) {
                return false;
            }
            return ((strD.contains("text") && !strD.contains(com.anythink.basead.exoplayer.k.o.O)) || strD.contains(com.baidu.mobads.sdk.internal.a.f) || strD.contains("xml")) ? false : true;
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        private static boolean a2(String str) {
            String strD = af.d(str);
            if (TextUtils.isEmpty(strD)) {
                return false;
            }
            return ((strD.contains("text") && !strD.contains(com.anythink.basead.exoplayer.k.o.O)) || strD.contains(com.baidu.mobads.sdk.internal.a.f) || strD.contains("xml")) ? false : true;
        }
    };

    public interface b extends h.a {
        @Deprecated
        void a(String str);

        @Deprecated
        void a(String str, String str2);

        @Override // com.anythink.basead.exoplayer.j.h.a
        /* JADX INFO: renamed from: b */
        s a();

        f c();

        @Deprecated
        void d();
    }

    @Override // com.anythink.basead.exoplayer.j.h
    int a(byte[] bArr, int i, int i2);

    @Override // com.anythink.basead.exoplayer.j.h
    long a(k kVar);

    void a(String str);

    void a(String str, String str2);

    @Override // com.anythink.basead.exoplayer.j.h
    void b();

    Map<String, List<String>> c();

    void d();

    public static final class f {
        private final Map<String, String> a = new HashMap();
        private Map<String, String> b;

        public final synchronized void a(String str, String str2) {
            this.b = null;
            this.a.put(str, str2);
        }

        private synchronized void a(Map<String, String> map) {
            this.b = null;
            this.a.putAll(map);
        }

        private synchronized void b(Map<String, String> map) {
            this.b = null;
            this.a.clear();
            this.a.putAll(map);
        }

        public final synchronized void a(String str) {
            this.b = null;
            this.a.remove(str);
        }

        public final synchronized void a() {
            this.b = null;
            this.a.clear();
        }

        public final synchronized Map<String, String> b() {
            if (this.b == null) {
                this.b = Collections.unmodifiableMap(new HashMap(this.a));
            }
            return this.b;
        }
    }

    public static abstract class a implements b {
        private final f a = new f();

        protected abstract s a(f fVar);

        @Override // com.anythink.basead.exoplayer.j.s.b, com.anythink.basead.exoplayer.j.h.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final s a() {
            return a(this.a);
        }

        @Override // com.anythink.basead.exoplayer.j.s.b
        public final f c() {
            return this.a;
        }

        @Override // com.anythink.basead.exoplayer.j.s.b
        @Deprecated
        public final void a(String str, String str2) {
            this.a.a(str, str2);
        }

        @Override // com.anythink.basead.exoplayer.j.s.b
        @Deprecated
        public final void a(String str) {
            this.a.a(str);
        }

        @Override // com.anythink.basead.exoplayer.j.s.b
        @Deprecated
        public final void d() {
            this.a.a();
        }
    }

    public static class c extends IOException {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public final int d;
        public final k e;

        @Retention(RetentionPolicy.SOURCE)
        public @interface a {
        }

        private c(k kVar, int i) {
            this.e = kVar;
            this.d = i;
        }

        public c(String str, k kVar) {
            super(str);
            this.e = kVar;
            this.d = 1;
        }

        public c(IOException iOException, k kVar, int i) {
            super(iOException);
            this.e = kVar;
            this.d = i;
        }

        public c(String str, IOException iOException, k kVar) {
            super(str, iOException);
            this.e = kVar;
            this.d = 1;
        }
    }

    public static final class d extends c {
        public final String f;

        public d(String str, k kVar) {
            super("Invalid content type: ".concat(String.valueOf(str)), kVar);
            this.f = str;
        }
    }

    public static final class e extends c {
        public final int f;
        public final Map<String, List<String>> g;

        public e(int i, Map<String, List<String>> map, k kVar) {
            super("Response code: ".concat(String.valueOf(i)), kVar);
            this.f = i;
            this.g = map;
        }
    }
}
