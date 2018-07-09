package com.xero.mcpews.event;

public abstract class BaseEvent extends Event {
    private int AccountType;
    private String ActiveSessionID;
    private String AppSessionID;
    private String Build;
    private int BuildPlat;
    private boolean Cheevos;
    private String ClientId;
    private int CurrentInput;
    private int DeviceSessionId;
    private int Dim;
    private int Mode;
    private String Plat;
    private int PlayerGameMode;
    private String Treatments;
    private String locale;
    private boolean vrMode;

    public int getAccountType() {
        return AccountType;
    }

    public String getActiveSessionID() {
        return ActiveSessionID;
    }

    public String getAppSessionID() {
        return AppSessionID;
    }

    public String getBuild() {
        return Build;
    }

    public int getBuildPlatform() {
        return BuildPlat;
    }

    public boolean isCheevos() {
        return Cheevos;
    }

    public String getClientId() {
        return ClientId;
    }

    public int getCurrentInput() {
        return CurrentInput;
    }

    public int getDeviceSessionId() {
        return DeviceSessionId;
    }

    public int getDimension() {
        return Dim;
    }

    public int getMode() {
        return Mode;
    }

    public String getPlatform() {
        return Plat;
    }

    public int getPlayerGameMode() {
        return PlayerGameMode;
    }

    public String getTreatments() {
        return Treatments;
    }

    public String getLocale() {
        return locale;
    }

    public boolean isVRMode() {
        return vrMode;
    }
}
