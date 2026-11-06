package com.byazt.rte;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.auw.DownloadInfo;
import com.byazt.lj.Downloader;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 580, 121})
public class x {
    public static pr pr(Context context, String str, JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (downloadInfo == null || context == null || jSONObject == null) {
            return null;
        }
        String savePath = downloadInfo.getSavePath();
        if (TextUtils.isEmpty(savePath) || TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(savePath);
        com.byazt.ew.pr prVarPr = com.byazt.ew.pr.pr(downloadInfo);
        if (str.equals("v1")) {
            return new vk(context, prVarPr, downloadInfo.getTargetFilePath());
        }
        if (str.equals("v2")) {
            return new w(context, prVarPr, file.getAbsolutePath());
        }
        if (str.equals("v3")) {
            return new k(context, prVarPr, file.getAbsolutePath());
        }
        if (str.equals("o1")) {
            return new fw(context, prVarPr, file.getAbsolutePath());
        }
        if (str.equals("o2")) {
            return new zo(context, prVarPr, file.getAbsolutePath());
        }
        if (str.equals("o3")) {
            String dBJsonString = downloadInfo.getDBJsonString("file_content_uri");
            if (TextUtils.isEmpty(dBJsonString)) {
                return null;
            }
            return new aj(context, prVarPr, file.getAbsolutePath(), dBJsonString, downloadInfo.getName());
        }
        if (str.equals(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM)) {
            return new hn(context, prVarPr, file.getAbsolutePath(), jSONObject);
        }
        if (!str.equals("vbi")) {
            return null;
        }
        return new m(context, prVarPr, com.byazt.mdu.hn.pr(downloadInfo.getId(), Downloader.getInstance(context).getDownloadFileUriProvider(downloadInfo.getId()), context, com.byazt.mdu.x.w().c(), new File(downloadInfo.getSavePath() + File.separator + downloadInfo.getName())).toString());
    }

    public static boolean pr(Context context, String str, JSONObject jSONObject, com.byazt.ew.pr prVar) {
        if (context == null || str == null) {
            return false;
        }
        pr mVar = null;
        String strHw = com.byazt.mdu.hn.hw();
        if (TextUtils.isEmpty(strHw) || TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.byazt.now.c.x() && str.equals("v1")) {
            mVar = new vk(context, prVar, strHw);
        } else if (com.byazt.now.c.x() && str.equals("v2")) {
            mVar = new w(context, prVar, strHw);
        } else if (com.byazt.now.c.x() && str.equals("v3")) {
            mVar = new k(context, prVar, strHw);
        } else if (com.byazt.now.c.c() && str.equals("o1")) {
            mVar = new fw(context, prVar, strHw);
        } else if (com.byazt.now.c.c() && str.equals("o2")) {
            mVar = new zo(context, prVar, strHw);
        } else if (com.byazt.now.c.c() && str.equals("o3")) {
            mVar = new aj(context, prVar, strHw, strHw, strHw);
        } else if (com.byazt.now.c.x() && str.equals(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM)) {
            mVar = new hn(context, prVar, strHw, jSONObject);
        } else if (com.byazt.now.c.x() && str.equals("vbi")) {
            mVar = new m(context, prVar, strHw);
        }
        return mVar != null && mVar.pr();
    }
}
