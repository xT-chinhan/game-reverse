package com.mcto.sspsdk.internal;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: loaded from: classes2.dex */
public final class ek extends ViewOutlineProvider {
    public final /* synthetic */ float a;
    public final /* synthetic */ int b;

    public ek(int i, float f) {
        this.a = f;
        this.b = i;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        int width = view.getWidth();
        int height = view.getHeight();
        int iCeil = (int) Math.ceil(this.a);
        switch (j.a(this.b)) {
            case 0:
                outline.setRoundRect(0, 0, width, height, this.a);
                break;
            case 1:
                outline.setRoundRect(0, 0, width + iCeil, height, this.a);
                break;
            case 2:
                outline.setRoundRect(0, 0, width, height + iCeil, this.a);
                break;
            case 3:
                outline.setRoundRect(0 - iCeil, 0, width, height, this.a);
                break;
            case 4:
                outline.setRoundRect(0, 0 - iCeil, width, height, this.a);
                break;
        }
    }
}
