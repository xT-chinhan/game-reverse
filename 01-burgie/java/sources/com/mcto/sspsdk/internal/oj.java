package com.mcto.sspsdk.internal;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class oj {
    public final p a;
    public final String b;
    public int c = 1;
    public long d;
    public final String e;
    public final String f;

    public oj(p pVar) {
        this.e = "浏览%nrt秒后可领取奖励";
        this.f = "继续浏览%nrt秒后可领取奖励";
        this.a = pVar;
        JSONObject jSONObject = pVar.R0;
        this.d = ((long) jSONObject.optInt("nrt", 15)) * 1000;
        this.e = jSONObject.optString("desc", "浏览%nrt秒后可领取奖励");
        this.f = jSONObject.optString("rdesc", "继续浏览%nrt秒后可领取奖励");
        this.b = jSONObject.optString("ftoast", "需要浏览" + this.d + "秒才可以领取奖励！");
    }

    public final String a() {
        return this.a.a + "_" + this.a.n0;
    }
}
