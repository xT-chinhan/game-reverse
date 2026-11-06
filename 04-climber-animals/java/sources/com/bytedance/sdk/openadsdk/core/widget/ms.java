package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.re;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends AlertDialog {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Context f3726ms;
    private String xr;

    public ms(Context context, String str) {
        super(context, t.ab(context, "tt_custom_dialog"));
        this.f3726ms = context == null ? re.getContext() : context;
        this.xr = str;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.bytedance.sdk.openadsdk.res.ka.az(getContext()));
        ms();
    }

    private void ms() {
        ((TextView) findViewById(2114387705)).setText(this.xr);
        findViewById(2114387761).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.ms.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ms.this.dismiss();
            }
        });
    }
}
