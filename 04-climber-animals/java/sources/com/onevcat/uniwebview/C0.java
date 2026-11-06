package com.onevcat.uniwebview;

import android.app.Activity;
import android.webkit.WebView;
import com.unity3d.player.UnityPlayer;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
public final class C0 extends Lambda implements Function0 {
    public static final C0 a = new C0();

    public C0() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        boolean z;
        int i = C0764w.i;
        Activity activity = UnityPlayer.currentActivity;
        Intrinsics.checkNotNullExpressionValue(activity, "currentActivity");
        Intrinsics.checkNotNullParameter(activity, "activity");
        try {
            new WebView(activity).destroy();
            z = true;
        } catch (Exception unused) {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
