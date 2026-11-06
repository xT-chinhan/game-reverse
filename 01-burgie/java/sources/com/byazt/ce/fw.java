package com.byazt.ce;

import android.text.TextUtils;
import com.byazt.ca.ho;
import com.byazt.hcx.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_300, 62})
public class fw {
    public static volatile fw pr;
    public AtomicBoolean hw = new AtomicBoolean(false);

    public interface pr {
        void hw();

        void pr();
    }

    public static fw pr() {
        if (pr == null) {
            synchronized (fw.class) {
                if (pr == null) {
                    pr = new fw();
                }
            }
        }
        return pr;
    }

    private fw() {
    }

    public com.byazt.hfm.hw pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return uc.pr().pr(str);
    }

    public Set<com.byazt.hfm.hw> hw(String str) {
        return uc.pr().hw(str);
    }

    private void hw() {
        if (com.byazt.bg.pr.pr().hn() == null) {
            return;
        }
        int iPr = com.byazt.bg.pr.pr().hn().pr();
        if (iPr <= 0) {
            iPr = 100;
        }
        List<com.byazt.hfm.hw> listHw = uc.pr().hw();
        if (listHw == null || listHw.isEmpty() || iPr >= listHw.size()) {
            if (listHw != null) {
                listHw.size();
                return;
            }
            return;
        }
        TreeMap treeMap = new TreeMap();
        for (com.byazt.hfm.hw hwVar : listHw) {
            treeMap.put(hwVar.fw(), hwVar);
        }
        HashSet hashSet = new HashSet();
        int size = (int) (listHw.size() - (iPr * 0.75f));
        int i = 0;
        for (Map.Entry entry : treeMap.entrySet()) {
            if (entry != null && i < size) {
                i++;
                ((Long) entry.getKey()).longValue();
                com.byazt.hfm.hw hwVar2 = (com.byazt.hfm.hw) entry.getValue();
                if (hwVar2 != null) {
                    hashSet.add(hwVar2.hw());
                }
            }
        }
        pr(hashSet);
        this.hw.set(false);
    }

    public JSONObject pr(String str, pr prVar) {
        JSONObject jSONObjectC;
        m mVarC = com.byazt.tf.hn.c(str);
        if (mVarC != null) {
            try {
                if (mVarC.fw() && (jSONObjectC = mVarC.c()) != null) {
                    return jSONObjectC;
                }
            } catch (Exception e) {
            }
        }
        if (prVar != null) {
            prVar.hw();
            return null;
        }
        return null;
    }

    public void pr(com.byazt.hfm.x xVar, String str) {
        String strX;
        if (xVar == null) {
            ho.hw("TmplDiffManager", "saveTemplate error: tplInfo == null");
            return;
        }
        final String str2 = xVar.pr;
        final String str3 = xVar.hn;
        final String str4 = xVar.hw;
        final String str5 = xVar.x;
        final String str6 = xVar.c;
        if (com.byazt.bg.pr.pr().hn() == null) {
            strX = "";
        } else {
            strX = com.byazt.bg.pr.pr().hn().x();
        }
        final String str7 = TextUtils.isEmpty(str) ? strX : str;
        if (TextUtils.isEmpty(str2)) {
            ho.hw("TmplDiffManager", "saveTemplate error:tmpId is empty");
        } else {
            com.byazt.js.c.pr(new com.byazt.xlm.fw("saveTemplate") { // from class: com.byazt.ce.fw.1
                @Override // java.lang.Runnable
                public void run() {
                    fw.this.pr(str2, str3, str4, str5, str6, str7);
                }
            }, 10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void pr(String str, String str2, String str3, String str4, String str5, String str6) {
        if (pr(str) != null) {
            if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
                hw(str6, str, str3, str2, str4, str5);
            }
            return;
        } else if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
            pr(str2, str6, str);
        } else {
            hw(str6, str, str3, str2, str4, str5);
        }
        boolean zPr = zo.pr(str5);
        if (!hw.c() || zPr) {
            c.hw().pr(true);
        }
    }

    private void pr(String str, String str2, String str3) {
        pr(str, str2, str3, null);
    }

    public void pr(com.byazt.hfm.x xVar, pr prVar) {
        pr(xVar, xVar.hw(), prVar);
    }

    public void pr(com.byazt.hfm.x xVar, String str, final pr prVar) {
        String strX;
        if (prVar == null) {
            return;
        }
        if (xVar == null) {
            ho.hw("TmplDiffManager", "saveTemplate error: tplInfo == null");
            prVar.hw();
            return;
        }
        final String str2 = xVar.pr;
        final String str3 = xVar.hn;
        final String str4 = xVar.hw;
        final String str5 = xVar.x;
        final String str6 = xVar.c;
        if (com.byazt.bg.pr.pr().hn() == null) {
            strX = "";
        } else {
            strX = com.byazt.bg.pr.pr().hn().x();
        }
        final String str7 = TextUtils.isEmpty(str) ? strX : str;
        if (TextUtils.isEmpty(str2)) {
            ho.hw("TmplDiffManager", "saveTemplate error:tmpId is empty");
            prVar.hw();
        } else {
            com.byazt.js.c.pr(new com.byazt.xlm.fw("saveTemplate") { // from class: com.byazt.ce.fw.2
                @Override // java.lang.Runnable
                public void run() {
                    fw.this.pr(str2, str3, str4, str5, str6, str7, prVar);
                }
            }, 10);
        }
    }

    public synchronized void pr(String str, String str2, String str3, String str4, String str5, String str6, pr prVar) {
        if (pr(str) != null) {
            if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
                hw(str6, str, str3, str2, str4, str5);
                prVar.pr();
            }
            prVar.pr();
            return;
        }
        if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
            pr(str2, str6, str, prVar);
        } else {
            hw(str6, str, str3, str2, str4, str5);
            prVar.pr();
        }
        boolean zPr = zo.pr(str5);
        if (!hw.c() || zPr) {
            c.hw().pr(true);
        }
    }

    private void hw(String str, String str2, String str3, String str4, String str5, String str6) {
        uc.pr().pr(new com.byazt.hfm.hw().pr(str).hw(str2).hn(str3).x(str4).c(str5).uc(str6).pr(Long.valueOf(System.currentTimeMillis())), false);
        hw();
    }

    private void pr(String str, String str2, String str3, pr prVar) {
        if (TextUtils.isEmpty(str) && prVar != null) {
            prVar.hw();
            return;
        }
        JSONObject jSONObjectPr = pr(str, prVar);
        if (jSONObjectPr != null) {
            String strOptString = jSONObjectPr.optString("md5");
            String strOptString2 = jSONObjectPr.optString("version");
            String strOptString3 = jSONObjectPr.optString("data");
            if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2) || TextUtils.isEmpty(strOptString3)) {
                if (prVar != null) {
                    prVar.hw();
                    return;
                }
                return;
            }
            com.byazt.hfm.hw hwVarPr = new com.byazt.hfm.hw().pr(str2).hw(str3).hn(strOptString).x(str).c(strOptString3).uc(strOptString2).pr(Long.valueOf(System.currentTimeMillis()));
            if (hwVarPr == null || com.byazt.bg.pr.pr().hw() == null) {
                if (prVar != null) {
                    prVar.hw();
                }
            } else {
                if (TextUtils.isEmpty(hwVarPr.hw())) {
                    if (prVar != null) {
                        prVar.hw();
                        return;
                    }
                    return;
                }
                uc.pr().pr(hwVarPr, false);
                hw();
                if (zo.pr(strOptString2)) {
                    hwVarPr.uc(strOptString2);
                    c.hw().pr(true);
                }
                if (prVar != null) {
                    prVar.pr();
                }
            }
        }
    }

    public void pr(Set<String> set) {
        try {
            uc.pr().pr(set);
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
