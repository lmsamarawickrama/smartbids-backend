package org.saliam.smartbids.user.infrastructure.config;

import org.mapstruct.factory.Mappers;
import org.saliam.smartbids.commons.validation.Specification;
import org.saliam.smartbids.user.domain.entity.User;
import org.saliam.smartbids.user.domain.port.in.UserService;
import org.saliam.smartbids.user.domain.port.out.UserRepository;
import org.saliam.smartbids.user.domain.service.UserServiceImpl;
import org.saliam.smartbids.user.domain.specification.MandatoryAttributesNotEmpty;
import org.saliam.smartbids.user.domain.specification.NameWithinMaxLengthSpecification;
import org.saliam.smartbids.user.domain.specification.UserNotExistsSpecification;
import org.saliam.smartbids.user.domain.specification.UserValidator;
import org.saliam.smartbids.user.infrastructure.adapter.database.mapper.UserEntityMapper;
import org.saliam.smartbids.user.infrastructure.adapter.database.repository.RoleEntityRepository;
import org.saliam.smartbids.user.infrastructure.adapter.database.repository.UserEntityRepository;
import org.saliam.smartbids.user.infrastructure.adapter.database.repository.UserRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class UserConfiguration
{
  @Bean(name = "org.saliam.smartbids.user.domain.port.out.UserRepository")
  public UserRepository getUserRepository(final UserEntityRepository userEntityRepository, final RoleEntityRepository roleEntityRepository)
  {
    return new UserRepositoryAdapter(userEntityRepository, Mappers.getMapper(UserEntityMapper.class),
        roleEntityRepository);
  }

  @Bean(name = "org.saliam.smartbids.user.domain.port.in.UserService")
  public UserService getUserService(final UserRepository userRepository, final UserValidator userValidator, final
                                    PasswordEncoder passwordEncoder)
  {
    return new UserServiceImpl(userRepository, userValidator, passwordEncoder);
  }

  @Bean(name = "org.saliam.smartbids.user.domain.specification.UserValidator")
  public UserValidator getUserValidator(List<Specification<User>> rules)
  {
    return new UserValidator(rules);
  }

  @Bean(name= "org.saliam.smartbids.user.domain.specification.MandatoryAttributesNotEmpty")
  public Specification<User> getMandatoryAttributesNotEmpty(){
    return new MandatoryAttributesNotEmpty();
  }

  @Bean(name = "org.saliam.smartbids.user.domain.specification.NameWithinMaxLengthSpecification")
  public Specification<User> getNameWithinMaxLengthSpecification()
  {
    return new NameWithinMaxLengthSpecification();
  }

  @Bean(name= "org.saliam.smartbids.user.domain.specification.UserNotExistsSpecification")
  public Specification<User> getUserNotExistsSpecification(final UserRepository userRepository){
    return new UserNotExistsSpecification(userRepository);
  }
}
