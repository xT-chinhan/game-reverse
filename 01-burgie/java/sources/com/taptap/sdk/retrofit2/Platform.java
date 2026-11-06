package com.taptap.sdk.retrofit2;

import android.os.Build;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
final class Platform {
    static final BuiltInFactories builtInFactories;

    @Nullable
    static final Executor callbackExecutor;
    static final Reflection reflection;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:11:0x0022  */
    static {
        switch (System.getProperty("java.vm.name")) {
            case "Dalvik":
                callbackExecutor = new AndroidMainExecutor();
                if (Build.VERSION.SDK_INT >= 24) {
                    reflection = new Reflection.Android24();
                    builtInFactories = new BuiltInFactories.Java8();
                    break;
                } else {
                    reflection = new Reflection();
                    builtInFactories = new BuiltInFactories();
                    break;
                }
                break;
            case "RoboVM":
                callbackExecutor = null;
                reflection = new Reflection();
                builtInFactories = new BuiltInFactories();
                break;
            default:
                callbackExecutor = null;
                reflection = new Reflection.Java8();
                builtInFactories = new BuiltInFactories.Java8();
                break;
        }
    }

    private Platform() {
    }
}
