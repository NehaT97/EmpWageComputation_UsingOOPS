package com.computaion;
import java.util.ArrayList;
import java.util.HashMap;


class EmpWageUsingOOPS implements InEmployeeWageOops {
    //constants
    public static final int IS_FULL_TIME = 1;
    public static final int IS_PART_TIME = 2;
    int daySalary;
    //list
    ArrayList<Integer> dailyWage = new ArrayList<Integer>();
    ArrayList<CompanyEmpWage> CompanyEmpWageArrayList;
    HashMap<String, CompanyEmpWage> CompanyEmpWageMap;

    public EmpWageUsingOOPS() {
        CompanyEmpWageArrayList = new ArrayList<>();
        CompanyEmpWageMap = new HashMap<>();
    }

    public void dailyWage() {
        dailyWage.add(daySalary);
    }

    public void addCompanyEmpWage(String company, int empRatePerHr, int numberOfWorkingDays, int maxHrPerMonth) {
        CompanyEmpWage companyEmpWage = new CompanyEmpWage(company, empRatePerHr, numberOfWorkingDays, maxHrPerMonth);
        CompanyEmpWageArrayList.add(companyEmpWage);
        CompanyEmpWageMap.put(company, companyEmpWage);
    }

    public void computeEmpWage() {
        for (int i = 0; i < CompanyEmpWageArrayList.size(); i++) {
            CompanyEmpWage companyEmpWage = CompanyEmpWageArrayList.get(i);
            companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
        }
    }

    public int computeEmpWage(CompanyEmpWage companyEmpWage) {
        int empHrs = 0;
        int totalEmpHrs = 0;
        int totalWorkingDays = 0;

        while (totalEmpHrs <= companyEmpWage.maxHrPerMonth && totalWorkingDays < companyEmpWage.numberOfWorkingDays) {
            totalWorkingDays++;
            double empCheck = Math.floor(Math.random() * 10) % 3;
            switch ((int) empCheck) {
                case IS_FULL_TIME:
                    empHrs = 8;
                    break;
                case IS_PART_TIME:
                    empHrs = 4;
                    break;
                default:
                    empHrs = 0;
            }
            int daySalary = empHrs * companyEmpWage.empRatePerHr;
            companyEmpWage.dailyWage.add(daySalary);
            totalEmpHrs += empHrs;
            System.out.println("totalWorkingDays: " + totalWorkingDays + "/ daily empHrs: " + empHrs + "/ totalEmpHrs: " + totalEmpHrs);
        }
        System.out.println("\nTotal emp wage : " + (totalEmpHrs * companyEmpWage.empRatePerHr) + "\n");
        return totalEmpHrs * companyEmpWage.empRatePerHr;
    }

    public int getTotalEmpWage(String company) {
        return CompanyEmpWageMap.get(company).totalEmpWage;
    }

}

