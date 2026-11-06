package com.byazt.k;

import androidx.core.internal.view.SupportMenu;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 210, 19})
public class n implements rv {
    public int cp;
    public int[] d;
    public int fs;
    public int k;
    public int[] l;
    public int oa;
    public w q;
    public q qg;
    public int rv;
    public int sz;
    public int tj;
    public boolean x;
    public boolean s = false;
    public C0228n w = new C0228n();

    @Override // com.byazt.k.x
    public int w() {
        return -1;
    }

    public n() {
        x();
    }

    public void n(InputStream inputStream) {
        n();
        if (inputStream != null) {
            this.qg = new q(inputStream, false);
        }
    }

    public void n() {
        if (this.s) {
            this.s = false;
            this.qg.n();
            this.qg = null;
            this.q = null;
            this.l = null;
            this.w.n();
            x();
        }
    }

    public int qg() throws IOException, fs {
        if (this.qg == null) {
            throw new fs("Parser is not opened.", this, null);
        }
        try {
            fs();
            return this.fs;
        } catch (IOException e) {
            n();
            throw e;
        }
    }

    @Override // com.byazt.k.x
    public int s() {
        return this.rv;
    }

    @Override // com.byazt.k.x
    public String q() {
        return "XML line #" + s();
    }

    public int l() {
        if (this.fs != 2) {
            return -1;
        }
        return this.d.length / 5;
    }

    public String n(int i) {
        int i2 = this.d[l(i) + 1];
        return i2 == -1 ? "" : this.q.n(i2);
    }

    public int qg(int i) {
        return this.d[l(i) + 3];
    }

    public int s(int i) {
        return this.d[l(i) + 4];
    }

    public String q(int i) {
        int iL = l(i);
        int[] iArr = this.d;
        if (iArr[iL + 3] != 3) {
            return "";
        }
        return this.q.n(iArr[iL + 2]);
    }

    private final int l(int i) {
        if (this.fs != 2) {
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        int i2 = i * 5;
        if (i2 < this.d.length) {
            return i2;
        }
        throw new IndexOutOfBoundsException("Invalid attribute index (" + i + ").");
    }

    private final void x() {
        this.fs = -1;
        this.rv = -1;
        this.tj = -1;
        this.cp = -1;
        this.d = null;
        this.oa = -1;
        this.sz = -1;
        this.k = -1;
    }

    private final void fs() throws IOException {
        if (this.q == null) {
            qg.n(this.qg, 524291);
            this.qg.s();
            this.q = w.n(this.qg);
            this.w.l();
            this.s = true;
        }
        int i = this.fs;
        if (i == 1) {
            return;
        }
        x();
        while (true) {
            if (this.x) {
                this.x = false;
                this.w.w();
            }
            int i2 = 3;
            if (i == 3 && this.w.q() == 1 && this.w.qg() == 0) {
                this.fs = 1;
                return;
            }
            int iQg = i == 0 ? 1048834 : this.qg.qg();
            if (iQg == 524672) {
                int iQg2 = this.qg.qg();
                if (iQg2 >= 8 && iQg2 % 4 == 0) {
                    this.l = this.qg.qg((iQg2 / 4) - 2);
                } else {
                    throw new IOException("Invalid resource ids size (" + iQg2 + ").");
                }
            } else {
                if (iQg < 1048832 || iQg > 1048836) {
                    throw new IOException("Invalid chunk type (" + iQg + ").");
                }
                if (iQg == 1048834 && i == -1) {
                    this.fs = 0;
                    return;
                }
                this.qg.s();
                int iQg3 = this.qg.qg();
                this.qg.s();
                if (iQg != 1048832 && iQg != 1048833) {
                    this.rv = iQg3;
                    if (iQg == 1048834) {
                        this.cp = this.qg.qg();
                        this.tj = this.qg.qg();
                        this.qg.s();
                        int iQg4 = this.qg.qg();
                        this.oa = (iQg4 >>> 16) - 1;
                        int i3 = iQg4 & SupportMenu.USER_MASK;
                        int iQg5 = this.qg.qg();
                        this.k = (iQg5 >>> 16) - 1;
                        this.sz = (65535 & iQg5) - 1;
                        this.d = this.qg.qg(i3 * 5);
                        while (true) {
                            int[] iArr = this.d;
                            if (i2 < iArr.length) {
                                iArr[i2] = iArr[i2] >>> 24;
                                i2 += 5;
                            } else {
                                this.w.l();
                                this.fs = 2;
                                return;
                            }
                        }
                    } else {
                        if (iQg == 1048835) {
                            this.cp = this.qg.qg();
                            this.tj = this.qg.qg();
                            this.fs = 3;
                            this.x = true;
                            return;
                        }
                        if (iQg == 1048836) {
                            this.tj = this.qg.qg();
                            this.qg.s();
                            this.qg.s();
                            this.fs = 4;
                            return;
                        }
                    }
                } else if (iQg == 1048832) {
                    this.w.n(this.qg.qg(), this.qg.qg());
                } else {
                    this.qg.s();
                    this.qg.s();
                    this.w.s();
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.byazt.k.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 210, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    private static final class C0228n {
        public int[] n = new int[32];
        public int qg;
        public int s;

        public final void n() {
            this.qg = 0;
            this.s = 0;
        }

        public final int qg() {
            int i = this.qg;
            if (i == 0) {
                return 0;
            }
            return this.n[i - 1];
        }

        public final void n(int i, int i2) {
            if (this.s == 0) {
                l();
            }
            n(2);
            int i3 = this.qg;
            int i4 = i3 - 1;
            int[] iArr = this.n;
            int i5 = iArr[i4];
            int i6 = (i4 - 1) - (i5 * 2);
            int i7 = i5 + 1;
            iArr[i6] = i7;
            iArr[i4] = i;
            iArr[i4 + 1] = i2;
            iArr[i4 + 2] = i7;
            this.qg = i3 + 2;
        }

        public final boolean s() {
            int i;
            int[] iArr;
            int i2;
            int i3 = this.qg;
            if (i3 == 0 || (i2 = (iArr = this.n)[(i = i3 - 1)]) == 0) {
                return false;
            }
            int i4 = i2 - 1;
            int i5 = i - 2;
            iArr[i5] = i4;
            iArr[i5 - ((i4 * 2) + 1)] = i4;
            this.qg = i3 - 2;
            return true;
        }

        public final int q() {
            return this.s;
        }

        public final void l() {
            n(2);
            int i = this.qg;
            int[] iArr = this.n;
            iArr[i] = 0;
            iArr[i + 1] = 0;
            this.qg = i + 2;
            this.s++;
        }

        public final void w() {
            int i = this.qg;
            if (i != 0) {
                int i2 = i - 1;
                int i3 = this.n[i2] * 2;
                if ((i2 - 1) - i3 != 0) {
                    this.qg = i - (i3 + 2);
                    this.s--;
                }
            }
        }

        private void n(int i) {
            int[] iArr = this.n;
            int length = iArr.length;
            int i2 = this.qg;
            int i3 = length - i2;
            if (i3 <= i) {
                int[] iArr2 = new int[(iArr.length + i3) * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i2);
                this.n = iArr2;
            }
        }
    }
}
