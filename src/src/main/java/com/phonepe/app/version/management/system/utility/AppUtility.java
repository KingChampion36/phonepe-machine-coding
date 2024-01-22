package com.phonepe.app.version.management.system.utility;

import com.phonepe.app.version.management.system.model.AppVersionDetails;
import com.phonepe.app.version.management.system.model.Version;

import java.util.Arrays;
import java.util.UUID;

public class AppUtility {
  public static void installApp(AppVersionDetails appVersionDetails) {
    // This is supposed to be already implemented
    System.out.println("App with version " + appVersionDetails.getVersion().toString() + " successfully installed");
  }

  public static void updateApp(AppVersionDetails oldVersion, AppVersionDetails newVersion) {
    // This is supposed to be already implemented
    String diff = createDiffPack(oldVersion.getVersion(), newVersion.getVersion());
    System.out.println("App with version " + oldVersion.getVersion() + " successfully updated to version " + newVersion.getVersion().toString() + " with diff " + diff);
  }

  public static String createDiffPack(Version oldVersion, Version newVersion) {
    // This is supposed to be already implemented
    System.out.println("Diff Pack created - old version: " + oldVersion + ", new version: " + newVersion);
    return UUID.randomUUID().toString();
  }

  public static String uploadFile(AppVersionDetails appVersionDetails) {
    // This is supposed to be already implemented
    return "http://localhost:8080/" + Arrays.toString(appVersionDetails.getFile()) + "/" + appVersionDetails.getVersion();
  }

  public static String getFile(String fileUrl) {
    // This is supposed to be already implemented
    return UUID.randomUUID().toString();
  }
}
