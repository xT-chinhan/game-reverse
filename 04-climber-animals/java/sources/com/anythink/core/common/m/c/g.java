package com.anythink.core.common.m.c;

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

    @Override // com.anythink.core.common.m.c.i
    public final com.anythink.core.common.m.b.f a(com.anythink.core.common.m.b.d dVar) {
        i iVarA;
        if (this.b == null || dVar == null) {
            return null;
        }
        try {
            a aVar = this.d;
            com.anythink.core.common.m.b.f fVarA = aVar != null ? aVar.a(dVar) : null;
            return ((fVarA == null || !fVarA.e()) && (iVarA = a(this.b, dVar)) != null) ? iVarA.a(dVar) : fVarA;
        } catch (Throwable th) {
            Object[] objArr = new Object[1];
            th.getMessage();
            return null;
        }
    }

    @Override // com.anythink.core.common.m.c.i
    public final void a(com.anythink.core.common.m.b.f fVar, com.anythink.core.common.m.b.d dVar) {
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
        } catch (Throwable th) {
            Object[] objArr = new Object[1];
            th.getMessage();
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0052  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private i a(Context context, com.anythink.core.common.m.b.d dVar) {
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
                        if (!strB.equals(com.anythink.core.common.m.b.g.f)) {
                            b = -1;
                        } else {
                            b = 3;
                        }
                        break;
                    case 1584672721:
                        if (!strB.equals(com.anythink.core.common.m.b.g.b)) {
                            b = -1;
                        } else {
                            b = 0;
                        }
                        break;
                    case 1899111790:
                        if (!strB.equals(com.anythink.core.common.m.b.g.c)) {
                            b = -1;
                        } else {
                            b = 1;
                        }
                        break;
                    case 1976115158:
                        if (!strB.equals(com.anythink.core.common.m.b.g.d)) {
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
