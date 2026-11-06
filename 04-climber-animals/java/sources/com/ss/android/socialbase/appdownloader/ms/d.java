package com.ss.android.socialbase.appdownloader.ms;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class d {
    public static ms ms(Context context, String str, JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (downloadInfo == null || context == null || jSONObject == null) {
            return null;
        }
        String savePath = downloadInfo.getSavePath();
        if (TextUtils.isEmpty(savePath) || TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(savePath);
        com.ss.android.socialbase.downloader.ab.ms msVarMs = com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo);
        if (str.equals("v1")) {
            return new ch(context, msVarMs, downloadInfo.getTargetFilePath());
        }
        if (str.equals("v2")) {
            return new hi(context, msVarMs, file.getAbsolutePath());
        }
        if (str.equals("v3")) {
            return new sl(context, msVarMs, file.getAbsolutePath());
        }
        if (str.equals("o1")) {
            return new ab(context, msVarMs, file.getAbsolutePath());
        }
        if (str.equals("o2")) {
            return new x(context, msVarMs, file.getAbsolutePath());
        }
        if (str.equals("o3")) {
            String dBJsonString = downloadInfo.getDBJsonString("file_content_uri");
            if (TextUtils.isEmpty(dBJsonString)) {
                return null;
            }
            return new ny(context, msVarMs, file.getAbsolutePath(), dBJsonString, downloadInfo.getName());
        }
        if (str.equals("custom")) {
            return new ah(context, msVarMs, file.getAbsolutePath(), jSONObject);
        }
        if (!str.equals("vbi")) {
            return null;
        }
        return new zb(context, msVarMs, com.ss.android.socialbase.appdownloader.ah.ms(downloadInfo.getId(), Downloader.getInstance(context).getDownloadFileUriProvider(downloadInfo.getId()), context, com.ss.android.socialbase.appdownloader.d.ch().d(), new File(downloadInfo.getSavePath() + File.separator + downloadInfo.getName())).toString());
    }

    public static boolean ms(Context context, String str, JSONObject jSONObject, com.ss.android.socialbase.downloader.ab.ms msVar) {
        ms zbVar;
        if (context != null && str != null) {
            String strXr = com.ss.android.socialbase.appdownloader.ah.xr();
            if (!TextUtils.isEmpty(strXr) && !TextUtils.isEmpty(str)) {
                if (com.ss.android.socialbase.appdownloader.c.ka.d() && str.equals("v1")) {
                    zbVar = new ch(context, msVar, strXr);
                } else if (com.ss.android.socialbase.appdownloader.c.ka.d() && str.equals("v2")) {
                    zbVar = new hi(context, msVar, strXr);
                } else if (com.ss.android.socialbase.appdownloader.c.ka.d() && str.equals("v3")) {
                    zbVar = new sl(context, msVar, strXr);
                } else if (com.ss.android.socialbase.appdownloader.c.ka.ka() && str.equals("o1")) {
                    zbVar = new ab(context, msVar, strXr);
                } else if (com.ss.android.socialbase.appdownloader.c.ka.ka() && str.equals("o2")) {
                    zbVar = new x(context, msVar, strXr);
                } else if (com.ss.android.socialbase.appdownloader.c.ka.ka() && str.equals("o3")) {
                    zbVar = new ny(context, msVar, strXr, strXr, strXr);
                } else if (com.ss.android.socialbase.appdownloader.c.ka.d() && str.equals("custom")) {
                    zbVar = new ah(context, msVar, strXr, jSONObject);
                } else {
                    zbVar = (com.ss.android.socialbase.appdownloader.c.ka.d() && str.equals("vbi")) ? new zb(context, msVar, strXr) : null;
                }
                if (zbVar != null && zbVar.ms()) {
                    return true;
                }
            }
        }
        return false;
    }
}
