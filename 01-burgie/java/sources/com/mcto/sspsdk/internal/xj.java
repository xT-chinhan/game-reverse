package com.mcto.sspsdk.internal;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class xj implements i7 {
    public final /* synthetic */ p a;
    public final /* synthetic */ String b;
    public final /* synthetic */ ke c;

    public xj(zj zjVar, p pVar, String str, ke keVar) {
        this.a = pVar;
        this.b = str;
        this.c = keVar;
    }

    @Override // com.mcto.sspsdk.internal.i7
    public final void a(String str, h7 h7Var) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            w5 w5Var = new w5(jSONObject);
            kh.a.a(new wj(this, w5Var));
            if (w5Var.a == 0) {
                zj.a(65, this.a, this.b, jSONObject, h7Var, null);
            } else {
                zj.a(68, this.a, this.b, jSONObject, h7Var, null);
            }
        } catch (Exception e) {
            kh.a.a(new wj(this, new w5("数据解析异常")));
            zj.a(67, this.a, this.b, null, h7Var, e.getMessage());
        }
    }

    @Override // com.mcto.sspsdk.internal.i7
    public final void a(h7 h7Var) {
        kh.a.a(new wj(this, new w5("网络请求失败，错误码：" + h7Var)));
        if (h7Var.c == -4) {
            zj.a(66, this.a, this.b, null, h7Var, null);
        } else {
            zj.a(67, this.a, this.b, null, h7Var, null);
        }
    }
}
