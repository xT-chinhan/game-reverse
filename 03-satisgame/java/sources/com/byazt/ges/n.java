package com.byazt.ges;

import android.text.TextUtils;
import com.anythink.core.common.f.a;
import com.byazt.gct.pk;
import com.byazt.wm.DownloadInfo;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1374, 19})
public class n {
    public static boolean n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(a.C0017a.c);
        String strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("package_name") : null;
        if (TextUtils.isEmpty(strOptString)) {
            strOptString = jSONObject.optString("package_name");
        }
        return n(strOptString);
    }

    public static boolean n(pk pkVar) {
        if (pkVar == null) {
            return false;
        }
        com.byazt.gct.l lVarK = pkVar.k();
        String strQ = lVarK != null ? lVarK.q() : null;
        if (TextUtils.isEmpty(strQ)) {
            strQ = pkVar.em();
        }
        return n(strQ);
    }

    private static boolean n(String str) {
        List<DownloadInfo> listQg;
        if (TextUtils.isEmpty(str) || (listQg = com.byazt.xv.s.hu().qg()) == null) {
            return false;
        }
        for (DownloadInfo downloadInfo : listQg) {
            int status = downloadInfo.getStatus();
            if (str.equals(downloadInfo.getPackageName()) && status == -3) {
                return true;
            }
        }
        return false;
    }
}
