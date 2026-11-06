package com.taptap.sdk.kit.internal.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.taptap.sdk.common.R;
import com.taptap.sdk.kit.internal.TapTapKit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TapToast.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bJ!\u0010\f\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\r\u001a\u00020\u000bH\u0001¢\u0006\u0002\b\u000eR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/taptap/sdk/kit/internal/utils/TapToast;", "", "()V", "toast", "Landroid/widget/Toast;", "clear", "", "showBottomToast", "content", "", "yOffset", "", "showToast", "toastDuration", "showToast$tap_common_release", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapToast {
    public static final TapToast INSTANCE = new TapToast();
    private static Toast toast;

    private TapToast() {
    }

    public static /* synthetic */ void showToast$tap_common_release$default(TapToast tapToast, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        tapToast.showToast$tap_common_release(str, i);
    }

    public final void showToast$tap_common_release(String content, int toastDuration) {
        Toast toast2 = toast;
        if (toast2 != null) {
            toast2.cancel();
        }
        View viewInflate = LayoutInflater.from(TapTapKit.INSTANCE.getContext()).inflate(R.layout.layout_tap_toast, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tap_toast_text);
        if (textView != null) {
            textView.setText(content);
        }
        Toast toast3 = new Toast(TapTapKit.INSTANCE.getContext());
        toast3.setDuration(toastDuration);
        toast3.setView(viewInflate);
        toast3.setGravity(17, 0, 0);
        toast3.show();
        toast = toast3;
    }

    public static /* synthetic */ void showBottomToast$default(TapToast tapToast, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        tapToast.showBottomToast(str, i);
    }

    public final void showBottomToast(String content, int yOffset) {
        Intrinsics.checkNotNullParameter(content, "content");
        Toast toast2 = toast;
        if (toast2 != null) {
            toast2.cancel();
        }
        View viewInflate = LayoutInflater.from(TapTapKit.INSTANCE.getContext()).inflate(R.layout.layout_tap_toast, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tap_toast_text);
        if (textView != null) {
            textView.setText(content);
        }
        Toast toast3 = new Toast(TapTapKit.INSTANCE.getContext());
        toast3.setDuration(0);
        toast3.setView(viewInflate);
        toast3.setGravity(80, 0, yOffset);
        toast3.show();
        toast = toast3;
    }

    public final void clear() {
        Toast toast2 = toast;
        if (toast2 != null) {
            toast2.cancel();
        }
        toast = null;
    }
}
