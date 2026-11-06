package com.byazt.hr;

import android.graphics.Rect;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 180, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public abstract class zo {
    public int hn;
    public final Rect hw;
    public final RecyclerView.aj pr;

    public abstract int c();

    public abstract int c(View view);

    public abstract int fw();

    public abstract int hn();

    public abstract int hn(View view);

    public abstract int hw(View view);

    public abstract int pr(View view);

    public abstract void pr(int i);

    public abstract int uc();

    public abstract int uc(View view);

    public abstract int x();

    public abstract int x(View view);

    public abstract int zo();

    private zo(RecyclerView.aj ajVar) {
        this.hn = Integer.MIN_VALUE;
        this.hw = new Rect();
        this.pr = ajVar;
    }

    public void pr() {
        this.hn = uc();
    }

    public int hw() {
        if (Integer.MIN_VALUE == this.hn) {
            return 0;
        }
        return uc() - this.hn;
    }

    public static zo pr(RecyclerView.aj ajVar, int i) {
        switch (i) {
            case 0:
                return pr(ajVar);
            case 1:
                return hw(ajVar);
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }

    public static zo pr(RecyclerView.aj ajVar) {
        return new zo(ajVar) { // from class: com.byazt.hr.zo.1
            @Override // com.byazt.hr.zo
            public int x() {
                return this.pr.ny() - this.pr.b();
            }

            @Override // com.byazt.hr.zo
            public int c() {
                return this.pr.ny();
            }

            @Override // com.byazt.hr.zo
            public void pr(int i) {
                this.pr.aj(i);
            }

            @Override // com.byazt.hr.zo
            public int hn() {
                return this.pr.rc();
            }

            @Override // com.byazt.hr.zo
            public int c(View view) {
                RecyclerView.vk vkVar = (RecyclerView.vk) view.getLayoutParams();
                return this.pr.c(view) + vkVar.leftMargin + vkVar.rightMargin;
            }

            @Override // com.byazt.hr.zo
            public int uc(View view) {
                RecyclerView.vk vkVar = (RecyclerView.vk) view.getLayoutParams();
                return this.pr.uc(view) + vkVar.topMargin + vkVar.bottomMargin;
            }

            @Override // com.byazt.hr.zo
            public int hw(View view) {
                return this.pr.aj(view) + ((RecyclerView.vk) view.getLayoutParams()).rightMargin;
            }

            @Override // com.byazt.hr.zo
            public int pr(View view) {
                return this.pr.fw(view) - ((RecyclerView.vk) view.getLayoutParams()).leftMargin;
            }

            @Override // com.byazt.hr.zo
            public int hn(View view) {
                this.pr.pr(view, true, this.hw);
                return this.hw.right;
            }

            @Override // com.byazt.hr.zo
            public int x(View view) {
                this.pr.pr(view, true, this.hw);
                return this.hw.left;
            }

            @Override // com.byazt.hr.zo
            public int uc() {
                return (this.pr.ny() - this.pr.rc()) - this.pr.b();
            }

            @Override // com.byazt.hr.zo
            public int fw() {
                return this.pr.b();
            }

            @Override // com.byazt.hr.zo
            public int zo() {
                return this.pr.a();
            }
        };
    }

    public static zo hw(RecyclerView.aj ajVar) {
        return new zo(ajVar) { // from class: com.byazt.hr.zo.2
            @Override // com.byazt.hr.zo
            public int x() {
                return this.pr.fo() - this.pr.iu();
            }

            @Override // com.byazt.hr.zo
            public int c() {
                return this.pr.fo();
            }

            @Override // com.byazt.hr.zo
            public void pr(int i) {
                this.pr.vk(i);
            }

            @Override // com.byazt.hr.zo
            public int hn() {
                return this.pr.z();
            }

            @Override // com.byazt.hr.zo
            public int c(View view) {
                RecyclerView.vk vkVar = (RecyclerView.vk) view.getLayoutParams();
                return this.pr.uc(view) + vkVar.topMargin + vkVar.bottomMargin;
            }

            @Override // com.byazt.hr.zo
            public int uc(View view) {
                RecyclerView.vk vkVar = (RecyclerView.vk) view.getLayoutParams();
                return this.pr.c(view) + vkVar.leftMargin + vkVar.rightMargin;
            }

            @Override // com.byazt.hr.zo
            public int hw(View view) {
                return this.pr.vk(view) + ((RecyclerView.vk) view.getLayoutParams()).bottomMargin;
            }

            @Override // com.byazt.hr.zo
            public int pr(View view) {
                return this.pr.zo(view) - ((RecyclerView.vk) view.getLayoutParams()).topMargin;
            }

            @Override // com.byazt.hr.zo
            public int hn(View view) {
                this.pr.pr(view, true, this.hw);
                return this.hw.bottom;
            }

            @Override // com.byazt.hr.zo
            public int x(View view) {
                this.pr.pr(view, true, this.hw);
                return this.hw.top;
            }

            @Override // com.byazt.hr.zo
            public int uc() {
                return (this.pr.fo() - this.pr.z()) - this.pr.iu();
            }

            @Override // com.byazt.hr.zo
            public int fw() {
                return this.pr.iu();
            }

            @Override // com.byazt.hr.zo
            public int zo() {
                return this.pr.cz();
            }
        };
    }
}
