package com.byazt.dh;

import android.text.TextUtils;
import com.byazt.at.hn;
import com.byazt.dd.c;
import com.taptap.sdk.db.constant.Common;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2066, 37})
public class pr implements hn {
    @Override // com.byazt.at.hn
    public boolean hw(String str) {
        return "Lottie://state".equals(str);
    }

    @Override // com.byazt.at.hn
    public boolean pr(String str, String str2, int i, Map<String, Object> map, Map<String, Object> map2, c cVar) {
        String strPr = pr(map2, "id");
        String strPr2 = pr(map2, "state");
        if (TextUtils.isEmpty(strPr) || TextUtils.isEmpty(strPr2)) {
            return false;
        }
        String strPr3 = pr(map, "id");
        if (TextUtils.isEmpty(strPr3)) {
            strPr3 = pr(map, Common.System.NAME);
        }
        String strPr4 = pr(map, "state");
        if (TextUtils.isEmpty(strPr3) || !TextUtils.equals(strPr3, strPr)) {
            return false;
        }
        if (!TextUtils.isEmpty(strPr4) && !TextUtils.equals(strPr4, strPr2)) {
            return false;
        }
        if (cVar != null) {
            cVar.pr();
            return true;
        }
        return true;
    }

    private static String pr(Map<String, Object> map, String str) {
        Object obj;
        return (map == null || (obj = map.get(str)) == null) ? "" : String.valueOf(obj);
    }
}
