package project.crud.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;
import project.crud.model.Phone;
import project.crud.model.User;

import static org.mockito.Mockito.when;

@ActiveProfiles("test")
class VerificationsServicesTest {

    @Mock
    private UserServices userServices;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Should find and display that User's id exists in database")
    void existsUserByIdCaseSuccess(){
        User user = new User(
                1L,
                "username",
                "first name",
                "last name",
                "password",
                "test@example.com",
                new Phone(55,11,941693341));

        when(userServices.getUserById(1L)).thenAnswer(invocationOnMock -> user);
    }

    @Test
    @DisplayName("Should not find and display that User's id exists in database")
    void existsUserByIdCaseFailed() {
    }

    @Test
    void existsUserByUsername() {
    }

    @Test
    void existsUserByEmail() {
    }
}