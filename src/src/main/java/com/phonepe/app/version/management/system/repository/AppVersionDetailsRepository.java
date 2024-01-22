package com.phonepe.app.version.management.system.repository;

import com.phonepe.app.version.management.system.model.AppVersionDetails;
import com.phonepe.app.version.management.system.model.Version;

public interface AppVersionDetailsRepository {
  void uploadNewVersion(AppVersionDetails appVersionDetails);
  Version getLatestVersion();
}
