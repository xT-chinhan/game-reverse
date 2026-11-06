package com.byazt.mr;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.byazt.gct.pk;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_POS, 101})
public class fs extends AlertDialog {
    public boolean fs;
    public String l;
    public JSONObject n;
    public x.n q;
    public JSONObject qg;
    public Context s;
    public com.byazt.ep.n w;
    public com.byazt.ozc.x x;

    public fs(String str, Context context, JSONObject jSONObject, JSONObject jSONObject2, com.byazt.ozc.x xVar, pk pkVar) {
        super(context);
        this.x = xVar;
        this.s = context;
        this.n = jSONObject;
        this.l = str;
        this.qg = jSONObject2;
        this.w = new com.byazt.ep.n(context, pkVar);
    }

    public String n() {
        return this.l;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (this.fs) {
            hide();
            dismiss();
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        com.byazt.cb.s.qg(this);
        qg();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        x.n nVar = this.q;
        if (nVar != null) {
            nVar.s(this);
        }
    }

    public void n(x.n nVar) {
        this.q = nVar;
        com.byazt.ep.n nVar2 = this.w;
        if (nVar2 != null) {
            nVar2.n(nVar);
        }
    }

    public void n(com.byazt.ozc.x xVar) {
        this.x = xVar;
    }

    private void qg() {
        if (this.n == null || this.qg == null || this.w == null) {
            return;
        }
        this.fs = false;
        final FrameLayout frameLayout = new FrameLayout(this.s);
        this.w.n(this.n, this.qg, new com.byazt.ozc.x() { // from class: com.byazt.mr.fs.1
            @Override // com.byazt.ozc.x
            public void n(int i, String str) {
                fs.this.fs = true;
                if (fs.this.x != null) {
                    FrameLayout frameLayout2 = frameLayout;
                    if (frameLayout2 != null) {
                        frameLayout2.removeAllViews();
                    }
                    fs.this.x.n(i, str);
                }
            }

            @Override // com.byazt.ozc.x
            public void n(com.byazt.ih.s<View> sVar) {
                fs.this.fs = false;
                if (fs.this.x != null) {
                    fs.this.x.n(null);
                }
                frameLayout.addView(sVar.rv(), new FrameLayout.LayoutParams(sVar.an(), sVar.ae()));
                fs.this.setContentView(frameLayout);
            }
        });
    }
}
