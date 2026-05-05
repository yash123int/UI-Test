package com.automation;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.time.LocalDateTime;
import java.time.Duration;
import java.time.Instant;

public class Listener implements ITestListener {

    private Instant startTime;

    @Override
    public void onStart(ITestContext context) {
        startTime = Instant.now();
        System.out.println("SUITE STARTED AT: " + LocalDateTime.now());
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("TEST STARTED: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        printResult(result, "PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        printResult(result, "FAILED");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        printResult(result, "SKIPPED");
    }

    @Override
    public void onFinish(ITestContext context) {
        Instant endTime = Instant.now();

        long duration = Duration.between(startTime, endTime).toMillis();

        System.out.println("SUITE FINISHED AT: " + LocalDateTime.now());
        System.out.println("TOTAL EXECUTION TIME: " + duration + " ms");
    }

    private void printResult(ITestResult result, String status) {
        long timeTaken = result.getEndMillis() - result.getStartMillis();

        System.out.println("TEST: " + result.getName());
        System.out.println("STATUS: " + status);
        System.out.println("TIME TAKEN: " + timeTaken + " ms");
        System.out.println("-----------------------------------");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        throw new UnsupportedOperationException("Unimplemented method 'onTestFailedButWithinSuccessPercentage'");
    }
}