package com.byazt.gm;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 27, 203})
public class r extends com.byazt.ee.c<JSONObject, JSONObject> {
    public com.byazt.nc.fw.pr pr;

    public static void pr(com.byazt.ee.yb ybVar, com.byazt.nc.fw.pr prVar) {
        ybVar.pr("UgenDownloadDialogInteraction", (com.byazt.ee.c<?, ?>) new r(prVar));
    }

    @Override // com.byazt.ee.c
    public JSONObject pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
        pr(jSONObject);
        return hn();
    }

    private void pr(JSONObject jSONObject) {
        if (jSONObject == null || this.pr == null) {
            return;
        }
        switch (jSONObject.optInt("InteractionType")) {
            case 1:
                this.pr.hn(null);
                break;
            case 2:
                this.pr.pr(null);
                break;
            case 3:
                this.pr.pr();
                break;
            case 4:
                this.pr.hw(null);
                break;
            case 5:
                this.pr.x(null);
                break;
        }
    }

    public r(com.byazt.nc.fw.pr prVar) {
        this.pr = prVar;
    }

    public JSONObject hn() {
        return new JSONObject();
    }
}
