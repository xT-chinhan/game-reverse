package com.bytedance.sdk.openadsdk.core.nw;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    private String ah;
    private long c;
    private List<lm> d = new ArrayList();
    private JSONObject ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f3069ms;
    private int xr;

    public void ms(String str) {
        this.f3069ms = str;
    }

    public int ms() {
        return this.xr;
    }

    public void ms(int i) {
        this.xr = i;
    }

    public void xr(String str) {
        this.ah = str;
    }

    public List<lm> xr() {
        return this.d;
    }

    public void ms(lm lmVar) {
        this.d.add(lmVar);
    }

    public void ms(List<lm> list) {
        this.d = list;
    }

    public JSONObject ah() {
        return this.ka;
    }

    public void ms(JSONObject jSONObject) {
        this.ka = jSONObject;
    }

    public void ms(long j) {
        this.c = j;
    }
}
