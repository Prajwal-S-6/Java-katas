package com.java.katas;

public interface DatabaseAccess {
    Employee getEmployeeById(int employeeId);

    double lookupValue(String namedConstant);
}
