package com.byazt.ezh;

import androidx.core.internal.view.SupportMenu;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 166, 19})
public class n {
    public w cp;
    public qg fs;
    public int[] rv;
    public int w;
    public boolean x;
    public boolean tj = false;
    public final s d = new s();
    public int n = 0;
    public int qg = 1;
    public int s = 2;
    public int q = 3;
    public int l = 4;

    public n() {
        q();
    }

    public void n(InputStream inputStream) {
        n();
        if (inputStream != null) {
            this.fs = new qg(inputStream);
        }
    }

    public void n() {
        if (this.tj) {
            this.tj = false;
            this.fs.n();
            this.cp = null;
            this.fs = null;
            this.d.n();
            q();
        }
    }

    public int qg() throws IOException {
        try {
            if (this.fs != null) {
                l();
                return this.w;
            }
            throw new IOException("Parser is not opened.");
        } catch (IOException e) {
            n();
            throw e;
        }
    }

    public int s() {
        if (this.w != 2) {
            return -1;
        }
        return this.rv.length / 5;
    }

    public String n(int i) {
        int i2 = this.rv[l(i) + 1];
        return i2 == -1 ? "" : this.cp.n(i2);
    }

    public int qg(int i) {
        return this.rv[l(i) + 3];
    }

    public int s(int i) {
        return this.rv[l(i) + 4];
    }

    public String q(int i) {
        int iL = l(i);
        int[] iArr = this.rv;
        if (iArr[iL + 3] != 3) {
            return "";
        }
        return this.cp.n(iArr[iL + 2]);
    }

    private int l(int i) {
        if (this.w != 2) {
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        int i2 = i * 5;
        if (i2 < this.rv.length) {
            return i2;
        }
        throw new IndexOutOfBoundsException("Invalid attribute index (" + i + ").");
    }

    private void q() {
        this.rv = null;
        this.w = -1;
    }

    private void l() throws IOException {
        if (this.cp == null) {
            this.fs.qg(524291);
            this.fs.s();
            this.cp = w.n(this.fs);
            this.d.l();
            this.tj = true;
        }
        int i = this.w;
        if (i == this.qg) {
            return;
        }
        q();
        while (true) {
            if (this.x) {
                this.x = false;
                this.d.w();
            }
            if (i == this.q && this.d.q() == 1 && this.d.qg() == 0) {
                this.w = this.qg;
                return;
            }
            int iQg = i == this.n ? 1048834 : this.fs.qg();
            if (iQg == 524672) {
                int iQg2 = this.fs.qg();
                if (iQg2 < 8 || iQg2 % 4 != 0) {
                    throw new IOException("Invalid resource ids size (" + iQg2 + ").");
                }
                this.fs.n((iQg2 / 4) - 2);
            } else {
                if (iQg < 1048832 || iQg > 1048836) {
                    throw new IOException("Invalid chunk type (" + iQg + ").");
                }
                if (iQg == 1048834 && i == -1) {
                    this.w = this.n;
                    return;
                }
                this.fs.s();
                this.fs.qg();
                this.fs.s();
                if (iQg == 1048832 || iQg == 1048833) {
                    if (iQg == 1048832) {
                        this.d.n(this.fs.qg(), this.fs.qg());
                    } else {
                        this.fs.s();
                        this.fs.s();
                        this.d.s();
                    }
                } else if (iQg == 1048834) {
                    this.fs.qg();
                    this.fs.qg();
                    this.fs.s();
                    int iQg3 = this.fs.qg() & SupportMenu.USER_MASK;
                    this.fs.qg();
                    this.rv = this.fs.n(iQg3 * 5);
                    int i2 = 3;
                    while (true) {
                        int[] iArr = this.rv;
                        if (i2 < iArr.length) {
                            iArr[i2] = iArr[i2] >>> 24;
                            i2 += 5;
                        } else {
                            this.d.l();
                            this.w = this.s;
                            return;
                        }
                    }
                } else {
                    if (iQg == 1048835) {
                        this.fs.qg();
                        this.fs.qg();
                        this.w = this.q;
                        this.x = true;
                        return;
                    }
                    if (iQg == 1048836) {
                        this.fs.qg();
                        this.fs.s();
                        this.fs.s();
                        this.w = this.l;
                        return;
                    }
                }
            }
        }
    }
}
