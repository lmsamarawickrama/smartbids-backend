package org.saliam.smartbids.user.domain.specification;

import org.saliam.smartbids.commons.validation.Specification;
import org.saliam.smartbids.user.domain.entity.User;
import org.saliam.smartbids.user.domain.port.out.UserRepository;

public class UserNotExistsSpecification implements Specification<User>
{
  private final UserRepository userRepository;

  public UserNotExistsSpecification(UserRepository userRepository)
  {
    this.userRepository = userRepository;
  }

  @Override
  public boolean IsSatisfiedBy(User subject)
  {
    return !userRepository.existsByUsername(subject.getUsername()) && !userRepository.existsByEmail(subject.getEmail());
  }
}
