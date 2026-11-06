package com.byazt.jv;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public final class zo {
    public static final zo aj;
    public static final zo c;
    public static final zo fw;
    public static final zo g;
    public static final zo hn;
    public static final zo ho;
    public static final zo hw;
    public static final zo k;
    public static final Map<String, zo> lb;
    public static final zo m;
    public static final zo nt;
    public static final Comparator<String> pr;
    public static final zo uc;
    public static final zo vk;
    public static final zo w;
    public static final zo x;
    public static final zo zo;
    public final String yb;

    static {
        Comparator<String> comparator = new Comparator<String>() { // from class: com.byazt.jv.zo.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
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
        pr = comparator;
        lb = new TreeMap(comparator);
        hw = pr("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
        hn = pr("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
        x = pr("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
        c = pr("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
        uc = pr("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
        fw = pr("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
        zo = pr("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
        aj = pr("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
        vk = pr("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
        w = pr("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
        k = pr("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
        m = pr("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
        g = pr("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
        ho = pr("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
        nt = pr("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
    }

    public static synchronized zo pr(String str) {
        zo zoVar;
        Map<String, zo> map = lb;
        zoVar = map.get(str);
        if (zoVar == null) {
            zoVar = new zo(str);
            map.put(str, zoVar);
        }
        return zoVar;
    }

    public static List<zo> pr(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(pr(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private zo(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.yb = str;
    }

    private static zo pr(String str, int i) {
        return pr(str);
    }

    public String pr() {
        return this.yb;
    }

    public String toString() {
        return this.yb;
    }
}
