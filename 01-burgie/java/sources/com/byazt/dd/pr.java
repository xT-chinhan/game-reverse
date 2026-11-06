package com.byazt.dd;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_AUDIO_FIRSTSEG_CONNECT_TIME, 37})
public class pr implements aj {
    @Override // com.byazt.dd.aj
    public List<zo> pr() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new zo("slide") { // from class: com.byazt.dd.pr.1
            @Override // com.byazt.dd.zo
            public com.byazt.xv.hw pr(Context context) {
                return new com.byazt.xv.x(context);
            }
        });
        arrayList.add(new zo("tap") { // from class: com.byazt.dd.pr.2
            @Override // com.byazt.dd.zo
            public com.byazt.xv.hw pr(Context context) {
                return new com.byazt.xv.c(context);
            }
        });
        arrayList.add(new zo("timer") { // from class: com.byazt.dd.pr.3
            @Override // com.byazt.dd.zo
            public com.byazt.xv.hw pr(Context context) {
                return new com.byazt.xv.uc(context);
            }
        });
        arrayList.add(new zo("touchStart") { // from class: com.byazt.dd.pr.4
            @Override // com.byazt.dd.zo
            public com.byazt.xv.hw pr(Context context) {
                return new com.byazt.xv.vk(context);
            }
        });
        arrayList.add(new zo("touchEnd") { // from class: com.byazt.dd.pr.5
            @Override // com.byazt.dd.zo
            public com.byazt.xv.hw pr(Context context) {
                return new com.byazt.xv.aj(context);
            }
        });
        arrayList.add(new zo("animateState") { // from class: com.byazt.dd.pr.6
            @Override // com.byazt.dd.zo
            public com.byazt.xv.hw pr(Context context) {
                return new com.byazt.xv.pr(context);
            }
        });
        arrayList.add(new zo("timerState") { // from class: com.byazt.dd.pr.7
            @Override // com.byazt.dd.zo
            public com.byazt.xv.hw pr(Context context) {
                return new com.byazt.xv.zo(context);
            }
        });
        return arrayList;
    }
}
