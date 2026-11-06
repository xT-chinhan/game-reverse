package com.byazt.bj;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
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

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FEED_PACKET_UNTIL_EMPTY, 37})
public final class pr implements HostnameVerifier {
    public static final pr pr = new pr();
    public static final Pattern hw = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    private pr() {
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return pr(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException e) {
            return false;
        }
    }

    private boolean pr(String str, X509Certificate x509Certificate) {
        if (pr(str)) {
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
        if (z || (strPr = new hw(x509Certificate.getSubjectX500Principal()).pr("cn")) == null) {
            return false;
        }
        return pr(lowerCase, strPr);
    }

    private static boolean pr(String str) {
        return hw.matcher(str).matches();
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

    private boolean pr(String str, String str2) {
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
