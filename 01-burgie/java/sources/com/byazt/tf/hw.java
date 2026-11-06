package com.byazt.tf;

import android.content.Context;
import android.os.Bundle;
import com.byazt.nzn.aj;
import com.byazt.nzn.k;
import com.byazt.ry.fw;
import com.byazt.ry.uc;
import com.byazt.vkw.c;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1049, 13})
public class hw {
    public int hn;
    public uc hw;
    public k pr;

    private hw(pr prVar) {
        k.pr prVarHw = new k.pr().pr(prVar.pr, TimeUnit.MILLISECONDS).hn(prVar.hn, TimeUnit.MILLISECONDS).hw(prVar.hw, TimeUnit.MILLISECONDS);
        if (prVar.x) {
            uc ucVar = new uc();
            this.hw = ucVar;
            prVarHw.pr(ucVar);
        }
        if (prVar.c != null && prVar.c.size() > 0) {
            Iterator<aj> it = prVar.c.iterator();
            while (it.hasNext()) {
                prVarHw.pr(it.next());
            }
        }
        if (prVar.fw != null) {
            prVarHw.pr(prVar.fw);
        }
        prVarHw.pr(prVar.uc);
        if (prVar.zo == null) {
            prVarHw.pr(new com.byazt.dqk.hw());
        } else {
            prVarHw.pr(prVar.zo);
        }
        this.pr = prVarHw.pr();
    }

    public void pr(Context context, boolean z, com.byazt.ry.hw hwVar) {
        if (context == null) {
            throw new IllegalArgumentException("tryInitAdTTNet context is null");
        }
        if (hwVar == null) {
            throw new IllegalArgumentException("tryInitAdTTNet ITTAdNetDepend is null");
        }
        int iPr = hwVar.pr();
        this.hn = iPr;
        uc ucVar = this.hw;
        if (ucVar != null) {
            ucVar.pr(iPr);
        }
        fw.pr().pr(this.hn).pr(z);
        fw.pr().pr(this.hn).pr(hwVar);
        fw.pr().pr(this.hn).pr(context, ((c) com.byazt.zs.uc.pr("app_process")).pr());
    }

    public void pr(Context context, boolean z) {
        com.byazt.ry.pr.hw(true);
        c cVar = (c) com.byazt.zs.uc.pr("app_process");
        if (pr(context) || (!cVar.pr() && z)) {
            fw.pr().pr(this.hn, context).x();
            fw.pr().pr(this.hn, context).pr();
        }
        if (!cVar.pr()) {
            return;
        }
        fw.pr().pr(this.hn, context).x();
        fw.pr().pr(this.hn, context).pr();
    }

    private static boolean pr(Context context) {
        String strHw = ((c) com.byazt.zs.uc.pr("app_process")).hw();
        if (strHw != null) {
            return strHw.endsWith(":push") || strHw.endsWith(":pushservice");
        }
        return false;
    }

    public k pr() {
        return this.pr;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 1049, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    public static final class pr {
        public Bundle fw;
        public Set<String> uc;
        public com.byazt.dqk.pr zo;
        public boolean x = true;
        public final List<aj> c = new ArrayList();
        public int pr = 10000;
        public int hw = 10000;
        public int hn = 10000;

        public pr pr(long j, TimeUnit timeUnit) {
            this.pr = pr("timeout", j, timeUnit);
            return this;
        }

        public pr hw(long j, TimeUnit timeUnit) {
            this.hw = pr("timeout", j, timeUnit);
            return this;
        }

        public pr hn(long j, TimeUnit timeUnit) {
            this.hn = pr("timeout", j, timeUnit);
            return this;
        }

        public pr pr(boolean z) {
            this.x = z;
            return this;
        }

        public pr pr(aj ajVar) {
            this.c.add(ajVar);
            return this;
        }

        public pr pr(Set<String> set) {
            this.uc = set;
            return this;
        }

        private static int pr(String str, long j, TimeUnit timeUnit) {
            if (j < 0) {
                throw new IllegalArgumentException(str + " < 0");
            }
            if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            }
            long millis = timeUnit.toMillis(j);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException(str + " too large.");
            }
            if (millis == 0 && j > 0) {
                throw new IllegalArgumentException(str + " too small.");
            }
            return (int) millis;
        }

        public hw pr() {
            return new hw(this);
        }
    }
}
