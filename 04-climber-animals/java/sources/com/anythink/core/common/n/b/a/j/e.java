package com.anythink.core.common.n.b.a.j;

import com.anythink.core.common.d.j;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes.dex */
public final class e implements HostnameVerifier {
    public static final e a = new e();
    private static final int b = 2;
    private static final int c = 7;

    private e() {
    }

    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        try {
            return a(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }

    public static boolean a(String str, X509Certificate x509Certificate) {
        if (com.anythink.core.common.n.b.a.c.c(str)) {
            return b(str, x509Certificate);
        }
        return c(str, x509Certificate);
    }

    private static boolean b(String str, X509Certificate x509Certificate) {
        List<String> listA = a(x509Certificate, 7);
        int size = listA.size();
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase(listA.get(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean c(String str, X509Certificate x509Certificate) {
        String lowerCase = str.toLowerCase(Locale.US);
        Iterator<String> it = a(x509Certificate, 2).iterator();
        while (it.hasNext()) {
            if (a(lowerCase, it.next())) {
                return true;
            }
        }
        return false;
    }

    public static List<String> a(X509Certificate x509Certificate) {
        List<String> listA = a(x509Certificate, 7);
        List<String> listA2 = a(x509Certificate, 2);
        ArrayList arrayList = new ArrayList(listA.size() + listA2.size());
        arrayList.addAll(listA);
        arrayList.addAll(listA2);
        return arrayList;
    }

    private static List<String> a(X509Certificate x509Certificate, int i) {
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && (num = (Integer) list.get(0)) != null && num.intValue() == i && (str = (String) list.get(1)) != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.emptyList();
        }
    }

    private static boolean a(String str, String str2) {
        if (str != null && str.length() != 0 && !str.startsWith(j.z) && !str.endsWith("..") && str2 != null && str2.length() != 0 && !str2.startsWith(j.z) && !str2.endsWith("..")) {
            if (!str.endsWith(j.z)) {
                str = str + '.';
            }
            if (!str2.endsWith(j.z)) {
                str2 = str2 + '.';
            }
            String lowerCase = str2.toLowerCase(Locale.US);
            if (!lowerCase.contains("*")) {
                return str.equals(lowerCase);
            }
            if (!lowerCase.startsWith("*.") || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || "*.".equals(lowerCase)) {
                return false;
            }
            String strSubstring = lowerCase.substring(1);
            if (!str.endsWith(strSubstring)) {
                return false;
            }
            int length = str.length() - strSubstring.length();
            return length <= 0 || str.lastIndexOf(46, length - 1) == -1;
        }
        return false;
    }
}
