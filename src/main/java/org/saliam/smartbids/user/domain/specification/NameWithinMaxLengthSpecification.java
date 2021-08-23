package org.saliam.smartbids.user.domain.specification;

import org.saliam.smartbids.commons.validation.Specification;
import org.saliam.smartbids.user.domain.entity.User;

public class NameWithinMaxLengthSpecification implements Specification<User>
{
  @Override
  public boolean IsSatisfiedBy(User subject)
  {
    return !subject.getUsername().isEmpty() && subject.getUsername().length() < 50;
  }
}
