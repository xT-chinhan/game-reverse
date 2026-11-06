package com.onevcat.uniwebview;

import android.app.Activity;
import com.unity3d.player.UnityPlayer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.onevcat.uniwebview.o0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0741o0 extends Lambda implements Function0 {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0741o0(String str, String str2) {
        super(0);
        this.a = str;
        this.b = str2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int i = C0764w.i;
        Activity currentActivity = UnityPlayer.currentActivity;
        Intrinsics.checkNotNullExpressionValue(currentActivity, "currentActivity");
        AbstractC0758u.a(currentActivity, this.a, this.b);
        return Unit.INSTANCE;
    }
}
