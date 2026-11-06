package com.bytedance.sdk.component.ah.xr.ms.ny;

import com.anythink.core.common.d.j;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes2.dex */
public final class ka implements HostnameVerifier {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final ka f1119ms = new ka();

    private ka() {
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return ms(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }

    public boolean ms(String str, X509Certificate x509Certificate) {
        if (com.bytedance.sdk.component.ah.xr.ms.ah.ah(str)) {
            return xr(str, x509Certificate);
        }
        return ah(str, x509Certificate);
    }

    private boolean xr(String str, X509Certificate x509Certificate) {
        List<String> listMs = ms(x509Certificate, 7);
        int size = listMs.size();
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase(listMs.get(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean ah(String str, X509Certificate x509Certificate) {
        String strMs;
        String lowerCase = str.toLowerCase(Locale.US);
        List<String> listMs = ms(x509Certificate, 2);
        int size = listMs.size();
        int i = 0;
        boolean z = false;
        while (i < size) {
            if (ms(lowerCase, listMs.get(i))) {
                return true;
            }
            i++;
            z = true;
        }
        if (z || (strMs = new d(x509Certificate.getSubjectX500Principal()).ms("cn")) == null) {
            return false;
        }
        return ms(lowerCase, strMs);
    }

    public static List<String> ms(X509Certificate x509Certificate) {
        List<String> listMs = ms(x509Certificate, 7);
        List<String> listMs2 = ms(x509Certificate, 2);
        ArrayList arrayList = new ArrayList(listMs.size() + listMs2.size());
        arrayList.addAll(listMs);
        arrayList.addAll(listMs2);
        return arrayList;
    }

    private static List<String> ms(X509Certificate x509Certificate, int i) {
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

    public boolean ms(String str, String str2) {
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
