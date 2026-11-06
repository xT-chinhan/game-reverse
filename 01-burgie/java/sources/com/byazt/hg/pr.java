package com.byazt.hg;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 37})
public class pr {
    public JSONObject c;
    public String hn;
    public int hw;
    public String pr;
    public long uc;
    public List<of> x = new ArrayList();

    public void pr(String str) {
        this.pr = str;
    }

    public int pr() {
        return this.hw;
    }

    public void pr(int i) {
        this.hw = i;
    }

    public void hw(String str) {
        this.hn = str;
    }

    public List<of> hw() {
        return this.x;
    }

    public void pr(of ofVar) {
        this.x.add(ofVar);
    }

    public void pr(List<of> list) {
        this.x = list;
    }

    public JSONObject hn() {
        return this.c;
    }

    public void pr(JSONObject jSONObject) {
        this.c = jSONObject;
    }

    public void pr(long j) {
        this.uc = j;
    }
}
