package com.phonepe.app.version.management.system.model;

import com.phonepe.app.version.management.system.enums.DeviceType;

public final class Device {
  private final String id;
  private final boolean isBetaVersionEnabled;
  private Version appVersion;
  private final DeviceType deviceType;
  private final Version oSVersion;

  public Device(String id, boolean isBetaVersionEnabled, Version appVersion, DeviceType deviceType, Version oSVersion) {
    this.id = id;
    this.isBetaVersionEnabled = isBetaVersionEnabled;
    this.appVersion = appVersion;
    this.deviceType = deviceType;
    this.oSVersion = oSVersion;
  }

  public String getId() {
    return id;
  }

  public boolean isBetaVersionEnabled() {
    return isBetaVersionEnabled;
  }

  public Version getAppVersion() {
    return appVersion;
  }

  public void setAppVersion(Version appVersion) {
    this.appVersion = appVersion;
  }

  public Version getoSVersion() {
    return oSVersion;
  }

  public DeviceType getDeviceType() {
    return deviceType;
  }

  @Override
  public String toString() {
    return "Device{" +
      "id='" + id + '\'' +
      ", isBetaVersionEnabled=" + isBetaVersionEnabled +
      ", appVersion=" + appVersion +
      ", deviceType=" + deviceType +
      ", oSVersion='" + oSVersion + '\'' +
      '}';
  }
}
