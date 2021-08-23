package org.saliam.smartbids.user.domain.port.in;

import org.saliam.smartbids.user.domain.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService
{
  Optional<User> findByUsername(String username);

  User save(User user);

  Optional<User> get(Long id);

  List<User> getAll(int page, int size);

  boolean existsByUsername(String username);

  boolean existsByEmail(String email);


}
