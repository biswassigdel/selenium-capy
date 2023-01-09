package com.corporatepay.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.*;

public class ExtentReportUtil {

    @BeforeSuite
    public static ExtentReports getExtentReports() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("CORPORATE.html");
        sparkReporter.config().setTheme(Theme.DARK);
        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        return extentReports;
    }

    @AfterSuite
    public static void getFlushReport() {
       getExtentReports().flush();
    }
}
