package com.byazt.wgd;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1090, 13})
public class hw implements aj {
    public com.byazt.ld.fw hw;
    public byte[] pr;

    public hw(byte[] bArr, com.byazt.ld.fw fwVar) {
        this.pr = bArr;
        this.hw = fwVar;
    }

    @Override // com.byazt.wgd.aj
    public void pr(com.byazt.sl.hn hnVar) {
        aj zoVar;
        int iM = hnVar.m();
        hnVar.pr(this.pr.length);
        switch (iM) {
            case 2:
                if (com.byazt.cb.pr.pr(this.pr)) {
                    zoVar = new c(this.pr, this.hw);
                } else if (this.hw == null && !hnVar.yb()) {
                    zoVar = new w();
                } else {
                    zoVar = new zo(1001, "not image format", null);
                }
                break;
            case 3:
                byte[] bArr = this.pr;
                zoVar = new g(bArr, bArr, this.hw, com.byazt.cb.pr.hw(bArr));
                break;
            default:
                boolean zHw = com.byazt.cb.pr.hw(this.pr);
                if (zHw) {
                    byte[] bArr2 = this.pr;
                    zoVar = new g(bArr2, bArr2, this.hw, zHw);
                } else if (com.byazt.cb.pr.pr(this.pr)) {
                    zoVar = new c(this.pr, this.hw);
                } else {
                    byte[] bArr3 = this.pr;
                    zoVar = new g(bArr3, bArr3, this.hw, zHw);
                }
                break;
        }
        hnVar.pr(zoVar);
    }

    @Override // com.byazt.wgd.aj
    public String pr() {
        return "image_type";
    }
}
