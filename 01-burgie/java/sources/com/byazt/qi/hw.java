package com.byazt.qi;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.byazt.aa.aj;
import com.byazt.ch.lb;
import com.byazt.ch.m;
import com.byazt.ch.nt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.group.constants.Constants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM, 13})
public class hw implements aj.pr {
    public com.byazt.ik.hn c;
    public Context hn;
    public lb hw;
    public int pr;
    public Handler uc = new aj(Looper.getMainLooper(), this);
    public nt x;

    public hw(Context context, nt ntVar, com.byazt.ik.hn hnVar) {
        this.hn = context;
        this.x = ntVar;
        this.c = hnVar;
    }

    public void pr(lb lbVar) {
        this.hw = lbVar;
    }

    public void pr() {
        nt ntVar = this.x;
        if (ntVar == null) {
            return;
        }
        try {
            int i = Integer.parseInt(com.byazt.tn.hw.pr(ntVar.hn().optString(Constants.DELAY_FIELD), this.c.vk()));
            this.pr = i;
            this.uc.sendEmptyMessageDelayed(1001, i);
        } catch (NumberFormatException e) {
        }
    }

    @Override // com.byazt.aa.aj.pr
    public void pr(Message message) {
        switch (message.what) {
            case 1001:
                JSONObject jSONObjectHn = this.x.hn();
                if (TextUtils.equals(jSONObjectHn.optString("type"), "onAnimation")) {
                    String strOptString = jSONObjectHn.optString("nodeId");
                    com.byazt.ik.hn hnVar = this.c;
                    com.byazt.ik.hn hnVarX = hnVar.hw(hnVar).x(strOptString);
                    new m(hnVarX.aj(), com.byazt.ch.pr.pr(jSONObjectHn.optJSONObject("animatorSet"), hnVarX)).pr();
                } else {
                    lb lbVar = this.hw;
                    if (lbVar != null) {
                        nt ntVar = this.x;
                        com.byazt.ik.hn hnVar2 = this.c;
                        lbVar.pr(ntVar, hnVar2, hnVar2);
                    }
                }
                this.uc.removeMessages(1001);
                break;
        }
    }
}
