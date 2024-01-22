package com.phonepe.app.version.management.system.model;

public final class Version {
  private final int majorVersion;
  private final int minorVersion;
  private final int patchVersion;

  public Version(int majorVersion, int minorVersion, int patchVersion) {
    this.majorVersion = majorVersion;
    this.minorVersion = minorVersion;
    this.patchVersion = patchVersion;
  }

  public int getMajorVersion() {
    return majorVersion;
  }

  public int getMinorVersion() {
    return minorVersion;
  }

  public int getPatchVersion() {
    return patchVersion;
  }

  @Override
  public String toString() {
    return majorVersion + "." + minorVersion + "." + patchVersion;
  }
}
