package com.anythink.core.common.inner.e;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static final String a = "b";
    private Map<String, AbstractC0023b> b;

    /* synthetic */ b(byte b) {
        this();
    }

    private b() {
        this.b = new HashMap(2);
    }

    public static b a() {
        return a.a;
    }

    private static class a {
        private static final b a = new b(0);

        private a() {
        }
    }

    public final void a(String str, AbstractC0023b abstractC0023b) {
        this.b.put(str, abstractC0023b);
    }

    public final AbstractC0023b a(String str) {
        return this.b.get(str);
    }

    public final void b(String str) {
        this.b.remove(str);
    }

    /* JADX INFO: renamed from: com.anythink.core.common.inner.e.b$b, reason: collision with other inner class name */
    public static abstract class AbstractC0023b implements Serializable {
        private Map<String, Object> a;
        private int b;
        private volatile boolean c = false;

        public abstract void a();

        public abstract void a(com.anythink.core.common.inner.b.a aVar);

        public abstract void a(e eVar);

        public abstract void a(boolean z);

        public abstract void b();

        public abstract void b(e eVar);

        public abstract void c();

        public AbstractC0023b() {
        }

        private AbstractC0023b(Map<String, Object> map, final String str) {
            this.a = map;
            com.anythink.core.common.t.c.a().a(str, new com.anythink.core.common.t.c.a() { // from class: com.anythink.core.common.inner.e.b.b.1
                @Override // com.anythink.core.common.t.c.a
                public final void a(String str2) {
                    if (!str.equals(str2) || AbstractC0023b.this.c) {
                        return;
                    }
                    AbstractC0023b.this.a(3);
                    AbstractC0023b.this.d();
                }
            });
        }

        public void d() {
            if (this.c) {
                return;
            }
            this.c = true;
            Map<String, Object> map = this.a;
            if (map != null) {
                map.put(com.anythink.core.common.a.b.C0013b.a, Integer.valueOf(this.b));
            }
        }

        public final int e() {
            return this.b;
        }

        public final void a(int i) {
            this.b = i;
        }
    }
}
