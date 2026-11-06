package com.efs.sdk.base.core.config.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.efs.sdk.base.IConfigRefreshAction;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.efs.sdk.base.http.HttpResponse;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements IConfigRefreshAction {

    /* JADX INFO: renamed from: com.efs.sdk.base.core.config.a.a$a, reason: collision with other inner class name */
    static class C0251a {
        private static final a a = new a();
    }

    public static a a() {
        return C0251a.a;
    }

    @Override // com.efs.sdk.base.IConfigRefreshAction
    @NonNull
    public final String refresh() {
        if (!NetworkUtil.isConnected(ControllerCenter.getGlobalEnvStruct().mAppContext)) {
            Log.i("efs.config", "Config refresh fail, network is disconnected.");
            return "";
        }
        String str = "";
        String strA = c.a().a(true);
        com.efs.sdk.base.core.a.c cVarA = com.efs.sdk.base.core.a.c.a();
        for (int i = 0; i < 3; i++) {
            com.efs.sdk.base.core.a.a aVarA = com.efs.sdk.base.core.a.a.a();
            String strB = cVarA.b();
            String str2 = strA + "/apm_cc";
            if (aVarA.a) {
                Log.i("efs.px.api", "get config from server, url is ".concat(String.valueOf(str2)));
            }
            HashMap map = new HashMap(1);
            map.put("wpk-header", strB);
            com.efs.sdk.base.core.util.a.c cVarA2 = new com.efs.sdk.base.core.util.a.d(str2).a(map).a(com.efs.sdk.base.core.a.b.a()).a();
            cVarA2.a.e = "get";
            HttpResponse httpResponseA = cVarA2.a();
            if (httpResponseA.succ) {
                str = httpResponseA.data;
                break;
            }
            if (TextUtils.isEmpty(httpResponseA.getBizCode()) || !"1000".equals(httpResponseA.getBizCode())) {
                return "";
            }
        }
        Log.i("efs.config", "config request succ, config is:\n ".concat(String.valueOf(str)));
        return str;
    }
}
