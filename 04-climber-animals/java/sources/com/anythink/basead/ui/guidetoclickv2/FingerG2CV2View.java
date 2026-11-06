package com.anythink.basead.ui.guidetoclickv2;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import com.anythink.basead.ui.GuideToClickView;

/* JADX INFO: loaded from: classes.dex */
public class FingerG2CV2View extends BaseG2CV2View {
    GuideToClickView d;
    int e;

    public FingerG2CV2View(Context context) {
        super(context);
        this.e = 501;
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    final void a(int i, int i2) {
        setGravity(17);
        GuideToClickView guideToClickView = new GuideToClickView(getContext());
        this.d = guideToClickView;
        guideToClickView.setFingerViewMode(this.e);
        addView(this.d, -2, -2);
        setClipChildren(false);
        if (this.c != null) {
            setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.guidetoclickv2.FingerG2CV2View.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (FingerG2CV2View.this.c != null) {
                        FingerG2CV2View.this.c.a(11, 20);
                    }
                }
            });
        }
    }

    public void setFingerViewMode(int i) {
        if (i == 503) {
            setBackgroundColor(Color.parseColor("#66000000"));
        }
        this.e = i;
        GuideToClickView guideToClickView = this.d;
        if (guideToClickView != null) {
            guideToClickView.setFingerViewMode(i);
        }
    }
}
