package com.byazt.yn;

import android.util.SparseArray;
import com.byazt.hcx.aj;
import com.byazt.hcx.ho;
import com.byazt.hcx.k;
import com.byazt.hcx.m;
import com.byazt.hcx.nt;
import com.byazt.vkw.gz;
import com.byazt.vkw.ve;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_MIN_JITTER_BUFFER, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c implements gz, Function {
    public final com.byazt.tf.hw hw;
    public final ve pr;

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                aj ajVarPr = pr();
                return ajVarPr != null ? new k(ajVarPr) : ajVarPr;
            case 2:
                Object ntVar = sparseArray.get(1);
                if (ntVar != null) {
                    ntVar = new nt((Function) ntVar);
                }
                pr((ho) ntVar);
                return null;
            default:
                return null;
        }
    }

    public c(ve veVar) {
        this.pr = veVar;
        final com.byazt.tf.hw.pr prVarPr = new com.byazt.tf.hw.pr().pr(veVar.hw(), TimeUnit.MILLISECONDS).hw(veVar.hn(), TimeUnit.MILLISECONDS).hn(veVar.x(), TimeUnit.MILLISECONDS).pr(veVar.c());
        veVar.fw().forEach(new Consumer<ho>() { // from class: com.byazt.yn.c.1
            @Override // java.util.function.Consumer
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public void accept(final ho hoVar) {
                prVarPr.pr(new com.byazt.nzn.aj() { // from class: com.byazt.yn.c.1.1
                    @Override // com.byazt.nzn.aj
                    public com.byazt.nzn.nt pr(com.byazt.nzn.aj.pr prVar) throws IOException {
                        hoVar.pr((aj) null);
                        com.byazt.nzn.nt ntVarPr = prVar.pr(prVar.pr());
                        hoVar.pr((m) null);
                        return ntVarPr;
                    }
                });
            }
        });
        com.byazt.tf.hw hwVarPr = prVarPr.pr(true).pr();
        this.hw = hwVarPr;
        com.byazt.nzn.x xVarPr = hwVarPr.pr().pr();
        if (xVarPr != null) {
            xVarPr.pr(veVar.uc());
            xVarPr.hw(veVar.pr());
        }
    }

    @Override // com.byazt.vkw.gz
    public aj pr() {
        return new hn(this.pr, this.hw);
    }

    @Override // com.byazt.vkw.gz
    public void pr(ho hoVar) {
    }
}
