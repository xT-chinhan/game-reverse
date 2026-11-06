package com.smartdigimkt.u1;

import com.smartdigimkt.sdk.basead.ui.CountDownView;
import com.smartdigimkt.sdk.basead.ui.web.WebProgressBarView;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public final com.smartdigimkt.b3.e a;
    public final CountDownView b;
    public final WebProgressBarView c;
    public long d;

    public e(com.smartdigimkt.b3.e eVar, CountDownView countDownView, WebProgressBarView webProgressBarView) {
        this.a = eVar;
        this.b = countDownView;
        this.c = webProgressBarView;
    }

    public final void a(int i) {
        long j = this.a.b1;
        if (j == 1 || j == 4) {
            CountDownView countDownView = this.b;
            if (countDownView != null && countDownView.getVisibility() != i) {
                countDownView.setVisibility(i);
            }
        } else {
            CountDownView countDownView2 = this.b;
            if (countDownView2 != null && countDownView2.getVisibility() != 8) {
                countDownView2.setVisibility(8);
            }
        }
        long j2 = this.a.b1;
        if (j2 == 2 || j2 == 4) {
            WebProgressBarView webProgressBarView = this.c;
            if (webProgressBarView == null || webProgressBarView.getVisibility() == i) {
                return;
            }
            webProgressBarView.setVisibility(i);
            return;
        }
        WebProgressBarView webProgressBarView2 = this.c;
        if (webProgressBarView2 == null || webProgressBarView2.getVisibility() == 8) {
            return;
        }
        webProgressBarView2.setVisibility(8);
    }
}
