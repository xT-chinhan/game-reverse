package com.mcto.sspsdk.internal;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mcto.sspsdk.R;
import com.mcto.sspsdk.component.button.DownloadButtonView;
import com.mcto.sspsdk.component.imageview.QYNiceImageView;

/* JADX INFO: loaded from: classes2.dex */
public final class bb extends LinearLayout implements View.OnTouchListener {
    public final QYNiceImageView a;
    public final TextView b;
    public DownloadButtonView c;
    public final LinearLayout d;
    public e2 e;

    public bb(Context context) {
        super(context);
        View.inflate(context, R.layout.qy_layout_roll_ad_complete_overlay, this);
        this.a = (QYNiceImageView) findViewById(R.id.qy_roll_ad_player_complete_overlay_icon);
        this.b = (TextView) findViewById(R.id.qy_roll_ad_player_complete_overlay_name);
        this.d = (LinearLayout) findViewById(R.id.qy_roll_ad_player_complete_overlay_btn);
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.e != null && motionEvent.getAction() == 0) {
            z3 z3Var = view.equals(this.d) ? z3.LAYER_BUTTON : z3.LAYER_GRAPHIC;
            a4 a4Var = new a4();
            a4Var.b = z3Var;
            a4Var.a = view;
            a4Var.e = gj.a(view);
            b4 b4Var = new b4(a4Var.a(motionEvent.getRawX(), motionEvent.getRawY()));
            DownloadButtonView downloadButtonView = this.c;
            if (downloadButtonView != null) {
                b4Var.a(downloadButtonView.c());
                b4Var.k = this.c.a();
            }
            this.e.a(b4Var);
        }
        return true;
    }
}
