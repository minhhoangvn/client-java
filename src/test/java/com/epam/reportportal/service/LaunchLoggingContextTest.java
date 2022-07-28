/*
 *  Copyright 2022 EPAM Systems
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.epam.reportportal.service;

import com.epam.reportportal.listeners.ListenerParameters;
import com.epam.reportportal.service.launch.PrimaryLaunch;
import com.epam.ta.reportportal.ws.model.launch.StartLaunchRQ;
import io.reactivex.Maybe;
import io.reactivex.schedulers.Schedulers;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.concurrent.Executors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LaunchLoggingContextTest {

    @Test
    @Order(1)
    public void test_logging_context_current_null_safety() {
        assertNull(LaunchLoggingContext.context("default"));
    }


    @Test
    public void test_logging_context_init() {
        LaunchLoggingContext context = LaunchLoggingContext.init(Maybe.just("launch_id"),
                mock(ReportPortalClient.class),
                Schedulers.from(Executors.newSingleThreadExecutor()));

        assertThat(LaunchLoggingContext.context("default"), sameInstance(context));
    }

    @Test
    public void test_logging_context_init_with_start_launch() {
        PrimaryLaunch primaryLaunch = new PrimaryLaunch(mock(ReportPortalClient.class), new ListenerParameters(),
                new StartLaunchRQ(), Executors.newSingleThreadExecutor(), mock(LaunchIdLock.class), "uid");

        Maybe<String> launchId = primaryLaunch.start();
    }
}
