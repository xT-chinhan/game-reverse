package com.anythink.basead.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import com.anythink.basead.ui.BaseATActivity;
import com.anythink.core.basead.a;
import com.anythink.core.basead.b.c;
import com.anythink.core.common.d.t;
import com.bykv.vk.component.ttvideo.player.C;

/* JADX INFO: loaded from: classes.dex */
public class ATMixSplashActivity extends BaseATActivity {
    private String o;
    private FrameLayout p;

    public static void b(Activity activity, c cVar) {
        if (cVar == null) {
            return;
        }
        Context contextG = t.b().g();
        if (activity == null || activity.isFinishing()) {
            Log.i("anythink_BaseATActivity", "Activity is null");
        } else {
            contextG = activity;
        }
        Intent intent = new Intent(contextG, (Class<?>) ATMixSplashActivity.class);
        intent.putExtra(a.C0075a.d, cVar.d);
        if (!(contextG instanceof Activity)) {
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
        }
        contextG.startActivity(intent);
        if (activity == null || activity.isFinishing()) {
            return;
        }
        activity.overridePendingTransition(0, 0);
    }

    @Override // com.anythink.basead.ui.BaseATActivity
    protected final void a(Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(this);
        this.p = frameLayout;
        setContentView(frameLayout);
        try {
            this.o = getIntent().getStringExtra(a.C0075a.d);
            com.anythink.core.common.l.f.a.a.InterfaceC0087a interfaceC0087aC = com.anythink.basead.mixad.a.a().c(this.o);
            if (interfaceC0087aC != null) {
                interfaceC0087aC.a(this, this.p);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.anythink.basead.ui.BaseATActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    private void a() {
        this.o = getIntent().getStringExtra(a.C0075a.d);
    }

    private void b() {
        com.anythink.core.common.l.f.a.a.InterfaceC0087a interfaceC0087aC = com.anythink.basead.mixad.a.a().c(this.o);
        if (interfaceC0087aC != null) {
            interfaceC0087aC.a(this, this.p);
        }
    }
}
