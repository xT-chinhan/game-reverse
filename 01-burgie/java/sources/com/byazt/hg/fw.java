package com.byazt.hg;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 62})
public class fw {
    public List<String> hw;
    public String pr;

    public fw(Map<String, Object> map) {
        this.pr = "";
        this.hw = new ArrayList();
        try {
            this.pr = (String) map.get("auto_test_param");
            String str = (String) map.get("auto_test_hosts");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(str);
            this.hw = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.hw.add(jSONArray.optString(i));
            }
        } catch (Exception e) {
        }
    }

    public String pr() {
        return this.pr;
    }

    public List<String> hw() {
        return this.hw;
    }
}
