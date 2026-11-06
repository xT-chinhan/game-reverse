package com.bytedance.sdk.openadsdk.c.ah;

import com.bytedance.sdk.openadsdk.c.ah.d;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr<T extends d> {
    private JSONObject ah;
    private T d;
    private boolean ka = false;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private lm f1857ms;
    private String xr;

    public xr(lm lmVar, String str, JSONObject jSONObject, T t) {
        this.f1857ms = lmVar;
        this.xr = str;
        this.ah = jSONObject;
        this.d = t;
    }

    public lm ms() {
        return this.f1857ms;
    }

    public String xr() {
        return this.xr;
    }

    public JSONObject ah() {
        if (this.ah == null) {
            this.ah = new JSONObject();
        }
        return this.ah;
    }

    public T d() {
        return this.d;
    }

    public boolean ka() {
        return this.ka;
    }

    public void ms(boolean z) {
        this.ka = z;
    }
}
