package com.byazt.di;

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

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AV_NO_SYNC_THRESHOLD, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public final class c implements HostnameVerifier {
    public static final c pr = new c();

    private c() {
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return pr(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException e) {
            return false;
        }
    }

    public boolean pr(String str, X509Certificate x509Certificate) {
        if (com.byazt.xx.hn.hn(str)) {
            return hw(str, x509Certificate);
        }
        return hn(str, x509Certificate);
    }

    private boolean hw(String str, X509Certificate x509Certificate) {
        List<String> listPr = pr(x509Certificate, 7);
        int size = listPr.size();
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase(listPr.get(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean hn(String str, X509Certificate x509Certificate) {
        String strPr;
        String lowerCase = str.toLowerCase(Locale.US);
        List<String> listPr = pr(x509Certificate, 2);
        int size = listPr.size();
        int i = 0;
        boolean z = false;
        while (i < size) {
            if (pr(lowerCase, listPr.get(i))) {
                return true;
            }
            i++;
            z = true;
        }
        if (z || (strPr = new x(x509Certificate.getSubjectX500Principal()).pr("cn")) == null) {
            return false;
        }
        return pr(lowerCase, strPr);
    }

    public static List<String> pr(X509Certificate x509Certificate) {
        List<String> listPr = pr(x509Certificate, 7);
        List<String> listPr2 = pr(x509Certificate, 2);
        ArrayList arrayList = new ArrayList(listPr.size() + listPr2.size());
        arrayList.addAll(listPr);
        arrayList.addAll(listPr2);
        return arrayList;
    }

    private static List<String> pr(X509Certificate x509Certificate, int i) {
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
        } catch (CertificateParsingException e) {
            return Collections.emptyList();
        }
    }

    public boolean pr(String str, String str2) {
        if (str == null || str.length() == 0 || str.startsWith(".") || str.endsWith("..") || str2 == null || str2.length() == 0 || str2.startsWith(".") || str2.endsWith("..")) {
            return false;
        }
        if (!str.endsWith(".")) {
            str = str + '.';
        }
        if (!str2.endsWith(".")) {
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
}
