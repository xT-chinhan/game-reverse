package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qr;

/* JADX INFO: loaded from: classes2.dex */
public class NativeDrawVideoTsView extends NativeVideoTsView implements View.OnClickListener {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private boolean f3591ms;
    private int xr;

    public NativeDrawVideoTsView(Context context, lm lmVar) {
        super(context, lmVar);
        this.f3591ms = false;
        setOnClickListener(this);
        this.xr = getResources().getConfiguration().orientation;
    }

    public NativeDrawVideoTsView(Context context, lm lmVar, String str, boolean z, boolean z2) {
        super(context, lmVar, str, z, z2);
        this.f3591ms = false;
        setOnClickListener(this);
        this.xr = getResources().getConfiguration().orientation;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    protected void ab() {
        this.ub = "draw_ad";
        super.ab();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    protected void xr() {
        if (this.f3591ms) {
            super.xr();
        }
    }

    public void setCanInterruptVideoPlay(boolean z) {
        this.f3591ms = z;
    }

    public void ms(Bitmap bitmap, int i) {
        ch.ub().ms(bitmap);
        this.ao = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    protected void onWindowVisibilityChanged(int i) {
        if (this.sl != null && this.sl.getVisibility() == 0) {
            nw();
        } else {
            super.onWindowVisibilityChanged(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        if (this.sl != null && this.sl.getVisibility() == 0) {
            nw();
        } else {
            super.onWindowFocusChanged(z);
        }
    }

    private void x() {
        ul.ms((View) this.ch, 0);
        ul.ms((View) this.hi, 0);
        ul.ms((View) this.zb, 8);
    }

    private void nw() {
        hi();
        if (this.ch != null) {
            if (this.ch.getVisibility() == 0) {
                return;
            }
            com.bytedance.sdk.openadsdk.x.xr.ms(qr.xr(this.d)).ms(this.hi);
            ms(this.hi, qr.xr(this.d));
        }
        x();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.sl != null && this.sl.getVisibility() == 0) {
            ul.ka(this.ch);
        }
        xr();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        if (this.xr == configuration.orientation) {
            return;
        }
        this.xr = configuration.orientation;
        ul.ms(this, new ul.ms() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeDrawVideoTsView.1
            @Override // com.bytedance.sdk.openadsdk.core.jw.ul.ms
            public void ms(View view) {
                if (NativeDrawVideoTsView.this.ka == null) {
                    return;
                }
                NativeDrawVideoTsView.this.ms(NativeDrawVideoTsView.this.getWidth(), NativeDrawVideoTsView.this.getHeight());
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void d() {
        int i = getResources().getConfiguration().orientation;
        if (this.xr != i) {
            this.xr = i;
            ul.ms(this, new ul.ms() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeDrawVideoTsView.2
                @Override // com.bytedance.sdk.openadsdk.core.jw.ul.ms
                public void ms(View view) {
                    if (NativeDrawVideoTsView.this.ka == null) {
                        return;
                    }
                    NativeDrawVideoTsView.this.ms(NativeDrawVideoTsView.this.getWidth(), NativeDrawVideoTsView.this.getHeight());
                    NativeDrawVideoTsView.super.d();
                }
            });
        } else {
            super.d();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    protected com.bykv.vk.openvk.component.video.api.d.ah ms(Context context, ViewGroup viewGroup, lm lmVar, String str, boolean z, boolean z2, boolean z3) {
        return new ah(context, viewGroup, lmVar, str, z, z2, z3);
    }
}
