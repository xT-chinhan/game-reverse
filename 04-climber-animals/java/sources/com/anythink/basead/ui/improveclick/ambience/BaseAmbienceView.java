package com.anythink.basead.ui.improveclick.ambience;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.anythink.basead.ui.improveclick.c;
import com.anythink.core.common.h.x;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseAmbienceView extends RelativeLayout {
    protected c.a a;

    public abstract void initSetting(x xVar, c.a aVar);

    protected abstract void initView();

    public abstract void onPause();

    public abstract void onResume();

    public abstract void release();

    public BaseAmbienceView(Context context) {
        super(context);
        initView();
    }

    public BaseAmbienceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public BaseAmbienceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }
}
