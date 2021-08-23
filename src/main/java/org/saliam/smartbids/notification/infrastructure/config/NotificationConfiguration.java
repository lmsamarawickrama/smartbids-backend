package org.saliam.smartbids.notification.infrastructure.config;

import org.saliam.smartbids.notification.domain.port.in.EmailService;
import org.saliam.smartbids.notification.domain.port.in.SelectedBidNotificationListener;
import org.saliam.smartbids.notification.domain.service.EmailServiceImpl;
import org.saliam.smartbids.notification.domain.service.SelectedBidNotificationListenerImpl;
import org.saliam.smartbids.notification.infrastructure.event.AMQPSelectedBidListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfiguration
{
  @Bean
  public AMQPSelectedBidListener getAMQPSelectedBidListener(
      SelectedBidNotificationListener selectedBidNotificationListener)
  {
    return new AMQPSelectedBidListener(selectedBidNotificationListener);
  }

  @Bean
  public SelectedBidNotificationListener getSelectedBidNotificationListener(EmailService emailService)
  {
    return new SelectedBidNotificationListenerImpl(emailService);
  }

  @Bean
  public EmailService getEmailService()
  {
    return new EmailServiceImpl();
  }
}
