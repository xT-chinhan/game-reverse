package com.mcto.sspsdk.internal;

import android.text.TextUtils;
import com.byazt.mg.PluginConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class mj implements i7 {
    public final /* synthetic */ com.mcto.sspsdk.feedback.a a;

    public mj(com.mcto.sspsdk.feedback.a aVar) {
        this.a = aVar;
    }

    @Override // com.mcto.sspsdk.internal.i7
    public final void a(String str, h7 h7Var) {
        try {
            String strOptString = new JSONObject(str).optString(PluginConstants.KEY_ERROR_CODE);
            this.a.a(TextUtils.equals("20001", strOptString) ? null : "errCode: " + strOptString + ", Please try again!");
        } catch (JSONException e) {
            this.a.a("feedback response error. Please try again!");
        }
    }

    @Override // com.mcto.sspsdk.internal.i7
    public final void a(h7 h7Var) {
        this.a.a("feedback post error. Please try again!");
    }
}
