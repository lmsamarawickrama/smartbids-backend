package org.saliam.smartbids.user.presentation.rest.controller;

import org.mapstruct.factory.Mappers;
import org.saliam.smartbids.commons.presentation.PageDto;
import org.saliam.smartbids.user.application.UserApplicationService;
import org.saliam.smartbids.user.domain.entity.User;
import org.saliam.smartbids.user.presentation.rest.UserApi;
import org.saliam.smartbids.user.presentation.rest.dto.UserCreateDto;
import org.saliam.smartbids.user.presentation.rest.dto.UserDto;
import org.saliam.smartbids.user.presentation.rest.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/smartbids/api")
public class UserController implements UserApi
{
  private UserApplicationService userApplicationService;

  @Autowired
  public void setUserService(UserApplicationService userApplicationService)
  {
    this.userApplicationService = userApplicationService;
  }

  @Override
  public ResponseEntity<UserDto> save(UserCreateDto userCreateDto)
  {
    final UserMapper userMapper = Mappers.getMapper(UserMapper.class);
    User user = userMapper.userCreateDtoToUser(userCreateDto);
    UserDto savedUser = userMapper.userToUserDto(userApplicationService.save(user));
    return ResponseEntity.ok(savedUser);
  }

  @Override
  public ResponseEntity<UserDto> get(Long id)
  {
    final Optional<User> userById = userApplicationService.get(id);
    final UserMapper userMapper = Mappers.getMapper(UserMapper.class);
    return userById.map(user -> ResponseEntity.ok(userMapper.userToUserDto(user)))
        .orElse(ResponseEntity.notFound().build());
  }

  @Override
  public ResponseEntity<PageDto<UserDto>> getAll(int page, int size)
  {
    final List<User> users = userApplicationService.getAll(page, size);
    final UserMapper userMapper = Mappers.getMapper(UserMapper.class);
    List<UserDto> userDtoS = users.stream().map(userMapper::userToUserDto).collect(Collectors.toList());
    return ResponseEntity.ok(new PageDto<>(userDtoS, page, userDtoS.size()));
  }
}
