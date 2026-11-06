package com.byazt.vga;

import android.content.Context;
import com.byazt.vf.cp;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 978, 5})
public class q extends l {
    @Override // com.byazt.vga.l, com.byazt.vga.qg
    public String n() {
        return "adevent_applog";
    }

    public q(Context context, com.byazt.vr.w wVar, com.byazt.vr.qg qgVar, cp cpVar) {
        super(context, wVar, qgVar, cpVar);
    }

    @Override // com.byazt.vga.l, com.byazt.fa.n
    public boolean n(com.byazt.vr.n nVar) {
        return com.byazt.hls.q.w(nVar);
    }

    @Override // com.byazt.vga.l
    public com.byazt.asa.q n(String str, JSONObject jSONObject) {
        return new com.byazt.asa.w(str, jSONObject);
    }
}
