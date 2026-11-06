package com.byazt.py;

import android.text.TextUtils;
import com.byazt.hg.of;
import com.byazt.hg.zo;
import com.byazt.vkw.nt;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 438, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public final fw aj;
    public static final c pr = new c(7);
    public static final c hw = new c(8);
    public static final c hn = new c(3);
    public static final c x = new c(1);
    public static final c c = new c(5);
    public static final c uc = new c(9);
    public static final c fw = new c(6);
    public static final c zo = new c(0);

    private c(int i) {
        this.aj = new fw(i);
    }

    public static c pr(int i) {
        switch (i) {
            case 1:
                return x;
            case 2:
            case 4:
            default:
                return zo;
            case 3:
                return hn;
            case 5:
                return c;
            case 6:
                return fw;
            case 7:
                return pr;
            case 8:
                return hw;
            case 9:
                return uc;
        }
    }

    public void pr(com.byazt.qe.hw hwVar, of ofVar, boolean z) {
        if (hwVar != null && ofVar != null) {
            hwVar.x();
            if (zo.pr(ls.k(ofVar)).pr("forbid_save_cache", new zo.hw.pr().pr(hwVar).pr(ofVar).pr())) {
                return;
            }
            if ((ofVar.xn() != null ? ofVar.xn().optInt("save_type") : 0) == 1) {
                return;
            }
            String strX = hwVar.x();
            String strHn = ((nt) com.byazt.zs.uc.pr("encrypt_service")).hn(ofVar.to().toString());
            long jCurrentTimeMillis = ((((System.currentTimeMillis() / 1000) / 60) / 60) / 3) + ((long) ls.qa(ofVar));
            long jHp = ofVar.hp();
            int iTc = ofVar.tc();
            if (ofVar.ke() > 0) {
                jHp = Math.min(jHp, ofVar.ke());
            }
            this.aj.pr(strX, new fw.hw(strHn, ofVar.ja(), jHp * 1000, ofVar.ri()), z, jCurrentTimeMillis, iTc);
        }
    }

    public of pr(String str, boolean z, long j) {
        fw.hw hwVarPr = this.aj.pr(str, z, j);
        if (hwVarPr == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(((nt) com.byazt.zs.uc.pr("encrypt_service")).x(hwVarPr.hn));
            if (zo.pr(this.aj.pr.hw()).pr("forbid_read_cache", new zo.hw.pr().pr(jSONObject).pr())) {
                this.aj.pr(str, hwVarPr.c);
                return null;
            }
            of ofVarPr = com.byazt.sd.pr.pr(jSONObject);
            ofVarPr.vk(true);
            ofVarPr.fw(hwVarPr.pr);
            ofVarPr.ve(hwVarPr.c);
            ofVarPr.xh().hw(2);
            return ofVarPr;
        } catch (Exception e) {
            return null;
        }
    }

    public List<of> pr(String str, boolean z, long j, int i, double d) {
        System.currentTimeMillis();
        List<fw.hw> listPr = this.aj.pr(str, z, j, i, d);
        if (listPr == null || listPr.isEmpty()) {
            return Collections.emptyList();
        }
        listPr.size();
        System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (fw.hw hwVar : listPr) {
            try {
                JSONObject jSONObject = new JSONObject(((nt) com.byazt.zs.uc.pr("encrypt_service")).x(hwVar.hn));
                if (zo.pr(this.aj.pr.hw()).pr("forbid_read_cache", new zo.hw.pr().pr(jSONObject).pr())) {
                    this.aj.pr(str, hwVar.c);
                } else {
                    of ofVarPr = com.byazt.sd.pr.pr(jSONObject);
                    ofVarPr.vk(true);
                    ofVarPr.fw(hwVar.pr);
                    ofVarPr.ve(hwVar.c);
                    ofVarPr.xh().hw(2);
                    arrayList.add(ofVarPr);
                }
            } catch (Exception e) {
            }
        }
        return arrayList;
    }

    public void pr(String str) {
        this.aj.pr(str);
    }

    public void hw(String str) {
        this.aj.hw(str);
    }

    public void hn(String str) {
        this.aj.hn(str);
    }

    public void pr(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.aj.pr(str, str2);
    }

    public boolean x(String str) {
        return this.aj.x(str);
    }

    public long c(String str) {
        fw.hw hwVarPr = this.aj.pr(str, false, 0L);
        if (hwVarPr == null || !hwVarPr.pr()) {
            return 0L;
        }
        long jCurrentTimeMillis = hwVarPr.hw - System.currentTimeMillis();
        if (jCurrentTimeMillis <= 0) {
            return 0L;
        }
        return jCurrentTimeMillis / 1000;
    }

    public void pr(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.aj.pr(str, str2, z);
    }

    public void pr() {
        this.aj.pr();
    }

    public static boolean pr(of ofVar) {
        if (ofVar == null) {
            return false;
        }
        if ((ofVar.xn() != null ? ofVar.xn().optInt("save_type") : 0) == 1) {
            return false;
        }
        return true;
    }

    public static void hw(int i) {
        pr(i).aj.pr(i);
    }
}
