package com.onevcat.uniwebview;

import android.app.Activity;
import android.content.Intent;
import java.util.UUID;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.onevcat.uniwebview.i0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0723i0 extends Lambda implements Function0 {
    public final /* synthetic */ String a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0723i0(String str) {
        super(0);
        this.a = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        C0707d c0707d = C0707d.b;
        String name = this.a;
        c0707d.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        A handler = (A) c0707d.a.get(name);
        if (handler != null) {
            InterfaceC0772y.a.getClass();
            Intrinsics.checkNotNullParameter(handler, "handler");
            String handlerId = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(handlerId, "randomUUID().toString()");
            C0769x.b.put(handlerId, handler);
            handler.g = handlerId;
            C0775z c0775z = UniWebViewAuthenticationActivity.Companion;
            Activity context = handler.b;
            if (handlerId == null) {
                Intrinsics.throwUninitializedPropertyAccessException("handlerId");
                handlerId = null;
            }
            c0775z.getClass();
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(handlerId, "handlerId");
            Intent intent = new Intent(context, (Class<?>) UniWebViewAuthenticationActivity.class);
            intent.putExtra(UniWebViewProxyActivity.HANDLER_ID, handlerId);
            context.startActivity(intent);
        }
        return Unit.INSTANCE;
    }
}
