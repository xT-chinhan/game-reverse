package com.kwad.components.core.webview.tachikoma.c;

import android.text.TextUtils;
import com.taptap.sdk.compliance.bean.IdentityVerifyStateKt;
import com.umeng.analytics.pro.cl;

/* JADX INFO: loaded from: classes3.dex */
public class y extends com.kwad.sdk.core.response.a.a {
    public String ahn;
    public int errorCode;
    public String errorReason;
    public int qz;

    public final boolean vz() {
        return TextUtils.equals("start", this.ahn);
    }

    public final boolean vA() {
        return TextUtils.equals(cl.s, this.ahn);
    }

    public final boolean isFailed() {
        return TextUtils.equals(IdentityVerifyStateKt.VERIFY_STATE_FAILED, this.ahn);
    }

    public final boolean vB() {
        return TextUtils.equals("progress", this.ahn);
    }

    public final boolean vC() {
        return TextUtils.equals("pause", this.ahn);
    }

    public final boolean vD() {
        return TextUtils.equals("resume", this.ahn);
    }

    public final int vE() {
        try {
            return (int) Long.parseLong(this.errorReason);
        } catch (NumberFormatException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            return 0;
        }
    }
}
