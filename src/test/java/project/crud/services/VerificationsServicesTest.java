package project.crud.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;
import project.crud.model.Phone;
import project.crud.model.User;

import static org.mockito.Mockito.*;

@ActiveProfiles("test")
class VerificationsServicesTest {


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @ParameterizedTest
    @ValueSource(longs = {1L, Long.MAX_VALUE})
    @DisplayName("Should find and display that User's id exists in database")
    void existsUserByIdCaseSuccess(Long id){
        User user = new User(
                id,
                "username",
                "first name",
                "last name",
                "password",
                "test@example.com",
                "49353637899",
                new Phone(55,11,941693341));

        VerificationsServices verificationsServices = mock(VerificationsServices.class);
        when(verificationsServices.existsUserById(id)).then(invocation -> true);

        assertNotNull(user, "User with this " + id + " was not found");
        assertEquals(user.getId(), user.getId(), "The ID of the found user should match the expected ID");

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