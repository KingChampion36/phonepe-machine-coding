package com.phonepe.app.version.management.system.service;

import com.phonepe.app.version.management.system.model.AppVersionDetails;
import com.phonepe.app.version.management.system.model.Device;

public interface AppService {
  void uploadNewVersion(AppVersionDetails appVersionDetails);
  String createUpdatePatch(AppVersionDetails oldVersion, AppVersionDetails newVersion);
  void releaseVersion(AppVersionDetails newVersion);
  boolean checkForInstall(Device device, AppVersionDetails appVersionDetails);
  boolean checkForUpdates(Device device, AppVersionDetails appVersionDetails);
}
