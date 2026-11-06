package com.bytedance.sdk.openadsdk.core.activity.base;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.component.reward.view.ugen.UgenBanner;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.h;
import com.bytedance.sdk.openadsdk.core.nw.ka;
import com.bytedance.sdk.openadsdk.core.ugeno.c.ms;
import com.bytedance.sdk.openadsdk.core.xr.xr;

/* JADX INFO: loaded from: classes2.dex */
public class BaseLandingPageActivity extends BaseThemeActivity {
    private boolean ab;
    protected String ah;
    private UgenBanner c;
    protected int d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected String f1893ms;
    protected String xr;

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.ah = intent.getStringExtra("event_tag");
        this.f1893ms = intent.getStringExtra("ad_id");
        this.xr = intent.getStringExtra("log_extra");
        this.d = intent.getIntExtra("source", -1);
    }

    @Override // android.app.Activity
    protected void onResume() {
        String strNq;
        super.onResume();
        if (this.ka == null || !xr()) {
            return;
        }
        if (this.c == null) {
            this.c = new UgenBanner(this);
        }
        addContentView(this.c, new ViewGroup.LayoutParams(-1, -2));
        this.ab = true;
        ka kaVarZh = this.ka.zh();
        if (kaVarZh != null) {
            strNq = kaVarZh.ah();
        } else {
            strNq = this.ka.nq();
        }
        this.c.setTopMargin(ul.ah(this, 50.0f));
        this.c.ms(ms(), this.ka, new xr(this, this.ka, this.ah, this.d), strNq, this.ka.eh(), "立即打开", true);
    }

    private ms ms() {
        h hVarTc = this.ka.tc();
        if (hVarTc == null) {
            return null;
        }
        String strC = hVarTc.c();
        if (TextUtils.isEmpty(strC)) {
            return null;
        }
        ms msVar = new ms();
        msVar.ah(strC);
        msVar.xr(hVarTc.ab());
        msVar.ms(strC);
        return msVar;
    }

    private boolean xr() {
        h hVarTc = this.ka.tc();
        if (hVarTc == null) {
            return false;
        }
        hVarTc.ms(true);
        int iAh = hVarTc.ah();
        return (iAh == 1 || iAh == 2) && !this.ab;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        h hVarTc;
        super.onDestroy();
        UgenBanner ugenBanner = this.c;
        if (ugenBanner != null) {
            ugenBanner.ms();
        }
        if (this.ka == null || (hVarTc = this.ka.tc()) == null) {
            return;
        }
        hVarTc.ms(false);
    }
}
