package com.byazt.jm;

import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.ca.yb;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.hg.sv;
import com.byazt.ihe.m;
import com.byazt.sd.a;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SPEEDX_DROP, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo {
    public static void pr(long j, boolean z, boolean z2, of ofVar, long j2, String str) {
        String str2;
        long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
        if (z) {
            str2 = z2 ? "load_video_success" : "load_video_error";
        } else {
            str2 = z2 ? "download_video_image_success" : "download_video_image_fail";
        }
        if (z) {
            Map<String, Object> mapPr = ls.pr(z2, ofVar, jElapsedRealtime, j2, str);
            mapPr.put("splash_show_type", 1);
            com.byazt.pj.pr.c(ofVar, "splash_ad", str2, mapPr);
        } else {
            Map<String, Object> mapHw = ls.hw(z2, ofVar, jElapsedRealtime, j2, str);
            mapHw.put("splash_show_type", 2);
            com.byazt.pj.pr.x(ofVar, "splash_ad", str2, mapHw);
        }
    }

    public static void pr(com.byazt.hg.pr prVar) {
        com.byazt.n.uc ucVarPr;
        if (!hw(prVar)) {
            return;
        }
        of ofVar = prVar.hw().get(0);
        int iM = ls.m(ofVar);
        com.byazt.n.x xVarHo = qv.ho(ofVar);
        if (xVarHo != null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            String strK = xVarHo.k();
            if (TextUtils.isEmpty(strK)) {
                pr(jElapsedRealtime, true, false, ofVar, -1L, "preLoadVideo videoUrl is null");
                return;
            }
            if (TextUtils.isEmpty(xVarHo.ho())) {
                com.byazt.ca.c.hw(strK);
            }
            if (ofVar.oc()) {
                ucVarPr = qv.pr(2, ofVar);
            } else {
                ucVarPr = qv.pr(3, ofVar);
            }
            ucVarPr.pr("material_meta", ofVar);
            if (a.hw().fw(String.valueOf(iM)) && !yb.x(a.getContext())) {
                return;
            }
            xVarHo.uc(0);
            com.byazt.s.pr.pr();
            com.byazt.it.hn.pr(ucVarPr, new com.byazt.e.pr() { // from class: com.byazt.jm.zo.1
                @Override // com.byazt.ihe.vk.pr
                public void hw(m mVar, int i) {
                }

                @Override // com.byazt.ihe.vk.pr
                public void pr(m mVar, int i, String str) {
                }
            });
        }
    }

    public static boolean hw(com.byazt.hg.pr prVar) {
        return (prVar == null || prVar.hw() == null || prVar.hw().isEmpty() || prVar.hw().get(0) == null) ? false : true;
    }

    public static int pr(sv svVar) {
        if (svVar != null) {
            int iHn = hn(svVar.hw());
            if (iHn <= 0) {
                return pr(svVar.pr());
            }
            return iHn;
        }
        return 0;
    }

    public static int pr(of ofVar) {
        if (ofVar != null) {
            return ls.m(ofVar);
        }
        return 0;
    }

    public static int hn(com.byazt.hg.pr prVar) {
        if (prVar != null) {
            return prVar.pr();
        }
        return 0;
    }

    public static boolean hw(of ofVar) {
        if (ofVar == null || ofVar.sx() == 1 || qv.ho(ofVar) == null || TextUtils.isEmpty(qv.pr(ofVar))) {
            return true;
        }
        ofVar.k(true);
        return false;
    }
}
