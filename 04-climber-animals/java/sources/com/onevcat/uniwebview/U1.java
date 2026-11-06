package com.onevcat.uniwebview;

import com.unity3d.player.UnityPlayer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
public final class U1 {
    public static E a(D params) {
        Intrinsics.checkNotNullParameter(params, "params");
        UniWebViewNativeChannel uniWebViewNativeChannel = UniWebViewInterface.channel;
        if (uniWebViewNativeChannel == null) {
            C0731l c0731l = C0731l.b;
            String message = "Unity method channel does not exist when invoking. Check implementation. Method: " + params;
            c0731l.getClass();
            Intrinsics.checkNotNullParameter(message, "message");
            c0731l.a(EnumC0728k.CRITICAL, message);
            return null;
        }
        C0731l c0731l2 = C0731l.b;
        String message2 = "invokeChannelMethod: " + params.a + ", " + params.b + ", " + params.c;
        c0731l2.getClass();
        Intrinsics.checkNotNullParameter(message2, "message");
        c0731l2.a(EnumC0728k.DEBUG, message2);
        String strInvokeChannelMethod = uniWebViewNativeChannel.invokeChannelMethod(params.a, params.b, params.c);
        if (strInvokeChannelMethod == null) {
            return null;
        }
        return new E(strInvokeChannelMethod);
    }

    public static final void b(Function0 runner) {
        Intrinsics.checkNotNullParameter(runner, "$runner");
        runner.invoke();
    }

    public static Object c(String str, Function1 function1) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        a(str, new N0(objectRef, function1, countDownLatch));
        try {
            countDownLatch.await(5000L, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            C0731l c0731l = C0731l.b;
            String message = "Exception detected: " + e.getMessage();
            c0731l.getClass();
            Intrinsics.checkNotNullParameter(message, "message");
            c0731l.a(EnumC0728k.CRITICAL, message);
        }
        return objectRef.element;
    }

    public static final void b(String name, Function1 runner) {
        Intrinsics.checkNotNullParameter(name, "$name");
        Intrinsics.checkNotNullParameter(runner, "$runner");
        C0710e c0710e = C0710e.b;
        c0710e.getClass();
        Intrinsics.checkNotNullParameter(name, "name");
        N n = (N) c0710e.a.get(name);
        if (n != null) {
            runner.invoke(n);
            return;
        }
        C0731l c0731l = C0731l.b;
        String message = "Did not find the correct web view container for name: " + name + ". Has it been already destroyed or not yet added?";
        c0731l.getClass();
        Intrinsics.checkNotNullParameter(message, "message");
        c0731l.a(EnumC0728k.CRITICAL, message);
    }

    public static Object c(Function0 function0) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        a(new M0(objectRef, function0, countDownLatch));
        try {
            countDownLatch.await(5000L, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            C0731l c0731l = C0731l.b;
            String message = "Exception detected: " + e.getMessage();
            c0731l.getClass();
            Intrinsics.checkNotNullParameter(message, "message");
            c0731l.a(EnumC0728k.CRITICAL, message);
        }
        return objectRef.element;
    }

    public static void a(final String str, final Function1 function1) {
        UnityPlayer.currentActivity.runOnUiThread(new Runnable() { // from class: com.onevcat.uniwebview.U1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                U1.b(str, function1);
            }
        });
    }

    public static void a(final Function0 function0) {
        UnityPlayer.currentActivity.runOnUiThread(new Runnable() { // from class: com.onevcat.uniwebview.U1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                U1.b(function0);
            }
        });
    }
}
