package com.begin.chapter4.JavaConfig;

import com.begin.chapter2.MessageProvider;

public interface MessageRenderer {
     void render();
     void setMessageProvider(MessageProvider messageProvider);
     MessageProvider getMessageProvider();
}
