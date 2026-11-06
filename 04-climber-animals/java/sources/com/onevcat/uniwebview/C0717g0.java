package com.onevcat.uniwebview;

import android.app.Activity;
import com.unity3d.player.UnityPlayer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.onevcat.uniwebview.g0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0717g0 extends Lambda implements Function0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0717g0(String str, String str2, String str3) {
        super(0);
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Activity activity = UnityPlayer.currentActivity;
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        new A(activity, this.a, this.b, this.c, new C0713f());
        return Unit.INSTANCE;
    }
}
