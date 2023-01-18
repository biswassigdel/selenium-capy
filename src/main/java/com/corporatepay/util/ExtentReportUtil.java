package com.corporatepay.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.*;

public class ExtentReportUtil {

    @BeforeSuite
    public static ExtentReports getExtentReports() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("CORPORATE.html");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setCss("css-string");
        sparkReporter.config().setDocumentTitle("Corporate-Pay Test Script");
        sparkReporter.config().setTimelineEnabled(true);
        sparkReporter.config().setEncoding("utf-8");
        sparkReporter.config().setJs("js-string");
        sparkReporter.config().setProtocol(Protocol.HTTPS);
        sparkReporter.config().setReportName("Corporate Pay test Report");
        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        return extentReports;
    }

    @AfterSuite
    public static void getFlushReport() {
       getExtentReports().flush();
    }
}
