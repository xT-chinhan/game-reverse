package com.bytedance.sdk.openadsdk.core.nw;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class ab {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f3030ms;
    private List<String> xr;

    public ab(Map<String, Object> map) {
        this.f3030ms = "";
        this.xr = new ArrayList();
        try {
            this.f3030ms = (String) map.get("auto_test_param");
            String str = (String) map.get("auto_test_hosts");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(str);
            this.xr = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.xr.add(jSONArray.optString(i));
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
    }

    public String ms() {
        return this.f3030ms;
    }

    public List<String> xr() {
        return this.xr;
    }
}
