package com.byazt.nzn;

import android.os.Bundle;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_SEI_ONCE, 250})
public class k extends zo implements Cloneable {
    public static final List<m> zo = com.byazt.qm.vk.pr(m.HTTP_2, m.HTTP_1_1);
    public List<m> aj;
    public TimeUnit c;
    public TimeUnit fw;
    public TimeUnit hn;
    public long hw;
    public List<aj> pr;
    public long uc;
    public Set<String> vk;
    public com.byazt.dqk.pr w;
    public long x;

    public k() {
        this(new pr());
    }

    public k(pr prVar) {
        this.hw = prVar.hn;
        this.x = prVar.c;
        this.uc = prVar.fw;
        this.hn = prVar.x;
        this.c = prVar.uc;
        this.fw = prVar.zo;
        this.pr = prVar.pr;
        this.aj = prVar.aj;
        this.vk = prVar.vk;
        this.w = prVar.hw;
    }

    public x pr() {
        return null;
    }

    public hw pr(g gVar) {
        return null;
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_SEI_ONCE, 785})
    public static final class pr {
        public List<m> aj;
        public long c;
        public long fw;
        public long hn;
        public com.byazt.dqk.pr hw;
        public final List<aj> pr;
        public TimeUnit uc;
        public Set<String> vk;
        public Bundle w;
        public TimeUnit x;
        public TimeUnit zo;

        public pr() {
            this.pr = new ArrayList();
            this.hn = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.x = TimeUnit.MILLISECONDS;
            this.c = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.uc = TimeUnit.MILLISECONDS;
            this.fw = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.zo = TimeUnit.MILLISECONDS;
        }

        public pr(String str) {
            this.pr = new ArrayList();
            this.hn = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.x = TimeUnit.MILLISECONDS;
            this.c = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.uc = TimeUnit.MILLISECONDS;
            this.fw = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.zo = TimeUnit.MILLISECONDS;
            this.aj = k.zo;
        }

        public pr(k kVar) {
            this.pr = new ArrayList();
            this.hn = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.x = TimeUnit.MILLISECONDS;
            this.c = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.uc = TimeUnit.MILLISECONDS;
            this.fw = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            this.zo = TimeUnit.MILLISECONDS;
            this.hn = kVar.hw;
            this.x = kVar.hn;
            this.c = kVar.x;
            this.uc = kVar.c;
            this.fw = kVar.uc;
            this.zo = kVar.fw;
            this.aj = kVar.aj;
            this.vk = kVar.vk;
        }

        public pr pr(long j, TimeUnit timeUnit) {
            this.hn = j;
            this.x = timeUnit;
            return this;
        }

        public pr hw(long j, TimeUnit timeUnit) {
            this.c = j;
            this.uc = timeUnit;
            return this;
        }

        public pr hn(long j, TimeUnit timeUnit) {
            this.fw = j;
            this.zo = timeUnit;
            return this;
        }

        public pr pr(com.byazt.dqk.pr prVar) {
            this.hw = prVar;
            return this;
        }

        public pr pr(aj ajVar) {
            this.pr.add(ajVar);
            return this;
        }

        public pr pr(Set<String> set) {
            this.vk = set;
            return this;
        }

        public pr pr(List<m> list) {
            ArrayList arrayList = new ArrayList(list);
            if (!arrayList.contains(m.HTTP_1_1)) {
                throw new IllegalArgumentException("protocols doesn't contain http/1.1: ".concat(String.valueOf(arrayList)));
            }
            if (arrayList.contains(m.HTTP_1_0)) {
                throw new IllegalArgumentException("protocols must not contain http/1.0: ".concat(String.valueOf(arrayList)));
            }
            if (arrayList.contains(null)) {
                throw new IllegalArgumentException("protocols must not contain null");
            }
            arrayList.remove(m.SPDY_3);
            this.aj = Collections.unmodifiableList(arrayList);
            return this;
        }

        public pr pr(Bundle bundle) {
            this.w = bundle;
            return this;
        }

        public k pr() {
            if (com.byazt.qr.pr.pr().hw()) {
                return com.byazt.qr.pr.hw(this);
            }
            return com.byazt.qr.pr.pr(this);
        }
    }

    public pr hw() {
        return new pr(this);
    }
}
