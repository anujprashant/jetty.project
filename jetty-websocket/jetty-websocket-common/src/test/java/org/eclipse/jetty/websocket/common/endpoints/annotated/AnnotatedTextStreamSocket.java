//
//  ========================================================================
//  Copyright (c) 1995-2018 Mort Bay Consulting Pty. Ltd.
//  ------------------------------------------------------------------------
//  All rights reserved. This program and the accompanying materials
//  are made available under the terms of the Eclipse Public License v1.0
//  and Apache License v2.0 which accompanies this distribution.
//
//      The Eclipse Public License is available at
//      http://www.eclipse.org/legal/epl-v10.html
//
//      The Apache License v2.0 is available at
//      http://www.opensource.org/licenses/apache2.0.php
//
//  You may elect to redistribute this code under either of these licenses.
//  ========================================================================
//

package org.eclipse.jetty.websocket.common.endpoints.annotated;

import java.io.Reader;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import org.eclipse.jetty.websocket.core.util.EventQueue;
import org.eclipse.jetty.websocket.core.util.TextUtil;

@WebSocket
public class AnnotatedTextStreamSocket
{
    public EventQueue events = new EventQueue();
    
    @OnWebSocketClose
    public void onClose(int statusCode, String reason)
    {
        events.add("onClose(%d, %s)", statusCode, TextUtil.quote(reason));
    }
    
    @OnWebSocketConnect
    public void onConnect(Session sess)
    {
        events.add("onConnect(%s)", sess);
    }
    
    @OnWebSocketMessage
    public void onText(Reader reader)
    {
        events.add("onText(%s)", reader);
    }
}