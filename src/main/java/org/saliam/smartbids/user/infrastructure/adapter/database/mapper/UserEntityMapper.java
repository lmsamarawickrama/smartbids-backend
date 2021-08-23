package org.saliam.smartbids.user.infrastructure.adapter.database.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.saliam.smartbids.user.domain.entity.User;
import org.saliam.smartbids.user.infrastructure.adapter.database.entity.UserEntity;

@Mapper(uses = RoleEntityMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserEntityMapper
{
  UserEntity userToUserEntity(User user);

  User userEntityToUser(UserEntity userEntity);
}
