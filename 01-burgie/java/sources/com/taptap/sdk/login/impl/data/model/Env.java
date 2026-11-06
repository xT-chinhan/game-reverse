package com.taptap.sdk.login.impl.data.model;

import android.os.Build;
import com.taptap.sdk.kit.internal.extensions.UIExtKt;
import com.taptap.sdk.kit.internal.utils.CommonUtils;
import com.taptap.sdk.kit.internal.utils.localize.TapLocalizeUtil;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: Env.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ;2\u00020\u0001:\u0002:;Bw\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fBU\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005¢\u0006\u0002\u0010\u0010J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003JY\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0005HÆ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0003HÖ\u0001J\t\u00101\u001a\u00020\u0005HÖ\u0001J&\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00002\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208HÁ\u0001¢\u0006\u0002\b9R\u001c\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0017R\u001c\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0017R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u0017R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001f\u0010\u0017R\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0012\u001a\u0004\b!\u0010\u0017R\u001c\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0012\u001a\u0004\b#\u0010\u0017¨\u0006<"}, d2 = {"Lcom/taptap/sdk/login/impl/data/model/Env;", "", "seen1", "", "manufacturer", "", "model", "appVersion", "appAPI", "sdkVersion", "loc", "lang", "theme", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppAPI$annotations", "()V", "getAppAPI", "()I", "getAppVersion$annotations", "getAppVersion", "()Ljava/lang/String;", "getLang$annotations", "getLang", "getLoc$annotations", "getLoc", "getManufacturer$annotations", "getManufacturer", "getModel$annotations", "getModel", "getSdkVersion$annotations", "getSdkVersion", "getTheme$annotations", "getTheme", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$tap_login_release", "$serializer", "Companion", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
public final /* data */ class Env {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int appAPI;
    private final String appVersion;
    private final String lang;
    private final String loc;
    private final String manufacturer;
    private final String model;
    private final String sdkVersion;
    private final String theme;

    public Env() {
        this((String) null, (String) null, (String) null, 0, (String) null, (String) null, (String) null, (String) null, 255, (DefaultConstructorMarker) null);
    }

    @SerialName("VERSION_SDK_INT")
    public static /* synthetic */ void getAppAPI$annotations() {
    }

    @SerialName("VERSION_RELEASE")
    public static /* synthetic */ void getAppVersion$annotations() {
    }

    @SerialName("LANG")
    public static /* synthetic */ void getLang$annotations() {
    }

    @SerialName("LOC")
    public static /* synthetic */ void getLoc$annotations() {
    }

    @SerialName("MANUFACTURER")
    public static /* synthetic */ void getManufacturer$annotations() {
    }

    @SerialName("MODEL")
    public static /* synthetic */ void getModel$annotations() {
    }

    @SerialName("VN_NAME")
    public static /* synthetic */ void getSdkVersion$annotations() {
    }

    @SerialName("THEME")
    public static /* synthetic */ void getTheme$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getManufacturer() {
        return this.manufacturer;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getModel() {
        return this.model;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAppVersion() {
        return this.appVersion;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getAppAPI() {
        return this.appAPI;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getLoc() {
        return this.loc;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getLang() {
        return this.lang;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getTheme() {
        return this.theme;
    }

    public final Env copy(String manufacturer, String model, String appVersion, int appAPI, String sdkVersion, String loc, String lang, String theme) {
        Intrinsics.checkNotNullParameter(manufacturer, "manufacturer");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        Intrinsics.checkNotNullParameter(loc, "loc");
        Intrinsics.checkNotNullParameter(lang, "lang");
        Intrinsics.checkNotNullParameter(theme, "theme");
        return new Env(manufacturer, model, appVersion, appAPI, sdkVersion, loc, lang, theme);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Env)) {
            return false;
        }
        Env env = (Env) other;
        return Intrinsics.areEqual(this.manufacturer, env.manufacturer) && Intrinsics.areEqual(this.model, env.model) && Intrinsics.areEqual(this.appVersion, env.appVersion) && this.appAPI == env.appAPI && Intrinsics.areEqual(this.sdkVersion, env.sdkVersion) && Intrinsics.areEqual(this.loc, env.loc) && Intrinsics.areEqual(this.lang, env.lang) && Intrinsics.areEqual(this.theme, env.theme);
    }

    public int hashCode() {
        return (((((((((((((this.manufacturer.hashCode() * 31) + this.model.hashCode()) * 31) + this.appVersion.hashCode()) * 31) + Integer.hashCode(this.appAPI)) * 31) + this.sdkVersion.hashCode()) * 31) + this.loc.hashCode()) * 31) + this.lang.hashCode()) * 31) + this.theme.hashCode();
    }

    public String toString() {
        return "Env(manufacturer=" + this.manufacturer + ", model=" + this.model + ", appVersion=" + this.appVersion + ", appAPI=" + this.appAPI + ", sdkVersion=" + this.sdkVersion + ", loc=" + this.loc + ", lang=" + this.lang + ", theme=" + this.theme + ')';
    }

    /* JADX INFO: compiled from: Env.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/login/impl/data/model/Env$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/taptap/sdk/login/impl/data/model/Env;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Env> serializer() {
            return Env$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ Env(int seen1, @SerialName("MANUFACTURER") String manufacturer, @SerialName("MODEL") String model, @SerialName("VERSION_RELEASE") String appVersion, @SerialName("VERSION_SDK_INT") int appAPI, @SerialName("VN_NAME") String sdkVersion, @SerialName("LOC") String loc, @SerialName("LANG") String lang, @SerialName("THEME") String theme, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen1 & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(seen1, 0, Env$$serializer.INSTANCE.getDescriptor());
        }
        if ((seen1 & 1) == 0) {
            String MANUFACTURER = Build.MANUFACTURER;
            Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
            this.manufacturer = MANUFACTURER;
        } else {
            this.manufacturer = manufacturer;
        }
        if ((seen1 & 2) == 0) {
            String MODEL = Build.MODEL;
            Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
            this.model = MODEL;
        } else {
            this.model = model;
        }
        if ((seen1 & 4) == 0) {
            String RELEASE = Build.VERSION.RELEASE;
            Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
            this.appVersion = RELEASE;
        } else {
            this.appVersion = appVersion;
        }
        if ((seen1 & 8) == 0) {
            this.appAPI = Build.VERSION.SDK_INT;
        } else {
            this.appAPI = appAPI;
        }
        if ((seen1 & 16) == 0) {
            this.sdkVersion = "4.10.9";
        } else {
            this.sdkVersion = sdkVersion;
        }
        if ((seen1 & 32) == 0) {
            String displayName = CommonUtils.getCurrentLocale().getDisplayName();
            Intrinsics.checkNotNullExpressionValue(displayName, "getCurrentLocale().displayName");
            this.loc = displayName;
        } else {
            this.loc = loc;
        }
        if ((seen1 & 64) == 0) {
            this.lang = TapLocalizeUtil.getPreferredLanguage().getLanguage();
        } else {
            this.lang = lang;
        }
        if ((seen1 & 128) == 0) {
            this.theme = UIExtKt.getThemeText();
        } else {
            this.theme = theme;
        }
    }

    public Env(String manufacturer, String model, String appVersion, int appAPI, String sdkVersion, String loc, String lang, String theme) {
        Intrinsics.checkNotNullParameter(manufacturer, "manufacturer");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        Intrinsics.checkNotNullParameter(loc, "loc");
        Intrinsics.checkNotNullParameter(lang, "lang");
        Intrinsics.checkNotNullParameter(theme, "theme");
        this.manufacturer = manufacturer;
        this.model = model;
        this.appVersion = appVersion;
        this.appAPI = appAPI;
        this.sdkVersion = sdkVersion;
        this.loc = loc;
        this.lang = lang;
        this.theme = theme;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$tap_login_release(Env self, CompositeEncoder output, SerialDescriptor serialDesc) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5 = false;
        if (output.shouldEncodeElementDefault(serialDesc, 0)) {
            z = true;
        } else {
            String str = self.manufacturer;
            String MANUFACTURER = Build.MANUFACTURER;
            Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
            z = !Intrinsics.areEqual(str, MANUFACTURER);
        }
        if (z) {
            output.encodeStringElement(serialDesc, 0, self.manufacturer);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1)) {
            z2 = true;
        } else {
            String str2 = self.model;
            String MODEL = Build.MODEL;
            Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
            z2 = !Intrinsics.areEqual(str2, MODEL);
        }
        if (z2) {
            output.encodeStringElement(serialDesc, 1, self.model);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2)) {
            z3 = true;
        } else {
            String str3 = self.appVersion;
            String RELEASE = Build.VERSION.RELEASE;
            Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
            z3 = !Intrinsics.areEqual(str3, RELEASE);
        }
        if (z3) {
            output.encodeStringElement(serialDesc, 2, self.appVersion);
        }
        boolean z6 = output.shouldEncodeElementDefault(serialDesc, 3) || self.appAPI != Build.VERSION.SDK_INT;
        if (z6) {
            output.encodeIntElement(serialDesc, 3, self.appAPI);
        }
        boolean z7 = output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.sdkVersion, "4.10.9");
        if (z7) {
            output.encodeStringElement(serialDesc, 4, self.sdkVersion);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5)) {
            z4 = true;
        } else {
            String str4 = self.loc;
            String displayName = CommonUtils.getCurrentLocale().getDisplayName();
            Intrinsics.checkNotNullExpressionValue(displayName, "getCurrentLocale().displayName");
            z4 = !Intrinsics.areEqual(str4, displayName);
        }
        if (z4) {
            output.encodeStringElement(serialDesc, 5, self.loc);
        }
        boolean z8 = output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.lang, TapLocalizeUtil.getPreferredLanguage().getLanguage());
        if (z8) {
            output.encodeStringElement(serialDesc, 6, self.lang);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || !Intrinsics.areEqual(self.theme, UIExtKt.getThemeText())) {
            z5 = true;
        }
        if (z5) {
            output.encodeStringElement(serialDesc, 7, self.theme);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ Env(String str, String str2, String str3, int i, String str4, String str5, String str6, String str7, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        String MANUFACTURER;
        String MODEL;
        String RELEASE;
        String displayName;
        if ((i2 & 1) != 0) {
            MANUFACTURER = Build.MANUFACTURER;
            Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
        } else {
            MANUFACTURER = str;
        }
        if ((i2 & 2) != 0) {
            MODEL = Build.MODEL;
            Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        } else {
            MODEL = str2;
        }
        if ((i2 & 4) != 0) {
            RELEASE = Build.VERSION.RELEASE;
            Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
        } else {
            RELEASE = str3;
        }
        int i3 = (i2 & 8) != 0 ? Build.VERSION.SDK_INT : i;
        String str8 = (i2 & 16) != 0 ? "4.10.9" : str4;
        if ((i2 & 32) != 0) {
            displayName = CommonUtils.getCurrentLocale().getDisplayName();
            Intrinsics.checkNotNullExpressionValue(displayName, "getCurrentLocale().displayName");
        } else {
            displayName = str5;
        }
        this(MANUFACTURER, MODEL, RELEASE, i3, str8, displayName, (i2 & 64) != 0 ? TapLocalizeUtil.getPreferredLanguage().getLanguage() : str6, (i2 & 128) != 0 ? UIExtKt.getThemeText() : str7);
    }

    public final String getManufacturer() {
        return this.manufacturer;
    }

    public final String getModel() {
        return this.model;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final int getAppAPI() {
        return this.appAPI;
    }

    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    public final String getLoc() {
        return this.loc;
    }

    public final String getLang() {
        return this.lang;
    }

    public final String getTheme() {
        return this.theme;
    }
}
