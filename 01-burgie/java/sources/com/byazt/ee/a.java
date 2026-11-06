package com.byazt.ee;

import android.net.Uri;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_IS_TOO_LARGE_AV_DIFF, MediaPlayer.MEDIA_PLAYER_OPTION_NOTIFY_ALL_SEI_THRESHOLD})
public class a {
    public w.hw c;
    public final ny hn = yb.pr;
    public final Set<String> hw;
    public final Set<String> pr;
    public final cz x;

    public a(cz czVar, Set<String> set, Set<String> set2) {
        this.x = czVar;
        if (set == null || set.isEmpty()) {
            this.pr = new LinkedHashSet();
        } else {
            this.pr = new LinkedHashSet(set);
        }
        if (set2 == null || set2.isEmpty()) {
            this.hw = new LinkedHashSet();
        } else {
            this.hw = new LinkedHashSet(set2);
        }
    }

    public final synchronized fo pr(boolean z, String str, hw hwVar) throws cz.pr {
        fo foVar;
        fo foVarHw;
        w.hw hwVar2;
        Uri uri = Uri.parse(str);
        String host = uri.getHost();
        if (host == null) {
            return null;
        }
        if (!this.hw.contains(hwVar.pr())) {
            foVar = null;
        } else {
            foVar = fo.PUBLIC;
        }
        for (String str2 : this.pr) {
            if (!uri.getHost().equals(str2) && !host.endsWith(".".concat(String.valueOf(str2)))) {
            }
            foVar = fo.PRIVATE;
        }
        if (foVar == null && (hwVar2 = this.c) != null && hwVar2.pr(str)) {
            if (this.c.pr(str, hwVar.pr())) {
                return null;
            }
            foVar = fo.PRIVATE;
        }
        if (z) {
            foVarHw = pr(str, hwVar);
        } else {
            foVarHw = hw(str, hwVar);
        }
        return foVarHw != null ? foVarHw : foVar;
    }

    public final synchronized fo pr(String str, hw hwVar) throws cz.pr {
        return pr(str, hwVar, true);
    }

    public final synchronized fo hw(String str, hw hwVar) {
        return pr(str, hwVar, false);
    }

    public void pr(w.hw hwVar) {
        this.c = hwVar;
    }

    public void pr(ny.pr prVar) {
        ny nyVar = this.hn;
        if (nyVar != null) {
            nyVar.pr(prVar);
        }
    }

    public void hw(ny.pr prVar) {
        ny nyVar = this.hn;
        if (nyVar != null) {
            nyVar.hw(prVar);
        }
    }

    private fo pr(String str, hw hwVar, boolean z) {
        cz czVar;
        if (!z || (czVar = this.x) == null) {
            return null;
        }
        cz.hn hnVarPr = czVar.pr(str, this.pr);
        if (hnVarPr.hn.contains(hwVar.pr())) {
            return null;
        }
        if (hnVarPr.hw.contains(hwVar.pr())) {
            return fo.PRIVATE;
        }
        if (hnVarPr.pr.compareTo(hwVar.hw()) < 0) {
            return null;
        }
        return hnVarPr.pr;
    }
}
