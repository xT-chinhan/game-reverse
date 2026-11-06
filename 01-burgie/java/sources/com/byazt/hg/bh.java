package com.byazt.hg;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 1993})
public class bh extends m {
    public int aj;
    public String c;
    public int fw;
    public int g;
    public int hn;
    public Map<String, bh> ho;
    public int hw;
    public int k;
    public int m;
    public String uc;
    public int vk;
    public int w;
    public String x;
    public int zo;

    public bh(JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            return;
        }
        this.hw = jSONObject.optInt("render_sequence");
        this.hn = jSONObject.optInt("displayAreaAndroid");
        this.x = jSONObject.optString("ugen_md5");
        this.c = jSONObject.optString("ugen_id");
        this.uc = jSONObject.optString("ugen_url");
        this.w = jSONObject.optInt("if_stay_top", 0);
        this.fw = jSONObject.optInt("need_backup_convert_area", 0);
        this.zo = jSONObject.optInt("min_height", 0);
        this.aj = jSONObject.optInt("min_width", 0);
        this.vk = jSONObject.optInt("min_ratio", 0);
        this.k = jSONObject.optInt("mode");
        this.m = jSONObject.optInt("render_control", 0);
        this.g = jSONObject.optInt("creative_type", 0);
        this.pr = i;
        pr(jSONObject.optJSONObject("config"));
    }

    private void pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.ho = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
            if (jSONObjectOptJSONObject != null) {
                this.ho.put(next, new bh(jSONObjectOptJSONObject, 5));
            }
        }
    }

    @Override // com.byazt.hg.m
    public int hn() {
        return this.hw;
    }

    @Override // com.byazt.hg.m
    public int x() {
        return this.hn;
    }

    public int uc() {
        return this.w;
    }

    public int fw() {
        return this.k;
    }

    public int zo() {
        return this.m;
    }

    public String aj() {
        return this.x;
    }

    @Override // com.byazt.hg.m
    public String c() {
        return this.c;
    }

    public String vk() {
        return this.uc;
    }

    public boolean w() {
        return this.fw == 1;
    }

    public boolean k() {
        return !TextUtils.isEmpty(this.uc);
    }

    public boolean pr(int i, int i2) {
        int iX = com.byazt.wt.er.x(com.byazt.sd.a.getContext(), i);
        int iX2 = com.byazt.wt.er.x(com.byazt.sd.a.getContext(), i2);
        int i3 = this.aj;
        if (i3 != 0 && iX < i3) {
            return false;
        }
        int i4 = this.zo;
        if (i4 == 0 || iX2 >= i4) {
            return iX == 0 || iX2 == 0 || ((float) iX2) / ((float) iX) >= ((float) this.vk);
        }
        return false;
    }
}
