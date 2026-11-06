package com.bykv.vk.openvk.component.video.ms.ms.xr;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.component.video.api.ah.d;
import com.bytedance.sdk.component.xr.ms.ao;
import com.bytedance.sdk.component.xr.ms.h;
import com.bytedance.sdk.component.xr.ms.sl;
import com.bytedance.sdk.component.xr.ms.u;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class xr {
    private File d;
    private File ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Context f58ms;
    private d xr;
    private volatile boolean ah = false;
    private final List<com.bykv.vk.openvk.component.video.api.ka.ms.InterfaceC0178ms> c = new ArrayList();
    private volatile boolean ab = false;

    public xr(Context context, d dVar) {
        this.d = null;
        this.ka = null;
        this.f58ms = context;
        this.xr = dVar;
        this.d = com.bykv.vk.openvk.component.video.ms.ka.ah.xr(dVar.ka(), dVar.h());
        this.ka = com.bykv.vk.openvk.component.video.ms.ka.ah.ah(dVar.ka(), dVar.h());
    }

    public void ms(com.bykv.vk.openvk.component.video.api.ka.ms.InterfaceC0178ms interfaceC0178ms) {
        if (this.ab) {
            synchronized (com.bykv.vk.openvk.component.video.api.ka.ms.InterfaceC0178ms.class) {
                this.c.add(interfaceC0178ms);
            }
            return;
        }
        this.c.add(interfaceC0178ms);
        if (xr()) {
            com.bykv.vk.openvk.component.video.api.c.ah.ms("VideoPreload", "Cache file is exist");
            this.xr.ny(1);
            ms(this.xr, 200);
            ah.ms(this.xr);
            return;
        }
        this.ab = true;
        this.xr.ny(0);
        ah();
    }

    private boolean xr() {
        if (this.ka.exists()) {
            return true;
        }
        if (!this.xr.zb()) {
            if (this.d.length() >= this.xr.c()) {
                return true;
            }
            if (this.xr.xr() > 0 && this.d.length() >= this.xr.xr()) {
                return true;
            }
        }
        return false;
    }

    private void ah() {
        sl.ms msVar;
        if (com.bykv.vk.openvk.component.video.api.ah.ah() != null) {
            msVar = com.bykv.vk.openvk.component.video.api.ah.ah().xr();
        } else {
            msVar = new sl.ms("v_preload");
        }
        msVar.ms(this.xr.y(), TimeUnit.MILLISECONDS).xr(this.xr.t(), TimeUnit.MILLISECONDS).ah(this.xr.nw(), TimeUnit.MILLISECONDS);
        sl slVarMs = msVar.ms();
        u.ms msVar2 = new u.ms();
        final long length = this.d.length();
        int iC = this.xr.c();
        boolean zZb = this.xr.zb();
        int iXr = this.xr.xr();
        if (iXr > 0) {
            if (iXr >= this.xr.sl()) {
                zZb = true;
            } else {
                iC = iXr;
            }
        }
        if (zZb) {
            msVar2.ms("RANGE", "bytes=" + length + "-").ms(this.xr.ao()).ms().xr();
        } else {
            msVar2.ms("RANGE", "bytes=" + length + "-" + iC).ms(this.xr.ao()).ms().xr();
        }
        slVarMs.ms(msVar2.xr()).ms(new com.bytedance.sdk.component.xr.ms.ah() { // from class: com.bykv.vk.openvk.component.video.ms.ms.xr.xr.1
            @Override // com.bytedance.sdk.component.xr.ms.ah
            public void onFailure(com.bytedance.sdk.component.xr.ms.xr xrVar, IOException iOException) {
                xr xrVar2 = xr.this;
                xrVar2.ms(xrVar2.xr, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE, iOException.getMessage());
                ah.ms(xr.this.xr);
            }

            /* JADX WARN: Code duplicated, block: B:81:0x0248 A[Catch: all -> 0x0292, TryCatch #2 {all -> 0x0292, blocks: (B:79:0x0238, B:81:0x0248, B:82:0x024c), top: B:91:0x0238 }] */
            @Override // com.bytedance.sdk.component.xr.ms.ah
            public void onResponse(com.bytedance.sdk.component.xr.ms.xr xrVar, ao aoVar) throws IOException {
                InputStream inputStream;
                int iAh;
                RandomAccessFile randomAccessFile;
                h hVarC;
                InputStream inputStreamAh;
                long jMs;
                RandomAccessFile randomAccessFile2;
                long j = length;
                int i = 4;
                String str = "VideoPreload";
                h hVar = null;
                if (aoVar != null) {
                    try {
                        boolean zD = aoVar.d();
                        if (zD) {
                            h hVarC2 = aoVar.c();
                            try {
                                hVarC = aoVar.c();
                                if (!zD || hVarC == null) {
                                    inputStreamAh = null;
                                    jMs = 0;
                                } else {
                                    try {
                                        jMs = length + hVarC.ms();
                                        inputStreamAh = hVarC.ah();
                                    } catch (Throwable th) {
                                        th = th;
                                        str = "VideoPreload";
                                        inputStream = null;
                                        randomAccessFile = null;
                                        hVar = hVarC;
                                        iAh = MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE;
                                        com.bytedance.sdk.component.utils.sl.ms(th);
                                        xr.this.d();
                                        xr xrVar2 = xr.this;
                                        d dVar = xrVar2.xr;
                                        if (aoVar != null) {
                                            iAh = aoVar.ah();
                                        }
                                        xrVar2.ms(dVar, iAh, th.getMessage());
                                        xr.this.ms(randomAccessFile);
                                        xr.this.ms(inputStream);
                                        xr.this.ms(hVar);
                                        xr.this.ms(aoVar);
                                        com.bykv.vk.openvk.component.video.api.c.ah.ms(str, "Pre finally ", xr.this.xr.ao(), " Preload size=", Integer.valueOf(xr.this.xr.c()));
                                    }
                                }
                                if (inputStreamAh == null) {
                                    try {
                                        xr xrVar3 = xr.this;
                                        xrVar3.ms(xrVar3.xr, aoVar.ah(), aoVar.ka());
                                        xr.this.ms((Closeable) null);
                                        xr.this.ms(inputStreamAh);
                                        xr.this.ms(hVarC);
                                        xr.this.ms(aoVar);
                                        com.bykv.vk.openvk.component.video.api.c.ah.ms("VideoPreload", "Pre finally ", xr.this.xr.ao(), " Preload size=", Integer.valueOf(xr.this.xr.c()));
                                    } catch (Throwable th2) {
                                        th = th2;
                                        inputStream = inputStreamAh;
                                        str = "VideoPreload";
                                        randomAccessFile = null;
                                        hVar = hVarC;
                                        iAh = MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE;
                                        com.bytedance.sdk.component.utils.sl.ms(th);
                                        xr.this.d();
                                        xr xrVar4 = xr.this;
                                        d dVar2 = xrVar4.xr;
                                        if (aoVar != null) {
                                            iAh = aoVar.ah();
                                        }
                                        xrVar4.ms(dVar2, iAh, th.getMessage());
                                        xr.this.ms(randomAccessFile);
                                        xr.this.ms(inputStream);
                                        xr.this.ms(hVar);
                                        xr.this.ms(aoVar);
                                        com.bykv.vk.openvk.component.video.api.c.ah.ms(str, "Pre finally ", xr.this.xr.ao(), " Preload size=", Integer.valueOf(xr.this.xr.c()));
                                    }
                                } else {
                                    try {
                                        randomAccessFile = new RandomAccessFile(xr.this.d, "rw");
                                        try {
                                            byte[] bArr = new byte[8192];
                                            int i2 = 0;
                                            long j2 = 0;
                                            while (true) {
                                                int i3 = inputStreamAh.read(bArr, i2, 8192 - i2);
                                                if (i3 == -1) {
                                                    str = str;
                                                    if (xr.this.xr.zb() && jMs == xr.this.d.length()) {
                                                        xr.this.ka();
                                                    }
                                                    xr xrVar5 = xr.this;
                                                    xrVar5.ms(xrVar5.xr, aoVar.ah());
                                                    randomAccessFile2 = randomAccessFile;
                                                    break;
                                                }
                                                if (xr.this.ah) {
                                                    xr xrVar6 = xr.this;
                                                    xrVar6.xr(xrVar6.xr, aoVar.ah());
                                                    xr.this.ms(randomAccessFile);
                                                    xr.this.ms(inputStreamAh);
                                                    xr.this.ms(hVarC);
                                                    xr.this.ms(aoVar);
                                                    Object[] objArr = new Object[i];
                                                    objArr[0] = "Pre finally ";
                                                    objArr[1] = xr.this.xr.ao();
                                                    objArr[2] = " Preload size=";
                                                    objArr[3] = Integer.valueOf(xr.this.xr.c());
                                                    com.bykv.vk.openvk.component.video.api.c.ah.ms(str, objArr);
                                                } else {
                                                    i2 += i3;
                                                    str = str;
                                                    j2 += (long) i3;
                                                    try {
                                                        if (j2 % 8192 == 0 || j2 == jMs - length) {
                                                            com.bykv.vk.openvk.component.video.ms.ka.ah.ms(randomAccessFile, bArr, j, i2);
                                                            j += (long) i2;
                                                            i2 = 0;
                                                        }
                                                        str = str;
                                                        i = 4;
                                                    } catch (Throwable th3) {
                                                        th = th3;
                                                        inputStream = inputStreamAh;
                                                        hVar = hVarC;
                                                        str = str;
                                                    }
                                                }
                                                th = th3;
                                                inputStream = inputStreamAh;
                                                hVar = hVarC;
                                                str = str;
                                                iAh = MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE;
                                                com.bytedance.sdk.component.utils.sl.ms(th);
                                                xr.this.d();
                                                xr xrVar7 = xr.this;
                                                d dVar3 = xrVar7.xr;
                                                if (aoVar != null) {
                                                    iAh = aoVar.ah();
                                                }
                                                xrVar7.ms(dVar3, iAh, th.getMessage());
                                                xr.this.ms(randomAccessFile);
                                                xr.this.ms(inputStream);
                                                xr.this.ms(hVar);
                                                xr.this.ms(aoVar);
                                                com.bykv.vk.openvk.component.video.api.c.ah.ms(str, "Pre finally ", xr.this.xr.ao(), " Preload size=", Integer.valueOf(xr.this.xr.c()));
                                            }
                                            xr.this.ms(randomAccessFile2);
                                            xr.this.ms(inputStreamAh);
                                            xr.this.ms(hVarC);
                                            xr.this.ms(aoVar);
                                            com.bykv.vk.openvk.component.video.api.c.ah.ms(str, "Pre finally ", xr.this.xr.ao(), " Preload size=", Integer.valueOf(xr.this.xr.c()));
                                        } catch (Throwable th4) {
                                            th = th4;
                                            inputStream = inputStreamAh;
                                            str = str;
                                            hVar = hVarC;
                                        }
                                    } catch (Throwable th5) {
                                        th = th5;
                                        inputStream = inputStreamAh;
                                        hVar = hVarC;
                                        iAh = MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE;
                                        randomAccessFile = null;
                                        com.bytedance.sdk.component.utils.sl.ms(th);
                                        xr.this.d();
                                        xr xrVar8 = xr.this;
                                        d dVar4 = xrVar8.xr;
                                        if (aoVar != null) {
                                            iAh = aoVar.ah();
                                        }
                                        xrVar8.ms(dVar4, iAh, th.getMessage());
                                        xr.this.ms(randomAccessFile);
                                        xr.this.ms(inputStream);
                                        xr.this.ms(hVar);
                                        xr.this.ms(aoVar);
                                        com.bykv.vk.openvk.component.video.api.c.ah.ms(str, "Pre finally ", xr.this.xr.ao(), " Preload size=", Integer.valueOf(xr.this.xr.c()));
                                    }
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                hVar = hVarC2;
                                inputStream = null;
                            }
                        } else {
                            try {
                                xr xrVar9 = xr.this;
                                xrVar9.ms(xrVar9.xr, aoVar.ah(), aoVar.ka());
                                xr.this.ms((Closeable) null);
                                xr.this.ms((Closeable) null);
                                xr.this.ms((Closeable) null);
                                xr.this.ms(aoVar);
                                com.bykv.vk.openvk.component.video.api.c.ah.ms("VideoPreload", "Pre finally ", xr.this.xr.ao(), " Preload size=", Integer.valueOf(xr.this.xr.c()));
                            } catch (Throwable th7) {
                                th = th7;
                                str = "VideoPreload";
                                inputStream = null;
                                randomAccessFile = null;
                                iAh = MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE;
                                try {
                                    com.bytedance.sdk.component.utils.sl.ms(th);
                                    xr.this.d();
                                    xr xrVar10 = xr.this;
                                    d dVar5 = xrVar10.xr;
                                    if (aoVar != null) {
                                        iAh = aoVar.ah();
                                    }
                                    xrVar10.ms(dVar5, iAh, th.getMessage());
                                    xr.this.ms(randomAccessFile);
                                    xr.this.ms(inputStream);
                                    xr.this.ms(hVar);
                                    xr.this.ms(aoVar);
                                    com.bykv.vk.openvk.component.video.api.c.ah.ms(str, "Pre finally ", xr.this.xr.ao(), " Preload size=", Integer.valueOf(xr.this.xr.c()));
                                } finally {
                                    xr.this.ms(randomAccessFile);
                                    xr.this.ms(inputStream);
                                    xr.this.ms(hVar);
                                    xr.this.ms(aoVar);
                                    com.bykv.vk.openvk.component.video.api.c.ah.ms(str, "Pre finally ", xr.this.xr.ao(), " Preload size=", Integer.valueOf(xr.this.xr.c()));
                                    ah.ms(xr.this.xr);
                                }
                            }
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        str = "VideoPreload";
                        inputStream = null;
                        iAh = MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE;
                        randomAccessFile = null;
                        hVar = null;
                    }
                } else {
                    str = "VideoPreload";
                    try {
                        xr xrVar11 = xr.this;
                        d dVar6 = xrVar11.xr;
                        iAh = MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE;
                        try {
                            xrVar11.ms(dVar6, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE, "Network link failed.");
                            inputStreamAh = null;
                            randomAccessFile2 = null;
                            hVarC = null;
                            xr.this.ms(randomAccessFile2);
                            xr.this.ms(inputStreamAh);
                            xr.this.ms(hVarC);
                            xr.this.ms(aoVar);
                            com.bykv.vk.openvk.component.video.api.c.ah.ms(str, "Pre finally ", xr.this.xr.ao(), " Preload size=", Integer.valueOf(xr.this.xr.c()));
                        } catch (Throwable th9) {
                            th = th9;
                            inputStream = null;
                            randomAccessFile = null;
                            hVar = null;
                            com.bytedance.sdk.component.utils.sl.ms(th);
                            xr.this.d();
                            xr xrVar12 = xr.this;
                            d dVar7 = xrVar12.xr;
                            if (aoVar != null) {
                                iAh = aoVar.ah();
                            }
                            xrVar12.ms(dVar7, iAh, th.getMessage());
                            xr.this.ms(randomAccessFile);
                            xr.this.ms(inputStream);
                            xr.this.ms(hVar);
                            xr.this.ms(aoVar);
                            com.bykv.vk.openvk.component.video.api.c.ah.ms(str, "Pre finally ", xr.this.xr.ao(), " Preload size=", Integer.valueOf(xr.this.xr.c()));
                        }
                    } catch (Throwable th10) {
                        th = th10;
                        iAh = MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE;
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public d ms() {
        return this.xr;
    }

    public void ms(boolean z) {
        this.ah = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(d dVar, int i) {
        synchronized (com.bykv.vk.openvk.component.video.api.ka.ms.InterfaceC0178ms.class) {
            for (com.bykv.vk.openvk.component.video.api.ka.ms.InterfaceC0178ms interfaceC0178ms : this.c) {
                if (interfaceC0178ms != null) {
                    interfaceC0178ms.ms(dVar, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(d dVar, int i, String str) {
        synchronized (com.bykv.vk.openvk.component.video.api.ka.ms.InterfaceC0178ms.class) {
            for (com.bykv.vk.openvk.component.video.api.ka.ms.InterfaceC0178ms interfaceC0178ms : this.c) {
                if (interfaceC0178ms != null) {
                    interfaceC0178ms.ms(dVar, i, str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(d dVar, int i) {
        synchronized (com.bykv.vk.openvk.component.video.api.ka.ms.InterfaceC0178ms.class) {
            for (com.bykv.vk.openvk.component.video.api.ka.ms.InterfaceC0178ms interfaceC0178ms : this.c) {
                if (interfaceC0178ms != null) {
                    interfaceC0178ms.xr(dVar, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            this.ka.delete();
            this.d.delete();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ka() {
        try {
            if (this.d.renameTo(this.ka)) {
            } else {
                throw new IOException("Error renaming file " + this.d + " to " + this.ka + " for completion!");
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
            com.bykv.vk.openvk.component.video.api.c.ah.ms("VideoPreload", th.getMessage());
        }
    }
}
