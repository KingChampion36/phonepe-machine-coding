package com.phonepe.app.version.management.system.rollout;

import com.phonepe.app.version.management.system.model.AppVersionDetails;
import com.phonepe.app.version.management.system.repository.DeviceRepository;
import com.phonepe.app.version.management.system.utility.AppUtility;

public class BetaRolloutStrategy implements RolloutStrategy {

  private final DeviceRepository deviceRepository;

  public BetaRolloutStrategy(DeviceRepository deviceRepository) {
    this.deviceRepository = deviceRepository;
  }

  @Override
  public void rollout(AppVersionDetails appVersionDetails) {
    System.out.println(deviceRepository.getAllDevices());
    deviceRepository
      .getAllDevices()
      .stream()
      .filter(d -> d.isBetaVersionEnabled())
      .forEach( d -> {
        String diff = AppUtility.createDiffPack(d.getAppVersion(), appVersionDetails.getVersion());
        deviceRepository.update(d, appVersionDetails, diff);
      });
  }
}
