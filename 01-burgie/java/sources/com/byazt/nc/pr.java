package com.byazt.nc;

import android.R;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.byazt.sd.a;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 52, 37})
public class pr extends AlertDialog {
    public String hw;
    public Context pr;

    public pr(Context context, String str) {
        super(context, R.style.Theme.Dialog);
        com.byazt.sdv.uc.pr(this);
        this.pr = context == null ? a.getContext() : context;
        this.hw = str;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.byazt.sdv.c.v(getContext()));
        pr();
    }

    private void pr() {
        ((TextView) findViewById(2114387699)).setText(this.hw);
        findViewById(2114387755).setOnClickListener(new View.OnClickListener() { // from class: com.byazt.nc.pr.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                pr.this.dismiss();
            }
        });
    }
}
