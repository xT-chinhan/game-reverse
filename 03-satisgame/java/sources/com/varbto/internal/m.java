package com.varbto.internal;

import android.util.Log;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public abstract class m {
    public static void a(String str, String str2, Object... objArr) {
        if (f.a) {
            Log.d(str, a(str2, objArr), null);
        }
    }

    public static void b(String str, Object... objArr) {
        if (f.a) {
            Log.i("VerbAnrHandler", a(str, objArr), null);
        }
    }

    public static void a(String str, String str2, Throwable th, Object... objArr) {
        if (f.a) {
            Log.e(str, a(str2, objArr), th);
        }
    }

    public static String a(String str, Object... objArr) {
        if (objArr.length > 0) {
            return String.format(Locale.ENGLISH, str, objArr) + " threadId: " + Thread.currentThread().getId();
        }
        return str + " threadId: " + Thread.currentThread().getId();
    }
}
