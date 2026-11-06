package com.byazt.yn;

import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.jv.b;
import com.byazt.jv.cz;
import com.byazt.jv.fo;
import com.byazt.jv.gz;
import com.byazt.jv.ho;
import com.byazt.jv.iu;
import com.byazt.jv.nl;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.net.InetAddress;
import java.net.Proxy;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_MIN_JITTER_BUFFER, 13})
public class hw implements com.byazt.hcx.c, Function {
    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                com.byazt.hcx.hn hnVarPr = pr((String) sparseArray.get(1), (byte[]) sparseArray.get(2), (Map) sparseArray.get(3), (String) sparseArray.get(4), (String) sparseArray.get(5), ((Integer) sparseArray.get(6)).intValue());
                return hnVarPr != null ? new com.byazt.hcx.x(hnVarPr) : hnVarPr;
            default:
                return null;
        }
    }

    /* JADX WARN: Type inference failed for: r10v12, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r11v5, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.Throwable] */
    @Override // com.byazt.hcx.c
    public com.byazt.hcx.hn pr(String str, byte[] bArr, Map<String, String> map, String str2, final String str3, int i) {
        Throwable th;
        if (TextUtils.isEmpty(str) || bArr == null || TextUtils.isEmpty(str3)) {
            if (bArr != null) {
                String.valueOf(bArr.length);
            }
            return new pr(false, 0, null, null, "error", new IllegalArgumentException("invalid_args"));
        }
        final String strPr = pr(str);
        if (TextUtils.isEmpty(strPr)) {
            return new pr(false, 0, null, null, "error", new IllegalArgumentException("invalid_url"));
        }
        System.currentTimeMillis();
        long j = i;
        fo foVarPr = new fo.pr().pr(Proxy.NO_PROXY).pr(j, TimeUnit.MILLISECONDS).hw(j, TimeUnit.MILLISECONDS).hn(j, TimeUnit.MILLISECONDS).pr(new ho() { // from class: com.byazt.yn.hw.1
            @Override // com.byazt.jv.ho
            public List<InetAddress> pr(String str4) throws UnknownHostException {
                if (!TextUtils.equals(strPr, str4)) {
                    return pr.pr(str4);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(InetAddress.getByName(str3));
                return arrayList;
            }
        }).pr();
        b.pr prVarPr = new b.pr().pr(str).pr(iu.pr(cz.pr(str2), bArr));
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                prVarPr.pr(entry.getKey(), entry.getValue());
            }
        }
        gz gzVar = null;
        byte[] bArrC = null;
        try {
            gz gzVarHw = foVarPr.pr(prVarPr.pr()).hw();
            try {
                nl nlVarAj = gzVarHw.aj();
                if (nlVarAj != null) {
                    bArrC = nlVarAj.c();
                }
                String strPr2 = gzVarHw.pr("x-tt-logid", "error");
                int iX = gzVarHw.x();
                System.currentTimeMillis();
                pr prVar = new pr(true, iX, gzVarHw.uc(), bArrC, strPr2, null);
                if (gzVarHw != null) {
                    try {
                        gzVarHw.close();
                    } catch (Throwable th2) {
                    }
                }
                return prVar;
            } catch (Throwable th3) {
                th = th3;
                gzVar = gzVarHw;
                try {
                    System.currentTimeMillis();
                    th.getClass().getSimpleName();
                    th.getMessage();
                    return new pr(false, 0, null, null, "error", th);
                } finally {
                    if (gzVar != null) {
                        try {
                            gzVar.close();
                        } catch (Throwable th4) {
                        }
                    }
                }
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    private static String pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URI.create(str).getHost();
        } catch (Throwable th) {
            return "";
        }
    }
}
