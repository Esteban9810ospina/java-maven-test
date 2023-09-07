/*
 * Informacion de Valoracion framework, Bolsa de Valores de Colombia BVC
 * Copyright (C) 2012 Quasar Software Ltda.
 */
package com.framework.common.ui;

import com.framework.common.domain.BasicData;
import com.vaadin.ui.*;
import java.util.Locale;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.MessageSource;

/**
 * @author Carlos Uribe [curibe@quasarbi.com]
 */
@Configurable(preConstruction = true)
public class Notifier {

  @Resource
  private MessageSource messageSource;

  private static Notifier instance = new Notifier();

  public enum Mode {

    REF_ARGS,
    TEXTUAL_TITLE,
    TEXTUAL_MESSAGE,
    TEXTUAL_ARGS
  }

  public static Notification tray(MessageWrapper wrapper, Mode mode) {
    BasicData basicData = parseParams(wrapper, mode);

    Notification notification = new Notification(basicData.getLabel(), basicData.getValue(), Notification.TYPE_TRAY_NOTIFICATION, true);
    notification.setDelayMsec(200);

    return notification;
  }

  public static Notification warn(MessageWrapper wrapper, Mode mode) {
    BasicData basicData = parseParams(wrapper, mode);

    Notification notification = new Notification(basicData.getLabel(), basicData.getValue(), Notification.TYPE_WARNING_MESSAGE, true);
    notification.setDelayMsec(Notification.DELAY_FOREVER);

    return notification;
  }

  public static Notification error(MessageWrapper wrapper, Mode mode) {
    BasicData basicData = parseParams(wrapper, mode);

    Notification notification = new Notification(basicData.getLabel(), basicData.getValue(), Notification.TYPE_ERROR_MESSAGE, true);
    notification.setPosition(Notification.POSITION_CENTERED);
    notification.setDelayMsec(Notification.DELAY_FOREVER);

    return notification;
  }

  private static BasicData parseParams(MessageWrapper wrapper, Mode mode) {
    String title = "";
    String message = "";

    if (Mode.REF_ARGS.equals(mode)) {
      title = instance.messageSource.getMessage(wrapper.getTitleRef(), wrapper.getArgs(), Locale.ROOT);
      message = instance.messageSource.getMessage(wrapper.getMessageRef(), wrapper.getArgs(), Locale.ROOT);
    } else if (Mode.TEXTUAL_ARGS.equals(mode)) {
      title = wrapper.getTitleRef();
      message = wrapper.getMessageRef();
    } else if (Mode.TEXTUAL_MESSAGE.equals(mode)) {
      title = instance.messageSource.getMessage(wrapper.getTitleRef(), wrapper.getArgs(), Locale.ROOT);
      message = wrapper.getMessageRef();
    } else if (Mode.TEXTUAL_TITLE.equals(mode)) {
      title = wrapper.getTitleRef();
      message = instance.messageSource.getMessage(wrapper.getMessageRef(), wrapper.getArgs(), Locale.ROOT);
    }

    title = title == null ? "" : title;
    message = message == null ? "" : message;

    return new BasicData(title, message);
  }

  public static class MessageWrapper {

    private String titleRef;
    private String messageRef;
    private Object[] args;

    public MessageWrapper(String titleRef, String messageRef) {
      this.titleRef = titleRef;
      this.messageRef = messageRef;
      this.args = new Object[]{};
    }

    public MessageWrapper(String titleRef, String messageRef, Object[] args) {
      this.titleRef = titleRef;
      this.messageRef = messageRef;
      this.args = args;
    }

    public String getTitleRef() {
      return titleRef;
    }

    public String getMessageRef() {
      return messageRef;
    }

    public Object[] getArgs() {
      return args;
    }
  }
}
