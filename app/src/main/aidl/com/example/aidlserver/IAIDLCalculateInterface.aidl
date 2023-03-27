// IAIDLCalculateInterface.aidl
package com.example.aidlserver;

// Declare any non-default types here with import statements

interface IAIDLCalculateInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    double doCalculate(String s);
    String zodiak(int day, int month);
}