package com.bytedance.sdk.openadsdk.core.activity.base;

import android.os.Bundle;
import android.view.View;
import com.byazt.ca.ho;
import com.byazt.gz.x;
import com.byazt.pi.TTScrollView;
import com.byazt.sdv.c;
import com.byazt.w.hn;

/* JADX INFO: loaded from: classes2.dex */
public class TTVideoScrollWebPageActivity extends TTVideoWebPageActivity {
    private TTScrollView v;

    @Override // com.byazt.rg.BaseLandingPageActivity, com.byazt.rg.BaseThemeActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TTScrollView tTScrollView = (TTScrollView) findViewById(2114387873);
        this.v = tTScrollView;
        tTScrollView.setListener(new TTScrollView.pr() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity.1
            @Override // com.byazt.pi.TTScrollView.pr
            public void pr(boolean z) {
                try {
                    if (TTVideoScrollWebPageActivity.this.er != null && (TTVideoScrollWebPageActivity.this.er instanceof x)) {
                        if (z && !TTVideoScrollWebPageActivity.this.er.a()) {
                            ((x) TTVideoScrollWebPageActivity.this.er).uc(false);
                        } else {
                            TTVideoScrollWebPageActivity.this.er.uc();
                        }
                    }
                } catch (Throwable th) {
                    ho.pr("TTVideoScrollWebPageActivity", "onCreate isShow error", th);
                }
            }
        });
        if (this.er != null) {
            this.er.x(false);
        }
        if (this.ls != null) {
            this.ls.setVideoAdInteractionListener(new hn.InterfaceC0220hn() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity.2
                @Override // com.byazt.w.hn.InterfaceC0220hn
                public void m_() {
                    if (TTVideoScrollWebPageActivity.this.v != null && !TTVideoScrollWebPageActivity.this.v.pr() && TTVideoScrollWebPageActivity.this.er != null) {
                        TTVideoScrollWebPageActivity.this.er.fw();
                    }
                }

                @Override // com.byazt.w.hn.InterfaceC0220hn
                public void n_() {
                }

                @Override // com.byazt.w.hn.InterfaceC0220hn
                public void o_() {
                }

                @Override // com.byazt.w.hn.InterfaceC0220hn
                public void pr(long j, long j2) {
                }

                @Override // com.byazt.w.hn.InterfaceC0220hn
                public void p_() {
                }
            });
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        super.setContentView(c.er(this));
    }
}
