package com.onevcat.uniwebview;

import android.net.Uri;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
public final class Q0 extends Lambda implements Function0 {
    public final /* synthetic */ String a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Q0(String str) {
        super(0);
        this.a = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        C0740o c0740o = C0740o.b;
        String name = this.a;
        c0740o.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        b2 b2Var = (b2) c0740o.a.get(name);
        if (b2Var != null) {
            CustomTabsClient customTabsClient = b2Var.e;
            if (customTabsClient == null) {
                b2Var.h = true;
            } else {
                if (b2Var.f == null) {
                    b2Var.f = customTabsClient.newSession(new a2(b2Var));
                }
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder(b2Var.f);
                Integer num = b2Var.g;
                if (num != null) {
                    builder.setToolbarColor(num.intValue());
                }
                builder.build().launchUrl(b2Var.a, Uri.parse(b2Var.c));
            }
        }
        return Unit.INSTANCE;
    }
}
