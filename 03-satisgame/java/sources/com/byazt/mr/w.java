package com.byazt.mr;

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
import com.byazt.kfh.TTProgressBar;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_POS, 13})
public class w extends Dialog {
    public View a;
    public String cd;
    public ViewGroup cp;
    public String cy;
    public Context d;
    public Button fs;
    public int hd;
    public String k;
    public TextView l;
    public TTProgressBar n;
    public String oa;
    public ImageView q;
    public n qg;
    public Button rv;
    public View.OnClickListener s;
    public String sz;
    public View tj;
    public boolean um;
    public TextView w;
    public Button x;

    public interface n {
        void n();

        void qg();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }

    public w(Context context) {
        super(context);
        this.hd = -1;
        this.um = false;
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.d = context;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCanceledOnTouchOutside(false);
        View viewYw = this.a;
        if (viewYw == null) {
            viewYw = com.byazt.cb.qg.yw(this.d);
        }
        setContentView(viewYw);
        l();
        q();
        s();
    }

    private void s() {
        com.byazt.okk.s.n(this.fs, new View.OnClickListener() { // from class: com.byazt.mr.w.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (w.this.qg != null) {
                    w.this.qg.n();
                }
            }
        }, "positiveBn");
        com.byazt.okk.s.n(this.x, new View.OnClickListener() { // from class: com.byazt.mr.w.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (w.this.qg != null) {
                    w.this.qg.qg();
                }
            }
        }, "negtiveBn");
        com.byazt.okk.s.n(this.rv, new View.OnClickListener() { // from class: com.byazt.mr.w.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (w.this.s != null) {
                    w.this.s.onClick(view);
                }
            }
        }, "dialog_change_btn");
    }

    private void q() {
        Button button;
        if (this.l != null) {
            if (!TextUtils.isEmpty(this.sz)) {
                this.l.setText(this.sz);
                this.l.setVisibility(0);
            } else {
                this.l.setVisibility(8);
            }
        }
        if (this.w != null && !TextUtils.isEmpty(this.oa)) {
            this.w.setText(this.oa);
        }
        if (this.fs != null) {
            if (!TextUtils.isEmpty(this.k)) {
                this.fs.setText(this.k);
            } else {
                this.fs.setText("确定");
            }
            int i = this.hd;
            if (i != -1) {
                this.fs.setBackgroundColor(i);
            }
        }
        if (this.x != null) {
            if (!TextUtils.isEmpty(this.cy)) {
                this.x.setText(this.cy);
            } else {
                this.x.setText("取消");
            }
        }
        ImageView imageView = this.q;
        if (imageView != null) {
            String str = this.cd;
            if (str != null) {
                com.byazt.tk.sz.n(this.d, str, imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
                this.q.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
        View view = this.tj;
        if (view == null || (button = this.x) == null) {
            return;
        }
        if (this.um) {
            view.setVisibility(8);
            this.x.setVisibility(8);
            return;
        }
        button.setVisibility(0);
        View view2 = this.tj;
        if (view2 != null) {
            view2.setVisibility(0);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
            q();
        } catch (Exception unused) {
        }
    }

    private void l() {
        this.x = (Button) findViewById(2114387829);
        this.fs = (Button) findViewById(2114387914);
        this.l = (TextView) findViewById(2114387802);
        this.w = (TextView) findViewById(2114387857);
        this.q = (ImageView) findViewById(2114387832);
        this.tj = findViewById(2114387775);
        this.cp = (ViewGroup) findViewById(2114387849);
        this.rv = (Button) findViewById(2114387749);
    }

    public w n(n nVar) {
        this.qg = nVar;
        return this;
    }

    public w n(View.OnClickListener onClickListener) {
        this.s = onClickListener;
        return this;
    }

    public w n(String str) {
        this.oa = str;
        return this;
    }

    public w qg(String str) {
        this.sz = str;
        return this;
    }

    public w s(String str) {
        this.k = str;
        return this;
    }

    public w q(String str) {
        this.cy = str;
        return this;
    }

    public w n(int i) {
        this.hd = i;
        return this;
    }

    public w l(String str) {
        this.cd = str;
        return this;
    }

    public w n(View view) {
        this.a = view;
        return this;
    }

    public void n() {
        if (this.cp == null) {
            return;
        }
        if (this.n == null) {
            try {
                this.n = new TTProgressBar(this.d);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA, MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
                layoutParams.gravity = 17;
                this.n.setLayoutParams(layoutParams);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(Color.parseColor("#77000000"));
                gradientDrawable.setCornerRadius(com.byazt.okk.s.s(this.d, 2.0f));
                this.n.setBackground(gradientDrawable);
                int iS = com.byazt.okk.s.s(this.d, 10.0f);
                this.n.setPadding(iS, iS, iS, iS);
                com.byazt.tk.sz.n(this.d, "tt_normalscreen_loading", new com.byazt.qyj.n<Bitmap>() { // from class: com.byazt.mr.w.4
                    @Override // com.byazt.qyj.n
                    public void n(Bitmap bitmap) {
                        w.this.n.setIndeterminateDrawable(TTProgressBar.n(w.this.d, new BitmapDrawable(w.this.d.getResources(), bitmap), 0, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL, 0.5f, 0.5f));
                    }
                }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
                this.cp.addView(this.n);
            } catch (Exception unused) {
            }
        }
        this.cp.setVisibility(0);
    }

    public void qg() {
        ViewGroup viewGroup = this.cp;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }
}
