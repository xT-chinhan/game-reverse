package com.byazt.zp;

import android.text.TextUtils;
import com.byazt.auw.DownloadInfo;
import com.byazt.hg.of;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1229, 13})
public class hw {
    public static boolean pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app");
        String strOptString = null;
        if (jSONObjectOptJSONObject != null) {
            strOptString = jSONObjectOptJSONObject.optString("package_name");
        }
        if (TextUtils.isEmpty(strOptString)) {
            strOptString = jSONObject.optString("package_name");
        }
        return pr(strOptString);
    }

    public static boolean pr(of ofVar) {
        if (ofVar == null) {
            return false;
        }
        com.byazt.hg.c cVarHo = ofVar.ho();
        String strIc = null;
        if (cVarHo != null) {
            strIc = cVarHo.x();
        }
        if (TextUtils.isEmpty(strIc)) {
            strIc = ofVar.ic();
        }
        return pr(strIc);
    }

    private static boolean pr(String str) {
        List<DownloadInfo> listHw;
        if (TextUtils.isEmpty(str) || (listHw = com.byazt.lj.hn.z().hw()) == null) {
            return false;
        }
        for (DownloadInfo downloadInfo : listHw) {
            int status = downloadInfo.getStatus();
            if (str.equals(downloadInfo.getPackageName()) && status == -3) {
                return true;
            }
        }
        return false;
    }
}
