package com.taptap.sdk.kit.internal.identifier;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.provider.Settings;
import com.anythink.core.common.u.n;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.kwad.sdk.api.model.AdnName;
import com.taptap.sdk.kit.internal.TapTapKit;
import com.taptap.sdk.kit.internal.identifier.content.TapGAIDUtil;
import com.taptap.sdk.kit.internal.identifier.content.TapGIDUtil;
import com.taptap.sdk.kit.internal.identifier.content.TapGameUserIdUtil;
import com.taptap.sdk.kit.internal.identifier.content.TapOAIDUtil;
import com.taptap.sdk.kit.internal.identifier.content.TapOpenIdUtil;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: TapIdentifierUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001:\u00013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0018\u001a\u00020\u0019J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u001e\u001a\u00020\u0004J\b\u0010\u001f\u001a\u00020\u0004H\u0007J\b\u0010 \u001a\u0004\u0018\u00010\u0004J\u000e\u0010!\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019J\u001c\u0010\"\u001a\u00020#2\u0014\u0010$\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0004\u0012\u00020#0%J\n\u0010&\u001a\u0004\u0018\u00010\u0004H\u0007J\u001c\u0010'\u001a\u00020#2\u0014\u0010$\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020#0%J\u000e\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020\tJ\u000e\u0010*\u001a\u00020#2\u0006\u0010)\u001a\u00020\fJ\u0010\u0010+\u001a\u00020#2\b\u0010,\u001a\u0004\u0018\u00010\u0004J\u0010\u0010-\u001a\u00020#2\b\u0010.\u001a\u0004\u0018\u00010\u0004J\u0010\u0010/\u001a\u00020#2\b\u00100\u001a\u0004\u0018\u00010\u0004J\u000e\u00101\u001a\u00020#2\u0006\u0010)\u001a\u00020\tJ\u000e\u00102\u001a\u00020#2\u0006\u0010)\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/taptap/sdk/kit/internal/identifier/TapIdentifierUtil;", "", "()V", "SP_NAME", "", "androidId", "deviceId", "gameUserIdChangedListeners", "", "Lcom/taptap/sdk/kit/internal/identifier/GameUserIdChangedListener;", "installUUID", "openIdChangedListeners", "Lcom/taptap/sdk/kit/internal/identifier/OpenIdChangedListener;", "sp", "Landroid/content/SharedPreferences;", "getSp", "()Landroid/content/SharedPreferences;", "sp$delegate", "Lkotlin/Lazy;", "uniqueDeviceId", "bytesToHexString", "src", "", "getAndroidID", "context", "Landroid/content/Context;", "getDeviceId", "getGAID", "Lcom/taptap/sdk/kit/internal/identifier/TapIdentifierUtil$GAID;", "getGameUserId", "getInstallUUID", "getOAID", "getOpenId", "getUniqueDeviceId", "queryGAID", "", "block", "Lkotlin/Function1;", "queryGID", "queryOAID", "registerGameUserIdChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "registerOpenIdChangedListener", "setGameUserId", "gameUserId", "setOAIDCertString", "oaidCert", "setOpenId", "openId", "unregisterGameUserIdChangedListener", "unregisterOpenIdChangedListener", "GAID", "tap-kit_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapIdentifierUtil {
    private static final String SP_NAME = "TapSdkCore_SP";
    private static volatile String androidId;
    private static volatile String deviceId;
    public static final TapIdentifierUtil INSTANCE = new TapIdentifierUtil();

    /* JADX INFO: renamed from: sp$delegate, reason: from kotlin metadata */
    private static final Lazy sp = LazyKt.lazy(new Function0<SharedPreferences>() { // from class: com.taptap.sdk.kit.internal.identifier.TapIdentifierUtil$sp$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SharedPreferences invoke() {
            return TapTapKit.INSTANCE.getContext().getSharedPreferences("TapSdkCore_SP", 0);
        }
    });
    private static final List<GameUserIdChangedListener> gameUserIdChangedListeners = new ArrayList();
    private static final List<OpenIdChangedListener> openIdChangedListeners = new ArrayList();
    private static volatile String uniqueDeviceId = "";
    private static volatile String installUUID = "";

    private TapIdentifierUtil() {
    }

    private final SharedPreferences getSp() {
        Object value = sp.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-sp>(...)");
        return (SharedPreferences) value;
    }

    @JvmStatic
    public static final String getAndroidID(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (androidId != null) {
            return androidId;
        }
        try {
            androidId = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception unused) {
        }
        return androidId;
    }

    public final String getUniqueDeviceId(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            if (uniqueDeviceId.length() > 0) {
                return uniqueDeviceId;
            }
            String string = new StringBuilder().append(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime).append('-').append(Process.myPid()).toString();
            MessageDigest messageDigest = MessageDigest.getInstance(n.a);
            StringBuilder sb = new StringBuilder("v1-");
            byte[] bytes = string.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            uniqueDeviceId = sb.append(bytesToHexString(messageDigest.digest(bytes))).toString();
            return uniqueDeviceId;
        } catch (Throwable th) {
            th.printStackTrace();
            uniqueDeviceId = "unknown";
            return uniqueDeviceId;
        }
    }

    public final String getDeviceId(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (deviceId != null) {
            return deviceId;
        }
        deviceId = DataUtils.getDeviceId(context);
        return deviceId;
    }

    public final synchronized String getInstallUUID() {
        boolean z = true;
        if (installUUID.length() > 0) {
            return installUUID;
        }
        String string = getSp().getString("tapsdk_install_uuid", null);
        String str = string;
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (!z) {
            installUUID = string;
            return string;
        }
        String string2 = UUID.randomUUID().toString();
        getSp().edit().putString("tapsdk_install_uuid", string2).apply();
        installUUID = string2;
        return string2;
    }

    public final String queryGID() {
        return TapGIDUtil.INSTANCE.queryGID();
    }

    public final void setOAIDCertString(String oaidCert) {
        TapOAIDUtil.INSTANCE.setOAIDCertString(oaidCert);
    }

    public final void queryOAID(Function1<? super String, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        TapOAIDUtil.INSTANCE.queryOAID(block);
    }

    public final String getOAID() {
        return TapOAIDUtil.INSTANCE.getOAID();
    }

    public final void queryGAID(Function1<? super GAID, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        TapGAIDUtil.INSTANCE.queryGAID(block);
    }

    public final GAID getGAID() {
        return TapGAIDUtil.INSTANCE.getGAID();
    }

    /* JADX INFO: compiled from: TapIdentifierUtil.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/taptap/sdk/kit/internal/identifier/TapIdentifierUtil$GAID;", "", "androidAdvertiserIdValue", "", "isTrackingLimited", "", "(Ljava/lang/String;Z)V", "getAndroidAdvertiserIdValue", "()Ljava/lang/String;", "setAndroidAdvertiserIdValue", "(Ljava/lang/String;)V", "()Z", "setTrackingLimited", "(Z)V", "component1", "component2", "copy", "equals", AdnName.OTHER, "hashCode", "", "toString", "tap-kit_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class GAID {
        private String androidAdvertiserIdValue;
        private boolean isTrackingLimited;

        /* JADX WARN: Multi-variable type inference failed */
        public GAID() {
            this(null, false, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ GAID copy$default(GAID gaid, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = gaid.androidAdvertiserIdValue;
            }
            if ((i & 2) != 0) {
                z = gaid.isTrackingLimited;
            }
            return gaid.copy(str, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getAndroidAdvertiserIdValue() {
            return this.androidAdvertiserIdValue;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsTrackingLimited() {
            return this.isTrackingLimited;
        }

        public final GAID copy(String androidAdvertiserIdValue, boolean isTrackingLimited) {
            return new GAID(androidAdvertiserIdValue, isTrackingLimited);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GAID)) {
                return false;
            }
            GAID gaid = (GAID) other;
            return Intrinsics.areEqual(this.androidAdvertiserIdValue, gaid.androidAdvertiserIdValue) && this.isTrackingLimited == gaid.isTrackingLimited;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public int hashCode() {
            String str = this.androidAdvertiserIdValue;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            boolean z = this.isTrackingLimited;
            ?? r1 = z;
            if (z) {
                r1 = 1;
            }
            return iHashCode + r1;
        }

        public String toString() {
            return "GAID(androidAdvertiserIdValue=" + this.androidAdvertiserIdValue + ", isTrackingLimited=" + this.isTrackingLimited + ')';
        }

        public GAID(String str, boolean z) {
            this.androidAdvertiserIdValue = str;
            this.isTrackingLimited = z;
        }

        public /* synthetic */ GAID(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? false : z);
        }

        public final String getAndroidAdvertiserIdValue() {
            return this.androidAdvertiserIdValue;
        }

        public final boolean isTrackingLimited() {
            return this.isTrackingLimited;
        }

        public final void setAndroidAdvertiserIdValue(String str) {
            this.androidAdvertiserIdValue = str;
        }

        public final void setTrackingLimited(boolean z) {
            this.isTrackingLimited = z;
        }
    }

    public final String getOpenId() {
        return TapOpenIdUtil.INSTANCE.getOpenId();
    }

    public final void setOpenId(String openId) {
        TapOpenIdUtil.INSTANCE.setOpenId$tap_kit_release(openId);
        List<OpenIdChangedListener> list = openIdChangedListeners;
        synchronized (list) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((OpenIdChangedListener) it.next()).onChange(openId);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final String getGameUserId() {
        return TapGameUserIdUtil.INSTANCE.getGameUserId();
    }

    public final void setGameUserId(String gameUserId) {
        TapGameUserIdUtil.INSTANCE.setGameUserId$tap_kit_release(gameUserId);
        List<GameUserIdChangedListener> list = gameUserIdChangedListeners;
        synchronized (list) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((GameUserIdChangedListener) it.next()).onChange(gameUserId);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void registerGameUserIdChangedListener(GameUserIdChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        List<GameUserIdChangedListener> list = gameUserIdChangedListeners;
        synchronized (list) {
            list.add(listener);
        }
    }

    public final void unregisterGameUserIdChangedListener(GameUserIdChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        List<GameUserIdChangedListener> list = gameUserIdChangedListeners;
        synchronized (list) {
            list.remove(listener);
        }
    }

    public final void registerOpenIdChangedListener(OpenIdChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        List<OpenIdChangedListener> list = openIdChangedListeners;
        synchronized (list) {
            list.add(listener);
        }
    }

    public final void unregisterOpenIdChangedListener(OpenIdChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        List<OpenIdChangedListener> list = openIdChangedListeners;
        synchronized (list) {
            list.remove(listener);
        }
    }

    private final String bytesToHexString(byte[] src) {
        if (src == null) {
            return null;
        }
        if (src.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder("");
        for (byte b : src) {
            String hexString = Integer.toHexString(b & UByte.MAX_VALUE);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }
}
