package com.onevcat.uniwebview;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import androidx.browser.customtabs.CustomTabsService;
import com.unity3d.player.UnityPlayer;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
public final class B0 extends Lambda implements Function0 {
    public static final B0 a = new B0();

    public B0() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Activity activity = UnityPlayer.currentActivity;
        Intrinsics.checkNotNullExpressionValue(activity, "currentActivity");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(activity, "activity");
        C0731l c0731l = C0731l.b;
        c0731l.getClass();
        Intrinsics.checkNotNullParameter("Checking CustomTabsService resolve info.", "message");
        EnumC0728k enumC0728k = EnumC0728k.DEBUG;
        c0731l.a(enumC0728k, "Checking CustomTabsService resolve info.");
        List<ResolveInfo> listQueryIntentServices = activity.getPackageManager().queryIntentServices(new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION), 0);
        Intrinsics.checkNotNullExpressionValue(listQueryIntentServices, "activity.packageManager.…ervices(serviceIntent, 0)");
        String message = "Resolved information: " + listQueryIntentServices;
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(enumC0728k, message);
        return Boolean.valueOf(((ResolveInfo) CollectionsKt.firstOrNull((List) listQueryIntentServices)) != null);
    }
}
