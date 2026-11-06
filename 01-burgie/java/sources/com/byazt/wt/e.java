package com.byazt.wt;

import com.byazt.hg.of;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 105})
public class e {
    public static final Set<Integer> pr = new CopyOnWriteArraySet();
    public static final com.byazt.ca.fo hw = new com.byazt.ca.fo() { // from class: com.byazt.wt.e.1
        @Override // com.byazt.ca.fo
        public boolean pr(int i) {
            if (com.byazt.sd.a.hw().sf()) {
                return e.pr.contains(Integer.valueOf(i));
            }
            return true;
        }
    };

    public static com.byazt.st.pr pr(of ofVar) {
        if (ofVar != null) {
            com.byazt.st.pr prVar = new com.byazt.st.pr();
            prVar.pr(ofVar.nl());
            prVar.pr(ofVar.B_());
            prVar.hw(ofVar.x());
            return prVar;
        }
        return null;
    }

    public static void pr() {
        if (com.byazt.sd.a.hw().sf()) {
            com.byazt.ca.ny.pr(hw);
        } else {
            pr.clear();
        }
    }

    public static void pr(int i) {
        if (com.byazt.sd.a.hw().sf()) {
            pr.add(Integer.valueOf(i));
        }
        hw.hn(i);
    }

    public static void hw(int i) {
        pr.remove(Integer.valueOf(i));
        hw.hw(i);
    }
}
