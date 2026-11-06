package com.anythink.basead.mraid;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class d implements com.anythink.core.express.b.b {
    g a;
    WeakReference<Activity> b;
    private e c;

    @Override // com.anythink.core.express.b.b
    public final void open(String str) {
        e eVar = this.c;
        if (eVar != null) {
            eVar.open(str);
        }
    }

    @Override // com.anythink.core.express.b.b
    public final void close() {
        e eVar = this.c;
        if (eVar != null) {
            eVar.close();
        }
    }

    @Override // com.anythink.core.express.b.b
    public final void unload() {
        close();
    }

    @Override // com.anythink.core.express.b.b
    public final void useCustomClose(boolean z) {
        try {
            e eVar = this.c;
            if (eVar != null) {
                eVar.useCustomClose(z);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.anythink.core.express.b.b
    public final void expand(String str, boolean z) {
        Activity activity;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            bundle.putBoolean("shouldUseCustomClose", z);
            WeakReference<Activity> weakReference = this.b;
            if (weakReference == null || (activity = weakReference.get()) == null) {
                return;
            }
            g gVar = this.a;
            if (gVar == null || !gVar.isShowing()) {
                g gVar2 = new g(activity, bundle, this.c);
                this.a = gVar2;
                gVar2.show();
            }
        } catch (Throwable unused) {
        }
    }

    private void a(Activity activity) {
        this.b = new WeakReference<>(activity);
    }

    public final void a(e eVar) {
        if (eVar != null) {
            this.c = eVar;
        }
    }
}
