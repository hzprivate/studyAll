package com.springboot.globalexception.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Component
public class LogOut {

    private static final Logger logger = LogManager.getLogger("custom_log");

    private static String thisClassUrl = LogOut.class.getName();

    private LogOut() {

    }

    private static void setSeat() {
        MDC.put("seat", getInvokInfo());
    }

    private static String getInvokInfo() {
        StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        String className = null;
        String methodName = null;
        int lineNumber = 0;
        // 从栈的最上开始 往下找 找到第一个不为Log和线程的类
        for (int i = 0; i < ste.length; i++) {
            className = ste[i].getClassName();

            if ("java.lang.Thread".equals(className) || thisClassUrl.equals(className)) {
                if (i != (ste.length - 1)) {
                    continue;// 如果不是最后一个就跳过，如果是最后一个那就没办法了，返回这栈信息吧
                }
            }
            methodName = ste[i].getMethodName();
            lineNumber = ste[i].getLineNumber();
            break;
        }
        return className + "." + methodName + "()@" + lineNumber + "";
    }

    public void debug(String arg0) {
        if (logger.isDebugEnabled()) {
            setSeat();
            logger.debug(arg0);
        }
    }

    public void debug(String arg0, Object var1) {
        if (logger.isInfoEnabled()) {
            setSeat();
            logger.debug(arg0, var1);
        }
    }

    public void debug(String arg0, Object var1, Object var2) {
        if (logger.isInfoEnabled()) {
            setSeat();
            logger.debug(arg0, var1, var2);
        }
    }

    public void debug(String arg0, Object var1, Object var2, Object var3) {
        if (logger.isInfoEnabled()) {
            setSeat();
            logger.debug(arg0, var1, var2, var3);
        }
    }

    public void debug(String arg0, Object var1, Object var2, Object var3, Object var4) {
        if (logger.isInfoEnabled()) {
            setSeat();
            logger.debug(arg0, var1, var2, var3, var4);
        }
    }

    public void debug(String arg0, Object var1, Object var2, Object var3, Object var4, Object var5) {
        if (logger.isInfoEnabled()) {
            setSeat();
            logger.debug(arg0, var1, var2, var3, var4, var5);
        }
    }

    public void debug(String arg0, Object var1, Object var2, Object var3, Object var4, Object var5, Object var6) {
        if (logger.isInfoEnabled()) {
            setSeat();
            logger.debug(arg0, var1, var2, var3, var4, var5, var6);
        }
    }

    public void info(String arg0) {
        if (logger.isInfoEnabled()) {
            setSeat();
            logger.info(arg0);
        }
    }


    public void info(String arg0, Object var1) {
        if (logger.isInfoEnabled()) {
            setSeat();
            logger.info(arg0, var1);
        }
    }

    public void info(String arg0, Object var1, Object var2) {
        if (logger.isInfoEnabled()) {
            setSeat();
            logger.info(arg0, var1, var2);
        }
    }

    public void info(String arg0, Object var1, Object var2, Object var3) {
        if (logger.isInfoEnabled()) {
            setSeat();
            logger.info(arg0, var1, var2, var3);
        }
    }

    public void info(String arg0, Object var1, Object var2, Object var3, Object var4) {
        if (logger.isInfoEnabled()) {
            setSeat();
            logger.info(arg0, var1, var2, var3, var4);
        }
    }

    public void info(String arg0, Object var1, Object var2, Object var3, Object var4, Object var5) {
        if (logger.isInfoEnabled()) {
            setSeat();
            logger.info(arg0, var1, var2, var3, var4, var5);
        }
    }

    public void info(String arg0, Object var1, Object var2, Object var3, Object var4, Object var5, Object var6) {
        if (logger.isInfoEnabled()) {
            setSeat();
            logger.info(arg0, var1, var2, var3, var4, var5, var6);
        }
    }

    public void error(Object var1, Throwable var2) {
        if (logger.isErrorEnabled()) {
            setSeat();
            logger.error(var1, var2);
        }
    }

    public void error(Throwable var1) {
        if (logger.isErrorEnabled()) {
            setSeat();
            logger.error(var1);
        }
    }

}
