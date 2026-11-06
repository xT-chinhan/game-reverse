package com.onevcat.uniwebview;

import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsCallback;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a2 extends CustomTabsCallback {
    public final /* synthetic */ b2 a;

    public a2(b2 b2Var) {
        this.a = b2Var;
    }

    @Override // androidx.browser.customtabs.CustomTabsCallback
    public final void onNavigationEvent(int i, Bundle bundle) {
        C0731l c0731l = C0731l.b;
        String message = "onNavigationEvent: " + i;
        c0731l.getClass();
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.INFO, message);
        if (i == 6) {
            b2 b2Var = this.a;
            b2Var.getClass();
            C0740o c0740o = C0740o.b;
            String name = b2Var.b;
            c0740o.getClass();
            Intrinsics.checkNotNullParameter(name, "name");
            String message2 = "Removing safe browsing from manager: " + name;
            Intrinsics.checkNotNullParameter(message2, "message");
            c0731l.a(EnumC0728k.DEBUG, message2);
            c0740o.a.remove(name);
            b2 b2Var2 = this.a;
            b2Var2.d.a(b2Var2.b, d2.SafeBrowsingFinished, "");
        }
    }
}
