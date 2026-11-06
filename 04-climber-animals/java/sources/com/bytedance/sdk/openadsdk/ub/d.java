package com.bytedance.sdk.openadsdk.ub;

import android.text.TextUtils;
import com.bytedance.embedapplog.ka;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f4218ms;
    private ka.ms xr;

    public d(ka.ms msVar) {
        this.xr = msVar;
        if (msVar == null || TextUtils.isEmpty(msVar.f497ms) || TextUtils.equals("00000000-0000-0000-0000-000000000000", msVar.f497ms)) {
            this.f4218ms = "error";
        }
    }

    public d(String str) {
        this.f4218ms = str;
    }

    public ka.ms ms() {
        return this.xr;
    }

    public String getType() {
        return this.f4218ms;
    }
}
