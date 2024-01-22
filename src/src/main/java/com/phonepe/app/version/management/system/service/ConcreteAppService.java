package com.phonepe.app.version.management.system.service;

import com.phonepe.app.version.management.system.model.AppVersionDetails;
import com.phonepe.app.version.management.system.model.Device;
import com.phonepe.app.version.management.system.repository.AppVersionDetailsRepository;
import com.phonepe.app.version.management.system.repository.DeviceRepository;
import com.phonepe.app.version.management.system.rollout.RolloutStrategy;
import com.phonepe.app.version.management.system.utility.AppUtility;

public class ConcreteAppService implements AppService {

  private final AppVersionDetailsRepository appVersionDetailsRepository;
  private final RolloutStrategy rolloutStrategy;
  private final DeviceRepository deviceRepository;

  public ConcreteAppService(AppVersionDetailsRepository appVersionDetailsRepository, RolloutStrategy rolloutStrategy, DeviceRepository deviceRepository) {
    this.appVersionDetailsRepository = appVersionDetailsRepository;
    this.rolloutStrategy = rolloutStrategy;
    this.deviceRepository = deviceRepository;
  }

  @Override
  public void uploadNewVersion(AppVersionDetails appVersionDetails) {
    appVersionDetailsRepository.uploadNewVersion(appVersionDetails);
  }

  @Override
  public String createUpdatePatch(AppVersionDetails oldVersion, AppVersionDetails newVersion) {
    return AppUtility.createDiffPack(oldVersion.getVersion(), newVersion.getVersion());
  }

  @Override
  public void releaseVersion(AppVersionDetails newVersion) {
    rolloutStrategy.rollout(newVersion);
  }

  @Override
  public boolean checkForInstall(Device device, AppVersionDetails appVersionDetails) {
    return deviceRepository.checkForInstall(device, appVersionDetails);
  }

  @Override
  public boolean checkForUpdates(Device device, AppVersionDetails appVersionDetails) {
    return deviceRepository.checkForUpdates(device, appVersionDetails);
  }
}
