package com.byazt.cg;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPENED_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo {
    public final List<com.byazt.cz.pr<Float>> a;
    public final com.byazt.eqw.k aj;
    public final pr c;
    public final hw cz;
    public final com.byazt.ynb.pr fo;
    public final String fw;
    public final float g;
    public final String hn;
    public final float ho;
    public final com.byazt.dx.uc hw;
    public final int k;
    public final com.byazt.eqw.w lb;
    public final float m;
    public final float nt;
    public final boolean ny;
    public final List<com.byazt.ynb.hn> pr;
    public final com.byazt.eqw.hw qa;
    public final com.byazt.tx.vk rc;
    public final long uc;
    public final int vk;
    public final int w;
    public final long x;
    public final com.byazt.eqw.vk yb;
    public final List<com.byazt.ynb.zo> zo;

    public enum hw {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public enum pr {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    public zo(List<com.byazt.ynb.hn> list, com.byazt.dx.uc ucVar, String str, long j, pr prVar, long j2, String str2, List<com.byazt.ynb.zo> list2, com.byazt.eqw.k kVar, int i, int i2, int i3, float f, float f2, float f3, float f4, com.byazt.eqw.vk vkVar, com.byazt.eqw.w wVar, List<com.byazt.cz.pr<Float>> list3, hw hwVar, com.byazt.eqw.hw hwVar2, boolean z, com.byazt.ynb.pr prVar2, com.byazt.tx.vk vkVar2) {
        this.pr = list;
        this.hw = ucVar;
        this.hn = str;
        this.x = j;
        this.c = prVar;
        this.uc = j2;
        this.fw = str2;
        this.zo = list2;
        this.aj = kVar;
        this.vk = i;
        this.w = i2;
        this.k = i3;
        this.m = f;
        this.g = f2;
        this.ho = f3;
        this.nt = f4;
        this.yb = vkVar;
        this.lb = wVar;
        this.a = list3;
        this.cz = hwVar;
        this.qa = hwVar2;
        this.ny = z;
        this.fo = prVar2;
        this.rc = vkVar2;
    }

    public com.byazt.dx.uc pr() {
        return this.hw;
    }

    public float hw() {
        return this.m;
    }

    public float hn() {
        return this.g / this.hw.lb();
    }

    public List<com.byazt.cz.pr<Float>> x() {
        return this.a;
    }

    public long c() {
        return this.x;
    }

    public String uc() {
        return this.hn;
    }

    public String fw() {
        return this.fw;
    }

    public float zo() {
        return this.ho;
    }

    public float aj() {
        return this.nt;
    }

    public List<com.byazt.ynb.zo> vk() {
        return this.zo;
    }

    public pr w() {
        return this.c;
    }

    public hw k() {
        return this.cz;
    }

    public long m() {
        return this.uc;
    }

    public List<com.byazt.ynb.hn> g() {
        return this.pr;
    }

    public com.byazt.eqw.k ho() {
        return this.aj;
    }

    public int nt() {
        return this.k;
    }

    public int yb() {
        return this.w;
    }

    public int lb() {
        return this.vk;
    }

    public com.byazt.eqw.vk qa() {
        return this.yb;
    }

    public com.byazt.eqw.w a() {
        return this.lb;
    }

    public com.byazt.eqw.hw cz() {
        return this.qa;
    }

    public String toString() {
        return pr("");
    }

    public boolean ny() {
        return this.ny;
    }

    public com.byazt.ynb.pr fo() {
        return this.fo;
    }

    public com.byazt.tx.vk rc() {
        return this.rc;
    }

    public String pr(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(uc()).append("\n");
        zo zoVarPr = this.hw.pr(m());
        if (zoVarPr != null) {
            sb.append("\t\tParents: ").append(zoVarPr.uc());
            zo zoVarPr2 = this.hw.pr(zoVarPr.m());
            while (zoVarPr2 != null) {
                sb.append("->").append(zoVarPr2.uc());
                zoVarPr2 = this.hw.pr(zoVarPr2.m());
            }
            sb.append(str).append("\n");
        }
        if (!vk().isEmpty()) {
            sb.append(str).append("\tMasks: ").append(vk().size()).append("\n");
        }
        if (lb() != 0 && yb() != 0) {
            sb.append(str).append("\tBackground: ").append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(lb()), Integer.valueOf(yb()), Integer.valueOf(nt())));
        }
        if (!this.pr.isEmpty()) {
            sb.append(str).append("\tShapes:\n");
            Iterator<com.byazt.ynb.hn> it = this.pr.iterator();
            while (it.hasNext()) {
                sb.append(str).append("\t\t").append(it.next()).append("\n");
            }
        }
        return sb.toString();
    }
}
