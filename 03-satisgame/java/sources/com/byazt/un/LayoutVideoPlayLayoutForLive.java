package com.byazt.un;

import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.byazt.kfh.TTProgressBar;
import com.byazt.lz.TTViewStub;
import com.byazt.tk.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 14, 15})
public class LayoutVideoPlayLayoutForLive extends RelativeLayout {
    public LayoutVideoPlayLayoutForLive(Context context) {
        super(context);
        n(context);
    }

    private void n(final Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387714);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        relativeLayout2.setId(2114387900);
        relativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout2.setBackgroundColor(0);
        relativeLayout2.setGravity(17);
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387651);
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        final TTProgressBar tTProgressBar = new TTProgressBar(context);
        tTProgressBar.setId(2114387631);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.byazt.okk.s.s(context, 60.0f), com.byazt.okk.s.s(context, 60.0f));
        layoutParams.addRule(13);
        tTProgressBar.setLayoutParams(layoutParams);
        sz.n(context, "tt_normalscreen_loading", new com.byazt.qyj.n<Bitmap>() { // from class: com.byazt.un.LayoutVideoPlayLayoutForLive.1
            @Override // com.byazt.qyj.n
            public void n(Bitmap bitmap) {
                tTProgressBar.setIndeterminateDrawable(TTProgressBar.n(context, new BitmapDrawable(context.getResources(), bitmap), 0, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL, 0.5f, 0.5f));
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        relativeLayout2.addView(imageView);
        relativeLayout2.addView(tTProgressBar);
        relativeLayout.addView(relativeLayout2);
        View viewQg = new s().qg(context);
        viewQg.setId(2114387888);
        relativeLayout.addView(viewQg);
        View viewQg2 = new q().qg(context);
        viewQg2.setId(2114387688);
        relativeLayout.addView(viewQg2);
        ImageView imageView2 = new ImageView(context);
        imageView2.setId(2114387626);
        imageView2.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        sz.n(context, "tt_new_play_video", imageView2, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        imageView2.setVisibility(8);
        relativeLayout.addView(imageView2);
        TTProgressBar tTProgressBar2 = new TTProgressBar(context, null, R.style.Widget.ProgressBar.Horizontal);
        tTProgressBar2.setIndeterminate(false);
        tTProgressBar2.setId(2114387653);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, com.byazt.okk.s.s(context, 1.5f));
        layoutParams2.addRule(12);
        tTProgressBar2.setBackgroundColor(0);
        tTProgressBar2.setIndeterminateDrawable(null);
        tTProgressBar2.setMax(100);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#A5FFFFFF"));
        float fS = com.byazt.okk.s.s(context, 1.0f);
        gradientDrawable.setCornerRadius(fS);
        int iS = com.byazt.okk.s.s(context, 2.0f);
        gradientDrawable.setSize(-1, iS);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(Color.parseColor("#FFFFFFFF"));
        gradientDrawable2.setCornerRadius(fS);
        gradientDrawable2.setSize(-1, iS);
        ClipDrawable clipDrawable = new ClipDrawable(gradientDrawable2, 3, 1);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(Color.parseColor("#FFF85959"));
        gradientDrawable3.setCornerRadius(fS);
        gradientDrawable3.setSize(-1, iS);
        tTProgressBar2.setProgressDrawable(new LayerDrawable(new Drawable[]{gradientDrawable, clipDrawable, new ClipDrawable(gradientDrawable3, 3, 1)}));
        tTProgressBar2.setVisibility(8);
        relativeLayout.addView(tTProgressBar2, layoutParams2);
        TTViewStub tTViewStub = new TTViewStub(context, new w());
        tTViewStub.setId(2114387744);
        tTViewStub.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.addView(tTViewStub);
        TTViewStub tTViewStub2 = new TTViewStub(context, new qg());
        tTViewStub2.setId(2114387666);
        tTViewStub2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.addView(tTViewStub2);
        TTViewStub tTViewStub3 = new TTViewStub(context, new x());
        tTViewStub3.setId(2114387828);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(13);
        tTViewStub3.setLayoutParams(layoutParams3);
        relativeLayout.addView(tTViewStub3);
        addView(relativeLayout);
    }
}
