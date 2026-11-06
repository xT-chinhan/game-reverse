package com.byazt.uq;

import com.byazt.hg.b;
import com.byazt.hg.bh;
import com.byazt.hg.of;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 209, 50})
public final class vk {
    public static volatile vk pr;
    public final Map<Integer, String> hw = new ConcurrentHashMap();

    private vk() {
    }

    public static vk pr() {
        if (pr == null) {
            synchronized (vk.class) {
                if (pr == null) {
                    pr = new vk();
                }
            }
        }
        return pr;
    }

    public bh pr(of ofVar) {
        List<bh> listVk;
        try {
            listVk = b.vk(ofVar);
            if (listVk != null) {
                try {
                    if (!listVk.isEmpty()) {
                        int iC = b.c(ofVar);
                        int iW = b.w(ofVar);
                        String str = this.hw.get(Integer.valueOf(iC));
                        int iPr = pr(listVk, str);
                        if (str != null && iPr != -1) {
                            if (iW != 1 && iW != 2) {
                                return listVk.get(iPr);
                            }
                            int iPr2 = pr(iC, str, "show_count");
                            int iPr3 = pr(iC, str, "last_has_click");
                            if (iW == 1 && iPr2 >= 3 && iPr3 != 1) {
                                return listVk.get((iPr + 1) % listVk.size());
                            }
                            if (iW == 2 && iPr3 == 1) {
                                return listVk.get((iPr + 1) % listVk.size());
                            }
                            return listVk.get(iPr);
                        }
                        return listVk.get(0);
                    }
                } catch (Throwable th) {
                    if (listVk == null || listVk.isEmpty()) {
                        return null;
                    }
                    return listVk.get(0);
                }
            }
            return null;
        } catch (Throwable th2) {
            listVk = null;
        }
    }

    public void pr(int i, String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        this.hw.put(Integer.valueOf(i), str);
    }

    private int pr(List<bh> list, String str) {
        if (list == null || str == null) {
            return -1;
        }
        for (int i = 0; i < list.size(); i++) {
            bh bhVar = list.get(i);
            if (bhVar != null && str.equals(bhVar.c())) {
                return i;
            }
        }
        return -1;
    }

    private int pr(int i, String str, String str2) {
        try {
            Object objPr = com.byazt.gf.pr.pr().pr("easy_play_carousel_session_001", "easy_play_info", i + "_" + str, str2);
            if (!(objPr instanceof Number)) {
                return 0;
            }
            return ((Number) objPr).intValue();
        } catch (Throwable th) {
            return 0;
        }
    }
}
