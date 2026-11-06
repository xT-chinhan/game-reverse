package com.bytedance.sdk.openadsdk.core.h.ms;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class nw extends com.bytedance.sdk.component.ms.ka<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Context f2545ms;
    private lm xr;

    public nw(Context context, lm lmVar) {
        this.f2545ms = context;
        this.xr = lmVar;
    }

    public static void ms(com.bytedance.sdk.component.ms.h hVar, Context context, lm lmVar) {
        hVar.ms("openNewCommonWebPage", (com.bytedance.sdk.component.ms.ka<?, ?>) new nw(context, lmVar));
    }

    @Override // com.bytedance.sdk.component.ms.ka
    public JSONObject ms(JSONObject jSONObject, com.bytedance.sdk.component.ms.c cVar) throws Exception {
        try {
            String strOptString = jSONObject.optString("web_url");
            String strOptString2 = jSONObject.optString("web_title");
            if (TextUtils.isEmpty(strOptString)) {
                return null;
            }
            if (TextUtils.isEmpty(strOptString2)) {
                strOptString2 = "";
            }
            TTDelegateActivity.d(this.f2545ms, strOptString, strOptString2);
            return null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.d("OpenNewWebPageMethod", "method:" + th.getMessage());
            return null;
        }
    }
}
