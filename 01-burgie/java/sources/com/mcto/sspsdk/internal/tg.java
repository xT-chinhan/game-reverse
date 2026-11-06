package com.mcto.sspsdk.internal;

import android.os.SystemClock;
import com.byazt.mg.PluginConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class tg implements i7 {
    public final /* synthetic */ String a;
    public final /* synthetic */ p b;
    public final /* synthetic */ ug c;

    public tg(ug ugVar, String str, p pVar) {
        this.c = ugVar;
        this.a = str;
        this.b = pVar;
    }

    @Override // com.mcto.sspsdk.internal.i7
    public final void a(String str, h7 h7Var) {
        int i;
        za zaVarD = za.d();
        ug ugVar = this.c;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt(PluginConstants.KEY_ERROR_CODE) != 0) {
                i = 39;
            } else {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("result");
                if (jSONObjectOptJSONObject != null) {
                    int iOptInt = jSONObjectOptJSONObject.optInt("risk_level", -1);
                    ugVar.a = iOptInt;
                    if (iOptInt == 0) {
                        i = 32;
                    } else if (iOptInt == 1) {
                        i = 33;
                    } else {
                        i = iOptInt == 2 ? 34 : 35;
                    }
                } else {
                    i = 38;
                }
            }
        } catch (Exception e) {
        }
        zaVarD.a(i, h7Var, str, this.a, this.b.c());
    }

    @Override // com.mcto.sspsdk.internal.i7
    public final void a(h7 h7Var) {
        int i = h7Var.c == -4 ? 36 : 37;
        this.c.b = SystemClock.elapsedRealtime();
        za.d().a(i, h7Var, "", this.a, this.b.c());
    }
}
