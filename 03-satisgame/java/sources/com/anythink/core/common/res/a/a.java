package com.anythink.core.common.res.a;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.d.s;
import com.anythink.core.common.res.d;
import com.anythink.core.common.res.e;
import com.anythink.core.common.u.n;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String b = "H5TemplateLoader";
    private static volatile a c;
    Context a;
    private final ConcurrentHashMap<String, List<InterfaceC0045a>> d = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Long> e = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: com.anythink.core.common.res.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0045a {
        void a();

        void b();
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
            this.a = s.b().g();
        }
    }

    private static a a(Context context) {
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
            File file = new File(d.a(this.a).b(5, n.a(str)));
            if (file.exists()) {
                file.delete();
            }
            try {
                LinkedList<InterfaceC0045a> linkedList = (LinkedList) this.d.remove(str);
                if (linkedList != null) {
                    Long l = this.e.get(str);
                    long jCurrentTimeMillis = l != null ? System.currentTimeMillis() - l.longValue() : 0L;
                    for (final InterfaceC0045a interfaceC0045a : linkedList) {
                        if (interfaceC0045a != null) {
                            s.b();
                            final long j = jCurrentTimeMillis;
                            s.b(new Runnable() { // from class: com.anythink.core.common.res.a.a.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    TextUtils.isEmpty(str2);
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
            String strA = n.a(str);
            File file = new File(d.a(this.a).b(5, strA));
            if (file.exists()) {
                file.delete();
            }
            File file2 = new File(d.a(this.a).b(6, strA));
            if (file2.exists()) {
                file2.delete();
            }
            LinkedList<InterfaceC0045a> linkedList = (LinkedList) this.d.remove(str);
            if (linkedList != null) {
                for (final InterfaceC0045a interfaceC0045a : linkedList) {
                    if (interfaceC0045a != null) {
                        s.b();
                        s.b(new Runnable() { // from class: com.anythink.core.common.res.a.a.2
                            @Override // java.lang.Runnable
                            public final void run() {
                            }
                        });
                    }
                }
            }
        }
    }

    private void a(String str, InterfaceC0045a interfaceC0045a) {
        if (interfaceC0045a != null && !TextUtils.isEmpty(str) && str.endsWith(".zip") && TextUtils.isEmpty(d.a(s.b().g()).a(str))) {
            synchronized (this.d) {
                if (!this.e.contains(str)) {
                    this.e.put(str, Long.valueOf(System.currentTimeMillis()));
                }
                if (!this.d.containsKey(str)) {
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(interfaceC0045a);
                    this.d.put(str, linkedList);
                    String strA = n.a(str);
                    if (TextUtils.isEmpty(strA) ? false : new File(d.a(s.b().g()).b(5, strA)).exists()) {
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
                if (linkedList2 != null && !linkedList2.contains(interfaceC0045a)) {
                    linkedList2.add(interfaceC0045a);
                }
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
        public final void a() {
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
            ConcurrentHashMap<String, List<InterfaceC0045a>> concurrentHashMap = this.d;
            if (concurrentHashMap != null) {
                concurrentHashMap.clear();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        String strA = n.a(str);
        String strB = d.a(this.a).b(5, strA);
        String strB2 = d.a(this.a).b(6, strA);
        File file = new File(strB2);
        if (file.exists()) {
            file.delete();
        }
        new com.anythink.core.common.u.a();
        if (com.anythink.core.common.u.a.a(strB, strB2) == 0) {
            b(str);
        } else {
            a(str, 2, "H5temp url unzip fail");
        }
    }
}
