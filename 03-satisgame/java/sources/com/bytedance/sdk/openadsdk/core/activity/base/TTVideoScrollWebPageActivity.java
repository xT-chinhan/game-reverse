package com.bytedance.sdk.openadsdk.core.activity.base;

import android.os.Bundle;
import android.view.View;
import com.byazt.cb.qg;
import com.byazt.ia.q;
import com.byazt.iag.s;
import com.byazt.ndr.TTScrollView;
import com.byazt.tk.k;

/* JADX INFO: loaded from: classes2.dex */
public class TTVideoScrollWebPageActivity extends TTVideoWebPageActivity {
    private TTScrollView df;

    @Override // com.byazt.pt.BaseLandingPageActivity, com.byazt.pt.BaseThemeActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TTScrollView tTScrollView = (TTScrollView) findViewById(2114387873);
        this.df = tTScrollView;
        tTScrollView.setListener(new TTScrollView.n() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity.1
            @Override // com.byazt.ndr.TTScrollView.n
            public void n(boolean z) {
                try {
                    if (TTVideoScrollWebPageActivity.this.fi != null && (TTVideoScrollWebPageActivity.this.fi instanceof q)) {
                        if (z && !TTVideoScrollWebPageActivity.this.fi.a()) {
                            ((q) TTVideoScrollWebPageActivity.this.fi).w(false);
                        } else {
                            TTVideoScrollWebPageActivity.this.fi.w();
                        }
                    }
                } catch (Throwable th) {
                    k.n("TTVideoScrollWebPageActivity", "onCreate isShow error", th);
                }
            }
        });
        if (this.fi != null) {
            this.fi.q(false);
        }
        if (this.f != null) {
            this.f.setVideoAdInteractionListener(new s.InterfaceC0200s() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity.2
                @Override // com.byazt.iag.s.InterfaceC0200s
                public void n(long j, long j2) {
                }

                @Override // com.byazt.iag.s.InterfaceC0200s
                public void t_() {
                }

                @Override // com.byazt.iag.s.InterfaceC0200s
                public void u_() {
                }

                @Override // com.byazt.iag.s.InterfaceC0200s
                public void v_() {
                }

                @Override // com.byazt.iag.s.InterfaceC0200s
                public void s_() {
                    if (TTVideoScrollWebPageActivity.this.df == null || TTVideoScrollWebPageActivity.this.df.n() || TTVideoScrollWebPageActivity.this.fi == null) {
                        return;
                    }
                    TTVideoScrollWebPageActivity.this.fi.x();
                }
            });
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        super.setContentView(qg.fi(this));
    }
}
