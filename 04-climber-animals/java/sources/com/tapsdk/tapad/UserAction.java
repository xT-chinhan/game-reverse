package com.tapsdk.tapad;

/* JADX INFO: loaded from: classes3.dex */
public class UserAction {
    public final long actionTime;
    public final int actionType;
    public final int amount;
    public final int winStatus;

    public static class Builder {
        private long actionTime;
        private int actionType;
        private int amount;
        private int winStatus;

        public UserAction build() {
            return new UserAction(this);
        }

        public Builder withActionTime(long j) {
            this.actionTime = j;
            return this;
        }

        public Builder withActionType(int i) {
            this.actionType = i;
            return this;
        }

        public Builder withAmount(int i) {
            this.amount = i;
            return this;
        }

        public Builder withWinStatus(int i) {
            this.winStatus = i;
            return this;
        }
    }

    public UserAction(Builder builder) {
        this.actionType = builder.actionType;
        this.actionTime = builder.actionTime;
        this.amount = builder.amount;
        this.winStatus = builder.winStatus;
    }
}
