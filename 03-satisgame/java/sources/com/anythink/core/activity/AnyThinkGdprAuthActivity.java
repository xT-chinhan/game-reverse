package com.anythink.core.activity;

import android.app.Activity;
import android.os.Bundle;
import com.anythink.core.activity.component.PrivacyPolicyView;
import com.anythink.core.api.ATGDPRAuthCallback;
import com.anythink.core.common.i;
import com.anythink.core.common.u.p;

/* JADX INFO: loaded from: classes.dex */
public class AnyThinkGdprAuthActivity extends Activity {
    public static ATGDPRAuthCallback mCallback;
    String a;
    PrivacyPolicyView b;
    boolean c = false;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        i.a();
        this.a = i.f();
        if (getResources().getConfiguration().orientation == 2) {
            p.a((Activity) this, 6);
        } else {
            p.a((Activity) this, 7);
        }
        try {
            PrivacyPolicyView privacyPolicyView = new PrivacyPolicyView(this);
            this.b = privacyPolicyView;
            privacyPolicyView.setResultCallbackListener(new PrivacyPolicyView.a() { // from class: com.anythink.core.activity.AnyThinkGdprAuthActivity.1
                @Override // com.anythink.core.activity.component.PrivacyPolicyView.a
                public final void onLevelSelect(int i) {
                    if (AnyThinkGdprAuthActivity.mCallback != null) {
                        AnyThinkGdprAuthActivity.mCallback.onAuthResult(i);
                        AnyThinkGdprAuthActivity.mCallback = null;
                    }
                    AnyThinkGdprAuthActivity.this.finish();
                }

                @Override // com.anythink.core.activity.component.PrivacyPolicyView.a
                public final void onPageLoadFail() {
                    AnyThinkGdprAuthActivity.this.c = true;
                    if (AnyThinkGdprAuthActivity.mCallback != null) {
                        AnyThinkGdprAuthActivity.mCallback.onPageLoadFail();
                    }
                }

                @Override // com.anythink.core.activity.component.PrivacyPolicyView.a
                public final void onPageLoadSuccess() {
                    AnyThinkGdprAuthActivity.this.c = false;
                }
            });
            setContentView(this.b);
            this.b.loadPolicyUrl(this.a);
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.c) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        PrivacyPolicyView privacyPolicyView = this.b;
        if (privacyPolicyView != null) {
            privacyPolicyView.destory();
        }
        mCallback = null;
        super.onDestroy();
    }
}
