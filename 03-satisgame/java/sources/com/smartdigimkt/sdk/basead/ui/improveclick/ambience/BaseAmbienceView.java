package com.smartdigimkt.sdk.basead.ui.improveclick.ambience;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.smartdigimkt.a3.a;
import com.smartdigimkt.b2.e;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseAmbienceView extends RelativeLayout {
    public e a;

    public BaseAmbienceView(Context context) {
        super(context);
        initView();
    }

    public abstract void initSetting(a aVar, e eVar);

    public abstract void initView();

    public abstract void onPause();

    public abstract void onResume();

    public abstract void release();

    public BaseAmbienceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public BaseAmbienceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }
}
