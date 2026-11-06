package com.byazt.fhc;

import android.content.Context;
import com.byazt.vkw.k;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 496, 121})
public class x extends c {
    public x(Context context, com.byazt.hh.uc ucVar, com.byazt.hh.hw hwVar, k kVar) {
        super(context, ucVar, hwVar, kVar);
    }

    @Override // com.byazt.fhc.c, com.byazt.fhc.hw
    public String pr() {
        return "adevent_applog";
    }

    @Override // com.byazt.fhc.c, com.byazt.ie.pr
    public boolean pr(com.byazt.hh.pr prVar) {
        return com.byazt.nn.x.uc(prVar);
    }

    @Override // com.byazt.fhc.c
    public com.byazt.yt.x pr(String str, JSONObject jSONObject) {
        return new com.byazt.yt.uc(str, jSONObject);
    }
}
