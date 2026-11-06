package com.anythink.core.common.l.d;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class g implements i {
    private static final String a = "HttpLoaderInterceptor";
    private final Context b;
    private final Map<String, i> c;
    private final a d;

    public g(Context context) {
        context = context instanceof Activity ? context.getApplicationContext() : context;
        this.b = context;
        this.c = new ConcurrentHashMap();
        this.d = new a(context);
    }

    @Override // com.anythink.core.common.l.d.i
    public final com.anythink.core.common.l.c.f a(com.anythink.core.common.l.c.d dVar) {
        i iVarA;
        if (this.b == null || dVar == null) {
            return null;
        }
        try {
            a aVar = this.d;
            com.anythink.core.common.l.c.f fVarA = aVar != null ? aVar.a(dVar) : null;
            return ((fVarA == null || !fVarA.e()) && (iVarA = a(this.b, dVar)) != null) ? iVarA.a(dVar) : fVarA;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.anythink.core.common.l.d.i
    public final void a(com.anythink.core.common.l.c.f fVar, com.anythink.core.common.l.c.d dVar) {
        if (this.b == null || fVar == null || dVar == null) {
            return;
        }
        try {
            a aVar = this.d;
            if (aVar != null) {
                aVar.a(fVar, dVar);
            }
            i iVarA = a(this.b, dVar);
            if (iVarA != null) {
                iVarA.a(fVar, dVar);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x005e  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private i a(Context context, com.anythink.core.common.l.c.d dVar) {
        byte b;
        i bVar = null;
        if (dVar == null || this.c == null) {
            return null;
        }
        String strB = dVar.b();
        i iVar = this.c.get(strB);
        if (iVar != null) {
            return iVar;
        }
        synchronized (this) {
            if (!TextUtils.isEmpty(strB)) {
                switch (strB.hashCode()) {
                    case 261237151:
                        if (!strB.equals(com.anythink.core.common.l.c.g.f)) {
                            b = -1;
                        } else {
                            b = 3;
                        }
                        break;
                    case 1051663406:
                        if (!strB.equals(com.anythink.core.common.l.c.g.m)) {
                            b = -1;
                        } else {
                            b = 4;
                        }
                        break;
                    case 1584672721:
                        if (!strB.equals("app_strategy")) {
                            b = -1;
                        } else {
                            b = 0;
                        }
                        break;
                    case 1899111790:
                        if (!strB.equals(com.anythink.core.common.l.c.g.c)) {
                            b = -1;
                        } else {
                            b = 1;
                        }
                        break;
                    case 1976115158:
                        if (!strB.equals(com.anythink.core.common.l.c.g.d)) {
                            b = -1;
                        } else {
                            b = 2;
                        }
                        break;
                    default:
                        b = -1;
                        break;
                }
                if (b == 0) {
                    bVar = new b(context);
                } else if (b == 1) {
                    bVar = new f(context);
                } else if (b == 2) {
                    bVar = new c(context);
                } else if (b == 3) {
                    bVar = new e(context);
                } else if (b == 4) {
                    bVar = new j(context);
                }
                if (bVar != null) {
                    this.c.put(strB, bVar);
                }
            }
        }
        return bVar;
    }

    private i a(Context context, String str) {
        i eVar = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        str.hashCode();
        switch (str) {
            case "get_cdn_domain":
                eVar = new e(context);
                break;
            case "user_dau_strategy":
                eVar = new j(context);
                break;
            case "app_strategy":
                eVar = new b(context);
                break;
            case "eu_traffic":
                eVar = new f(context);
                break;
            case "get_area":
                eVar = new c(context);
                break;
        }
        if (eVar != null) {
            this.c.put(str, eVar);
        }
        return eVar;
    }
}
