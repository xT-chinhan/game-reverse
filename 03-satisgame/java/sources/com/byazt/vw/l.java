package com.byazt.vw;

import com.anythink.core.common.d.i;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
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
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_INITED_TIME, 18})
public final class l implements HostnameVerifier {
    public static final l n = new l();

    private l() {
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return n(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }

    public boolean n(String str, X509Certificate x509Certificate) {
        if (com.byazt.zho.s.s(str)) {
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
        if (z || (strN = new q(x509Certificate.getSubjectX500Principal()).n("cn")) == null) {
            return false;
        }
        return n(lowerCase, strN);
    }

    public static List<String> n(X509Certificate x509Certificate) {
        List<String> listN = n(x509Certificate, 7);
        List<String> listN2 = n(x509Certificate, 2);
        ArrayList arrayList = new ArrayList(listN.size() + listN2.size());
        arrayList.addAll(listN);
        arrayList.addAll(listN2);
        return arrayList;
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

    public boolean n(String str, String str2) {
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
