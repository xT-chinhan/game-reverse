package com.byazt.jn;

import com.anythink.core.common.d.i;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1490, 19})
public final class n implements HostnameVerifier {
    public static final n n = new n();
    public static final Pattern qg = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    private n() {
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return n(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }

    private boolean n(String str, X509Certificate x509Certificate) {
        if (n(str)) {
            return qg(str, x509Certificate);
        }
        return s(str, x509Certificate);
    }

    private boolean qg(String str, X509Certificate x509Certificate) {
        List<String> listN = n(x509Certificate, 7);
        int size = listN.size();
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase(listN.get(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean s(String str, X509Certificate x509Certificate) {
        String strN;
        String lowerCase = str.toLowerCase(Locale.US);
        List<String> listN = n(x509Certificate, 2);
        int size = listN.size();
        int i = 0;
        boolean z = false;
        while (i < size) {
            if (n(lowerCase, listN.get(i))) {
                return true;
            }
            i++;
            z = true;
        }
        if (z || (strN = new qg(x509Certificate.getSubjectX500Principal()).n("cn")) == null) {
            return false;
        }
        return n(lowerCase, strN);
    }

    private static boolean n(String str) {
        return qg.matcher(str).matches();
    }

    private static List<String> n(X509Certificate x509Certificate, int i) {
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

    private boolean n(String str, String str2) {
        if (str != null && str.length() != 0 && !str.startsWith(i.E) && !str.endsWith("..") && str2 != null && str2.length() != 0 && !str2.startsWith(i.E) && !str2.endsWith("..")) {
            if (!str.endsWith(i.E)) {
                str = str + '.';
            }
            if (!str2.endsWith(i.E)) {
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
