package com.bytedance.sdk.openadsdk.core.activity.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.lm;

/* JADX INFO: loaded from: classes2.dex */
public class BaseThemeActivity extends Activity {
    protected lm ka;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        Window window;
        super.onCreate(bundle);
        lm lmVarMs = f.ms(getIntent());
        this.ka = lmVarMs;
        if (lmVarMs == null) {
            sl.xr("BaseLandingPageActivity", "物料为空,退出落地页!");
        } else {
            if (!lmVarMs.d() || (window = getWindow()) == null) {
                return;
            }
            window.addFlags(512);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        }
    }
}
