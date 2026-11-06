package com.onevcat.uniwebview;

import android.util.Log;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.onevcat.uniwebview.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0731l {
    public static final C0731l b = new C0731l();
    public int a;

    public C0731l() {
        Intrinsics.checkNotNullParameter("UniWebView", TTDownloadField.TT_TAG);
        this.a = 80;
    }

    public final void a(EnumC0728k enumC0728k, String str) {
        if (enumC0728k.a < this.a) {
            return;
        }
        if (enumC0728k == EnumC0728k.CRITICAL) {
            Log.e("UniWebView", "<UniWebView-Android> " + str);
        } else if (enumC0728k == EnumC0728k.WARNING) {
            Log.w("UniWebView", "<UniWebView-Android> " + str);
        } else {
            Log.d("UniWebView", "<UniWebView-Android> " + str);
        }
    }

    public static void a(EnumC0728k level, String mark, String message) {
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(mark, "mark");
        Intrinsics.checkNotNullParameter(message, "message");
        int iOrdinal = level.ordinal();
        if (iOrdinal == 3) {
            Log.w("UniWebView", mark + " <UniWebView-Web> " + message);
        } else if (iOrdinal != 4) {
            Log.d("UniWebView", mark + " <UniWebView-Web> " + message);
        } else {
            Log.e("UniWebView", mark + " <UniWebView-Web> " + message);
        }
    }
}
