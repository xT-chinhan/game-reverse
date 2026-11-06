package com.byazt.g;

import android.os.Build;
import android.text.TextUtils;
import com.byazt.ihe.m;
import com.byazt.n.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF, 37})
public class pr implements com.byazt.ihe.pr {
    public String pr = "video_reward_full";
    public String hw = "video_brand";
    public String hn = "video_splash";
    public String x = "video_default";
    public String c = null;
    public String uc = null;
    public String fw = null;
    public String zo = null;
    public String aj = null;

    @Override // com.byazt.ihe.pr
    public void pr(String str) {
        this.c = str;
    }

    @Override // com.byazt.ihe.pr
    public String pr() {
        if (this.aj == null) {
            this.aj = this.c + File.separator + this.x;
            File file = new File(this.aj);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.aj;
    }

    @Override // com.byazt.ihe.pr
    public String hw() {
        if (this.uc == null) {
            this.uc = this.c + File.separator + this.pr;
            File file = new File(this.uc);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.uc;
    }

    @Override // com.byazt.ihe.pr
    public String hn() {
        if (this.fw == null) {
            this.fw = this.c + File.separator + this.hw;
            File file = new File(this.fw);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.fw;
    }

    @Override // com.byazt.ihe.pr
    public String x() {
        if (this.zo == null) {
            this.zo = this.c + File.separator + this.hn;
            File file = new File(this.zo);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.zo;
    }

    @Override // com.byazt.ihe.pr
    public synchronized void c() {
        List<com.byazt.fl.pr> listUc = uc();
        if (Build.VERSION.SDK_INT >= 23) {
            Set<String> setFw = null;
            for (com.byazt.fl.pr prVar : listUc) {
                File[] fileArrPr = prVar.pr();
                if (fileArrPr != null && fileArrPr.length >= prVar.hw()) {
                    if (setFw == null) {
                        setFw = fw();
                    }
                    int iHw = prVar.hw() - 2;
                    if (iHw < 0) {
                        iHw = 0;
                    }
                    pr(prVar.pr(), iHw, setFw);
                }
            }
        }
    }

    @Override // com.byazt.ihe.pr
    public boolean pr(m mVar) {
        if (TextUtils.isEmpty(mVar.c()) || TextUtils.isEmpty(mVar.fo())) {
            return false;
        }
        return new File(mVar.c(), mVar.fo()).exists();
    }

    @Override // com.byazt.ihe.pr
    public long hw(m mVar) {
        if (TextUtils.isEmpty(mVar.c()) || TextUtils.isEmpty(mVar.fo())) {
            return 0L;
        }
        return com.byazt.t.hn.pr(mVar.c(), mVar.fo());
    }

    private static void pr(File[] fileArr, int i, Set<String> set) {
        if (i < 0 || fileArr == null) {
            return;
        }
        try {
            if (fileArr.length > i) {
                List listAsList = Arrays.asList(fileArr);
                Collections.sort(listAsList, new Comparator<File>() { // from class: com.byazt.g.pr.1
                    @Override // java.util.Comparator
                    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
                    public int compare(File file, File file2) {
                        long jLastModified = file2.lastModified() - file.lastModified();
                        if (jLastModified == 0) {
                            return 0;
                        }
                        if (jLastModified < 0) {
                            return -1;
                        }
                        return 1;
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
        } catch (Throwable th) {
        }
    }

    private List<com.byazt.fl.pr> uc() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.byazt.fl.pr(new File(hw()).listFiles(), com.byazt.s.pr.hn()));
        arrayList.add(new com.byazt.fl.pr(new File(x()).listFiles(), com.byazt.s.pr.hw()));
        arrayList.add(new com.byazt.fl.pr(new File(hn()).listFiles(), com.byazt.s.pr.x()));
        arrayList.add(new com.byazt.fl.pr(new File(pr()).listFiles(), com.byazt.s.pr.c()));
        return arrayList;
    }

    private Set<String> fw() {
        HashSet hashSet = new HashSet();
        for (com.byazt.k.pr prVar : com.byazt.k.pr.pr.values()) {
            if (prVar != null && prVar.pr() != null) {
                uc ucVarPr = prVar.pr();
                hashSet.add(com.byazt.t.hn.hw(ucVarPr.c(), ucVarPr.fo()).getAbsolutePath());
                hashSet.add(com.byazt.t.hn.hn(ucVarPr.c(), ucVarPr.fo()).getAbsolutePath());
            }
        }
        for (com.byazt.u.hw hwVar : com.byazt.u.hn.pr.values()) {
            if (hwVar != null && hwVar.pr() != null) {
                m mVarPr = hwVar.pr();
                hashSet.add(com.byazt.t.hn.hw(mVarPr.c(), mVarPr.fo()).getAbsolutePath());
                hashSet.add(com.byazt.t.hn.hn(mVarPr.c(), mVarPr.fo()).getAbsolutePath());
            }
        }
        return hashSet;
    }
}
