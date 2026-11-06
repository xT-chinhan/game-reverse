package com.byazt.pfl;

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
import com.byazt.mr.uc;
import com.byazt.pi.TTDislikeLayout;
import com.byazt.pi.TTDislikeScrollListView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVPH_DNS_PARSE_TIMEOUT, 121})
public class x extends Dialog {
    public TextView c;
    public final boolean fw;
    public final com.byazt.dw.hw hn;
    public TTDislikeLayout hw;
    public com.byazt.vg.hn pr;
    public pr uc;
    public boolean x;

    public x(Context context, com.byazt.dw.hw hwVar, pr prVar) {
        super(context);
        this.x = false;
        getWindow().addFlags(1024);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.hn = hwVar;
        this.fw = hwVar != null ? hwVar.hw() : false;
        this.uc = prVar;
    }

    public void pr(com.byazt.vg.hn hnVar) {
        this.pr = hnVar;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        setContentView(com.byazt.sdv.hn.pr(getContext(), this.fw), pr());
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        hw();
        hn();
    }

    public ViewGroup.LayoutParams pr() {
        return new ViewGroup.LayoutParams(com.byazt.rc.pr.hw().pr(getContext(), 345.0f), -2);
    }

    private void hw() {
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setDimAmount(0.34f);
        }
    }

    private void hn() {
        TTDislikeLayout tTDislikeLayout = (TTDislikeLayout) findViewById(2047279103);
        this.hw = tTDislikeLayout;
        pr(tTDislikeLayout);
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
            this.x = false;
            com.byazt.vg.hn hnVar = this.pr;
            if (hnVar != null) {
                hnVar.hw();
            }
        } catch (Exception e) {
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        com.byazt.vg.hn hnVar = this.pr;
        if (hnVar != null && !this.x) {
            hnVar.hn();
        }
    }

    public void pr(com.byazt.dw.hw hwVar) {
        TTDislikeLayout tTDislikeLayout;
        if (hwVar == null || (tTDislikeLayout = this.hw) == null) {
            return;
        }
        TTDislikeScrollListView tTDislikeScrollListView = (TTDislikeScrollListView) tTDislikeLayout.findViewById(2047279097);
        c cVar = (c) tTDislikeScrollListView.getAdapter();
        if (cVar != null) {
            tTDislikeScrollListView.setDislikeController(new com.byazt.rc.hw(hwVar));
            cVar.pr(hwVar.pr());
        }
    }

    private void pr(View view) {
        if (view == null) {
            return;
        }
        if (!this.fw) {
            TextView textView = (TextView) view.findViewById(2047279095);
            this.c = textView;
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.pfl.x.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (x.this.pr != null) {
                        x.this.pr.pr();
                    }
                    x.this.dismiss();
                }
            });
        }
        TTDislikeScrollListView tTDislikeScrollListView = (TTDislikeScrollListView) view.findViewById(2047279097);
        tTDislikeScrollListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.byazt.pfl.x.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                try {
                    uc ucVar = x.this.hn.pr().get(i);
                    if (!x.this.fw || !"99:1".equals(ucVar.pr())) {
                        if (x.this.pr != null) {
                            x.this.pr.pr(i, ucVar);
                            x.this.x = true;
                        }
                        x.this.dismiss();
                    }
                } catch (Throwable th) {
                }
            }
        });
        com.byazt.dw.hw hwVar = this.hn;
        c cVar = new c(getContext(), hwVar == null ? new ArrayList<>(0) : hwVar.pr(), this.fw, this.uc);
        cVar.pr(new c.pr() { // from class: com.byazt.pfl.x.3
            @Override // com.byazt.pfl.c.pr
            public void pr(int i, uc ucVar) {
                if (x.this.pr != null) {
                    x.this.pr.pr(i, ucVar);
                    x.this.x = true;
                }
                x.this.dismiss();
                com.byazt.rc.pr.pr().pr(x.this.hn, ucVar);
            }
        });
        tTDislikeScrollListView.setAdapter((ListAdapter) cVar);
        com.byazt.dw.hw hwVar2 = this.hn;
        if (hwVar2 != null) {
            tTDislikeScrollListView.setDislikeController(new com.byazt.rc.hw(hwVar2));
        }
    }

    public void pr(String str) {
        TextView textView = this.c;
        if (textView != null) {
            textView.setText(str);
        }
    }
}
