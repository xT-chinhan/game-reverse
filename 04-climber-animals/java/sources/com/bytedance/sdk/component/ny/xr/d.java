package com.bytedance.sdk.component.ny.xr;

import android.text.TextUtils;
import com.bytedance.sdk.component.xr.ms.sl;
import com.bytedance.sdk.component.xr.ms.u;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {
    protected sl ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Map<String, Object> f1293ms;
    private Object xr;
    protected String d = null;
    protected final Map<String, String> ka = new HashMap();
    protected String c = null;
    protected boolean ab = false;

    public abstract com.bytedance.sdk.component.ny.xr ms();

    public d(sl slVar) {
        this.ah = slVar;
        xr(UUID.randomUUID().toString());
    }

    public void ms(String str) {
        this.c = str;
    }

    public void xr(String str, String str2) {
        this.ka.put(str, str2);
    }

    public void d(Map<String, String> map) {
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.ka.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public void xr(String str) {
        this.d = str;
    }

    public String xr() {
        return this.d;
    }

    public Map<String, Object> ah() {
        return this.f1293ms;
    }

    public void ka(Map<String, Object> map) {
        this.f1293ms = map;
    }

    public Object d() {
        return this.xr;
    }

    protected void ms(u.ms msVar) {
        if (msVar != null && this.ka.size() > 0) {
            for (Map.Entry<String, String> entry : this.ka.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    String value = entry.getValue();
                    if (value == null) {
                        value = "";
                    }
                    msVar.xr(key, value);
                }
            }
        }
    }

    public void ms(boolean z) {
        this.ab = z;
    }
}
