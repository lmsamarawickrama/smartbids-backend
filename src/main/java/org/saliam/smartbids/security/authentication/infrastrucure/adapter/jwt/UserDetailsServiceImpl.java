package org.saliam.smartbids.security.authentication.infrastrucure.adapter.jwt;

import org.saliam.smartbids.security.authentication.domain.model.UserDetailsImpl;
import org.saliam.smartbids.user.domain.entity.User;
import org.saliam.smartbids.user.domain.port.in.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService
{

  private final UserService userService;

  public UserDetailsServiceImpl(UserService userService)
  {
    this.userService = userService;
  }

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
  {
    User user = userService.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

    return UserDetailsImpl.build(user);
  }

}
