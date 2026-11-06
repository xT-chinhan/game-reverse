package com.taptap.sdk.kit.internal.utils;

import android.os.Handler;
import android.os.Looper;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rJ!\u0010\u000e\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\rH\u0001¢\u0006\u0002\b\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/taptap/sdk/kit/internal/utils/TapToast;", "", "()V", "mainHandler", "Landroid/os/Handler;", "toast", "Landroid/widget/Toast;", "clear", "", "showBottomToast", "content", "", "yOffset", "", "showToast", "toastDuration", "showToast$tap_common_release", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapToast {
    public static final TapToast INSTANCE = new TapToast();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    private static Toast toast;

    private TapToast() {
    }

    public static /* synthetic */ void showToast$tap_common_release$default(TapToast tapToast, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        tapToast.showToast$tap_common_release(str, i);
    }

    public final void showToast$tap_common_release(final String content, final int toastDuration) {
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            mainHandler.post(new Runnable() { // from class: com.taptap.sdk.kit.internal.utils.TapToast$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    TapToast.showToast$lambda$0(content, toastDuration);
                }
            });
            return;
        }
        Toast toast2 = toast;
        if (toast2 != null) {
            toast2.cancel();
        }
        View toastView = LayoutInflater.from(TapTapKit.INSTANCE.getContext()).inflate(R.layout.layout_tap_toast, (ViewGroup) null);
        TextView $this$showToast_u24lambda_u241 = (TextView) toastView.findViewById(R.id.tap_toast_text);
        if ($this$showToast_u24lambda_u241 != null) {
            $this$showToast_u24lambda_u241.setText(content);
        }
        Toast $this$showToast_u24lambda_u242 = new Toast(TapTapKit.INSTANCE.getContext());
        $this$showToast_u24lambda_u242.setDuration(toastDuration);
        $this$showToast_u24lambda_u242.setView(toastView);
        $this$showToast_u24lambda_u242.setGravity(17, 0, 0);
        $this$showToast_u24lambda_u242.show();
        toast = $this$showToast_u24lambda_u242;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showToast$lambda$0(String $content, int $toastDuration) {
        INSTANCE.showToast$tap_common_release($content, $toastDuration);
    }

    public static /* synthetic */ void showBottomToast$default(TapToast tapToast, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        tapToast.showBottomToast(str, i);
    }

    public final void showBottomToast(final String content, final int yOffset) {
        Intrinsics.checkNotNullParameter(content, "content");
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            mainHandler.post(new Runnable() { // from class: com.taptap.sdk.kit.internal.utils.TapToast$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    TapToast.showBottomToast$lambda$3(content, yOffset);
                }
            });
            return;
        }
        Toast toast2 = toast;
        if (toast2 != null) {
            toast2.cancel();
        }
        View toastView = LayoutInflater.from(TapTapKit.INSTANCE.getContext()).inflate(R.layout.layout_tap_toast, (ViewGroup) null);
        TextView $this$showBottomToast_u24lambda_u244 = (TextView) toastView.findViewById(R.id.tap_toast_text);
        if ($this$showBottomToast_u24lambda_u244 != null) {
            $this$showBottomToast_u24lambda_u244.setText(content);
        }
        Toast $this$showBottomToast_u24lambda_u245 = new Toast(TapTapKit.INSTANCE.getContext());
        $this$showBottomToast_u24lambda_u245.setDuration(0);
        $this$showBottomToast_u24lambda_u245.setView(toastView);
        $this$showBottomToast_u24lambda_u245.setGravity(80, 0, yOffset);
        $this$showBottomToast_u24lambda_u245.show();
        toast = $this$showBottomToast_u24lambda_u245;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showBottomToast$lambda$3(String content, int $yOffset) {
        Intrinsics.checkNotNullParameter(content, "$content");
        INSTANCE.showBottomToast(content, $yOffset);
    }

    public final void clear() {
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            mainHandler.post(new Runnable() { // from class: com.taptap.sdk.kit.internal.utils.TapToast$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    TapToast.clear$lambda$6();
                }
            });
            return;
        }
        Toast toast2 = toast;
        if (toast2 != null) {
            toast2.cancel();
        }
        toast = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clear$lambda$6() {
        INSTANCE.clear();
    }
}
