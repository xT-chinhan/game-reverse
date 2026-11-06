package com.smartdigimkt.e;

import android.view.View;
import com.smartdigimkt.china.formatbusiness.ui.LeftSkipSinglePictureSplashATView;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 implements View.OnClickListener {
    public final /* synthetic */ LeftSkipSinglePictureSplashATView a;

    public c0(LeftSkipSinglePictureSplashATView leftSkipSinglePictureSplashATView) {
        this.a = leftSkipSinglePictureSplashATView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        LeftSkipSinglePictureSplashATView leftSkipSinglePictureSplashATView = this.a;
        int i = LeftSkipSinglePictureSplashATView.r0;
        leftSkipSinglePictureSplashATView.a(1, 1);
    }
}
