package project.crud.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import project.crud.dto.UserDTO;
import project.crud.model.User;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STANDARD)
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);

        Converter<User, UserDTO> userToUserDtoConverter = ctx -> {
            User user = ctx.getSource();
            return new UserDTO(
                    user.getId(),
                    user.getUsername(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getEmail(),
                    user.getPassword(),
                    user.getCpf(),
                    user.getPhoneNumber()
            );
        };
        modelMapper.typeMap(User.class, UserDTO.class).setConverter(userToUserDtoConverter);

        return modelMapper;
    }
}
