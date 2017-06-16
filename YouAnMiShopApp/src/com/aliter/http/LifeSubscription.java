package com.aliter.http;

import rx.Subscription;



public interface LifeSubscription{
    void bindSubscription(Subscription subscription);
}

