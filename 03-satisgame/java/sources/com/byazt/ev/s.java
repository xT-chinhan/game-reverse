package com.byazt.ev;

import android.text.TextUtils;
import androidx.core.internal.view.SupportMenu;
import com.anythink.china.a.c;
import com.anythink.core.common.d.i;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, AVMDLDataLoader.KeyIsPreloadWaitListType, 8})
public class s {
    public int n(File file, boolean z, StringBuilder sb) {
        String string;
        ZipFile zipFile = null;
        try {
            ZipFile zipFile2 = new ZipFile(file);
            try {
                ZipEntry entry = zipFile2.getEntry("assets/ZeusResMapping");
                if (entry == null) {
                    com.byazt.gx.x.n(zipFile2);
                    return 200;
                }
                if (z) {
                    File file2 = new File(file.getParentFile(), "resMappingBak");
                    if (!file2.exists()) {
                        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "resMappingBakFile is not exists. " + file2.getAbsolutePath());
                        sb.append("resMappingBakFile is not exists. ").append(file2.getAbsolutePath());
                        com.byazt.gx.x.n(zipFile2);
                        return TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX;
                    }
                    string = com.byazt.gx.fs.n(file2);
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    com.byazt.gx.fs.n(zipFile2.getInputStream(entry), byteArrayOutputStream);
                    string = byteArrayOutputStream.toString();
                }
                if (TextUtils.isEmpty(string)) {
                    ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "zeusResMappingContent empty, useBakFile:".concat(String.valueOf(z)));
                    sb.append("zeusResMappingContent isEmpty. useBakFile:").append(z);
                    com.byazt.gx.x.n(zipFile2);
                    return TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX;
                }
                JSONObject jSONObject = new JSONObject(string);
                JSONObject jSONObject2 = new JSONObject(string);
                JSONArray jSONArray = (JSONArray) jSONObject.get("fileNames");
                final HashSet<String> hashSet = new HashSet<>();
                for (int i = 0; i < jSONArray.length(); i++) {
                    hashSet.add((String) jSONArray.get(i));
                }
                final JSONObject jSONObject3 = (JSONObject) jSONObject.get("resMapping");
                final JSONObject jSONObject4 = (JSONObject) jSONObject2.get("resMapping");
                final int[] iArr = {0};
                try {
                    n(file, hashSet, new fs() { // from class: com.byazt.ev.s.1
                        @Override // com.byazt.ev.fs
                        public int n(int i2) {
                            String str = "0x" + Integer.toHexString(i2);
                            String str2 = (String) jSONObject3.opt(str);
                            if (str2 == null) {
                                return i2;
                            }
                            int identifier = Zeus.getAppApplication().getResources().getIdentifier(str2.split(" ")[1], str2.split(" ")[0], Zeus.getAppApplication().getPackageName());
                            if (identifier == 0) {
                                identifier = Zeus.getAppApplication().getResources().getIdentifier(str2.split(" ")[1].replaceAll("_", i.E), str2.split(" ")[0], Zeus.getAppApplication().getPackageName());
                            }
                            if (identifier == 0) {
                                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "getIdentifier failed. resName is ".concat(String.valueOf(str2)));
                                return i2;
                            }
                            String str3 = "0x" + Integer.toHexString(identifier);
                            if (TextUtils.equals(jSONObject4.optString(str), str2)) {
                                jSONObject4.remove(str);
                            }
                            try {
                                jSONObject4.put(str3, str2);
                            } catch (Throwable th) {
                                ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "update resMappingBak failed.", th);
                            }
                            if (identifier != i2) {
                                int[] iArr2 = iArr;
                                iArr2[0] = iArr2[0] + 1;
                            }
                            return identifier;
                        }

                        @Override // com.byazt.ev.fs
                        public boolean n(String str) {
                            return hashSet.contains(str);
                        }
                    });
                    ZeusLogger.d(ZeusLogger.TAG_INSTALL, "modifyRes count = " + iArr[0]);
                    if (com.byazt.gx.fs.n(jSONObject2.toString(), new File(file.getParentFile(), "resMappingBak"), sb)) {
                        com.byazt.gx.x.n(zipFile2);
                        return 100;
                    }
                    ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "writeText failed." + sb.toString());
                    sb.append("writeText failed.");
                    com.byazt.gx.x.n(zipFile2);
                    return TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX;
                } catch (Throwable th) {
                    th = th;
                    zipFile = zipFile2;
                    try {
                        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "modifyRes failed. catch: " + th.getMessage(), th);
                        sb.append("modifyRes failed. catch: ").append(th.getMessage());
                        return TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX;
                    } finally {
                        if (zipFile != null) {
                            com.byazt.gx.x.n(zipFile);
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private void n(File file, HashSet<String> hashSet, fs fsVar) throws Throwable {
        MappedByteBuffer mappedByteBufferN = n(file);
        int iN = n(mappedByteBufferN);
        if (iN == -1) {
            throw new Throwable("endOfCentralPosition == -1");
        }
        int i = mappedByteBufferN.getInt(iN + 12);
        int i2 = mappedByteBufferN.getInt(iN + 16);
        int i3 = i + i2;
        while (i2 < i3) {
            if (mappedByteBufferN.getInt(i2) != 33639248) {
                throw new RuntimeException("Expected: 0x02014b50, got: " + mappedByteBufferN.getInt(i2));
            }
            int i4 = mappedByteBufferN.getShort(i2 + 28);
            short s = mappedByteBufferN.getShort(i2 + 30);
            byte[] bArr = new byte[i4];
            for (int i5 = 0; i5 < i4; i5++) {
                bArr[i5] = mappedByteBufferN.get(i2 + 46 + i5);
            }
            String str = new String(bArr);
            int i6 = mappedByteBufferN.getInt(i2 + 20);
            int i7 = mappedByteBufferN.getInt(i2 + 24);
            if (hashSet.contains(str)) {
                if (i6 != i7) {
                    throw new Throwable(str.concat(" is compressed."));
                }
                com.byazt.gx.l<Integer, byte[]> lVarN = n(mappedByteBufferN, mappedByteBufferN.getInt(i2 + 42), str);
                try {
                    cp.n(str, lVarN.qg, fsVar);
                    for (int i8 = 0; i8 < lVarN.qg.length; i8++) {
                        mappedByteBufferN.put(lVarN.n.intValue() + i8, lVarN.qg[i8]);
                    }
                } catch (Throwable th) {
                    throw new RuntimeException(th);
                }
            }
            i2 += i4 + 46 + s;
        }
    }

    private static com.byazt.gx.l<Integer, byte[]> n(MappedByteBuffer mappedByteBuffer, int i, String str) {
        if (mappedByteBuffer.getInt(i) != 67324752) {
            throw new RuntimeException("Expected: 0x04034b50, got: " + mappedByteBuffer.getInt(i) + " FileName:" + str);
        }
        int i2 = mappedByteBuffer.getInt(i + 18);
        int i3 = mappedByteBuffer.getInt(i + 22);
        if (i2 != i3) {
            throw new RuntimeException(str + " is compressed. compressSize:" + i2 + " size:" + i3);
        }
        byte[] bArr = new byte[i3];
        int i4 = i + 30 + mappedByteBuffer.getShort(i + 26) + mappedByteBuffer.getShort(i + 28);
        for (int i5 = 0; i5 < i3; i5++) {
            bArr[i5] = mappedByteBuffer.get(i4 + i5);
        }
        return new com.byazt.gx.l<>(Integer.valueOf(i4), bArr);
    }

    private int n(ByteBuffer byteBuffer) {
        int iCapacity = byteBuffer.capacity();
        if (iCapacity < 22) {
            return -1;
        }
        int i = iCapacity - 22;
        int iMin = Math.min(i, SupportMenu.USER_MASK);
        for (int i2 = 0; i2 < iMin; i2++) {
            int i3 = i - i2;
            if (byteBuffer.getInt(i3) == 101010256 && byteBuffer.getShort(i3 + 20) == i2) {
                return i3;
            }
        }
        return -1;
    }

    public MappedByteBuffer n(File file) throws Throwable {
        RandomAccessFile randomAccessFile = null;
        try {
            ZeusLogger.d("temp-pxr", "mappedByteBuffer " + file.canWrite());
            if (!file.canWrite()) {
                file.setWritable(true);
            }
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rw");
            try {
                FileChannel channel = randomAccessFile2.getChannel();
                long size = channel.size();
                MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0L, size);
                byte[] bArr = new byte[4194304];
                long j = size / c.w;
                int i = (int) (size % c.w);
                for (int i2 = 0; i2 < j; i2++) {
                    map.get(bArr);
                }
                if (i > 0) {
                    map.get(new byte[i]);
                }
                map.order(ByteOrder.LITTLE_ENDIAN);
                randomAccessFile2.close();
                return map;
            } catch (Throwable th) {
                th = th;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
