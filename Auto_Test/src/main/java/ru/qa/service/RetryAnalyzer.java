package ru.qa.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
//import org.testng.IRetryAnalyzer;
//import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private static final Logger log = LoggerFactory.getLogger(RetryAnalyzer.class);

    private int retryCount;
    private static final int maxRetryCount = 1;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            log.error("Тест завершился неудачно, повторная попытка запуска!");
            return true;
        }
        log.error("!!! ТЕСТ ЗАВЕРШЕН НЕУДАЧНО ПОСЛЕ " + retryCount + " ПОПЫТОК !!!");
        return false;
    }
}
