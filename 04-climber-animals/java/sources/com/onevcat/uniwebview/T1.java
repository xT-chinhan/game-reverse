package com.onevcat.uniwebview;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
public final class T1 extends Lambda implements Function1 {
    public static final T1 a = new T1();

    public T1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws IOException {
        N it = (N) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        ByteArrayOutputStream byteArrayOutputStream = it.m;
        if (byteArrayOutputStream != null) {
            byteArrayOutputStream.close();
        }
        it.m = null;
        it.n = null;
        return Unit.INSTANCE;
    }
}
