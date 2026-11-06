package com.byazt.stl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import com.byazt.cq.fs;
import com.byazt.hkc.cp;
import com.byazt.tk.sz;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, 1119})
public class TTRatingBar2 extends FrameLayout {
    public double l;
    public LinearLayout n;
    public float q;
    public LinearLayout qg;
    public float s;
    public float w;
    public static final int x = (cp.qg("", 0.0f, true)[1] / 2) + 1;
    public static final int fs = (cp.qg("", 0.0f, true)[1] / 2) + 3;

    public TTRatingBar2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = new LinearLayout(getContext());
        this.qg = new LinearLayout(getContext());
        this.n.setOrientation(0);
        this.n.setGravity(GravityCompat.START);
        this.qg.setOrientation(0);
        this.qg.setGravity(GravityCompat.START);
    }

    public void n(double d, final int i, int i2, int i3) {
        float f = i2;
        this.s = (int) fs.s(getContext(), f);
        this.q = (int) fs.s(getContext(), f);
        this.l = d;
        this.w = i3;
        removeAllViews();
        sz.n(getContext(), "tt_star", new com.byazt.qyj.n<Bitmap>() { // from class: com.byazt.stl.TTRatingBar2.1
            @Override // com.byazt.qyj.n
            public void n(Bitmap bitmap) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(TTRatingBar2.this.getContext().getResources(), bitmap);
                for (int i4 = 0; i4 < 5; i4++) {
                    ImageView starImageView = TTRatingBar2.this.getStarImageView();
                    starImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    starImageView.setColorFilter(i, PorterDuff.Mode.SRC_IN);
                    starImageView.setImageDrawable(bitmapDrawable);
                    TTRatingBar2.this.qg.addView(starImageView);
                }
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        sz.n(getContext(), "tt_star_thick", new com.byazt.qyj.n<Bitmap>() { // from class: com.byazt.stl.TTRatingBar2.2
            @Override // com.byazt.qyj.n
            public void n(Bitmap bitmap) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(TTRatingBar2.this.getContext().getResources(), bitmap);
                for (int i4 = 0; i4 < 5; i4++) {
                    ImageView starImageView = TTRatingBar2.this.getStarImageView();
                    starImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    starImageView.setImageDrawable(bitmapDrawable);
                    TTRatingBar2.this.n.addView(starImageView);
                }
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        addView(this.n);
        addView(this.qg);
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams((int) this.s, (int) this.q));
        imageView.setPadding(1, x, 1, fs);
        return imageView;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.n.measure(i, i2);
        double d = this.l;
        float f = this.s;
        this.qg.measure(View.MeasureSpec.makeMeasureSpec((int) (((double) ((((int) d) * f) + 1.0f)) + (((double) (f - 2.0f)) * (d - ((double) ((int) d))))), C.ENCODING_PCM_32BIT), View.MeasureSpec.makeMeasureSpec(this.n.getMeasuredHeight(), C.ENCODING_PCM_32BIT));
        if (this.w > 0.0f) {
            LinearLayout linearLayout = this.n;
            linearLayout.setPadding(0, ((int) (linearLayout.getMeasuredHeight() - this.w)) / 2, 0, 0);
            this.qg.setPadding(0, ((int) (this.n.getMeasuredHeight() - this.w)) / 2, 0, 0);
        }
    }
}
