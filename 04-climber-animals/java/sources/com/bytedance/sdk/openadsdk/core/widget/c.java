package com.bytedance.sdk.openadsdk.core.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;

/* JADX INFO: loaded from: classes2.dex */
public class c extends Dialog {
    private Button ab;
    public View.OnClickListener ah;
    private String ao;
    private TextView c;
    private View ch;
    private ImageView d;
    private int h;
    private ViewGroup hi;
    private TextView ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    TTProgressBar f3706ms;
    private Button ny;
    private Drawable qv;
    private Context sl;
    private View t;
    private String u;
    private String ub;
    private Button x;
    public ms xr;
    private boolean y;
    private String zb;

    public interface ms {
        void ms();

        void xr();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }

    public c(Context context) {
        super(context);
        this.h = -1;
        this.y = false;
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.sl = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCanceledOnTouchOutside(false);
        View viewS = this.t;
        if (viewS == null) {
            viewS = com.bytedance.sdk.openadsdk.res.ka.s(this.sl);
        }
        setContentView(viewS);
        ka();
        d();
        ah();
    }

    private void ah() {
        ul.ms(this.x, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.xr != null) {
                    c.this.xr.ms();
                }
            }
        }, "positiveBn");
        ul.ms(this.ab, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.xr != null) {
                    c.this.xr.xr();
                }
            }
        }, "negtiveBn");
        ul.ms(this.ny, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.ah != null) {
                    c.this.ah.onClick(view);
                }
            }
        }, "dialog_change_btn");
    }

    private void d() {
        Button button;
        if (this.ka != null) {
            if (!TextUtils.isEmpty(this.u)) {
                this.ka.setText(this.u);
                this.ka.setVisibility(0);
            } else {
                this.ka.setVisibility(8);
            }
        }
        if (this.c != null && !TextUtils.isEmpty(this.zb)) {
            this.c.setText(this.zb);
        }
        if (this.x != null) {
            if (!TextUtils.isEmpty(this.ub)) {
                this.x.setText(this.ub);
            } else {
                this.x.setText("确定");
            }
            int i = this.h;
            if (i != -1) {
                this.x.setBackgroundColor(i);
            }
        }
        if (this.ab != null) {
            if (!TextUtils.isEmpty(this.ao)) {
                this.ab.setText(this.ao);
            } else {
                this.ab.setText("取消");
            }
        }
        ImageView imageView = this.d;
        if (imageView != null) {
            Drawable drawable = this.qv;
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
                this.d.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
        View view = this.ch;
        if (view == null || (button = this.ab) == null) {
            return;
        }
        if (this.y) {
            view.setVisibility(8);
            this.ab.setVisibility(8);
            return;
        }
        button.setVisibility(0);
        View view2 = this.ch;
        if (view2 != null) {
            view2.setVisibility(0);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
            d();
        } catch (Exception unused) {
        }
    }

    private void ka() {
        this.ab = (Button) findViewById(2114387835);
        this.x = (Button) findViewById(2114387920);
        this.ka = (TextView) findViewById(2114387808);
        this.c = (TextView) findViewById(2114387863);
        this.d = (ImageView) findViewById(2114387838);
        this.ch = findViewById(2114387781);
        this.hi = (ViewGroup) findViewById(2114387855);
        this.ny = (Button) findViewById(2114387755);
    }

    public c ms(ms msVar) {
        this.xr = msVar;
        return this;
    }

    public c ms(View.OnClickListener onClickListener) {
        this.ah = onClickListener;
        return this;
    }

    public c ms(String str) {
        this.zb = str;
        return this;
    }

    public c xr(String str) {
        this.u = str;
        return this;
    }

    public c ah(String str) {
        this.ub = str;
        return this;
    }

    public c d(String str) {
        this.ao = str;
        return this;
    }

    public c ms(int i) {
        this.h = i;
        return this;
    }

    public c ms(Drawable drawable) {
        this.qv = drawable;
        return this;
    }

    public c ms(View view) {
        this.t = view;
        return this;
    }

    public void ms() {
        if (this.hi == null) {
            return;
        }
        if (this.f3706ms == null) {
            try {
                this.f3706ms = new TTProgressBar(this.sl);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA, MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA);
                layoutParams.gravity = 17;
                this.f3706ms.setLayoutParams(layoutParams);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(Color.parseColor("#77000000"));
                gradientDrawable.setCornerRadius(ul.ah(this.sl, 2.0f));
                this.f3706ms.setBackground(gradientDrawable);
                int iAh = ul.ah(this.sl, 10.0f);
                this.f3706ms.setPadding(iAh, iAh, iAh, iAh);
                this.f3706ms.setIndeterminateDrawable(t.ah(this.sl, "tt_video_loading_progress_bar"));
                this.hi.addView(this.f3706ms);
            } catch (Exception unused) {
            }
        }
        this.hi.setVisibility(0);
    }

    public void xr() {
        ViewGroup viewGroup = this.hi;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }
}
