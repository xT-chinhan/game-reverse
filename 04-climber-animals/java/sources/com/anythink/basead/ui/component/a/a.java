package com.anythink.basead.ui.component.a;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.anythink.basead.ui.ScanningAnimButton;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements d {
    protected ScanningAnimButton a;
    protected ScanningAnimButton b;

    @Override // com.anythink.basead.ui.component.a.d
    public void a(ViewGroup viewGroup) {
    }

    @Override // com.anythink.basead.ui.component.a.d
    public final void a(Drawable drawable) {
        if (this.a == null || drawable == null) {
            return;
        }
        try {
            this.a.setBackground(drawable);
        } catch (Throwable unused) {
        }
    }

    @Override // com.anythink.basead.ui.component.a.d
    public final void a(String str) {
        ScanningAnimButton scanningAnimButton = this.a;
        if (scanningAnimButton != null) {
            scanningAnimButton.setText(str);
        }
    }

    @Override // com.anythink.basead.ui.component.a.d
    public final String a() {
        ScanningAnimButton scanningAnimButton = this.a;
        if (scanningAnimButton == null) {
            return "";
        }
        scanningAnimButton.getText().toString();
        return "";
    }

    @Override // com.anythink.basead.ui.component.a.d
    public final View b() {
        return this.a;
    }

    @Override // com.anythink.basead.ui.component.a.d
    public final View c() {
        return this.b;
    }
}
