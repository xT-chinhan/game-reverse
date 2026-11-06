package com.anythink.core.common;

import android.text.TextUtils;
import com.anythink.core.api.AdError;
import com.anythink.core.common.h.bd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class s {
    public static final String a = "s";
    private static volatile s b;
    private Map<String, bd> c;
    private List<bd> d;
    private final int f = 5;
    private final int g = 500;
    private List<String> e = Collections.synchronizedList(new ArrayList(8));

    public static boolean a(int i) {
        boolean z;
        switch (i) {
            case com.anythink.core.common.m.o.d /* -1003 */:
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

    public final synchronized void a(String str, String str2, long j) {
        bd bdVar = new bd();
        bdVar.b = 2;
        bdVar.d = str;
        bdVar.c = str2;
        bdVar.f = j;
        bdVar.a();
        a(bdVar, false);
    }

    private synchronized void a(final bd bdVar, final boolean z) {
        if (System.currentTimeMillis() > bdVar.f) {
            bdVar.a();
            this.e.remove(bdVar.a);
            if (z) {
                a(bdVar);
            }
            return;
        }
        if (this.e.contains(bdVar.a)) {
            bdVar.a();
            return;
        }
        this.e.add(bdVar.a);
        if (z) {
            bdVar.g++;
            if (bdVar.g >= 5) {
                bdVar.a();
                a(bdVar);
            } else {
                b(bdVar);
            }
        } else {
            bdVar.g++;
            if (bdVar.g >= 5) {
                bdVar.a();
                this.e.remove(bdVar.a);
                return;
            }
        }
        bdVar.a();
        new com.anythink.core.common.m.t(bdVar).a(0, new com.anythink.core.common.m.q() { // from class: com.anythink.core.common.s.1
            @Override // com.anythink.core.common.m.q
            public final void onLoadStart(int i) {
            }

            @Override // com.anythink.core.common.m.q
            public final void onLoadFinish(int i, Object obj) {
                String str = s.a;
                bdVar.a();
                synchronized (s.this) {
                    s.this.e.remove(bdVar.a);
                    if (z) {
                        s.this.a(bdVar);
                    }
                }
            }

            @Override // com.anythink.core.common.m.q
            public final void onLoadError(int i, String str, AdError adError) {
                String str2 = s.a;
                bdVar.a();
                synchronized (s.this) {
                    s.this.e.remove(bdVar.a);
                    if (!z) {
                        s.this.b(bdVar);
                    }
                }
            }

            @Override // com.anythink.core.common.m.q
            public final void onLoadCanceled(int i) {
                synchronized (s.this) {
                    s.this.e.remove(bdVar.a);
                }
            }
        });
    }

    public final synchronized void b() {
        try {
            c();
            List<bd> listSynchronizedList = this.d != null ? Collections.synchronizedList(new ArrayList(this.d)) : null;
            if (listSynchronizedList != null && listSynchronizedList.size() > 0) {
                for (bd bdVar : listSynchronizedList) {
                    bdVar.a();
                    a(bdVar, true);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private synchronized void c() {
        try {
            if (this.c == null && this.d == null) {
                com.anythink.core.common.e.m.a aVarA = com.anythink.core.common.e.m.a(com.anythink.core.common.e.e.a(com.anythink.core.common.d.t.b().g())).a();
                this.c = aVarA.b;
                this.d = aVarA.a;
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
    public synchronized void a(bd bdVar) {
        bdVar.a();
        Map<String, bd> map = this.c;
        if (map != null) {
            map.remove(bdVar.a);
        }
        List<bd> list = this.d;
        if (list != null) {
            list.remove(bdVar);
        }
        com.anythink.core.common.e.m.a(com.anythink.core.common.e.e.a(com.anythink.core.common.d.t.b().g())).b(bdVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(bd bdVar) {
        if (TextUtils.isEmpty(bdVar.a) && this.c != null && this.d != null) {
            bdVar.e = System.currentTimeMillis();
            bdVar.a = com.anythink.core.common.v.o.a(bdVar.d + bdVar.e);
            this.c.put(bdVar.a, bdVar);
            this.d.add(bdVar);
        }
        bdVar.a();
        com.anythink.core.common.e.m.a(com.anythink.core.common.e.e.a(com.anythink.core.common.d.t.b().g())).a(bdVar);
        List<bd> list = this.d;
        if (list != null && list.size() > 500) {
            bd bdVar2 = this.d.get(0);
            bdVar.a();
            this.e.remove(bdVar.a);
            a(bdVar2);
        }
    }
}
