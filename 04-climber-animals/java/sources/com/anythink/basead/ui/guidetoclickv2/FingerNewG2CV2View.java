package com.anythink.basead.ui.guidetoclickv2;

import android.content.Context;
import android.view.View;
import com.anythink.basead.ui.GuideToClickV2View;

/* JADX INFO: loaded from: classes.dex */
public class FingerNewG2CV2View extends BaseG2CV2View {
    GuideToClickV2View d;

    public FingerNewG2CV2View(Context context) {
        super(context);
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.BaseG2CV2View
    final void a(int i, int i2) {
        setGravity(17);
        GuideToClickV2View guideToClickV2View = new GuideToClickV2View(getContext());
        this.d = guideToClickV2View;
        guideToClickV2View.setFingerViewType(i);
        addView(this.d, -1, -1);
        setClipChildren(false);
        if (this.c != null) {
            setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.guidetoclickv2.FingerNewG2CV2View.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (FingerNewG2CV2View.this.c != null) {
                        FingerNewG2CV2View.this.c.a(11, 47);
                    }
                }
            });
        }
    }
}
