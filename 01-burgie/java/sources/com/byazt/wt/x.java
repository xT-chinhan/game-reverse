package com.byazt.wt;

import android.text.TextUtils;
import com.byazt.hg.of;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 121})
public class x {
    private static boolean pr(int i) {
        switch (i) {
            case 3:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    public static void pr(com.byazt.hg.pr prVar, int i, int i2, String str) {
        if (prVar == null || prVar.hw() == null || i2 <= 0) {
            return;
        }
        List<of> listHw = prVar.hw();
        int size = listHw.size();
        try {
            com.byazt.zq.fw fwVarHn = com.byazt.qn.x.hn(str, i + "_prefetch_new");
            delete(i, i2, fwVarHn, size);
            for (of ofVar : listHw) {
                String strJw = ofVar.jw();
                String strHn = ((com.byazt.vkw.nt) com.byazt.zs.uc.pr("encrypt_service")).hn(ofVar.to().toString());
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pre_fetch_time", System.currentTimeMillis());
                jSONObject.put("message", strHn);
                fwVarHn.pr(strJw, jSONObject.toString());
            }
        } catch (Throwable th) {
        }
    }

    private static void delete(int i, int i2, com.byazt.zq.fw fwVar, int i3) {
        if (fwVar == null) {
            return;
        }
        try {
            Map all = fwVar.getAll();
            if (all != null && all.size() != 0) {
                int size = all.size();
                if (pr(i)) {
                    if (size > 1) {
                        fwVar.pr();
                        return;
                    }
                    return;
                }
                if (i3 >= i2) {
                    fwVar.pr();
                    return;
                }
                int i4 = size + i3;
                if (i4 > i2) {
                    PriorityQueue priorityQueue = new PriorityQueue();
                    for (Map.Entry entry : all.entrySet()) {
                        String str = (String) entry.getValue();
                        JSONObject jSONObject = null;
                        if (str != null && str.contains("pre_fetch_time")) {
                            jSONObject = new JSONObject(str);
                        }
                        if (jSONObject != null) {
                            priorityQueue.add(new pr((String) entry.getKey(), jSONObject.optLong("pre_fetch_time")));
                        }
                    }
                    int size2 = priorityQueue.size();
                    int i5 = i4 - i2;
                    if (size2 != 0 && size2 >= i5) {
                        for (int i6 = 0; i6 < i5; i6++) {
                            pr prVar = (pr) priorityQueue.poll();
                            if (prVar != null) {
                                fwVar.pr(prVar.hw);
                            }
                        }
                        return;
                    }
                    fwVar.pr();
                }
            }
        } catch (Throwable th) {
        }
    }

    public static of pr(String str, int i, String str2) {
        if (com.byazt.sd.a.hw().i() <= 0) {
            return null;
        }
        com.byazt.zq.fw fwVarHn = com.byazt.qn.x.hn(str2, i + "_prefetch_new");
        String strHw = fwVarHn.hw(str, "");
        if (!TextUtils.isEmpty(strHw)) {
            try {
                if (strHw.contains("pre_fetch_time")) {
                    strHw = new JSONObject(strHw).optString("message");
                }
                of ofVarPr = com.byazt.sd.pr.pr(new JSONObject(((com.byazt.vkw.nt) com.byazt.zs.uc.pr("encrypt_service")).x(strHw)));
                fwVarHn.pr(str);
                return ofVarPr;
            } catch (Exception e) {
            }
        }
        return null;
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
    static class pr implements Comparable<pr> {
        public String hw;
        public long pr;

        public pr(String str, long j) {
            this.hw = str;
            this.pr = j;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public int compareTo(pr prVar) {
            if (prVar == null) {
                return 1;
            }
            long j = this.pr;
            long j2 = prVar.pr;
            if (j > j2) {
                return 1;
            }
            if (j == j2) {
                return 0;
            }
            return -1;
        }
    }
}
