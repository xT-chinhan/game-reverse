package com.anythink.core.common.r.a;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class m {
    private final Map<String, a> a = new HashMap();
    private final ReferenceQueue<Object> b = new ReferenceQueue<>();

    m() {
    }

    final synchronized Object a(String str) {
        b();
        a aVar = this.a.get(str);
        if (aVar == null) {
            return null;
        }
        return aVar.get();
    }

    final synchronized void a(String str, Object obj) {
        a aVar;
        b();
        if (obj != null && ((aVar = this.a.get(str)) == null || aVar.get() != obj)) {
            this.a.put(str, new a(str, obj, this.b));
        }
    }

    final synchronized void b(String str) {
        this.a.remove(str);
    }

    final synchronized void a() {
        this.a.clear();
        b();
    }

    private void b() {
        a aVar = (a) this.b.poll();
        while (aVar != null) {
            a aVar2 = this.a.get(aVar.a);
            if (aVar2 != null && aVar2.get() == null) {
                this.a.remove(aVar.a);
            }
            aVar = (a) this.b.poll();
        }
    }

    private static class a extends WeakReference<Object> {
        private final String a;

        a(String str, Object obj, ReferenceQueue<Object> referenceQueue) {
            super(obj, referenceQueue);
            this.a = str;
        }
    }
}
