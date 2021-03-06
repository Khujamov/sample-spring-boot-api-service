/*
 * This program and the accompanying materials are made available and may be used, at your option, under either:
 * * Eclipse Public License v2.0, available at https://www.eclipse.org/legal/epl-v20.html, OR
 * * Apache License, version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 *
 * SPDX-License-Identifier: EPL-2.0 OR Apache-2.0
 *
 * Copyright Contributors to the Zowe Project.
 */

package org.zowe.commons.zos.security.platform;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PlatformErnnoTests {
    @Test
    public void returnsErrno2ValueFromLongHexValue() {
        assertEquals(PlatformErrno2.JRSAFResourceUndefined, PlatformErrno2.valueOfErrno(0x93800CF));
    }

    @Test
    public void returnsAckErrnoValueFromInt() {
        assertEquals(PlatformAckErrno.ESRCH, PlatformAckErrno.valueOfErrno(143));
    }

    @Test
    public void returnsTlsErrnoValueFromInt() {
        assertEquals(PlatformTlsErrno.ESRCH, PlatformTlsErrno.valueOfErrno(143));
    }

    @Test
    public void returnsPwdErrnoValueFromInt() {
        assertEquals(PlatformPwdErrno.ESRCH, PlatformPwdErrno.valueOfErrno(143));
    }
}
