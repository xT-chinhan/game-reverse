package com.byazt.fhc;

import android.content.Context;
import com.byazt.vkw.k;
import com.byazt.yt.fw;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 496, 5})
public class uc extends hw {
    public uc(Context context, com.byazt.hh.uc ucVar, com.byazt.hh.hw hwVar, k kVar) {
        super(context, hwVar, ucVar == null ? com.byazt.jwj.pr.hn() : ucVar, kVar);
    }

    @Override // com.byazt.ie.pr
    public boolean pr(com.byazt.hh.pr prVar) {
        return com.byazt.nn.x.zo(prVar);
    }

    @Override // com.byazt.fhc.hw
    public String pr() {
        return "logstats";
    }

    @Override // com.byazt.fhc.hw
    public com.byazt.yt.x pr(JSONObject jSONObject, String str, int i) throws JSONException {
        return new fw(str, jSONObject);
    }
}
