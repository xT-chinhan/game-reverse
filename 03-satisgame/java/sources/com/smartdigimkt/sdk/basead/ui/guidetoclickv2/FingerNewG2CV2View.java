package com.smartdigimkt.sdk.basead.ui.guidetoclickv2;

import android.content.Context;
import com.smartdigimkt.sdk.basead.ui.GuideToClickV2View;
import com.smartdigimkt.y1.j;

/* JADX INFO: loaded from: classes3.dex */
public class FingerNewG2CV2View extends BaseG2CV2View {
    public GuideToClickV2View h;

    public FingerNewG2CV2View(Context context) {
        super(context);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.guidetoclickv2.BaseG2CV2View
    public final void initView(int i, int i2) {
        setGravity(17);
        GuideToClickV2View guideToClickV2View = new GuideToClickV2View(getContext());
        this.h = guideToClickV2View;
        guideToClickV2View.setFingerViewType(i);
        addView(this.h, -1, -1);
        setClipChildren(false);
        if (this.e != null) {
            setOnClickListener(new j(this));
        }
    }
}
