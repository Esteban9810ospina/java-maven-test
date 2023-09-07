/*
 * Informacion de Valoracion framework, Bolsa de Valores de Colombia BVC
 * Copyright (C) 2012 Quasar Software Ltda.
 */
package com.framework.common.ui;

import com.quasar.frameq.db.AppConfigParams;
import com.quasar.frameq.exception.FrameworkNegocioException;
import com.quasar.frameq.exception.FrameworkSistemaException;
import com.framework.common.ui.Notifier;
import com.framework.common.ui.Notifier.MessageWrapper;
import com.framework.common.ui.Notifier.Mode;
import com.framework.common.ui.Task;

import com.vaadin.ui.Component;
import com.vaadin.ui.ProgressIndicator;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.*;
import java.util.Locale;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.MessageSource;

/**
 * @author Roger Padilla C.
 * @author Carlos Uribe [curibe@quasarbi.com].
 */
@Configurable(preConstruction = true)
public class BaseComponent extends VerticalLayout {

  @Resource
  protected MessageSource messages;
  protected final Logger logger = LoggerFactory.getLogger(getClass());
  protected AppConfigParams appConfigParams = AppConfigParams.getInstance();
  protected ProgressIndicator progressIndicator;

  protected void runInBackground(Task tarea) {
    Worker work = new Worker(tarea);
    work.start();
  }

  private void showProgress() {
    progressIndicator = new ProgressIndicator();
    progressIndicator.setIndeterminate(true);
    addComponent(progressIndicator);
  }

  private void hideProgress() {
    removeComponent(progressIndicator);
    progressIndicator = null;
  }

  protected Window getMainWindow() {
    return getMainWindow();
  }

  public String getMessage(String code, Object... args) {
    return messages.getMessage(code, args, Locale.ROOT);
  }

  public String getMessage(String code) {
    return getMessage(code, (Object[]) null);
  }

  public void setContent(Component component) {
    removeAllComponents();
    addComponent(component);
  }

  public AppConfigParams getAppConfigParams() {
    return appConfigParams;
  }

  class Worker extends Thread {

    private Task task;

    Worker(Task tarea) {
      this.task = tarea;
    }

    @Override
    public void start() {
      showProgress();
      task.beforeStart();
      super.start();
    }

    @Override
    public void run() {
      try {
        task.execute();
      } catch (FrameworkNegocioException ex) {
        assessErrorType(ex);
      } catch (FrameworkSistemaException ex) {
        assessErrorType(ex);
      } catch (RuntimeException ex) {
        notifyAndLog(ex);
      } finally {
        try {
          task.complete();
        } catch (FrameworkNegocioException ex) {
          assessErrorType(ex);
        } catch (FrameworkSistemaException ex) {
          assessErrorType(ex);
        } catch (RuntimeException ex) {
          notifyAndLog(ex);
        } finally {
          hideProgress();
        }
      }
    }

    private void assessErrorType(RuntimeException ex) {
      notifyAndLog(ex);
    }

    private void notifyAndLog(Throwable ex) {
      Notification notification;

      if (ex instanceof FrameworkNegocioException) {
        String message = ex.getMessage();
        notification = Notifier.warn(new MessageWrapper("Atenci&oacute;n", message), Mode.TEXTUAL_ARGS);
        logger.warn("OPA - " + "Excepcion de negocio. {} ", ex.getMessage());
      } else {
        String message = getMessage("error.unspecified_runtime_control_flow");
        notification = Notifier.error(new MessageWrapper("Error t&eacute;cnico", message), Mode.TEXTUAL_ARGS);
        logger.error("Error tecnico.", ex);
      }

      getUI().showNotification(notification);
    }
  }

  public void appendContent(Component component) {
    removeAllComponents();
    addComponents();
    addComponent(component);
  }

  protected void addComponents() {
  }
}
