package com.java.katas;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class DiscountApplierTest {

    @InjectMocks
    private DiscountApplier discountApplier;

    @Mock
    private Notifier notifier;

    @Captor
    private ArgumentCaptor<String> messageArgumentCaptor;

    @Captor
    private ArgumentCaptor<User> userArgumentCaptor;

    @Test
    void should_notify_twice_when_applying_discount_for_two_users_v1() {
        // TODO: trigger the bug in DiscountApplier.applyV1() by implementing the Notifier interface
        discountApplier.applyV1(5, List.of(new User("user1", "user1@gmail.com"),
                new User("user2", "user2@gmail.com")));

        verify(notifier, times(2)).notify(userArgumentCaptor.capture(), messageArgumentCaptor.capture());
        List<String> messages = messageArgumentCaptor.getAllValues();
        List<User> users = userArgumentCaptor.getAllValues();
        assertAll(
                () -> assertEquals(2, messages.size()),
                () -> assertEquals(2, users.size())
        );
    }

    @Test
    void should_notify_twice_when_applying_discount_for_two_users_v2() {
        // TODO: trigger the bug in DiscountApplier.applyV2() by implementing Notifier interface
    }

}