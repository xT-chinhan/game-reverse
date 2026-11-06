package com.smartdigimkt.d2;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.smartdigimkt.sdk.basead.ui.component.RoundImageView;
import com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask.CountDownSkipIncentiveTaskView;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements com.smartdigimkt.i3.l {
    public final /* synthetic */ String a;
    public final /* synthetic */ CountDownSkipIncentiveTaskView b;

    public d(CountDownSkipIncentiveTaskView countDownSkipIncentiveTaskView, String str) {
        this.b = countDownSkipIncentiveTaskView;
        this.a = str;
    }

    @Override // com.smartdigimkt.i3.l
    public final void a() {
    }

    @Override // com.smartdigimkt.i3.l
    public final void a(String str, Bitmap bitmap) {
        RoundImageView roundImageView;
        if (!TextUtils.equals(str, this.a) || (roundImageView = this.b.i) == null) {
            return;
        }
        roundImageView.setImageBitmap(bitmap);
    }
}
