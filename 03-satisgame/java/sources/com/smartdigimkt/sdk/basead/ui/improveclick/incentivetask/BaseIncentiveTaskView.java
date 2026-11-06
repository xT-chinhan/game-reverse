package com.smartdigimkt.sdk.basead.ui.improveclick.incentivetask;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.smartdigimkt.b3.e;
import com.smartdigimkt.d2.a;
import com.smartdigimkt.d2.b;
import com.smartdigimkt.d2.c;
import com.smartdigimkt.m3.d;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseIncentiveTaskView extends RelativeLayout {
    public d a;
    public c b;

    public BaseIncentiveTaskView(Context context) {
        this(context, null);
    }

    public abstract void a();

    public final void b() {
        d dVar = this.a;
        if (dVar != null) {
            dVar.c();
        }
    }

    public void initSetting(com.smartdigimkt.b3.c cVar, e eVar, long j, c cVar2) {
        this.b = cVar2;
        d dVar = new d(eVar.i1, new a(this));
        this.a = dVar;
        dVar.b();
        setOnClickListener(new b());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    public void onPause() {
        d dVar = this.a;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void onResume() {
        d dVar = this.a;
        if (dVar != null) {
            dVar.b();
        }
    }

    public void release() {
        b();
    }

    public BaseIncentiveTaskView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseIncentiveTaskView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
