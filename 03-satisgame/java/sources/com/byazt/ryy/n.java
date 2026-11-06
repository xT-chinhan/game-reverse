package com.byazt.ryy;

import android.text.TextUtils;
import com.byazt.ej.k;
import com.byazt.zsl.l;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_FALLBACK_THRESHLOD, 19})
public class n implements com.byazt.ej.n {
    public String n = "video_reward_full";
    public String qg = "video_brand";
    public String s = "video_splash";
    public String q = "video_default";
    public String l = null;
    public String w = null;
    public String x = null;
    public String fs = null;
    public String rv = null;

    @Override // com.byazt.ej.n
    public void n(String str) {
        this.l = str;
    }

    @Override // com.byazt.ej.n
    public String n() {
        if (this.rv == null) {
            this.rv = this.l + File.separator + this.q;
            File file = new File(this.rv);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.rv;
    }

    @Override // com.byazt.ej.n
    public String qg() {
        if (this.w == null) {
            this.w = this.l + File.separator + this.n;
            File file = new File(this.w);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.w;
    }

    @Override // com.byazt.ej.n
    public String s() {
        if (this.x == null) {
            this.x = this.l + File.separator + this.qg;
            File file = new File(this.x);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.x;
    }

    @Override // com.byazt.ej.n
    public String q() {
        if (this.fs == null) {
            this.fs = this.l + File.separator + this.s;
            File file = new File(this.fs);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.fs;
    }

    @Override // com.byazt.ej.n
    public synchronized void l() {
        Set<String> setX = null;
        for (com.byazt.yvi.n nVar : w()) {
            File[] fileArrN = nVar.n();
            if (fileArrN != null && fileArrN.length >= nVar.qg()) {
                if (setX == null) {
                    setX = x();
                }
                int iQg = nVar.qg() - 2;
                if (iQg < 0) {
                    iQg = 0;
                }
                n(nVar.n(), iQg, setX);
            }
        }
    }

    @Override // com.byazt.ej.n
    public boolean n(k kVar) {
        if (TextUtils.isEmpty(kVar.l()) || TextUtils.isEmpty(kVar.wm())) {
            return false;
        }
        return new File(kVar.l(), kVar.wm()).exists();
    }

    @Override // com.byazt.ej.n
    public long qg(k kVar) {
        if (TextUtils.isEmpty(kVar.l()) || TextUtils.isEmpty(kVar.wm())) {
            return 0L;
        }
        return com.byazt.udy.s.n(kVar.l(), kVar.wm());
    }

    private static void n(File[] fileArr, int i, Set<String> set) {
        if (i >= 0 && fileArr != null) {
            try {
                if (fileArr.length > i) {
                    List listAsList = Arrays.asList(fileArr);
                    Collections.sort(listAsList, new Comparator<File>() { // from class: com.byazt.ryy.n.1
                        @Override // java.util.Comparator
                        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
                        public int compare(File file, File file2) {
                            long jLastModified = file2.lastModified() - file.lastModified();
                            if (jLastModified == 0) {
                                return 0;
                            }
                            return jLastModified < 0 ? -1 : 1;
                        }
                    });
                    while (i < listAsList.size()) {
                        File file = (File) listAsList.get(i);
                        if (set != null && !set.contains(file.getAbsolutePath())) {
                            ((File) listAsList.get(i)).delete();
                        }
                        i++;
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private List<com.byazt.yvi.n> w() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.byazt.yvi.n(new File(qg()).listFiles(), com.byazt.lhs.n.s()));
        arrayList.add(new com.byazt.yvi.n(new File(q()).listFiles(), com.byazt.lhs.n.qg()));
        arrayList.add(new com.byazt.yvi.n(new File(s()).listFiles(), com.byazt.lhs.n.q()));
        arrayList.add(new com.byazt.yvi.n(new File(n()).listFiles(), com.byazt.lhs.n.l()));
        return arrayList;
    }

    private Set<String> x() {
        HashSet hashSet = new HashSet();
        for (com.byazt.vje.n nVar : com.byazt.vje.n.n.values()) {
            if (nVar != null && nVar.n() != null) {
                l lVarN = nVar.n();
                hashSet.add(com.byazt.udy.s.qg(lVarN.l(), lVarN.wm()).getAbsolutePath());
                hashSet.add(com.byazt.udy.s.s(lVarN.l(), lVarN.wm()).getAbsolutePath());
            }
        }
        for (com.byazt.nkg.qg qgVar : com.byazt.nkg.s.n.values()) {
            if (qgVar != null && qgVar.n() != null) {
                k kVarN = qgVar.n();
                hashSet.add(com.byazt.udy.s.qg(kVarN.l(), kVarN.wm()).getAbsolutePath());
                hashSet.add(com.byazt.udy.s.s(kVarN.l(), kVarN.wm()).getAbsolutePath());
            }
        }
        return hashSet;
    }
}
