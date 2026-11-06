package com.bytedance.sdk.component.ah.xr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public final class x {
    public static final x ab;
    public static final x ah;
    public static final x ao;
    public static final x c;
    public static final x ch;
    public static final x d;
    public static final x hi;
    public static final x ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    static final Comparator<String> f1145ms;
    public static final x ny;
    private static final Map<String, x> qv;
    public static final x sl;
    public static final x u;
    public static final x ub;
    public static final x x;
    public static final x xr;
    public static final x zb;
    final String h;

    static {
        Comparator<String> comparator = new Comparator<String>() { // from class: com.bytedance.sdk.component.ah.xr.x.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
            public int compare(String str, String str2) {
                int iMin = Math.min(str.length(), str2.length());
                for (int i = 4; i < iMin; i++) {
                    char cCharAt = str.charAt(i);
                    char cCharAt2 = str2.charAt(i);
                    if (cCharAt != cCharAt2) {
                        return cCharAt < cCharAt2 ? -1 : 1;
                    }
                }
                int length = str.length();
                int length2 = str2.length();
                if (length != length2) {
                    return length < length2 ? -1 : 1;
                }
                return 0;
            }
        };
        f1145ms = comparator;
        qv = new TreeMap(comparator);
        xr = ms("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
        ah = ms("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
        d = ms("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
        ka = ms("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
        c = ms("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
        ab = ms("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
        x = ms("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
        ny = ms("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
        ch = ms("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
        hi = ms("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
        sl = ms("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
        zb = ms("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
        u = ms("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
        ub = ms("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
        ao = ms("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
    }

    public static synchronized x ms(String str) {
        x xVar;
        Map<String, x> map = qv;
        xVar = map.get(str);
        if (xVar == null) {
            xVar = new x(str);
            map.put(str, xVar);
        }
        return xVar;
    }

    static List<x> ms(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(ms(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private x(String str) {
        str.getClass();
        this.h = str;
    }

    private static x ms(String str, int i) {
        return ms(str);
    }

    public String ms() {
        return this.h;
    }

    public String toString() {
        return this.h;
    }
}
