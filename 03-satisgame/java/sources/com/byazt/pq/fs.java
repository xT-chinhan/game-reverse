package com.byazt.pq;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 109, 101})
public final class fs {
    public static final Map<String, fs> cd;
    public static final fs cp;
    public static final fs cy;
    public static final fs d;
    public static final fs fs;
    public static final fs k;
    public static final fs l;
    public static final Comparator<String> n;
    public static final fs oa;
    public static final fs q;
    public static final fs qg;
    public static final fs rv;
    public static final fs s;
    public static final fs sz;
    public static final fs tj;
    public static final fs w;
    public static final fs x;
    public final String hd;

    static {
        Comparator<String> comparator = new Comparator<String>() { // from class: com.byazt.pq.fs.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
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
        n = comparator;
        cd = new TreeMap(comparator);
        qg = n("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
        s = n("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
        q = n("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
        l = n("TLS_RSA_WITH_AES_128_GCM_SHA256", MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPEN_TIME);
        w = n("TLS_RSA_WITH_AES_256_GCM_SHA384", MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_CODEC_NAME);
        x = n("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
        fs = n("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
        rv = n("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
        tj = n("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
        cp = n("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
        d = n("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
        oa = n("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
        sz = n("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
        k = n("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
        cy = n("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
    }

    public static synchronized fs n(String str) {
        fs fsVar;
        Map<String, fs> map = cd;
        fsVar = map.get(str);
        if (fsVar == null) {
            fsVar = new fs(str);
            map.put(str, fsVar);
        }
        return fsVar;
    }

    public static List<fs> n(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(n(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private fs(String str) {
        str.getClass();
        this.hd = str;
    }

    private static fs n(String str, int i) {
        return n(str);
    }

    public String n() {
        return this.hd;
    }

    public String toString() {
        return this.hd;
    }
}
