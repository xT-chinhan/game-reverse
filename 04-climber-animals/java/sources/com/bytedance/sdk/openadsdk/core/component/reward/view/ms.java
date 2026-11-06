package com.bytedance.sdk.openadsdk.core.component.reward.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.g;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    TextView ab;
    TextView ah;
    TextView c;
    private int ch;
    TTRatingBar d;
    private boolean hi;
    TextView ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    LinearLayout f2274ms;
    private lm ny;
    private final TTBaseVideoActivity x;
    TTRoundRectImageView xr;

    public ms(TTBaseVideoActivity tTBaseVideoActivity) {
        this.x = tTBaseVideoActivity;
    }

    public void ms(lm lmVar) {
        if (this.hi) {
            return;
        }
        this.hi = true;
        this.ny = lmVar;
        this.ch = lmVar.od();
        ka();
        xr();
        ms(d());
        c();
    }

    private void ka() {
        this.f2274ms = (LinearLayout) this.x.findViewById(2114387745);
        this.xr = (TTRoundRectImageView) this.x.findViewById(2114387779);
        this.ah = (TextView) this.x.findViewById(2114387651);
        this.d = (TTRatingBar) this.x.findViewById(2114387785);
        this.ka = (TextView) this.x.findViewById(2114387788);
        this.c = (TextView) this.x.findViewById(2114387870);
        this.ab = (TextView) this.x.findViewById(2114387715);
        TTRatingBar tTRatingBar = this.d;
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            this.d.setStarFillNum(4);
            this.d.setStarImageWidth(ul.ah(this.x, 16.0f));
            this.d.setStarImageHeight(ul.ah(this.x, 16.0f));
            this.d.setStarImagePadding(ul.ah(this.x, 4.0f));
            this.d.ms();
        }
    }

    public void ms(com.bytedance.sdk.openadsdk.core.xr.xr xrVar) {
        ul.ms(this.f2274ms, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.ms.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        }, "TTBaseVideoActivity#mLLEndCardBackup");
        TextView textView = this.c;
        if (textView != null) {
            textView.setOnClickListener(xrVar);
            this.c.setOnTouchListener(xrVar);
        }
    }

    public void ms() {
        ul.ms((View) this.f2274ms, 0);
    }

    private void c() {
        TTRoundRectImageView tTRoundRectImageView;
        if (this.ch == 1 && (tTRoundRectImageView = this.xr) != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tTRoundRectImageView.getLayoutParams();
            layoutParams.setMargins(0, ul.ah(this.x, 50.0f), 0, 0);
            this.xr.setLayoutParams(layoutParams);
        }
    }

    public void xr() {
        if (this.xr != null) {
            g gVarQd = this.ny.qd();
            if (gVarQd != null && !TextUtils.isEmpty(gVarQd.ms())) {
                com.bytedance.sdk.openadsdk.x.xr.ms(gVarQd).ms(this.xr);
            } else {
                t.ms((Context) this.x, "tt_ad_logo_small", (ImageView) this.xr);
            }
        }
        if (this.ah != null) {
            if (this.ny.zh() != null && !TextUtils.isEmpty(this.ny.zh().ah())) {
                this.ah.setText(this.ny.zh().ah());
            } else {
                this.ah.setText(this.ny.eh());
            }
        }
        if (this.ka != null) {
            int iC = this.ny.zh() != null ? this.ny.zh().c() : 6870;
            this.ka.setText(String.format(t.ms(this.x, "tt_comment_num_backup"), iC > 10000 ? (iC / 10000) + "万" : String.valueOf(iC)));
        }
        TextView textView = this.ab;
        if (textView != null) {
            ul.ms(textView, this.ny);
        }
    }

    public void ms(String str) {
        TextView textView;
        if (TextUtils.isEmpty(str) || (textView = this.c) == null) {
            return;
        }
        textView.setText(str);
    }

    public void ah() {
        ul.ms((View) this.f2274ms, 8);
    }

    protected String d() {
        lm lmVar = this.ny;
        if (lmVar == null) {
            return "立即下载";
        }
        if (TextUtils.isEmpty(lmVar.bn())) {
            return this.ny.jr() != 4 ? "查看详情" : "立即下载";
        }
        return this.ny.bn();
    }
}
