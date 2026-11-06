package com.byazt.pk;

import android.text.TextUtils;
import com.byazt.ca.ho;
import com.byazt.ea.zo;
import com.byazt.hcx.fw;
import com.byazt.hcx.m;
import com.byazt.hg.i;
import com.byazt.hg.ie;
import com.byazt.hg.of;
import com.byazt.sd.a;
import com.byazt.sd.fo;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_BEGIN_TIME, 20})
public class hn {

    public interface hw {
        void pr();

        void pr(JSONObject jSONObject);
    }

    public interface pr {
        void pr(int i, String str);

        void pr(JSONObject jSONObject);
    }

    public static void pr(com.byazt.qk.pr prVar, hw hwVar) {
        if (prVar == null) {
            if (hwVar != null) {
                hwVar.pr();
                return;
            }
            return;
        }
        pr(prVar.hn(), prVar.pr(), prVar.hw(), hwVar);
    }

    public static void pr(String str, final String str2, final String str3, final hw hwVar) {
        if (TextUtils.isEmpty(str)) {
            if (hwVar != null) {
                hwVar.pr();
                return;
            }
            return;
        }
        com.byazt.tf.hn.hw(str).pr(new fw() { // from class: com.byazt.pk.hn.1
            @Override // com.byazt.hcx.fw
            public void pr(m mVar) {
                if (mVar == null) {
                    return;
                }
                if (mVar.fw()) {
                    String strZo = mVar.zo();
                    zo.pr().pr(str2, str3, strZo);
                    if (hwVar != null) {
                        try {
                            hwVar.pr(new JSONObject(strZo));
                            return;
                        } catch (JSONException e) {
                            hwVar.pr();
                            return;
                        }
                    }
                    return;
                }
                hw hwVar2 = hwVar;
                if (hwVar2 != null) {
                    hwVar2.pr();
                }
            }

            @Override // com.byazt.hcx.fw
            public void pr(int i, String str4, Throwable th) {
                hw hwVar2 = hwVar;
                if (hwVar2 != null) {
                    hwVar2.pr();
                }
            }
        });
    }

    public static void pr(of ofVar, JSONObject jSONObject, final com.byazt.ap.x xVar, com.byazt.qe.hw hwVar) {
        if (xVar == null) {
            return;
        }
        if (ofVar != null) {
            try {
                if (!TextUtils.isEmpty(ofVar.B_())) {
                    int iK = ls.k(ofVar);
                    com.byazt.qe.hw hwVarP = ofVar.p();
                    if (hwVarP != null) {
                        hwVar = hwVarP;
                    }
                    i iVar = new i();
                    iVar.c = 2;
                    if (ie.fw(ofVar) != null) {
                        iVar.fw = 2;
                    }
                    JSONObject jSONObjectCg = ofVar.cg();
                    JSONObject jSONObject2 = new JSONObject();
                    if (jSONObjectCg != null) {
                        try {
                            Iterator<String> itKeys = jSONObjectCg.keys();
                            while (itKeys.hasNext()) {
                                String next = itKeys.next();
                                jSONObject2.put(next, jSONObjectCg.opt(next));
                            }
                        } catch (JSONException e) {
                        }
                    }
                    if (jSONObject != null) {
                        Iterator<String> itKeys2 = jSONObject.keys();
                        while (itKeys2.hasNext()) {
                            String next2 = itKeys2.next();
                            jSONObject2.put(next2, jSONObject.opt(next2));
                        }
                    }
                    iVar.m = jSONObject2;
                    a.pr().pr(hwVar, iVar, iK, new fo.hw() { // from class: com.byazt.pk.hn.2
                        @Override // com.byazt.sd.fo.hw
                        public void pr(int i, String str, com.byazt.hg.hw hwVar2) {
                            xVar.pr(false, null, false);
                            hwVar2.pr(i);
                            com.byazt.hg.hw.pr(hwVar2);
                        }

                        @Override // com.byazt.sd.fo.hw
                        public void pr(com.byazt.hg.pr prVar, com.byazt.hg.hw hwVar2) {
                            if (prVar.hw() != null && !prVar.hw().isEmpty()) {
                                xVar.pr(true, prVar.hw(), false);
                                return;
                            }
                            xVar.pr(false, null, false);
                            hwVar2.pr(-3);
                            com.byazt.hg.hw.pr(hwVar2);
                        }
                    });
                    return;
                }
            } catch (Exception e2) {
                ho.pr("PageNetUtils", "get ads error", e2);
                return;
            }
        }
        xVar.pr(false, null, false);
    }

    public static void pr(String str, final pr prVar) {
        com.byazt.tf.hn.hw(str).pr(new fw() { // from class: com.byazt.pk.hn.3
            @Override // com.byazt.hcx.fw
            public void pr(m mVar) {
                if (mVar != null && mVar.fw()) {
                    try {
                        JSONObject jSONObject = new JSONObject(mVar.zo());
                        pr prVar2 = prVar;
                        if (prVar2 != null) {
                            prVar2.pr(jSONObject);
                            return;
                        }
                        return;
                    } catch (JSONException e) {
                        return;
                    }
                }
                pr prVar3 = prVar;
                if (prVar3 != null && mVar != null) {
                    prVar3.pr(mVar.pr(), mVar.hw());
                }
            }

            @Override // com.byazt.hcx.fw
            public void pr(int i, String str2, Throwable th) {
                pr prVar2 = prVar;
                if (prVar2 != null) {
                    prVar2.pr(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE, th.getMessage());
                }
            }
        });
    }
}
