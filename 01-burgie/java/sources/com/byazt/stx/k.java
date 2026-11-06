package com.byazt.stx;

import com.byazt.auw.DownloadInfo;
import com.byazt.lhc.BaseException;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, 250})
public class k implements c {
    public final c hn;
    public final com.byazt.auw.c hw;
    public final aj pr;

    public k(DownloadInfo downloadInfo, hw hwVar, aj ajVar) throws BaseException {
        this.pr = ajVar;
        this.hw = pr(downloadInfo, ajVar);
        this.hn = new zo(hwVar, this);
    }

    public c pr() {
        return this.hn;
    }

    @Override // com.byazt.stx.c
    public void hw(pr prVar) throws IOException {
        this.hw.pr(prVar.pr, 0, prVar.hn);
        this.pr.hw(prVar.hn);
    }

    public void hw() throws IOException {
        this.hw.hw();
    }

    public void hn() throws IOException {
        this.hw.hn();
    }

    public void x() {
        com.byazt.tuy.uc.pr(this.hw);
    }

    public aj c() {
        return this.pr;
    }

    private com.byazt.auw.c pr(DownloadInfo downloadInfo, aj ajVar) throws BaseException {
        com.byazt.auw.c cVarPr = com.byazt.tuy.uc.pr(downloadInfo, downloadInfo.getTempPath(), downloadInfo.getTempName(), com.byazt.ew.pr.pr(downloadInfo.getId()).pr("flush_buffer_size_byte", -1));
        try {
            cVarPr.pr(ajVar.c());
            return cVarPr;
        } catch (IOException e) {
            throw new BaseException(1054, e);
        }
    }
}
