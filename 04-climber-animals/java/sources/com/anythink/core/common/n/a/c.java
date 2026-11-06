package com.anythink.core.common.n.a;

import android.text.TextUtils;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    private static volatile c a;
    private volatile i[] c;
    private volatile k d = null;
    private i e = null;
    private final j<String, l[]> b = new j<>();

    private c() {
    }

    public static c a() {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c();
                }
            }
        }
        return a;
    }

    public final synchronized void a(k kVar, i[] iVarArr) {
        if (kVar == null) {
            try {
                kVar = k.j;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.d = kVar;
        this.c = iVarArr;
    }

    public final synchronized boolean b() {
        return this.c != null && this.c.length > 0;
    }

    private static l[] a(l[] lVarArr) {
        ArrayList arrayList = new ArrayList(lVarArr.length);
        for (l lVar : lVarArr) {
            if (lVar != null && (lVar.a() || lVar.b())) {
                arrayList.add(lVar);
            }
        }
        return (l[]) arrayList.toArray(new l[arrayList.size()]);
    }

    private static String[] b(l[] lVarArr) {
        if (lVarArr == null || lVarArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(lVarArr.length);
        for (l lVar : lVarArr) {
            arrayList.add(lVar.g);
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static boolean a(String str) {
        if (str == null || str.length() < 7 || str.length() > 15 || str.contains("-")) {
            return false;
        }
        try {
            int iIndexOf = str.indexOf(46);
            if (iIndexOf != -1 && Integer.parseInt(str.substring(0, iIndexOf)) > 255) {
                return false;
            }
            int i = iIndexOf + 1;
            int iIndexOf2 = str.indexOf(46, i);
            if (iIndexOf2 != -1 && Integer.parseInt(str.substring(i, iIndexOf2)) > 255) {
                return false;
            }
            int i2 = iIndexOf2 + 1;
            int iIndexOf3 = str.indexOf(46, i2);
            return iIndexOf3 == -1 || Integer.parseInt(str.substring(i2, iIndexOf3)) <= 255 || Integer.parseInt(str.substring(iIndexOf3 + 1, str.length() - 1)) <= 255 || str.charAt(str.length() - 1) == '.';
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    private synchronized void c() {
        this.b.clear();
    }

    private l[] b(String str) {
        return b(new h(str));
    }

    private l[] b(h hVar) throws IOException {
        if (hVar == null) {
            throw new IOException("null domain");
        }
        if (hVar.a == null || hVar.a.trim().isEmpty()) {
            throw new IllegalArgumentException("empty domain " + hVar.a);
        }
        if (a(hVar.a)) {
            return new l[]{new l(hVar.a, 1, -1, new Date().getTime(), 0, "")};
        }
        return c(hVar);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x005d  */
    private l[] c(h hVar) throws UnknownHostException {
        l[] lVarArr;
        l[] lVarArrA = this.b.get(hVar.a);
        Exception e = null;
        if (lVarArrA == null || lVarArrA.length == 0) {
            lVarArr = null;
        } else {
            ArrayList arrayList = new ArrayList(lVarArrA.length);
            for (l lVar : lVarArrA) {
                if (lVar != null && !TextUtils.isEmpty(lVar.g)) {
                    if (!(lVar.i != -1 && lVar.j + ((long) lVar.i) <= System.currentTimeMillis() / 1000)) {
                        arrayList.add(lVar);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                lVarArr = null;
            } else {
                lVarArr = (l[]) arrayList.toArray(new l[arrayList.size()]);
            }
        }
        if (lVarArr != null && lVarArr.length > 0) {
            return lVarArr;
        }
        if (this.c == null || this.c.length == 0) {
            throw new IllegalArgumentException("no resolver");
        }
        for (i iVar : this.c) {
            try {
                lVarArrA = iVar.a(hVar);
                if (lVarArrA != null && lVarArrA.length > 0) {
                    this.e = iVar;
                    break;
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
        if (lVarArrA == null || lVarArrA.length == 0) {
            throw new UnknownHostException(hVar.a + " " + (e != null ? e.getMessage() : ""));
        }
        l[] lVarArrA2 = a(lVarArrA);
        if (lVarArrA2.length == 0) {
            throw new UnknownHostException("no A/AAAA records");
        }
        this.b.put(hVar.a, lVarArrA2);
        return lVarArrA2;
    }

    public final synchronized m a(h hVar) {
        String[] strArr;
        l[] lVarArrB = b(hVar);
        if (lVarArrB != null && lVarArrB.length != 0) {
            ArrayList arrayList = new ArrayList(lVarArrB.length);
            for (l lVar : lVarArrB) {
                arrayList.add(lVar.g);
            }
            strArr = arrayList.size() == 0 ? null : (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        if (strArr != null && strArr.length != 0) {
            InetAddress[] inetAddressArr = new InetAddress[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                inetAddressArr[i] = InetAddress.getByName(strArr[i]);
            }
            return new m(inetAddressArr, this.e);
        }
        return null;
    }

    private static l[] c(l[] lVarArr) {
        if (lVarArr == null || lVarArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(lVarArr.length);
        for (l lVar : lVarArr) {
            if (lVar != null && !TextUtils.isEmpty(lVar.g)) {
                if (!(lVar.i != -1 && lVar.j + ((long) lVar.i) <= System.currentTimeMillis() / 1000)) {
                    arrayList.add(lVar);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (l[]) arrayList.toArray(new l[arrayList.size()]);
    }
}
