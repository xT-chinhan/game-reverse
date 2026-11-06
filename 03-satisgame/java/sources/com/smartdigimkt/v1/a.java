package com.smartdigimkt.v1;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import com.smartdigimkt.sdk.basead.ui.ScanningAnimButton;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements h {
    public ScanningAnimButton a;
    public ScanningAnimButton b;

    public final void a(Drawable drawable) {
        ScanningAnimButton scanningAnimButton = this.a;
        if (scanningAnimButton == null || drawable == null) {
            return;
        }
        try {
            scanningAnimButton.setBackground(drawable);
        } catch (Throwable unused) {
        }
    }

    @Override // com.smartdigimkt.v1.h
    public void c(ViewGroup viewGroup) {
    }
}
