package com.byazt.he;

import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.byazt.ajv.UGFrameLayout;
import com.byazt.ch.nt;
import com.byazt.ik.hn;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVREAGE_BITRATE_DIFF, 37})
public class pr extends com.byazt.oob.pr {
    public pr(Context context) {
        super(context);
    }

    @Override // com.byazt.ik.hn
    /* JADX INFO: renamed from: lv, reason: merged with bridge method [inline-methods] */
    public UGFrameLayout pr() {
        UGFrameLayout uGFrameLayout = new UGFrameLayout(this.hw);
        uGFrameLayout.pr(this);
        return uGFrameLayout;
    }

    @Override // com.byazt.oob.pr, com.byazt.ik.pr, com.byazt.ik.hn
    public void hw() {
        super.hw();
    }

    public void pr(long j, long j2) {
        nt ntVar;
        JSONObject jSONObjectHn;
        if (!pr(12) || (ntVar = this.na.get(12)) == null || (jSONObjectHn = ntVar.hn()) == null) {
            return;
        }
        jSONObjectHn.optString("type");
        JSONArray jSONArrayOptJSONArray = jSONObjectHn.optJSONArray("actions");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString("type");
                int iOptInt = jSONObjectOptJSONObject.optInt(NotificationCompat.CATEGORY_PROGRESS) * 1000;
                if (iOptInt > j2) {
                    iOptInt = (int) j2;
                }
                if (j == iOptInt && TextUtils.equals(strOptString, "onShow")) {
                    hn hnVarHw = hw(this);
                    String strOptString2 = jSONObjectOptJSONObject.optString("nodeId");
                    if (hnVarHw != null) {
                        hnVarHw.x(strOptString2).hw(0);
                    }
                }
            }
        }
    }
}
