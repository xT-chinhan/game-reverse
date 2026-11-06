package com.byazt.un;

import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.byazt.kfh.TTProgressBar;
import com.byazt.lz.TTViewStub;
import com.byazt.tk.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 14, 2323})
public class LayoutVideoDetail extends RelativeLayout {
    public Drawable n;
    public Drawable qg;

    public LayoutVideoDetail(Context context) {
        super(context);
        n(context);
    }

    private void n(Context context) {
        setId(2114387714);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        setBackgroundColor(-1);
        addView(qg(context));
        addView(new q().qg(context));
        addView(s(context));
        addView(q(context));
        addView(l(context));
        addView(w(context));
        addView(x(context));
        addView(fs(context));
        TTViewStub tTViewStub = new TTViewStub(context, new w());
        tTViewStub.setId(2114387744);
        tTViewStub.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        addView(tTViewStub);
        TTViewStub tTViewStub2 = new TTViewStub(context, new qg());
        tTViewStub2.setId(2114387666);
        tTViewStub2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        addView(tTViewStub2);
        addView(rv(context));
    }

    private View qg(final Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387900);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.setBackgroundColor(0);
        relativeLayout.setGravity(17);
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387651);
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        final TTProgressBar tTProgressBar = new TTProgressBar(context);
        tTProgressBar.setId(2114387631);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.byazt.okk.s.s(context, 60.0f), com.byazt.okk.s.s(context, 60.0f));
        layoutParams.addRule(13);
        tTProgressBar.setLayoutParams(layoutParams);
        sz.n(context, "tt_normalscreen_loading", new com.byazt.qyj.n<Bitmap>() { // from class: com.byazt.un.LayoutVideoDetail.1
            @Override // com.byazt.qyj.n
            public void n(Bitmap bitmap) {
                tTProgressBar.setIndeterminateDrawable(TTProgressBar.n(context, new BitmapDrawable(context.getResources(), bitmap), 0, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL, 0.5f, 0.5f));
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(2114387823);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        linearLayout.setLayoutParams(layoutParams2);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        linearLayout.setVisibility(8);
        final ImageView imageView2 = new ImageView(context);
        imageView2.setId(2114387618);
        imageView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        sz.n(context, "tt_refreshing_video_textpage_pressed", new com.byazt.qyj.n<Bitmap>() { // from class: com.byazt.un.LayoutVideoDetail.2
            @Override // com.byazt.qyj.n
            public void n(Bitmap bitmap) {
                LayoutVideoDetail.this.n = new BitmapDrawable(context.getResources(), bitmap);
                LayoutVideoDetail.this.n(context, imageView2);
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        sz.n(context, "tt_refreshing_video_textpage_normal", new com.byazt.qyj.n<Bitmap>() { // from class: com.byazt.un.LayoutVideoDetail.3
            @Override // com.byazt.qyj.n
            public void n(Bitmap bitmap) {
                LayoutVideoDetail.this.qg = new BitmapDrawable(context.getResources(), bitmap);
                LayoutVideoDetail.this.n(context, imageView2);
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        TextView textView = new TextView(context);
        textView.setId(2114387860);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setText("加载失败，点击重试");
        textView.setTextColor(10066329);
        linearLayout.addView(imageView2);
        linearLayout.addView(textView);
        relativeLayout.addView(imageView);
        relativeLayout.addView(tTProgressBar);
        relativeLayout.addView(linearLayout);
        return relativeLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Context context, ImageView imageView) {
        Drawable drawable;
        Drawable drawable2 = this.n;
        if (drawable2 == null || (drawable = this.qg) == null) {
            return;
        }
        imageView.setImageDrawable(com.byazt.cb.n.n(context, drawable2, drawable));
    }

    private View s(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387626);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        sz.n(context, "tt_new_play_video", imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        imageView.setVisibility(8);
        return imageView;
    }

    private View q(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387678);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#26000000"));
        gradientDrawable.setCornerRadius(com.byazt.okk.s.s(context, 4.0f));
        imageView.setBackground(gradientDrawable);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        int color = Color.parseColor("#959595");
        com.byazt.jjh.n nVar = new com.byazt.jjh.n(48);
        nVar.n(color);
        float fS = com.byazt.okk.s.s(context, 2.0f);
        nVar.n(fS);
        int color2 = Color.parseColor("#FFFFFF");
        com.byazt.jjh.n nVar2 = new com.byazt.jjh.n(48);
        nVar2.n(color2);
        nVar2.n(fS);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, nVar);
        stateListDrawable.addState(new int[0], nVar2);
        imageView.setImageDrawable(stateListDrawable);
        int iS = com.byazt.okk.s.s(context, 30.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iS, iS);
        layoutParams.addRule(21);
        layoutParams.addRule(11);
        int iS2 = com.byazt.okk.s.s(context, 7.0f);
        layoutParams.setMargins(0, iS2, iS2, 0);
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    private View l(Context context) {
        TextView textView = new TextView(context);
        textView.setId(2114387730);
        textView.setGravity(8388659);
        textView.setMaxLines(2);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setSingleLine(false);
        textView.setTextSize(2, 17.0f);
        textView.setTextColor(-1);
        textView.setVisibility(8);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        gradientDrawable.setColors(new int[]{Color.parseColor("#FF1A1A1A"), Color.parseColor("#00000000")});
        textView.setBackground(gradientDrawable);
        int i = com.byazt.lz.qg.n.q;
        textView.setPadding(i, com.byazt.lz.qg.n.l, i, 0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(20);
        layoutParams.addRule(10);
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    private View w(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387605);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setVisibility(8);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        gradientDrawable.setColors(new int[]{Color.parseColor("#FF1A1A1A"), Color.parseColor("#00000000")});
        relativeLayout.setBackground(gradientDrawable);
        relativeLayout.setGravity(16);
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387897);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams2.leftMargin = com.byazt.okk.s.s(context, 12.0f);
        imageView.setLayoutParams(layoutParams2);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        int color = Color.parseColor("#959595");
        com.byazt.jjh.n nVar = new com.byazt.jjh.n(48);
        nVar.n(color);
        float fS = com.byazt.okk.s.s(context, 2.0f);
        nVar.n(fS);
        int color2 = Color.parseColor("#FFFFFF");
        com.byazt.jjh.n nVar2 = new com.byazt.jjh.n(48);
        nVar2.n(color2);
        nVar2.n(fS);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, nVar);
        stateListDrawable.addState(new int[0], nVar2);
        imageView.setImageDrawable(stateListDrawable);
        relativeLayout.addView(imageView);
        TextView textView = new TextView(context);
        textView.setId(2114387706);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
        textView.setGravity(16);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setSingleLine(true);
        textView.setTextSize(2, 17.0f);
        textView.setTextColor(-1);
        int i = com.byazt.lz.qg.n.q;
        textView.setPadding(i, 0, i, 0);
        relativeLayout.addView(textView);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(2114387797);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        linearLayout.setGravity(16);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(i, 0, i, 0);
        TextView textView2 = new TextView(context);
        textView2.setId(2114387846);
        textView2.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        textView2.setGravity(17);
        textView2.setMaxLines(1);
        textView2.setSingleLine(true);
        textView2.setTextSize(2, 12.0f);
        textView2.setTextColor(-1);
        linearLayout.addView(textView2);
        relativeLayout.addView(linearLayout);
        return relativeLayout;
    }

    private View x(Context context) {
        TTProgressBar tTProgressBar = new TTProgressBar(context, null, R.style.Widget.ProgressBar.Horizontal);
        tTProgressBar.setIndeterminate(false);
        tTProgressBar.setId(2114387653);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.byazt.okk.s.s(context, 1.5f));
        layoutParams.addRule(12);
        tTProgressBar.setLayoutParams(layoutParams);
        tTProgressBar.setBackground(null);
        tTProgressBar.setMax(100);
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
        com.byazt.cb.s.n(tTProgressBar, new LayerDrawable(new Drawable[]{gradientDrawable, clipDrawable, new ClipDrawable(gradientDrawable3, 3, 1)}));
        tTProgressBar.setVisibility(8);
        return tTProgressBar;
    }

    private View fs(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(2114387628);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.byazt.okk.s.s(context, 40.0f));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setVisibility(8);
        TextView textView = new TextView(context);
        textView.setId(2114387811);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(com.byazt.okk.s.s(context, 16.0f), 0, com.byazt.okk.s.s(context, 12.0f), 0);
        textView.setLayoutParams(layoutParams2);
        textView.setText("00:00");
        textView.setTextColor(-1);
        textView.setTextSize(2, 10.0f);
        linearLayout.addView(textView);
        SeekBar seekBar = new SeekBar(context);
        seekBar.setId(2114387872);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams3.gravity = 16;
        seekBar.setLayoutParams(layoutParams3);
        seekBar.setBackground(null);
        seekBar.setMax(100);
        if (Build.VERSION.SDK_INT >= 29) {
            seekBar.setMaxHeight(com.byazt.okk.s.s(context, 4.0f));
            seekBar.setMinHeight(com.byazt.okk.s.s(context, 4.0f));
        } else {
            layoutParams3.height = com.byazt.okk.s.s(context, 4.0f);
        }
        seekBar.setPadding(0, 0, 0, 0);
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
        seekBar.setProgressDrawable(new LayerDrawable(new Drawable[]{gradientDrawable, clipDrawable, new ClipDrawable(gradientDrawable3, 3, 1)}));
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        Paint paint = shapeDrawable.getPaint();
        paint.setColor(Color.parseColor("#FFFFFFFF"));
        int iS2 = com.byazt.okk.s.s(context, 15.0f);
        shapeDrawable.setIntrinsicWidth(iS2);
        shapeDrawable.setIntrinsicHeight(iS2);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(com.byazt.okk.s.s(context, 1.0f));
        paint.setColor(Color.parseColor("#1E000000"));
        seekBar.setThumb(shapeDrawable);
        seekBar.setThumbOffset(0);
        linearLayout.addView(seekBar);
        TextView textView2 = new TextView(context);
        textView2.setId(2114387668);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.setMargins(com.byazt.okk.s.s(context, 12.0f), 0, com.byazt.okk.s.s(context, 16.0f), 0);
        textView2.setLayoutParams(layoutParams4);
        textView2.setText("00:00");
        textView2.setTextColor(-1);
        textView2.setTextSize(2, 10.0f);
        linearLayout.addView(textView2);
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387661);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams5.setMargins(com.byazt.okk.s.s(context, 16.0f), 0, com.byazt.okk.s.s(context, 16.0f), 0);
        imageView.setLayoutParams(layoutParams5);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setVisibility(8);
        sz.n(context, "tt_enlarge_video", imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        linearLayout.addView(imageView);
        return linearLayout;
    }

    private View rv(Context context) {
        TextView textView = new TextView(context);
        textView.setId(2114387759);
        textView.setBackgroundColor(0);
        textView.setMinHeight(com.byazt.okk.s.s(context, 44.0f));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = com.byazt.okk.s.s(context, 12.0f);
        textView.setLayoutParams(layoutParams);
        textView.setCompoundDrawablesWithIntrinsicBounds(tj(context), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(tj(context), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setText("关闭");
        return textView;
    }

    private StateListDrawable tj(Context context) {
        int color = Color.parseColor("#959595");
        com.byazt.jjh.n nVar = new com.byazt.jjh.n(48);
        nVar.n(color);
        float fS = com.byazt.okk.s.s(context, 2.0f);
        nVar.n(fS);
        int color2 = Color.parseColor("#FFFFFF");
        com.byazt.jjh.n nVar2 = new com.byazt.jjh.n(48);
        nVar2.n(color2);
        nVar2.n(fS);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, nVar);
        stateListDrawable.addState(new int[0], nVar2);
        return stateListDrawable;
    }
}
