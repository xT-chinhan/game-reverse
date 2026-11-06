package com.onevcat.uniwebview;

import android.content.ComponentName;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class Z1 extends CustomTabsServiceConnection {
    public final /* synthetic */ b2 a;

    public Z1(b2 b2Var) {
        this.a = b2Var;
    }

    @Override // androidx.browser.customtabs.CustomTabsServiceConnection
    public final void onCustomTabsServiceConnected(ComponentName name, CustomTabsClient client) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(client, "client");
        b2 b2Var = this.a;
        b2Var.e = client;
        if (b2Var.h) {
            if (client == null) {
                b2Var.h = true;
                return;
            }
            if (b2Var.f == null) {
                b2Var.f = client.newSession(new a2(b2Var));
            }
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder(b2Var.f);
            Integer num = b2Var.g;
            if (num != null) {
                builder.setToolbarColor(num.intValue());
            }
            builder.build().launchUrl(b2Var.a, Uri.parse(b2Var.c));
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.a.e = null;
    }
}
