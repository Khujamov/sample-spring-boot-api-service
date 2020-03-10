/*
 * This program and the accompanying materials are made available and may be used, at your option, under either:
 * * Eclipse Public License v2.0, available at https://www.eclipse.org/legal/epl-v20.html, OR
 * * Apache License, version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 *
 * SPDX-License-Identifier: EPL-2.0 OR Apache-2.0
 *
 * Copyright Contributors to the Zowe Project.
 */
package org.zowe.commons.spring.config;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import java.util.HashMap;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ZoweWebSecurityConfigTest {

    @InjectMocks
    ZoweWebSecurityConfig zoweWebSecurityConfig;

    @InjectMocks
    HttpSecurity http;

    @Mock
    ObjectPostProcessor<Object> objectPostProcessor;

    @Mock
    HashMap<Object, Object> map;

    @Mock
    AuthenticationManagerBuilder authenticationManagerBuilder;

    @Mock
    ZoweAuthenticationUtility authConfigurationProperties;

    @Before

    public void setup() {
    }

    @Test
    public void configure() throws Exception {
        when(authConfigurationProperties.getServiceLoginEndpoint()).thenReturn("/login");
        zoweWebSecurityConfig.configure(http);

        Assert.assertNotNull(http);
    }
}
