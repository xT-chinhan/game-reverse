package com.byazt.dd;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_AUDIO_FIRSTSEG_CONNECT_TIME, 5})
public class uc implements hn {
    @Override // com.byazt.dd.hn
    public List<hw> pr() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new hw("update") { // from class: com.byazt.dd.uc.1
            @Override // com.byazt.dd.hw
            public com.byazt.tby.pr pr(com.byazt.ik.hn hnVar, String str, fw.pr prVar) {
                return new com.byazt.tby.uc(hnVar, str, prVar);
            }
        });
        arrayList.add(new hw("emit") { // from class: com.byazt.dd.uc.2
            @Override // com.byazt.dd.hw
            public com.byazt.tby.pr pr(com.byazt.ik.hn hnVar, String str, fw.pr prVar) {
                return new com.byazt.tby.hw(hnVar, str, prVar);
            }
        });
        arrayList.add(new hw("startAnimate") { // from class: com.byazt.dd.uc.3
            @Override // com.byazt.dd.hw
            public com.byazt.tby.pr pr(com.byazt.ik.hn hnVar, String str, fw.pr prVar) {
                return new com.byazt.tby.x(hnVar, str, prVar);
            }
        });
        arrayList.add(new hw("startTimer") { // from class: com.byazt.dd.uc.4
            @Override // com.byazt.dd.hw
            public com.byazt.tby.pr pr(com.byazt.ik.hn hnVar, String str, fw.pr prVar) {
                return new com.byazt.tby.c(hnVar, str, prVar);
            }
        });
        return arrayList;
    }
}
