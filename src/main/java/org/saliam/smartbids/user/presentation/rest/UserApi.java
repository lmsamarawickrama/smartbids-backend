package org.saliam.smartbids.user.presentation.rest;

import org.saliam.smartbids.commons.presentation.PageDto;
import org.saliam.smartbids.user.presentation.rest.dto.UserCreateDto;
import org.saliam.smartbids.user.presentation.rest.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserApi
{
  @PostMapping(value = "/user")
  ResponseEntity<UserDto> save(@RequestBody UserCreateDto userCreateDto);

  @GetMapping(value = "/user/{id}")
  ResponseEntity<UserDto> get(@PathVariable(name = "id") Long id);

  @GetMapping(value = "/user")
  ResponseEntity<PageDto<UserDto>> getAll(@RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "100") int size);
}
