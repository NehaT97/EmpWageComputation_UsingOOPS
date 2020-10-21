package com.computaion;

public class getRun {

    public static void main(String[] args) {
        EmpWageUsingOOPS empWageBuilder = new EmpWageUsingOOPS();
        empWageBuilder.addCompanyEmpWage("sbi", 50, 20, 100);
        empWageBuilder.addCompanyEmpWage("sc", 40, 20, 100);
        empWageBuilder.addCompanyEmpWage("boi", 30, 20, 100);
        empWageBuilder.addCompanyEmpWage("uco", 30, 20, 100);
        empWageBuilder.addCompanyEmpWage("sbi", 50, 20, 100);

        empWageBuilder.computeEmpWage();
        System.out.println("Total wage of the searched company: " + empWageBuilder.getTotalEmpWage("sbi"));
    }
}