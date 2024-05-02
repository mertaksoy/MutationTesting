package at.codesquare.service;

import at.codesquare.dto.PlanTO;
import at.codesquare.repo.PlanRepo;

public class SubscriptionService {
    private final PlanRepo planRepo;

    public SubscriptionService(PlanRepo planRepo) {
        this.planRepo = planRepo;
    }

    public boolean subscribe(PlanTO plan) {
        if (plan != null) {
            return planRepo.savePlan(plan);
        }
        return false;
    }

}
