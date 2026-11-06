package com.byazt.wg;

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
import com.byazt.fvm.w;
import com.byazt.ndr.TTDislikeLayout;
import com.byazt.ndr.TTDislikeScrollListView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 204, 5})
public class q extends Dialog {
    public TextView l;
    public com.byazt.ae.s n;
    public boolean q;
    public TTDislikeLayout qg;
    public final com.byazt.oj.qg s;
    public n w;
    public final boolean x;

    public q(Context context, com.byazt.oj.qg qgVar, n nVar) {
        super(context);
        this.q = false;
        getWindow().addFlags(1024);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.s = qgVar;
        this.x = qgVar != null ? qgVar.qg() : false;
        this.w = nVar;
    }

    public void n(com.byazt.ae.s sVar) {
        this.n = sVar;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        setContentView(com.byazt.xn.s.n(getContext(), this.x), n());
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        qg();
        s();
    }

    public ViewGroup.LayoutParams n() {
        return new ViewGroup.LayoutParams(com.byazt.nnl.n.qg().n(getContext(), 345.0f), -2);
    }

    private void qg() {
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setDimAmount(0.34f);
        }
    }

    private void s() {
        TTDislikeLayout tTDislikeLayout = (TTDislikeLayout) findViewById(2047279103);
        this.qg = tTDislikeLayout;
        n(tTDislikeLayout);
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
            this.q = false;
            com.byazt.ae.s sVar = this.n;
            if (sVar != null) {
                sVar.qg();
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        com.byazt.ae.s sVar = this.n;
        if (sVar == null || this.q) {
            return;
        }
        sVar.s();
    }

    public void n(com.byazt.oj.qg qgVar) {
        TTDislikeLayout tTDislikeLayout;
        if (qgVar == null || (tTDislikeLayout = this.qg) == null) {
            return;
        }
        TTDislikeScrollListView tTDislikeScrollListView = (TTDislikeScrollListView) tTDislikeLayout.findViewById(2047279097);
        l lVar = (l) tTDislikeScrollListView.getAdapter();
        if (lVar != null) {
            tTDislikeScrollListView.setDislikeController(new com.byazt.nnl.qg(qgVar));
            lVar.n(qgVar.n());
        }
    }

    private void n(View view) {
        if (view == null) {
            return;
        }
        if (!this.x) {
            TextView textView = (TextView) view.findViewById(2047279095);
            this.l = textView;
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.wg.q.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (q.this.n != null) {
                        q.this.n.n();
                    }
                    q.this.dismiss();
                }
            });
        }
        TTDislikeScrollListView tTDislikeScrollListView = (TTDislikeScrollListView) view.findViewById(2047279097);
        tTDislikeScrollListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.byazt.wg.q.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                try {
                    w wVar = q.this.s.n().get(i);
                    if (q.this.x && "99:1".equals(wVar.n())) {
                        return;
                    }
                    if (q.this.n != null) {
                        q.this.n.n(i, wVar);
                        q.this.q = true;
                    }
                    q.this.dismiss();
                } catch (Throwable unused) {
                }
            }
        });
        com.byazt.oj.qg qgVar = this.s;
        l lVar = new l(getContext(), qgVar == null ? new ArrayList<>(0) : qgVar.n(), this.x, this.w);
        lVar.n(new l.n() { // from class: com.byazt.wg.q.3
            @Override // com.byazt.wg.l.n
            public void n(int i, w wVar) {
                if (q.this.n != null) {
                    q.this.n.n(i, wVar);
                    q.this.q = true;
                }
                q.this.dismiss();
                com.byazt.nnl.n.n().n(q.this.s, wVar);
            }
        });
        tTDislikeScrollListView.setAdapter((ListAdapter) lVar);
        if (this.s != null) {
            tTDislikeScrollListView.setDislikeController(new com.byazt.nnl.qg(this.s));
        }
    }

    public void n(String str) {
        TextView textView = this.l;
        if (textView != null) {
            textView.setText(str);
        }
    }
}
