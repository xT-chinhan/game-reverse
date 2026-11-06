package com.bytedance.sdk.openadsdk.core.p;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.sl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ny {
    private final JSONObject ah;
    private String c;
    private final String d;
    private String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Map<String, List<String>> f3246ms;
    private final String xr;

    public ny(String str, String str2, Map<String, List<String>> map, JSONObject jSONObject) {
        this.xr = str;
        this.d = str2;
        this.f3246ms = map;
        this.ah = jSONObject;
    }

    public void ms(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        List<String> list = this.f3246ms.get(str);
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str2);
            this.f3246ms.put(str, arrayList);
            return;
        }
        list.add(str2);
    }

    public Map<String, List<String>> ms() {
        return this.f3246ms;
    }

    public String xr() {
        return this.xr;
    }

    public void ms(String str) {
        this.ka = str;
    }

    public void xr(String str) {
        this.c = str;
    }

    public String ah() {
        try {
            String strOptString = this.ah.optString("expandParams");
            String str = "apppackage=" + this.ka + "|appsign=" + this.c;
            if (!TextUtils.isEmpty(strOptString)) {
                str = strOptString + "|" + str;
            }
            this.ah.put("expandParams", str);
        } catch (Exception e) {
            sl.ms(e);
        }
        JSONObject jSONObject = this.ah;
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public String d() {
        return this.d;
    }
}
