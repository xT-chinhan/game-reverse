package com.bytedance.sdk.openadsdk.core.re;

import android.content.Context;
import android.location.Address;
import com.bytedance.sdk.openadsdk.core.jw.g;
import com.bytedance.sdk.openadsdk.core.t;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class d implements com.bytedance.sdk.component.ny.ah.xr {
    private Context ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    String f3297ms = "sp_multi_ttadnet_config";
    com.bytedance.sdk.component.d.ms.xr xr = g.ms("sp_multi_ttadnet_config");

    @Override // com.bytedance.sdk.component.ny.ah.xr
    public String ah() {
        return "android";
    }

    @Override // com.bytedance.sdk.component.ny.ah.xr
    public Address ms(Context context) {
        return null;
    }

    @Override // com.bytedance.sdk.component.ny.ah.xr
    public String xr() {
        return "openadsdk";
    }

    public d(Context context) {
        this.ah = context;
    }

    @Override // com.bytedance.sdk.component.ny.ah.xr
    public Context getContext() {
        return this.ah;
    }

    @Override // com.bytedance.sdk.component.ny.ah.xr
    public int ms() {
        return Integer.parseInt("1371");
    }

    @Override // com.bytedance.sdk.component.ny.ah.xr
    public int d() {
        return com.bytedance.sdk.openadsdk.core.g.xr;
    }

    @Override // com.bytedance.sdk.component.ny.ah.xr
    public String ka() {
        return t.ah();
    }

    @Override // com.bytedance.sdk.component.ny.ah.xr
    public String ms(Context context, String str, String str2) {
        return this.xr.xr(str, str2);
    }

    @Override // com.bytedance.sdk.component.ny.ah.xr
    public void ms(Context context, Map<String, ?> map) {
        if (map != null) {
            try {
                for (Map.Entry<String, ?> entry : map.entrySet()) {
                    Object value = entry.getValue();
                    if (value instanceof Integer) {
                        this.xr.ms(entry.getKey(), ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        this.xr.ms(entry.getKey(), ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        this.xr.ms(entry.getKey(), ((Float) value).floatValue());
                    } else if (value instanceof Boolean) {
                        this.xr.ms(entry.getKey(), ((Boolean) value).booleanValue());
                    } else if (value instanceof String) {
                        this.xr.ms(entry.getKey(), (String) value);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.component.ny.ah.xr
    public String[] c() {
        return new String[]{"tnc3-bjlgy.zijieapi.com", "tnc3-alisc1.zijieapi.com", "tnc3-aliec2.zijieapi.com"};
    }
}
