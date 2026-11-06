package com.anythink.core.common;

import android.text.TextUtils;
import com.anythink.core.api.AdError;
import com.anythink.core.common.h.bf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class s {
    public static final String a = "s";
    private static volatile s b;
    private Map<String, bf> c;
    private List<bf> d;
    private final int f = 5;
    private final int g = 500;
    private List<String> e = Collections.synchronizedList(new ArrayList(8));

    private static boolean a(int i) {
        boolean z;
        switch (i) {
            case com.anythink.core.common.l.q.d /* -1003 */:
            case -1002:
            case -1001:
            case -1000:
                z = true;
                break;
            default:
                z = false;
                break;
        }
        if (z || ((i < -99 || i >= 200) && i < 400)) {
            return z;
        }
        return true;
    }

    private s() {
    }

    public static s a() {
        if (b == null) {
            synchronized (s.class) {
                if (b == null) {
                    b = new s();
                }
            }
        }
        return b;
    }

    private synchronized void a(int i, String str, String str2, long j) {
        bf bfVar = new bf();
        bfVar.b = i;
        bfVar.d = str;
        bfVar.c = str2;
        bfVar.f = j;
        a(bfVar, false);
    }

    private synchronized void a(final bf bfVar, final boolean z) {
        if (System.currentTimeMillis() > bfVar.f) {
            this.e.remove(bfVar.a);
            if (z) {
                a(bfVar);
            }
        } else {
            if (this.e.contains(bfVar.a)) {
                return;
            }
            this.e.add(bfVar.a);
            if (z) {
                bfVar.g++;
                if (bfVar.g >= 5) {
                    a(bfVar);
                } else {
                    b(bfVar);
                }
            } else {
                bfVar.g++;
                if (bfVar.g >= 5) {
                    this.e.remove(bfVar.a);
                    return;
                }
            }
            new com.anythink.core.common.l.v(bfVar).a(0, new com.anythink.core.common.l.s() { // from class: com.anythink.core.common.s.1
                @Override // com.anythink.core.common.l.s
                public final void onLoadStart(int i) {
                }

                @Override // com.anythink.core.common.l.s
                public final void onLoadFinish(int i, Object obj) {
                    synchronized (s.this) {
                        s.this.e.remove(bfVar.a);
                        if (z) {
                            s.this.a(bfVar);
                        }
                    }
                }

                @Override // com.anythink.core.common.l.s
                public final void onLoadError(int i, String str, AdError adError) {
                    synchronized (s.this) {
                        s.this.e.remove(bfVar.a);
                        if (!z) {
                            s.this.b(bfVar);
                        }
                    }
                }

                @Override // com.anythink.core.common.l.s
                public final void onLoadCanceled(int i) {
                    synchronized (s.this) {
                        s.this.e.remove(bfVar.a);
                    }
                }
            });
        }
    }

    public final synchronized void b() {
        try {
            c();
            List listSynchronizedList = this.d != null ? Collections.synchronizedList(new ArrayList(this.d)) : null;
            if (listSynchronizedList != null && listSynchronizedList.size() > 0) {
                Iterator it = listSynchronizedList.iterator();
                while (it.hasNext()) {
                    a((bf) it.next(), true);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private synchronized void c() {
        try {
            if (this.c == null && this.d == null) {
                com.anythink.core.common.f.h.a aVarC = com.anythink.core.common.f.h.a(com.anythink.core.common.f.d.a(com.anythink.core.common.d.s.b().g())).c();
                this.c = aVarC.b;
                this.d = aVarC.a;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (this.c == null) {
            this.c = new ConcurrentHashMap();
        }
        if (this.d == null) {
            this.d = Collections.synchronizedList(new ArrayList());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(bf bfVar) {
        Map<String, bf> map = this.c;
        if (map != null) {
            map.remove(bfVar.a);
        }
        List<bf> list = this.d;
        if (list != null) {
            list.remove(bfVar);
        }
        com.anythink.core.common.f.h.a(com.anythink.core.common.f.d.a(com.anythink.core.common.d.s.b().g())).b(bfVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(bf bfVar) {
        if (TextUtils.isEmpty(bfVar.a) && this.c != null && this.d != null) {
            bfVar.e = System.currentTimeMillis();
            bfVar.a = com.anythink.core.common.u.n.a(bfVar.d + bfVar.e);
            this.c.put(bfVar.a, bfVar);
            this.d.add(bfVar);
        }
        com.anythink.core.common.f.h.a(com.anythink.core.common.f.d.a(com.anythink.core.common.d.s.b().g())).a(bfVar);
        List<bf> list = this.d;
        if (list != null && list.size() > 500) {
            bf bfVar2 = this.d.get(0);
            this.e.remove(bfVar.a);
            a(bfVar2);
        }
    }
}
