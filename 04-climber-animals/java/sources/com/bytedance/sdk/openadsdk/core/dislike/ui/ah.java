package com.bytedance.sdk.openadsdk.core.dislike.ui;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.ao.xr.xr.c;
import com.bytedance.sdk.openadsdk.widget.TTDislikeLayout;
import com.bytedance.sdk.openadsdk.widget.TTDislikeScrollListView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends Dialog {
    private final com.bytedance.sdk.openadsdk.core.dislike.ah.xr ah;
    private boolean d;
    private TextView ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.dislike.xr.ah f2477ms;
    private TTDislikeLayout xr;

    public ah(Context context, com.bytedance.sdk.openadsdk.core.dislike.ah.xr xrVar) {
        super(context);
        this.d = false;
        getWindow().addFlags(1024);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.ah = xrVar;
    }

    public void ms(com.bytedance.sdk.openadsdk.core.dislike.xr.ah ahVar) {
        this.f2477ms = ahVar;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        setContentView(com.bytedance.sdk.openadsdk.res.d.ms(getContext()), ms());
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        xr();
        ah();
    }

    public ViewGroup.LayoutParams ms() {
        return new ViewGroup.LayoutParams(com.bytedance.sdk.openadsdk.core.dislike.ms.ms.xr().ms(getContext(), 345.0f), -2);
    }

    private void xr() {
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setDimAmount(0.34f);
        }
    }

    private void ah() {
        TTDislikeLayout tTDislikeLayout = (TTDislikeLayout) findViewById(2047279103);
        this.xr = tTDislikeLayout;
        ms(tTDislikeLayout);
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
            this.d = false;
            com.bytedance.sdk.openadsdk.core.dislike.xr.ah ahVar = this.f2477ms;
            if (ahVar != null) {
                ahVar.xr();
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        com.bytedance.sdk.openadsdk.core.dislike.xr.ah ahVar = this.f2477ms;
        if (ahVar == null || this.d) {
            return;
        }
        ahVar.ah();
    }

    public void ms(com.bytedance.sdk.openadsdk.core.dislike.ah.xr xrVar) {
        TTDislikeLayout tTDislikeLayout;
        if (xrVar == null || (tTDislikeLayout = this.xr) == null) {
            return;
        }
        TTDislikeScrollListView tTDislikeScrollListView = (TTDislikeScrollListView) tTDislikeLayout.findViewById(2047279097);
        d dVar = (d) tTDislikeScrollListView.getAdapter();
        if (dVar != null) {
            tTDislikeScrollListView.setDislikeController(new com.bytedance.sdk.openadsdk.core.dislike.ms.xr(xrVar));
            dVar.ms(xrVar.ms());
        }
    }

    private void ms(View view) {
        if (view == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(2047279095);
        this.ka = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.ah.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ah.this.f2477ms != null) {
                    ah.this.f2477ms.ms();
                }
                ah.this.dismiss();
            }
        });
        TTDislikeScrollListView tTDislikeScrollListView = (TTDislikeScrollListView) view.findViewById(2047279097);
        tTDislikeScrollListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.ah.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                try {
                    if (ah.this.f2477ms != null) {
                        ah.this.f2477ms.ms(i, ah.this.ah.ms().get(i));
                        ah.this.d = true;
                    }
                    ah.this.dismiss();
                } catch (Throwable unused) {
                }
            }
        });
        com.bytedance.sdk.openadsdk.core.dislike.ah.xr xrVar = this.ah;
        d dVar = new d(getContext(), xrVar == null ? new ArrayList<>(0) : xrVar.ms());
        dVar.ms(new d.ms() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.ah.3
            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.d.ms
            public void ms(int i, c cVar) {
                if (ah.this.f2477ms != null) {
                    ah.this.f2477ms.ms(i, cVar);
                    ah.this.d = true;
                }
                ah.this.dismiss();
                com.bytedance.sdk.openadsdk.core.dislike.ms.ms.ms().ms(ah.this.ah, cVar);
            }
        });
        tTDislikeScrollListView.setAdapter((ListAdapter) dVar);
        if (this.ah != null) {
            tTDislikeScrollListView.setDislikeController(new com.bytedance.sdk.openadsdk.core.dislike.ms.xr(this.ah));
        }
    }

    public void ms(String str) {
        TextView textView = this.ka;
        if (textView != null) {
            textView.setText(str);
        }
    }
}
