package com.se.dummytempmonitorbackend.notification;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.io.IOException;
import java.util.List;

public interface NotificationManager {

    int sender(List<String> to, String subject, String description) throws AddressException, MessagingException, IOException;


}
