package com.mcto.sspsdk.internal;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.mcto.sspsdk.R;
import com.mcto.sspsdk.component.imageview.QYNiceImageView;
import com.mcto.sspsdk.ssp.fullscreen.QyFullActivity;

/* JADX INFO: loaded from: classes2.dex */
public final class v6 extends q6 {
    public gf v;
    public boolean w;
    public ImageView x;

    public v6(QyFullActivity qyFullActivity) {
        super(qyFullActivity);
    }

    @Override // com.mcto.sspsdk.internal.q6
    public final void a(QYNiceImageView qYNiceImageView, float f) {
        this.k = f;
        this.w = this.e.isMute();
        gf gfVarA = gf.a(getContext(), this.d, this.e, false, false, 1.0f, new u6(this));
        this.v = gfVarA;
        gfVarA.E = 1;
        gfVarA.setId(R.id.qy_interstitial_main_creative);
        gf gfVar = this.v;
        this.l = gfVar;
        gfVar.setId(R.id.qy_full_screen_main_creative);
    }

    @Override // com.mcto.sspsdk.internal.q6
    public final void d() {
        super.d();
        ImageView imageView = (ImageView) findViewById(R.id.qy_full_screen_ad_video_volume);
        this.x = imageView;
        if (imageView != null) {
            imageView.setImageResource(this.w ? R.drawable.qy_ic_volume_off_with_bg : R.drawable.qy_ic_volume_on_with_bg);
        }
    }

    @Override // com.mcto.sspsdk.internal.q6, android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return true;
        }
        if (view.getId() != R.id.qy_full_screen_ad_video_volume) {
            return super.onTouch(view, motionEvent);
        }
        if (this.w) {
            this.v.a(false);
            this.x.setImageResource(R.drawable.qy_ic_volume_on_with_bg);
            this.w = false;
        } else {
            this.v.a(true);
            this.x.setImageResource(R.drawable.qy_ic_volume_off_with_bg);
            this.w = true;
        }
        return true;
    }
}
