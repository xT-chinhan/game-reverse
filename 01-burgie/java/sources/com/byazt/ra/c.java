package com.byazt.ra;

import android.text.TextUtils;
import com.byazt.hg.of;
import com.byazt.sd.a;
import com.byazt.sd.rc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_STALL_COUNTER, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public static boolean pr(com.byazt.qe.hw hwVar, of ofVar, boolean z) {
        boolean z2;
        if (!a.hw().hw(hwVar.x())) {
            return true;
        }
        if (ofVar == null) {
            com.byazt.xk.hw.pr().hw(3);
            return false;
        }
        String strCz = hwVar.cz();
        long jL = ofVar.l();
        String strJw = ofVar.jw();
        try {
            if (TextUtils.isEmpty(strCz)) {
                com.byazt.xk.hw.pr().hw(1);
                return false;
            }
            JSONObject jSONObjectPr = com.byazt.mp.uc.pr(new JSONObject(strCz), false, true);
            if (jSONObjectPr == null) {
                com.byazt.xk.hw.pr().hw(1);
                return false;
            }
            rc.pr prVarPr = rc.pr.pr(jSONObjectPr, hwVar, null);
            if (prVarPr.zo == null) {
                com.byazt.xk.hw.pr().hw(1);
                return false;
            }
            prVarPr.zo.pr(jSONObjectPr);
            List<of> listHw = prVarPr.zo.hw();
            if (listHw == null) {
                com.byazt.xk.hw.pr().hw(1);
                return false;
            }
            Iterator<of> it = listHw.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                of next = it.next();
                if (TextUtils.isEmpty(next.jw())) {
                    com.byazt.xk.hw.pr().hw(2);
                    return false;
                }
                if (!next.d()) {
                    com.byazt.xk.hw.pr().hw(5);
                    return false;
                }
                if (TextUtils.equals(next.jw(), strJw)) {
                    ofVar.ww(next.ug());
                    z2 = true;
                    break;
                }
            }
            if (!z2) {
                com.byazt.xk.hw.pr().hw(3);
                return false;
            }
            if (ofVar.iy() + jL >= System.currentTimeMillis()) {
                return true;
            }
            com.byazt.py.c.pr(z ? 7 : 8).pr(hwVar.x());
            com.byazt.xk.hw.pr().hw(4);
            return false;
        } catch (Exception e) {
            com.byazt.xk.hw.pr().hw(1000);
            return false;
        }
    }
}
