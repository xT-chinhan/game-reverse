package com.anythink.core.common.res.a;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.d.t;
import com.anythink.core.common.res.d;
import com.anythink.core.common.res.e;
import com.anythink.core.common.v.o;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String b = "H5TemplateLoader";
    private static volatile a c;
    Context a;
    private final ConcurrentHashMap<String, List<InterfaceC0097a>> d = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Long> e = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: com.anythink.core.common.res.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0097a {
        void a(String str, int i, String str2);

        void a(String str, String str2, long j);
    }

    public static class b {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        public static final int e = 5;
        public static final int f = 6;
        public static final int g = 7;
    }

    private a(Context context) {
        if (context != null) {
            this.a = context.getApplicationContext();
        } else {
            this.a = t.b().g();
        }
    }

    public static a a(Context context) {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a(context);
                }
            }
        }
        return c;
    }

    private void a(final String str, final String str2) {
        synchronized (this.d) {
            File file = new File(d.a(this.a).c(5, o.a(str)));
            if (file.exists()) {
                file.delete();
            }
            try {
                LinkedList<InterfaceC0097a> linkedList = (LinkedList) this.d.remove(str);
                if (linkedList != null) {
                    Long l = this.e.get(str);
                    long jCurrentTimeMillis = l != null ? System.currentTimeMillis() - l.longValue() : 0L;
                    for (final InterfaceC0097a interfaceC0097a : linkedList) {
                        if (interfaceC0097a != null) {
                            final long j = jCurrentTimeMillis;
                            t.b().b(new Runnable() { // from class: com.anythink.core.common.res.a.a.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    if (!TextUtils.isEmpty(str2)) {
                                        interfaceC0097a.a(str, str2, j);
                                    } else {
                                        interfaceC0097a.a(str, 3, "H5Template load fail:h5TemplateFilePath is empty");
                                    }
                                }
                            });
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final int i, final String str2) {
        synchronized (this.d) {
            String strA = o.a(str);
            File file = new File(d.a(this.a).c(5, strA));
            if (file.exists()) {
                file.delete();
            }
            File file2 = new File(d.a(this.a).c(6, strA));
            if (file2.exists()) {
                file2.delete();
            }
            LinkedList<InterfaceC0097a> linkedList = (LinkedList) this.d.remove(str);
            if (linkedList != null) {
                for (final InterfaceC0097a interfaceC0097a : linkedList) {
                    if (interfaceC0097a != null) {
                        t.b().b(new Runnable() { // from class: com.anythink.core.common.res.a.a.2
                            @Override // java.lang.Runnable
                            public final void run() {
                                interfaceC0097a.a(str, i, str2);
                            }
                        });
                    }
                }
            }
        }
    }

    public final void a(String str, InterfaceC0097a interfaceC0097a) {
        if (TextUtils.isEmpty(str)) {
            interfaceC0097a.a(str, 1, "No url info.");
            return;
        }
        if (!str.endsWith(".zip")) {
            interfaceC0097a.a(str, 1, "Not zip file url");
            return;
        }
        String strA = d.a(t.b().g()).a(str);
        if (!TextUtils.isEmpty(strA)) {
            interfaceC0097a.a(str, strA, 0L);
            return;
        }
        synchronized (this.d) {
            if (!this.e.contains(str)) {
                this.e.put(str, Long.valueOf(System.currentTimeMillis()));
            }
            if (!this.d.containsKey(str)) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(interfaceC0097a);
                this.d.put(str, linkedList);
                if (d.a(t.b().g()).b(5, o.a(str))) {
                    a(str);
                } else {
                    e eVar = new e(5, str);
                    com.anythink.core.common.res.a.b bVar = new com.anythink.core.common.res.a.b(eVar);
                    bVar.b = new AnonymousClass3(eVar);
                    bVar.d();
                }
                return;
            }
            LinkedList linkedList2 = (LinkedList) this.d.get(str);
            if (linkedList2 != null && !linkedList2.contains(interfaceC0097a)) {
                linkedList2.add(interfaceC0097a);
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.res.a.a$3, reason: invalid class name */
    final class AnonymousClass3 implements com.anythink.core.common.res.a.b.a {
        final /* synthetic */ e a;

        AnonymousClass3(e eVar) {
            this.a = eVar;
        }

        @Override // com.anythink.core.common.res.a.b.a
        public final void a(e eVar) {
            String str = eVar.h;
            a.this.a(this.a.h);
        }

        @Override // com.anythink.core.common.res.a.b.a
        public final void a(e eVar, String str) {
            a.this.a(eVar.h, 1, str);
        }
    }

    private void a(e eVar) {
        com.anythink.core.common.res.a.b bVar = new com.anythink.core.common.res.a.b(eVar);
        bVar.b = new AnonymousClass3(eVar);
        bVar.d();
    }

    private void b(String str) {
        String strA = d.a(this.a).a(str);
        if (!TextUtils.isEmpty(strA)) {
            a(str, strA);
        } else {
            a(str, 3, "h5temp html file not exist");
        }
    }

    private void a() {
        try {
            ConcurrentHashMap<String, List<InterfaceC0097a>> concurrentHashMap = this.d;
            if (concurrentHashMap != null) {
                concurrentHashMap.clear();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        String strA = o.a(str);
        String strC = d.a(this.a).c(5, strA);
        String strC2 = d.a(this.a).c(6, strA);
        File file = new File(strC2);
        if (file.exists()) {
            file.delete();
        }
        new com.anythink.core.common.v.a();
        if (com.anythink.core.common.v.a.a(strC, strC2) == 0) {
            b(str);
        } else {
            a(str, 2, "H5temp url unzip fail");
        }
    }
}
