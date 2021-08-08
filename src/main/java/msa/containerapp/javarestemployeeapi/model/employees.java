package msa.containerapp.javarestemployeeapi.model;

import java.util.ArrayList;
import java.util.List;

public class employees {
    private List<employee> employeeList;
    
    public List<employee> getEmployeeList() {
        if(employeeList == null) {
            employeeList = new ArrayList<>();
        }
        return employeeList;
    }
  
    public void setEmployeeList(List<employee> employeeList) {
        this.employeeList = employeeList;
    }
    
}
