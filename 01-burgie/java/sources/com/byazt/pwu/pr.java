package com.byazt.pwu;

import android.support.v4.internal.view.SupportMenu;
import com.mar.sdk.MARCode;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1002, 37})
public class pr implements aj {
    public int aj;
    public int[] c;
    public boolean fw;
    public int g;
    public int ho;
    public x hw;
    public int[] k;
    public int m;
    public int vk;
    public int w;
    public uc x;
    public int zo;
    public boolean hn = false;
    public C0166pr uc = new C0166pr();

    public pr() {
        fw();
    }

    public void pr(InputStream inputStream) {
        pr();
        if (inputStream != null) {
            this.hw = new x(inputStream, false);
        }
    }

    public void pr() {
        if (this.hn) {
            this.hn = false;
            this.hw.pr();
            this.hw = null;
            this.x = null;
            this.c = null;
            this.uc.pr();
            fw();
        }
    }

    public int hw() throws zo, IOException {
        if (this.hw == null) {
            throw new zo("Parser is not opened.", this, null);
        }
        try {
            zo();
            return this.zo;
        } catch (IOException e) {
            pr();
            throw e;
        }
    }

    @Override // com.byazt.pwu.fw
    public int hn() {
        return this.aj;
    }

    @Override // com.byazt.pwu.fw
    public String x() {
        return "XML line #" + hn();
    }

    public int c() {
        if (this.zo != 2) {
            return -1;
        }
        return this.k.length / 5;
    }

    public String pr(int i) {
        int i2 = this.k[c(i) + 1];
        return i2 == -1 ? "" : this.x.pr(i2);
    }

    public int hw(int i) {
        return this.k[c(i) + 3];
    }

    public int hn(int i) {
        return this.k[c(i) + 4];
    }

    public String x(int i) {
        int iC = c(i);
        int[] iArr = this.k;
        if (iArr[iC + 3] == 3) {
            return this.x.pr(iArr[iC + 2]);
        }
        return "";
    }

    @Override // com.byazt.pwu.fw
    public int uc() {
        return -1;
    }

    private final int c(int i) {
        if (this.zo != 2) {
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        int i2 = i * 5;
        if (i2 >= this.k.length) {
            throw new IndexOutOfBoundsException("Invalid attribute index (" + i + ").");
        }
        return i2;
    }

    private final void fw() {
        this.zo = -1;
        this.aj = -1;
        this.vk = -1;
        this.w = -1;
        this.k = null;
        this.m = -1;
        this.g = -1;
        this.ho = -1;
    }

    private final void zo() throws IOException {
        int iHw;
        if (this.x == null) {
            hw.pr(this.hw, 524291);
            this.hw.hn();
            this.x = uc.pr(this.hw);
            this.uc.c();
            this.hn = true;
        }
        int i = this.zo;
        if (i != 1) {
            fw();
            while (true) {
                if (this.fw) {
                    this.fw = false;
                    this.uc.uc();
                }
                int i2 = 3;
                if (i == 3 && this.uc.x() == 1 && this.uc.hw() == 0) {
                    this.zo = 1;
                    return;
                }
                if (i == 0) {
                    iHw = 1048834;
                } else {
                    iHw = this.hw.hw();
                }
                if (iHw == 524672) {
                    int iHw2 = this.hw.hw();
                    if (iHw2 >= 8 && iHw2 % 4 == 0) {
                        this.c = this.hw.hw((iHw2 / 4) - 2);
                    } else {
                        throw new IOException("Invalid resource ids size (" + iHw2 + ").");
                    }
                } else {
                    if (iHw < 1048832 || iHw > 1048836) {
                        throw new IOException("Invalid chunk type (" + iHw + ").");
                    }
                    if (iHw == 1048834 && i == -1) {
                        this.zo = 0;
                        return;
                    }
                    this.hw.hn();
                    int iHw3 = this.hw.hw();
                    this.hw.hn();
                    if (iHw == 1048832 || iHw == 1048833) {
                        if (iHw == 1048832) {
                            this.uc.pr(this.hw.hw(), this.hw.hw());
                        } else {
                            this.hw.hn();
                            this.hw.hn();
                            this.uc.hn();
                        }
                    } else {
                        this.aj = iHw3;
                        if (iHw == 1048834) {
                            this.w = this.hw.hw();
                            this.vk = this.hw.hw();
                            this.hw.hn();
                            int iHw4 = this.hw.hw();
                            this.m = (iHw4 >>> 16) - 1;
                            int i3 = iHw4 & SupportMenu.USER_MASK;
                            int iHw5 = this.hw.hw();
                            this.g = iHw5;
                            this.ho = (iHw5 >>> 16) - 1;
                            this.g = (65535 & iHw5) - 1;
                            this.k = this.hw.hw(i3 * 5);
                            while (true) {
                                int[] iArr = this.k;
                                if (i2 < iArr.length) {
                                    iArr[i2] = iArr[i2] >>> 24;
                                    i2 += 5;
                                } else {
                                    this.uc.c();
                                    this.zo = 2;
                                    return;
                                }
                            }
                        } else {
                            if (iHw == 1048835) {
                                this.w = this.hw.hw();
                                this.vk = this.hw.hw();
                                this.zo = 3;
                                this.fw = true;
                                return;
                            }
                            if (iHw == 1048836) {
                                this.vk = this.hw.hw();
                                this.hw.hn();
                                this.hw.hn();
                                this.zo = 4;
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.byazt.pwu.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 1002, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    private static final class C0166pr {
        public int hn;
        public int hw;
        public int[] pr = new int[32];

        public final void pr() {
            this.hw = 0;
            this.hn = 0;
        }

        public final int hw() {
            int i = this.hw;
            if (i == 0) {
                return 0;
            }
            return this.pr[i - 1];
        }

        public final void pr(int i, int i2) {
            if (this.hn == 0) {
                c();
            }
            pr(2);
            int i3 = this.hw;
            int i4 = i3 - 1;
            int[] iArr = this.pr;
            int i5 = iArr[i4];
            int i6 = (i4 - 1) - (i5 * 2);
            int i7 = i5 + 1;
            iArr[i6] = i7;
            iArr[i4] = i;
            iArr[i4 + 1] = i2;
            iArr[i4 + 2] = i7;
            this.hw = i3 + 2;
        }

        public final boolean hn() {
            int i;
            int[] iArr;
            int i2;
            int i3 = this.hw;
            if (i3 == 0 || (i2 = (iArr = this.pr)[(i = i3 - 1)]) == 0) {
                return false;
            }
            int i4 = i2 - 1;
            int i5 = i - 2;
            iArr[i5] = i4;
            iArr[i5 - ((i4 * 2) + 1)] = i4;
            this.hw = i3 - 2;
            return true;
        }

        public final int x() {
            return this.hn;
        }

        public final void c() {
            pr(2);
            int i = this.hw;
            int[] iArr = this.pr;
            iArr[i] = 0;
            iArr[i + 1] = 0;
            this.hw = i + 2;
            this.hn++;
        }

        public final void uc() {
            int i = this.hw;
            if (i != 0) {
                int i2 = i - 1;
                int i3 = this.pr[i2] * 2;
                if ((i2 - 1) - i3 != 0) {
                    this.hw = i - (i3 + 2);
                    this.hn--;
                }
            }
        }

        private void pr(int i) {
            int[] iArr = this.pr;
            int length = iArr.length;
            int i2 = this.hw;
            int i3 = length - i2;
            if (i3 <= i) {
                int[] iArr2 = new int[(iArr.length + i3) * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i2);
                this.pr = iArr2;
            }
        }
    }
}
