package org.saliam.smartbids.user.presentation.rest.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.saliam.smartbids.user.domain.entity.User;
import org.saliam.smartbids.user.presentation.rest.dto.UserCreateDto;
import org.saliam.smartbids.user.presentation.rest.dto.UserDto;

@Mapper(uses = RoleMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper
{
  User userCreateDtoToUser(UserCreateDto user);

  UserDto userToUserDto(User user);
}
