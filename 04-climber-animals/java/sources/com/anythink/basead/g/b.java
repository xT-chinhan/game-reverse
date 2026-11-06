package com.anythink.basead.g;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static final String a = "b";
    private Map<String, AbstractC0044b> b;

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

    public final void a(String str, AbstractC0044b abstractC0044b) {
        this.b.put(str, abstractC0044b);
    }

    public final AbstractC0044b a(String str) {
        return this.b.get(str);
    }

    public final void b(String str) {
        this.b.remove(str);
    }

    /* JADX INFO: renamed from: com.anythink.basead.g.b$b, reason: collision with other inner class name */
    public static abstract class AbstractC0044b implements Serializable {
        private Map<String, Object> a;
        private int b;
        private volatile boolean c = false;

        public abstract void a();

        public abstract void a(com.anythink.basead.d.f fVar);

        public abstract void a(j jVar);

        public abstract void a(boolean z);

        public abstract void b();

        public abstract void b(j jVar);

        public abstract void c();

        public AbstractC0044b() {
        }

        public AbstractC0044b(Map<String, Object> map, final String str) {
            this.a = map;
            com.anythink.core.common.u.a.a().a(str, new com.anythink.core.common.u.a.InterfaceC0102a() { // from class: com.anythink.basead.g.b.b.1
                @Override // com.anythink.core.common.u.a.InterfaceC0102a
                public final void a(String str2) {
                    if (!str.equals(str2) || AbstractC0044b.this.c) {
                        return;
                    }
                    AbstractC0044b.this.a(3);
                    AbstractC0044b.this.d();
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
                map.put(com.anythink.core.common.a.b.C0077b.a, Integer.valueOf(this.b));
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
