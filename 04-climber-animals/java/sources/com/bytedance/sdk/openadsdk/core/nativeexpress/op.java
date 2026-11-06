package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.view.ViewGroup;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.jw.p;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.pc;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class op implements SSWebView.xr {
    private pc ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private SSWebView f2984ms;
    private lm xr;

    public op(SSWebView sSWebView, pc pcVar, lm lmVar) {
        this.f2984ms = sSWebView;
        this.xr = lmVar;
        this.ah = pcVar;
    }

    private boolean ms() {
        SSWebView sSWebView = this.f2984ms;
        if (sSWebView == null) {
            return false;
        }
        return f.xr(sSWebView, 50, com.bytedance.sdk.openadsdk.core.jw.f.x(this.xr));
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView.xr
    public void ms(final int i) {
        boolean zMs = ms();
        com.bytedance.sdk.component.utils.sl.xr("xeasy", "wv:".concat(String.valueOf(zMs)));
        if (zMs) {
            if (com.bytedance.sdk.openadsdk.core.re.xr().ny()) {
                SSWebView sSWebView = this.f2984ms;
                if (sSWebView != null) {
                    p.ms((WeakReference<ViewGroup>) new WeakReference((ViewGroup) sSWebView.getParent()), new com.bytedance.sdk.openadsdk.core.xr.ah() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.op.1
                        @Override // com.bytedance.sdk.openadsdk.core.xr.ah
                        public void ms() {
                            if (op.this.ah != null) {
                                op.this.ah.ms(i);
                            }
                        }
                    });
                    return;
                }
                return;
            }
            pc pcVar = this.ah;
            if (pcVar != null) {
                pcVar.ms(i);
            }
        }
    }
}
