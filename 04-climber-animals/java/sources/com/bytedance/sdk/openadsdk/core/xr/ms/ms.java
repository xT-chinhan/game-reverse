package com.bytedance.sdk.openadsdk.core.xr.ms;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.nw.hi;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms {
    protected hi ah;
    protected View d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected lm f3767ms;
    protected Context xr;

    public abstract int ms(Map<String, Object> map, ah ahVar);

    public void ms(hi hiVar) {
        this.ah = hiVar;
    }

    public void ms(View view) {
        this.d = view;
    }
}
