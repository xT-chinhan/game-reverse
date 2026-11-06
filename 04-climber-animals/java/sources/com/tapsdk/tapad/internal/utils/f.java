package com.tapsdk.tapad.internal.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes3.dex */
public class f {

    static class a implements Consumer<String> {
        final /* synthetic */ Context a;
        final /* synthetic */ File b;

        a(Context context, File file) {
            this.a = context;
            this.b = file;
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
            Intent launchIntentForPackage;
            if (TextUtils.isEmpty(str) || (launchIntentForPackage = this.a.getPackageManager().getLaunchIntentForPackage(str)) == null) {
                f.c(this.a, this.b);
            } else {
                this.a.startActivity(launchIntentForPackage);
            }
        }
    }

    static class b implements ObservableOnSubscribe<String> {
        final /* synthetic */ File a;
        final /* synthetic */ Context b;

        b(File file, Context context) {
            this.a = file;
            this.b = context;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
            PackageInfo packageArchiveInfo;
            try {
                File file = this.a;
                if (file == null || !file.exists() || (packageArchiveInfo = this.b.getPackageManager().getPackageArchiveInfo(this.a.getAbsolutePath(), 1)) == null) {
                    observableEmitter.onNext(null);
                } else {
                    observableEmitter.onNext(packageArchiveInfo.applicationInfo.packageName);
                }
            } catch (Exception e) {
                TapADLogger.d("parse apk pkgName fail :" + e.getMessage());
                observableEmitter.onNext(null);
            }
            observableEmitter.onComplete();
        }
    }

    public static String a(Context context, File file) {
        PackageInfo packageArchiveInfo;
        return (file == null || !file.exists() || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 1)) == null) ? "" : packageArchiveInfo.applicationInfo.packageName;
    }

    public static void a(InputStream inputStream, File file) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    break;
                } else {
                    fileOutputStream.write(bArr, 0, i);
                }
            }
            fileOutputStream.flush();
        } catch (Exception unused) {
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            throw th;
        }
        try {
            inputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0044 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:33:0x0046 A[Catch: IOException -> 0x0049, TRY_LEAVE, TryCatch #0 {IOException -> 0x0049, blocks: (B:31:0x0041, B:33:0x0046), top: B:37:0x0041 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x0041 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static void a(byte[] bArr, String str) {
        FileOutputStream fileOutputStream;
        File file = new File(str);
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(fileOutputStream);
                    try {
                        bufferedOutputStream2.write(bArr);
                        bufferedOutputStream2.close();
                        fileOutputStream.close();
                        bufferedOutputStream2.close();
                    } catch (IOException e) {
                        e = e;
                        bufferedOutputStream = bufferedOutputStream2;
                        try {
                            e.printStackTrace();
                            if (bufferedOutputStream != null) {
                                bufferedOutputStream.close();
                            }
                            if (fileOutputStream == null) {
                                return;
                            }
                        } catch (Throwable th) {
                            th = th;
                            bufferedOutputStream2 = bufferedOutputStream;
                            fileOutputStream = fileOutputStream;
                            bufferedOutputStream = bufferedOutputStream2;
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                } catch (IOException unused) {
                                    throw th;
                                }
                            } else if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = fileOutputStream;
                        bufferedOutputStream = bufferedOutputStream2;
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                        } else if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                } catch (Throwable th3) {
                    th = th3;
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } else if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (IOException unused2) {
                return;
            }
        } catch (IOException e3) {
            e = e3;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
        fileOutputStream.close();
    }

    public static boolean a(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:44:0x003e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0048: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:34:0x0048 */
    private static byte[] a(File file) throws Throwable {
        DigestInputStream digestInputStream;
        DigestInputStream digestInputStream2;
        DigestInputStream digestInputStream3 = null;
        try {
            if (file == null) {
                return null;
            }
            try {
                digestInputStream2 = new DigestInputStream(new FileInputStream(file), MessageDigest.getInstance("MD5"));
                try {
                    while (digestInputStream2.read(new byte[262144]) > 0) {
                    }
                    byte[] bArrDigest = digestInputStream2.getMessageDigest().digest();
                    try {
                        digestInputStream2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return bArrDigest;
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    if (digestInputStream2 != null) {
                        try {
                            digestInputStream2.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return null;
                } catch (NoSuchAlgorithmException e4) {
                    e = e4;
                    e.printStackTrace();
                    if (digestInputStream2 != null) {
                        digestInputStream2.close();
                    }
                    return null;
                }
            } catch (IOException e5) {
                e = e5;
                digestInputStream2 = null;
                e.printStackTrace();
                if (digestInputStream2 != null) {
                    digestInputStream2.close();
                }
                return null;
            } catch (NoSuchAlgorithmException e6) {
                e = e6;
                digestInputStream2 = null;
                e.printStackTrace();
                if (digestInputStream2 != null) {
                    digestInputStream2.close();
                }
                return null;
            } catch (Throwable th) {
                th = th;
                if (digestInputStream3 != null) {
                    try {
                        digestInputStream3.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            digestInputStream3 = digestInputStream;
        }
    }

    public static Observable<String> b(Context context, File file) {
        return Observable.create(new b(file, context));
    }

    public static String b(File file) throws Throwable {
        byte[] bArrA = a(file);
        if (bArrA != null) {
            return q.a(bArrA);
        }
        return null;
    }

    public static byte[] b(String str) throws IOException {
        FileChannel channel = new FileInputStream(str).getChannel();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((int) channel.size());
        channel.read(byteBufferAllocate);
        return byteBufferAllocate.array();
    }

    public static void c(Context context, File file) {
        if (file.exists()) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setFlags(268435457);
            intent.setDataAndType(FileProvider.getUriForFile(context, context.getPackageName() + ".com.tds.ad.fileprovider", file), "application/vnd.android.package-archive");
            context.startActivity(intent);
        }
    }

    public static void d(Context context, File file) {
        if (file == null || !file.exists()) {
            return;
        }
        b(context, file).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(context, file));
    }
}
