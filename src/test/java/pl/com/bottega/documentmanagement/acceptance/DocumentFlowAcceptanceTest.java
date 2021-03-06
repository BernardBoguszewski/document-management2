package pl.com.bottega.documentmanagement.acceptance;

import com.google.common.collect.Sets;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import pl.com.bottega.documentmanagement.api.DocumentDto;
import pl.com.bottega.documentmanagement.api.DocumentFlowProcess;
import pl.com.bottega.documentmanagement.api.DocumentsCatalog;
import pl.com.bottega.documentmanagement.api.UserManager;
import pl.com.bottega.documentmanagement.domain.DocumentNumber;
import pl.com.bottega.documentmanagement.domain.DocumentStatus;
import pl.com.bottega.documentmanagement.domain.EmployeeId;
import pl.com.bottega.documentmanagement.utils.Assert;

import java.util.Date;

import static org.junit.Assert.*;
import static org.springframework.mock.staticmock.AnnotationDrivenStaticEntityMockingControl.verify;
import static pl.com.bottega.documentmanagement.utils.Assert.assertDatesEqual;

/**
 * Created by bernard.boguszewski on 20.08.2016.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration({"/application.xml"})
@TestPropertySource({"/jdbc-test.properties", "/hibernate-test.properties"})
@WebAppConfiguration
public class DocumentFlowAcceptanceTest {

    @Autowired
    private UserManager userManager;

    @Autowired
    private DocumentFlowProcess documentFlowProcess;

    @Autowired
    private DocumentsCatalog documentsCatalog;

    private String anyLogin = "xxx";
    private String anyPassword = "ppp";
    private Long anyId = 1L;
    private EmployeeId anyEmployeeId = new EmployeeId(anyId);
    private String anyTitle = "test";
    private String anyContent = "test content";

    @Before
    public void setUp(){
        userManager.createAdmin();
    }

    @Test
    @Transactional
    public void shouldCreateDocument(){
        //given
        loginAs("STAFF", "EDITOR");

        //when
        DocumentNumber nr = documentFlowProcess.create(anyTitle, anyContent);

        //then
        DocumentDto dto = documentsCatalog.get(nr);
        assertEquals(anyContent, dto.getContent());
        assertEquals(anyTitle, dto.getTitle());
        assertEquals(nr.getNumber(), dto.getNumber());
        assertDatesEqual(new Date(), dto.getCreatedAt());
    }

    @Test
    public void shouldVerifyDocument(){
        //given
        loginAs("STAFF", "EDITOR", "MANAGER");
        DocumentNumber nr = documentFlowProcess.create(anyTitle, anyContent);

        //when
        documentFlowProcess.verify(nr);

        //then
        DocumentDto dto = documentsCatalog.get(nr);
        assertEquals(DocumentStatus.VERIFIED.name(), dto.getStatus());

    }

    public void loginAs(String... roles){
        userManager.signup(anyLogin, anyPassword, anyEmployeeId);
        userManager.login("admin", "admin");
        userManager.updateRoles(anyEmployeeId, Sets.newHashSet(roles));
        userManager.login(anyLogin, anyPassword);
    }

}
