package com.byazt.lhc;

import android.os.Parcel;
import android.os.Parcelable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 502, 2262})
public class BaseException extends Exception implements Parcelable {
    public static final Parcelable.Creator<BaseException> CREATOR = new Parcelable.Creator<BaseException>() { // from class: com.byazt.lhc.BaseException.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public BaseException createFromParcel(Parcel parcel) {
            return new BaseException(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public BaseException[] newArray(int i) {
            return new BaseException[i];
        }
    };
    public static final String TAG = "[d-ex]:";
    public int errorCode;
    public String errorMsg;
    public String extraInfo;

    public BaseException() {
        this.extraInfo = "";
    }

    public BaseException(int i, String str) {
        super(TAG.concat(String.valueOf(str)));
        this.extraInfo = "";
        this.errorMsg = TAG.concat(String.valueOf(str));
        this.errorCode = i;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public BaseException(int i, Throwable th) {
        this(i, com.byazt.tuy.uc.vk(th));
    }

    public BaseException(int i, String str, Throwable th) {
        super(TAG.concat(String.valueOf(str)), th);
        this.extraInfo = "";
        this.errorMsg = TAG.concat(String.valueOf(str));
        this.errorCode = i;
    }

    public BaseException(Parcel parcel) {
        this.extraInfo = "";
        readFromParcel(parcel);
    }

    public void readFromParcel(Parcel parcel) {
        this.errorCode = parcel.readInt();
        this.errorMsg = parcel.readString();
        this.extraInfo = parcel.readString();
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMsg;
    }

    public String getExtraInfo() {
        return this.extraInfo;
    }

    public void setExtraInfo(String str) {
        this.extraInfo = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.errorCode);
        parcel.writeString(this.errorMsg);
        parcel.writeString(this.extraInfo);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "BaseException{errorCode=" + this.errorCode + ", errorMsg='" + this.errorMsg + '\'' + AbstractJsonLexerKt.END_OBJ;
    }
}
