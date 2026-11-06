package com.onevcat.uniwebview;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsService;
import androidx.browser.customtabs.CustomTabsSession;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b2 {
    public final Activity a;
    public final String b;
    public final String c;
    public final c2 d;
    public CustomTabsClient e;
    public CustomTabsSession f;
    public Integer g;
    public boolean h;

    public b2(Activity activity, String name, String url, C0713f messageSender) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(messageSender, "messageSender");
        this.a = activity;
        this.b = name;
        this.c = url;
        this.d = messageSender;
        C0740o c0740o = C0740o.b;
        c0740o.getClass();
        Intrinsics.checkNotNullParameter(this, "browsing");
        Intrinsics.checkNotNullParameter(name, "name");
        C0731l c0731l = C0731l.b;
        String strA = AbstractC0746q.a("Adding safe browsing to manager: ", name, c0731l, "message");
        EnumC0728k enumC0728k = EnumC0728k.DEBUG;
        c0731l.a(enumC0728k, strA);
        c0740o.a.put(name, this);
        Intrinsics.checkNotNullParameter(activity, "activity");
        c0731l.getClass();
        Intrinsics.checkNotNullParameter("Checking CustomTabsService resolve info.", "message");
        c0731l.a(enumC0728k, "Checking CustomTabsService resolve info.");
        List<ResolveInfo> listQueryIntentServices = activity.getPackageManager().queryIntentServices(new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION), 0);
        Intrinsics.checkNotNullExpressionValue(listQueryIntentServices, "activity.packageManager.…ervices(serviceIntent, 0)");
        String message = "Resolved information: " + listQueryIntentServices;
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(enumC0728k, message);
        ResolveInfo resolveInfo = (ResolveInfo) CollectionsKt.firstOrNull((List) listQueryIntentServices);
        if (resolveInfo == null || CustomTabsClient.bindCustomTabsService(activity, resolveInfo.serviceInfo.packageName, new Z1(this))) {
            return;
        }
        Intrinsics.checkNotNullParameter("Custom Tabs didn't bind to a tab service. Something goes wrong. Trying to show the browser without a session.", "message");
        c0731l.a(EnumC0728k.CRITICAL, "Custom Tabs didn't bind to a tab service. Something goes wrong. Trying to show the browser without a session.");
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        Integer num = this.g;
        if (num != null) {
            builder.setToolbarColor(num.intValue());
        }
        builder.build().launchUrl(activity, Uri.parse(url));
    }
}
