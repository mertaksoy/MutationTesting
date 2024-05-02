package at.codesquare.service;

import at.codesquare.dto.PlanTO;
import at.codesquare.repo.PlanRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class SubscriptionServiceTest {

    @InjectMocks
    private SubscriptionService subscriptionService;

    @Mock
    private PlanRepo planRepo;

    @Test
    void givenNoPlan_whenSubscribe_thenPlanIsNotSaved() {
        // Given

        // When
        boolean saved = subscriptionService.subscribe(null);

        // Then
        Assertions.assertFalse(saved);
        Mockito.verify(planRepo, Mockito.never()).savePlan(Mockito.any());
    }


    @Test
    void givenPlan_whenSubscribe_thenPlanIsSaved() {
        // Given
        PlanTO plan = Mockito.mock(PlanTO.class);

        // When
        Mockito.when(planRepo.savePlan(plan)).thenReturn(true);
        boolean saved = subscriptionService.subscribe(plan);

        // Then
        Assertions.assertTrue(saved);
        Mockito.verify(planRepo, Mockito.times(1)).savePlan(plan);
    }

    @Test
    void givenPlan_whenSubscribe_thenPlanIsNotSaved() {
        // Given
        PlanTO plan = Mockito.mock(PlanTO.class);
        Mockito.when(planRepo.savePlan(plan)).thenReturn(false);

        // When
        boolean saved = subscriptionService.subscribe(plan);

        // Then
        Assertions.assertFalse(saved);
        Mockito.verify(planRepo, Mockito.times(1)).savePlan(plan);
    }
}
