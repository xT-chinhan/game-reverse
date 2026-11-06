package com.byazt.bny;

import android.content.Context;
import android.util.Pair;
import com.byazt.dx.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1753, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo {
    public final uc hw;
    public final fw pr;

    public zo(fw fwVar, uc ucVar) {
        this.pr = fwVar;
        this.hw = ucVar;
    }

    public m<com.byazt.dx.uc> pr(Context context, String str, String str2) {
        com.byazt.dx.uc ucVarHw = hw(context, str, str2);
        if (ucVarHw != null) {
            return new m<>(ucVarHw);
        }
        com.byazt.ptr.uc.pr("Animation for " + str + " not found in cache. Fetching from network.");
        return hn(context, str, str2);
    }

    private com.byazt.dx.uc hw(Context context, String str, String str2) {
        fw fwVar;
        Pair<hn, InputStream> pairPr;
        m<com.byazt.dx.uc> mVarHw;
        if (str2 == null || (fwVar = this.pr) == null || (pairPr = fwVar.pr(str2)) == null) {
            return null;
        }
        hn hnVar = (hn) pairPr.first;
        InputStream inputStream = (InputStream) pairPr.second;
        if (hnVar == hn.ZIP) {
            mVarHw = com.byazt.dx.fw.pr(context, new ZipInputStream(inputStream), str2);
        } else {
            mVarHw = com.byazt.dx.fw.hw(inputStream, str2);
        }
        if (mVarHw.pr() == null) {
            return null;
        }
        return mVarHw.pr();
    }

    private m<com.byazt.dx.uc> hn(Context context, String str, String str2) {
        com.byazt.ptr.uc.pr("Fetching " + str);
        x xVar = null;
        try {
            try {
                x xVarPr = this.hw.pr(str);
                if (!xVarPr.pr()) {
                    m<com.byazt.dx.uc> mVar = new m<>(new IllegalArgumentException(xVarPr.x()));
                    if (xVarPr != null) {
                        try {
                            xVarPr.close();
                        } catch (IOException e) {
                            com.byazt.ptr.uc.pr("LottieFetchResult close failed ", e);
                        }
                    }
                    return mVar;
                }
                m<com.byazt.dx.uc> mVarPr = pr(context, str, xVarPr.hw(), xVarPr.hn(), str2);
                com.byazt.ptr.uc.pr("Completed fetch from network. Success: " + (mVarPr.pr() != null));
                if (xVarPr != null) {
                    try {
                        xVarPr.close();
                    } catch (IOException e2) {
                        com.byazt.ptr.uc.pr("LottieFetchResult close failed ", e2);
                    }
                }
                return mVarPr;
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        xVar.close();
                    } catch (IOException e3) {
                        com.byazt.ptr.uc.pr("LottieFetchResult close failed ", e3);
                    }
                }
                throw th;
            }
        } catch (Exception e4) {
            m<com.byazt.dx.uc> mVar2 = new m<>(e4);
            if (0 != 0) {
                try {
                    xVar.close();
                } catch (IOException e5) {
                    com.byazt.ptr.uc.pr("LottieFetchResult close failed ", e5);
                }
            }
            return mVar2;
        }
    }

    private m<com.byazt.dx.uc> pr(Context context, String str, InputStream inputStream, String str2, String str3) throws IOException {
        m<com.byazt.dx.uc> mVarPr;
        hn hnVar;
        fw fwVar;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (str2.contains("application/zip") || str2.contains("application/x-zip") || str2.contains("application/x-zip-compressed") || str.split("\\?")[0].endsWith(".lottie")) {
            com.byazt.ptr.uc.pr("Handling zip response.");
            hn hnVar2 = hn.ZIP;
            mVarPr = pr(context, str, inputStream, str3);
            hnVar = hnVar2;
        } else {
            com.byazt.ptr.uc.pr("Received json response.");
            hnVar = hn.JSON;
            mVarPr = pr(str, inputStream, str3);
        }
        if (str3 != null && mVarPr.pr() != null && (fwVar = this.pr) != null) {
            fwVar.pr(str3, hnVar);
        }
        return mVarPr;
    }

    private m<com.byazt.dx.uc> pr(Context context, String str, InputStream inputStream, String str2) throws IOException {
        fw fwVar;
        if (str2 == null || (fwVar = this.pr) == null) {
            return com.byazt.dx.fw.pr(context, new ZipInputStream(inputStream), (String) null);
        }
        return com.byazt.dx.fw.pr(context, new ZipInputStream(new FileInputStream(fwVar.pr(str2, inputStream, hn.ZIP))), str);
    }

    private m<com.byazt.dx.uc> pr(String str, InputStream inputStream, String str2) throws IOException {
        fw fwVar;
        if (str2 == null || (fwVar = this.pr) == null) {
            return com.byazt.dx.fw.hw(inputStream, (String) null);
        }
        return com.byazt.dx.fw.hw(new FileInputStream(fwVar.pr(str2, inputStream, hn.JSON).getAbsolutePath()), str);
    }
}
