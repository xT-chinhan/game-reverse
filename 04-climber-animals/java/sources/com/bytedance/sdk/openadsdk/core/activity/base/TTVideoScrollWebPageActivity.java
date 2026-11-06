package com.bytedance.sdk.openadsdk.core.activity.base;

import android.os.Bundle;
import android.view.View;
import com.bykv.vk.openvk.component.video.api.d.ah;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.d;
import com.bytedance.sdk.openadsdk.res.ka;
import com.bytedance.sdk.openadsdk.widget.TTScrollView;

/* JADX INFO: loaded from: classes2.dex */
public class TTVideoScrollWebPageActivity extends TTVideoWebPageActivity {
    private TTScrollView ny;

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity, com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TTScrollView tTScrollView = (TTScrollView) findViewById(2114387879);
        this.ny = tTScrollView;
        tTScrollView.setListener(new TTScrollView.ms() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity.1
            @Override // com.bytedance.sdk.openadsdk.widget.TTScrollView.ms
            public void ms(boolean z) {
                try {
                    if (TTVideoScrollWebPageActivity.this.x != null && (TTVideoScrollWebPageActivity.this.x instanceof d)) {
                        if (z && !TTVideoScrollWebPageActivity.this.x.t()) {
                            ((d) TTVideoScrollWebPageActivity.this.x).c(false);
                        } else {
                            TTVideoScrollWebPageActivity.this.x.c();
                        }
                    }
                } catch (Throwable th) {
                    sl.ah("TTVideoScrollWebPageActivity", "onCreate isShow error", th);
                }
            }
        });
        if (this.x != null) {
            this.x.d(false);
        }
        if (this.ab != null) {
            this.ab.setVideoAdInteractionListener(new ah.InterfaceC0177ah() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity.2
                @Override // com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah
                public void C_() {
                }

                @Override // com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah
                public void ms(long j, long j2) {
                }

                @Override // com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah
                public void p_() {
                }

                @Override // com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah
                public void q_() {
                }

                @Override // com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah
                public void o_() {
                    if (TTVideoScrollWebPageActivity.this.ny == null || TTVideoScrollWebPageActivity.this.ny.ms() || TTVideoScrollWebPageActivity.this.x == null) {
                        return;
                    }
                    TTVideoScrollWebPageActivity.this.x.ab();
                }
            });
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        super.setContentView(ka.ul(this));
    }
}
