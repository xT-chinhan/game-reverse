package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bykv.vk.component.ttvideo.player.C;
import com.smartdigimkt.a3.a;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.b3.e;
import com.smartdigimkt.h1.n;
import com.smartdigimkt.i2.l;
import com.smartdigimkt.n1.q0;
import com.smartdigimkt.n1.r0;
import com.smartdigimkt.r4.k;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseMediaATView extends FrameLayout {
    public final c a;
    public final e b;
    public final a c;
    public final n d;
    public final boolean e;
    public int f;
    public int g;
    public boolean h;
    public final FrameLayout i;
    public final CloseImageView j;
    public int k;

    public BaseMediaATView(Context context) {
        super(context);
        this.f = 0;
        this.g = 0;
        this.h = false;
    }

    public void changeCloseViewSizeAfterClick() {
        CloseImageView closeImageView = this.j;
        if (closeImageView == null || this.b == null) {
            return;
        }
        l.a(closeImageView, true, this.c, true);
    }

    public void destroy() {
    }

    public List<View> getClickViews() {
        return new ArrayList();
    }

    public List<View> getContainerClickViews() {
        return new ArrayList();
    }

    public int getLayoutParamsHeight() {
        if (this.h) {
            return -2;
        }
        return this.g;
    }

    public int getMediaViewHeight() {
        return this.g;
    }

    public int getMediaViewWidth() {
        return this.f;
    }

    public View getMonitorClickView() {
        return null;
    }

    public void init(int i, int i2, int i3) {
        float f;
        float f2;
        this.f = i;
        this.g = i2;
        this.k = i3;
        boolean z = i2 == -2;
        this.h = z;
        if (z && i > 0) {
            if (i3 == 1 || i3 == 2) {
                f = i;
                f2 = 0.5f;
            } else {
                f = i;
                f2 = 0.75f;
            }
            this.g = (int) (f * f2);
        }
        CloseImageView closeImageView = this.j;
        if (closeImageView != null) {
            if (this.e) {
                closeImageView.setVisibility(0);
            } else {
                closeImageView.setVisibility(8);
            }
            l.a(this.j, false, this.c, true);
            this.j.setOnClickListener(new r0(this));
        }
        if (this.f == -1) {
            post(new q0(this));
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int i3;
        float f;
        float f2;
        if (this.h) {
            int size = View.MeasureSpec.getMode(i) == 0 ? this.f : View.MeasureSpec.getSize(i);
            if (size > 0) {
                int i4 = this.k;
                if (i4 == 1 || i4 == 2) {
                    f = size;
                    f2 = 0.5f;
                } else {
                    f = size;
                    f2 = 0.75f;
                }
                i3 = (int) (f * f2);
            } else {
                i3 = 0;
            }
            if (i3 > 0) {
                int mode = View.MeasureSpec.getMode(i2);
                int size2 = View.MeasureSpec.getSize(i2);
                if (mode != 0 && size2 > 0 && size2 < i3) {
                    i3 = size2;
                }
                i2 = View.MeasureSpec.makeMeasureSpec(i3, C.ENCODING_PCM_32BIT);
            }
        }
        super.onMeasure(i, i2);
    }

    public BaseMediaATView(Context context, c cVar, a aVar, n nVar) {
        super(context);
        this.f = 0;
        this.g = 0;
        this.h = false;
        this.a = cVar;
        e eVar = aVar.s;
        this.b = eVar;
        this.e = eVar.o == 0;
        this.d = nVar;
        this.c = aVar;
        LayoutInflater.from(getContext()).inflate(k.a(getContext(), "base_myoffer_media_ad_view", "layout"), this);
        this.i = (FrameLayout) findViewById(k.a(getContext(), "base_media_view_content", "id"));
        this.j = (CloseImageView) findViewById(k.a(getContext(), "base_media_ad_close", "id"));
    }
}
