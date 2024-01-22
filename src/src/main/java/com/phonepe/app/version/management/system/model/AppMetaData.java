package com.phonepe.app.version.management.system.model;

public final class AppMetaData {
  private final Version minimumSupportedAndroidVersion;
  private final Version minimumSupportedIOSVersion;

  public AppMetaData(Version minimumSupportedAndroidVersion, Version minimumSupportedIOSVersion) {
    this.minimumSupportedAndroidVersion = minimumSupportedAndroidVersion;
    this.minimumSupportedIOSVersion = minimumSupportedIOSVersion;
  }

  public Version getMinimumSupportedAndroidVersion() {
    return minimumSupportedAndroidVersion;
  }

  public Version getMinimumSupportedIOSVersion() {
    return minimumSupportedIOSVersion;
  }

  @Override
  public String toString() {
    return "AppMetaData{" +
      "minimumSupportedAndroidVersion='" + minimumSupportedAndroidVersion + '\'' +
      ", minimumSupportedIOSVersion='" + minimumSupportedIOSVersion + '\'' +
      '}';
  }
}
