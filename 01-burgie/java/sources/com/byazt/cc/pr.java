package com.byazt.cc;

import android.support.v4.internal.view.SupportMenu;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 762, 37})
public class pr {
    public int[] aj;
    public boolean fw;
    public int uc;
    public uc w;
    public hw zo;
    public boolean vk = false;
    public final hn k = new hn();
    public int pr = 0;
    public int hw = 1;
    public int hn = 2;
    public int x = 3;
    public int c = 4;

    public pr() {
        x();
    }

    public void pr(InputStream inputStream) {
        pr();
        if (inputStream != null) {
            this.zo = new hw(inputStream);
        }
    }

    public void pr() {
        if (this.vk) {
            this.vk = false;
            this.zo.pr();
            this.w = null;
            this.zo = null;
            this.k.pr();
            x();
        }
    }

    public int hw() throws IOException {
        try {
            if (this.zo != null) {
                c();
                return this.uc;
            }
            throw new IOException("Parser is not opened.");
        } catch (IOException e) {
            pr();
            throw e;
        }
    }

    public int hn() {
        if (this.uc != 2) {
            return -1;
        }
        return this.aj.length / 5;
    }

    public String pr(int i) {
        int i2 = this.aj[c(i) + 1];
        return i2 == -1 ? "" : this.w.pr(i2);
    }

    public int hw(int i) {
        return this.aj[c(i) + 3];
    }

    public int hn(int i) {
        return this.aj[c(i) + 4];
    }

    public String x(int i) {
        int iC = c(i);
        int[] iArr = this.aj;
        if (iArr[iC + 3] == 3) {
            return this.w.pr(iArr[iC + 2]);
        }
        return "";
    }

    private int c(int i) {
        if (this.uc != 2) {
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        int i2 = i * 5;
        if (i2 >= this.aj.length) {
            throw new IndexOutOfBoundsException("Invalid attribute index (" + i + ").");
        }
        return i2;
    }

    private void x() {
        this.aj = null;
        this.uc = -1;
    }

    private void c() throws IOException {
        int iHw;
        if (this.w == null) {
            this.zo.hw(524291);
            this.zo.hn();
            this.w = uc.pr(this.zo);
            this.k.c();
            this.vk = true;
        }
        int i = this.uc;
        if (i == this.hw) {
            return;
        }
        x();
        while (true) {
            if (this.fw) {
                this.fw = false;
                this.k.uc();
            }
            if (i == this.x && this.k.x() == 1 && this.k.hw() == 0) {
                this.uc = this.hw;
                return;
            }
            if (i == this.pr) {
                iHw = 1048834;
            } else {
                iHw = this.zo.hw();
            }
            if (iHw == 524672) {
                int iHw2 = this.zo.hw();
                if (iHw2 < 8 || iHw2 % 4 != 0) {
                    throw new IOException("Invalid resource ids size (" + iHw2 + ").");
                }
                this.zo.pr((iHw2 / 4) - 2);
            } else {
                if (iHw < 1048832 || iHw > 1048836) {
                    throw new IOException("Invalid chunk type (" + iHw + ").");
                }
                if (iHw == 1048834 && i == -1) {
                    this.uc = this.pr;
                    return;
                }
                this.zo.hn();
                this.zo.hw();
                this.zo.hn();
                if (iHw == 1048832 || iHw == 1048833) {
                    if (iHw == 1048832) {
                        this.k.pr(this.zo.hw(), this.zo.hw());
                    } else {
                        this.zo.hn();
                        this.zo.hn();
                        this.k.hn();
                    }
                } else if (iHw == 1048834) {
                    this.zo.hw();
                    this.zo.hw();
                    this.zo.hn();
                    int iHw3 = this.zo.hw() & SupportMenu.USER_MASK;
                    this.zo.hw();
                    this.aj = this.zo.pr(iHw3 * 5);
                    int i2 = 3;
                    while (true) {
                        int[] iArr = this.aj;
                        if (i2 < iArr.length) {
                            iArr[i2] = iArr[i2] >>> 24;
                            i2 += 5;
                        } else {
                            this.k.c();
                            this.uc = this.hn;
                            return;
                        }
                    }
                } else {
                    if (iHw == 1048835) {
                        this.zo.hw();
                        this.zo.hw();
                        this.uc = this.x;
                        this.fw = true;
                        return;
                    }
                    if (iHw == 1048836) {
                        this.zo.hw();
                        this.zo.hn();
                        this.zo.hn();
                        this.uc = this.c;
                        return;
                    }
                }
            }
        }
    }
}
