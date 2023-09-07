///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.framework.common.ui;
//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//import com.framework.common.service.security.MyUserDetailsService;
//import com.framework.common.ui.util.GenerarArchivoInterfazBackOffice;
//import com.vaadin.shared.ui.label.ContentMode;
//import com.vaadin.ui.HorizontalLayout;
//import com.vaadin.ui.Label;
//import com.vaadin.ui.ProgressBar;
//import com.vaadin.ui.UI;
//import com.vaadin.ui.Upload;
//import com.vaadin.ui.VerticalLayout;
//import com.vaadin.ui.Window;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import org.vaadin.dialogs.ConfirmDialog;
//import com.framework.common.ui.util.ValidarCampos;
//import com.ibm.icu.util.Calendar;
//import com.ibm.icu.util.GregorianCalendar;
//import com.jensjansson.pagedtable.PagedTable;
//import com.quasar.frameq.db.Facade;
//import com.vaadin.data.Item;
//import com.vaadin.data.util.IndexedContainer;
//import com.vaadin.data.util.filter.SimpleStringFilter;
//import com.vaadin.event.FieldEvents;
//import com.vaadin.event.SelectionEvent;
//import com.vaadin.server.FileDownloader;
//import com.vaadin.server.FileResource;
//import com.vaadin.server.Resource;
//import com.vaadin.server.Sizeable;
//import com.vaadin.server.ThemeResource;
//import com.vaadin.ui.Alignment;
//import com.vaadin.ui.Button;
//import com.vaadin.ui.Button.ClickEvent;
//import com.vaadin.ui.Button.ClickListener;
//import com.vaadin.ui.Embedded;
//import com.vaadin.ui.Grid;
//import com.vaadin.ui.GridLayout;
//import com.vaadin.ui.Notification;
//import com.vaadin.ui.Panel;
//import com.vaadin.ui.TextField;
//import java.io.BufferedWriter;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileWriter;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.io.PrintWriter;
//import java.sql.SQLException;
//import java.text.SimpleDateFormat;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.Date;
//import java.util.Locale;
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import jxl.write.DateTime;
//import net.sf.jasperreports.engine.export.JRPdfExporter;
//import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.comparator.LastModifiedFileComparator;
//import org.jboss.util.stream.NullOutputStream;
//import org.mozilla.universalchardet.UniversalDetector;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
///**
// *
// * @author Cristian
// */
//public class MainView extends Window {
//    
//
//
//public class LoginPanel extends Window {
//
//    private Window loginModal;
//
//    public LoginPanel() {
//        super("Wymagana autoryzacja");   
//        center();
//        setClosable(true);
//        setModal(true);
//        setContent(loginModal);
//    }
//}
//} 
//
