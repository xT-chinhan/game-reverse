package com.byazt.qi;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.byazt.aa.aj;
import com.byazt.ch.lb;
import com.byazt.ch.nt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.an;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM, 5})
public class uc implements aj.pr {
    public nt c;
    public Handler fw = new aj(Looper.getMainLooper(), this);
    public lb hn;
    public int hw;
    public boolean pr;
    public com.byazt.ik.hn uc;
    public Context x;

    public uc(Context context, nt ntVar, com.byazt.ik.hn hnVar) {
        this.x = context;
        this.c = ntVar;
        this.uc = hnVar;
    }

    public void pr(lb lbVar) {
        this.hn = lbVar;
    }

    public void pr() {
        nt ntVar = this.c;
        if (ntVar == null) {
            return;
        }
        JSONObject jSONObjectHn = ntVar.hn();
        try {
            this.hw = Integer.parseInt(com.byazt.tn.hw.pr(jSONObjectHn.optString(an.aU, "8000"), this.uc.vk()));
            this.pr = jSONObjectHn.optBoolean("repeat");
            this.fw.sendEmptyMessageDelayed(1001, this.hw);
        } catch (NumberFormatException e) {
        }
    }

    @Override // com.byazt.aa.aj.pr
    public void pr(Message message) {
        switch (message.what) {
            case 1001:
                lb lbVar = this.hn;
                if (lbVar != null) {
                    nt ntVar = this.c;
                    com.byazt.ik.hn hnVar = this.uc;
                    lbVar.pr(ntVar, hnVar, hnVar);
                }
                if (this.pr) {
                    this.fw.sendEmptyMessageDelayed(1001, this.hw);
                } else {
                    this.fw.removeMessages(1001);
                }
                break;
        }
    }
}
