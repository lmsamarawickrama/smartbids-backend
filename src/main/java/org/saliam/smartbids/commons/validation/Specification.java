package org.saliam.smartbids.commons.validation;

public interface Specification<T>
{
  boolean IsSatisfiedBy(T subject);
}
