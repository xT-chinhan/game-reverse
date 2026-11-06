package com.byazt.lj;

import android.text.TextUtils;
import com.byazt.sx.s;
import com.byazt.xz.l;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import com.taptap.sdk.login.internal.handlers.web.WebLoginFragment;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 688, 19})
public class n implements s {
    @Override // com.byazt.sx.s
    public boolean qg(String str) {
        return "Lottie://state".equals(str);
    }

    @Override // com.byazt.sx.s
    public boolean n(String str, String str2, int i, Map<String, Object> map, Map<String, Object> map2, l lVar) {
        String strN = n(map2, "id");
        String strN2 = n(map2, WebLoginFragment.QUERY_KEY_ID);
        if (TextUtils.isEmpty(strN) || TextUtils.isEmpty(strN2)) {
            return false;
        }
        String strN3 = n(map, "id");
        if (TextUtils.isEmpty(strN3)) {
            strN3 = n(map, TapEventParamConstants.PARAM_NAME);
        }
        String strN4 = n(map, WebLoginFragment.QUERY_KEY_ID);
        if (TextUtils.isEmpty(strN3) || !TextUtils.equals(strN3, strN)) {
            return false;
        }
        if (!TextUtils.isEmpty(strN4) && !TextUtils.equals(strN4, strN2)) {
            return false;
        }
        if (lVar == null) {
            return true;
        }
        lVar.n();
        return true;
    }

    private static String n(Map<String, Object> map, String str) {
        Object obj;
        return (map == null || (obj = map.get(str)) == null) ? "" : String.valueOf(obj);
    }
}
