package com.byazt.rg;

import com.byazt.gct.g;
import com.byazt.gct.h;
import com.byazt.gct.pk;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, 101})
public final class fs {
    public static volatile fs n;
    public final Map<Integer, String> qg = new ConcurrentHashMap();

    private fs() {
    }

    public static fs n() {
        if (n == null) {
            synchronized (fs.class) {
                if (n == null) {
                    n = new fs();
                }
            }
        }
        return n;
    }

    public g n(pk pkVar) {
        List<g> listCp;
        try {
            listCp = h.cp(pkVar);
            if (listCp != null) {
                try {
                    if (!listCp.isEmpty()) {
                        int iW = h.w(pkVar);
                        int iD = h.d(pkVar);
                        String str = this.qg.get(Integer.valueOf(iW));
                        int iN = n(listCp, str);
                        if (str != null && iN != -1) {
                            if (iD != 1 && iD != 2) {
                                return listCp.get(iN);
                            }
                            int iN2 = n(iW, str, "show_count");
                            int iN3 = n(iW, str, "last_has_click");
                            if (iD == 1 && iN2 >= 3 && iN3 != 1) {
                                return listCp.get((iN + 1) % listCp.size());
                            }
                            if (iD == 2 && iN3 == 1) {
                                return listCp.get((iN + 1) % listCp.size());
                            }
                            return listCp.get(iN);
                        }
                        return listCp.get(0);
                    }
                } catch (Throwable unused) {
                    if (listCp == null || listCp.isEmpty()) {
                        return null;
                    }
                    return listCp.get(0);
                }
            }
            return null;
        } catch (Throwable unused2) {
            listCp = null;
        }
    }

    public void n(int i, String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        this.qg.put(Integer.valueOf(i), str);
    }

    private int n(List<g> list, String str) {
        if (list != null && str != null) {
            for (int i = 0; i < list.size(); i++) {
                g gVar = list.get(i);
                if (gVar != null && str.equals(gVar.l())) {
                    return i;
                }
            }
        }
        return -1;
    }

    private int n(int i, String str, String str2) {
        try {
            Object objN = com.byazt.aun.q.n().n("easy_play_carousel_session_001", "easy_play_info", i + "_" + str, str2);
            if (objN instanceof Number) {
                return ((Number) objN).intValue();
            }
        } catch (Throwable unused) {
        }
        return 0;
    }
}
