/*
 * This program and the accompanying materials are made available and may be used, at your option, under either:
 * * Eclipse Public License v2.0, available at https://www.eclipse.org/legal/epl-v20.html, OR
 * * Apache License, version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 *
 * SPDX-License-Identifier: EPL-2.0 OR Apache-2.0
 *
 * Copyright Contributors to the Zowe Project.
 */
package org.zowe.commons.rest.response;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * The implementation of {@link ApiMessage} should be used in the case when a
 * problem (an error) happens and then the response contains only the error(s).
 */
public class BasicApiMessage implements ApiMessage {
    private final List<Message> messages;

    @JsonCreator
    public BasicApiMessage(
            @JsonProperty("messages") @JsonDeserialize(contentAs = BasicMessage.class) List<Message> messages) {
        this.messages = messages;
    }

    public BasicApiMessage(Message message) {
        this.messages = Collections.singletonList(message);
    }

    @Override
    public List<Message> getMessages() {
        return messages;
    }

    @Override
    public String toReadableText() {
        return getMessages().get(0).toReadableText();
    }

    @Override
    public String toLogMessage() {
        return this.toReadableText() + " {" + this.getMessages().get(0).getMessageInstanceId() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BasicApiMessage)) {
            return false;
        }
        BasicApiMessage that = (BasicApiMessage) o;
        return Objects.equals(messages, that.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messages);
    }

    @Override
    public String toString() {
        return "BasicApiMessage{" + "messages=" + messages + '}';
    }
}
