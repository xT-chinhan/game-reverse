package com.byazt.nc;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.byazt.hg.of;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 52, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo extends AlertDialog {
    public String c;
    public com.byazt.sa.fw fw;
    public Context hn;
    public JSONObject hw;
    public JSONObject pr;
    public com.byazt.ea.pr uc;
    public fw.pr x;
    public boolean zo;

    public zo(String str, Context context, JSONObject jSONObject, JSONObject jSONObject2, com.byazt.sa.fw fwVar, of ofVar) {
        super(context);
        this.fw = fwVar;
        this.hn = context;
        this.pr = jSONObject;
        this.c = str;
        this.hw = jSONObject2;
        this.uc = new com.byazt.ea.pr(context, ofVar);
    }

    public String pr() {
        return this.c;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (this.zo) {
            hide();
            dismiss();
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        com.byazt.sdv.uc.hw(this);
        hw();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        fw.pr prVar = this.x;
        if (prVar != null) {
            prVar.hn(this);
        }
    }

    public void pr(fw.pr prVar) {
        this.x = prVar;
        com.byazt.ea.pr prVar2 = this.uc;
        if (prVar2 != null) {
            prVar2.pr(prVar);
        }
    }

    public void pr(com.byazt.sa.fw fwVar) {
        this.fw = fwVar;
    }

    private void hw() {
        if (this.pr == null || this.hw == null || this.uc == null) {
            return;
        }
        this.zo = false;
        final FrameLayout frameLayout = new FrameLayout(this.hn);
        this.uc.pr(this.pr, this.hw, new com.byazt.sa.fw() { // from class: com.byazt.nc.zo.1
            @Override // com.byazt.sa.fw
            public void pr(int i, String str) {
                zo.this.zo = true;
                if (zo.this.fw != null) {
                    FrameLayout frameLayout2 = frameLayout;
                    if (frameLayout2 != null) {
                        frameLayout2.removeAllViews();
                    }
                    zo.this.fw.pr(i, str);
                }
            }

            @Override // com.byazt.sa.fw
            public void pr(com.byazt.ik.hn<View> hnVar) {
                zo.this.zo = false;
                if (zo.this.fw != null) {
                    zo.this.fw.pr(null);
                }
                frameLayout.addView(hnVar.aj(), new FrameLayout.LayoutParams(hnVar.e(), hnVar.s()));
                zo.this.setContentView(frameLayout);
            }
        });
    }
}
