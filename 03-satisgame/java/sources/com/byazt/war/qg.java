package com.byazt.war;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 994, 26})
public class qg implements rv {
    public byte[] n;
    public com.byazt.si.x qg;

    @Override // com.byazt.war.rv
    public String n() {
        return "image_type";
    }

    public qg(byte[] bArr, com.byazt.si.x xVar) {
        this.n = bArr;
        this.qg = xVar;
    }

    @Override // com.byazt.war.rv
    public void n(com.byazt.gxb.s sVar) {
        rv fsVar;
        int iOa = sVar.oa();
        sVar.n(this.n.length);
        if (iOa != 2) {
            if (iOa == 3) {
                byte[] bArr = this.n;
                fsVar = new sz(bArr, bArr, this.qg, com.byazt.wvr.n.qg(bArr));
            } else {
                boolean zQg = com.byazt.wvr.n.qg(this.n);
                if (zQg) {
                    byte[] bArr2 = this.n;
                    fsVar = new sz(bArr2, bArr2, this.qg, zQg);
                } else if (com.byazt.wvr.n.n(this.n)) {
                    fsVar = new l(this.n, this.qg);
                } else {
                    byte[] bArr3 = this.n;
                    fsVar = new sz(bArr3, bArr3, this.qg, zQg);
                }
            }
        } else if (com.byazt.wvr.n.n(this.n)) {
            fsVar = new l(this.n, this.qg);
        } else if (this.qg == null && !sVar.hd()) {
            fsVar = new cp();
        } else {
            fsVar = new fs(1001, "not image format", null);
        }
        sVar.n(fsVar);
    }
}
