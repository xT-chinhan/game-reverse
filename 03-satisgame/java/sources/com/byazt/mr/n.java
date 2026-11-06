package com.byazt.mr;

import android.R;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_POS, 19})
public class n extends AlertDialog {
    public Context n;
    public String qg;

    public n(Context context, String str) {
        super(context, R.style.Theme.Dialog);
        com.byazt.cb.s.n(this);
        this.n = context == null ? com.byazt.nf.rv.getContext() : context;
        this.qg = str;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.byazt.cb.qg.df(getContext()));
        n();
    }

    private void n() {
        ((TextView) findViewById(2114387699)).setText(this.qg);
        findViewById(2114387755).setOnClickListener(new View.OnClickListener() { // from class: com.byazt.mr.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                n.this.dismiss();
            }
        });
    }
}
