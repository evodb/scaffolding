/*
 * Copyright 2018 The Scaffolding Project
 *
 *  The Scaffolding Project licenses this file to you under the Apache License,
 *  version 2.0 (the "License"); you may not use this file except in compliance
 *  with the License. You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  License for the specific language governing permissions and limitations
 *  under the License.
 *
 */

package io.evodb.common.domain.model;

import java.util.LinkedList;
import java.util.List;

public class DomainEventPublisher {
    private static final ThreadLocal<DomainEventPublisher> instance = new ThreadLocal<DomainEventPublisher>() {
        @Override
        protected DomainEventPublisher initialValue() {
            return new DomainEventPublisher();
        }
    };

    private boolean publishing;

    private List<DomainEventSubscriber> subscribers = new LinkedList<DomainEventSubscriber>();

    private DomainEventPublisher() {
        setPublishing(false);
    }

    public <T> void publish(T aDomainEvent) {
        if (isPublishing() && hasSubscribers()) {
            try {
                setPublishing(true);
                Class<?> eventType = aDomainEvent.getClass();
                for (DomainEventSubscriber subscriber : subscribers()) {
                    Class<T> subscribedToType = subscriber.subscribedToEventType();
                    if (eventType == subscribedToType || DomainEvent.class == subscribedToType) {
                        subscriber.handleEvent(aDomainEvent);
                    }
                }
            } finally {
                setPublishing(false);
            }
        }
    }

    public <T> void subscribe(DomainEventSubscriber<T> aSubscriber) {
        if (!isPublishing()) {
            subscribers().add(aSubscriber);
        }
    }

    public static DomainEventPublisher instance() {
        return instance.get();
    }

    private List<DomainEventSubscriber> subscribers() {
        return subscribers;
    }

    public boolean hasSubscribers() {
        return !subscribers.isEmpty();
    }

    public boolean isPublishing() {
        return publishing;
    }

    public void setPublishing(boolean aFlag) {
        publishing = aFlag;
    }
}
