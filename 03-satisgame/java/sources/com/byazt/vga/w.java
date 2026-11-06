package com.byazt.vga;

import android.content.Context;
import com.byazt.asa.x;
import com.byazt.vf.cp;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 978, 13})
public class w extends qg {
    @Override // com.byazt.vga.qg
    public String n() {
        return "logstats";
    }

    public w(Context context, com.byazt.vr.w wVar, com.byazt.vr.qg qgVar, cp cpVar) {
        super(context, qgVar, wVar == null ? com.byazt.blx.n.s() : wVar, cpVar);
    }

    @Override // com.byazt.fa.n
    public boolean n(com.byazt.vr.n nVar) {
        return com.byazt.hls.q.fs(nVar);
    }

    @Override // com.byazt.vga.qg
    public com.byazt.asa.q n(JSONObject jSONObject, String str, int i) throws JSONException {
        return new x(str, jSONObject);
    }
}
