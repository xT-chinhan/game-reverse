package com.taptap.sdk.kit.internal.identifier.content;

import android.os.Handler;
import android.os.Looper;
import com.taptap.sdk.kit.internal.TapTapKit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: TapOAIDUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\u0004J\u001c\u0010\r\u001a\u00020\u000b2\u0014\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u000b0\nJ\u0010\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/taptap/sdk/kit/internal/identifier/content/TapOAIDUtil;", "", "()V", "TAG", "", "isQuerying", "Ljava/util/concurrent/atomic/AtomicBoolean;", "oaid", "waitingList", "", "Lkotlin/Function1;", "", "getOAID", "queryOAID", "callback", "setOAIDCertString", "oaidCert", "tap-kit_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapOAIDUtil {
    private static final String TAG = "TapOAIDUtil";
    private static String oaid;
    public static final TapOAIDUtil INSTANCE = new TapOAIDUtil();
    private static List<Function1<String, Unit>> waitingList = new ArrayList();
    private static AtomicBoolean isQuerying = new AtomicBoolean(false);

    private TapOAIDUtil() {
    }

    public final void queryOAID(Function1<? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        synchronized (this) {
            String str = oaid;
            if (str != null) {
                callback.invoke(str);
                return;
            }
            waitingList.add(callback);
            if (isQuerying.get()) {
                return;
            }
            isQuerying.set(true);
            Unit unit = Unit.INSTANCE;
            ThreadsKt.thread$default(false, false, null, null, 0, new AnonymousClass2(), 31, null);
        }
    }

    /* JADX INFO: renamed from: com.taptap.sdk.kit.internal.identifier.content.TapOAIDUtil$queryOAID$2, reason: invalid class name */
    /* JADX INFO: compiled from: TapOAIDUtil.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            final String oaid = OaidHelper.getOAID(TapTapKit.INSTANCE.getContext());
            Handler handler = new Handler(Looper.getMainLooper());
            final TapOAIDUtil tapOAIDUtil = TapOAIDUtil.this;
            handler.post(new Runnable() { // from class: com.taptap.sdk.kit.internal.identifier.content.TapOAIDUtil$queryOAID$2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    TapOAIDUtil.AnonymousClass2.invoke$lambda$2(tapOAIDUtil, oaid);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$2(TapOAIDUtil this$0, String str) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            synchronized (this$0) {
                TapOAIDUtil tapOAIDUtil = TapOAIDUtil.INSTANCE;
                TapOAIDUtil.oaid = str;
                Iterator it = TapOAIDUtil.waitingList.iterator();
                while (it.hasNext()) {
                    ((Function1) it.next()).invoke(str);
                }
                TapOAIDUtil.waitingList.clear();
                TapOAIDUtil.isQuerying.set(false);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final String getOAID() {
        String oaid2 = OaidHelper.getOAID(TapTapKit.INSTANCE.getContext());
        Intrinsics.checkNotNullExpressionValue(oaid2, "getOAID(TapTapKit.context)");
        return oaid2;
    }

    public final void setOAIDCertString(String oaidCert) {
        OaidHelper.setCertString(oaidCert);
    }
}
