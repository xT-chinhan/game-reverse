package com.onevcat.uniwebview;

import android.graphics.Rect;
import java.io.ByteArrayOutputStream;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
public final class R1 extends Lambda implements Function1 {
    public final /* synthetic */ String a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public R1(String str) {
        super(1);
        this.a = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        N it = (N) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        String str = this.a;
        ByteArrayOutputStream byteArrayOutputStream = it.m;
        if (byteArrayOutputStream != null) {
            try {
                byteArrayOutputStream.close();
            } catch (Exception e) {
                C0731l c0731l = C0731l.b;
                C0731l c0731l2 = C0731l.b;
                String message = "Snapshot buffer close exception: " + e;
                c0731l2.getClass();
                Intrinsics.checkNotNullParameter(message, "message");
                c0731l2.a(EnumC0728k.CRITICAL, message);
            }
        }
        it.m = new ByteArrayOutputStream();
        if (it.e.getHeight() > 0 && it.e.getWidth() > 0) {
            it.n = it.a((Rect) null);
            if (str != null) {
                it.c.a(it.b, d2.SnapshotRenderingStarted, str);
            }
        }
        return Unit.INSTANCE;
    }
}
