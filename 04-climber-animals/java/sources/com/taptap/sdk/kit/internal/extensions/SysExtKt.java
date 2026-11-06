package com.taptap.sdk.kit.internal.extensions;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.anythink.core.common.d.j;
import com.taptap.sdk.initializer.api.model.RegionType;
import com.taptap.sdk.kit.internal.TapTapKit;
import com.taptap.sdk.kit.internal.utils.TapToast;
import com.umeng.analytics.pro.g;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: SysExt.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\u001a\u0018\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u001a\u0006\u0010\f\u001a\u00020\u0003\u001a\u0006\u0010\r\u001a\u00020\u0001\u001a\u0006\u0010\u000e\u001a\u00020\u000f\u001a\u0010\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u001a\n\u0010\u0013\u001a\u00020\u0014*\u00020\u000b\u001a\u0014\u0010\u0015\u001a\u00020\u0003*\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"INVALID_PACKAGE_VERSION_CODE", "", "PACKAGE_NAME_CN", "", "PACKAGE_NAME_GLOBAL", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "checkApkFile", g.X, "Landroid/content/Context;", "file", "Ljava/io/File;", "getTapPkgName", "getTapVersionCode", "isTapInstalled", "", "showToast", "Lkotlinx/coroutines/Job;", "content", "toByteArray", "", "toDateString", "pattern", "tap-common_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class SysExtKt {
    public static final int INVALID_PACKAGE_VERSION_CODE = -1;
    public static final String PACKAGE_NAME_CN = "com.taptap";
    public static final String PACKAGE_NAME_GLOBAL = "com.taptap.global";
    private static final CoroutineScope mainScope = CoroutineScopeKt.MainScope();

    public static final boolean isTapInstalled() {
        try {
            return TapTapKit.INSTANCE.getContext().getPackageManager().getPackageInfo(getTapPkgName(), 0) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static final String getTapPkgName() {
        return TapTapKit.INSTANCE.getRegionType$tap_common_release() == RegionType.CN ? PACKAGE_NAME_CN : PACKAGE_NAME_GLOBAL;
    }

    public static final int getTapVersionCode() {
        if (!isTapInstalled()) {
            return -1;
        }
        try {
            PackageInfo packageInfo = TapTapKit.INSTANCE.getContext().getPackageManager().getPackageInfo(getTapPkgName(), 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* JADX INFO: renamed from: com.taptap.sdk.kit.internal.extensions.SysExtKt$showToast$1, reason: invalid class name */
    /* JADX INFO: compiled from: SysExt.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.taptap.sdk.kit.internal.extensions.SysExtKt$showToast$1", f = "SysExt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $content;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$content = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$content, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            TapToast.showToast$tap_common_release$default(TapToast.INSTANCE, this.$content, 0, 2, null);
            return Unit.INSTANCE;
        }
    }

    public static final Job showToast(String str) {
        return BuildersKt__Builders_commonKt.launch$default(mainScope, null, null, new AnonymousClass1(str, null), 3, null);
    }

    public static final int checkApkFile(Context context, File file) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!(file != null && file.exists())) {
            return -1;
        }
        try {
            String fileName = file.getName();
            Intrinsics.checkNotNullExpressionValue(fileName, "fileName");
            String strSubstring = fileName.substring(StringsKt.lastIndexOf$default((CharSequence) fileName, j.z, 0, false, 6, (Object) null) + 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
            if (Intrinsics.areEqual(strSubstring, "apk")) {
                return context.getPackageManager().getPackageArchiveInfo(file.getPath(), 1) == null ? -2 : 0;
            }
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static /* synthetic */ String toDateString$default(int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "yyyy.MM.dd";
        }
        return toDateString(i, str);
    }

    public static final String toDateString(int i, String pattern) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        String str = new SimpleDateFormat(pattern, Locale.getDefault()).format(new Date(((long) i) * 1000));
        Intrinsics.checkNotNullExpressionValue(str, "formatter.format(date)");
        return str;
    }

    public static final byte[] toByteArray(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileInputStream fileInputStream2 = fileInputStream;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
                ByteStreamsKt.copyTo$default(fileInputStream2, byteArrayOutputStream2, 0, 2, null);
                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                CloseableKt.closeFinally(byteArrayOutputStream, null);
                CloseableKt.closeFinally(fileInputStream, null);
                Intrinsics.checkNotNullExpressionValue(byteArray, "inputStream().use { inpu…teArray()\n        }\n    }");
                return byteArray;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(byteArrayOutputStream, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(fileInputStream, th3);
                throw th4;
            }
        }
    }
}
