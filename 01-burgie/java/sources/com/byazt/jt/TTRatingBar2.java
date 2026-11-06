package com.byazt.jt;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.InputDeviceCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.byazt.ca.g;
import com.byazt.js.zo;
import com.byazt.uko.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 86, InputDeviceCompat.SOURCE_GAMEPAD})
public class TTRatingBar2 extends FrameLayout {
    public static final int fw = (w.hw("", 0.0f, true)[1] / 2) + 1;
    public static final int zo = (w.hw("", 0.0f, true)[1] / 2) + 3;
    public double c;
    public float hn;
    public LinearLayout hw;
    public LinearLayout pr;
    public float uc;
    public float x;

    public TTRatingBar2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pr = new LinearLayout(getContext());
        this.hw = new LinearLayout(getContext());
        this.pr.setOrientation(0);
        this.pr.setGravity(GravityCompat.START);
        this.hw.setOrientation(0);
        this.hw.setGravity(GravityCompat.START);
    }

    public void pr(double d, final int i, int i2, int i3) {
        float f = i2;
        this.hn = (int) zo.hn(getContext(), f);
        this.x = (int) zo.hn(getContext(), f);
        this.c = d;
        this.uc = i3;
        removeAllViews();
        g.pr(getContext(), "tt_star", new com.byazt.ezf.pr<Bitmap>() { // from class: com.byazt.jt.TTRatingBar2.1
            @Override // com.byazt.ezf.pr
            public void pr(Bitmap bitmap) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(TTRatingBar2.this.getContext().getResources(), bitmap);
                for (int i4 = 0; i4 < 5; i4++) {
                    ImageView starImageView = TTRatingBar2.this.getStarImageView();
                    starImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    starImageView.setColorFilter(i, PorterDuff.Mode.SRC_IN);
                    starImageView.setImageDrawable(bitmapDrawable);
                    TTRatingBar2.this.hw.addView(starImageView);
                }
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        g.pr(getContext(), "tt_star_thick", new com.byazt.ezf.pr<Bitmap>() { // from class: com.byazt.jt.TTRatingBar2.2
            @Override // com.byazt.ezf.pr
            public void pr(Bitmap bitmap) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(TTRatingBar2.this.getContext().getResources(), bitmap);
                for (int i4 = 0; i4 < 5; i4++) {
                    ImageView starImageView = TTRatingBar2.this.getStarImageView();
                    starImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    starImageView.setImageDrawable(bitmapDrawable);
                    TTRatingBar2.this.pr.addView(starImageView);
                }
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        addView(this.pr);
        addView(this.hw);
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams((int) this.hn, (int) this.x));
        imageView.setPadding(1, fw, 1, zo);
        return imageView;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.pr.measure(i, i2);
        double d = this.c;
        float f = this.hn;
        this.hw.measure(View.MeasureSpec.makeMeasureSpec((int) (((double) ((((int) d) * f) + 1.0f)) + (((double) (f - 2.0f)) * (d - ((double) ((int) d))))), 1073741824), View.MeasureSpec.makeMeasureSpec(this.pr.getMeasuredHeight(), 1073741824));
        if (this.uc > 0.0f) {
            LinearLayout linearLayout = this.pr;
            linearLayout.setPadding(0, ((int) (linearLayout.getMeasuredHeight() - this.uc)) / 2, 0, 0);
            this.hw.setPadding(0, ((int) (this.pr.getMeasuredHeight() - this.uc)) / 2, 0, 0);
        }
    }
}
