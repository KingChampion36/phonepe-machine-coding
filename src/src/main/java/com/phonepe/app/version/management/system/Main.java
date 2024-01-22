package com.phonepe.app.version.management.system;

import com.phonepe.app.version.management.system.enums.DeviceType;
import com.phonepe.app.version.management.system.model.AppMetaData;
import com.phonepe.app.version.management.system.model.AppVersionDetails;
import com.phonepe.app.version.management.system.model.Device;
import com.phonepe.app.version.management.system.model.Version;
import com.phonepe.app.version.management.system.repository.AppVersionDetailsRepository;
import com.phonepe.app.version.management.system.repository.DeviceRepository;
import com.phonepe.app.version.management.system.repository.LocalAppVersionDetailsRepository;
import com.phonepe.app.version.management.system.repository.LocalDeviceRepository;
import com.phonepe.app.version.management.system.rollout.BetaRolloutStrategy;
import com.phonepe.app.version.management.system.rollout.RolloutStrategy;
import com.phonepe.app.version.management.system.service.AppService;
import com.phonepe.app.version.management.system.service.ConcreteAppService;

import java.util.UUID;

public class Main {
  public static void main(String[] args) {
    AppVersionDetailsRepository appVersionDetailsRepository = new LocalAppVersionDetailsRepository();
    DeviceRepository deviceRepository = new LocalDeviceRepository();

    RolloutStrategy betaRolloutStrategy = new BetaRolloutStrategy(deviceRepository);

    Device device1 = new Device(
      "device1",
      false,
      null,
      DeviceType.IOS,
      new Version(10, 0, 0)
    );

    Device device2 = new Device(
      "device2",
      true,
      null,
      DeviceType.ANDROID,
      new Version(10, 0, 0)
    );

    deviceRepository.addDevice(device1);
    deviceRepository.addDevice(device2);

    AppService appService = new ConcreteAppService(appVersionDetailsRepository, betaRolloutStrategy, deviceRepository);
    AppVersionDetails appVersionDetails = new AppVersionDetails(
      new Version(1, 0, 0),
      UUID.randomUUID().toString().getBytes(),
      new AppMetaData(
        new Version(3, 0, 0),
        new Version(3, 0, 0)
      )
    );

    AppVersionDetails appVersionDetails2 = new AppVersionDetails(
      new Version(2, 0, 0),
      UUID.randomUUID().toString().getBytes(),
      new AppMetaData(
        new Version(3, 0, 0),
        new Version(3, 0, 0)
      )
    );

    appService.uploadNewVersion(appVersionDetails);
    System.out.println(appService.checkForInstall(device1, appVersionDetails));
    System.out.println(appService.checkForInstall(device2, appVersionDetails));

    appService.releaseVersion(appVersionDetails);

    String diff = appService.createUpdatePatch(appVersionDetails, appVersionDetails2);

    appService.uploadNewVersion(appVersionDetails2);
    System.out.println(appService.checkForUpdates(device1, appVersionDetails2));
    System.out.println(appService.checkForUpdates(device2, appVersionDetails2));
    appService.releaseVersion(appVersionDetails2);
  }
}
