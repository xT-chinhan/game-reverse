package com.bytedance.sdk.openadsdk.core.hi.ah;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.ul;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ka implements com.bytedance.sdk.openadsdk.core.hi.xr.ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected boolean f2594ms = true;
    protected WeakReference<com.bytedance.sdk.openadsdk.core.multipro.xr.ms.InterfaceC0296ms> xr;

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void c(boolean z) {
        this.f2594ms = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ah
    public void ms(com.bytedance.sdk.openadsdk.core.multipro.xr.ms.InterfaceC0296ms interfaceC0296ms) {
        this.xr = new WeakReference<>(interfaceC0296ms);
    }

    protected boolean ms(Context context, lm lmVar, String str) {
        if (!this.f2594ms || !com.bytedance.sdk.openadsdk.core.jw.c.ms(lmVar) || !ul.ms(context, lmVar, f.xr(str), str, xr())) {
            return false;
        }
        TTNativePageActivity.ms(this);
        return true;
    }

    private String xr() {
        com.bytedance.sdk.openadsdk.core.multipro.xr.ms.InterfaceC0296ms interfaceC0296ms;
        com.bytedance.sdk.openadsdk.core.multipro.xr.ms msVarR_;
        WeakReference<com.bytedance.sdk.openadsdk.core.multipro.xr.ms.InterfaceC0296ms> weakReference = this.xr;
        if (weakReference == null || (interfaceC0296ms = weakReference.get()) == null || (msVarR_ = interfaceC0296ms.r_()) == null) {
            return null;
        }
        return msVarR_.ms().toString();
    }

    public int ch() {
        return hashCode();
    }
}
