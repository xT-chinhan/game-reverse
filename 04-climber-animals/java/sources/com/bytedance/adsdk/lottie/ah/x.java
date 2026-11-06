package com.bytedance.adsdk.lottie.ah;

import android.content.Context;
import android.util.Pair;
import com.bytedance.adsdk.lottie.sl;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes2.dex */
public class x {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final ab f141ms;
    private final c xr;

    public x(ab abVar, c cVar) {
        this.f141ms = abVar;
        this.xr = cVar;
    }

    public sl<com.bytedance.adsdk.lottie.c> ms(Context context, String str, String str2) {
        com.bytedance.adsdk.lottie.c cVarXr = xr(context, str, str2);
        if (cVarXr != null) {
            return new sl<>(cVarXr);
        }
        com.bytedance.adsdk.lottie.ka.ka.ms("Animation for " + str + " not found in cache. Fetching from network.");
        return ah(context, str, str2);
    }

    private com.bytedance.adsdk.lottie.c xr(Context context, String str, String str2) {
        ab abVar;
        Pair<ah, InputStream> pairMs;
        sl<com.bytedance.adsdk.lottie.c> slVarXr;
        if (str2 == null || (abVar = this.f141ms) == null || (pairMs = abVar.ms(str)) == null) {
            return null;
        }
        ah ahVar = (ah) pairMs.first;
        InputStream inputStream = (InputStream) pairMs.second;
        if (ahVar == ah.ZIP) {
            slVarXr = com.bytedance.adsdk.lottie.ab.ms(context, new ZipInputStream(inputStream), str2);
        } else {
            slVarXr = com.bytedance.adsdk.lottie.ab.xr(inputStream, str2);
        }
        if (slVarXr.ms() != null) {
            return slVarXr.ms();
        }
        return null;
    }

    private sl<com.bytedance.adsdk.lottie.c> ah(Context context, String str, String str2) {
        com.bytedance.adsdk.lottie.ka.ka.ms("Fetching " + str);
        d dVar = null;
        try {
            try {
                d dVarMs = this.xr.ms(str);
                if (!dVarMs.ms()) {
                    sl<com.bytedance.adsdk.lottie.c> slVar = new sl<>(new IllegalArgumentException(dVarMs.d()));
                    if (dVarMs != null) {
                        try {
                            dVarMs.close();
                        } catch (IOException e) {
                            com.bytedance.adsdk.lottie.ka.ka.ms("LottieFetchResult close failed ", e);
                        }
                    }
                    return slVar;
                }
                sl<com.bytedance.adsdk.lottie.c> slVarMs = ms(context, str, dVarMs.xr(), dVarMs.ah(), str2);
                com.bytedance.adsdk.lottie.ka.ka.ms("Completed fetch from network. Success: " + (slVarMs.ms() != null));
                if (dVarMs != null) {
                    try {
                        dVarMs.close();
                    } catch (IOException e2) {
                        com.bytedance.adsdk.lottie.ka.ka.ms("LottieFetchResult close failed ", e2);
                    }
                }
                return slVarMs;
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        dVar.close();
                    } catch (IOException e3) {
                        com.bytedance.adsdk.lottie.ka.ka.ms("LottieFetchResult close failed ", e3);
                    }
                }
                throw th;
            }
        } catch (Exception e4) {
            sl<com.bytedance.adsdk.lottie.c> slVar2 = new sl<>(e4);
            if (0 != 0) {
                try {
                    dVar.close();
                } catch (IOException e5) {
                    com.bytedance.adsdk.lottie.ka.ka.ms("LottieFetchResult close failed ", e5);
                }
            }
            return slVar2;
        }
    }

    private sl<com.bytedance.adsdk.lottie.c> ms(Context context, String str, InputStream inputStream, String str2, String str3) throws IOException {
        sl<com.bytedance.adsdk.lottie.c> slVarMs;
        ah ahVar;
        ab abVar;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (str2.contains("application/zip") || str2.contains("application/x-zip") || str2.contains("application/x-zip-compressed") || str.split("\\?")[0].endsWith(".lottie")) {
            com.bytedance.adsdk.lottie.ka.ka.ms("Handling zip response.");
            ah ahVar2 = ah.ZIP;
            slVarMs = ms(context, str, inputStream, str3);
            ahVar = ahVar2;
        } else {
            com.bytedance.adsdk.lottie.ka.ka.ms("Received json response.");
            ahVar = ah.JSON;
            slVarMs = ms(str, inputStream, str3);
        }
        if (str3 != null && slVarMs.ms() != null && (abVar = this.f141ms) != null) {
            abVar.ms(str, ahVar);
        }
        return slVarMs;
    }

    private sl<com.bytedance.adsdk.lottie.c> ms(Context context, String str, InputStream inputStream, String str2) throws IOException {
        ab abVar;
        if (str2 == null || (abVar = this.f141ms) == null) {
            return com.bytedance.adsdk.lottie.ab.ms(context, new ZipInputStream(inputStream), (String) null);
        }
        return com.bytedance.adsdk.lottie.ab.ms(context, new ZipInputStream(new FileInputStream(abVar.ms(str, inputStream, ah.ZIP))), str);
    }

    private sl<com.bytedance.adsdk.lottie.c> ms(String str, InputStream inputStream, String str2) throws IOException {
        ab abVar;
        if (str2 == null || (abVar = this.f141ms) == null) {
            return com.bytedance.adsdk.lottie.ab.xr(inputStream, (String) null);
        }
        return com.bytedance.adsdk.lottie.ab.xr(new FileInputStream(abVar.ms(str, inputStream, ah.JSON).getAbsolutePath()), str);
    }
}
