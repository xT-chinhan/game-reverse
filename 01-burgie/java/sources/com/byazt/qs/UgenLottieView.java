package com.byazt.qs;

import android.content.Context;
import com.byazt.at.x;
import com.byazt.dx.LottieAnimationView;
import com.byazt.is.w;
import com.byazt.llk.c;
import com.byazt.sd.a;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 670, 1833})
public class UgenLottieView extends LottieAnimationView {
    public c pr;

    public UgenLottieView(Context context) {
        super(context);
        zo();
    }

    private void zo() {
        w wVarHw = a.hw();
        if (wVarHw != null && wVarHw.xy()) {
            setTriggerManagerProxy(new hn(x.pr()));
        }
    }

    public void pr(c cVar) {
        this.pr = cVar;
    }

    @Override // com.byazt.dx.LottieAnimationView, android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c cVar = this.pr;
        if (cVar != null) {
            cVar.c();
        }
    }

    @Override // com.byazt.dx.LottieAnimationView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = this.pr;
        if (cVar != null) {
            cVar.uc();
        }
    }
}
