package pl.com.bottega.documentmanagement.infrastructure;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import pl.com.bottega.documentmanagement.api.EmployeeDetails;

import pl.com.bottega.documentmanagement.api.PrintSystemFacade;
import pl.com.bottega.documentmanagement.domain.Document;

import java.util.Set;


/**
 * Created by bernard.boguszewski on 21.08.2016.
 */
@Component
public class PrintSystemFacadeImpl implements PrintSystemFacade {

    @Override
    public void printDocument(Document document, Set<EmployeeDetails> employeeDetailsSet) {
        for (EmployeeDetails employeeDetails : employeeDetailsSet){
            Logger.getLogger(PrintSystemFacade.class).info("Printing document for" + employeeDetails.getFirstName() + " " +
                    employeeDetails.getLastName() + " with mail " + employeeDetails.getEmail());
        }
    }
}
