package com.anythink.core.common.n.b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class i {
    final String bq;
    static final Comparator<String> a = new Comparator() { // from class: com.anythink.core.common.n.b.i$$ExternalSyntheticLambda0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return i.a((String) obj, (String) obj2);
        }
    };
    private static final Map<String, i> br = new LinkedHashMap();
    public static final i b = c("SSL_RSA_WITH_NULL_MD5");
    public static final i c = c("SSL_RSA_WITH_NULL_SHA");
    public static final i d = c("SSL_RSA_EXPORT_WITH_RC4_40_MD5");
    public static final i e = c("SSL_RSA_WITH_RC4_128_MD5");
    public static final i f = c("SSL_RSA_WITH_RC4_128_SHA");
    public static final i g = c("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA");
    public static final i h = c("SSL_RSA_WITH_DES_CBC_SHA");
    public static final i i = c("SSL_RSA_WITH_3DES_EDE_CBC_SHA");
    public static final i j = c("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA");
    public static final i k = c("SSL_DHE_DSS_WITH_DES_CBC_SHA");
    public static final i l = c("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA");
    public static final i m = c("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA");
    public static final i n = c("SSL_DHE_RSA_WITH_DES_CBC_SHA");
    public static final i o = c("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA");
    public static final i p = c("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5");
    public static final i q = c("SSL_DH_anon_WITH_RC4_128_MD5");
    public static final i r = c("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA");
    public static final i s = c("SSL_DH_anon_WITH_DES_CBC_SHA");
    public static final i t = c("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA");
    public static final i u = c("TLS_KRB5_WITH_DES_CBC_SHA");
    public static final i v = c("TLS_KRB5_WITH_3DES_EDE_CBC_SHA");
    public static final i w = c("TLS_KRB5_WITH_RC4_128_SHA");
    public static final i x = c("TLS_KRB5_WITH_DES_CBC_MD5");
    public static final i y = c("TLS_KRB5_WITH_3DES_EDE_CBC_MD5");
    public static final i z = c("TLS_KRB5_WITH_RC4_128_MD5");
    public static final i A = c("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA");
    public static final i B = c("TLS_KRB5_EXPORT_WITH_RC4_40_SHA");
    public static final i C = c("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5");
    public static final i D = c("TLS_KRB5_EXPORT_WITH_RC4_40_MD5");
    public static final i E = c("TLS_RSA_WITH_AES_128_CBC_SHA");
    public static final i F = c("TLS_DHE_DSS_WITH_AES_128_CBC_SHA");
    public static final i G = c("TLS_DHE_RSA_WITH_AES_128_CBC_SHA");
    public static final i H = c("TLS_DH_anon_WITH_AES_128_CBC_SHA");
    public static final i I = c("TLS_RSA_WITH_AES_256_CBC_SHA");
    public static final i J = c("TLS_DHE_DSS_WITH_AES_256_CBC_SHA");
    public static final i K = c("TLS_DHE_RSA_WITH_AES_256_CBC_SHA");
    public static final i L = c("TLS_DH_anon_WITH_AES_256_CBC_SHA");
    public static final i M = c("TLS_RSA_WITH_NULL_SHA256");
    public static final i N = c("TLS_RSA_WITH_AES_128_CBC_SHA256");
    public static final i O = c("TLS_RSA_WITH_AES_256_CBC_SHA256");
    public static final i P = c("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256");
    public static final i Q = c("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA");
    public static final i R = c("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA");
    public static final i S = c("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA");
    public static final i T = c("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256");
    public static final i U = c("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256");
    public static final i V = c("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256");
    public static final i W = c("TLS_DH_anon_WITH_AES_128_CBC_SHA256");
    public static final i X = c("TLS_DH_anon_WITH_AES_256_CBC_SHA256");
    public static final i Y = c("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA");
    public static final i Z = c("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA");
    public static final i aa = c("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA");
    public static final i ab = c("TLS_PSK_WITH_RC4_128_SHA");
    public static final i ac = c("TLS_PSK_WITH_3DES_EDE_CBC_SHA");
    public static final i ad = c("TLS_PSK_WITH_AES_128_CBC_SHA");
    public static final i ae = c("TLS_PSK_WITH_AES_256_CBC_SHA");
    public static final i af = c("TLS_RSA_WITH_SEED_CBC_SHA");
    public static final i ag = c("TLS_RSA_WITH_AES_128_GCM_SHA256");
    public static final i ah = c("TLS_RSA_WITH_AES_256_GCM_SHA384");
    public static final i ai = c("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256");
    public static final i aj = c("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384");
    public static final i ak = c("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256");
    public static final i al = c("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384");
    public static final i am = c("TLS_DH_anon_WITH_AES_128_GCM_SHA256");
    public static final i an = c("TLS_DH_anon_WITH_AES_256_GCM_SHA384");
    public static final i ao = c("TLS_EMPTY_RENEGOTIATION_INFO_SCSV");
    public static final i ap = c("TLS_FALLBACK_SCSV");
    public static final i aq = c("TLS_ECDH_ECDSA_WITH_NULL_SHA");
    public static final i ar = c("TLS_ECDH_ECDSA_WITH_RC4_128_SHA");
    public static final i as = c("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA");
    public static final i at = c("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA");
    public static final i au = c("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA");
    public static final i av = c("TLS_ECDHE_ECDSA_WITH_NULL_SHA");
    public static final i aw = c("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA");
    public static final i ax = c("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA");
    public static final i ay = c("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA");
    public static final i az = c("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA");
    public static final i aA = c("TLS_ECDH_RSA_WITH_NULL_SHA");
    public static final i aB = c("TLS_ECDH_RSA_WITH_RC4_128_SHA");
    public static final i aC = c("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA");
    public static final i aD = c("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA");
    public static final i aE = c("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA");
    public static final i aF = c("TLS_ECDHE_RSA_WITH_NULL_SHA");
    public static final i aG = c("TLS_ECDHE_RSA_WITH_RC4_128_SHA");
    public static final i aH = c("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA");
    public static final i aI = c("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA");
    public static final i aJ = c("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA");
    public static final i aK = c("TLS_ECDH_anon_WITH_NULL_SHA");
    public static final i aL = c("TLS_ECDH_anon_WITH_RC4_128_SHA");
    public static final i aM = c("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA");
    public static final i aN = c("TLS_ECDH_anon_WITH_AES_128_CBC_SHA");
    public static final i aO = c("TLS_ECDH_anon_WITH_AES_256_CBC_SHA");
    public static final i aP = c("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256");
    public static final i aQ = c("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384");
    public static final i aR = c("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256");
    public static final i aS = c("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384");
    public static final i aT = c("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256");
    public static final i aU = c("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384");
    public static final i aV = c("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256");
    public static final i aW = c("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384");
    public static final i aX = c("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256");
    public static final i aY = c("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384");
    public static final i aZ = c("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256");
    public static final i ba = c("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384");
    public static final i bb = c("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256");
    public static final i bc = c("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384");
    public static final i bd = c("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256");
    public static final i be = c("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384");
    public static final i bf = c("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA");
    public static final i bg = c("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA");
    public static final i bh = c("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256");
    public static final i bi = c("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256");
    public static final i bj = c("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256");
    public static final i bk = c("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256");
    public static final i bl = c("TLS_AES_128_GCM_SHA256");
    public static final i bm = c("TLS_AES_256_GCM_SHA384");
    public static final i bn = c("TLS_CHACHA20_POLY1305_SHA256");
    public static final i bo = c("TLS_AES_128_CCM_SHA256");
    public static final i bp = c("TLS_AES_128_CCM_8_SHA256");

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a(String str, String str2) {
        int iMin = Math.min(str.length(), str2.length());
        for (int i2 = 4; i2 < iMin; i2++) {
            char cCharAt = str.charAt(i2);
            char cCharAt2 = str2.charAt(i2);
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

    public static synchronized i a(String str) {
        i iVar;
        String str2;
        Map<String, i> map = br;
        iVar = map.get(str);
        if (iVar == null) {
            if (str.startsWith("TLS_")) {
                str2 = "SSL_" + str.substring(4);
            } else {
                str2 = str.startsWith("SSL_") ? "TLS_" + str.substring(4) : str;
            }
            iVar = map.get(str2);
            if (iVar == null) {
                iVar = new i(str);
            }
            map.put(str, iVar);
        }
        return iVar;
    }

    private static String b(String str) {
        if (str.startsWith("TLS_")) {
            return "SSL_" + str.substring(4);
        }
        return str.startsWith("SSL_") ? "TLS_" + str.substring(4) : str;
    }

    static List<i> a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(a(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private i(String str) {
        str.getClass();
        this.bq = str;
    }

    private static i c(String str) {
        i iVar = new i(str);
        br.put(str, iVar);
        return iVar;
    }

    private String a() {
        return this.bq;
    }

    public final String toString() {
        return this.bq;
    }
}
