package com.bytedance.sdk.openadsdk.core.component.reward.business.xr;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f2121ms;
    private int xr;

    public String ms() {
        return this.f2121ms;
    }

    public void ms(String str) {
        this.f2121ms = str;
    }

    public void ms(int i) {
        this.xr = i;
    }

    public int xr() {
        return this.xr;
    }

    public boolean ah() {
        return !TextUtils.isEmpty(this.f2121ms);
    }
}
