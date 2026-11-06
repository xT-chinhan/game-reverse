package com.anythink.core.common.inner.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import com.anythink.core.basead.a;
import com.anythink.core.basead.b.c;
import com.anythink.core.common.d.s;
import com.anythink.core.common.inner.ui.BaseATActivity;
import com.bykv.vk.component.ttvideo.player.C;

/* JADX INFO: loaded from: classes.dex */
public class ATMixSplashActivity extends BaseATActivity {
    private String l;
    private FrameLayout m;

    public static void b(Activity activity, c cVar) {
        if (cVar == null) {
            return;
        }
        Context contextG = s.b().g();
        if (activity == null || activity.isFinishing()) {
            Log.i("anythink_BaseATActivity", "Activity is null");
        } else {
            contextG = activity;
        }
        Intent intent = new Intent(contextG, (Class<?>) ATMixSplashActivity.class);
        intent.putExtra(a.C0009a.d, cVar.d);
        if (!(contextG instanceof Activity)) {
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
        }
        contextG.startActivity(intent);
        if (activity == null || activity.isFinishing()) {
            return;
        }
        activity.overridePendingTransition(0, 0);
    }

    @Override // com.anythink.core.common.inner.ui.BaseATActivity
    protected final void a(Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(this);
        this.m = frameLayout;
        setContentView(frameLayout);
        try {
            this.l = getIntent().getStringExtra(a.C0009a.d);
            com.anythink.core.common.k.f.a.a.InterfaceC0030a interfaceC0030aC = com.anythink.core.common.inner.mixad.a.a().c(this.l);
            if (interfaceC0030aC != null) {
                interfaceC0030aC.a(this, this.m);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.anythink.core.common.inner.ui.BaseATActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    private void a() {
        this.l = getIntent().getStringExtra(a.C0009a.d);
    }

    private void b() {
        com.anythink.core.common.k.f.a.a.InterfaceC0030a interfaceC0030aC = com.anythink.core.common.inner.mixad.a.a().c(this.l);
        if (interfaceC0030aC != null) {
            interfaceC0030aC.a(this, this.m);
        }
    }
}
