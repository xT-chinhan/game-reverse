package com.byazt.nc;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.byazt.fj.TTProgressBar;
import com.byazt.wt.er;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 52, 5})
public class uc extends Dialog {
    public View a;
    public Button aj;
    public TextView c;
    public Button fw;
    public String g;
    public View.OnClickListener hn;
    public String ho;
    public pr hw;
    public Context k;
    public String lb;
    public String m;
    public String nt;
    public TTProgressBar pr;
    public boolean qa;
    public TextView uc;
    public View vk;
    public ViewGroup w;
    public ImageView x;
    public int yb;
    public Button zo;

    public interface pr {
        void hw();

        void pr();
    }

    public uc(Context context) {
        super(context);
        this.yb = -1;
        this.qa = false;
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.k = context;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCanceledOnTouchOutside(false);
        View viewLv = this.a;
        if (viewLv == null) {
            viewLv = com.byazt.sdv.c.lv(this.k);
        }
        setContentView(viewLv);
        c();
        x();
        hn();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }

    private void hn() {
        er.pr(this.zo, new View.OnClickListener() { // from class: com.byazt.nc.uc.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (uc.this.hw != null) {
                    uc.this.hw.pr();
                }
            }
        }, "positiveBn");
        er.pr(this.fw, new View.OnClickListener() { // from class: com.byazt.nc.uc.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (uc.this.hw != null) {
                    uc.this.hw.hw();
                }
            }
        }, "negtiveBn");
        er.pr(this.aj, new View.OnClickListener() { // from class: com.byazt.nc.uc.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (uc.this.hn != null) {
                    uc.this.hn.onClick(view);
                }
            }
        }, "dialog_change_btn");
    }

    private void x() {
        Button button;
        if (this.c != null) {
            if (!TextUtils.isEmpty(this.g)) {
                this.c.setText(this.g);
                this.c.setVisibility(0);
            } else {
                this.c.setVisibility(8);
            }
        }
        if (this.uc != null && !TextUtils.isEmpty(this.m)) {
            this.uc.setText(this.m);
        }
        if (this.zo != null) {
            if (!TextUtils.isEmpty(this.ho)) {
                this.zo.setText(this.ho);
            } else {
                this.zo.setText("确定");
            }
            int i = this.yb;
            if (i != -1) {
                this.zo.setBackgroundColor(i);
            }
        }
        if (this.fw != null) {
            if (!TextUtils.isEmpty(this.nt)) {
                this.fw.setText(this.nt);
            } else {
                this.fw.setText("取消");
            }
        }
        ImageView imageView = this.x;
        if (imageView != null) {
            String str = this.lb;
            if (str != null) {
                com.byazt.ca.g.pr(this.k, str, imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
                this.x.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
        View view = this.vk;
        if (view != null && (button = this.fw) != null) {
            if (this.qa) {
                view.setVisibility(8);
                this.fw.setVisibility(8);
                return;
            }
            button.setVisibility(0);
            View view2 = this.vk;
            if (view2 != null) {
                view2.setVisibility(0);
            }
        }
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
            x();
        } catch (Exception e) {
        }
    }

    private void c() {
        this.fw = (Button) findViewById(2114387829);
        this.zo = (Button) findViewById(2114387914);
        this.c = (TextView) findViewById(2114387802);
        this.uc = (TextView) findViewById(2114387857);
        this.x = (ImageView) findViewById(2114387832);
        this.vk = findViewById(2114387775);
        this.w = (ViewGroup) findViewById(2114387849);
        this.aj = (Button) findViewById(2114387749);
    }

    public uc pr(pr prVar) {
        this.hw = prVar;
        return this;
    }

    public uc pr(View.OnClickListener onClickListener) {
        this.hn = onClickListener;
        return this;
    }

    public uc pr(String str) {
        this.m = str;
        return this;
    }

    public uc hw(String str) {
        this.g = str;
        return this;
    }

    public uc hn(String str) {
        this.ho = str;
        return this;
    }

    public uc x(String str) {
        this.nt = str;
        return this;
    }

    public uc pr(int i) {
        this.yb = i;
        return this;
    }

    public uc c(String str) {
        this.lb = str;
        return this;
    }

    public uc pr(View view) {
        this.a = view;
        return this;
    }

    public void pr() {
        if (this.w == null) {
            return;
        }
        if (this.pr == null) {
            try {
                this.pr = new TTProgressBar(this.k);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA, MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
                layoutParams.gravity = 17;
                this.pr.setLayoutParams(layoutParams);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(Color.parseColor("#77000000"));
                gradientDrawable.setCornerRadius(er.hn(this.k, 2.0f));
                this.pr.setBackground(gradientDrawable);
                int iHn = er.hn(this.k, 10.0f);
                this.pr.setPadding(iHn, iHn, iHn, iHn);
                com.byazt.ca.g.pr(this.k, "tt_normalscreen_loading", new com.byazt.ezf.pr<Bitmap>() { // from class: com.byazt.nc.uc.4
                    @Override // com.byazt.ezf.pr
                    public void pr(Bitmap bitmap) {
                        uc.this.pr.setIndeterminateDrawable(TTProgressBar.pr(uc.this.k, new BitmapDrawable(uc.this.k.getResources(), bitmap), 0, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL, 0.5f, 0.5f));
                    }
                }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
                this.w.addView(this.pr);
            } catch (Exception e) {
            }
        }
        this.w.setVisibility(0);
    }

    public void hw() {
        ViewGroup viewGroup = this.w;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }
}
