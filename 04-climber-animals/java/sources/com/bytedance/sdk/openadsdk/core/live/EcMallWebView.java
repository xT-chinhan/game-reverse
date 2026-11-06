package com.bytedance.sdk.openadsdk.core.live;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.t;
import com.bytedance.sdk.openadsdk.core.pc;
import com.bytedance.sdk.openadsdk.core.qv.d;
import com.bytedance.sdk.openadsdk.op.ab;

/* JADX INFO: loaded from: classes2.dex */
public class EcMallWebView extends SSWebView {
    private d ab;
    private final lm c;
    pc ka;

    public EcMallWebView(final Context context, lm lmVar, final int i) {
        super(context);
        this.c = lmVar;
        ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.live.EcMallWebView.1
            @Override // java.lang.Runnable
            public void run() {
                EcMallWebView.this.ms(context, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(Context context, int i) {
        this.ka = new pc(context);
        final String strMs = f.ms(i);
        this.ab = new d() { // from class: com.bytedance.sdk.openadsdk.core.live.EcMallWebView.2
            @Override // com.bytedance.sdk.openadsdk.core.qv.d
            public void ah() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.qv.d
            public void xr() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.qv.d
            public void ms() {
                if (EcMallWebView.this.c != null) {
                    com.bytedance.sdk.openadsdk.ao.xr.ms.ms msVar = (com.bytedance.sdk.openadsdk.ao.xr.ms.ms) i.ms(EcMallWebView.this.c.da(), com.bytedance.sdk.openadsdk.ao.xr.ms.ms.class);
                    if (msVar != null) {
                        msVar.ms(2, null);
                    }
                } else {
                    sl.ms("EcMallWebView", "onSendReward failed meta null");
                }
                com.bytedance.sdk.openadsdk.core.zb.ah.ms(strMs, EcMallWebView.this.c);
            }
        };
        this.ka.xr(this).ms(this.c).xr(this.c.df()).ah(this.c.lx()).ah(i).d(f.ao(this.c)).ms((SSWebView) this).ms(strMs).ms(this.ab).ms(true);
        setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.ms.d(context, this.ka, this.c.df(), new com.bytedance.sdk.openadsdk.core.zb.d(this.c, this).xr(true)));
        setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.ms.ah(this.ka));
        String strC = t.c(this.c);
        if (TextUtils.isEmpty(strC)) {
            strC = this.c.ir();
        }
        if (TextUtils.isEmpty(strC)) {
            return;
        }
        loadUrl(strC);
    }

    @Override // com.bytedance.sdk.component.widget.web.BizWebView, android.view.View, com.bytedance.sdk.component.zb.ah
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        pc pcVar = this.ka;
        if (pcVar != null) {
            pcVar.hi(z);
        }
    }
}
