/*
 * This program and the accompanying materials are made available and may be used, at your option, under either:
 * * Eclipse Public License v2.0, available at https://www.eclipse.org/legal/epl-v20.html, OR
 * * Apache License, version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 *
 * SPDX-License-Identifier: EPL-2.0 OR Apache-2.0
 *
 * Copyright Contributors to the Zowe Project.
 */
package org.zowe.sample.apiservice.test;

import org.junit.Before;
import org.zowe.commons.spring.config.ZoweAuthenticationUtility;

public class IntegrationTests {
    protected ServiceUnderTest serviceUnderTest = ServiceUnderTest.getInstance();
    protected String token = null;
    protected String cookieName = null;
    ZoweAuthenticationUtility authConfigurationProperties
        = new ZoweAuthenticationUtility();

    @Before
    public void setup() {
        serviceUnderTest.waitUntilIsReady();
        this.token = authConfigurationProperties.BEARER_AUTHENTICATION_PREFIX + serviceUnderTest.login();
        this.cookieName = serviceUnderTest.getCookieName();
    }
}
