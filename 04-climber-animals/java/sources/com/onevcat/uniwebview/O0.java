package com.onevcat.uniwebview;

import android.app.Activity;
import com.unity3d.player.UnityPlayer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
public final class O0 extends Lambda implements Function0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public O0(String str, String str2) {
        super(0);
        this.a = str;
        this.b = str2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Activity activity = UnityPlayer.currentActivity;
        String str = this.a;
        if (str == null) {
            str = "";
        }
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        new b2(activity, this.b, str, new C0713f());
        return Unit.INSTANCE;
    }
}
