package com.byazt.zr;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.byazt.af.w;
import com.byazt.ca.ho;
import com.byazt.hg.of;
import com.byazt.hg.yb;
import com.byazt.sd.a;
import com.byazt.sd.zo;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.constants.Constants;
import com.taptap.sdk.db.constant.Common;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FIRST_VIDEO_SEND_OUTLET_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends pr {
    @Override // com.byazt.zr.x
    public int pr(Context context, w wVar, Map<String, Object> map) {
        String str;
        int i;
        if (context == null || wVar == null || !pr(wVar)) {
            return -1;
        }
        if (map == null) {
            str = "";
        } else {
            str = (String) map.get("event_tag");
        }
        int iC = wVar.c();
        int iIntValue = 1;
        if (!uc()) {
            pr(com.byazt.lx.hw.pr(wVar, map), str, iC, 1, iC == 7 ? 1 : 2);
            return 1;
        }
        if (this.pr != null) {
            int iHw = 0;
            Object objApply = this.pr.apply(com.byazt.xi.hw.pr().pr(0).pr(Integer.class).pr(0, hw(wVar, map)).hw());
            iIntValue = objApply != null ? ((Integer) objApply).intValue() : 0;
            if (iIntValue == 0) {
                if (pr(wVar, 0) && (iHw = hw(wVar)) == 0) {
                    try {
                        new com.byazt.nl.pr().pr(str).pr(context, map, wVar);
                        i = iHw;
                    } catch (Exception e) {
                        iHw = 3;
                        i = iHw;
                    }
                } else {
                    i = iHw;
                }
            } else {
                iHw = 3;
                i = iHw;
            }
        } else {
            i = 1;
        }
        pr(com.byazt.lx.hw.pr(wVar, map), str, iC, iC, i);
        return iIntValue;
    }

    private String hw(w wVar, Map<String, Object> map) {
        if (wVar == null) {
            return "";
        }
        try {
            return com.byazt.eg.hn.pr(Uri.parse("sslocal://webcast_room"), pr(wVar, map)).toString();
        } catch (Throwable th) {
            ho.hw(com.byazt.ay.hn.TAG, "link: null");
            return "";
        }
    }

    public Map<String, String> pr(w wVar, Map<String, Object> map) {
        HashMap map2 = new HashMap();
        if (wVar == null) {
            return map2;
        }
        map2.put("room_id", wVar.vk());
        if (this.pr != null) {
            int iK = ls.k(com.byazt.lx.hw.pr(wVar, map));
            String str = (String) this.pr.apply(com.byazt.xi.hw.pr().pr(1).pr(String.class).pr(0, Integer.valueOf(iK)).hw());
            String str2 = (String) this.pr.apply(com.byazt.xi.hw.pr().pr(2).pr(String.class).pr(0, Integer.valueOf(iK)).pr(1, Boolean.valueOf(com.byazt.lpk.pr.pr(com.byazt.lx.hw.pr(wVar, map)))).hw());
            map2.put("enter_from_merge", str);
            map2.put("enter_method", str2);
        }
        map2.put("host", "aweme");
        map2.put("is_other_channel", "union_ad");
        String strPr = pr(wVar, wVar.k(), map);
        if (!TextUtils.isEmpty(strPr)) {
            map2.put("ecom_live_params", strPr);
        }
        yb ybVarG = wVar.g();
        if (ybVarG != null && !TextUtils.isEmpty(ybVarG.hw())) {
            try {
                Uri uri = Uri.parse(ybVarG.hw());
                JSONObject jSONObject = new JSONObject(uri.getQueryParameter("ad_data_params"));
                String strOptString = jSONObject.optString("log_extra");
                JSONObject jSONObject2 = new JSONObject();
                if (!TextUtils.isEmpty(strOptString)) {
                    JSONObject jSONObject3 = new JSONObject(strOptString);
                    jSONObject3.put("ad_event_aid", jSONObject.optString("aid"));
                    jSONObject3.put("ad_event_source", com.byazt.eg.hn.pr(uri, "source"));
                    jSONObject3.put("ad_event_gd_label", com.byazt.eg.hn.pr(uri, "gd_label"));
                    jSONObject3.put("ad_event_union_user_id", com.byazt.eg.hn.pr(uri, "union_user_id"));
                    jSONObject3.put("ad_event_app_siteid", zo.nt().ny());
                    jSONObject3.put("ad_event_live_type", "1");
                    map2.put("log_extra", jSONObject3.toString());
                    jSONObject2.put("log_extra", jSONObject3.toString());
                }
                String strOptString2 = jSONObject.optString("cid");
                jSONObject2.put("creativeID", strOptString2);
                map2.put("creative_id", strOptString2);
                map2.put("IESLiveEffectAdTrackExtraServiceKey", jSONObject2.toString());
                String strPr2 = com.byazt.eg.hn.pr(uri, "owner_open_id");
                if (TextUtils.isEmpty(strPr2)) {
                    strPr2 = com.byazt.eg.hn.pr(uri, Common.System.USER_ID);
                }
                map2.put("owner_open_id", strPr2);
                String strPr3 = com.byazt.eg.hn.pr(uri, "pangle_live_room_data");
                if (!TextUtils.isEmpty(strPr3)) {
                    map2.put("pangle_live_room_data", strPr3);
                }
                map2.put(Constants.Bidding.REQUEST_ID, com.byazt.eg.hn.pr(uri, Constants.Bidding.REQUEST_ID));
            } catch (Exception e) {
            }
        }
        return map2;
    }

    @Override // com.byazt.zr.x
    public int pr(Context context, of ofVar, Map<String, Object> map) {
        return -1;
    }

    @Override // com.byazt.zr.x
    public boolean a_(of ofVar) {
        return pr((w) ofVar) && this.pr != null;
    }

    @Override // com.byazt.zr.pr
    public boolean w_() {
        return true;
    }

    @Override // com.byazt.zr.pr, com.byazt.zr.x
    public void pr(final String str, final of ofVar, final long j) {
        com.byazt.zp.zo.hw(new Runnable() { // from class: com.byazt.zr.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.hw(str, ofVar, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(String str, of ofVar, long j) {
        try {
            if (this.pr == null) {
                return;
            }
            Map<String, String> mapPr = pr(ofVar, (Map<String, Object>) null);
            Map<String, String> mapPr2 = com.byazt.lpk.pr.pr(a.getContext());
            mapPr2.put("room_id", mapPr.get("room_id"));
            mapPr2.put("anchor_id", mapPr.get("owner_open_id"));
            mapPr2.put("enter_from_merge", mapPr.get("enter_from_merge"));
            mapPr2.put("enter_method", mapPr.get("enter_method"));
            mapPr2.put("action_type", "click");
            mapPr2.put(Constants.Bidding.REQUEST_ID, mapPr.get(Constants.Bidding.REQUEST_ID));
            mapPr2.put("duration", new StringBuilder().append(j).toString());
            mapPr2.put("is_other_channel", "union_ad");
            mapPr2.put("IESLiveEffectAdTrackExtraServiceKey", mapPr.get("IESLiveEffectAdTrackExtraServiceKey"));
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : mapPr2.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            this.pr.apply(com.byazt.xi.hw.pr().pr(4).pr(Void.class).pr(0, str).pr(1, jSONObject).hw());
        } catch (Throwable th) {
            if (ho.hn()) {
                ho.pr("TTInnerLiveHelper", "Throwable : ", th);
            }
        }
    }

    @Override // com.byazt.zr.x
    public int hw() {
        if (this.pr != null) {
            try {
                Object objApply = this.pr.apply(com.byazt.xi.hw.pr().pr(3).pr(Object.class).pr(0, 1).hw());
                if (objApply instanceof Integer) {
                    return ((Integer) objApply).intValue();
                }
            } catch (Throwable th) {
            }
        }
        return 0;
    }

    @Override // com.byazt.zr.x
    public int hw(of ofVar) {
        if (this.pr != null) {
            long jPr = pr(ofVar);
            if (jPr == 0) {
                return 1;
            }
            try {
                Bundle bundle = new Bundle();
                bundle.putLong("room_id", jPr);
                Object objApply = this.pr.apply(com.byazt.xi.hw.pr().pr(3).pr(Object.class).pr(0, 2).pr(1, bundle).hw());
                if (objApply instanceof Integer) {
                    return ((Integer) objApply).intValue();
                }
            } catch (Throwable th) {
            }
        }
        return 0;
    }

    @Override // com.byazt.zr.x
    public void x() {
    }

    @Override // com.byazt.zr.x
    public int c() {
        boolean zBooleanValue = false;
        if (this.pr != null) {
            try {
                Object objApply = this.pr.apply(com.byazt.xi.hw.pr().pr(3).pr(Object.class).pr(0, 3).hw());
                if (objApply instanceof Boolean) {
                    zBooleanValue = ((Boolean) objApply).booleanValue();
                }
            } catch (Throwable th) {
            }
        }
        return zBooleanValue ? 2 : 1;
    }

    @Override // com.byazt.zr.x
    public boolean uc() {
        return hw() == 2;
    }

    @Override // com.byazt.zr.x
    public String fw() {
        if (this.pr != null) {
            try {
                Object objApply = this.pr.apply(com.byazt.xi.hw.pr().pr(3).pr(Object.class).pr(0, 4).hw());
                if (objApply instanceof String) {
                    return (String) objApply;
                }
                return null;
            } catch (Throwable th) {
                return null;
            }
        }
        return null;
    }

    @Override // com.byazt.zr.x
    public int pr(w wVar, hn hnVar, String str, Map<String, Object> map) {
        if (wVar == null || TextUtils.isEmpty(wVar.y_()) || this.pr == null) {
            return -1;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("schema", wVar.y_());
            Object objApply = this.pr.apply(com.byazt.xi.hw.pr().pr(3).pr(Object.class).pr(0, 5).pr(1, bundle).hw());
            if (objApply == null) {
                return 4;
            }
            if (!(objApply instanceof Integer)) {
                return -1;
            }
            return ((Integer) objApply).intValue();
        } catch (Throwable th) {
            return -1;
        }
    }

    @Override // com.byazt.zr.x
    public JSONObject zo() {
        return this.hn;
    }

    @Override // com.byazt.zr.x
    public int pr(String str) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("schema", str);
            Object objApply = this.pr.apply(com.byazt.xi.hw.pr().pr(3).pr(Object.class).pr(0, 6).pr(1, bundle).hw());
            if (objApply instanceof Integer) {
                return ((Integer) objApply).intValue();
            }
        } catch (Throwable th) {
        }
        return 0;
    }

    @Override // com.byazt.zr.x
    public int pr(com.byazt.mh.hw hwVar, boolean z) {
        return 0;
    }

    @Override // com.byazt.zr.x
    public void pr(String str, boolean z) {
    }

    @Override // com.byazt.zr.x
    public void pr(com.byazt.igw.x xVar) {
    }
}
