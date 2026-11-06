package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;

/* JADX INFO: loaded from: classes2.dex */
public class ub {
    private com.bykv.vk.openvk.component.video.api.ah.ah ab;
    private Context ah;
    private boolean c = false;
    private com.bytedance.sdk.openadsdk.core.video.nativevideo.xr d;
    private xr ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private View f3742ms;
    private View ny;
    private TTViewStub x;
    private TextView xr;

    public enum ms {
        PAUSE_VIDEO,
        RELEASE_VIDEO,
        START_VIDEO
    }

    public interface xr {
        boolean ch();

        void sl();
    }

    public void ms(Context context, View view) {
        if (context == null || !(view instanceof ViewGroup)) {
            return;
        }
        this.ny = view;
        this.ah = re.getContext().getApplicationContext();
        try {
            this.x = new TTViewStub(context, new com.bytedance.sdk.openadsdk.res.layout.video.x());
        } catch (Throwable unused) {
        }
    }

    private void ms(Context context, View view, boolean z) {
        TTViewStub tTViewStub;
        if (context == null || view == null || (tTViewStub = this.x) == null || tTViewStub.getParent() == null || this.f3742ms != null) {
            return;
        }
        this.x.ms();
        this.f3742ms = view.findViewById(2114387876);
        this.xr = (TextView) view.findViewById(2114387823);
        View viewFindViewById = view.findViewById(2114387886);
        if (z) {
            viewFindViewById.setClickable(true);
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.ub.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    ub.this.ah();
                    if (ub.this.d != null) {
                        ub.this.d.ms(ms.START_VIDEO, (String) null);
                    }
                }
            });
        } else {
            viewFindViewById.setOnClickListener(null);
            viewFindViewById.setClickable(false);
        }
    }

    public void ms(com.bytedance.sdk.openadsdk.core.video.nativevideo.xr xrVar, xr xrVar2) {
        this.ka = xrVar2;
        this.d = xrVar;
    }

    private void xr() {
        this.ab = null;
    }

    public boolean ms(int i, com.bykv.vk.openvk.component.video.api.ah.ah ahVar, boolean z) {
        Context context = this.ah;
        if (context != null && ahVar != null) {
            try {
                ms(context, this.ny, z);
                this.ab = ahVar;
                if (i == 1 || i == 2) {
                    return ms(i);
                }
                return true;
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.sl.ms(th);
            }
        }
        return true;
    }

    private boolean ms(int i) {
        xr xrVar;
        if (ms() || this.c) {
            return true;
        }
        if (this.d != null && (xrVar = this.ka) != null) {
            if (xrVar.ch()) {
                this.d.ka(null, null);
            }
            this.d.ms(ms.PAUSE_VIDEO, (String) null);
        }
        ms(this.ab, true);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah() {
        if (this.ah == null) {
            return;
        }
        d();
    }

    public void ms(boolean z) {
        if (z) {
            xr();
        }
        d();
    }

    public boolean ms() {
        View view = this.f3742ms;
        return view != null && view.getVisibility() == 0;
    }

    private void d() {
        View view = this.f3742ms;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void ms(com.bykv.vk.openvk.component.video.api.ah.ah ahVar, boolean z) {
        View view;
        String str;
        View view2;
        if (ahVar == null || (view = this.f3742ms) == null || this.ah == null || view.getVisibility() == 0) {
            return;
        }
        xr xrVar = this.ka;
        if (xrVar != null) {
            xrVar.sl();
        }
        int iCeil = (int) Math.ceil((ahVar.ka() * 1.0d) / 1048576.0d);
        if (z) {
            str = t.ms(this.ah, "tt_video_without_wifi_tips") + iCeil + t.ms(this.ah, "tt_video_bytesize_MB") + t.ms(this.ah, "tt_video_bytesize");
        } else {
            str = t.ms(this.ah, "tt_video_without_wifi_tips") + t.ms(this.ah, "tt_video_bytesize");
        }
        ul.ms(this.f3742ms, 0);
        ul.ms(this.xr, str);
        if (!ul.d(this.f3742ms) || (view2 = this.f3742ms) == null) {
            return;
        }
        view2.bringToFront();
    }
}
