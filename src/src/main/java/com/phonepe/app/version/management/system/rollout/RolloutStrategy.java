package com.phonepe.app.version.management.system.rollout;

import com.phonepe.app.version.management.system.model.AppVersionDetails;

public interface RolloutStrategy {
  void rollout(AppVersionDetails appVersionDetails);
}
