package com.byazt.uf;

import android.content.Context;
import android.util.Pair;
import com.anythink.core.common.l.b;
import com.byazt.pp.oa;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 886, 101})
public class fs {
    public final x n;
    public final w qg;

    public fs(x xVar, w wVar) {
        this.n = xVar;
        this.qg = wVar;
    }

    public oa<com.byazt.pp.w> n(Context context, String str, String str2) {
        com.byazt.pp.w wVarQg = qg(context, str, str2);
        if (wVarQg != null) {
            return new oa<>(wVarQg);
        }
        com.byazt.nu.w.n("Animation for " + str + " not found in cache. Fetching from network.");
        return s(context, str, str2);
    }

    private com.byazt.pp.w qg(Context context, String str, String str2) {
        x xVar;
        Pair<s, InputStream> pairN;
        oa<com.byazt.pp.w> oaVarQg;
        if (str2 == null || (xVar = this.n) == null || (pairN = xVar.n(str2)) == null) {
            return null;
        }
        s sVar = (s) pairN.first;
        InputStream inputStream = (InputStream) pairN.second;
        if (sVar == s.ZIP) {
            oaVarQg = com.byazt.pp.x.n(context, new ZipInputStream(inputStream), str2);
        } else {
            oaVarQg = com.byazt.pp.x.qg(inputStream, str2);
        }
        if (oaVarQg.n() != null) {
            return oaVarQg.n();
        }
        return null;
    }

    private oa<com.byazt.pp.w> s(Context context, String str, String str2) {
        com.byazt.nu.w.n("Fetching " + str);
        q qVar = null;
        try {
            try {
                q qVarN = this.qg.n(str);
                if (!qVarN.n()) {
                    oa<com.byazt.pp.w> oaVar = new oa<>(new IllegalArgumentException(qVarN.q()));
                    if (qVarN != null) {
                        try {
                            qVarN.close();
                        } catch (IOException e) {
                            com.byazt.nu.w.n("LottieFetchResult close failed ", e);
                        }
                    }
                    return oaVar;
                }
                oa<com.byazt.pp.w> oaVarN = n(context, str, qVarN.qg(), qVarN.s(), str2);
                com.byazt.nu.w.n("Completed fetch from network. Success: " + (oaVarN.n() != null));
                if (qVarN != null) {
                    try {
                        qVarN.close();
                    } catch (IOException e2) {
                        com.byazt.nu.w.n("LottieFetchResult close failed ", e2);
                    }
                }
                return oaVarN;
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        qVar.close();
                    } catch (IOException e3) {
                        com.byazt.nu.w.n("LottieFetchResult close failed ", e3);
                    }
                }
                throw th;
            }
        } catch (Exception e4) {
            oa<com.byazt.pp.w> oaVar2 = new oa<>(e4);
            if (0 != 0) {
                try {
                    qVar.close();
                } catch (IOException e5) {
                    com.byazt.nu.w.n("LottieFetchResult close failed ", e5);
                }
            }
            return oaVar2;
        }
    }

    private oa<com.byazt.pp.w> n(Context context, String str, InputStream inputStream, String str2, String str3) throws IOException {
        oa<com.byazt.pp.w> oaVarN;
        s sVar;
        x xVar;
        if (str2 == null) {
            str2 = b.h;
        }
        if (str2.contains("application/zip") || str2.contains("application/x-zip") || str2.contains("application/x-zip-compressed") || str.split("\\?")[0].endsWith(".lottie")) {
            com.byazt.nu.w.n("Handling zip response.");
            s sVar2 = s.ZIP;
            oaVarN = n(context, str, inputStream, str3);
            sVar = sVar2;
        } else {
            com.byazt.nu.w.n("Received json response.");
            sVar = s.JSON;
            oaVarN = n(str, inputStream, str3);
        }
        if (str3 != null && oaVarN.n() != null && (xVar = this.n) != null) {
            xVar.n(str3, sVar);
        }
        return oaVarN;
    }

    private oa<com.byazt.pp.w> n(Context context, String str, InputStream inputStream, String str2) throws IOException {
        x xVar;
        if (str2 == null || (xVar = this.n) == null) {
            return com.byazt.pp.x.n(context, new ZipInputStream(inputStream), (String) null);
        }
        return com.byazt.pp.x.n(context, new ZipInputStream(new FileInputStream(xVar.n(str2, inputStream, s.ZIP))), str);
    }

    private oa<com.byazt.pp.w> n(String str, InputStream inputStream, String str2) throws IOException {
        x xVar;
        if (str2 == null || (xVar = this.n) == null) {
            return com.byazt.pp.x.qg(inputStream, (String) null);
        }
        return com.byazt.pp.x.qg(new FileInputStream(xVar.n(str2, inputStream, s.JSON).getAbsolutePath()), str);
    }
}
