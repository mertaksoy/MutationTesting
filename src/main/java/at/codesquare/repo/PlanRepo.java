package at.codesquare.repo;

import at.codesquare.dto.PlanTO;

public interface PlanRepo {
    boolean savePlan(PlanTO plan);
}
